package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CashReconciliationL2Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class CashReconciliation_L2_Stepdef {

	public CashReconciliation_L2_Stepdef() {
		cashreconciliationL2page = new CashReconciliationL2Page(TestBase.getDriver());
	}

	SeleniumFunNonPega seleniumFunNonPega;
	CashReconciliationL2Page cashreconciliationL2page;

	@Then("the user should display {string} page")
	public void the_user_should_display_page(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyInitiationScreen(pageTitle);

	}

	@Then("user should click {string} on toggle button {string}")
	public void user_should_click_on_toggle_button(String string, String string2) throws Throwable {
		cashreconciliationL2page.clickOn_AllPayments_Received_toggle();
	}

	@Then("the user should clicks {string} on toggle button {string}")
	public void the_user_should_clicks_on_toggle_button(String string, String string2) throws Throwable {
		cashreconciliationL2page.clickOn_Cash_Collection_Update_toggle();
	}

	@Then("the user should display {string}")
	public void the_user_should_display(String completed) throws Throwable {
		cashreconciliationL2page.verify_Process_Completed(completed);
	}

	@Then("the user should able to see case status as {string}")
	public void the_user_should_able_to_see_case_status_as(String status) throws Throwable {

		cashreconciliationL2page.verifyCompletedStatus(status);
	}

	@Then("user click on {string} workbasket")
	public void user_click_on_workbasket(String workbasket) throws Throwable {

		cashreconciliationL2page.click_On_workbasket_COPP_L2(workbasket);
	}

	@Then("user is able to land on page {string}")
	public void user_is_able_to_land_on_page(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyPaymentReviewScreen(pageTitle);
	}

	@Then("the user is able to land on {string} page")
	public void the_user_is_able_to_land_on_page(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyPaymentReleaseScreen(pageTitle);
	}

	@Then("select answer {string} for question - Payment\\(s) have been correctly set up on banking platform")
	public void select_answer_for_question_Payment_s_have_been_correctly_set_up_on_banking_platform(String string)
			throws Throwable {

		cashreconciliationL2page.clickOn_Payments1_toggle();
	}

	@Then("select answer {string} for question - Payment\\(s) have been released via the banking platform")
	public void select_answer_for_question_Payment_s_have_been_released_via_the_banking_platform(String string)
			throws Throwable {

		cashreconciliationL2page.clickOn_Payments2_toggle();
	}

	@Then("user is able to display the {string} page title")
	public void user_is_able_to_display_the_page_title(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyPaymentReconciliationScreen(pageTitle);
	}

	@Then("select answer {string} for question - Accounting platform has been reviewed for payment\\(s) update")
	public void select_answer_for_question_Accounting_platform_has_been_reviewed_for_payment_s_update(String string)
			throws Throwable {

		cashreconciliationL2page.clickOn_Payments3_toggle();
	}

	@Then("the user should display {string} page title")
	public void the_user_should_display_page_title(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyL1NoticeDistributionScreen(pageTitle);
	}

	@Then("the user should display the {string} page title")
	public void the_user_should_display_the_page_title(String pageTitle) throws Throwable {

		cashreconciliationL2page.verifyL2NoticeDistributionScreen(pageTitle);
	}

	@Then("select answer {string} for question - All investor notices have been distributed to relevant parties via ReportPro")
	public void select_answer_for_question_All_investor_notices_have_been_distributed_to_relevant_parties_via_ReportPro(
			String string) throws Throwable {

		cashreconciliationL2page.clickOn_Distributed_toggle();
	}

	@Then("select answer {string} for question - All investor notices have been distributed to the relevant parties")
	public void select_answer_for_question_All_investor_notices_have_been_distributed_to_the_relevant_parties(
			String string) throws Throwable {

		cashreconciliationL2page.clickOn_Toggle_Button2_Yes();
	}

	@Then("select answer {string} for question - All investor notices have been reviewed")
	public void select_answer_for_question_All_investor_notices_have_been_reviewed(String string) throws Throwable {

		cashreconciliationL2page.clickOn_Notice_Toggle__Yes();
	}

	@Then("the user is able to land on the {string} page")
	public void the_user_is_able_to_land_on_the_page(String pageTiltle) throws Throwable {

		cashreconciliationL2page.verifyL2NoticeDistributionScreen(pageTiltle);
	}

	@Then("user should land on the {string} page")
	public void user_should_land_on_the_page(String pageTiltle) throws Throwable {

		cashreconciliationL2page.verifyL2ReconciliationReviewScreen(pageTiltle);
	}

	@Then("select answer {string} for question - Accounting platform has been reviewed for investment")
	public void select_answer_for_question_Accounting_platform_has_been_reviewed_for_investment(String string)
			throws Throwable {

		cashreconciliationL2page.clickOn_accounting_review_toggle();
	}

	@Then("select Yes for Payment has been received")
	public void select_Yes_for_Payment_has_been_received() {
		cashreconciliationL2page.clickOnPaymentReceivedToggle();
	}

	@Then("select Yes for Accounting platform was reviewed")
	public void select_Yes_for_Accounting_platform_was_reviewed() {
		cashreconciliationL2page.clickOnAccReviewToggle();
	}

	@Then("the user is able to land on the page L2 cash reconcilation review - {string}")
	public void the_user_is_able_to_land_on_the_page_L2_cash_reconcilation_review(String title) throws Exception {

		cashreconciliationL2page.verifyL2CashReconcilationReviewTitle(title);
	}

	@Then("the case is resolved and successful message will appeared on the page {string}")
	public void the_case_is_resolved_and_successful_message_will_appeared_on_the_page(String message) throws Exception {

		cashreconciliationL2page.verifySuccessfulMessage(message);
	}

}
