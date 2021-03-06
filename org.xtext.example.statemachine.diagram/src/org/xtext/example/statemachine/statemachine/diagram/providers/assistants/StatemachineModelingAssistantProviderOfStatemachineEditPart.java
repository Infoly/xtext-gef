package org.xtext.example.statemachine.statemachine.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.xtext.example.statemachine.statemachine.diagram.providers.StatemachineElementTypes;
import org.xtext.example.statemachine.statemachine.diagram.providers.StatemachineModelingAssistantProvider;

/**
 * @generated
 */
public class StatemachineModelingAssistantProviderOfStatemachineEditPart extends
		StatemachineModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(StatemachineElementTypes.State_2001);
		return types;
	}

}
