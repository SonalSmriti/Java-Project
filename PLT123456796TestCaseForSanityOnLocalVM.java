package com.successfactors.saf.tests.systemUltra.regression.mdf.mdfcore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.successfactors.saf.library.common.actions.CommonAppLogin;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GOBean;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GODefinitionAssociationsBean.AssociationType;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GODefinitionAssociationsBean.Multiplicity;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GODefinitionBean;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GODefinitionBean.EffectiveDatingEnum;
import com.successfactors.saf.library.system.testbeans.mdffields.gofields.GODefinitionFieldBean.VisibilityEnum;
import com.successfactors.saf.library.system.utils.SystemUltraUITest_MDF;

/**
 * Case Name:<br>
 * Test Case for Sanity on local VM<br>
 * Summary:<br>
 * <br>
 * Scenarios :<br>
 * <br>
 * 1. Object with fields defined with all dataType<br>
 * 2. Composite 1:1 and 1:M Association<br>
 * 3. ValidWhen 1:M Association<br>
 * 4. Object instance Creation<br>
 * 5. Config UI Screen Creation<br>
 */


public class PLT123456796TestCaseForSanityOnLocalVM extends SystemUltraUITest_MDF {
	private GODefinitionBean allDataTypeGO;
	private GODefinitionBean quickCardGO;
	private GODefinitionBean compChildObjectOneToOne;
	private GODefinitionBean compChildObjectOnetoMany;
	private GODefinitionBean validWhenObjectOnetoMany;
	private GOBean compChildObjectOneToOne_Instance;
	private GOBean compChildObjectOneToMany_Instance1;
	private GOBean compChildObjectOneToMany_Instance2;
	private GOBean allDataTypeGOInstance;
	private GOBean allDataTypeGO_PastDatedRecord;
	private GOBean allDataTypeGO_FutureDatedRecord;
	private GOBean allDataTypeGO_FutureDatedRecord_Updated;
	private GOBean allDataTypeGOInstance_CreatedThroughRuntimePage;
	private GOBean allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage;
	private GOBean allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage;
	private GOBean allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated;
	private GOBean quickCardGOInstance1;
	private GOBean validWhenObjectOnetoManyInstance1;
	private GOBean validWhenObjectOnetoManyInstance2;
	private String quickCardGOInstanceEffectiveStartDate = "10/24/2015";
	private String validWhenObjectOnetoManyInstanceEffectiveStartDate = "10/24/2015";
	private String effectiveStartDateForPastDatedRecord = "01/10/2013";
	private String effectiveStartDateForfutureDatedRecord = "05/15/2050";
	private String externalNameField_NewValue;
	private String numberField_NewValue = "125";


	@BeforeClass(alwaysRun = true)
	public void beforeClassMethod1() throws Exception {
		systemInitDriverFlags.setEnableFO(true);
		super.init(ANY_BROWSER);
		/**
		 * Preconditions:<br>
		 * <br>
		 * Picklist Creation :<br>
		 * <br>
		 * 1. Login to the Application -> Admin Tools<br>
		 * 2. Go to Configure Object Definition Page -> Click on Create new<br>
		 * 3. Select Picklist -> Create a picklist(Picklist1) with few fields
		 * <br>
		 * 4. Save<br>
		 */
		CommonAppLogin.superAdminLogin();

		// Creating Picklist
		picklistBean1.addPicklistField(picklistFieldBean1);
		mdfActions.configureGODefinition.createNewPicklistIfNotPresent(picklistBean1);
	}

