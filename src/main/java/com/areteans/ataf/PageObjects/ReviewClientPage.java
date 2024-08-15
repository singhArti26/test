package com.areteans.ataf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.ReviewClientPageLoc;

public class ReviewClientPage extends CustomerServ implements ReviewClientPageLoc {

	ReviewClientPage reviewclient;

	public ReviewClientPage(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(ReviewClientPage reviewclientpage) {
		this.reviewclient = reviewclient;
	}

	public void verify_Workbasket(String title) throws Exception {

		xpath_GenericMethod_scrollIntoView(workbasket_xpath);

	}

	public void clickOn_Process_ID_Dropdown() throws Exception {

		xpath_GenericMethod_Click(process_ID_dropdown_xpath);

	}

	public void clickOn_Process_ID() throws Exception {

		xpath_GenericMethod_Click(processID_xpath);

	}

	public void clickOn_Allocation_File_Approve() throws Exception {
		waitFor(3);

		xpath_GenericMethod_Click(allocation_file_approve_xpath);

	}

	public void clickOn_Notices_Approve() throws Exception {

		xpath_GenericMethod_Click(notices_approve_xpath);

	}

	public void clickOn_Notice_Reject() throws Exception {

		xpath_GenericMethod_Click(allocation_file_approve_xpath);
		waitFor(2);
		try {
			xpath_GenericMethod_Click(reject_xpath);
		} catch (Exception e) {
			xpath_GenericMethod_Click(reject_xpath);
		}

	}

	public void clickOn_toggleYes() throws Exception {

		// xpath_GenericMethod_Click(toggle_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void click_On_LogOff_Button() throws Exception {

		try {
			xpath_GenericMethod_Click(c_logoff_xpath);
			xpath_GenericMethod_Click(log_off_xpath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(pagetitle_xpath, pageTitle);

	}

	public void click_On_Approve_toggleButton() throws Exception {

		WebElement approveYes = driver.findElement(By.xpath(toggle_button_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", approveYes);
	}

	public void verify_pageTitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_release_xpath, pageTitle);

	}

	public void verify_pagetitle(String title) throws Exception {

		xpath_GenericMethod_scrollIntoView(title_xpath);

	}

	public void clickOn_Toggle_Button1_Yes() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(toggle1_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verifyUploadExecutedDocumentsPageTitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(uploadexecuteddocuments_xpath, pageTitle);

	}

	public void verifyClientExpensePaymentReviewTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(ClientExpensePaymentReviewTitle)), 60);
		String actualText = getElementText(ClientExpensePaymentReviewTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOnToggle1(String ans) throws Exception {
		xpath_GenericMethod_Click(toggle1);

	}

	public void clickToggleYesForPaymentRelease() throws Exception {
		// Mandatory wait for loader icon to disappear
		waitFor(7);
		Actions a = new Actions(driver);
		a.click(driver.findElement(By.xpath(toggle_ReleasePayment))).perform();

	}

	public void clickOnUploadButtonOnClientPage(String file, String value1) throws Exception {
		// Mandatory sleep as "loader" icon is present for longer time
		waitFor(6);
		xpath_GenericMethod_Click(upload_doc_btn);
		String path = System.getProperty("user.dir");

		try {
			String file2 = path + "\\ExpensePaymentResources\\INV8000943936.pdf";
			waitFor(1);
			driver.findElement(By.xpath(select_file_button)).sendKeys(file2);
			waitFor(1);
			Assert.assertTrue(true, "document(s) upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload documents");
		}

	}

	public void clickToggleYesForPaymentReleaseDIP() {
		try {
			xpath_GenericMethod_Click(toggle_DIP_ReleasePayment);
//			WebElement toggle = driver.findElement(By.xpath(toggle_DIP_ReleasePayment));
//			Actions a = new Actions(driver);
//			a.moveToElement(toggle).click().build().perform();
		} catch (Exception e) {
			WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_ReleasePayment));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
		}
	}

	public void clickOn_Allocation_File_Approve_Distribution() throws Exception {
		try {
			waitFor(3);
			WebElement toggleYes = driver.findElement(By.xpath(allocation_file_approve_distribution));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
		} catch (Exception e) {
			xpath_GenericMethod_Click(allocation_file_approve_distribution);
		}

	}
}
