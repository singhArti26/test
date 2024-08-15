package com.areteans.ataf.stepDef;

import java.awt.AWTException;
import java.io.IOException;

import com.areteans.ataf.GeneralHelperSel.SeleniumFunNonPega;
import com.areteans.ataf.PageObjects.CommonPage;
//import com.areteans.ataf.PageObjects.LoginPage;
import com.areteans.ataf.TestBase.TestBase;
import com.areteans.ataf.configreader.ObjectRepo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Common_StepDef {

	SeleniumFunNonPega seleniumFunNonPega;
	CommonPage homepage;

	public Common_StepDef() {
		seleniumFunNonPega = new SeleniumFunNonPega(TestBase.getDriver());
		seleniumFunNonPega.sendSeleniumFunNonPegaObject(seleniumFunNonPega);
		homepage = new CommonPage(TestBase.getDriver());
	}

	@Given("User open the browser and navigate to CorproURL")
	public void user_open_the_browser_and_navigate_to_CorproURL() throws InterruptedException {

		TestBase.getDriver().get(ObjectRepo.reader.getCorproURL());

	}

	@Given("User open the browser and navigate to FundServicesURL")
	public void user_open_the_browser_and_navigate_to_FundServicesURL() throws InterruptedException {

		TestBase.getDriver().get(ObjectRepo.reader.getFundServicesURL());

	}

	@Then("the user clicks on {string}")
	public void the_user_click_on_on_page(String elementkey) throws Exception {

		seleniumFunNonPega.elementClick(elementkey);
		seleniumFunNonPega.waitpageLoad();

	}

	@Then("the user validate following error message {string}")
	public void the_user_verify_msg(String errorMsg) throws Exception {

		homepage.verifyError(errorMsg);

	}

	@Then("the user enters value in {string} filed with {string}")
	public void the_user_enters_a_value_in_filed_with(String elementkey, String inputvalue) throws Exception {

		seleniumFunNonPega.inputTextBox(elementkey, inputvalue);

	}

	@Then("the user gets the pagetitle")
	public void the_user_gets_the_pagetitle() {

		seleniumFunNonPega.pageTitle();
	}

	@Then("the user gets the currentURL")
	public void the_user_gets_the_currentURL() {

		seleniumFunNonPega.currentURL();
	}

	@Then("the user gets the inputdata {string} and {string}")
	public void the_user_gets_the_inputdata(String elementkey, String value) throws IOException {

		seleniumFunNonPega.getAttributeValue(elementkey, value);
	}

	@Then("the user removes the existing data in {string}")
	public void the_user_removes_the_existing_data_in(String elementkey) throws Exception {

		seleniumFunNonPega.clearinputTextBoxData(elementkey);
	}

	@Then("the user performs submit request on {string}")
	public void the_user_performs_submit_request_on(String elementkey) throws IOException {

		seleniumFunNonPega.elementSubmit(elementkey);
	}

	@Then("the user verifies whether element ispresent {string}")
	public void the_user_verifies_whether_element_ispresent(String elementkey) throws IOException {

		seleniumFunNonPega.isElementDisplayed(elementkey);
	}

	@Then("the user verifies whether element isenabled {string}")
	public void the_user_verifies_whether_element_isenabled(String elementkey) throws IOException {

		seleniumFunNonPega.isElementEnabled(elementkey);
	}

	@Then("the user verifies whether element isSelected {string}")
	public void the_user_verifies_whether_element_isSelected(String elementkey) throws IOException {

		seleniumFunNonPega.isElementSelected(elementkey);
	}

	@Then("the user gets text data of {string}")
	public void the_user_gets_text_data_of(String elementkey) throws IOException {

		seleniumFunNonPega.getTextData(elementkey);
	}

	@Then("the user navigates to any particular URL {string}")
	public void the_user_navigates_to_any_particular_URL(String URL) {

		seleniumFunNonPega.navigateToURL(URL);
	}

	@Then("the user navigates back")
	public void the_user_navigates_back() {

		seleniumFunNonPega.navigateBack();
	}

	@Then("the user navigates forward")
	public void the_user_navigates_forward() {

		seleniumFunNonPega.navigateForward();
	}

	@Then("the user refreshes the current webpage")
	public void the_user_refreshes_the_current_webpage() {

		seleniumFunNonPega.pageRefresh();
	}

	@Then("the user accepts the alert")
	public void the_user_accepts_the_alert() {

		seleniumFunNonPega.alertAccept();
	}

	@Then("the user dismisses the alert")
	public void the_user_dismisses_the_alert() {

		seleniumFunNonPega.alertDismiss();
	}

	@Then("the user gets the alert text")
	public void the_user_gets_the_alert_text() {

		seleniumFunNonPega.getTextFromAlert();
	}

	@Then("the user provides input data to alert {string}")
	public void the_user_provides_input_data_to_alert(String value) {

		seleniumFunNonPega.sendValueToAlert(value);
	}

	@Then("the user switches to frameByIndex {string}")
	public void the_user_switches_to_frameByIndex(String inputindex) {

		seleniumFunNonPega.switchFrameByIndex(inputindex);
	}

	@Then("the user switches to frameByIdorName {string}")
	public void the_user_switches_to_frameByIdorName(String nameorid) throws InterruptedException {

		seleniumFunNonPega.switchFrameByIdORName(nameorid);
	}

	@Then("the user switches to frameByElement {string}")
	public void the_user_switches_to_frameByElement(String elementkey) throws IOException {

		seleniumFunNonPega.switchFrameByElement(elementkey);
	}

	@Then("the user moves out from the frame")
	public void the_user_moves_out_from_the_frame() {

		seleniumFunNonPega.exitFromeFrame();
	}

	@Then("the user selects the dropdown value {string} ByIndex {string}")
	public void the_user_selects_the_dropdown_value_ByIndex(String elementkey, String index) throws IOException {

		seleniumFunNonPega.pickByIndex(elementkey, index);
	}

	@Then("the user selects the dropdown value {string} ByVisibleText {string}")
	public void the_user_selects_the_dropdown_value_ByVisibleText(String elementkey, String visibleText)
			throws IOException {

		seleniumFunNonPega.pickByVisbleText(elementkey, visibleText);
	}

	@Then("the user selects the dropdown value {string} ByValue {string}")
	public void the_user_selects_the_dropdown_value_ByValue(String elementkey, String value) throws IOException {

		seleniumFunNonPega.pickByValue(elementkey, value);
	}

	@Then("the user switches window ByIndex {string}")
	public void the_user_switches_to_window_ByIndex(String value) {

		seleniumFunNonPega.switchToWindowByIndex(value);
	}

	@Then("the user switches window ByURL {string}")
	public void the_user_switches_to_window_ByURL(String URLname) {

		seleniumFunNonPega.switchToWindowByURL(URLname);
	}

	@Then("the user switches window ByTitle {string}")
	public void the_user_switches_to_window_ByTitle(String title) {

		seleniumFunNonPega.switchToWindowByTitle(title);
	}

	@Then("the user does leftClick on {string}")
	public void the_user_does_leftClick_on(String elementkey) throws IOException {

		seleniumFunNonPega.performLeftClick(elementkey);
	}

	@Then("the user does rightClick on {string}")
	public void the_user_does_rightClick_on(String elementkey) throws IOException {

		seleniumFunNonPega.performRightClick(elementkey);
	}

	@Then("the user does doubleClick on {string}")
	public void the_user_does_doubleClick_on(String elementkey) throws IOException {

		seleniumFunNonPega.performDoubleClick(elementkey);
	}

	@Then("the user moves to {string}")
	public void the_user_moves_to(String elementkey) throws IOException {

		seleniumFunNonPega.performMoveToElement(elementkey);
	}

	@Then("the user drags the {string} and drops the {string}")
	public void the_user_drags_the_and_drops_the(String elementkey, String elementkey1) throws IOException {

		seleniumFunNonPega.performDragandDrop(elementkey, elementkey1);
	}

	@Then("the user does clickAndHold the {string}")
	public void the_user_does_clickAndHold_the(String elementkey) throws IOException {

		seleniumFunNonPega.performClickAndHold(elementkey);
	}

	@Then("the user does enter value in {string} filed with {string}")
	public void the_user_does_enter_value_in_filed_with(String elementkey, String inputData) throws IOException {

		seleniumFunNonPega.performinputTextBox(elementkey, inputData);
	}

	@Then("the user validates all the verification")
	public void the_user_validates_all_the_verification() {

		seleniumFunNonPega.endOfAssert();
	}

	@Then("the user verifies the pagetitle {string}")
	public void the_user_verifies_the_pagetitle(String actualTitle) throws IOException {

		seleniumFunNonPega.verifyPageTitle(actualTitle);
	}

	@Then("the user verifies the currentURL {string}")
	public void the_user_verifies_the_currentURL(String actualURL) throws IOException {

		seleniumFunNonPega.verifyCurrentURL(actualURL);
	}

	@Then("the user verifies the element is displayed {string}")
	public void the_user_verifies_the_element_is_displayed(String elementkey) throws IOException {

		seleniumFunNonPega.verifyElementisDisplayed(elementkey);
	}

	@Then("the user verifies the element is enabled {string}")
	public void the_user_verifies_the_element_is_enabled(String elementkey) throws IOException {

		seleniumFunNonPega.verifyElementisEnabled(elementkey);
	}

	@Then("the user verifies the element is selected {string}")
	public void the_user_verifies_the_element_is_selected(String elementkey) throws IOException {

		seleniumFunNonPega.verifyElementisSelected(elementkey);
	}

	@Then("the user verifies the alert text {string}")
	public void the_user_verifies_the_alert_text(String actualData) throws IOException {

		seleniumFunNonPega.verifygetTextDataFromAlert(actualData);
	}

	@Then("the user verifies expected data of {string} is same as actual data {string}")
	public void the_user_verifies_expected_data_of_is_same_as_actual_data(String elementkey, String actualData)
			throws IOException {

		seleniumFunNonPega.verifygetText(elementkey, actualData);
	}

	@Then("the user verifies the element {string} is {string} of attribute {string}")
	public void the_user_verifies_the_element_is_of_attribute(String elementkey, String attributevalue,
			String actualvalue) throws IOException {

		seleniumFunNonPega.verifyAttributeValue(elementkey, attributevalue, actualvalue);
	}

	@Then("the user performs Enter and KeyDown")
	public void the_user_performs_Enter_and_KeyDown() throws AWTException, InterruptedException {

		seleniumFunNonPega.key_ArrowDown();
		seleniumFunNonPega.key_ArrowDown();
		seleniumFunNonPega.key_Enter();
	}

	@Then("the user selects use template option from Actions {string}")
	public void the_user_selects_use_template_option(String status) throws Exception {

		homepage.useTemplate(status);
	}

	@Then("upload documents with one supported file type {string}")
	public void upload_documents_with_one_supported_file_type(String fileTyp1) throws Exception {
		homepage.clickOnUploadButtoninInitiation(fileTyp1);
	}

	@And("the user should clicks on the Submit button in upload popup")
	public void the_user_should_clicks_on_the_Submit_button_in_upload_popup() throws Exception {

		homepage.clickOnSubmit();
	}

	@Then("click on Submit button")
	public void click_on_submit_button() throws Exception {
		homepage.clickOnSubmitFinal();
	}

	@Then("validate the comments section {string} {string} {string}")
	public void validate_the_comments_section(String actionName, String actionComments, String actionBy)
			throws Exception {

		homepage.validateComments(actionName, actionComments, actionBy);

	}

	@Then("User click on Related Cases section from case360")
	public void validate_the_comments_section() throws Exception {

		homepage.validateRelatedCases();

	}

	@And("capture the {string}")
	public void capture_the_case_id(String caseID) throws Exception {
		homepage.captureCaseID(caseID);

	}

	@Then("the user clicks on the the workbasket CSL1 {string}")
	public void the_user_clicks_on_the_the_CSL1_workbasket(String value) {

		homepage.clickOnCSL1WorkBench(value);
	}

	@Then("the user clicks on the the workbasket {string}")
	public void the_user_clicks_on_the_the_workbasket(String value) {

		homepage.clickOnWorkBench(value);
	}

	@Then("the user clicks on the COPPL1 workbasket {string}")
	public void the_user_clicks_on_the_the_COPPL1_workbasket(String value) {

		homepage.clickOn_COPPL1_WorkBench(value);
	}

	@Then("the user select the captured case id from the Process Id and click the filtered case {string}")
	public void the_user_clicks_on_the_Process_Id_option(String path) throws Exception {

		homepage.clickOnFilterToChooseRelevantCase(path);
	}

	@Then("the user select the captured case id from the Process Id and click the filtered case - Priority check {string}")
	public void the_user_clicks_on_the_Process_Id_option_along_with_priority_check(String priority) throws Exception {

		homepage.clickOnFilterToChooseRelevantCaseToCheckPriority(priority);
	}

	@Then("User cancels the request {string}")
	public void User_cancels_the_request(String cancelResn) throws Exception {

		homepage.cancelRequest(cancelResn);
	}

	@Then("verify the status {string}")
	public void verify_the_status(String status) throws Exception {
		homepage.verifyCompletedStatus(status);
	}

	@Then("the user filters the cancelled case{string}")
	public void the_user_filters_the_cancelled_case(String path) throws Exception {

		homepage.clickOnFilterToChooseCase(path);

	}

	@Then("operator approves the cancel request {string} {string}")
	public void operator_approves_the_cancel_request(String cancelResn, String status) throws Exception {

		homepage.cancelRequestApprove(cancelResn, status);
	}

	@Then("the user assigns priority")
	public void the_user_assigns_priority() throws Exception {
		homepage.assignPriority();
	}

	@Then("upload documents with all supported file types {string} {string} {string} {string} {string} {string}")
	public void upload_documents_with_all_supported_file_types(String fileTyp1, String fileTyp2, String fileTyp3,
			String fileTyp4, String fileTyp5, String fileTyp6) throws Exception {
		homepage.clickOnUploadButtoninInitiation(fileTyp1, fileTyp2, fileTyp3, fileTyp4, fileTyp5, fileTyp6);
	}

	@Then("the user select the captured case id from the workbasket and click the filtered case {string} {string}")
	public void the_user_select_the_captured_case_id_from_the_workbasket_and_click_the_filtered_case_along_with_priority_check(
			String path, String priority) throws Exception {

		homepage.clickOnWorkbasketFilterToChooseRelevantCase(path, priority);

	}

	@Then("enter client comments {string}")
	public void enter_client_comments(String eKey) throws Exception {

		homepage.enterClientComments(eKey);
	}

	@Then("verify summary page title {string}")
	public void verify_summary_page_title(String ekey) throws Exception {
		homepage.verifySummaryInitiationTitle(ekey);
	}

	@Then("the user select the captured case id from the workbasket and click the filtered case {string}")
	public void the_user_select_the_captured_case_id_from_the_workbasket_and_click_the_filtered_case(String path)
			throws Exception {

		homepage.clickOnWorkbasketFilterToChooseRelevantCase(path);

	}

	@Then("the user provides the external comments as {string}")
	public void the_user_provides_the_external_comments(String cmnts) throws Exception {

		homepage.enterExternalCmnts(cmnts);

	}

	@Then("verify the reject reason comments submitted by previous operator is displayed or not {string}")
	public void verify_the_reject_reason_comments_submitted_by_previous_operator_is_displayed(String cmnts)
			throws Throwable {

		homepage.verifyRejectionComments(cmnts);
	}

	@Then("validate the comments section {string} {string} {string} - client")
	public void validate_the_comments_section_client(String actionName, String actionComments, String actionBy)
			throws Exception {

		homepage.validateCommentsClient(actionName, actionComments, actionBy);

	}

	@And("wait for loading to get completed")
	public void wait_for_loading() throws Exception {
		homepage.waitForLoading();
	}

	@And("wait for success message")
	public void wait_for_success_message() throws Exception {
		homepage.waitForSuccessMessage();
	}

	@Then("upload documents with one supported file type {string} - Second")
	public void upload_documents_with_one_supported_file_type_two(String fileTyp1) throws Exception {
		homepage.clickOnUploadButtoninInitiationTwo(fileTyp1);
	}

}
