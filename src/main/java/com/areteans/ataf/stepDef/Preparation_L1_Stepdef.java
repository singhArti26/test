package com.areteans.ataf.stepDef;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CommonPage;
import com.areteans.ataf.PageObjects.InitiationL1Page;
import com.areteans.ataf.PageObjects.InitiationL2Page;
import com.areteans.ataf.PageObjects.PreparationL1Page;
import com.areteans.ataf.PageObjects.PreparationL2Page;
import com.areteans.ataf.PageObjects.ReviewL1Page;
import com.areteans.ataf.TestBase.TestBase;

import io.cucumber.java.en.Then;

public class Preparation_L1_Stepdef {

	SeleniumFunNonPega seleniumFunNonPega;
	PreparationL1Page l1_preparation;
	CommonPage homepage;
	InitiationL1Page loginpage;
	InitiationL2Page logoutpage;
	PreparationL2Page preparationL2page;
	ReviewL1Page reviewL1page;
	String amount = "";

	/**
	 * 
	 */
	public Preparation_L1_Stepdef() {
		l1_preparation = new PreparationL1Page(TestBase.getDriver());
		l1_preparation.sendLogoutObject(logoutpage);
	}

	@Then("user should display the {string} page")
	public void user_should_display_the_page(String pageTitle) throws Throwable {

		l1_preparation.verifyInitiationScreen(pageTitle);
	}

	@Then("the user should upload the {string}")
	public void the_user_should_upload_the(String upload) throws Throwable {
		l1_preparation.clickOn_Upload_Document(upload);
	}

	@Then("the user should upload the second document {string}")
	public void the_user_should_upload_Second_the(String upload) throws Throwable {
		l1_preparation.clickOn_Upload_Document2(upload);
	}

	@Then("the user clicks on {string} button on the internal window")
	public void the_user_clicks_on_button_on_the_internal_window(String submit) throws Throwable {

		l1_preparation.clickOn_submit_button(submit);
	}

	@Then("the user should click on {string}")
	public void the_user_should_click_on(String string) throws Throwable {

		l1_preparation.clickOn_Investor_List();
	}

	@Then("the user should click {string} on the toggle button {string}")
	public void the_user_should_click_on_the_toggle_button(String yes, String filed) throws Throwable {
		l1_preparation.clickOn_toggle(yes, filed);
	}

	@Then("the user should upload Documents")
	public void the_user_should_upload_Documents() throws Throwable {

		l1_preparation.upload_Documents();
	}

	@Then("the user can upload Documents")
	public void the_user_can_upload_Documents() throws Throwable {

		l1_preparation.upload_Supporting_Documents();
	}

	@Then("the user should able see the {string},{string} and {string} under the {string}")
	public void the_user_should_able_see_the_and_under_the(String filed1, String filed2, String filed3, String filed4)
			throws Throwable {

		l1_preparation.select_Documents(filed1, filed2, filed3, filed4);
	}

	@Then("the user enters {string} and {string}")
	public void the_user_enters_and(String internal, String external) throws Throwable {

		l1_preparation.enter_internal_external_filed(internal, external);
	}

	@Then("the user clicks on the {string} button,case shall be assigned to {string}")
	public void the_user_clicks_on_the_button_case_shall_be_assigned_to(String submit, String cs) throws Throwable {

		l1_preparation.clicksOnSubmitButton(submit, cs);
	}

	@Then("user should display {string} pagetitle")
	public void user_should_display_pagetitle(String pageTitle) throws Throwable {

		l1_preparation.verifyInitiationScreenForDistribution(pageTitle);
	}

	@Then("user should click on {string} for {string}")
	public void user_should_click_on_for(String string, String string2) throws Throwable {

		l1_preparation.clickOnYesButton();
	}

	@Then("then click on the insufficient liquidity dropdown and select the {string}")
	public void then_click_on_the_insufficient_liquidity_dropdown_and_select_the(String selectDropDown)
			throws Throwable {

		l1_preparation.selectTheInsufficientLiquidityDropDown(selectDropDown);
	}

	@Then("link one or more capital calls to the current distribution case")
	public void link_one_or_more_capital_calls_to_the_current_distribution_case() throws Throwable {

		l1_preparation.clickOnCheckbox();

	}

