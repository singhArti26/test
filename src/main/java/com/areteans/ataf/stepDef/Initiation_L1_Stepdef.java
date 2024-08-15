package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CommonPage;
import com.areteans.ataf.PageObjects.InitiationL1Page;
import com.areteans.ataf.PageObjects.InitiationL2Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Initiation_L1_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;
	InitiationL1Page loginpage;
	InitiationL2Page logoutpage;
	CommonPage homepage;

	public Initiation_L1_Stepdef() {
		loginpage = new InitiationL1Page(TestBase.getDriver());
		loginpage.sendLoginObject(loginpage);
		logoutpage = new InitiationL2Page(TestBase.getDriver());
		logoutpage.sendLogoutObject(logoutpage);
		homepage = new CommonPage(TestBase.getDriver());

	}

	@When("the user clicks on {string} button")
	public void the_user_clicks_on_button(String Signin) throws Throwable {

		loginpage.clickOnLoginbtn(Signin);

	}

	@Then("the user click on the {string}\\/create icon")
	public void the_user_click_on_the_create_icon(String Create) throws Throwable {

		loginpage.clickOnCreatebtn(Create);
	}

	@Then("the user clicks on PortalNavHeader")
	public void the_user_clicks_on_PortalNavHeader() throws Exception {

		loginpage.clickOnPortalNavHeader();

	}

	@Then("the user clicks on Close PortalNavHeader")
	public void the_user_clicks_on_Close_PortalNavHeader() throws Exception {

		loginpage.clickOnClosePortalNavHeader();

	}

	@Then("the user clicks on {string} plusIcon")
	public void the_user_clicks_on_plusIcon(String string) throws Exception {

		loginpage.clickOnCreateIcon(string);

	}
	
	@Then("the user clicks on {string} plusIcon for client")
	public void the_user_clicks_on_plusIcon_for_client(String string) throws Exception {

		loginpage.clickOnClientCreateIcon(string);

	}

	@Then("the user click on {string} button")
	public void the_user_click_on_button(String btn) throws Exception {
		loginpage.clickOnFoFCommitment(btn);
	}

	public void the_user_should_click_on_button(String btn) throws Throwable {
		loginpage.clickOnCapitalActivity(btn);
	}

	@Then("the user should click on process name {string}")
	public void the_user_should_click_processName(String processname) throws Throwable {
		switch (processname) {
		case "Capital Activity":
			loginpage.clickOnCapitalActivity(processname);
			break;
		case "Direct Investment Purchase":
			loginpage.clickOnDirectInvPurchase(processname);
			break;
		case "Direct Investment Sale":
			loginpage.clickOnCapitalActivity(processname);
			break;
		case "Expense Payment":
			loginpage.clickOnExpensePayment(processname);
			break;
		case "FOF Capital Call":
			loginpage.clickOnFOFCaptitalCall(processname);
			break;
		case "FOF Commitment":
			loginpage.clickOnFOFCommitment(processname);
			break;
		case "FOF Distribution":
			loginpage.clickOnFOFDistribution(processname);
			break;
		case "Transfer":
			loginpage.clickOnTransfer(processname);
			break;
		case "Repository":
			loginpage.clickOnRepository(processname);
			break;
		case "Period End Reporting":
			loginpage.clickOnlnkPeriodEndReporting(processname);
			break;

		default:
			System.out.println("User not able to find the process which he is expecting");
			break;
		}

	}

	@Then("the user selects use template option {string}")
	public void the_user_can_selectTheUserTemplate(String crossProcess) throws Throwable {
		loginpage.useTemplate(crossProcess);
	}

	@Then("the user can check Capital Activity {string}")
	public void the_user_can_check_Capital_Activity(String caseID) throws Throwable {
		loginpage.verifyCaseID(caseID);
	}

	@Then("the user can get the {string}")
	public void the_user_can_get_caseID(String caseID) throws Throwable {
		loginpage.verifyCaseID(caseID);
	}

	@Then("the user should land on the {string} screen")
	public void the_user_should_land_on_the_screen(String pageTitle) throws Exception {
		loginpage.verifyInitiationScreen(pageTitle);
	}

	@Then("User wants to transfer the case to {string} for that select {string} from actions dropdown")
	public void the_User_transfer_the_case_otherCSL2(String transferTo, String croprocess) throws Exception {
		loginpage.transferAssagiment(transferTo, croprocess);
	}

	@Then("User wants to cancel the request {string} for that select {string} from actions dropdown")
	public void the_User_cancelrequest_the_case_otherCSL2(String cancelReason, String croprocess) throws Exception {
		loginpage.cancelRequest(cancelReason, croprocess);
	}

	@Then("User can assign the Priority selected case using the option like {string} from actions dropdown")
	public void the_User_assign_priority(String croprocess) throws Exception {
		loginpage.assignpriortyFromCSL2(croprocess);
	}

	@Then("verify that Priority status as {string} after assign priority at CSL2")
	public void the_User_verify_assign_priority(String croprocess) throws Exception {
		loginpage.verifythePriority(croprocess);
	}

	@Then("then click on the {string} dropdown and select the {string}")
	public void then_click_on_the_dropdown_and_select_the_FUnd(String fundDropdown, String fundName) throws Throwable {
		loginpage.selectTheFund(fundDropdown, fundName);

	}
	
	@Then("then click on the {string} dropdown and select the {string} for FOFcommitment")
	public void then_click_on_the_dropdown_and_select_the_FUnd_for_FOFcommitment(String fundDropdown, String fundName) throws Throwable {
		loginpage.selectTheFundForFOFcommitment(fundDropdown, fundName);

	}

	@Then("then click on the {string} dropdown and select the {string} - REP")
	public void then_click_on_the_dropdown_and_select_the_FUnd_REP(String fundDropdown, String fundName)
			throws Throwable {
		loginpage.selectTheFund_REP(fundDropdown, fundName);

	}

	@Then("then click on the {string} dropdown and select the multi {string}")
	public void then_click_on_the_dropdown_and_select_the_FUndmulti(String fundDropdown, String fundName)
			throws Throwable {
		loginpage.selectTheMultiyFund(fundDropdown, fundName);

	}

	@Then("then click on the {string} dropdown and select the Applicable timetable {string}")
	public void then_click_on_the_dropdown_and_select_the_Applicabletimetable(String fundDropdown, String fundName)
			throws Throwable {
		loginpage.selectTheApplicabletimetable(fundDropdown, fundName);

	}

	@Then("select the toggle {string} - PER")
	public void select_the_toggle_fin_statemnts(String toggle) throws Throwable {
		loginpage.selectToggleFinStatements(toggle);

	}

	@Then("then click on the {string} dropdown and select the multi2 {string}")
	public void then_click_on_the_dropdown_and_select_the_FUndmulti2(String fundDropdown, String fundName)
			throws Throwable {
		loginpage.selectTheMultiyFund(fundDropdown, fundName);

	}

	@Then("then click on the {string} dropdown and select the {string} for Fund Level Checklist")
	public void then_click_on_the_dropdown_and_select_the_FundLevelChecklist(String fundDropdown, String fundName)
			throws Throwable {
		loginpage.selectTheClient(fundDropdown, fundName);

	}

	@Then("the user enters {string}")
	public void the_user_enters(String transactionName) throws Throwable {
		loginpage.entersTransactionName(transactionName);
	}

	@Then("the user provides the {string} and {string}")
	public void the_user_provides_the_and(String string, String string2) throws Throwable {
		loginpage.enterTotalCallAmountAndDistributionAmount(string, string2);
	}

	@Then("verify system shall display {string},{string} and {string} sections on the screen")
	public void verify_system_shall_display_and_sections_on_the_screen(String section1, String section2,
			String section3) throws Throwable {
		loginpage.verifySections(section1, section2, section3);
	}

	@Then("under the {string} the system shall display {string} as default section")
	public void under_the_the_system_shall_display_as_default_section(String capitalCall, String amount)
			throws Throwable {
		loginpage.verifyAmountText(capitalCall, amount);
	}

	@Then("the user provides the {string}")
	public void the_user_provides_the(String callAmount) throws Throwable {
		loginpage.enterTotalCallAmount(callAmount);
	}

	@Then("validate the {string}")
	public void validate_the(String netAmount) throws Throwable {
		loginpage.validateTheNetAmount(netAmount);
	}

	@Then("then click on the {string} dropdown and select the {string} under {string} sections")
	public void then_click_on_the_dropdown_and_select_the_under_sections(String transactionTypes, String selectDropdown,
			String section) throws Throwable {

		loginpage.selectTheTransactionTypes(transactionTypes, selectDropdown, section);
	}

	@Then("User select the transaction type from inition page {string}")
	public void then_click_on_the_dropdown_and_select_the_under_sections(String transactionTypes) throws Throwable {

		loginpage.selectTheTransactionTypes(transactionTypes);
	}

	@Then("User enter mandatory fileds like {string} {string} {string} in Initiation page")
	public void user_enter_mandatory_fileds_like_in_initiation_page(String Distrfund, String Amtdistributed,
			String Distritype) throws Exception {

		loginpage.selectTheDisstributionfun(Distrfund, Amtdistributed, Distritype);

	}

	@Then("click on the {string} dropdown and select the {string}")
	public void click_on_the_dropdown_and_select_the(String dealName, String selectDropdown) throws Throwable {

		loginpage.selectTheDealName(dealName, selectDropdown);
	}

	@Then("the user click on the {string} dropdown and select the {string}")
	public void the_user_click_on_the_dropdown_and_select_the(String position, String selectDropdown) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		loginpage.selectThePosition(position, selectDropdown);
	}

	@Then("enter {string} is equal to {string}")
	public void enter_is_equal_to(String transactionTypeAmount, String netAmount) throws Throwable {
		loginpage.enterTransactionTypeAmount(transactionTypeAmount, netAmount);
	}

	@Then("User selects the {string} and  enters the amount for transaction {string} for Transaction Details section")
	public void enter_is_equal_trans(String transactiontpye, String transactionTypeAmount) throws Throwable {
		loginpage.selectTheTransactionTypes(transactiontpye);
		loginpage.enterTransactionForAmount(transactionTypeAmount);
	}

	@Then("User selects the {string} for Fund distributing bank account")
	public void enter_is_equal_trans(String fundDisnkacc) throws Throwable {
		loginpage.selectFundDisnkacc(fundDisnkacc);

	}

	@Then("User selects the {string} and  enters the amount for transaction {string} for second Transaction Details section")
	public void enter_is_equal_trans_second(String transactiontpye, String transactionTypeAmount) throws Throwable {
		loginpage.selectTheSecondTransactionTypes(transactiontpye);
		loginpage.enterSecondTransactionForAmount(transactionTypeAmount);
	}

	@Then("click on the {string} dropdown and select the {string} under {string} sections")
	public void click_on_the_dropdown_and_select_the_under_sections(String allocationRule, String selectDropdown,
			String section) throws Throwable {
		loginpage.selectAllocationRule(allocationRule, selectDropdown, section);
	}

	@Then("the user shall be able to add a Transaction type by clicking on {string}")
	public void the_user_shall_be_able_to_add_a_Transaction_type_by_clicking_on(String transactionType)
			throws Throwable {

		loginpage.addTransactionType(transactionType);
	}

	@Then("the user shall be able to delete the Transaction type by clicking on Delete icon")
	public void the_user_shall_be_able_to_delete_the_Transaction_type_by_clicking_on_Delete_icon() throws Throwable {

		loginpage.deleteTransactionType();
	}

	@Then("User provides the Notice Date and Due Date from calendar")
	public void provide_the_Notice_Date_th_from_calendar() throws Throwable {
		loginpage.provideNoticeDate();
		loginpage.provideDueDate();
	}

	@Then("User provides the Target date from calendar")
	public void provide_the_Target_Date_th_from_calendar() throws Throwable {

		loginpage.provideTargetDateTransfer();
	}

	@Then("User validates the following message displaying or not based effective date")
	public void user_click_on_clik_here() throws Throwable {

		loginpage.clickHere();
	}

	@Then("User provides the Transfer effective date from calendar")
	public void provide_the_Transfereffectivedate_from_calendar() throws Throwable {
		loginpage.provideNoticeDate();
	}

	@Then("User provides the Period end date from calendar {string}")
	public void provide_the_Periodenddate_from_calendar(String preDate) throws Throwable {
		loginpage.providePeriodEndDate(preDate);
	}

	@Then("User provides the Due Date from calendar")
	public void provide_the_DueDate_th_from_calendar() throws Throwable {

		loginpage.provideDueDateForFOFDis();
	}

	@Then("User selects the pending cancel option from phase-status")
	public void selects_the_pending_status() throws Throwable {
		logoutpage.clickOn_Process_ID_Dropdown();
		logoutpage.clickOn_ApplyFilter();
		loginpage.enter_process_ID();
		loginpage.selectPendingstatus();
		logoutpage.clickOn_Process_ID();
	}

	@Then("User selects the L1 CashReconciliation from phase-status")
	public void selects_the_pending_status1() throws Throwable {
		logoutpage.clickOn_Process_ID_Dropdown();
		loginpage.enter_process_ID();
		loginpage.selectL1CashReconciliation();
		logoutpage.clickOn_Process_ID();
	}

	@Then("User selects the L1 Open Capital Activity from phase-status")
	public void selects_the_pending_statusCapitalActivity() throws Throwable {
		logoutpage.clickOn_Process_ID_Dropdown();
		loginpage.enter_process_ID();
		loginpage.selectL1CapitalCall();
		logoutpage.clickOn_Process_ID();
	}

	@Then("User selects the L1 Drafting from phase-status")
	public void selects_the_pending_statusL1Drafting() throws Throwable {
		logoutpage.clickOn_Process_ID_Dropdown();
		loginpage.enter_process_ID();
		loginpage.selectL1Drafting();
		logoutpage.clickOn_Process_ID();
	}

	@Then("User selects the client financial satements from phase-status")
	public void selects_the_client_finStatemnts() throws Throwable {
//		logoutpage.clickOn_Phase_Process_ID_Dropdown();
//		loginpage.enter_process_ID();
		loginpage.selectClientfinStatemnts();
//		logoutpage.clickOn_Process_ID();
	}

	@Then("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String submit) throws Throwable {

		loginpage.clicksOnSubmitButton(submit);
	}

	@Then("the user clicks on the save {string} button")
	public void the_user_clicks_on_save_button(String save) throws Throwable {

		loginpage.clicksOnSaveButton(save);
	}

	@Then("The user clicks on the {string} button")
	public void then_the_user_clicks_on_the_button(String submit) throws Throwable {

		loginpage.clicksOnSubmitButton(submit);
	}

	@Then("The user clicks on the client doc {string} button")
	public void then_the_user_clicks_on_the_buttonclient(String submit) throws Throwable {

		loginpage.clicksOnSubmitButton1(submit);
	}

	@Then("the user clicks on the {string} button on inition summary")
	public void then_the_user_clicks_summaryon_the_button(String submit) throws Throwable {

		loginpage.clicksOnSubmitButton(submit);
	}

	@Then("verify the case shall be assigned to {string}")
	public void verify_the_case_shall_be_assigned_to(String task) throws Throwable {
		loginpage.verifyTaskAssignedTo(task);
	}

	@Then("the user clicks on hamburger menu to the left and clicks on Log off button")
	public void the_user_clicks_on_the_Log_off_button() throws Throwable {

		loginpage.logoutForADOpertors();
	}

	@Then("user clicks on the Log off button")
	public void user_clicks_on_the_Log_off_button() throws Throwable {

		loginpage.clickOn_LogOff_Button();
	}

	@Then("click on {string} workbasket")
	public void click_on_workbasket(String workbasket) throws Throwable {

		loginpage.click_On_workbasket_L1(workbasket);
	}

	@Then("the user should enter {string} is equal to {string}")
	public void the_user_should_enter_is_equal_to(String transactionTypeAmount, String amount) throws Throwable {
		loginpage.TransactionTypeAmount(transactionTypeAmount, amount);
	}

	@Then("click on the {string} dropdown and select investment name {string}")
	public void click_on_the_dropdown_and_select_investment_name(String investmentName, String selectDropdown)
			throws Throwable {

		loginpage.selectTheInvestmentname(investmentName, selectDropdown);
	}

	@Then("the user provide {string}")
	public void the_user_provide(String amountToCommit) throws Exception {
		loginpage.enterAmountToCommit(amountToCommit);
	}

	@Then("the user click on the {string} in Purchase Agreement")
	public void the_user_click_on_the_in_Purchase_Agreement(String string) throws Throwable {
		loginpage.clickOnDraft();
	}

	@Then("the user click on {string} in Purchase Agreement")
	public void the_user_click_on_in_Purchase_Agreement(String string) throws Throwable {
		loginpage.clickOnExecuted();
	}

	@Then("the user should check FOF Commitment {string}")
	public void the_user_should_check_FOF_Commitment(String caseID) throws Throwable {

		loginpage.verifyCaseID(caseID);

	}

	@Then("the user land on {string} screen")
	public void the_user_land_on_screen(String pageTitle) throws Throwable {

		loginpage.verifyInvestmentDetailsPreparationScreen(pageTitle);
	}

	@Then("user enters {string}")
	public void user_enters(String name) throws Throwable {
		loginpage.entersTransactionNameforFOF(name);

	}

	@Then("click on the Security & transaction details")
	public void click_on_the_Security_transaction_details() throws Throwable {
		loginpage.clickOnSecuityDetails();
	}

	@Then("click on the {string} dropdown and select the {string} under Security & transaction details")
	public void click_on_the_dropdown_and_select_the_under_Security_transaction_details(String title,
			String selectDropdown) throws Throwable {
		loginpage.selectSecurityName(title, selectDropdown);
	}

	@Then("then click on the {string} dropdown and select the {string} under Security & transaction details")
	public void then_click_on_the_dropdown_and_select_the_under_Security_transaction_details(String title,
			String selectDropdown) throws Throwable {

		loginpage.select_Transactiontype(title, selectDropdown);
	}

	@Then("user enter {string} is equal to {string}")
	public void user_enter_is_equal_to(String string, String string2) throws Throwable {

		loginpage.enterAmountForTransaction();
	}

	@Then("user enter {string} under Security & transaction details")
	public void user_enter_under_Security_transaction_details(String string) throws Throwable {

		loginpage.enterNumberOfShares();
	}

	@Then("provide the Trade date {string} from calendar")
	public void provide_the_Trade_date_from_calendar(String tradeDate) throws Throwable {

		loginpage.enterTradeDate(tradeDate);
	}

	@Then("provide the Settlement date {string} from calendar")
	public void provide_the_Settlement_date_from_calendar(String settlementDate) throws Throwable {

		loginpage.enterSettlementDate(settlementDate);
	}

	@Then("provide {string}")
	public void provide(String name) throws Throwable {

		loginpage.entersSecurityName(name);
	}

	@Then("select {string} from security type dropdown")
	public void select_from_security_type_dropdown(String selectDropdown) throws Throwable {

		loginpage.select_Securitytype(selectDropdown);
	}

	@Then("select answer {string} for question - Did the client provide banking details for this investment?")
	public void select_answer_for_question_Did_the_client_provide_banking_details_for_this_investment(String string)
			throws Throwable {

		loginpage.clickOn_bank_details_toggle();
	}

	@Then("the user provide {string} and {string}")
	public void the_user_provide_and(String string, String string2) throws Throwable {

		loginpage.entersBankName();
		loginpage.enterBankAccount();
	}

	@Then("select {string} from country dropdown")
	public void select_from_country_dropdown(String countryName) throws Throwable {

		loginpage.select_country(countryName);
	}

	@Then("enter {string}")
	public void enter(String string) throws Throwable {

		loginpage.enterBICcode();
	}

	@Then("the user should verify security name {string}")
	public void the_user_should_verify_security_name(String securityName) throws Throwable {

		loginpage.verifySecurityName(securityName);
	}

	@Then("the user should verify transaction types {string}")
	public void the_user_should_verify_transaction_types(String transactiontype) throws Throwable {

		loginpage.verifyTransactiontype(transactiontype);
	}

	@Then("User validate status {string}")
	public void i_validate_status(String compeletedStatus) throws Exception {

		loginpage.verifyCompletedStatus(compeletedStatus);
	}

	@Then("the user should get logout successfully by clicking on {string} button")
	public void the_user_should_get_logout_successfully_by_clicking_on_button(String eKey) throws Exception {

		loginpage.logout();

	}

	@Then("the user should click on Direct Investment Sale link")
	public void the_user_should_click_on_direct_investment_sale_link() throws Exception {
		loginpage.clickOnDirectInvestmentSaleLink();
	}

	@Then("click {string} under agreement section")
	public void click_under_agreement_section(String string) throws Exception {

		loginpage.selectDocumentForm(string);
	}

	@And("the user provides the internal comments as {string}")
	public void the_user_provides_the_internal_comments(String cmnts) throws Exception {
		homepage.enterInternalComments(cmnts);
	}

	@Then("the user land on L1 {string} screen")
	public void the_user_land_on_screen_L1(String pageTitle) throws Throwable {

		loginpage.L1SaleOfInvPageReviewPage(pageTitle);
	}

	@Then("the user clicks on the L1 agreement{string}")
	public void the_user_clicks_on_L1_agreement(String saleAgreemnt) throws Throwable {
		loginpage.clickSaleAgreement(saleAgreemnt);
	}

	@Then("user selects {string} in Details Preparation screen")
	public void user_selects(String string) throws Throwable {
		loginpage.clickOn_Approve();
	}

	@Then("user enters {string} client service")
	public void the_user_enters_details_client_service(String s) throws Throwable {
		loginpage.enterTransactionName(s);
	}

	@Then("the user provide amount {string}")
	public void the_user_provide_amount(String amountToSell) throws Exception {
		loginpage.enterAmountToSell(amountToSell);
	}

	@And("select {string} from dropdown")
	public void Select_security_name(String securityName) throws Exception {
		loginpage.selectSecurityName(securityName);

	}
	
	@And("select {string} from dropdown for FOFCommitment")
	public void Select_security_name_for_FOFCommitment(String securityName) throws Exception {
		loginpage.selectSecurityNameFOFCommitment(securityName);

	}

	@Then("add single transaction type {string} - {string}")
	public void add_multiple_transaction_types(String transactionType1, String amount1) throws Throwable {
		loginpage.select_Transactiontypes(transactionType1, amount1);
	}

	@Then("User provides the Trade date and Settlement date from calendar")
	public void provide_the_Trade_date_and_Settlement_date_from_calendar() throws Throwable {
		loginpage.enterTradeDate();
		loginpage.enterSettlementDate();

	}

	@Then("verify the status change - {string}")
	public void verify_the_status_change(String status) throws Exception {
		loginpage.verifyStatusChange(status);

	}

	@Then("the user click on the Fund dropdown and Select the value for fund {string} in Direct Inv Sale")
	public void the_user_click_on_the_fund_dropdown_and_select_the_value_for_fund_in_direct_inv_sale(String string)
			throws Exception {

		loginpage.selectTheFundInDirctInv(string);

	}

	@Then("the user clicks on the Investment list dropdown and select the {string}")
	public void the_user_clicks_on_the_investment_list_dropdown_and_select_the(String string) throws Exception {
		loginpage.selectTheInvestmentListDirctInv(string);
	}

	@Then("the user clicks on the Investment fund dropdown and select the {string}")
	public void the_user_clicks_on_the_investment_fund_dropdown_and_select_the(String string) throws Exception {
		loginpage.selectTheInvestmentFund(string);
	}
	
	@Then("the user clicks on the Investment fund dropdown and select the investment fund")
	public void the_user_clicks_on_the_investment_fund_dropdown_and_select_the_investment_fund() throws Exception {
		loginpage.selectTheInvestmentFundForTemplate();
	}

	@Then("verify if Sale agreement is in Executed state")
	public void verify_if_Sale_agreement_is_in_Executed_state() throws Throwable {

		loginpage.verifyExecuteState();
	}

	@Then("add multiple transaction types {string} - {string} {string} - {string} {string} - {string}")
	public void add_multiple_transaction_types(String transactionType1, String amount1, String transactionType2,
			String amount2, String transactionType3, String amount3) throws Throwable {
		loginpage.select_Transactiontypes(transactionType1, amount1, transactionType2, amount2, transactionType3,
				amount3);
	}

	@Then("the user is able to add Account number as {string} - FOF Capital Call")
	public void the_user_is_able_to_add_Account_number(String accNo) throws Exception {
		loginpage.enterAccNo(accNo);
	}

	@Then("the user should be able to provide the ABA routing number as {string} - FOF Capital Call")
	public void the_user_is_able_to_add_ABA_number(String accNo) throws Exception {
		loginpage.enterABANo(accNo);
	}

	@Then("the user should be able to provide the SWIFT number as {string} - FOF Capital Call")
	public void the_user_is_able_to_add_SWIFT_number(String accNo) throws Exception {
		loginpage.enterSWIFTNo(accNo);
	}

	@Then("add multiple transaction types FOF CapCall {string} - {string} {string} - {string} {string} - {string}")
	public void add_multiple_transaction_types_FOF_CapCall(String transactionType1, String amount1,
			String transactionType2, String amount2, String transactionType3, String amount3) throws Throwable {
		loginpage.select_TransactiontypesFOFCap(transactionType1, amount1, transactionType2, amount2, transactionType3,
				amount3);
	}

	@Then("the user able to land on {string} screen")
	public void the_user_able_to_land_on_screen(String pageTitle) throws Exception {

		loginpage.verifyInitiationPage(pageTitle);
	}

	@Then("enter the transaction name as {string}")
	public void enter_the_transaction_name(String trnsctnName) throws Exception {
		loginpage.enterTransctnName(trnsctnName);
	}

	@Then("enter the total amount to be paid {string}")
	public void enter_the_total_amount_to_be_paid(String amt) throws Exception {
		loginpage.enterAmtTobePaid(amt);
	}

	@Then("select the {string} from Position dropdown")
	public void select_the_position_from_position_dropdown(String position) throws Exception {
		loginpage.selectPosition(position);
	}

	@Then("enter Notice date and Payment date")
	public void enter_Notice_date_and_Payment_date() throws Exception {
		loginpage.enterNoticeDate();
		loginpage.enterSettlementDate();
	}

	@Then("then user click on the {string} dropdown and select the currency {string} - FOF CapitalCall")
	public void then_user_click_on_the_dropdown_and_select_the_currency_FOFCap(String currency, String value)
			throws Exception {

		loginpage.selectCurrencyFOFCap(currency, value);

	}

	@Then("then user click on the {string} dropdown and select the issuing account {string} - FOF CapitalCall")
	public void then_user_click_on_the_dropdown_and_select_the_issuing_account(String acc, String value)
			throws Exception {

		loginpage.selectIssuingAccValuesInDropdownFOFCap(acc, value);
	}
	
	@Then("then user click on the {string} dropdown and select the issuing account")
	public void then_user_click_and_select_the_issuing_account(String acc)
			throws Exception {

		loginpage.selectIssuingAccValuesForTemplate(acc);
	}

	@Then("the user should land on the {string} screen FOF")
	public void the_user_should_land_on_the_screen_FOF_Capital_call(String pageTitle) throws Exception {
		loginpage.verifyInitiationScreenFOFcap(pageTitle);
	}

	@Then("add multiple transaction types FOF CapCall {string} - {string}")
	public void add_multiple_transaction_types_FOF_CapCall(String transactionType1, String amount1) throws Throwable {
		loginpage.select_TransactiontypesFOFCap(transactionType1, amount1);
	}

	@Then("user enter {string} is equal to Amount to commit")
	public void user_enter_is_equal_to(String amt) throws Throwable {

		loginpage.enterAmountForTransaction(amt);
	}

	@Then("user enter {string} is equal to Amount to commit - FOF")
	public void user_enter_amt_FOF(String amt) throws Throwable {

		loginpage.enterAmountForTransactionFOF(amt);
	}

	@Then("add multiple transaction types {string} - {string} {string} - {string} {string} - {string} - DIP")
	public void add_multiple_transaction_types_DIP(String transactionType1, String amount1, String transactionType2,
			String amount2, String transactionType3, String amount3) throws Throwable {
		loginpage.select_Transactiontypes_DIP(transactionType1, amount1, transactionType2, amount2, transactionType3,
				amount3);
	}

	@Then("enter Period end reporting description as {string}")
	public void enter_the_Periodendreportingdescription(String trnsctnName) throws Exception {
		loginpage.enterPeriodendreportingdescription1(trnsctnName);
	}

	@Then("User select the documents to be requested from the client and enter description as {string}")
	public void Pleaseseledocuments_requested_client(String trnsctnName) throws Exception {
		loginpage.enterPeriodendreportingdescription(trnsctnName);
	}

	@Then("User select enter description as {string}")
	public void Pleaseseledocuments_ested_client(String trnsctnName) throws Exception {
		loginpage.enterPeriodendreportingdescription2(trnsctnName);
	}

}
