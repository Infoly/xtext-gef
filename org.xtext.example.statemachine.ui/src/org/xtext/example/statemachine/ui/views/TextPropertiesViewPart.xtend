/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.views

import com.google.inject.Inject
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess
import org.xtext.example.statemachine.StatemachineUtil
import org.xtext.example.statemachine.ui.internal.StatemachineActivator

class TextPropertiesViewPart extends ViewPart {

	val resourceProvider =  new EditedResourceProvider()
	
	@Inject EmbeddedEditorFactory editorFactory
	
	@Inject ISerializer serializer
	
	XtextSourceViewer viewer
	EmbeddedEditorModelAccess modelAccess
	
	EObject currentViewedObject
	TransactionalEditingDomain editingDomain
	String initialContent
	boolean refreshing
	boolean mergingBack
	Thread clearStatusThread
	
	new() {
		super()
		val injector = StatemachineActivator.instance.getInjector('org.xtext.example.statemachine.Statemachine')
		injector.injectMembers(this)
		resourceProvider.addStateChangeListener[object, notification, editingDomain |
			refresh(object, notification)
			this.editingDomain = editingDomain
		]
	}
	
	override createPartControl(Composite parent) {
		val editor = editorFactory.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withParent(parent)
		modelAccess = editor.createPartialEditor()
		editor.document.addModelListener[documentChanged]
		viewer = editor.viewer
		refresh(resourceProvider.selectedObject, null)
		editingDomain = resourceProvider.editingDomain
	}
	
	override dispose() {
		resourceProvider.dispose
		super.dispose()
	}
	
	protected def refresh(EObject object, Notification notification) {
		if (mergingBack) {
			return
		}
		refreshing = true
		try {
			if (object === currentViewedObject && notification !== null) {
				val mergeResult = resourceProvider.mergeForward(object, notification)
				if (mergeResult !== null) {
					val uriFragment = mergeResult.eResource.getURIFragment(mergeResult)
					modelAccess.updateModel(serializer.serialize(mergeResult.eContainer), uriFragment)
					initialContent = modelAccess.editablePart
					return
				}
			}
			
			if (currentViewedObject !== null) {
				val content = modelAccess.editablePart
				if (content != initialContent) {
					var EObject mergeSource
					if (object !== currentViewedObject && resourceProvider.resource.parseResult.syntaxErrors.empty) {
						mergeSource = resourceProvider.mergeBack(currentViewedObject, editingDomain)
					}
					if (mergeSource === null)
						handleDiscardedChanges()
				}
			}
			
			if (object === null) {
				modelAccess.updateModel('')
			} else {
				val stateCopy = createSerializableCopy(object)
				val uriFragment = stateCopy.eResource.getURIFragment(stateCopy)
				modelAccess.updateModel(serializer.serialize(stateCopy.eContainer), uriFragment)
				viewer.setSelectedRange(0, 0)
				initialContent = modelAccess.editablePart
			}
			currentViewedObject = object
		} finally {
			refreshing = false
		}
	}
	
	protected def createSerializableCopy(EObject object) {
		if (object.eContainer === null)
			throw new IllegalStateException
		val copier = new Copier
		val modelCopy = copier.copy(object.eContainer)
		copier.copyReferences()
		val dummyResource = new XtextResource
		dummyResource.contents += modelCopy
		StatemachineUtil.ensureUniqueIds(dummyResource)
		return copier.get(object)
	}
	
	protected def documentChanged(XtextResource resource) {
		if (!refreshing && currentViewedObject !== null && resource.parseResult.syntaxErrors.empty) {
			mergingBack = true
			try {
				resourceProvider.mergeBack(currentViewedObject, editingDomain)
			} finally {
				mergingBack = false
			}
		}
	}
	
	protected def handleDiscardedChanges() {
		if (clearStatusThread !== null && clearStatusThread.alive)
			clearStatusThread.interrupt()
		val display = viewSite.shell.display
		val actionBars = #[viewSite.actionBars, resourceProvider.editorPart.editorSite.actionBars]
		display.asyncExec[
			actionBars.forEach[
				statusLineManager.errorMessage = 'Warning: The previous text changes have been discarded due to syntax errors.'
			]
		]
		clearStatusThread = new Thread[
			try {
				Thread.sleep(5000)
				display.syncExec[
					actionBars.forEach[
						statusLineManager.errorMessage = null
					]
				]
			} catch (InterruptedException exception) {}
		]
		clearStatusThread.start
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}