	@Test(groups = { "PLT123456796", "Modules.systemUltra", "Modules.systemUltra.mdf", "Priorities.P2", "all",
			"TestType.Regression", "systemv12", "TestType.PostDeployment", "DBType.Oracle", "DBType.HANA",
			"standalone" })
	public void testCase1() throws Exception {
		// Creating object definitions
		/**
		 * Composite Object Creation:<br>
		 * <br>
		 * 1. Login to the Application -> Admin Tools<br>
		 * 2. Go to Configure Object Definition Page -> Create 2 new object
		 * definition (ChildObject1 and ChildObject2 with effectiveDate = FROM
		 * PARENT)<br>
		 * 3. Save<br>
		 */

		compChildObjectOneToOne = goDefinitionBean2;
		compChildObjectOneToOne.setEffectiveDatingEnum(EffectiveDatingEnum.FromParent);

		compChildObjectOnetoMany = goDefinitionBean3;
		compChildObjectOnetoMany.setEffectiveDatingEnum(EffectiveDatingEnum.FromParent);

		mdfDPExecutor.add(mdfDPActions.goDef_CreateIfNotExist.GOD1, compChildObjectOneToOne);
		mdfDPExecutor.add(mdfDPActions.goDef_CreateIfNotExist.GOD2, compChildObjectOnetoMany);

		/**
		 * ValidWhen Object Creation:<br>
		 * <br>
		 * 1. Login to the Application -> Admin Tools<br>
		 * 2. Go to Configure Object Definition Page -> Create new object
		 * definition (ValidWhenObject with effectiveDate = BASIC)<br>
		 * 3. Save<br>
		 */

		validWhenObjectOnetoMany = goDefinitionBean4;
		validWhenObjectOnetoMany.setEffectiveDatingEnum(EffectiveDatingEnum.Basic);

		mdfDPExecutor.add(mdfDPActions.goDef_CreateIfNotExist.GOD3, validWhenObjectOnetoMany);

		/**
		 * STEP 1 <br>
		 * 1. Login to the Application -> Admin Tools<br>
		 * 2. Go to Configure Object Definition Page -> Create 2 new object
		 * definition (AllDataTypeGO with effectiveDate = MCPD and QuickCardGO
		 * with effectiveDate = BASIC)<br>
		 * 3. For Object AllDataTypeGO change the externalCode DataType = User
		 * <br>
		 * 4. For Object AllDataTypeGO define the following fields :<br>
		 * <br>
		 * <br>
		 * F1 with dataType = Number<br>
		 * <br>
		 * F2 with dataType = AutoNumber<br>
		 * <br>
		 * F3 with dataType = Decimal<br>
		 * <br>
		 * F4 with dataType = Translatable<br>
		 * <br>
		 * F5 with dataType = Boolean<br>
		 * <br>
		 * F6 with dataType = DateTime<br>
		 * <br>
		 * F7 with dataType = Attachment<br>
		 * <br>
		 * F8 with dataType = Picklist (validValue = Picklist1 [created in
		 * precondition] )<br>
		 * <br>
		 * F9 with dataType = GO (ValidValue = QuickCardGO)<br>
		 * <br>
		 * F10 with dataType = FO (ValidValue = location )<br>
		 * <br>
		 * F11 with dataType = CLOB<br>
		 * <br>
		 * <br>
		 * 5. Save the object -> Make Correction<br>
		 * 6. Set the mdfSystemStatus field&#39;s visibility = Editable<br>
		 * 7. Associate ChildObject1 to AllDataTypeGO as composite 1:1<br>
		 * 8. Associate ChildObject2 to AllDataTypeGO as composite 1:M<br>
		 * 9. Associate ValidWhenObject to AllDataTypeGO as ValidWhen 1:M<br>
		 * 10. Save<br>
		 * <br>
		 * User should be able to save the object definition without any issue
		 * <br>
		 */

		quickCardGO = goDefinitionBean5;
		quickCardGO.setEffectiveDatingEnum(EffectiveDatingEnum.Basic);

		mdfDPExecutor.add(mdfDPActions.goDef_CreateIfNotExist.GOD4, quickCardGO);

		createAllDataTypeGOObjectDefinition();
		configUIBean2.setConfigUIBaseObject(allDataTypeGO);
		mdfDPExecutor.runAll();

		// testCase2
		createInstanceOfAllDatatypeGoThroughManageDataPage();

		createPastAndFutureDatedRecordsThroughManageDataPage();

		editFutureDatedRecordThroughManageDataPage();

		// testCase3
		// Creating ConfigUI
		mdfActions.configUIAction.createNew(configUIBean2);

		createInstanceOfAllDataTypeGOThroughRuntimePage();

		createPastAndFutureDatedRecordsThroughRuntimePage();

		editFutureDatedRecordThroughRuntimePage();
//		String strBatchLoc = "SendMailToStartModuleSanity";
//		RunBatch(strBatchLoc);

	}

