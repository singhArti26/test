package com.cucumber.framework.pageconstants;

public interface PrepartaionLPageLoc {

	String l2_allocation_file_review_xpath = "//span[contains(text(),'L2 Allocation File Review')]";
	String approve_xpath = "//label[contains(text(),'Approve')]";
	String reject_xpath = "//label[contains(text(),'Reject')]";
	String reason_textbox_xpath = "//label[text()='Reason']/following-sibling::div/span/span/textarea";
	String internal_xpath = "//*[@id='f8bf7b66']";
	String investor_xpath = "//body[1]/div[5]/main[1]/div[1]/form[1]/div[3]/div[1]/section[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[1]/div[1]/div[1]/div[1]";
	String mcp_id_xpath = "//body[1]/div[5]/main[1]/div[1]/form[1]/div[3]/div[1]/section[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/div[1]/div[1]";
	String alternative_ID_xpath = "//body[1]/div[5]/main[1]/div[1]/form[1]/div[3]/div[1]/section[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[3]/div[1]/div[1]/div[1]";
	String total_amount_xpath = "//body[1]/div[5]/main[1]/div[1]/form[1]/div[3]/div[1]/section[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[4]/div[1]/div[1]/div[1]";
	String investor_list = "//*[contains(text(),'Investor List')]";
	String approve_toggle_xpath = "(//div[@class='content-item content-field item-2 remove-bottom-spacing remove-right-spacing flex flex-row checkbox-switch checkbox-switch--small dataValueWrite'])[1]";
	String submit_button_xpath = "//button[contains(text(),'Submit')]";
	String summarypage_title_xpath = "(//*[contains(text(),'Summary - Initiation')])[1]";

	String left_arrow_xpath = "(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";

	String callbackreview_pagetitle_xpath = "(//span[contains(text(),'L2 Call Back Review')])[1]";

	// Exp payment
	String wrk_coppL1 = "//a[@class='AD_Strong' and contains(text(),'FSNA Central Operations PP L2')]";
	String L2ExpensePaymentPreparationTitle = "(//span[text()='L2 Expense Payment Preparation'])[1]";
	String confirmDecisionDrpDown_xpath = "//input[@name='$PpyWorkPage$pPaymentList$l1$pValueGroup$gL2Decision']";
	String search_xpath = "//*[@id='anypicker-input']";
	String dropDown_list_xpath = "//ul[@id='apresults-list']/li";
	String confirmDecisionDrpDownSecondInvoice_xpath = "//input[@name='$PpyWorkPage$pPaymentList$l2$pValueGroup$gL2Decision']";
	String error_msg_xpath = "(//div[@class='custom_text' and contains(text(),'All invoices')])[2]";
	
	//PER
	String btn_click_fund = "(//h3[@class='layout-group-item-title'])[2]";

}