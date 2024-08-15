package com.areteans.ataf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.CashReconciliationL2PageLoc;

public class CashReconciliationL2Page extends CustomerServ implements CashReconciliationL2PageLoc {

	CashReconciliationL2Page cashreconciliation_L2_page;

	public CashReconciliationL2Page(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(CashReconciliationL2Page cashreconciliationL2page,
			CashReconciliationL2Page cashreconciliation_L2_page) {
		this.cashreconciliation_L2_page = cashreconciliation_L2_page;
	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextEquals(l2_cash_reconciliation, pageTitle);

	}

	public void verifyPaymentReconciliationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_reconciliation_xpath, pageTitle);

	}

	public void verifyL1NoticeDistributionScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(notice_distribution_pagetitle_xpath, pageTitle);

	}

	public void verifyL2NoticeDistributionScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(l2_notice_distribution_pagetitle_xpath, pageTitle);

	}

	public void verifyL2ReconciliationReviewScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(l2reconciliationreview_pagetitle_xpath, pageTitle);

	}

	public void clickOn_AllPayments_Received_toggle() throws Exception {

		// xpath_GenericMethod_Click(toggle_xpath);

		xpath_GenericMethod_scrollIntoView(total_amount_received_xpath);
		WebElement toggleYes = driver.findElement(By.xpath(all_payments_received_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Cash_Collection_Update_toggle() throws Exception {

		// xpath_GenericMethod_Click(toggle_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(cash_collection_update_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verify_Process_Completed(String completed) throws Exception {

		xpath_Genericmethod_VerifyTextContains(process_completed_xpath, completed);

	}

	public void verify_Case_Status(String status) throws Exception {

	}

	public void click_On_workbasket_COPP_L2(String workbasket) throws Exception {

		xpath_GenericMethod_Click(workbasket_COPPL2_xpath);

	}

	public void verifyPaymentReviewScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_review_pagetiltle_xpath, pageTitle);

	}

	public void verifyPaymentReleaseScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_release_xpath, pageTitle);

	}

	public void clickOn_Payments1_toggle() throws Exception {

		xpath_GenericMethod_scrollIntoView(bankingplatform_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(payments1_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Payments2_toggle() throws Exception {

		xpath_GenericMethod_scrollIntoView(payments2_toggle_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(payments2_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Payments3_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(payments3_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Distributed_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(distributed_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Toggle_Button2_Yes() throws Exception {

		waitFor(2);
		WebElement toggleYes = driver.findElement(By.xpath(toggle2_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Notice_Toggle__Yes() throws Exception {

		waitFor(2);
		WebElement toggleYes = driver.findElement(By.xpath(toggle3_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_accounting_review_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(accounting_review_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verifyCompletedStatus(String compeletedStatus) throws Exception {
		//updated the method by parameterizing the xpath
		WebElement element = driver.findElement(By.xpath(String.format(Status_txt_xpath1, compeletedStatus)));
		String ResloveStatus = element.getText();
		Assert.assertEquals(ResloveStatus, compeletedStatus);
	}

	public void clickOnPaymentReceivedToggle() {
		WebElement toggleYes = driver.findElement(By.xpath(btn_PaymentReceived));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOnAccReviewToggle() {
		WebElement toggleYes = driver.findElement(By.xpath(btn_AccReview));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verifyL2CashReconcilationReviewTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L2CashReconcilationReviewTitle)), 30);
		String actualText = getElementText(L2CashReconcilationReviewTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void verifySuccessfulMessage(String message) throws Exception {
		xpath_Genericmethod_verifyElementPresent(Resolved);
	}
}