	private void editFutureDatedRecordThroughManageDataPage() throws Exception, CloneNotSupportedException {
		/**
		 * STEP 4 <br>
		 * 16. For the future dated record -> click on Make correction<br>
		 * 17. change the value of externalName, F1, F5 field -> Save<br>
		 * <br>
		 * User should be able to save the object successfully.<br>
		 */

		externalNameField_NewValue = allDataTypeGOInstance.getFieldValue("externalName") + "_UpdatedValue";

		allDataTypeGO_FutureDatedRecord_Updated = generateGO(allDataTypeGO);
		allDataTypeGO_FutureDatedRecord_Updated.setFieldValue("externalCode",
				allDataTypeGOInstance.getExternalCodeFieldValue());
		allDataTypeGO_FutureDatedRecord_Updated.setFieldValue("externalName", externalNameField_NewValue);
		allDataTypeGO_FutureDatedRecord_Updated.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(),
				numberField_NewValue);
		allDataTypeGO_FutureDatedRecord_Updated.setOriginalBean(allDataTypeGO_FutureDatedRecord);
		mdfActions.manageGO.setIsNeedToNavigate(true);
		mdfActions.manageGO.editGO(allDataTypeGO_FutureDatedRecord_Updated);
		allDataTypeGO_FutureDatedRecord_Updated = allDataTypeGO_FutureDatedRecord.clone();
		allDataTypeGO_FutureDatedRecord_Updated.setOriginalBean(allDataTypeGO_FutureDatedRecord);
		allDataTypeGO_FutureDatedRecord_Updated.setFieldValue("externalName", externalNameField_NewValue);
		allDataTypeGO_FutureDatedRecord_Updated.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(),
				numberField_NewValue);
		allDataTypeGO_FutureDatedRecord.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(),
				numberField_NewValue);
		mdfActions.manageGO.setIsNeedToNavigate(false);
		mdfActions.manageGO.validate(allDataTypeGO_FutureDatedRecord_Updated);

		mdfDbUtil.deleteAllGOHistoryEntries(allDataTypeGOInstance);
	}

	private void createPastAndFutureDatedRecordsThroughManageDataPage() throws Exception, CloneNotSupportedException {
		/**
		 * STEP 3 <br>
		 * 13. Click on Insert New Record for the same object -> Select a past
		 * date -> Proceed<br>
		 * 14. Save<br>
		 * 15. Repeat step 13 with future date<br>
		 * <br>
		 * 1. User should be able to save the new inserted record for both past
		 * and future date<br>
		 */

		allDataTypeGO_PastDatedRecord = generateGO(allDataTypeGO);
		allDataTypeGO_PastDatedRecord.setFieldValue("externalCode", allDataTypeGOInstance.getExternalCodeFieldValue());
		allDataTypeGO_PastDatedRecord.setOriginalBean(allDataTypeGOInstance);
		allDataTypeGO_PastDatedRecord.setEffectiveStartDate(effectiveStartDateForPastDatedRecord);

		mdfActions.manageGO.insertNewRecordForGO(allDataTypeGO_PastDatedRecord);
		mdfActions.manageGO.setIsNeedToNavigate(false);
		mdfActions.manageGO.validate(allDataTypeGO_PastDatedRecord);

		allDataTypeGO_FutureDatedRecord = generateGO(allDataTypeGO);
		allDataTypeGO_FutureDatedRecord.setFieldValue("externalCode",
				allDataTypeGOInstance.getExternalCodeFieldValue());
		allDataTypeGO_FutureDatedRecord.setOriginalBean(allDataTypeGOInstance);
		allDataTypeGO_FutureDatedRecord.setEffectiveStartDate(effectiveStartDateForfutureDatedRecord);

		mdfActions.manageGO.insertNewRecordForGO(allDataTypeGO_FutureDatedRecord);
		allDataTypeGO_FutureDatedRecord = allDataTypeGOInstance.clone();
		allDataTypeGO_FutureDatedRecord.setOriginalBean(allDataTypeGOInstance);
		allDataTypeGO_FutureDatedRecord.setEffectiveStartDate(effectiveStartDateForfutureDatedRecord);
		mdfActions.manageGO.validate(allDataTypeGO_FutureDatedRecord);
	}

	private void createInstanceOfAllDatatypeGoThroughManageDataPage() throws Exception {
		/**
		 * STEP 2 <br>
		 * 11. Go to Manage Data Page -> Create New object instance for
		 * AllDataType<br>
		 * 12. Save<br>
		 * <br>
		 * User should be able to save the object instance successfully<br>
		 */

		CommonAppLogin.superAdminLogin();
		quickCardGOInstance1 = generateGOWithValue(quickCardGO);
		quickCardGOInstance1.setEffectiveStartDate(quickCardGOInstanceEffectiveStartDate);
		mdfDPExecutor.add(mdfDPActions.go_CreateIfNotExist.GO1, quickCardGOInstance1);

		validWhenObjectOnetoManyInstance1 = generateGOWithValue(validWhenObjectOnetoMany);
		validWhenObjectOnetoManyInstance1.setEffectiveStartDate(validWhenObjectOnetoManyInstanceEffectiveStartDate);
		mdfDPExecutor.add(mdfDPActions.go_CreateIfNotExist.GO2, validWhenObjectOnetoManyInstance1);

		validWhenObjectOnetoManyInstance2 = generateGOWithValue(validWhenObjectOnetoMany);
		validWhenObjectOnetoManyInstance2.setEffectiveStartDate(validWhenObjectOnetoManyInstanceEffectiveStartDate);
		mdfDPExecutor.add(mdfDPActions.go_CreateIfNotExist.GO3, validWhenObjectOnetoManyInstance2);

		compChildObjectOneToOne_Instance = generateGOWithValue(compChildObjectOneToOne);
		compChildObjectOneToMany_Instance1 = generateGOWithValue(compChildObjectOnetoMany);
		compChildObjectOneToMany_Instance2 = generateGOWithValue(compChildObjectOnetoMany);

		List<GOBean> compOneToOneAssociationGOList = new ArrayList<GOBean>();
		compOneToOneAssociationGOList.add(compChildObjectOneToOne_Instance);

		List<GOBean> compOneToManyAssociationGOsList = new ArrayList<GOBean>();
		compOneToManyAssociationGOsList.add(compChildObjectOneToMany_Instance1);
		compOneToManyAssociationGOsList.add(compChildObjectOneToMany_Instance2);

		List<GOBean> validWhenAssociationGOsList = new ArrayList<GOBean>();
		validWhenAssociationGOsList.add(validWhenObjectOnetoManyInstance1);
		validWhenAssociationGOsList.add(validWhenObjectOnetoManyInstance2);

		allDataTypeGO.removeField(goDefinitionBooleanFieldBean1);
		allDataTypeGO.removeField(goDefinitionDateTimeFieldBean1);
		allDataTypeGO.removeField(goDefinitionClobFieldBean1);
		allDataTypeGO.removeField(goDefinitionAttachmentFieldBean1);

		allDataTypeGOInstance = generateGOWithValue(allDataTypeGO);

		allDataTypeGOInstance.setFieldValue(goDefinitionPicklistFieldBean1.getExternalCode(), picklistFieldBean1);
		allDataTypeGOInstance.setFieldValue(goDefinitionGOFieldBean1.getExternalCode(), quickCardGOInstance1);
		// allDataTypeGOInstance.setFieldValue(goDefinitionFOFieldBean1.getExternalCode(),
		// "loc1");

		allDataTypeGOInstance.addAssociationGO(goDefAssociationBean1, compOneToOneAssociationGOList);
		allDataTypeGOInstance.addAssociationGO(goDefAssociationBean2, compOneToManyAssociationGOsList);
		allDataTypeGOInstance.addAssociationGO(goDefAssociationBean3, validWhenAssociationGOsList);

		// mdfActions.manageGO.createNew(allDataTypeGOInstance);
		mdfDPExecutor.add(mdfDPActions.go_CreateNew.GO4, allDataTypeGOInstance);
		mdfDPExecutor.runAll();
		mdfActions.manageGO.validate(allDataTypeGOInstance);
	}

	private void editFutureDatedRecordThroughRuntimePage() throws Exception {
		externalNameField_NewValue = allDataTypeGOInstance_CreatedThroughRuntimePage.getFieldValue("externalName")
				+ "_UpdatedValue";
		numberField_NewValue = "123";
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated = generateGO(allDataTypeGO);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated.setFieldValue("externalCode",
				allDataTypeGOInstance_CreatedThroughRuntimePage.getExternalCodeFieldValue());
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated.setFieldValue("externalName",
				externalNameField_NewValue);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated
				.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(), numberField_NewValue);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated
				.setOriginalBean(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage);
		mdfActions.manageGOWithConfigUI.setIsNeedToNavigate(true);
		mdfActions.manageGOWithConfigUI.editGO(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated = allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.clone();
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated.setFieldValue("externalName",
				externalNameField_NewValue);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated
				.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(), numberField_NewValue);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.setFieldValue(goDefinitionNumberFieldBean1.getExternalCode(), numberField_NewValue);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated
				.setOriginalBean(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage);
		mdfActions.manageGOWithConfigUI.setIsNeedToNavigate(false);
		mdfActions.manageGOWithConfigUI.validateGO(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage_Updated);
	}

	private void createPastAndFutureDatedRecordsThroughRuntimePage() throws CloneNotSupportedException, Exception {
		allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage = generateGO(allDataTypeGO);
		allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage.setFieldValue("externalCode",
				allDataTypeGOInstance_CreatedThroughRuntimePage.getExternalCodeFieldValue());
		allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage
				.setOriginalBean(allDataTypeGOInstance_CreatedThroughRuntimePage);
		allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage
				.setEffectiveStartDate(effectiveStartDateForPastDatedRecord);

		mdfActions.manageGOWithConfigUI.insertNewRecordForGO(allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage);
		mdfActions.manageGOWithConfigUI.validateGO(allDataTypeGO_PastDatedRecord_CreatedThroughRuntimePage);

		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage = generateGO(allDataTypeGO);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage.setFieldValue("externalCode",
				allDataTypeGOInstance_CreatedThroughRuntimePage.getExternalCodeFieldValue());
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.setOriginalBean(allDataTypeGOInstance_CreatedThroughRuntimePage);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.setEffectiveStartDate(effectiveStartDateForfutureDatedRecord);

		mdfActions.manageGOWithConfigUI.insertNewRecordForGO(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage = allDataTypeGOInstance_CreatedThroughRuntimePage
				.clone();
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.setOriginalBean(allDataTypeGOInstance_CreatedThroughRuntimePage);
		allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage
				.setEffectiveStartDate(effectiveStartDateForfutureDatedRecord);
		mdfActions.manageGOWithConfigUI.validateGO(allDataTypeGO_FutureDatedRecord_CreatedThroughRuntimePage);
	}

	private void createInstanceOfAllDataTypeGOThroughRuntimePage() throws Exception {
		allDataTypeGOInstance_CreatedThroughRuntimePage = generateGOWithValue(allDataTypeGO);
		allDataTypeGOInstance_CreatedThroughRuntimePage.setFieldValue(goDefinitionPicklistFieldBean1.getExternalCode(),
				picklistFieldBean1);
		allDataTypeGOInstance_CreatedThroughRuntimePage.setFieldValue(goDefinitionGOFieldBean1.getExternalCode(),
				quickCardGOInstance1);
		// allDataTypeGOInstance_CreatedThroughRuntimePage.setFieldValue(goDefinitionFOFieldBean1.getExternalCode(),
		// "loc1");

		List<GOBean> compOneToOneAssociationGOList = new ArrayList<GOBean>();
		compOneToOneAssociationGOList.add(compChildObjectOneToOne_Instance);

		List<GOBean> compOneToManyAssociationGOsList = new ArrayList<GOBean>();
		compOneToManyAssociationGOsList.add(compChildObjectOneToMany_Instance1);
		compOneToManyAssociationGOsList.add(compChildObjectOneToMany_Instance2);

		List<GOBean> validWhenAssociationGOsList = new ArrayList<GOBean>();
		validWhenAssociationGOsList.add(validWhenObjectOnetoManyInstance1);
		validWhenAssociationGOsList.add(validWhenObjectOnetoManyInstance2);

		allDataTypeGOInstance_CreatedThroughRuntimePage.addAssociationGO(goDefAssociationBean1,
				compOneToOneAssociationGOList);
		allDataTypeGOInstance_CreatedThroughRuntimePage.addAssociationGO(goDefAssociationBean2,
				compOneToManyAssociationGOsList);
		allDataTypeGOInstance_CreatedThroughRuntimePage.addAssociationGO(goDefAssociationBean3,
				validWhenAssociationGOsList);
		allDataTypeGOInstance_CreatedThroughRuntimePage.setConfigUIBean(configUIBean2);
		mdfActions.manageGOWithConfigUI.createNew(allDataTypeGOInstance_CreatedThroughRuntimePage);
		mdfActions.manageGOWithConfigUI.setIsNeedToNavigate(false);
		mdfActions.manageGOWithConfigUI.validateGO(allDataTypeGOInstance_CreatedThroughRuntimePage);
	}

	private void createAllDataTypeGOObjectDefinition() throws Exception {
		goDefinitionPicklistFieldBean1.setValidValuesSource(picklistBean1.getExternalCode());
		goDefinitionGOFieldBean1.setValidValuesSource(quickCardGO.getExternalCode());
		// goDefinitionFOFieldBean1.setValidValuesSource("location");

		goDefAssociationBean1.setType(AssociationType.Composite);
		goDefAssociationBean1.setMultiplicity(Multiplicity.OneToOne);
		goDefAssociationBean1.setDestinationObject(compChildObjectOneToOne);
		goDefAssociationBean1.setGoDefinitionBean(allDataTypeGO);

		goDefAssociationBean2.setType(AssociationType.Composite);
		goDefAssociationBean2.setMultiplicity(Multiplicity.OneToMany);
		goDefAssociationBean2.setDestinationObject(compChildObjectOnetoMany);
		goDefAssociationBean2.setGoDefinitionBean(allDataTypeGO);

		goDefAssociationBean3.setType(AssociationType.ValidWhen);
		goDefAssociationBean3.setMultiplicity(Multiplicity.OneToMany);
		goDefAssociationBean3.setDestinationObject(validWhenObjectOnetoMany);
		goDefAssociationBean3.setGoDefinitionBean(allDataTypeGO);

		allDataTypeGO = goDefinitionBean1;
		allDataTypeGO.setEffectiveDatingEnum(EffectiveDatingEnum.MultipleChangesPerDay);

		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = dateformat.format(today);

		String[] dateTime = reportDate.split(" ");

		String date = dateTime[0];
		String time = dateTime[1];

		date = date.replace("-", "_");

		String[] timewithoutColon = time.split(":");

		String code = "sanityParentAllDataTypeGO";

		String goCode = code + date;

		for (int i = 0; i < timewithoutColon.length; i++) {
			goCode = goCode + timewithoutColon[i];
		}

		allDataTypeGO.setCode(goCode);
		goDefinitionAutoNumberFieldBean1.setVisibilityEnum(VisibilityEnum.ReadOnly);
		allDataTypeGO.addUserDefinedField(goDefinitionNumberFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionAutoNumberFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionDecimalFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionTranslatableFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionBooleanFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionDateTimeFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionAttachmentFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionPicklistFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionGOFieldBean1);
		// allDataTypeGO.addUserDefinedField(goDefinitionFOFieldBean1);
		allDataTypeGO.addUserDefinedField(goDefinitionClobFieldBean1);

		allDataTypeGO.addAssociation(goDefAssociationBean1);
		allDataTypeGO.addAssociation(goDefAssociationBean2);
		allDataTypeGO.addAssociation(goDefAssociationBean3);

		// mdfActions.configureGODefinition.createNewGODefinitionWithTimeStamp(allDataTypeGO);
		mdfDPExecutor.add(mdfDPActions.goDef_CreateIfNotExist.GOD5, allDataTypeGO);
	}

	private static void RunBatch(String strBatchLoc) {

		try {
			strBatchLoc = "C:\\Batch\\" + strBatchLoc + ".bat";
			strBatchLoc = "cmd /c start /wait " + strBatchLoc;
			Runtime rn = Runtime.getRuntime();
			Process pr = rn.exec(strBatchLoc);
			System.out.println("Waiting for batch file ...");
			pr.waitFor();
			System.out.println("Batch file done.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClassMethod1() throws Exception {
		super.stop();
	}

}
