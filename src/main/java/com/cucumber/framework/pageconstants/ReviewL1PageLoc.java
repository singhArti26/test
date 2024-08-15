package com.cucumber.framework.pageconstants;

public interface ReviewL1PageLoc {

	String pageTitle_Xpath = "//span[contains(text(),'L1 Investor Notice Preparation')]";
	String investor_wire_instruction_pagetitle_xpath = "(//span[contains(text(),'L1 - Investor Wire Instruction Review')])[1]";
	String notice_preparation_pagetitle_xpath = "(//span[contains(text(),'L1 Investor Notice Preparation')])[1]";
	String upload_document_xpath = "//button[contains(text(),'Upload Document(s)')]";
	String select_file_xpath = "//input[@id='$PpyAttachmentPage$ppxAttachName']";
	String submit_documents_xpath = "//button[@id='ModalButtonSubmit']";
	String document_category_xpath = "//*[text()='Document Category']";
	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String toggle_xpath = "(//*[contains(text(),'The wire instructions are up to date')])/../div[3]/input[2]";
	String title_xpath = "//span[contains(text(),'L1 Investor Notice Preparation')]";
	String notice_preparation_pageTitle_xpath = "";
	String notice_distribution_toggle_xpath = "(//*[contains(text(),'All investor notices were uploaded to the relevant po')])/../div[3]/input[2]";

	// FOF Capital call
	String txt_RejectionReason = "//span[text()='Reason']/following-sibling::div[@class='field-item dataValueRead']/span[@class='ad_standard_inputs']";
	String toggle_PaymentRelease = "//div[text()='All the payments were successfully released']/following-sibling::div/input[@name='$PpyWorkPage$pFlagsValue$gPaymentExecuted' and @type='checkbox']";
	String toggle_AccPlatformUpdated = "//div[text()='The accounting platform has been updated to reflect the payments']/following-sibling::div/input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdate' and @type='checkbox']";

	// DIP
	String toggle_DIP_PaymentRelease = "//div[text()='Payment has been released']/following-sibling::div/input[@name='$PpyWorkPage$pFlagsValue$gPaymentExecuted' and @type='checkbox']";
	String toggle_DIP_AccPlatformUpdated = "//div[text()='Accounting Platform has been updated for investment']/following-sibling::div/input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdate' and @type='checkbox']";
	String toggle_DIP_AccPlatformReviewed = "//div[text()='Accounting platform has been reviewed for investment']/following-sibling::div/input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformReview' and @type='checkbox']";
}