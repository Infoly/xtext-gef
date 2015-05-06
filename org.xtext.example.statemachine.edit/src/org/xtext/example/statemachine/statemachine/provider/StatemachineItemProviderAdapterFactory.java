/**
 */
package org.xtext.example.statemachine.statemachine.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.xtext.example.statemachine.statemachine.util.StatemachineAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatemachineItemProviderAdapterFactory extends StatemachineAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatemachineItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.Statemachine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatemachineItemProvider statemachineItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.Statemachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatemachineAdapter() {
		if (statemachineItemProvider == null) {
			statemachineItemProvider = new StatemachineItemProvider(this);
		}

		return statemachineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.State} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateItemProvider stateItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateAdapter() {
		if (stateItemProvider == null) {
			stateItemProvider = new StateItemProvider(this);
		}

		return stateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.Transition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionItemProvider transitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this);
		}

		return transitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.Command} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandItemProvider commandItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.Command}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCommandAdapter() {
		if (commandItemProvider == null) {
			commandItemProvider = new CommandItemProvider(this);
		}

		return commandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.SetCommand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetCommandItemProvider setCommandItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.SetCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSetCommandAdapter() {
		if (setCommandItemProvider == null) {
			setCommandItemProvider = new SetCommandItemProvider(this);
		}

		return setCommandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.ExecuteCommand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecuteCommandItemProvider executeCommandItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.ExecuteCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecuteCommandAdapter() {
		if (executeCommandItemProvider == null) {
			executeCommandItemProvider = new ExecuteCommandItemProvider(this);
		}

		return executeCommandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.PrintCommand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrintCommandItemProvider printCommandItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.PrintCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrintCommandAdapter() {
		if (printCommandItemProvider == null) {
			printCommandItemProvider = new PrintCommandItemProvider(this);
		}

		return printCommandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.Expression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionItemProvider expressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this);
		}

		return expressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.VerbatimExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerbatimExpressionItemProvider verbatimExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.VerbatimExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVerbatimExpressionAdapter() {
		if (verbatimExpressionItemProvider == null) {
			verbatimExpressionItemProvider = new VerbatimExpressionItemProvider(this);
		}

		return verbatimExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xtext.example.statemachine.statemachine.StatePropertyExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatePropertyExpressionItemProvider statePropertyExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.xtext.example.statemachine.statemachine.StatePropertyExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatePropertyExpressionAdapter() {
		if (statePropertyExpressionItemProvider == null) {
			statePropertyExpressionItemProvider = new StatePropertyExpressionItemProvider(this);
		}

		return statePropertyExpressionItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (statemachineItemProvider != null) statemachineItemProvider.dispose();
		if (stateItemProvider != null) stateItemProvider.dispose();
		if (transitionItemProvider != null) transitionItemProvider.dispose();
		if (commandItemProvider != null) commandItemProvider.dispose();
		if (setCommandItemProvider != null) setCommandItemProvider.dispose();
		if (executeCommandItemProvider != null) executeCommandItemProvider.dispose();
		if (printCommandItemProvider != null) printCommandItemProvider.dispose();
		if (expressionItemProvider != null) expressionItemProvider.dispose();
		if (verbatimExpressionItemProvider != null) verbatimExpressionItemProvider.dispose();
		if (statePropertyExpressionItemProvider != null) statePropertyExpressionItemProvider.dispose();
	}

}
