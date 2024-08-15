package com.areteans.ataf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.ReviewL2PageLoc;

public class ReviewL2Page extends CustomerServ implements ReviewL2PageLoc {

	ReviewL2Page reviewl2page;

	public ReviewL2Page(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(ReviewL2Page reviewL2page2) {
		this.reviewl2page = reviewl2page;
	}

	public void verifyInitiationScreen(String pageTitle, String approve) throws Exception {

		xpath_Genericmethod_VerifyTextContains(l2_investor_notice_review_xpath, pageTitle);
		try {
			// Mandatory sleep
			waitFor(3);
			xpath_GenericMethod_Click(approve_xpath);
		} catch (Exception e) {
			xpath_GenericMethod_Click(approve_xpath);
		}
	}

	public void verifyL2CallBackReviewTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(callBackReviewTitle)), 60);
		String actualText = getElementText(callBackReviewTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOnApprove(String ans) throws Exception {

		waitForElement(driver.findElement(By.xpath(approve)), 60);
		xpath_GenericMethod_Click(approve);

	}

	public void verifyL2ExpensePaymentProcessingReviewTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L2ExpensePaymentProcessingReviewTitle)), 60);
		String actualText = getElementText(L2ExpensePaymentProcessingReviewTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOntoggle2() throws Exception {

		xpath_GenericMethod_Click(toggle2);
	}

	public void verifyL2ExpensePaymentProcessingReviewAndReleaseTitle(String pagetitle) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(L2ExpensePaymentProcessingReviewAndReleaseTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOnBankingPlatformToggle(String ans) throws Exception {
		WebElement toggleYes = driver.findElement(By.xpath(setup_toggle));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOnPaymentReleaseToggle(String ans) throws Exception {
		WebElement toggleYes = driver.findElement(By.xpath(payment_release_toggle));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void checkIfBankingPlatformAndCallBackTogglesAreDisabled() {

		// Banking platform toggle "disabled" check

		if (driver.findElement(By.xpath(toggle_DisabledCheck1)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "Banking platform toggle is disabled");
		} else {
			Assert.assertTrue(false, "Banking platform toggle is not disabled");
		}

		// call back toggle "disabled" check
		if (driver.findElement(By.xpath(toggle_DisabledCheck2)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "call back toggle is disabled");
		} else {
			Assert.assertTrue(false, "call back toggle is not disabled");
		}

	}

	public void provideRejectReason(String cmnts) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_Reason, cmnts);

	}

	public void checkIfBankingPlatformIsDisabled() {
		// Banking platform toggle "disabled" check
		if (driver.findElement(By.xpath(toggle_DisabledCheck1)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "Banking platform toggle is disabled");
		} else {
			Assert.assertTrue(false, "Banking platform toggle is not disabled");
		}

	}

	public void providePaymentRejectReason(String cmnts) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(txt_PaymentRejectReason, cmnts);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txt_PaymentRejectReason, cmnts);
		}

	}

	public void verifyPaymentErrorMessage(String message) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(txt_PaymentErrorMsg);
		Assert.assertEquals(actualText, message);

	}

	public void reviewAllPayments() throws Exception {

		for (int i = 0; i <= 50; i++) {

			xpath_GenericMethod_ClickWithoutJS(toggle_ReviewPayments);

			if (driver.findElement(By.xpath(toggle_ReviewPayments)).getAttribute("checked") == null) {
				break;
			} else if ((driver.findElement(By.xpath(toggle_ReviewPayments)).getAttribute("checked") != null)) {

				continue;
			}
		}
	}

	public void provideReason(String cmnts) throws Exception {
		xpath_GenericMethod_Click(txt_Reason);
		xpath_GenericMethod_Sendkeys(txt_Reason, cmnts);
	}

	public void checkIfBankingPlatformAndCallBackTogglesAreDisabled_DIP() {
		// Banking platform toggle "disabled" check

		if (driver.findElement(By.xpath(toggle_DIP_DisabledCheck1)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "Banking platform toggle is disabled");
		} else {
			Assert.assertTrue(false, "Banking platform toggle is not disabled");
		}

		// call back toggle "disabled" check
		if (driver.findElement(By.xpath(toggle_DisabledCheck2)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "call back toggle is disabled");
		} else {
			Assert.assertTrue(false, "call back toggle is not disabled");
		}

	}

	public void checkIfBankingPlatformIsDisabledDIP() {
		// Banking platform toggle "disabled" check
		if (driver.findElement(By.xpath(toggle_DIP_DisabledCheck1)).getAttribute("disabled") == null) {
			Assert.assertTrue(true, "Banking platform toggle is disabled");
		} else {
			Assert.assertTrue(false, "Banking platform toggle is not disabled");
		}

	}

	public void reviewAllPaymentsDIP() {
		try {

			WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_ReviewPayments));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);

		} catch (Exception e) {

			WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_ReviewPayments));
			Actions a = new Actions(driver);
			a.moveToElement(toggleYes).click().build().perform();

		}

	}

	public void verifyPaymentErrorMessageDIP(String message) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(txt_DIP_PaymentErrorMsg);
		Assert.assertEquals(actualText, message);

	}
}
