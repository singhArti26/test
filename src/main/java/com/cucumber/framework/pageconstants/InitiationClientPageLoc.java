package com.cucumber.framework.pageconstants;

public interface InitiationClientPageLoc {

	String create_btn_xpath = "(//span[@class='menu-item-icon-imageclass pi pi-plus'])[1]";
	String rdoPercentage = "(//label[contains(text(),'Percentage')])[1]";
	String txtPercentagetobecalled = "//input[@id='802a8add']";
	String txtComment = "//label[text()='Comment']/following-sibling::div/span/span/textarea";
	String case_ID_xpath = "//*[@id='RULE_KEY']/div[1]/div/div/div[1]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div/span";
	String left_arrow_xpath = "//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i";
	String page_title_xpath = "//*[@id='RULE_KEY']/div/div[1]/span";
	String pagetitle_xpath = "(//*[contains(text(),'Fund Liquidity Resolution')])[1]";
	String resolution_xpath = "//*[@id='c42afc63']";
	String search_xpath = "//*[@id='anypicker-input']";
	String resolution_list_xpath = "//ul[@id='apresults-list']/li/div";
	String comments_xpath = "//*[@id='a297a653']";
	String exp_xpath = "//*[@id='70569a70']";
	// FOF Commitment
	//String newinvestment_toggle_xpath = "(//*[contains(text(),'Is this a new investment?')])/../div[3]/input[2]";
	String newinvestment_toggle_xpath = "//input[@id='3a1c5c32']";
	String investmentname_xpath = "(//input[@name='$PpyWorkPage$pTransactionData$l1$pOperationName'])[2]";
	String currencyOfCommitment_xpath = "(//input[@name='$PpyWorkPage$pTransactionData$l1$pCurrency'])[2]/../button";
	String currencyOfCommitment_dropdown_xpath = "//div[@id='apresults-list']/ul/li";
	String save_button_xpath = "//button[contains(text(),'Save')]";
	String changes_successfully_text_xpath = "//div[contains(text(),'Changes successfully saved')]";
	String ok_xpath = "(//button[contains(text(),'OK')])[1]";
	String cancel_xpath = "(//button[contains(text(),'Cancel')])[2]";
	String fund_name_xpath = "(//*[@class='anypicker-token']/span)[1]";
	String investment_name_xpath = "(//*[@class='anypicker-token']/span)[2]";
	String executed_xpath = "//label[contains(text(),'Executed')]";

	String fund_dropdown_xpath = "//input[@id='ms4ead46ac']";

	String fund_list_xpath = "//span[@class='ms-primary-option']";

	String currencyOfInvestment_xpath = "(//input[@name='$PpyWorkPage$pTransactionData$l1$pCurrency'])[2]/../button";

	String amount_to_commit_xpath = "//*[@id='fcae7c03']";

	// Expense Payment
	String payment_package_name = "//*[@id='bd7dcbc9']";
	String noOfInvoices_value = "//input[@name='$PpyWorkPage$pValueGroup$gNoOfInvoices']";
	String upload_doc_btn = "//button[contains(text(),'Upload Document(s)')]";
	String invoice_xpath = "//select[@name='$PdragDropFileUpload$ppxResults$l1$pDocumentCategory']";
	String select_file_button = "//input[@name='$PpyAttachmentPage$ppxAttachName']";
	String invoice2_xpath = "//select[@name='$PdragDropFileUpload$ppxResults$l2$pDocumentCategory']";
	String successfulMessage = "//*[contains(text(),'Thank you, the next task has been assigned')]";
	String actions_click = "//button[@name='CaseActionHeader_pyWorkPage_5']";
	String refresh_click = "//*[@title='Refresh this work item']";
	String ocr_status_check = "//span[@class='case_description']";
	String initiationPageVerify = "//span[@class='ad_primary_title' and contains(text(),'Expense Payment Initiation')]";
	String verifyExpensePaymentTitle = "//span[text()='Expense Payment Initiation']";
	String moreFund = "//input[@name='$PpyWorkPage$pValueGroup$gMultipleFunds']/following-sibling::label[text()='Yes']";

}