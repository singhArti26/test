package com.cucumber.framework.pageconstants;

public interface InitiationL2PageLoc {

	String logout_icon_xpath = "//i[@data-test-id='px-opr-image-ctrl']";
	String logout_xpath = "//a//span[contains(text(),'Logout')]";
	String username_xpath = "//input[@id='txtUserID']";
	String login_popup_close_xpath = "//div[@class='pzbtn-mid' and text()='Close']";

	String FSNA_client_services_L2_xpath = "//a[contains(text(),'FSNA Client Services L2')]";
	String cases_To_Be_Processed_xpath = "//div[@aria-label='Cases To Be Processed']";
	String headerClick_xpath = "//div[@node_name='OperationalHeader']";
	String process_ID_xpath = "(//div[@name='BASE_REF']//a[@aria-label='Process ID Actions'])[2]";
	String worklist_process_ID_xpath = "(//div[@name='BASE_REF']//a[@aria-label='Process ID Actions'])[1]";
	String filtr_description_ID_xpath = "(//a[@class='pointerStyle pi pi-filter ' and position()=1])[4]";
	
	String WF_ApplyFilter_xpath = "//*[@class='menu menu-format-standard menu-regular']/li[3]/a";

	String processID_xpath = "(//div[text()='Process ID']/following::tr/td/div/div/div)[1]";
	String fundFilter_xpath = "(//div[text()='Fund'])[1]";

	String approve_xpath = "(//label[contains(text(),'Approve')])[1]";
	// "//label[contains(text(),'Approve')]";
	String labelInvestor_xpath = "(//label[contains(text(),'Investor')])[1]";
	String approve_FOF_xpath = "(//label[contains(text(),'Approve')])[2]";
	String approve_3_xpath = "(//label[contains(text(),'Approve')])[3]";
	String submit_button_xpath = "//button[contains(text(),'Submit')]";
	String task_assign_xpath = "//span[contains(text(),'Task assigned to: Client Services 002')]";
	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String reject_xpath = "(//label[contains(text(),'Reject')])[1]";
	String reject_xpath1 = "(//label[contains(text(),'Reject')])[2]";
	String reject_xpath2 = "(//label[contains(text(),'Reject')])[3]";
	String client_xpath = "//*[@id='RULE_KEY']/div/div[1]/div/div[2]/div/div/div/span[1]/label";
	String reason_xpath = "//label[text()='Reason'or text()='Comment']/following-sibling::div/span/span/textarea";
	String reason_xpath_1 = "(//label[text()='Reason'or text()='Comment']/following-sibling::div/span/span/textarea)[2]";
	String client_service_l1_xpath = "//*[@id='RULE_KEY']/div/div[1]/div/div[2]/div/div/div/span[2]/label";
	String investment_review_pagetitle_xpath = "(//span[contains(text(),'L2 - Investment Review')])[1]";
	String todolist_xpath = "//span[contains(text(),'To-do list')]";

	String filtr_search_in_workBasket = "//div[@class='field-item dataValueWrite']/span/input";
	String filter2 = "(//div[text()='Process ID']//a[contains(@class, 'pointerStyle pi pi-filter')])[2]";
	String filterDescription = "(//div[text()='Description']//a[contains(@class, 'pointerStyle pi pi-filter')])[2]";
	String workbasketfilteredCaseId = "(//a[@data-ctl='Link'])[last()]";

	String apply_button = "//button[contains(text(),'Apply')]";
	String btn_clickApproveForOutcomeOfReview = "//div[@aria-label='Outcome of review']//label[text()='Approve']";
	String btn_clickReject = "//label[text()='Reject']";
	String txa_rejectRsn = "//textarea[@name='$PpyWorkPage$pAttachmentList$l1$pValueGroup$gRejectReason']";
	String btn_clickRejectForOutcomeOfReview = "//input[@name='$PpyWorkPage$pValueGroup$gL2InvestmentDecision' and @value='Reject']";
	String btn_FinalSubmit = "//button[contains(text(),'Submit')]";
	String txt_errorMessage = "(//div[@class='custom_text'])[2]";

	// FOF Capital Call
	String txt_RejectReason = "//textarea[@name='$PpyWorkPage$pValueGroup$gRejectReason']";
	String toggle_ApproveExtlCommnts = "//input[@name='$PpyWorkPage$pFlagsValue$gIsApproved' and @type='checkbox']";
	String btn_ClientServicesL1 = "//label[text()='Client services L1']";
	String lnkCaseProcessID = "(//div[text()='Process ID']/following::tr/td/span/a)[1]";
	String btn_clickRejectForOutcomeOfReviewFOF = "//input[@name='$PpyWorkPage$pValueGroup$gL2IntakeDecision' and @value='Reject']";
	String btn_clickRejectForOutcomeOfReviewL2 = "//input[@name='$PpyWorkPage$pValueGroup$gL2CallBackDecision' and @value='Reject']";
	String btn_clickApproveForOutcomeOfReviewFOFcp = "//input[@id='eeab78d0Approve']";

	// DIP
	String txa_DIP_rejectRsn = "//textarea[@name='$PpyWorkPage$pAttachmentList$l1$pReasonForReject']";
	String btn_DIP_clickRejectForOutcomeOfReview = "//input[@name='$PpyWorkPage$pValueGroup$gL2CallBackDecision' and @value='Reject']";
	String btn_DIP_clickReject = "//input[@name='$PpyWorkPage$pAttachmentList$l1$pDocumentCategoryReviewStatus' and @value='Reject']";

	// PER
	String btn_Apprve_scndTab = "(//label[ text()='Approve'])[2]";
	String client_wrkBasket_PhaseFilter = "(//div[text()='Phase/Status']/child::div/a[@id='template_filter'])[2]";
}