	@Then("user should display pagetitle is {string}")
	public void user_should_display_pagetitle_is(String pageTitle) throws Throwable {

		l1_preparation.verifyL1_Liquidity_Resolution_PageTitle(pageTitle);

	}

	@Then("select answer {string} for question - I confirm liquidity was made sufficient, following the instructions provided by the client")
	public void select_answer_for_question_I_confirm_liquidity_was_made_sufficient_following_the_instructions_provided_by_the_client(
			String string) throws Throwable {

		l1_preparation.clickOn_Liquidity_toggle();
	}

	@Then("the user is able to land on the page {string} pagetitle")
	public void the_user_is_able_to_land_on_the_page_pagetitle(String pageTitle) throws Throwable {

		l1_preparation.verifyCallBackScreen(pageTitle);
	}

	@Then("select answer {string} for question - Are the banking details for this investment present in the banking platform?")
	public void select_answer_for_question_Are_the_banking_details_for_this_investment_present_in_the_banking_platform(
			String string) throws Throwable {

		l1_preparation.clickOn_bank_details_toggle();

	}

	@Then("the user enter reason")
	public void the_user_enter_reason() throws Throwable {

		l1_preparation.enter_reason();
	}

	@Then("the user enters {string} textbox")
	public void the_user_enters_textbox(String string) throws Throwable {

		l1_preparation.entersClientRepresentativeCalled();
	}

	@Then("the user provide the Call back date and time {string} from calendar")
	public void the_user_provide_the_Call_back_date_and_time_from_calendar(String date) throws Throwable {

		l1_preparation.enterCallBackDate(date);
	}

	@Then("the user enters {string} of client representative")
	public void the_user_enters_of_client_representative(String string) throws Throwable {

		l1_preparation.enterPhoneNumberOfClient();
	}

	@Then("select answer {string} for question - I confirm that call back was successful")
	public void select_answer_for_question_I_confirm_that_call_back_was_successful(String string) throws Throwable {

		l1_preparation.clickOnCallBackSuccessfulToggle();
	}

	@Then("the user click on Template input type {string}")
	public void the_user_click_on_Template_input_type(String string) throws Throwable {

		l1_preparation.clickOnEditButton();
	}

	@Then("the user is able to land on the page L1 expense payment preparation - {string}")
	public void the_user_is_able_to_land_on_the_page_L1(String title) throws Exception {

		l1_preparation.verifyExpensePaymentPreparationTitleL1(title);
	}

	@Then("then user click on the {string} dropdown and select the currency {string}")
	public void then_user_click_on_the_dropdown_and_select_the_currency(String currency, String value)
			throws Exception {

		l1_preparation.selectCurrency(currency, value);

	}

	@Then("then user click on the {string} dropdown and select the issuing account {string}")
	public void then_user_click_on_the_dropdown_and_select_the_issuing_account(String acc, String value)
			throws Exception {

		l1_preparation.selectIssuingAccValuesInDropdown(acc, value);
	}

	@Then("the user should be able to provide the total amount as {string}")
	public void the_user_should_be_able_to_provide_the_total_amount_as(String amt) throws Exception {
		l1_preparation.enterAmountToPaid(amt);

	}

	@Then("the user enters the vendor name in {string}")
	public void the_user_enters_the_vendor_name_in(String value) throws Exception {
		l1_preparation.enterVendorForFirstInvoice(value);
	}

	@Then("the user is able to provide the invoiceNo")
	public void the_user_is_able_to_provide_the_invoice_no() throws Exception {

		l1_preparation.enterInvoiceNo();
	}

	@Then("User provides the Invoice Date and Payment date from calendar")
	public void provide_the_Notice_Date_th_from_calendar() throws Throwable {
		l1_preparation.enterInvDate();
		l1_preparation.enterPayDate();
	}

	@Then("the user is able to add Account number as {string}")
	public void the_user_is_able_to_add_Account_number_as(String no) throws Exception {
		l1_preparation.enterAccNo(no);
	}

	@Then("the user should be able to provide the routing no ABA routing number as {string}")
	public void the_user_should_be_able_to_provide_the_routing_no_ABA_routing_number_as(String string)
			throws Exception {
		l1_preparation.enterABANo(string);
	}

	@Then("the user should be able to provide the SWIFT number as {string}")
	public void the_user_should_be_able_to_provide_the_SWIFT_number_as(String value) throws Exception {
		l1_preparation.enterSwiftNo(value);
	}

