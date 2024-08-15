package com.areteans.ataf.PageObjects;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.areteans.ataf.GeneralHelperSel.SeleniumFunc;
import com.areteans.ataf.TestBase.TestBase;
import com.cucumber.framework.pageconstants.InitiationL2PageLoc;

public class InitiationL2Page extends CustomerServ implements InitiationL2PageLoc {
	InitiationL2Page logoutpage;

	public InitiationL2Page(WebDriver driver) {
		super(driver);

	}

	public void sendLogoutObject(InitiationL2Page logoutpage) {
		this.logoutpage = logoutpage;
		// System.out.println("In sendLogoutObject method page"+this.logoutpage);
	}

	public void clickOn_FSNA_Client_Services_L2(String title) throws Exception {
		try {

			xpath_GenericMethod_Click(FSNA_client_services_L2_xpath);

			Assert.assertTrue(true, "Successfully clicked on L2 workbasket");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To clicked on L2 workbasket");
		}

	}
	
	public void clickOn_CasesToBeProcessed() throws Exception {
		try {

			xpath_GenericMethod_Click(cases_To_Be_Processed_xpath);

			Assert.assertTrue(true, "Successfully clicked on L2 workbasket");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To clicked on L2 workbasket");
		}

	}

	public void clickOn_Process_ID_Dropdown() throws Exception {
		try {
			xpath_GenericMethod_Click(headerClick_xpath);
			xpath_GenericMethod_Click(process_ID_xpath);
			Assert.assertTrue(true, "select caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");
		}

	}
	
	public void clickOn_worklist_Process_ID_Dropdown() throws Exception {
		try {
			xpath_GenericMethod_Click(headerClick_xpath);
			xpath_GenericMethod_Click(worklist_process_ID_xpath);
			Assert.assertTrue(true, "select caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");
		}

	}
	
	public void clickOn_ApplyFilter() throws Exception {
		try {
			xpath_GenericMethod_Click(WF_ApplyFilter_xpath);
			Assert.assertTrue(true, "selected caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");

		}
	}

	public void clickOn_DesProcess_ID_Dropdown() throws Exception {
		try {
			xpath_GenericMethod_Click(filtr_description_ID_xpath);
			Assert.assertTrue(true, "select caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");
		}

	}

	public void clickOn_Process_ID() throws Exception {
		System.out.println("process id: " + TestBase.caseID);
		try {
		if (!(TestBase.caseID).isEmpty()) {		
			//xpath_GenericMethod_Click(processID_xpath);
			WebElement elementTest = driver.findElement(By.xpath("//a[contains (text(),'"+TestBase.caseID+"')]"));
			System.out.println("//div//a[contains (text(),'"+TestBase.caseID+"')]");
			elementTest.click();
		}
		else {

			String path = System.getProperty("user.dir");
			String filePath = path + "\\attachments\\TestData1.xlsx";

			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			String caseID = sheet.getRow(0).getCell(0).getStringCellValue();
			WebElement elementTest = driver.findElement(By.xpath("//a[contains (text(),'"+caseID+"')]"));
			System.out.println("//div//a[contains (text(),'"+caseID+"')]");
			elementTest.click();
		}

			Assert.assertTrue(true, "selected caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");

		}
	}
	
	public void clickOn_Process_ID_worklist() throws Exception {
		
		try {
			
			xpath_GenericMethod_Click(processID_xpath);
			Assert.assertTrue(true, "selected caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");

		}
	}

	public void clickOn_FundFilter() throws Exception {
		try {
			xpath_GenericMethod_Click(fundFilter_xpath);
			Assert.assertTrue(true, "selected caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");

		}

	}

	public void clickOn_Approve() throws Exception {
		try {
			// Mandatory sleep
			waitFor(4);
			xpath_GenericMethod_Click(approve_xpath);

			Assert.assertTrue(true, "select approve button Successfully");
		} catch (Exception e) {
			xpath_GenericMethod_Click(approve_xpath);

		}

	}

	public void clickOn_Approve_FOF() throws Exception {
		try {
			waitFor(2);
			xpath_GenericMethod_Click(approve_FOF_xpath);

		} catch (Exception e) {
			xpath_GenericMethod_Click(approve_FOF_xpath);
		}

	}

	public void clickOn_Approve_3() throws Exception {

		xpath_GenericMethod_Click(approve_3_xpath);

	}

	public void verifyTaskAssignedToL2(String submit) throws Exception {

		xpath_GenericMethod_Click(submit_button_xpath);
		xpath_GenericMethod_HoverOnDemoScreenPops(task_assign_xpath);
		xpath_Genericmethod_VerifyTextContains(task_assign_xpath, "Task assigned to: FSNA Client Services 002");
	}

