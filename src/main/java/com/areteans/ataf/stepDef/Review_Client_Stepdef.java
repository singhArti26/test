package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.ReviewClientPage;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class Review_Client_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;

	ReviewClientPage reviewclientpage;

	/**
	 * 
	 */
	public Review_Client_Stepdef() {

		reviewclientpage = new ReviewClientPage(TestBase.getDriver());
		reviewclientpage.sendLogoutObject(reviewclientpage);
	}

	@Then("the user should able to select Process ID under {string}")
	public void the_user_should_able_to_select_Process_ID_under(String title) throws Throwable {

		reviewclientpage.verify_Workbasket(title);
	}

	@Then("the user select Process ID dropdown")
	public void the_user_select_Process_ID_dropdown() throws Throwable {
		reviewclientpage.clickOn_Process_ID_Dropdown();
	}

	@Then("the user select Process ID")
	public void the_user_select_Process_ID() throws Throwable {
		reviewclientpage.clickOn_Process_ID();
	}

	@Then("the user should approve {string} and {string}")
	public void the_user_should_approve_and(String approve1, String approve2) throws Throwable {
		reviewclientpage.clickOn_Allocation_File_Approve();
		reviewclientpage.clickOn_Notices_Approve();
	}

	@Then("the user should reject {string}")
	public void the_user_should_reject(String string) throws Throwable {
		reviewclientpage.clickOn_Notice_Reject();
	}

	@Then("user should click {string} on the toggle button {string}")
	public void user_should_click_on_the_toggle_button(String string, String string2) throws Throwable {
		reviewclientpage.clickOn_toggleYes();
	}

	@Then("the user clicks on the Log off")
	public void the_user_clicks_on_the_Log_off() throws Throwable {

		reviewclientpage.click_On_LogOff_Button();

	}

	@Then("user should display {string}")
	public void user_should_display(String pageTitle) throws Throwable {

		reviewclientpage.sendLogoutObject(reviewclientpage);
		reviewclientpage.verifyInitiationScreen(pageTitle);
	}

	@Then("the user enable toggle button {string}")
	public void the_user_enable_toggle_button(String string) throws Throwable {

		reviewclientpage.sendLogoutObject(reviewclientpage);
		reviewclientpage.click_On_Approve_toggleButton();
	}

	@Then("user is able to land on {string} page")
	public void user_is_able_to_land_on_page(String pageTitle) throws Throwable {

		reviewclientpage.verify_pageTitle(pageTitle);
	}

	@Then("the user is able to land on the page - {string}")
	public void the_user_is_able_to_land_on_the_page(String title) throws Throwable {

		reviewclientpage.verify_pagetitle(title);
	}

	@Then("the user should approve {string}")
	public void the_user_should_approve(String string) throws Throwable {

		reviewclientpage.clickOn_Allocation_File_Approve();
	}

	@Then("select answer {string} for question - All investor notices have been prepared for the relevant parties")
	public void select_answer_for_question_All_investor_notices_have_been_prepared_for_the_relevant_parties(
			String string) throws Throwable {

		reviewclientpage.clickOn_Toggle_Button1_Yes();
	}

	@Then("the user should land on {string} page title")
	public void the_user_should_land_on_page_title(String pageTitle) throws Throwable {

		reviewclientpage.verifyUploadExecutedDocumentsPageTitle(pageTitle);
	}

	@Then("the user is able to land on the page client expense payment review - {string}")
	public void the_user_is_able_to_land_on_the_page_client_expense_payment_review(String title) throws Exception {

		reviewclientpage.verifyClientExpensePaymentReviewTitle(title);
	}

	@Then("select answer {string} for - All the payments were released on the banking platform")
	public void select_answer_for_All_the_payments_were_released_on_the_banking_platform(String ans) throws Exception {

		reviewclientpage.clickOnToggle1(ans);
	}

	@Then("select answer Yes for the question - All payments were released on the banking platform")
	public void select_answer_yes_for_All_the_payments_were_released_on_the_banking_platform() throws Exception {

		reviewclientpage.clickToggleYesForPaymentRelease();
	}

	@Then("upload the {string} and change file type to {string} - client")
	public void upload_documents_on_client_page(String file, String value1) throws Exception {

		reviewclientpage.clickOnUploadButtonOnClientPage(file, value1);
	}
	
	@Then("select answer Yes for the question - All payments were released on the banking platform - DIP")
	public void select_answer_yes_for_All_the_payments_were_released_on_the_banking_platform_DIP() throws Exception {

		reviewclientpage.clickToggleYesForPaymentReleaseDIP();
	}
	
	@Then("the user should approve {string} - Distribution")
	public void the_user_should_approve_Distribution(String string) throws Throwable {

		reviewclientpage.clickOn_Allocation_File_Approve_Distribution();
	}

}