	@Then("the user should be able to provide the Memo as {string}")
	public void the_user_should_be_able_to_provide_the_Memo_payment_communication_as(String string) throws Exception {
		l1_preparation.enterMemo(string);
	}

	@Then("the user should be able to click on the {string} and select {string}")
	public void the_user_should_be_able_to_select_proposed_decision(String s1, String s2) throws Exception {

		l1_preparation.selectValuesInDropdownForProposedDecision(s1, s2);
	}

	@Then("the user shuld be to provide the comments as {string} {string}")
	public void the_user_shuld_be_to_provide_the_comments_as(String comment, String s1) throws Exception {

		l1_preparation.writeDecisionComment(comment, s1);

	}

	@Then("the user should able to click on {string} header")
	public void the_user_should_able_to_click_on_header(String invoice2) throws Exception {

		l1_preparation.clickonInvoiceHeader(invoice2);

	}

	@Then("then user click on the {string} dropdown and select the currency {string} for Invoice two")
	public void then_user_click_on_the_dropdown_and_select_the_currency_Invoice_two(String currency, String value)
			throws Exception {

		l1_preparation.selectCurrencyForSecondInvoice(currency, value);

	}

	@Then("then user click on the {string} dropdown and select the issuing account {string} Invoice Two")
	public void then_user_click_on_the_dropdown_and_select_the_issuing_account_Invoice_Two(String fund, String value)
			throws Exception {

		l1_preparation.selectIssuingAccValuesInDropdownInSecondInvoice(fund, value);
	}

	@Then("the user should be able to provide the total amount as {string} for Invoice two")
	public void the_user_should_be_able_to_provide_the_total_amount_as_Invoice_Two(String amt) throws Exception {
		l1_preparation.enterAmountToPaid2(amt);

	}

	@Then("the user enters the vendor name in {string} for Invoice Two")
	public void the_user_enters_the_vendor_name_in_for_Invoice_Two(String string) throws Exception {

		l1_preparation.enterVendorForSecondInvoice(string);
	}

	@Then("the user is able to provide the invoiceNo for Invoice Two")
	public void the_user_is_able_to_provide_the_invoice_no_for_Invoice_Two() throws Exception {

		l1_preparation.enterInvoiceNoForInvoiceTwo();
	}

	@Then("the user should be able to provide the Invoice date and payment date for Invoice Two")
	public void the_user_should_be_able_to_provide_the_Invoice_date_and_payment_date_for_Invoice_Two()
			throws Exception {
		l1_preparation.enterPayDate2();
	}

	@Then("the user is able to add Account number as {string} for Invoice Two")
	public void the_user_is_able_to_add_Account_number_as_for_Invoice_Two(String string) throws Exception {
		l1_preparation.enterAccNo2(string);
	}

	@Then("the user should be able to provide the routing no ABA routing number as {string} for Invoice Two")
	public void the_user_should_be_able_to_provide_the_routing_no_ABA_routing_number_as_for_Invoice_Two(String string)
			throws Exception {
		l1_preparation.enterABANo2(string);
	}

	@Then("the user should be able to provide the SWIFT number as {string} for Invoice Two")
	public void the_user_should_be_able_to_provide_the_SWIFT_number_as_for_Invoice_Two(String string) throws Exception {
		l1_preparation.enterSwiftNo2(string);
	}

	@Then("the user should be able to provide the Memo as {string} for Invoice Two")
	public void the_user_should_be_able_to_provide_the_Memo_payment_communication_as_for_Invoice_Two(String string)
			throws Exception {
		l1_preparation.enterMemo2(string);
	}

	@Then("the user should be able to click on the  {string} and select {string} for Invoice Two")
	public void the_user_should_be_able_to_click_on_the_and_select_for_Invoice_Two(String string, String string2)
			throws Exception {
		l1_preparation.selectValuesInDropdownUnderProposedDecisionForSecondInvoice(string, string2);
	}

	@Then("the user shuld be to provide the comments as {string} for Invoice Two")
	public void the_user_shuld_be_to_provide_the_comments_as_for_Invoice_Two(String string2) throws Exception {
		l1_preparation.writeDecisionComment2(string2);
	}