	public void clickOnDownArrow() throws Exception {

		try { // driver.findElement(By.xpath(login_popup_close_xpath)).click();
			xpath_GenericMethod_Click(login_popup_close_xpath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try { // driver.findElement(By.xpath(logout_icon_xpath)).click();
			xpath_GenericMethod_Click(logout_icon_xpath); // waitFor(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickOnLogoutButton() throws Exception {
		/*
		 * try { //driver.findElement(By.xpath(login_popup_close_xpath)).click();
		 * xpath_GenericMethod_Click(login_popup_close_xpath); }catch(Exception e) {
		 * System.out.println(e.getMessage()); }
		 */

		/*
		 * try { //driver.findElement(By.xpath(logout_icon_xpath)).click();
		 * 
		 * xpath_GenericMethod_Click(logout_icon_xpath); waitFor(3); }catch(Exception e)
		 * { System.out.println(e.getMessage()); }
		 */
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(logout_icon_xpath);
	}

	public void clickOnLogoutLink() {
		try {
			xpath_GenericMethod_Click(logout_xpath);
			waitFor(1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// robotClass();
		waitFor(1);
		driver.switchTo().alert().dismiss();
		waitFor(2);
	}

	public boolean verifyUsernameField_IsDisplayed() {
		try {
			Assert.assertTrue(driver.findElement(By.xpath(username_xpath)).isDisplayed(), "Logout is not successful");
			// System.out.println("verify UsernameField_IsDisplayed method" + driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// when case created in client

	public void clickOnReject() throws Exception {

		xpath_GenericMethod_Click(reject_xpath);

	}

	public void clickOnInvestor() throws Exception {

		xpath_GenericMethod_Click(labelInvestor_xpath);

	}

	public void clickOnReject_2() throws Exception {
		try {
			xpath_GenericMethod_Click(reject_xpath1);

		} catch (Exception e) {
			xpath_GenericMethod_Click(reject_xpath1);
		}

	}

	public void clickOnReject_3() throws Exception {

		try {
			xpath_GenericMethod_Click(reject_xpath2);

		} catch (Exception e) {
			xpath_GenericMethod_Click(reject_xpath2);
		}

	}

	public void clickOnClient() throws Exception {

		xpath_GenericMethod_Click(client_xpath);

	}

	public void enterReason(String reason) throws Exception {

		xpath_GenericMethod_Sendkeys(reason_xpath, reason);

	}

	public void enterReason2(String reason) throws Exception {

		xpath_GenericMethod_Sendkeys(reason_xpath_1, reason);

	}

	// select Client servics L1 for rejection

	public void clickOnClientServicesL1() throws Exception {

		xpath_GenericMethod_Click(client_service_l1_xpath);

	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		waitFor(3);
		xpath_Genericmethod_VerifyTextContains(investment_review_pagetitle_xpath, pageTitle);

	}

	public void enter_reason() throws Exception {

		xpath_GenericMethod_Sendkeys(reason_xpath, "Reason");

	}

	public void clickOnFilterInWorkBasket() throws Exception {

		try {

			xpath_GenericMethod_Click(filter2);

		} catch (Exception e) {

			xpath_GenericMethod_Click(filter2);

		}

	}

	public void clickOnFilterInWorkBasketDes() throws Exception {

		try {

			xpath_GenericMethod_Click(filterDescription);

		} catch (Exception e) {

			xpath_GenericMethod_Click(filterDescription);

		}

	}

	public void clickOnWorkBasketFileredID() throws Exception {

		// waitForElement(driver.findElement(By.xpath(filteredCaseId)), 5);

		waitForElement(driver.findElement(By.xpath(workbasketfilteredCaseId)), 10);

		xpath_GenericMethod_Click(workbasketfilteredCaseId);

	}

	public void clickOnApproveForOutcomeOfReview() throws Exception {

		// clicks on "Accept" for "outcome of review"
		WebElement toggleYes = driver.findElement(By.xpath(btn_clickApproveForOutcomeOfReview));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

		// clicks on "Accept" for "outcome of review"
//		xpath_GenericMethod_Click(btn_clickApproveForOutcomeOfReview);

	}

	public void verifyErrorValidation(String intlCmnts, String errorValdtn) throws Exception {
		// clicks on "Reject" for "confirm decision"
		xpath_GenericMethod_Click(btn_clickReject);

		// enter Reject reason
		xpath_GenericMethod_Sendkeys(txa_rejectRsn, intlCmnts);

		// Click on "Approve" on "outcome of review"
		xpath_GenericMethod_Click(btn_clickApproveForOutcomeOfReview);

		// clicks submit button
		xpath_GenericMethod_Click(btn_FinalSubmit);

		// wait
		waitForElement(driver.findElement(By.xpath(txt_errorMessage)), 60);
		// error validation
		String errorMsg = xpath_Genericmethod_getElementText(txt_errorMessage);

		// validation to check error message
		Assert.assertEquals(errorValdtn, errorMsg);

	}

	public void clickOnRejectForOutcomeOfReview() throws Exception {
		try {
			// clicks on "Reject" for "outcome of review"
			// Mandatory wait
			waitFor(3);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReview))).perform();
			a.click(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReview))).perform();
		} catch (Exception e) {
			xpath_GenericMethod_Click(btn_clickRejectForOutcomeOfReview);
		}

	}

	public void enterRejectReason(String reason) throws Exception {
		// Enter reject reason
		xpath_GenericMethod_ClickWithoutJS(txt_RejectReason);
		xpath_GenericMethod_Sendkeys(txt_RejectReason, reason);

	}

	public void approveExternalComments() {

		WebElement toggleYes = driver.findElement(By.xpath(toggle_ApproveExtlCommnts));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void assignToOperator() throws Exception {

		xpath_GenericMethod_Click(btn_ClientServicesL1);
	}

	public void verifyErrorValidationDIP(String intlCmnts, String errorValdtn) throws Exception {
		// clicks on "Reject" for "confirm decision"
		xpath_GenericMethod_Click(btn_DIP_clickReject);

		// enter Reject reason
		xpath_GenericMethod_Click(txa_DIP_rejectRsn);
		xpath_GenericMethod_Sendkeys(txa_DIP_rejectRsn, intlCmnts);

		// Click on "Approve" on "outcome of review"
		xpath_GenericMethod_Click(btn_clickApproveForOutcomeOfReview);

		// clicks submit button
		xpath_GenericMethod_Click(btn_FinalSubmit);

		// wait
		waitForElement(driver.findElement(By.xpath(txt_errorMessage)), 60);
		// error validation
		String errorMsg = xpath_Genericmethod_getElementText(txt_errorMessage);

		// validation to check error message
		Assert.assertEquals(errorValdtn, errorMsg);

	}

	public void clickOnRejectForOutcomeOfReviewDI() throws Exception {
		try {
			// Mandatory wait
			waitFor(6);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_DIP_clickRejectForOutcomeOfReview))).perform();
			a.click(driver.findElement(By.xpath(btn_DIP_clickRejectForOutcomeOfReview))).perform();

		} catch (Exception e) {

			xpath_GenericMethod_Click(btn_DIP_clickRejectForOutcomeOfReview);

		}

	}

