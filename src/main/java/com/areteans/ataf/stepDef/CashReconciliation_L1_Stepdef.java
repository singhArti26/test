package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CashReconciliationL1Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class CashReconciliation_L1_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;
	CashReconciliationL1Page cashreconciliationL1page;

	public CashReconciliation_L1_Stepdef() {
		cashreconciliationL1page = new CashReconciliationL1Page(TestBase.getDriver());
		cashreconciliationL1page.sendLogoutObject(cashreconciliationL1page);
	}

	@Then("user should display {string} page title")
	public void user_should_display_page_title(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyInitiationScreen(pageTitle);
	}

	@Then("user clicks on {string}")
	public void user_clicks_on(String string) throws Throwable {
		cashreconciliationL1page.clickOn_Paid_In_Full_Checkbox();
	}

	@Then("the user should click {string} on toggle button {string}")
	public void the_user_should_click_on_toggle_button(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_toggle();
	}

	@Then("User should click {string} on frist toggle button {string}")
	public void the_user_should_click_on_toggle_button1(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_firsttoggle();
	}

	@Then("User should click {string} on  frist toggle button {string}")
	public void the_user_should_click_on_toggle_buttonrr(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_firsttoggle1();
	}

	@Then("User should click {string} on client toggle button {string}")
	public void the_user_should_click_on_toggle_button4(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_clienttoggle();
	}

	@Then("User should click {string} on second toggle button {string}")
	public void the_user_should_click_on_toggle_button2(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_secondtoggle();
	}

	@Then("User should click {string} on  second toggle button {string}")
	public void the_user_should_click_on_toggle_buttonsed(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_secondtoggle2();
	}

	@Then("User should click {string} on thrid toggle button {string}")
	public void the_user_should_click_on_toggle_button3(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_thridtoggle();
	}

	@Then("User should click {string} on  thrid toggle button {string}")
	public void the_user_should_click_on_toggle_buttongh(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_thridtoggle3();
	}

	@Then("User should click {string} on external toggle button {string}")
	public void the_user_should_click_on_toggle_buttonex(String string, String string2) throws Exception {
		cashreconciliationL1page.clickOn_externaltoggle();
	}

	@Then("the user is able to land on the page {string}")
	public void the_user_is_able_to_land_on_the_page(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyReconciliationScreen(pageTitle);
	}

	@Then("user is able to land on the page {string}")
	public void user_is_able_to_land_on_the_page(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyPaymentPreparationScreen(pageTitle);
	}

	@Then("the user is able to land on the page {string} screen")
	public void the_user_is_able_to_land_on_the_page_screen(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyInvestorWireInstructionScreen(pageTitle);
	}

	@Then("select answer {string} for question - Payment\\(s) have been set up on banking platform")
	public void select_answer_for_question_Payment_s_have_been_set_up_on_banking_platform(String string)
			throws Throwable {

		cashreconciliationL1page.clickOn_toggle_button();
	}

	@Then("the user click on {string} workbasket")
	public void the_user_click_on_workbasket(String workbasket) throws Throwable {

		cashreconciliationL1page.sendLogoutObject(cashreconciliationL1page);
		cashreconciliationL1page.click_On_workbasket_COPP_L1(workbasket);
	}

	@Then("user is able to display {string} page title")
	public void user_is_able_to_display_page_title(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyPaymentReconciliationScreen(pageTitle);
	}

	@Then("select answer {string} for question - Payment\\(s) have been executed")
	public void select_answer_for_question_Payment_s_have_been_executed(String string) throws Throwable {

		cashreconciliationL1page.clickOn_Payments1_toggle();

	}

	@Then("select answer {string} for question - Accounting platform has been updated for payment\\(s)")
	public void select_answer_for_question_Accounting_platform_has_been_updated_for_payment_s(String string)
			throws Throwable {

		cashreconciliationL1page.clickOn_Payments2_toggle();
	}

	@Then("select failed payment\\(s)")
	public void select_failed_payment_s() throws Throwable {

		cashreconciliationL1page.clickOn_Failed_Payments_Checkbox();

	}

	@Then("the user should display pagetitle is {string}")
	public void the_user_should_display_pagetitle_is(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyNoticeDistributionScreen(pageTitle);
	}

	@Then("select answer {string} for question - All investor notices were uploaded to the relevant portal")
	public void select_answer_for_question_All_investor_notices_were_uploaded_to_the_relevant_portal(String string)
			throws Throwable {

		cashreconciliationL1page.clickOn_NoticeDistribution_toggle();
	}

	@Then("user should land on pagetitle {string} screen")
	public void user_should_land_on_pagetitle_screen(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyL1ReconciliationScreen(pageTitle);
	}

	@Then("select answer {string} for question - Accounting platform has been updated for investment")
	public void select_answer_for_question_Accounting_platform_has_been_updated_for_investment(String string)
			throws Throwable {

		cashreconciliationL1page.clickOn_accounting_review_toggle();
	}

	@Then("the user should land on {string} title")
	public void the_user_should_land_on_title(String pageTitle) throws Throwable {

		cashreconciliationL1page.verifyExecutedDocumentsReview(pageTitle);
	}

	@Then("select Yes for Cash collection and reconciliation completed")
	public void select_Yes_for_Cash_collection_and_reconciliation_completed() throws Throwable {

		cashreconciliationL1page.selectYesForCashRecon();
	}

	@Then("select Yes for Accounting platform was updated correctly")
	public void select_Yes_for_Acc_platform() throws Throwable {

		cashreconciliationL1page.selectYesForAccPlatform();
	}

	@Then("the user is able to land on the page L1 cash reconcilation - {string}")
	public void the_user_is_able_to_land_on_the_page_L1_cash_reconcilation(String title) throws Exception {

		cashreconciliationL1page.verifyL1CashReconcilationTitle(title);

	}

	@Then("User Please reconcile cash and validate and provide support {string}")
	public void the_user_is_able_to_land_on_the_page_L1_cash_reconcilation1(String title) throws Exception {

		cashreconciliationL1page.enterL1CashReconcilationsupport(title);

	}

	@Then("User enter and validate and client description {string}")
	public void the_user_is_able_to_land_on_the_page_L1_cash_reconcilation2(String title) throws Exception {

		cashreconciliationL1page.enterL1CashReconcilationsupport1(title);

	}

	@Then("select answer {string} for L1 accounting platform - All the payments above were set up on the banking platform")
	public void select_answer_for_L1_accounting_platform(String s1) throws Exception {

		cashreconciliationL1page.selectYesL1BankingPlatformToggle(s1);
	}

	@Then("select {string} for L1 payment release - Payment has been released from banking platform")
	public void select_answer_for_L1_All_the_payments_were_successfully_released(String s1) throws Exception {

		cashreconciliationL1page.selectYesL1PaymentReleaseToggle(s1);
	}

	@Then("User select the open check list and validate and provide support")
	public void select_answer_for_L1_All_the_payments_were_successfully_support() throws Exception {

		cashreconciliationL1page.clickandSelectAllOpencheck();
	}

	@Then("User select the open check list for reconcile cash and validate and provide support at CSL2")
	public void select_answer_for_L1_All_the_payments_were_successfully_supportL() throws Exception {

		cashreconciliationL1page.clickandSelectAllOpencheckL2();
	}

	@Then("User select the open check list for reconcile cash and validate and provide support L1 Capital Activity")
	public void select_answer_for_L1_All_the_payments_were_successfully_supportLCapitalActivity() throws Exception {

		cashreconciliationL1page.clickandSelectAllOpencheckCapitalActivity();
	}

	@Then("User select the open check list for reconcile cash and validate and provide support L1 book accruals")
	public void select_answer_for_L1_All_the_payments_were_successfully_supportbookaccruals() throws Exception {

		cashreconciliationL1page.clickandSelectAllOpencheckbookaccruals();
	}

	@Then("User selecting Please funds that require draft reporting to the client")
	public void select_draft_reporting() throws Exception {

		cashreconciliationL1page.chkDraftreportingrequired1();
	}

}