	@Then("the user is able to land on the page L1 Liquidity Review - {string}")
	public void the_user_is_able_to_land_on_the_page_L1_Liquidity_Review(String title) throws Exception {

		l1_preparation.verifyL1LiquidityReviewTitle(title);
	}
	
	@Then("user selected {string} for does your team review fund liquidty")
	public void select_Yes_for_fund_liquidity_review(String ans) throws Exception {
		l1_preparation.selectAnswerForReviewFundLiquidity(ans);
	}

	@Then("select answer for fund has sufficient liquidity as {string} {string}")
	public void select_answer_for_fund_has_sufficient_liquidity_as(String ans, String res) throws Exception {

		l1_preparation.selectAnswer(ans, res);
	}

	@Then("Select Fee type as {string}")
	public void select_Fee_type_as(String type) throws Exception {
		l1_preparation.selectFeeType(type);
	}

	@Then("enter amount the same as Amount to be paid {string}")
	public void enter_amount_the_same_as_Amount_to_be_paid(String amount) throws Exception {

		l1_preparation.enterAmount(amount);
	}

	@Then("the user is able to land on the page L1 Expense Payment Call Back - {string}")
	public void the_user_is_able_to_land_on_the_page_L1_Expense_Payment_Call_Back(String title) throws Exception {

		l1_preparation.verifyL1ExpensePaymentCallBackTitle(title);
	}

	@Then("select template input as {string};")
	public void select_template_input_as(String edit) throws Exception {

		l1_preparation.clickOnTemplateOption(edit);
	}

	@Then("enter template name {string}")
	public void enter_template_name(String name) throws Exception {
		l1_preparation.enterTemplateName(name);
	}

	@Then("enter template name {string} - {string}")
	public void enter_template_name_FOF_Capital_Call(String name, String process) throws Exception {
		l1_preparation.enterTemplateNameFOFCapitalCall(name);
	}

	@Then("enter template bank as {string}")
	public void enter_template_bank_as(String name1) throws Exception {
		l1_preparation.enterTemplateBank(name1);
	}

	@Then("enter template bank as {string} - {string}")
	public void enter_template_bank_FOF_Capital_Call(String name1, String process) throws Exception {
		l1_preparation.enterTemplateBank_FOF_Capital_Call(name1);
	}

	@Then("enter client representative call name {string}")
	public void enter_client_representative_call_name(String name) throws Exception {
		l1_preparation.enterClientName(name);
	}

	@Then("enter client representative call name {string} - {string}")
	public void enter_client_representative_call_name_FOF_Capital_call(String name, String Process) throws Exception {
		l1_preparation.enterClientNameFOFCapitalCall(name);
	}

	@Then("User should select {string} for client call successful")
	public void user_should_select_for_client_call_successful(String ans) throws Exception {
		l1_preparation.selectAnswer(ans);
	}

	@Then("User should select {string} for client call successful - {string}")
	public void user_should_select_for_client_call_successful_FOF_Capital_Call(String ans, String process)
			throws Exception {
		l1_preparation.selectAnswerFOFCapitalCall(ans);
	}

	@Then("upload the {string} and change file type to {string}")
	public void upload_the_document_and_change_file_type_to(String file, String type1) throws Exception {

		l1_preparation.clickOnUploadButton(file, type1);

	}

	@Then("enter call completed time {string}")
	public void enter_call_completed_time(String time) throws Exception {
		l1_preparation.enterTime(time);
	}

	@Then("enter call completed time {string} - {string}")
	public void enter_call_completed_time_FOF_Capital_Call(String time, String process) throws Exception {
		l1_preparation.enterTimeFOFCapital(time);
	}

	@Then("enter no of client representative as {string}")
	public void enter_no_of_client_representative_as(String no) throws Exception {
		l1_preparation.enterClientNo(no);
	}

	@Then("enter no of client representative as {string} - {string}")
	public void enter_no_of_client_representative_FOF_Capital_Call(String no, String process) throws Exception {
		l1_preparation.enterClientNoFOFcapitalCall(no);
	}

	@Then("the user is able to land on the page L1 Expense Payment Processing - {string}")
	public void the_user_is_able_to_land_on_the_page_L1_Expense_Payment_Processing(String title) throws Exception {

		l1_preparation.verifyL1ExpensePaymentProcessingTitle(title);
	}

