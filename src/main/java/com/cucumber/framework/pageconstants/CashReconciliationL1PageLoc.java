package com.cucumber.framework.pageconstants;

public interface CashReconciliationL1PageLoc {

	String l1_cash_reconciliation = "(//*[contains(text(),'Reconciliation')])[1]";
	String paidinfull_checkbox_xpath = "(//*[@id='6944c8cc'])[1]";
	String toggle_xpath = "(//input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdated']/../input)[2]";
	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String pageTitle_xpath = "//*[contains(text(),'Additional Payment Preparation')]";
	String payment_preparation_screen_xpath = "//*[contains(text(),'L1 Payment Preparation')]";
	String investor_wire_instruction_xpath = "//*[contains(text(),'L1 - Investor Wire Instruction Review')]";
	String toggle_button_xpath = "(//*[contains(text(),'Payment(s) have been set up on banking platform')])/../div[3]/input[2]";
	String workbasket_COPPL1_xpath = "//a[contains(text(),'FSNA: COPPL1')]";

	String payment_reconciliation_screen_xpath = "(//span[contains(text(),'L1 Payment Reconciliation')])[1]";
	String payments1_toggle_xpath = "(//*[contains(text(),'Payment(s) have been executed')])/../div[3]/input[2]";
	String payments2_toggle_xpath = "(//*[contains(text(),'Accounting platform has been updated for payment(s)')])/../div[3]/input[2]";
	String bankingplatform_xpath = "(//*[contains(text(),'Payment(s) have been set up on banking platform')])";
	String payments_xpath = "(//*[contains(text(),'Payment(s) have been executed')])";
	String failed_payments1_xpath = "((//table[@class='gridTable '])[1]/tbody/tr/td/div/input[2])[1]";
	String failed_payments2_xpath = "((//table[@class='gridTable '])[1]/tbody/tr/td/div/input[2])[3]";
	String notice_distribution_toggle_xpath = "(//*[contains(text(),'All investor notices were uploaded to the relevant portal / made available to release')])/../div[3]/input[2]";
	String notice_distribution_pagetitle_xpath = "(//*[contains(text(),'L1 Investor Notice Distribution')])[1]";
	String L1ReconciliationScreen_xpath = "(//span[contains(text(),'L1 Reconciliation')])[1]";
	String accounting_review_toggle_xpath = "(//*[contains(text(),'Accounting platform has been updated for investment')])/../div[3]/input[2]";

//FOF Commitment
	String executeddocumentsreview_pagetitle_xpath = "(//span[contains(text(),'L1 Executed Documents Review')])[1]";
	// FOF Disstrbution
	String chkCashcollectionandreconciliation = "(//div[text()='Cash collection and reconciliation completed']/following-sibling::div)[2]";
	String chkAccountingplatform = "(//div[text()='Accounting platform was updated correctly']/following-sibling::div)[2]";
	String chkBox1 = "(//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage$pValue')])[1]";
	// "(//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage')])[1]";
	String chkBox2 = "(//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage$pValue')])[2]";
	// "(//label[@class='chkbxCaptionRight'])[2]";
	String chkBox3 = "(//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage$pValue')])[3]";
	String chkBox4 = "(//label[@class='chkbxCaptionRight'])[1]";
	// "(//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage')])[1]";
	String chkBox5 = "(//label[@class='chkbxCaptionRight'])[2]";
	// "(//label[@class='chkbxCaptionRight'])[2]";
	String chkBox6 = "(//label[@class='chkbxCaptionRight'])[3]";

	// Direct Investment Sale
	String btn_cashRecon = "//input[@name='$PpyWorkPage$pFlagsValue$gCashCollectionCompleted' and @type='checkbox']";
	String btn_accPlatform = "//input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdate' and @type='checkbox']";

	// Exp payment
	String L1CashReconcilationTitle = "(//span[text()='L1 Expense Payment Cash Reconciliation'])[1]";
	String AccountingPlatformUpdatedToggle = "//input[@name='$PpyWorkPage$pFlagsValue$gAccountingPlatformUpdated' and @type='checkbox']";
	String allPaymentsReleased_Toggle = "//input[@name='$PpyWorkPage$pFlagsValue$gAllPaymentsReleased' and @type='checkbox']";
	String textComment = "//textarea[@id='525b1e60']";
	String clientdesComment = "//textarea[@id='9806d51d']";
	String chkbxPer = "//div/input[@type='checkbox' and contains(@name,'$ppySelected')]";
	String chkbxPer1 = "//div/input[@type='checkbox' and contains(@name,'$PpyWorkPage$pValueGroup')]";
	String chkbxPer2 = "//div/input[@type='checkbox' and contains(@name,'PpyWorkPage$pFlagsValue')]";

	// "//input[@type='checkbox']/following-sibling::label[@class='chkbxCaptionRight']";
	String lnkOpenChecklist = "(//div[normalize-space()='Open Checklist'])[1]";
	String chkDraftreportingrequired1 = "//input[@id='6d99bcab']";
	String chkDraftreportingrequired2 = "//input[@id='37f883cb']";

}