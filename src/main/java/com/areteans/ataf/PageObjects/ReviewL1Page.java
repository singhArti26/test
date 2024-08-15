package com.areteans.ataf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.ReviewL1PageLoc;

public class ReviewL1Page extends CustomerServ implements ReviewL1PageLoc {

	ReviewL1Page reviewl1_page;

	public ReviewL1Page(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(ReviewL1Page reviewL1page) {

		this.reviewl1_page = reviewl1_page;
	}

	public void verify_Investor_Wire_Instruction_Pagetitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(investor_wire_instruction_pagetitle_xpath, pageTitle);

	}

	public void verify_Notice_Preparation_Pagetitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(notice_preparation_pagetitle_xpath, pageTitle);

	}

	public void verify_pageTitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(title_xpath, pageTitle);

	}

	public void clickOn_Upload_Document() throws Exception {

		xpath_GenericMethod_Click(upload_document_xpath);

		String path = System.getProperty("user.dir");
		String noticeDocument = path + "\\attachments\\document1.pdf";
		driver.findElement(By.xpath(select_file_xpath)).sendKeys(noticeDocument);
		xpath_GenericMethod_scrollIntoView(document_category_xpath);
	}

	public void clickOn_toggleYes() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verifyRejectComments(String cmnts) throws Exception {
		// Verify the rejection commnets is correct or not
		String ActualCmnts = xpath_Genericmethod_getElementText(txt_RejectionReason);
		org.testng.Assert.assertEquals(ActualCmnts, cmnts);

	}

	public void selectYesForPaymentReleaseToggle() {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_PaymentRelease));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForAccountingPlatformToggle() {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_AccPlatformUpdated));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForPaymentReleaseToggleDIP() {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_PaymentRelease));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForAccountingPlatformToggleDIP() {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_AccPlatformUpdated));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForAccountingPlatformReviewToggleDIP() {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_AccPlatformReviewed));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

}
