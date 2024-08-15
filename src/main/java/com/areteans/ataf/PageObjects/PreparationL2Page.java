package com.areteans.ataf.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.PrepartaionLPageLoc;

public class PreparationL2Page extends CustomerServ implements PrepartaionLPageLoc {

	PreparationL2Page payment_data;

	public PreparationL2Page(WebDriver driver) {
		super(driver);
	}

	public void sendPaymentObject(PreparationL2Page payment_data) {
		this.payment_data = payment_data;
	}

	public void verifyInitiationScreen(String pageTitle, String approve) throws Exception {

		xpath_Genericmethod_VerifyTextContains(l2_allocation_file_review_xpath, pageTitle);
		xpath_GenericMethod_Click(approve_xpath);
	}

	public void verifyInitiationScreenAndReject(String pageTitle, String reject) throws Exception {

		// xpath_Genericmethod_VerifyTextContains(l2_allocation_file_review_xpath,pageTitle);
		xpath_GenericMethod_Click(reject_xpath);
	}

	public void enterReason() throws Exception {

		xpath_GenericMethod_Click(reason_textbox_xpath);

		xpath_GenericMethod_Sendkeys(reason_textbox_xpath, "reason");
	}

	public void verify_investor_List_filed(String filed1, String filed2, String filed3, String filed4)
			throws Exception {

		xpath_Genericmethod_VerifyTextContains(investor_xpath, filed1);
		xpath_Genericmethod_VerifyTextContains(mcp_id_xpath, filed2);
		xpath_Genericmethod_VerifyTextContains(alternative_ID_xpath, filed3);
		xpath_Genericmethod_VerifyTextContains(total_amount_xpath, filed4);
		xpath_GenericMethod_Click(investor_list);
	}

	public void enter_internal_filed(String internal) throws Exception {

		xpath_GenericMethod_Sendkeys(internal_xpath, "internal comments");

	}

	public void click_On_Approve_toggleButton(String approve) throws Exception {
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(approve_toggle_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(approve_toggle_xpath);
		}

	}

	public void click_On_Submit(String submit) throws Exception {

		try {
			xpath_GenericMethod_scrollIntoView(submit_button_xpath);
			xpath_GenericMethod_Click(submit_button_xpath);
			Assert.assertTrue(true, "click on submit button Successfully");
		} catch (Exception e) {
			xpath_GenericMethod_Click(submit_button_xpath);
			Assert.assertTrue(false, "Unable To click on submit button");
		}
	}

	public void click_On_Submit_SummaryPage() throws Exception {

		xpath_GenericMethod_scrollIntoView(submit_button_xpath);
		xpath_Genericmethod_VerifyTextContains(summarypage_title_xpath, "Summary - Initiation");
		xpath_GenericMethod_Click(submit_button_xpath);

	}

	public void verifyL2CallBackReviewScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(callbackreview_pagetitle_xpath, pageTitle);

	}

	public void clickOnWorkBench(String task) throws Exception {
		xpath_GenericMethod_Click(wrk_coppL1);
	}

	public void verifyExpensePaymentPreparationTitleL2(String pagetitle) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(L2ExpensePaymentPreparationTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void selectDropDownValue(String dropDown, String value) throws Exception {

		for (int i = 1; i < 50; i++) {
			{
				if (driver.findElement(By.xpath(confirmDecisionDrpDown_xpath)).getAttribute("value").isEmpty()) {
					xpath_GenericMethod_Click(confirmDecisionDrpDown_xpath);
					List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
					for (WebElement webElement : dropdownvalues) {
						if (webElement.getText().equals(value)) {
							webElement.click();
						}
					}
					if (driver.findElement(By.xpath(confirmDecisionDrpDown_xpath)).getAttribute("value")
							.equals(value)) {
						break;
					}
					Assert.assertTrue(true, "Selected confirmDecision successfully ");
				}
			}
		}

	}

	public void selectDropDownValueForSecondInvoice(String dropDown, String value) throws Exception {

		for (int i = 1; i < 50; i++) {
			{
				if (driver.findElement(By.xpath(confirmDecisionDrpDownSecondInvoice_xpath)).getAttribute("value")
						.isEmpty()) {
					xpath_GenericMethod_Click(confirmDecisionDrpDownSecondInvoice_xpath);
					List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
					for (WebElement webElement : dropdownvalues) {
						if (webElement.getText().equals(value)) {
							webElement.click();
						}
					}
					if (driver.findElement(By.xpath(confirmDecisionDrpDownSecondInvoice_xpath)).getAttribute("value")
							.equals(value)) {
						break;
					}
					Assert.assertTrue(true, "Selected confirmDecision successfully ");
				}
			}
		}

	}

	public void verifyErrorMessage(String msg) throws Exception {
		// mandatory sleep
		waitFor(2);
		String actualText = xpath_Genericmethod_getElementText(error_msg_xpath);
		Assert.assertEquals(actualText, msg);

	}

	public void clickOnNxtFundTab() {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_click_fund))).perform();
			a.click(driver.findElement(By.xpath(btn_click_fund))).perform();
		} catch (Exception e) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_click_fund))).click().build().perform();
		}

	}

}
