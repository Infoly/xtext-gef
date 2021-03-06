/**
 */
package org.xtext.example.statemachine.statemachine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.PrintCommand#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getPrintCommand()
 * @model
 * @generated
 */
public interface PrintCommand extends Command
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getPrintCommand_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.PrintCommand#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

} // PrintCommand
