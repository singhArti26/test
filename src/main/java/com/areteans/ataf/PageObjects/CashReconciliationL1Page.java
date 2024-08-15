package com.areteans.ataf.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.CashReconciliationL1PageLoc;

public class CashReconciliationL1Page extends CustomerServ implements CashReconciliationL1PageLoc {

	CashReconciliationL1Page cashreconciliation_L1_page;

	public CashReconciliationL1Page(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(CashReconciliationL1Page cashreconciliationL1page) {

		this.cashreconciliation_L1_page = cashreconciliation_L1_page;
	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(l1_cash_reconciliation, pageTitle);

	}

	public void verifyReconciliationScreen(String pageTitle) throws Exception {

		// xpath_GenericMethod_Click(left_arrow_xpath);
		xpath_Genericmethod_VerifyTextContains(pageTitle_xpath, pageTitle);

	}

	public void verifyPaymentPreparationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_preparation_screen_xpath, pageTitle);

	}

	public void verifyInvestorWireInstructionScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(investor_wire_instruction_xpath, pageTitle);

	}

	public void verifyPaymentReconciliationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(payment_reconciliation_screen_xpath, pageTitle);

	}

	public void verifyNoticeDistributionScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(notice_distribution_pagetitle_xpath, pageTitle);

	}

	public void verifyL1ReconciliationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(L1ReconciliationScreen_xpath, pageTitle);

	}

	public void verifyExecutedDocumentsReview(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(executeddocumentsreview_pagetitle_xpath, pageTitle);

	}

	public void click_On_workbasket_COPP_L1(String workbasket) throws Exception {

		xpath_GenericMethod_Click(workbasket_COPPL1_xpath);

	}

	public void clickOn_Paid_In_Full_Checkbox() throws Exception {

		xpath_GenericMethod_Click(paidinfull_checkbox_xpath);

	}

	public void clickOn_toggle() throws Exception {

		xpath_GenericMethod_scrollIntoView(toggle_xpath);
		WebElement toggleYes = driver.findElement(By.xpath(toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_firsttoggle() throws Exception {

		waitFor(3);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox1);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox1);
		}

	}

	public void clickOn_secondtoggle() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox2);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox2);
		}

	}

	public void clickOn_thridtoggle() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox3);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox3);
		}

	}

	public void clickOn_firsttoggle1() throws Exception {

		waitFor(3);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox4);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox4);
		}

	}

	public void clickOn_secondtoggle2() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox5);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox5);
		}

	}

	public void clickOn_thridtoggle3() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox6);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox6);
		}

	}

	public void clickOn_clienttoggle() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkbxPer1);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkbxPer1);
		}

	}

	public void clickOn_externaltoggle() throws Exception {

		waitFor(5);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkbxPer2);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkbxPer2);
		}

	}

	public void clickOn_toggle_button() throws Exception {

		xpath_GenericMethod_scrollIntoView(toggle_button_xpath);
		WebElement toggleYes = driver.findElement(By.xpath(toggle_button_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Payments1_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(payments1_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Payments2_toggle() throws Exception {

		xpath_GenericMethod_scrollIntoView(payments_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(payments2_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_Failed_Payments_Checkbox() throws Exception {

		xpath_GenericMethod_Click(failed_payments1_xpath);

		xpath_GenericMethod_Click(failed_payments2_xpath);

	}

	public void clickOn_NoticeDistribution_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(notice_distribution_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_accounting_review_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(accounting_review_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForCashRecon() throws Exception {
		WebElement toggleYes = driver.findElement(By.xpath(btn_cashRecon));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesForAccPlatform() throws Exception {
		WebElement toggleYes = driver.findElement(By.xpath(btn_accPlatform));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void verifyL1CashReconcilationTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L1CashReconcilationTitle)), 60);
		String actualText = getElementText(L1CashReconcilationTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void selectYesL1BankingPlatformToggle(String ans) throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(AccountingPlatformUpdatedToggle));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectYesL1PaymentReleaseToggle(String ans) throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(allPaymentsReleased_Toggle));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickandSelectAllOpencheck() throws Exception {

		waitFor(2);
		xpath_GenericMethod_Click(lnkOpenChecklist);
		List<WebElement> togglePer = driver.findElements(By.xpath(chkbxPer));

		System.out.println("the is" + togglePer.size());
		for (int i = 0; i < togglePer.size(); i++) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

//				waitFor(2);
//				textDescription.get(i + 1).click();

			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

			}
		}

	}

	public void clickandSelectAllOpencheckL2() throws Exception {

		waitFor(2);
		xpath_GenericMethod_Click(lnkOpenChecklist);
		List<WebElement> togglePer = driver.findElements(By.xpath(chkbxPer));

		System.out.println("the is" + togglePer.size());
		for (int i = 0; i < togglePer.size(); i++) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

//				waitFor(2);
//				textDescription.get(i + 1).click();

			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

			}
		}
		waitFor(5);

	}

	public void clickandSelectAllOpencheckCapitalActivity() throws Exception {

		waitFor(2);
		xpath_GenericMethod_Click(lnkOpenChecklist);
		List<WebElement> togglePer = driver.findElements(By.xpath(chkbxPer));

		System.out.println("the is" + togglePer.size());
		for (int i = 0; i < togglePer.size(); i++) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

//				waitFor(2);
//				textDescription.get(i + 1).click();

			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

			}
		}
		waitFor(10);

	}

	public void clickandSelectAllOpencheckbookaccruals() throws Exception {

		waitFor(2);
		xpath_GenericMethod_Click(lnkOpenChecklist);
		List<WebElement> togglePer = driver.findElements(By.xpath(chkbxPer));

		System.out.println("the is" + togglePer.size());
		for (int i = 1; i <= 14; i++) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

//				waitFor(2);
//				textDescription.get(i + 1).click();

			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", togglePer.get(i));

			}
		}
		waitFor(10);

	}

	public void chkDraftreportingrequired1() throws Exception {

		xpath_GenericMethod_Click(chkDraftreportingrequired1);
		// xpath_GenericMethod_Click(chkDraftreportingrequired2);

	}

	public void enterL1CashReconcilationsupport(String title) throws Exception {
		xpath_GenericMethod_Sendkeys(textComment, title);
	}

	public void enterL1CashReconcilationsupport1(String title) throws Exception {
		xpath_GenericMethod_Sendkeys(clientdesComment, title);
	}

}
