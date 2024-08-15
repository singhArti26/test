 package com.cucumber.framework.pageconstants;

public interface PreparationCOISL1PageLoc {
   
	String workbasket_COISL1_xpath="(//a[contains(text(),'FSNA')])[1]";
	String pageTitle_xpath="(//*[contains(text(),'L1 - AML/KYC Review')])[1]";
	String investor_registry_confirmation_pagetitle="(//*[contains(text(),'Investor Registry Confirmation')])[1]";
	String investor_registry_confirmation_xpath="(//*[contains(text(),'Investor Registry Confirmation')])[1]";
	String left_arrow_xpath="(//*[@id='RULE_KEY']/div[1]/div/div/div[2]/span/button/i)[1]";
	String toggle_xpath="(//*[contains(text(),'All investors are AML/KYC cleared')])/../div[3]/input[2]";
	String upto_date_toggle_xpath="(//*[contains(text(),'The investor registry of this fund is up to date')])/../div[3]/input[2]";
	String kyc_clear_toggle_xpath="(//*[contains(text(),'All investors are AML/KYC cleared')])/../div[3]/input[2]";
	String investor_registry_toggle_xpath="//*[@aria-describedby='$PpyWorkPage$pInvestoryRegistryConfirmationError ']";
	String upload_documents_xpath="//button[contains(text(),'Upload Document(s)')]";
	String select_file_xpath="//input[@type='file']";
    String submit_documents_xpath="//button[@id='ModalButtonSubmit']";
    String document_category_xpath="//*[text()='Document Category']";
    String kyc_investor_registry_pagetitle_xpath="(//*[contains(text(),'L1 AML/KYC & Investor Registry Review')])[1]";
    String KYC_pagetitle_xpath="(//*[contains(text(),'L1 AML/KYC & Investor Registry Review')])[1]";
    String KYC_comfortletter_xpath="(//*[contains(text(),'L1 AML/KYC Comfort Letter Review & Registry Review')])[1]";
    String KYC_toggle_xpath="(//*[contains(text(),'All investors are AML/KYC cleared')])/../div[3]/input[2]";
    String comfortletter_toggle_xpath="//input[@aria-describedby='$PpyWorkPage$pComfortLetterConfirmationError ']";


}