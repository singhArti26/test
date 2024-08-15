package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CommonPage;
import com.areteans.ataf.PageObjects.InitiationL1Page;
import com.areteans.ataf.PageObjects.InitiationL2Page;
import com.areteans.ataf.PageObjects.PreparationL1Page;
import com.areteans.ataf.PageObjects.PreparationL2Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class Preparation_L2_Stepdef {
	SeleniumFunNonPega seleniumFunNonPega;
	PreparationL1Page l2_reviewpage;
	CommonPage homepage;
	InitiationL1Page loginpage;
	InitiationL2Page logoutpage;
	PreparationL2Page preparationL2page;

	/**
	 * 
	 */
	public Preparation_L2_Stepdef() {
		preparationL2page = new PreparationL2Page(TestBase.getDriver());

	}

	@Then("the user should display the {string} page and click on {string}")
	public void the_user_should_display_the_page_and_click_on(String pageTitle, String approve) throws Throwable {

		preparationL2page.verifyInitiationScreen(pageTitle, approve);
	}

	@Then("the user should display the {string} page and click on {string} option")
	public void the_user_should_display_the_page_and_click_on_option(String pageTitle, String reject) throws Throwable {

		preparationL2page.verifyInitiationScreenAndReject(pageTitle, reject);
	}

	@Then("the user enter reason for rejection")
	public void the_user_enter_reason_for_rejection() throws Throwable {

		preparationL2page.enterReason();
	}

	@Then("the user enters {string} filed")
	public void the_user_enters_filed(String internal) throws Throwable {

		preparationL2page.enter_internal_filed(internal);
	}

	@Then("the user clicks on {string} toggle button")
	public void the_user_clicks_on_toggle_button(String approve) throws Throwable {

		preparationL2page.click_On_Approve_toggleButton(approve);
	}

	@Then("the user clicks on the {string}")
	public void the_user_clicks_on_the(String submit) throws Throwable {

		preparationL2page.click_On_Submit(submit);
	}

	@Then("verify {string},{string},{string} and	{string}")
	public void verify_and(String filed1, String filed2, String filed3, String filed4) throws Throwable {
		preparationL2page.verify_investor_List_filed(filed1, filed2, filed3, filed4);
	}

	@Then("the user clicks on the {string} button in {string} page")
	public void the_user_clicks_on_the_button_in_page(String string, String string2) throws Throwable {

		preparationL2page.click_On_Submit_SummaryPage();
	}

	@Then("the user is able to display the {string} page title")
	public void the_user_is_able_to_display_the_page_title(String pageTitle) throws Throwable {

		preparationL2page.verifyL2CallBackReviewScreen(pageTitle);
	}

	@When("the user clicks on the the workbasket {string} option")
	public void the_user_is_be_able_to_click_on_the_the_workbasket_option(String string) throws Exception {

		preparationL2page.clickOnWorkBench(string);
	}

	@Then("the user is able to land on the page L2 expense payment preparation - {string}")
	public void the_user_is_able_to_land_on_the_page_L2(String title) throws Exception {

		preparationL2page.verifyExpensePaymentPreparationTitleL2(title);
	}

	@Then("the user should be able to click on the dropDown to {string} and select {string}")
	public void the_user_should_be_able_to_click_on_the_dropDown_to_and_select(String string, String value)
			throws Exception {
		preparationL2page.selectDropDownValue(string, value);
	}
	

	@Then("the user should be able to click on the dropDown to {string} and select {string} for Invoice Two")
	public void the_user_should_be_able_to_click_on_the_dropDown_to_and_select_for_Invoice_Two(String string,
			String string2) throws Exception {
		preparationL2page.selectDropDownValueForSecondInvoice(string, string2);
	}

	@And("error message is displayed stating {string}")
	public void And_error_message_is_displayed(String msg) throws Exception {
		preparationL2page.verifyErrorMessage(msg);
	}
	
	@And("user clicks on next fund tab")
	public void user_clicks_on_next_fund_tab() throws Exception {
		preparationL2page.clickOnNxtFundTab();
	}
}