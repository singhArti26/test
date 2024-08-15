package com.areteans.ataf.stepDef;

import com.areteans.ataf.PageObjects.InitiationL1Page;
import com.areteans.ataf.PageObjects.InitiationL2Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Initiation_L2_Stepdef {
	InitiationL2Page logoutpage;
	InitiationL1Page loginpage;

	public Initiation_L2_Stepdef() {
		logoutpage = new InitiationL2Page(TestBase.getDriver());
		logoutpage.sendLogoutObject(logoutpage);
		loginpage = new InitiationL1Page(TestBase.getDriver());
		loginpage.sendLoginObject(loginpage);

	}

	@Given("^Steps for logout in case of failure$")
	public void steps_for_logout_in_case_of_failure() throws Throwable {
		System.out.println("Steps to reproduce:");
		System.out.println("Open the browser and navigate to the url");
		System.out.println("I enter username as 'csinboundagent'");
		System.out.println("I enter password as 'rules'");
		System.out.println("I click on Login button");
		System.out.println("Login should be successful");
		System.out.println("When I click on down arrow");
		System.out.println("I click on Logout");
		System.out.println("Logout should be successful");

	}
	
	@Then("click on Cases To Be Processed")
	public void click_on_cases_to_be_processed() throws Throwable {
		logoutpage.clickOn_CasesToBeProcessed();
		
	}

	@Then("click on {string} work basket")
	public void click_on(String title) throws Throwable {

		logoutpage.clickOn_FSNA_Client_Services_L2(title);
	}

	@Then("the user select the captured case id from the Process Id and click the filtered case")
	public void select_Process_ID_dropdown() throws Throwable {

		logoutpage.clickOn_Process_ID_Dropdown();
		logoutpage.clickOn_ApplyFilter();
		loginpage.enter_process_ID();

		logoutpage.clickOn_Process_ID();
	}
	
	@Then("the user select the captured case id from the Process Id and click the filtered case for client")
	public void select_Process_ID_dropdown_for_client() throws Throwable {

		logoutpage.clickOn_Process_ID_Dropdown();
		logoutpage.clickOn_ApplyFilter();
		loginpage.enter_process_ID();

		logoutpage.clickOn_Process_ID();
	}
	
	@Then("the user select the captured case id from the Process Id in worklist and click the filtered case")
	public void select_Process_ID_dropdown_from_worklist() throws Throwable {

		logoutpage.clickOn_worklist_Process_ID_Dropdown();
		logoutpage.clickOn_ApplyFilter();
		loginpage.enter_process_ID_worklist();

		logoutpage.clickOn_Process_ID_worklist();
	}

	@Then("the user select the captured case id from the Des Process Id and click the filtered case")
	public void select_Process_ID_dropdownDes() throws Throwable {

		logoutpage.clickOn_DesProcess_ID_Dropdown();
		loginpage.enter_process_ID();
		logoutpage.clickOn_Process_ID();
	}

	@Then("the user select the captured case id from the Des Process Id and click fund filtered")
	public void clickonFundFilter() throws Throwable {
		logoutpage.clickOn_DesProcess_ID_Dropdown();
		loginpage.enter_process_ID();
		logoutpage.clickOn_FundFilter();
		logoutpage.clickOn_Process_ID();

	}

	@Then("User verify the Audit History for distribution type as Inkind")
	public void verify_the_Audit_Historyforinkind() throws Throwable {

		loginpage.verifytheAuditHistoryforInkind();

	}

	@Then("user selects {string}")
	public void user_selects(String action) throws Throwable {

		if (action.equalsIgnoreCase("Approve")) {

			logoutpage.clickOn_Approve();

		} else if (action.equalsIgnoreCase("Approve2")) {
			try {
				logoutpage.clickOn_Approve_FOF();

			} catch (Exception e) {
				logoutpage.clickOn_Approve_FOF();
			}

		} else if (action.equalsIgnoreCase("Approve3")) {
			try {
				logoutpage.clickOn_Approve_3();

			} catch (Exception e) {
				logoutpage.clickOn_Approve_3();
			}

		} else if (action.equalsIgnoreCase("Reject")) {
			logoutpage.clickOnReject();
		} else if (action.equalsIgnoreCase("Investor")) {
			logoutpage.clickOnInvestor();
		}

	}

	@Then("the user selects {string}")
	public void the_user_selects(String string) throws Throwable {

		logoutpage.clickOn_Approve_FOF();
	}

	@Then("the user selects thrid {string}")
	public void the_user_selects_3(String string) throws Throwable {

		logoutpage.clickOnReject_3();
	}

	@Then("the user selects second {string}")
	public void the_user_selects_2(String string) throws Throwable {

		logoutpage.clickOnReject_2();
	}

	@Then("then the user clicks on the {string} button,case shall be assigned to Client Services L{int}")
	public void then_the_user_clicks_on_the_button_case_shall_be_assigned_to_Client_Services_L(String submit,
			Integer int1) throws Throwable {
		logoutpage.verifyTaskAssignedToL2(submit);
	}

	@Then("user selects {string} in {string}")
	public void user_selects_in(String string, String string2) throws Throwable {
		logoutpage.clickOnReject();
	}

	@Then("the user clicks on {string} in {string} filed")
	public void the_user_clicks_on_in_filed(String string, String string2) throws Throwable {
		logoutpage.clickOnClient();
	}

	@Then("User enters Reason for rejection {string}")
	public void enter_Reason_for_rejection(String reason) throws Throwable {
		logoutpage.enterReason(reason);
	}

	@Then("User enters Reason for rejection other doc {string}")
	public void enter_Reason_for_rejection2(String reason) throws Throwable {
		logoutpage.enterReason2(reason);
	}

	@Then("the user clicks on {string} in {string}")
	public void the_user_clicks_on_in(String string, String string2) throws Throwable {
		logoutpage.clickOnClientServicesL1();
	}

	@Then("user should land on the {string} initiation screen")
	public void user_should_land_on_the_initiation_screen(String pageTitle) throws Throwable {
		logoutpage.verifyInitiationScreen(pageTitle);
	}

	@Then("the user enters reason")
	public void the_user_enters_reason() throws Throwable {
		logoutpage.enter_reason();
	}

	@Then("the user select the captured case id from the workbasket and click the filtered case")

	public void the_user_select_the_captured_case_id_from_the_workbasket_and_click_the_filtered_case()

			throws Exception {

		logoutpage.clickOnFilterInWorkBasket();

		loginpage.enter_process_ID();

		logoutpage.clickOnWorkBasketFileredID();

	}

	@Then("the user select the captured case id from the workbasket and click the filtered case to priority {string}")
	public void the_user_select_the_captured_case_id_from_the_workbasket_and_click_the_filtered_case_along_with_priority_check(
			String priority) throws Exception {
		
		logoutpage.clickOn_worklist_Process_ID_Dropdown();
		logoutpage.clickOn_ApplyFilter();
		loginpage.enter_process_ID_worklist();
		loginpage.verifythePriority(priority);
		logoutpage.clickOn_Process_ID_worklist();
		
//		logoutpage.clickOn_Process_ID_Dropdown();
//		loginpage.enter_process_ID();
//		
//		logoutpage.clickOn_Process_ID();

	}

	@Then("the user select the captured case id based on Description the workbasket and click the filtered case")

	public void the_user_select_the_captured_case_id_from_Des_the_workbasket_and_click_the_filtered_case()

			throws Exception {

		logoutpage.clickOnFilterInWorkBasketDes();

		loginpage.enter_process_ID();

		logoutpage.clickOnWorkBasketFileredID();

	}

	@Then("User verify the rejects comments from CSL2 {string}")
	public void user_verify_the_rejects_comments_from_csl2(String expRejectComments) throws Exception {
		loginpage.verifyTheRejectcomments(expRejectComments);

	}

	@Then("User verify the rejects comments from AD to client {string}")
	public void user_verify_the_rejects_comments_from_AD(String expRejectComments) throws Exception {
		loginpage.verifyTheRejectcommentstoClient(expRejectComments);

	}

	@Then("the operator accepts the outcome of review")
	public void the_operator_accepts_the_outcome_of_review() throws Exception {
		logoutpage.clickOnApproveForOutcomeOfReview();
	}

	@Then("the operator rejects the confirm decision and approves the outcome of review - error validation check {string} {string}")
	public void the_operator_rejects_the_confirm_decision_and_approves_the_outcome_of_review(String intlCmnts,
			String errorValdtn) throws Exception {
		logoutpage.verifyErrorValidation(intlCmnts, errorValdtn);

	}

	@Then("the user veriy the captured case id from the Process Id and click the filtered case")
	public void verify_Process_ID_dropdown() throws Throwable {

		logoutpage.clickOn_Process_ID_Dropdown();
		loginpage.enter_process_ID();
	}

	@Then("the user get Process Id in work list or work basket and click the filtered case")
	public void click_Process_ID() throws Throwable {

		logoutpage.clickOn_Process_ID();
	}

	@Then("the operator rejects the outcome of review")
	public void the_operator_rejects_the_outcome_of_review() throws Exception {
		logoutpage.clickOnRejectForOutcomeOfReview();
	}

	@Then("provide the reject reason as {string}")
	public void provide_the_reject_reason(String reason) throws Exception {
		logoutpage.enterRejectReason(reason);
	}

	@Then("Assign to Client Services L1 operator")
	public void Assign_to_operator() throws Exception {
		logoutpage.assignToOperator();
	}

	@Then("approve external comments")
	public void approve_external_comments() throws Exception {
		logoutpage.approveExternalComments();
	}

	@Then("the operator rejects the confirm decision and approves the outcome of review - error validation check {string} {string} - DIP")
	public void the_operator_rejects_the_confirm_decision_and_approves_the_outcome_of_review_DIP(String intlCmnts,
			String errorValdtn) throws Exception {
		logoutpage.verifyErrorValidationDIP(intlCmnts, errorValdtn);

	}

	@Then("the operator rejects the outcome of review - DI")
	public void the_operator_rejects_the_outcome_of_review_DI() throws Exception {
		logoutpage.clickOnRejectForOutcomeOfReviewDI();
	}

	@Then("the operator rejects the outcome of review - FOFcp")
	public void the_operator_rejects_the_outcome_of_review_FOFcp() throws Exception {
		logoutpage.clickOnRejectForOutcomeOfReviewFOF();
	}

	@Then("the operator rejects the outcome of review - FOFclbck")
	public void the_operator_accepts_the_outcome_of_review_FOFclbck() throws Exception {
		logoutpage.clickOnRejectForOutcomeOfReviewFOFclbck();
	}
	
	@Then("the operator accepts the outcome of review - FOFcp")
	public void the_operator_accepts_the_outcome_of_review_FOFcp() throws Exception {
		logoutpage.clickOnApproveForOutcomeOfReviewFOFcp();
	}
	
	@Then("user selects {string} in second fund")
	public void user_selects_approve_in_second_fund(String s) throws Exception {
		logoutpage.selectsApproveSecondFund();
	}

}
