package com.cucumber.framework.pageconstants;

public interface CashReconciliationL2PageLoc {
	String l2_cash_reconciliation = "(//*[contains(text(),'L2 Cash Reconciliation')])[1]";
	String all_payments_received_toggle_xpath = "(//input[@name='$PpyWorkPage$pFlagsValue$gPaymentsReceived']/../input)[2]";
	String cash_collection_update_toggle_xpath = "(//input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformReview']/../input)[2]";
	String total_amount_received_xpath = "(//*[contains(text(),'Total amount received')])[1]";
	String process_completed_xpath = "//*[contains(text(),'Thank you, the process has been completed successfully')]";
	String resolved_completed_xparh = "(//*[contains(text(),'Resolved-Completed')])[1]";
	String left_arrow_xpath = "//button[@name='CaseHeader_pyWorkPage_59']/i";

	String workbasket_COPPL2_xpath = "//a[contains(text(),'FSNA:COPPL2')]";
	String payment_review_pagetiltle_xpath = "(//*[contains(text(),'L2 Payment Review')])[1]";
	String payment_release_xpath = "(//*[contains(text(),'Payment Release')])[1]";
	String payments1_toggle_xpath = "(//input[@name='$PpyWorkPage$pFlagsValue$gPaymentSetUp']/../input)[2]";
	String payments2_toggle_xpath = "(//*[contains(text(),'Payment(s) have been released via the banking platform')])/../div[3]/input[2]";
	String payment_reconciliation_xpath = "(//*[contains(text(),'L2 Payment Reconciliation')])[1]";
	String payments3_toggle_xpath = "(//*[contains(text(),'Accounting platform has been reviewed for payment(s) update')])/../div[3]/input[2]";
	String bankingplatform_xpath = "(//*[contains(text(),'Payment(s) have been correctly set up on banking platform')])";
	String bankingplatform2_xpath = "(//*[contains(text(),'Payment(s) have been released via the banking platform')])";
	String notice_distribution_pagetitle_xpath = "(//*[contains(text(),'L1 Investor Notice Distribution')])[1]";
	String distributed_toggle_xpath = "(//*[contains(text(),'All investor notices have been distributed to relevant parties via ReportPro')])/../div[3]/input[2]";
	String toggle1_xpath = "(//*[contains(text(),'All investor notices have been prepared for the relevant parties')])/../div[3]/input[2]";
	String toggle2_xpath = "(//*[contains(text(),'All investor notices have been distributed to the relevant parties')])/../div[3]/input[2]";
	String toggle3_xpath = "(//*[contains(text(),'All investor notices have been reviewed')])/../div[3]/input[2]";
	String l2_notice_distribution_pagetitle_xpath = "(//*[contains(text(),'L2 Investor Notice Distribution')])[1]";
	String l2reconciliationreview_pagetitle_xpath = "(//*[contains(text(),'L2 Reconciliation Review')])[1]";

	String accounting_review_toggle_xpath = "(//*[contains(text(),'Accounting platform has been reviewed for investment')])/../div[3]/input[2]";
	String Status_txt_xpath1 = "//span[contains (text(), '%s')]";

	// Direct Investment Sale
	String btn_PaymentReceived = "//input[@name='$PpyWorkPage$pFlagsValue$gPaymentReceived' and @type='checkbox']";
	String btn_AccReview = "//input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdateL2' and @type='checkbox']";
	String L2CashReconcilationReviewTitle = "(//span[text()='L2 Expense Payment Cash Reconciliation Review'])[1]";

	// Exp Payment
	String Resolved = "//*[contains(text(),'Thank you, the process has been completed successfully')]";

}