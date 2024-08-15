package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
//import com.areteans.ataf.PageObjects.initiationclientpage;
import com.areteans.ataf.PageObjects.InitiationClientPage;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Initiation_Client_Stepdef {

	InitiationClientPage payment_data;

	SeleniumFunNonPega seleniumFunNonPega;
	InitiationClientPage initiationclientpage;

	public Initiation_Client_Stepdef() {
		initiationclientpage = new InitiationClientPage(TestBase.getDriver());
		initiationclientpage.sendLogoutObject(initiationclientpage);
	}

	@Then("the user click on the {string}")
	public void the_user_click_on_the(String Create) throws Throwable {

		initiationclientpage.clickOnCreatebtn(Create);
	}

	@Then("the user should check Capital Activity {string}")
	public void the_user_should_check_Capital_Activity(String caseID) throws Throwable {

		initiationclientpage.verifyCaseID(caseID);
	}

	@Then("the user clicks on {string} under {string}")
	public void the_user_clicks_on_under(String percentage, String filed) throws Throwable {

		initiationclientpage.clickOnPercentage(percentage, filed);
	}

	@Then("the user enters percentage under {string}")
	public void the_user_enters_percentage_under(String filed) throws Throwable {
		initiationclientpage.enterPercentage(filed);
	}

	@Then("the user enters {string} on Initiation Page")
	public void the_user_enters_comments(String comments) throws Throwable {

		initiationclientpage.enterComments(comments);
	}

	@Then("the user enters {string} on Explanation")
	public void the_user_enters_comments2(String comments) throws Throwable {

		initiationclientpage.enterExplanation(comments);
	}

	@Then("the user should land on {string}")
	public void the_user_should_land_on(String pageTitle) throws Throwable {

		initiationclientpage.verifySummaryScreen(pageTitle);
	}

	@Then("the user is able to land on page {string}")
	public void the_user_is_able_to_land_on_page(String pageTitle) throws Throwable {

		initiationclientpage.verify_PageTitle(pageTitle);
	}

	@Then("then click on the Resolution dropdown and select the {string}")
	public void then_click_on_the_Resolution_dropdown_and_select_the(String selectDropDown) throws Throwable {

		initiationclientpage.selectResolutionDropDown(selectDropDown);
	}

	@Then("the user enters comment on {string} page")
	public void the_user_enters_comment_on_page(String string) throws Throwable {

		initiationclientpage.enterCommentsOnResolutionPage();
	}

	@Then("select answer {string} for question - Is this a new investment?")
	public void select_answer_for_question_Is_this_a_new_investment(String string) throws Throwable {

		initiationclientpage.selectYesNewInvestment();
	}

	@Then("the user enter {string}")
	public void the_user_enter(String invName) throws Throwable {

		initiationclientpage.enterInvestmentName(invName);
	}

	@Then("select {string} from {string} dropdown")
	public void select_from_dropdown(String selectDropdown, String commitment) throws Throwable {

		initiationclientpage.selectCurrencyOfCommitment(selectDropdown, commitment);
	}

	@Then("the user clicks on {string} button for save details")
	public void the_user_clicks_on_button_for_save_details(String string) throws Throwable {

		initiationclientpage.clickOnSaveButton();
	}

	@Then("the user click on {string} button for {string}")
	public void the_user_click_on_button_for(String OK, String title) throws Throwable {

		initiationclientpage.clickOnOkButton(OK, title);
	}

	@Then("the user click on the {string} button")
	public void the_user_click_on_the_button(String string) throws Throwable {

		initiationclientpage.clickOnCancelButton();
	}

	@Then("the user should verify fund {string}")
	public void the_user_should_verify_fund(String fundName) throws Throwable {

		initiationclientpage.verifyFundName(fundName);
	}

	@Then("the user should verify investment name {string}")
	public void the_user_should_verify_investment_name(String investmentName) throws Throwable {

		initiationclientpage.verifyInvestmentName(investmentName);
	}

	@Then("the user should verify purchase agreement {string}")
	public void the_user_should_verify_purchase_agreement(String executed) throws Throwable {

		initiationclientpage.verifyPurchaseAgreementExected(executed);
	}

	@Then("the user enters name of package {string} with value {string}")
	public void the_user_enters_name_of_package_with_value(String elementKey, String value) throws Exception {
		initiationclientpage.enterPackageName(value);
	}

	@Then("the user enters the {string} that needs to be attached")
	public void the_user_adds_the_Number_of_invoices(String noOfInvoices) throws Exception {
		initiationclientpage.enterTheNumberOfInvoices(noOfInvoices);
	}

	@Then("the user click on the {string} dropdown and Select the value for fund {string}")
	public void the_user_click_on_the_dropdown_and_Select_the_value_for_fund(String fundDropdown, String fundName)
			throws Exception {
		initiationclientpage.selectTheFund(fundDropdown, fundName);
	}

	@Then("upload the {string} and change file type to {string} {string}")
	public void upload_the_document_and_change_file_type_to(String file, String type1, String type2) throws Exception {

		initiationclientpage.clickOnUploadButton(file, type1, type2);

	}

	@Then("the {string} should get displayed after the {string} button clicked.")
	public void the_should_get_displayed_after_the_button_clicked(String message, String submit) throws Exception {

		initiationclientpage.verifySuccessfullMessage(message, submit);
	}

	@And("click on refresh from Actions {string}")
	public void click_on_refresh_from_Actions(String status) throws Exception {

		initiationclientpage.clickRefresh(status);
	}

	@Then("the user should land on expense payment initiation {string} screen")
	public void the_user_should_land_on_expense_payment_initiation_screen(String value) throws Exception {

		initiationclientpage.verifyInitiationScreen(value);

	}

	@Then("upload the {string} and change file type to {string} client")
	public void upload_the_document_and_change_file_type_client(String file, String type1) throws Exception {

		initiationclientpage.clickOnUploadButtonForRejectedInvoice(file, type1);

	}

	@Then("verify page title {string}")
	public void verify_page_title(String ekey) throws Exception {
		initiationclientpage.verifyExpensePaymentTitle(ekey);
	}

	@Then("Select answer {string} for question Are any invoices paid by more than one fund")
	public void select_answer_for_question_Are_any_invoices_paid_by_more_than_one_fund(String string) throws Exception {

		initiationclientpage.selectAnswer();

	}

	@Then("the user should land on {string} exp screen")
	public void the_user_should_land_on_screen(String value) throws Exception {

		initiationclientpage.verifyInitiationScreenExpPaymnt(value);

	}

	@And("click on refresh from Actions")
	public void click_on_refresh_from_Actions() throws Exception {

		initiationclientpage.clickRefresh();
	}

}
