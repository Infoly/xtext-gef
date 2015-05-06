/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.merging

import com.google.inject.ImplementedBy
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject

@ImplementedBy(ExplicitModelMerger)
interface IModelMerger {
	
	def void merge(EObject source, EObject destination)
	
	def void apply(Notification notification, EObject destination)
	
}