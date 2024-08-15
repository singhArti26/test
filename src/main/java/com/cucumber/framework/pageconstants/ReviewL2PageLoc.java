package com.cucumber.framework.pageconstants;

public interface ReviewL2PageLoc {

	String l2_investor_notice_review_xpath = "//span[contains(text(),'L2 Investor Notice Review')]";
	String approve_xpath = "//label[contains(text(),'Approve')]";
	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String pagetitle_xpath = "(//*[contains(text(),'L2 Investor Notice Distribution')])[1]";
	String toggle_button_xpath = "(//input[@name='$PpyWorkPage$pValueGroup$gInvestorNoticesSentViaReportPro'])[2]";
	String toggle2 = "//div[@class='content-item content-field item-3 remove-all-spacing flex flex-row checkbox-switch AD-checkbox-swicth dataValueWrite']";

	// Exp payment
	String callBackReviewTitle = "(//span[text()='L2 Expense Payment Call Back Review'])[1]";
	String approve = "//label[contains(text(),'Approve')]";
	String L2ExpensePaymentProcessingReviewTitle = "(//span[text()='L2 Expense Payment Processing Review'])[1]";
	String L2ExpensePaymentProcessingReviewAndReleaseTitle = "(//span[text()='L2 Expense Payment Review And Release'])[1]";
	String setup_toggle = " //input[@name='$PpyWorkPage$pFlagsValue$gPaymentSetUpReview' and @type='checkbox']";
	String payment_release_toggle = " //input[@name='$PpyWorkPage$pFlagsValue$gPaymentReleased' and @type='checkbox']";

	// FOF Capital
	String toggle_DisabledCheck1 = "//span[text()='Are the banking details provided in the notice already present in the banking platform?']/following::div[contains(@class,'checkbox-switch')]";
	String toggle_DisabledCheck2 = "//div[text()='I confirm that call back was successful']/following-sibling::div[contains(@class,'checkbox-switch')]";
	String txt_Reason = "//textarea[@name='$PpyWorkPage$pValueGroup$gL2CallBackRejectReason']";
	String txt_PaymentRejectReason = "//textarea[@name='$PpyWorkPage$pValueGroup$gPaymentSetUpReason']";
	String txt_PaymentErrorMsg = "(//div[contains(text(),'Please select the accounting platform has been updated to reflect the payments')])[2]";
	String toggle_ReviewPayments = "//div[text()='Please review that all the payments above were correctly set up on the banking platform']/following-sibling::div[contains(@class,'checkbox-swicth')]";

	// DIP
	String toggle_DIP_DisabledCheck1 = "//span[text()='Are the banking details for this investment present in the banking platform?']/following::div[contains(@class,'checkbox-switch')]";
	String toggle_DIP_ReviewPayments = "//div[text()='Payment was correctly set up on the banking platform']/following-sibling::div[contains(@class,'checkbox-swicth')]";
	String txt_DIP_PaymentErrorMsg = "(//div[contains(text(),'Please select accounting platform has been reviewed for investment')])[2]";
}