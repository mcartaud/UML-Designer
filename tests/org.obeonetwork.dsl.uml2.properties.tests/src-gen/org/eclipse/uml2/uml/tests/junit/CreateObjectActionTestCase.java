/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.uml2.uml.tests.junit;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;
import org.obeonetwork.dsl.uml2.properties.uml.providers.UmlMessages;
/**
 * TestCase for CreateObjectAction
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class CreateObjectActionTestCase extends SWTBotEEFTestCase {

	/**
	 * The EClass of the type to edit
	 */
	private EClass createObjectActionMetaClass = UMLPackage.eINSTANCE.getCreateObjectAction();

	/**
	 * The type to edit
	 */
	private EObject createObjectAction;

	/**
	 * The enum value for the enum class visibility
	 */
	private Object enumValueForVisibility;
	/**
	 * The reference value for the reference class activity
	 */
	private Object referenceValueForActivity;

	/**
	 * The reference value for the reference class inPartition
	 */
	private Object referenceValueForInPartition;

	/**
	 * The reference value for the reference class inStructuredNode
	 */
	private Object referenceValueForInStructuredNode;

	/**
	 * The reference value for the reference class incoming
	 */
	private Object referenceValueForIncoming;

	/**
	 * The reference value for the reference class outgoing
	 */
	private Object referenceValueForOutgoing;

	/**
	 * The reference value for the reference class inInterruptibleRegion
	 */
	private Object referenceValueForInInterruptibleRegion;

	/**
	 * The reference value for the reference class redefinedNode
	 */
	private Object referenceValueForRedefinedNode;

	/**
	 * The reference value for the reference class clientDependency
	 */
	private Object referenceValueForClientDependency;

	/**
	 * The reference value for the reference class classifier
	 */
	private Object referenceValueForClassifier;
	/**
	 * The EClass of the reference to edit
	 */
	private EClass interruptibleActivityRegionMetaClass = UMLPackage.eINSTANCE.getInterruptibleActivityRegion();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass structuredActivityNodeMetaClass = UMLPackage.eINSTANCE.getStructuredActivityNode();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityMetaClass = UMLPackage.eINSTANCE.getActivity();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityNodeMetaClass = UMLPackage.eINSTANCE.getActivityNode();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass classifierMetaClass = UMLPackage.eINSTANCE.getClassifier();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityPartitionMetaClass = UMLPackage.eINSTANCE.getActivityPartition();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityEdgeMetaClass = UMLPackage.eINSTANCE.getActivityEdge();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass dependencyMetaClass = UMLPackage.eINSTANCE.getDependency();
	/**
	 * The eObjects list contained in widgets
	 */
	private List allInstancesOf;
	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelFolder()
	 */
	protected String getInputModelFolder() {
		return "input";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelName()
	 */
	protected String getInputModelName() {
		return "input.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.obeonetwork.dsl.uml2.properties.tests";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelFolder()
	 */
	protected String getExpectedModelFolder() {
		// The project that contains models for tests
		return "expected";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getImportModelsFolder()
	 */
	protected String getImportModelsFolder() {
		return  "models";
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionName() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getNamedElement_Name(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionName() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionName();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the name feature of the CreateObjectAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.name, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionVisibility() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getNamedElement_Visibility(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionVisibility() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		enumValueForVisibility = bot.changeEnumLiteralValue(UMLPackage.eINSTANCE.getVisibilityKind(), ((CreateObjectAction)createObjectAction).getVisibility().getLiteral());
		// Create the expected model
		initializeExpectedModelForCreateObjectActionVisibility();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the visibility feature of the CreateObjectAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.visibility, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionClientDependency() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, dependencyMetaClass);
		referenceValueForClientDependency = bot.changeReferenceValue(allInstancesOf, ((CreateObjectAction)createObjectAction).getClientDependency());
		cc.append(AddCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), referenceValueForClientDependency));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionClientDependency() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionClientDependency();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the clientDependency feature of the CreateObjectAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.clientDependency, referenceValueForClientDependency);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateObjectActionClientDependency() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createObjectAction.eGet(UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateObjectActionClientDependency() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateObjectActionClientDependency();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the clientDependency feature of the CreateObjectAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.clientDependency, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionIsLeaf() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionIsLeaf() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionIsLeaf();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the isLeaf feature of the CreateObjectAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.isLeaf, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionInStructuredNode() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, structuredActivityNodeMetaClass);
		referenceValueForInStructuredNode = bot.changeReferenceValue(allInstancesOf, ((CreateObjectAction)createObjectAction).getInStructuredNode());
		cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InStructuredNode(), referenceValueForInStructuredNode));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionInStructuredNode() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionInStructuredNode();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inStructuredNode feature of the CreateObjectAction element 
		bot.editEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inStructuredNode, allInstancesOf.indexOf(referenceValueForInStructuredNode)+1);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateObjectActionInStructuredNode() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, structuredActivityNodeMetaClass);
		cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InStructuredNode(), null));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateObjectActionInStructuredNode() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateObjectActionInStructuredNode();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inStructuredNode feature of the CreateObjectAction element
		bot.removeEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inStructuredNode);
		

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionActivity() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityMetaClass);
		referenceValueForActivity = bot.changeReferenceValue(allInstancesOf, ((CreateObjectAction)createObjectAction).getActivity());
		cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_Activity(), referenceValueForActivity));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionActivity() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionActivity();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the activity feature of the CreateObjectAction element 
		bot.editEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.activity, allInstancesOf.indexOf(referenceValueForActivity)+1);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateObjectActionActivity() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityMetaClass);
		cc.append(SetCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_Activity(), null));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateObjectActionActivity() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateObjectActionActivity();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the activity feature of the CreateObjectAction element
		bot.removeEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.activity);
		

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionInPartition() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityPartitionMetaClass);
		referenceValueForInPartition = bot.changeReferenceValue(allInstancesOf, ((CreateObjectAction)createObjectAction).getInPartition());
		cc.append(AddCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), referenceValueForInPartition));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionInPartition() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionInPartition();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inPartition feature of the CreateObjectAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inPartition, referenceValueForInPartition);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateObjectActionInPartition() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createObjectAction.eGet(UMLPackage.eINSTANCE.getActivityNode_InPartition());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateObjectActionInPartition() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateObjectActionInPartition();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inPartition feature of the CreateObjectAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inPartition, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateObjectActionInInterruptibleRegion() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, interruptibleActivityRegionMetaClass);
		referenceValueForInInterruptibleRegion = bot.changeReferenceValue(allInstancesOf, ((CreateObjectAction)createObjectAction).getInInterruptibleRegion());
		cc.append(AddCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), referenceValueForInInterruptibleRegion));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateObjectActionInInterruptibleRegion() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateObjectActionInInterruptibleRegion();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inInterruptibleRegion feature of the CreateObjectAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inInterruptibleRegion, referenceValueForInInterruptibleRegion);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateObjectActionInInterruptibleRegion() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createObjectAction.eGet(UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createObjectAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateObjectActionInInterruptibleRegion() throws Exception {

		// Import the input model
		initializeInputModel();

		createObjectAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (createObjectAction == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateObjectActionInInterruptibleRegion();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateObjectAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createObjectActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createObjectActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createObjectActionMetaClass, firstInstanceOf, null);

		// Change value of the inInterruptibleRegion feature of the CreateObjectAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateObjectAction.Properties.inInterruptibleRegion, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}


















}
