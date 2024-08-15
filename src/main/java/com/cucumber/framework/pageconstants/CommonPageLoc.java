package com.cucumber.framework.pageconstants;

public interface CommonPageLoc {

	String btn_Header_Actions = "//button[@name='CaseActionHeader_pyWorkPage_5']";
	String btn_UseTemplate = "//span[text()='Use Template']";
	String drp_ProcessID_Select = "//label[text()='Process ID']/following-sibling::div//input";
	String drp_caseID_value = "(//label[text()='Process ID']/following-sibling::div[@class='anypicker-results']/ul//div/span)[1]";
	String btn_Search = "//button[text()='Search']";
	String txt_Description = "(//div[text()='Description']/following::tr/child::td[@data-attribute-name='Description']//span)[1]";
	String drp_Select = "//label[text()='Transaction Name']/following-sibling::div//input";
	String drp_list = "(//ul[@id='apresults-list']//span)[1]";
	String btn_Filter_Copy = "//button[text()='Copy']";
	String txt_Status = "//span[contains (text(), '%s')]";
	String btn_Go = "//div[@String_type='field']/span/button[text()='Go']";

	String icon_Loading = "//div[text()='Loading...']";
	String btn_upload = "//button[contains(text(),'Upload Document(s)')]";
	String btn_selectFile = "//input[@name='$PpyAttachmentPage$ppxAttachName']";

	String btn_uploadSubmit = "//button[@id='ModalButtonSubmit']";

	String txa_intlComments = "//textarea[@name='$PpyWorkPage$pInternalComment']";

	String btn_FinalSubmit = "//button[contains(text(),'Submit')]";

	String actions_click = "//button[@name='CaseActionHeader_pyWorkPage_5']";
	String refresh_click = "//*[@title='Refresh this work item']";
	String btn_Case360 = "//div[text()='Case 360']";
	String btn_Comments = "//h3[text()='Comments']";
	String btn_Related = "//h3[text()='Related Cases']";
	String txt_ActionName = "(//div[contains(text(),'Action Name')]/following::tr/td[@data-attribute-name='Action Name']/span)[1]";
	String txt_ActionComments = "(//div[contains(text(),'Action Comments')]/following::tr/td[@data-attribute-name='Action Comments']/span)[1]";
	String txt_ActionBy = "(//div[contains(text(),'Action By')]/following::tr/td[@data-attribute-name='Action By']/span)[1]";
	String txt_ActionNameClient = "(//div[contains(text(),'Action Name')]/following::tr/td[@data-attribute-name='Action Name']/span)[1]";
	String txt_ActionCommentsClient = "(//div[contains(text(),'Action Comments')]/following::tr/td[@data-attribute-name='Action Comments']/span)[2]";
	String txt_ActionByClient = "(//div[contains(text(),'Action By')]/following::tr/td[@data-attribute-name='Action By']/span)[2]";

	String txt_caseIDtitle = "//span[@class='ad_case_title']";

	String lnk_wrkbench = "//a[contains(text(),'FSNA Client Services L2')]";
	String lnk_CSL1_wrkbench = "//a[contains(text(),'FSNA Client Services L1')]";
	String headerClick_xpath = "//div[@node_name='OperationalHeader']";
	String btn_filter = "(//div[@name='BASE_REF']//a[@aria-label='Process ID Actions'])[2]";
	String btn_filter_worklist = "(//div[@name='BASE_REF']//a[@aria-label='Process ID Actions'])[1]";
	String btn_applyFilter = "//li[@title='Click to filter']//a";
	String txt_filtrSsearch = "//div[@class='field-item dataValueWrite']/span/input";
	String btn_apply = "//button[contains(text(),'Apply')]";
	String lnk_filteredCaseId = "//a[@data-ctl='Link']";

	String btn_CancelRequest = "//span[text()='Cancel Request']";
	String txa_CanclReqRsn = "//textarea[@name='$PpyWorkPage$pCancelRequestReason']";
	String btn_Filter_CancelCase = "//span[text()='Pending - Cancel']";
	String btn_ReviewDecision_Approve = "//label[text()='Review decision']/following-sibling::div//span/label[text()='Approve']";

	String btn_AssignPriority = "//span[text()='Assign Priority']";
	String btn_ToggleOn = "//input[@name='$PpyWorkPage$pValueGroup$gCasePriority' and @type='checkbox']";

	String btn_filterWorkbasket = "(//th[@aria-label='Process ID']//div[@name='BASE_REF']//a[@class='columnMenu'])[2]";
	
	String TEST_ApplyFilter_xpath = "//*[@class='menu menu-format-standard menu-regular']/li[3]/a";
	String txt_filtrSearchWorkBasket = "//div[@class='field-item dataValueWrite']/span/input";
	String txt_Priority = "//span[text()='Priority']";
	String lnk_workbasketfilteredCaseId = "(//a[@data-ctl='Link'])[last()]";
	String txa_ClientComments = "//textarea[@name='$PpyWorkPage$pExternalComment']";
	String txt_Summary = "//h2[contains(text(),'Summary - Initiation')]";

	String lnk_wrkBench_COPPL1 = "//a[contains(text(),'FSNA Central Operations PP L1')]";
	String txt_ExtlCmnts = "//textarea[@name='$PpyWorkPage$pExternalComment']";

	String txt_RejectionComments = "//span[@class='ad_warning_notification_header']";
	String lnkCaseProcessID = "(//div[text()='Process ID']/following::tr/td/span/a)[1]";
	String btnGo = "(//button[text()='Go'])[2]";
	String txterrorMsg = "//div[contains(@class,'-item content-sub_section item-1 remove-all-spacing flex flex-row')]/ul/li/div/div";
	String txt_SuccessMsg = "//div[contains(text(),'Thank you')]";
	String txt_UploadPopup = "//h2[contains(text(),'Attach')]";
	
	String btn_SecondUpload = "//button[@name='InvestorRegistryConfirmation_pyWorkPage_25']";

}