	public void clickOnRejectForOutcomeOfReviewFOF() throws Exception {
		try {
			// Mandatory sleep
			waitFor(3);
			// clicks on "Reject" for "outcome of review"

			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReviewFOF))).perform();
			a.click(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReviewFOF))).perform();

		} catch (Exception e) {

			xpath_GenericMethod_Click(btn_clickRejectForOutcomeOfReviewFOF);

		}

	}

	public void clickOnRejectForOutcomeOfReviewFOFclbck() throws Exception {
		try {

			// Mandatory sleep
			waitFor(3);
			// clicks on "Reject" for "outcome of review"

			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReviewL2))).perform();
			a.click(driver.findElement(By.xpath(btn_clickRejectForOutcomeOfReviewL2))).perform();

		} catch (Exception e) {
			xpath_GenericMethod_Click(btn_clickRejectForOutcomeOfReviewL2);
		}

	}

	public void clickOnApproveForOutcomeOfReviewFOFcp() throws Exception {
		try {
			// Mandatory sleep
			waitFor(3);
			// clicks on "Accept" for "outcome of review"

			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_clickApproveForOutcomeOfReviewFOFcp))).perform();
			a.click(driver.findElement(By.xpath(btn_clickApproveForOutcomeOfReviewFOFcp))).perform();

		} catch (Exception e) {
			xpath_GenericMethod_Click(btn_clickApproveForOutcomeOfReviewFOFcp);
		}

	}

	public void selectsApproveSecondFund() {
		try {
			waitFor(2);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_Apprve_scndTab))).perform();
			a.click(driver.findElement(By.xpath(btn_Apprve_scndTab))).perform();
		} catch (Exception e) {
			waitFor(2);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_Apprve_scndTab))).perform();
			a.click(driver.findElement(By.xpath(btn_Apprve_scndTab))).perform();
		}

	}
	
	public void clickOn_Phase_Process_ID_Dropdown() throws Exception {
		try {
			xpath_GenericMethod_Click(client_wrkBasket_PhaseFilter);
			Assert.assertTrue(true, "select caseID Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select caseID");
		}

	}

}
