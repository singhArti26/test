package com.cucumber.framework.pageconstants;

public interface PreparationL1PageLoc {

	String FSNA_client_services_L2_xpath = "//a[contains(text(),'FSNA Client Services L2')]";
	String logout_xpath = "//a//span[contains(text(),'Logout')]";
	String username_xpath = "//input[@id='txtUserID']";
	String login_popup_close_xpath = "//div[@class='pzbtn-mid' and text()='Close']";

	String l1_allocation_file_preparation = "(//span[contains(text(),'L1 Allocation File Preparation')])[1]";
	String upload_document_xpath = "//button[contains(text(),'Upload Document(s)')]";
	String select_file_xpath = "//input[@id='$PpyAttachmentPage$ppxAttachName']";
	String submit_documents_xpath = "(//button[@id='ModalButtonSubmit'])[1]";
	String investor_list = "//*[contains(text(),'Investor List')]";
	String toggle_xpath = "//*[contains(text(),'The investor registry of this fund is up to date')]/parent::div/div[3]/input[2]";
	String internal_xpath = "//*[@id='f8bf7b66']";
	String external_xpath = "//*[@id='233aa558']";
	String submit_button_xpath = "//button[contains(text(),'Submit')]";
	String upload_documents_xpath = "(//button[contains(text(),'Upload Document(s)')])[3]";
	String upload_supporting_documents_xpath = "(//button[contains(text(),'Upload Document(s)')])[2]";

	String document_category_xpath = "//*[text()='Document Category']";
	String system_screenshot_xpath = "//*[@id='9fb26c58']";

	String share_registry_xpath = "//*[@id='3ce4eaf1']";
	String others_xpath = "//*[@id='eb066aa9']";

	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";

//Distribution xpaths

	String l1_liquidity_check_xpath = "(//span[contains(text(),'L1 Liquidity Check')])[1]";
	String yes_button_xpath = "//label[contains(text(),'Yes')]";
	String insufficient_liquidity_dropdown_xpath = "//input[@id='d39e98fe']";
	String insufficient_liquidity_dropdown_list_xpath = "//ul[@id='apresults-list']/li";
	String search_xpath = "//*[@id='anypicker-input']";
	String checkbox_xpath = "((//table[@class='gridTable '])[2]/tbody/tr/td/div/input[2])[1]";
	String liquidity_resolution_pagetitle_xpath = "(//span[contains(text(),'L1 Liquidity Resolution')])[1]";
	String liquidity_toggletext_xpath = "(//*[contains(text(),'I confirm liquidity was made sufficient, following the instructions provided by the client')])";
	String liquidity_toggle_xpath = "(//*[contains(text(),'I confirm liquidity was made sufficient, following the instructions provided by the client')])/../div[3]/input[2]";
//FOF Commitment
	String callback_pagetitle_xpath = "(//span[contains(text(),'Call Back')])[2]";
	String bank_details_toggle_xpath = "(//input[@name='$PpyWorkPage$pTransactionData$l1$pValueGroup$gBankingDetails'])[4]";
	String reason_xpath = "//*[@id='dbcaf3cd']";
	String client_representative_called_xpath = "//input[@name='$PpyWorkPage$pVendorDetails$pClientRepresentative']";
	String call_back_date_and_time_xpath = "//input[@name='$PpyWorkPage$pVendorDetails$pCallBack']";
	String phonenumber_client_representative_xpath = "//input[@name='$PpyWorkPage$pVendorDetails$pClientPhoneNumber']";
	String callback_successful_toggle_xpath = "(//input[@name='$PpyWorkPage$pVendorDetails$pValueGroup$gCallBackSuccessful'])[2]";
	String edit_xpath = "//label[contains(text(),'Edit')]";
	String btnSelectUpload = "//button[contains(text(),'Select file')]";

