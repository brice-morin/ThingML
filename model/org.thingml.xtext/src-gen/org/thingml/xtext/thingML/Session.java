/**
 * generated by Xtext 2.10.0
 */
package org.thingml.xtext.thingML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.thingml.xtext.thingML.Session#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.thingml.xtext.thingML.Session#getSubstate <em>Substate</em>}</li>
 *   <li>{@link org.thingml.xtext.thingML.Session#getRegion <em>Region</em>}</li>
 * </ul>
 *
 * @see org.thingml.xtext.thingML.ThingMLPackage#getSession()
 * @model
 * @generated
 */
public interface Session extends Region, State
{
  /**
   * Returns the value of the '<em><b>Initial</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial</em>' reference.
   * @see #setInitial(State)
   * @see org.thingml.xtext.thingML.ThingMLPackage#getSession_Initial()
   * @model
   * @generated
   */
  State getInitial();

  /**
   * Sets the value of the '{@link org.thingml.xtext.thingML.Session#getInitial <em>Initial</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial</em>' reference.
   * @see #getInitial()
   * @generated
   */
  void setInitial(State value);

  /**
   * Returns the value of the '<em><b>Substate</b></em>' containment reference list.
   * The list contents are of type {@link org.thingml.xtext.thingML.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Substate</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Substate</em>' containment reference list.
   * @see org.thingml.xtext.thingML.ThingMLPackage#getSession_Substate()
   * @model containment="true"
   * @generated
   */
  EList<State> getSubstate();

  /**
   * Returns the value of the '<em><b>Region</b></em>' containment reference list.
   * The list contents are of type {@link org.thingml.xtext.thingML.ParallelRegion}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Region</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Region</em>' containment reference list.
   * @see org.thingml.xtext.thingML.ThingMLPackage#getSession_Region()
   * @model containment="true"
   * @generated
   */
  EList<ParallelRegion> getRegion();

} // Session
