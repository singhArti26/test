package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.PreparationCOISL1Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class Preparation_COIS_L1_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;
	PreparationCOISL1Page preparationCOISL1page;

	public Preparation_COIS_L1_Stepdef() {
		preparationCOISL1page = new PreparationCOISL1Page(TestBase.getDriver());
	}

	@Then("the user click on {string}")
	public void the_user_click_on(String workbasket) throws Throwable {

		preparationCOISL1page.click_On_workbasket_COIS_L1(workbasket);
	}

	@Then("user should land on the {string} screen")
	public void user_should_land_on_the_screen(String pageTitle) throws Throwable {

		preparationCOISL1page.verifyL1KYCScreen(pageTitle);
	}

	@Then("the user should land on {string} screen pagetitle")
	public void the_user_should_land_on_screen_pagetitle(String pageTitle) throws Throwable {

		preparationCOISL1page.verifyInvestorRegistryConfirmationScreen(pageTitle);
	}

	@Then("user should land on {string} screen")
	public void user_should_land_on_screen(String pageTitle) throws Throwable {

		preparationCOISL1page.verify_KYC_Investor_Registry_Pagetitle(pageTitle);
	}

	@Then("click {string} on the toggle button {string}")
	public void click_on_the_toggle_button(String string, String string2) throws Throwable {

		preparationCOISL1page.clickOn_KYC_toggleYes();
	}

	@Then("the user click {string} on toggle button {string}")
	public void the_user_click_on_toggle_button(String string, String string2) throws Throwable {

		preparationCOISL1page.clickOn_investor_registry_toggleYes();
	}

	@Then("click {string} on toggle button {string}")
	public void click_on_toggle_button(String string, String string2) throws Throwable {

		preparationCOISL1page.clickOn_investor_registry_toggleYes();
	}

	@Then("the user should upload Document\\(s)")
	public void the_user_should_upload_Document_s() throws Throwable {

		preparationCOISL1page.upload_Documents();
	}

	@Then("the user should land on {string} screen")
	public void the_user_should_land_on_screen(String pageTitle) throws Throwable {

		preparationCOISL1page.verify_Initiation_Screen(pageTitle);
	}

	@Then("the user should land on {string} screen page")
	public void the_user_should_land_on_screen_page(String pageTitle) throws Throwable {

		preparationCOISL1page.verify_KYC_ComfortLetter_Screen(pageTitle);
	}

	@Then("select answer {string} for question - All investors are AML\\/KYC cleared")
	public void select_answer_for_question_All_investors_are_AML_KYC_cleared(String string) throws Throwable {

		preparationCOISL1page.clickOn_comfortletter_toggleYes();
	}

	@Then("select answer {string} for question - Comfort Letter is still valid")
	public void select_answer_for_question_Comfort_Letter_is_still_valid(String string) throws Throwable {

		preparationCOISL1page.click_On_comfortletter_toggleYes();
	}

}