	// Expense payment
	String L1ExpensePaymentPreparationTitle = "(//span[text()='L1 Expense Payment Preparation'])[1]";
	String currency = "//input[@name='$PpyWorkPage$pPaymentList$l1$pCurrency']";
	String dropDown_list_xpath = "//ul[@id='apresults-list']/li";
	String issuing_account_drp_down = "//input[@name='$PpyWorkPage$pPaymentList$l1$pIssuingAccount']";
	String amt_to_paid = "//input[@name='$PpyWorkPage$pPaymentList$l1$pAmount']";
	String vendor_txt = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pName']";
	String invoice = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pInvoiceID']";
	String inv_date = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pInvoiceDate']";
	String payment_Date = "//tbody[@id='controlCalBody']//a[contains(@aria-label, '%s'  )]";
	String paymentDatePicker_xpath = "//*[@id='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pPaymentDateSpan']//img";
	String acc_no = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pBankAccountList$l1$pAccountNumber']";
	String aba_routing = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pBankAccountList$l1$pAbaCode']";
	String swift_code = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pBankAccountList$l1$pSwiftNumber']";
	String memo = "//textarea[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pDescription']";
	String proposedDecisionDrpDown_xpath = "//input[@name='$PpyWorkPage$pPaymentList$l1$pValueGroup$gL1Decision']";
	String Dec_comments = "//textarea[@name='$PpyWorkPage$pPaymentList$l1$pValueGroup$gL1DecisonComment']";
	String intl_comments = "//textarea[@name='$PpyWorkPage$pInternalComment']";
	String invoice2_header = "//h4[text()='Invoice 2']";
	String currency2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pCurrency']";
	String issu_acc_drp_down2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pIssuingAccount']";
	String amt_to_paid2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pAmount']";
	String vendor_2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pName']";
	String invoice2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pInvoiceID']";
	String inv_date2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pInvoiceDate']";
	String pay_date2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pPaymentDate']";
	String acc_no2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pBankAccountList$l1$pAccountNumber']";
	String abe_rot2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pBankAccountList$l1$pAbaCode']";
	String swift_cod2 = "//input[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pBankAccountList$l1$pSwiftNumber']";
	String memo2 = "//textarea[@name='$PpyWorkPage$pPaymentList$l2$pVendorDetails$pDescription']";
	String proposedDecisionDrpDownSecondInvoice_xpath = "//input[@id='176333ff']";
	String dec_comm2 = "//textarea[@name='$PpyWorkPage$pPaymentList$l2$pValueGroup$gL1DecisonComment']";
	String L1LiquidityReviewTitle = "(//span[text()='L1 Liquidity Review'])[1]";
	String answer_yes = "//input[@name='$PpyWorkPage$pValueGroup$gFundSufficientLiquidity' and @type='checkbox']";
	String liquidity_resolution_xpath = "//input[@name='$PpyWorkPage$pValueGroup$gInsufficientLiquidity']";
	String reviewFundLiquidity_xpath = "//input[@id='b2bb7ba4Yes']";
	String fee_type = "//input[@name='$PpyWorkPage$pPaymentList$l1$pFeeList$l1$pType']";
	String capt_amount = "//span[@class='leftJustifyStyle']";
	String amt = "//input[@name='$PpyWorkPage$pPaymentList$l1$pFeeList$l1$pAmount']";
	String L1ExpensePaymentCallback = "(//span[text()='L1 Expense Payment Call Back'])[1]";
	String title = "//span[@class='ad_primary_title']";
	String templete_inp_edit = "//label[contains(text(),'Edit')]";
	String template_name = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pTemplateName']";
	String template_bank = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pTemplateBank']";
	String client_rep_call = "//input[@name='$PpyWorkPage$pCallBackDetails$pClientRepresentative']";
	String call_succ = "//*[@id='RULE_KEY']/div/div[5]/div/div/div/span[1]/label";
	String upload_doc_btn = "//button[contains(text(),'Upload Document(s)')]";
	String select_file_button = "//input[@name='$PpyAttachmentPage$ppxAttachName']";
	String call_compl_time = "//input[@name='$PpyWorkPage$pCallBackDetails$pCallBack']";
	String no_of_client = "//input[@name='$PpyWorkPage$pCallBackDetails$pClientPhoneNumber']";
	String L1ExpensePaymentProcessingTitle = "(//span[text()='L1 Expense Payment Processing'])[1]";
	String toggle_BankingPlatform = "//div[text()='All the payments above were set up on the banking platform']/following-sibling::div[contains(@class,'checkbox-switch')]";
	String value = "//li[@role='treeitem']";
	String Fee_drp_down = "//input[@name='$PpyWorkPage$pPaymentList$l1$pFeeList$l1$pType']";
	String amount = "//input[@name='$PpyWorkPage$pPaymentList$l1$pFeeList$l1$pAmount']";
	String vendor = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pName']";
	String routingNo = "//input[@name='$PpyWorkPage$pPaymentList$l1$pVendorDetails$pBankAccountList$l1$pAbaCode']";

	// FOF Capital Call
	String txt_ClientRep = "//input[@name='$PpyWorkPage$pVendorDetails$pClientRepresentative']";
	String txt_CallBackDate = "//input[@name='$PpyWorkPage$pVendorDetails$pCallBack']";
	String txt_CientEmail = "//input[@name='$PpyWorkPage$pVendorDetails$pClientEmail']";
	String txt_CientPhone = "//input[@name='$PpyWorkPage$pVendorDetails$pClientPhoneNumber']";
	String toggle_CallBackYes = "//input[@name='$PpyWorkPage$pVendorDetails$pValueGroup$gCallBackSuccessful' and @type='checkbox']";
	String txt_templateName = "//input[@name='$PpyWorkPage$pVendorDetails$pTemplateName']";
	String txt_templateBank = "//input[@name='$PpyWorkPage$pVendorDetails$pTemplateBank']";
	String toggle_BankingDetails = "//span[text()='Are the banking details provided in the notice already present in the banking platform?']/following::div[contains(@class,'checkbox-switch')]";
	String txt_ReasonAfterEnablingToggle = "//textarea[@name='$PpyWorkPage$pValueGroup$gL1CallBackReason']";
	String chkBox1 = "(//label[@class='chkbxCaptionRight'])[1]";
	String txtInvestorcont = "//label[text()='Investor representative contacted']/following-sibling::div/span/input";
	String txtInvestorEmail = "//label[text()='Email address of investor representative']/following-sibling::div/span/input";

	// DIP
	String toggle_DIP_BankingPlatform = "(//input[@name='$PpyWorkPage$pFlagsValue$gPaymentSetUp'])[2]";
	String toggle_DIP_BankingPlatformPresent = "(//span[text()='Are the banking details for this investment present in the banking platform?']/following::div/input[@name='$PpyWorkPage$pTransactionData$l1$pValueGroup$gBankingDetails' and @type='checkbox'])[2]";
	String txt_Banking_Rsn = "//textarea[@name='$PpyWorkPage$pValueGroup$gL1CallBackReason']";

	String imgUpload = "(//a[text()='Upload']/img)[1]";
	String save_button_xpath = "//button[contains(text(),'Save')]";
	String btn_ok_xpath = "(//button[text()='OK'])[1]";
	
	//PER
	String drpbox_DocCategory = "//select[@name='$PdragDropFileUpload$ppxResults$l1$pDocumentCategory']";
}