	@Then("select answer {string} for question - All the payments above were set up on the banking platform")
	public void select_answer_for_question_All_the_payments_above_were_set_up_on_the_banking_platform(String box)
			throws Exception {
		l1_preparation.clickOnCheckBox(box);
	}

	@Then("Select Fee Type as {string}")
	public void select_Fee_Type_as(String string) throws Exception {

		l1_preparation.clickOnFeeDrp(string);
	}

	@Then("the user should be able to provide the Amount To Be Paid")
	public void the_user_should_be_able_to_provide_the_Amount_To_Be_Paid() throws Exception {

		l1_preparation.enterAmount();
	}

	@Then("the user should be able to provide the {string}")
	public void the_user_should_be_able_to_provide_the_vendor_name(String vendor) throws Exception {

		l1_preparation.enterVendorName(vendor);
	}

	@Then("the user should be able to provide the routing no ABA routing number")
	public void the_user_should_be_able_to_provide_the_routing_no_ABA_routing_number() throws Exception {

		l1_preparation.enterRoutingNO();
	}

	@Then("the user should be able to provide the SWIFT number")
	public void the_user_should_be_able_to_provide_the_SWIFT_number() throws Exception {

		l1_preparation.enterSwiftNo();
	}

	@Then("the user should provide the intlComments as {string}")
	public void the_user_should_provide_the_intlComments(String comments) throws Exception {

		l1_preparation.writeIntlComment(comments);
	}

	@Then("enter amount the same as Amount to be paid")
	public void enter_amount_the_same_as_Amount_to_be_paid() throws Exception {

		l1_preparation.enterAmount(amount);
	}

	@Then("the user should able to submit the details by clicking on {string} button refresh warning")
	public void the_user_should_able_to_submit_the_details_by_clicking_on_button_refresh_warning(String string)
			throws Exception {
		l1_preparation.clickOnSubmitRefreshWarning(string);

	}

	@Then("the user is able to land on the COPP page {string}")
	public void the_user_is_able_to_land_on_the_COPP_page(String scr) throws Exception {

		l1_preparation.verifyInitationScreen(scr);

	}

	@Then("select answer Yes for question - Are the banking details provided in the notice already present in the banking platform - FOF capital")
	public void select_answer_for_question_banking_details_provided_present_in_banking_platform() throws Exception {

		l1_preparation.selectToggleForbankingDetailsProvided();

	}

	@Then("provide the reason under toggle {string} - FOF Capital")
	public void provide_the_reason_under_toggle(String cmnts) throws Exception {

		l1_preparation.enterReasonAfterEnablingToggle(cmnts);

	}

	@Then("user enter investor related information {string} {string}")
	public void user_enter_investor_related_information(String name, String emailadd) throws Exception {
		l1_preparation.enterTheInvestorData(name, emailadd);
	}

	@Then("select answer {string} for question - All the payments above were set up on the banking platform - DIP")
	public void select_answer_for_question_All_the_payments_above_were_set_up_on_the_banking_platform_DIP(String box)
			throws Exception {
		l1_preparation.clickOnCheckBoxDIP(box);
	}

	@Then("the user should upload the {string} for Repository")
	public void the_user_should_upload_the_Repository(String upload) throws Throwable {
		l1_preparation.clickOn_Upload_Document_For_Repository(upload);
	}

	@Then("the user should upload the {string} for Repository Fund Level Checklist")
	public void the_user_should_upload_the_RepositoryFundLevelChecklist(String upload) throws Throwable {
		l1_preparation.clickOn_Upload_Document_For_Repository(upload);
	}

	@Then("click yes on toggle - Are the banking details for this investment present in the banking platform?")
	public void click_yes_on_toggle_banking_details_for_this_investment() throws Exception {
		l1_preparation.clickOnCheckBoxBankingDetailsDIP();
	}

	@Then("provide the reason for banking platform {string} - {string}")
	public void provide_the_reason_for_banking_platform(String cmnts, String process) throws Exception {
		l1_preparation.provideReasonForBankingPlatform(cmnts);
	}
	
	@Then("the user should upload the {string} and select {string} - PER")
	public void the_user_should_upload_document(String upload,String docCatgry) throws Throwable {
		l1_preparation.clickOn_Upload_DocumentPER(upload,docCatgry);
	}

}
