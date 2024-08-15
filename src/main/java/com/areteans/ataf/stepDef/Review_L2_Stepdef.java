package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.ReviewL2Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class Review_L2_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;

	ReviewL2Page reviewL2page;

	public Review_L2_Stepdef() {
		
		reviewL2page = new ReviewL2Page(TestBase.getDriver());
		reviewL2page.sendLogoutObject(reviewL2page);
	}

	@Then("user should display the {string} page and click on {string}")
	public void user_should_display_the_page_and_click_on(String pageTitle, String approve) throws Throwable {

		reviewL2page.verifyInitiationScreen(pageTitle, approve);
	}

	@Then("the user is able to land on the page call back review - {string}")
	public void the_user_is_able_to_land_on_the_page_call_back_review(String title) throws Exception {

		reviewL2page.verifyL2CallBackReviewTitle(title);
	}

	@Then("confirm the decision by clicking on {string}")
	public void confirm_the_decision_by_clicking_on(String ans) throws Exception {
		reviewL2page.clickOnApprove(ans);
	}

	@Then("the user is able to land on the page L2 Expense Payment Processing Review - {string}")
	public void the_user_is_able_to_land_on_the_page_L2_Expense_Payment_Processing_Review(String title)
			throws Exception {

		reviewL2page.verifyL2ExpensePaymentProcessingReviewTitle(title);
	}

	@Then("select answer {string} for the question - All the payments above were set up on the banking platform")
	public void select_answer_for_the_question_All_the_payments_above_were_set_up_on_the_banking_platform(String string)
			throws Exception {

		reviewL2page.clickOntoggle2();

	}

	@Then("the user is able to land on the page L2 Expense Payment Processing Review and Release - {string}")
	public void the_user_is_able_to_land_on_the_page_L2_Expense_Payment_Processing_Review_and_Release(String title)
			throws Exception {

		reviewL2page.verifyL2ExpensePaymentProcessingReviewAndReleaseTitle(title);
	}

	@Then("select answer {string} for question - L2 {string}")
	public void select_answer_for_payments_above_were_set_up_on_the_banking_platform(String s1, String s2)
			throws Exception {

		reviewL2page.clickOnBankingPlatformToggle(s1);
	}

	@Then("select {string} for - L2 Payment has been released from banking platform")
	public void select_answer_for_payment_release(String ans) throws Exception {

		reviewL2page.clickOnPaymentReleaseToggle(ans);
	}

	@Then("check the toggles if they are disabled")
	public void check_the_toggles_if_it_is_disabled() throws Exception {
		reviewL2page.checkIfBankingPlatformAndCallBackTogglesAreDisabled();
	}

	@Then("check if toggle is disabled for banking platform")
	public void check_if_toggle_is_disabled_for_banking_platform() throws Exception {
		reviewL2page.checkIfBankingPlatformIsDisabled();
	}

	@Then("provide the reject reason as {string} - FOF Capital")
	public void provide_the_reject_reason(String cmnts) throws Exception {
		reviewL2page.provideRejectReason(cmnts);
	}

	@Then("provide the payment reject reason as {string} - FOF Capital")
	public void provide_the_payment_reject_reason(String cmnts) throws Exception {
		reviewL2page.providePaymentRejectReason(cmnts);
	}

	@Then("verify payment error message - {string}")
	public void verify_payment_error_message(String message) throws Exception {
		reviewL2page.verifyPaymentErrorMessage(message);
	}

	@Then("select answer Yes for question - Please review that all the payments above were correctly set up on the banking platform")
	public void review_All_Payments() throws Exception {
		reviewL2page.reviewAllPayments();
	}
	
	@Then("provide the reason as {string} - {string}")
	public void provide_the_reason(String cmnts,String process) throws Exception {
		reviewL2page.provideReason(cmnts);
	}
	
	@Then("check the toggles if they are disabled - DIP")
	public void check_the_toggles_if_it_is_disabled_DIP() throws Exception {
		reviewL2page.checkIfBankingPlatformAndCallBackTogglesAreDisabled_DIP();
	}
	
	@Then("check if toggle is disabled for banking platform - DIP")
	public void check_if_toggle_is_disabled_for_banking_platform_DIP() throws Exception {
		reviewL2page.checkIfBankingPlatformIsDisabledDIP();
	}
	
	@Then("select answer Yes for question - Please review that all the payments above were correctly set up on the banking platform - DIP")
	public void review_All_Payments_DIP() throws Exception {
		reviewL2page.reviewAllPaymentsDIP();
	}
	
	@Then("verify payment error message - {string} - DIP")
	public void verify_payment_error_message_DIP(String message) throws Exception {
		reviewL2page.verifyPaymentErrorMessageDIP(message);
	}
}
