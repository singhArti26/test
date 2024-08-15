package com.cucumber.framework.pageconstants;

public interface ReviewClientPageLoc {

	String workbasket_xpath = "//div[contains(text(),'Workbasket')]";
	String process_ID_dropdown_xpath = "(//tbody/tr[1]/th[2]/div[1]/div[2]/a[1])[2]";
	String processID_xpath = "(//*[@id='gridTableBody'])[2]/tr[2]/td[2]/div/div/div/span/a";
	String allocation_file_approve_xpath = "(//label[text()='Approve'])[1]";
	String notices_approve_xpath = "(//label[contains(text(),'Approve')])[2]";
	String toggle_xpath = "(//input[@name='$PpyWorkPage$pFlagsValue$gAllInvestorNoticesDistributed']/../input)[2]";
	String c_logoff_xpath = " (//*[@id=\"RULE_KEY\"]/div[1]/div/div/div[2]/div/div[2]/div/div[2]/span)[1]";
	String log_off_xpath = "//span[contains(text(),'Log off')]";
	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String reject_xpath = "(//label[text()='Reject'])[2]";

	String pagetitle_xpath = "(//*[contains(text(),'L2 Investor Notice Distribution')])[1]";
	String toggle_button_xpath = "(//input[@name='$PpyWorkPage$pValueGroup$gInvestorNoticesSentViaReportPro'])[2]";
	String payment_release_xpath = "(//span[contains(text(),'Payment Release')])[1]";
	String title_xpath = "(//span[contains(text(),'Investor Allocation Review & Notice Distribution')])[1]";
	String toggle1_xpath = "(//*[contains(text(),'All investor notices have been prepared for the relevant parties')])/../div[3]/input[2]";
	String toggle2_xpath = "(//*[contains(text(),'All investor notices have been distributed to the relevant parties')])/../div[3]/input[2]";
	
	//String allocation_file_approve_distribution = "(//input[@name='$PpyWorkPage$pAttachmentList$l4$pDocumentCategoryReviewStatus'])[1]";
	String allocation_file_approve_distribution = "//span//input[@id='808771f4Approve']";

	// FOF Commitment
	String uploadexecuteddocuments_xpath = "(//span[contains(text(),'Upload Executed Documents')])[2]";

	// Exp payment
	String ClientExpensePaymentReviewTitle = "(//span[text()='Expense Payment Review And Release'])[1]";
	String toggle1 = "//div[@class='content-item content-field item-3 remove-all-spacing flex flex-row checkbox-switch AD-checkbox-swicth dataValueWrite']";

	// FOF Capital Call
	String toggle_ReleasePayment = "//input[@name='$PpyWorkPage$pFlagsValue$gPaymentReleased' and @type='checkbox']";
	String icon_Loading = "//div[@class='loader']";
	String upload_doc_btn = "//button[contains(text(),'Upload Document(s)')]";
	String select_file_button = "//input[@name='$PpyAttachmentPage$ppxAttachName']";

	// DIP
	String toggle_DIP_ReleasePayment = "//input[@name='$PpyWorkPage$pFlagsValue$gPaymentReleasedClient' and @type='checkbox']";

}