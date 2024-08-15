package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.ReviewL1Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class Review_L1_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;

	ReviewL1Page reviewL1page;

	/**
	 * 
	 */
	public Review_L1_Stepdef() {
		
		reviewL1page = new ReviewL1Page(TestBase.getDriver());
		reviewL1page.sendLogoutObject(reviewL1page);

	}

	@Then("user should display {string} page")
	public void user_should_display_page(String pageTitle) throws Throwable {

		reviewL1page.verify_Investor_Wire_Instruction_Pagetitle(pageTitle);
	}

	@Then("the user should display {string} pagetitle")
	public void the_user_should_display_pagetitle(String pageTitle) throws Throwable {

		reviewL1page.verify_Notice_Preparation_Pagetitle(pageTitle);
	}

	@Then("the user should display {string} title")
	public void the_user_should_display_title(String pageTitle) throws Throwable {

		reviewL1page.verify_Notice_Preparation_Pagetitle(pageTitle);
	}

	@Then("the user should display the pagetitle {string} page")
	public void the_user_should_display_the_pagetitle_page(String pageTitle) throws Throwable {

		reviewL1page.verify_Notice_Preparation_Pagetitle(pageTitle);
	}

	@Then("the user should upload the notices Documents")
	public void the_user_should_upload_the_notices_Documents() throws Throwable {

		reviewL1page.clickOn_Upload_Document();
	}

	@Then("select answer {string} for question - The wire instructions are up to date")
	public void select_answer_for_question_The_wire_instructions_are_up_to_date(String string) throws Throwable {

		reviewL1page.clickOn_toggleYes();
	}

	@Then("user should display the {string}")
	public void user_should_display_the(String pageTitle) throws Throwable {

		reviewL1page.verify_pageTitle(pageTitle);
	}
	
	@Then("verify reject comments {string} provided by previous operator")
	public void verify_reject_comments(String cmnts) throws Throwable {

		reviewL1page.verifyRejectComments(cmnts);
	}
	
	@Then("select Yes - All the payments were successfully released")
	public void select_Yes_All_the_payments_were_successfully_released() throws Throwable {

		reviewL1page.selectYesForPaymentReleaseToggle();
	}
	
	@Then("select Yes - The accounting platform has been updated to reflect the payments")
	public void select_Yes_Accounting_platform_Update() throws Throwable {

		reviewL1page.selectYesForAccountingPlatformToggle();
	}
	
	@Then("select Yes - All the payments were successfully released - DIP")
	public void select_Yes_All_the_payments_were_successfully_released_DIP() throws Throwable {

		reviewL1page.selectYesForPaymentReleaseToggleDIP();
	}
	
	@Then("select Yes - The accounting platform has been updated to reflect the payments - DIP")
	public void select_Yes_Accounting_platform_Update_DIP() throws Throwable {

		reviewL1page.selectYesForAccountingPlatformToggleDIP();
	}

	@Then("select Yes - The accounting platform has been reviewed to reflect the payments - DIP")
	public void select_Yes_Accounting_platform_Review_DIP() throws Throwable {

		reviewL1page.selectYesForAccountingPlatformReviewToggleDIP();
	}
}
