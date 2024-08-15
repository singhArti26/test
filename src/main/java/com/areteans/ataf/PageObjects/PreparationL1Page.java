package com.areteans.ataf.PageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.CommonPageLoc;
import com.cucumber.framework.pageconstants.PreparationL1PageLoc;

public class PreparationL1Page extends CustomerServ implements PreparationL1PageLoc, CommonPageLoc {

	PreparationL1Page logoutpage;

	public PreparationL1Page(WebDriver driver) {
		super(driver);

	}

	public void sendLogoutObject(InitiationL2Page logoutpage2) {
		this.logoutpage = logoutpage;
		// System.out.println("In sendLogoutObject method page"+this.logoutpage);
	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		try {

			xpath_Genericmethod_VerifyTextContains(l1_allocation_file_preparation, pageTitle);
			Assert.assertTrue(true, "verified L1 Allocation File Preparation Initiation Screen Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To verify L1 Allocation File Preparation Initiation Screen");
		}

	}

	public void verifyCallBackScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(callback_pagetitle_xpath, pageTitle);

	}

	public void verifyInitiationScreenForDistribution(String pageTitle) throws Exception {

		;
		xpath_Genericmethod_VerifyTextContains(l1_liquidity_check_xpath, pageTitle);

	}

	public void verifyL1_Liquidity_Resolution_PageTitle(String pageTitle) throws Exception {

		;
		xpath_Genericmethod_VerifyTextContains(liquidity_resolution_pagetitle_xpath, pageTitle);

	}

	public void clickOn_Upload_Document_For_Repository(String title) throws Exception {
		String path = System.getProperty("user.dir");
		String allocationfilepath = path + title;
		// "C:\\Automation\\ATAF_CAPITALCALL_8.9.23\\ATAF_CAPITALCALL\\attachments\\allocationfiletemplate.xlsx";

		try {
			xpath_GenericMethod_Click(imgUpload);

		} catch (Exception e) {
			xpath_GenericMethod_Click(imgUpload);
		}

//		waitFor(5);
//
//		Actions actions = new Actions(driver);
//		WebElement uploadChooseBtn = driver.findElement(By.xpath("//button[contains(text(),'Select file')]"));

//		try {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		} catch (Exception e) {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		}

		uploadFile(allocationfilepath);

		xpath_GenericMethod_Click(save_button_xpath);
		xpath_GenericMethod_Click(btn_ok_xpath);
		// xpath_GenericMethod_scrollIntoView(document_category_xpath);
		Assert.assertTrue(true, "document uploaded Successfully");

	}

	public void clickOn_Upload_Document(String title) throws Exception {
		String path = System.getProperty("user.dir");
		String allocationfilepath = path + title;
		// "C:\\Automation\\ATAF_CAPITALCALL_8.9.23\\ATAF_CAPITALCALL\\attachments\\allocationfiletemplate.xlsx";
		xpath_GenericMethod_Click(upload_document_xpath);
		waitFor(3);

//		Actions actions = new Actions(driver);
//		WebElement uploadChooseBtn = driver.findElement(By.xpath("//button[contains(text(),'Select file')]"));

//		try {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		} catch (Exception e) {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		}

//		uploadFile(allocationfilepath);
		driver.findElement(By.xpath(btn_selectFile)).sendKeys(allocationfilepath);
		xpath_GenericMethod_Click(submit_documents_xpath);

		// xpath_GenericMethod_scrollIntoView(document_category_xpath);
		Assert.assertTrue(true, "document uploaded Successfully");

	}

	public void clickOn_Upload_Document2(String title) throws Exception {
		String path = System.getProperty("user.dir");
		String allocationfilepath = path + title;
		// "C:\\Automation\\ATAF_CAPITALCALL_8.9.23\\ATAF_CAPITALCALL\\attachments\\allocationfiletemplate.xlsx";
		xpath_GenericMethod_Click(upload_document_xpath);

//		Actions actions = new Actions(driver);
//		WebElement uploadChooseBtn = driver.findElement(By.xpath("//button[contains(text(),'Select file')]"));
//
//		try {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		} catch (Exception e) {
//			actions.moveToElement(uploadChooseBtn).click().perform();
//		}
//
//		uploadFile(allocationfilepath);

		driver.findElement(By.xpath(btn_selectFile)).sendKeys(allocationfilepath);
		waitFor(2);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(system_screenshot_xpath, 1);

		xpath_GenericMethod_Click(submit_documents_xpath);
		// xpath_GenericMethod_scrollIntoView(document_category_xpath);
		Assert.assertTrue(true, "document uploaded Successfully");

	}

	public void clickOn_submit_button(String submit) throws Exception {

		try {

			xpath_GenericMethod_Click(submit_documents_xpath);

			Assert.assertTrue(true, "Click on submit button successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on submit button");
		}

	}

	public void clickOn_Investor_List() throws Exception {

		try {
			//xpath_GenericMethod_scrollIntoView(investor_list);
			xpath_GenericMethod_Click(investor_list);
			Assert.assertTrue(true, "click on invester list Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on invester list");
		}

	}

	public void enter_internal_external_filed(String internal, String external) throws Exception {

		xpath_GenericMethod_Sendkeys(internal_xpath, internal);
		xpath_GenericMethod_Sendkeys(external_xpath, external);

	}

	public void clickOn_toggle(String yes, String filed) throws Exception {

		try {

			WebElement toggleYes = driver.findElement(By.xpath(toggle_xpath));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
			Assert.assertTrue(true, "Click on toggle button successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on toggle button");
		}
	}

	public void clicksOnSubmitButton(String yes, String filed) throws Exception {

		xpath_GenericMethod_Click(submit_button_xpath);

	}

	public void upload_Documents() throws Exception {

		try {

			xpath_GenericMethod_scrollIntoView(upload_documents_xpath);
			xpath_GenericMethod_Click(upload_documents_xpath);
			;
			String path = System.getProperty("user.dir");
			String systemScreenshot = path + "\\attachments\\document1.pdf";
			driver.findElement(By.xpath(select_file_xpath)).sendKeys(systemScreenshot);
			xpath_GenericMethod_scrollIntoView(document_category_xpath);
			Assert.assertTrue(true, "Documents uploaded successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To upload documents");
		}

	}

	public void upload_Supporting_Documents() throws Exception {

		//xpath_GenericMethod_scrollIntoView(upload_supporting_documents_xpath);
		xpath_GenericMethod_Click(upload_supporting_documents_xpath);
		;
		String path = System.getProperty("user.dir");
		String systemScreenshot = path + "\\attachments\\document1.pdf";
		driver.findElement(By.xpath(select_file_xpath)).sendKeys(systemScreenshot);
		//xpath_GenericMethod_scrollIntoView(document_category_xpath);

	}

	public void select_Documents(String filed1, String filed2, String filed3, String filed4) throws Exception {

		xpath_GenericMethod_scrollIntoView(document_category_xpath);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(system_screenshot_xpath, 0);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(share_registry_xpath, 1);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(others_xpath, 2);

	}

	public void select_WithTwoDocuments(String filed1, String filed2) throws Exception {

		xpath_GenericMethod_scrollIntoView(document_category_xpath);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(share_registry_xpath, 1);

	}

	public void clickOnYesButton() throws Exception {

		xpath_GenericMethod_Click(yes_button_xpath);
	}

	public void selectTheInsufficientLiquidityDropDown(String selectDropDown) throws Exception {

		xpath_GenericMethod_Click(insufficient_liquidity_dropdown_xpath);

		xpath_GenericMethod_Click(search_xpath);

		try {
			List<WebElement> dropDowns = driver.findElements(By.xpath(insufficient_liquidity_dropdown_list_xpath));
			for (WebElement dropDown : dropDowns) {
				if (dropDown.getText().contains(selectDropDown)) {

					dropDown.click();

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCheckbox() throws Exception {

		xpath_GenericMethod_Click(checkbox_xpath);
	}

	public void clickOn_Liquidity_toggle() throws Exception {

		xpath_GenericMethod_scrollIntoView(liquidity_toggletext_xpath);

		WebElement toggleYes = driver.findElement(By.xpath(liquidity_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_bank_details_toggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(bank_details_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void enter_reason() throws Exception {

		xpath_GenericMethod_Sendkeys(reason_xpath, "Reason");

	}

	public void entersClientRepresentativeCalled() throws Exception {

		String clientRepresentative = RandomStringUtils.randomAlphabetic(5);
		xpath_GenericMethod_Click(client_representative_called_xpath);

		xpath_GenericMethod_Sendkeys(client_representative_called_xpath, clientRepresentative);

	}

	public void enterCallBackDate(String date) throws Exception {

		xpath_GenericMethod_Click(call_back_date_and_time_xpath);
		xpath_GenericMethod_Sendkeys(call_back_date_and_time_xpath, date);

	}

	public void enterPhoneNumberOfClient() throws Exception {

		String phonenumber = RandomStringUtils.randomNumeric(9);
		xpath_GenericMethod_Click(phonenumber_client_representative_xpath);
		xpath_GenericMethod_Sendkeys(phonenumber_client_representative_xpath, phonenumber);

	}

	public void clickOnCallBackSuccessfulToggle() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(callback_successful_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOnEditButton() throws Exception {

		xpath_GenericMethod_Click(edit_xpath);
	}

	public void testLogoutPage() {
		// System.out.println("In test logout page");
	}

	public void verifyExpensePaymentPreparationTitleL1(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L1ExpensePaymentPreparationTitle)), 60);
		String actualText = getElementText(L1ExpensePaymentPreparationTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void selectCurrency(String currencyDrpdwn, String value) throws Exception {

		try {
			for (int i = 0; i < 50; i++) {
				if (driver.findElement(By.xpath(currency)).getAttribute("value").isEmpty()) {
					xpath_GenericMethod_Click(currency);
					List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
					for (WebElement webElement : dropdownvalues) {
						if (webElement.getText().equals(value)) {
							webElement.click();
						}
					}
					Assert.assertTrue(true, "Selected currency successfully ");
				}
				if (driver.findElement(By.xpath(currency)).getAttribute("value").equals(value)) {
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select currency");
		}
	}

	public void selectIssuingAccValuesInDropdown(String dropDown, String value) throws Exception {
		//updated to select first value from drop down for issuing account
		try {
					
					if (driver.findElement(By.xpath(issuing_account_drp_down)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(issuing_account_drp_down);
						xpath_GenericMethod_Click(dropDown_list_xpath);						
						Assert.assertTrue(true, "Selected currency successfully ");
					}
			
		} catch (Exception e) {
					if (driver.findElement(By.xpath(issuing_account_drp_down)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(issuing_account_drp_down);
						xpath_GenericMethod_Click(dropDown_list_xpath);
						Assert.assertTrue(true, "Selected currency successfully ");
					}
				}
	}

	public void enterAmountToPaid(String value) throws Exception {
		//if (driver.findElement(By.xpath(amt_to_paid)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Sendkeys(amt_to_paid, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(amt_to_paid, value);
			}
		//}
	}

	public void enterVendorForFirstInvoice(String value) throws Exception {
		try {

			xpath_GenericMethod_Clear(vendor_txt);
			xpath_GenericMethod_Sendkeys(vendor_txt, value + RandomStringUtils.randomNumeric(5));

		} catch (Exception e) {
			xpath_GenericMethod_Clear(vendor_txt);
			xpath_GenericMethod_Sendkeys(vendor_txt, value + RandomStringUtils.randomNumeric(5));
		}

	}

	public void enterInvoiceNo() throws Exception {

		String invoiceNo = RandomStringUtils.randomNumeric(5);
		if (driver.findElement(By.xpath(invoice)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(invoice, invoiceNo);
		}

	}

	public void enterInvDate() throws Exception {
		// User enters the invoice date
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			// If day falls on Saturday or Sunday, append 3 days forward
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

				cal.add(Calendar.DATE, 3);
			} else {
				cal.add(Calendar.DATE, 7);
			}

			String futureDateTime = "" + dateFormat.format(cal.getTime());
			System.out.println("future invoice date ------------ " + futureDateTime);
			if (driver.findElement(By.xpath(inv_date)).getAttribute("value").isEmpty()) {
				xpath_GenericMethod_Click(inv_date);
				xpath_GenericMethod_SendkeysWithoutJS(inv_date, futureDateTime);
			}

			Assert.assertTrue(true, "entered invoice date Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter invoice date ");
		}

	}

	public void enterPayDate() throws Exception {
		// User enters the payment date
		try {
			WebElement dateWidget = driver.findElement(By.xpath(paymentDatePicker_xpath));
			dateWidget.click();
			
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		    Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			String nextMonth = dateFormat.format(cal.getTime());
			String[] arrOfStr = nextMonth.split(" ");
			System.out.println("Next month print: " + arrOfStr[0].trim());
			Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='monDrop']")));
			monthDropdown.selectByVisibleText(arrOfStr[0].trim());
			driver.findElement(By.xpath("//td[@class='calcell']")).click();
		    
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	WebElement dateWidget1 = driver.findElement(By.xpath(paymentDatePicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(payment_Date, newDate)))).click();
		    }	

			Assert.assertTrue(true, "entered payment date Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter pay date ");
		}

	}

	public void enterAccNo(String value) throws Exception {
		if (driver.findElement(By.xpath(acc_no)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Click(acc_no);
				xpath_GenericMethod_Sendkeys(acc_no, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(acc_no, value);
			}
		}
	}

	public void enterABANo(String value) throws Exception {
		if (driver.findElement(By.xpath(aba_routing)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(aba_routing, value);
		}
	}

	public void enterSwiftNo(String value) throws Exception {
		if (driver.findElement(By.xpath(swift_code)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(swift_code, value);
		}
	}

	public void enterMemo(String value) throws Exception {
		if (driver.findElement(By.xpath(memo)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(memo, value);
		}
	}

	public void selectValuesInDropdownForProposedDecision(String dropDown, String value) throws Exception {

//		for (int i = 1; i < 50; i++) {
//			{
				if (driver.findElement(By.xpath(proposedDecisionDrpDown_xpath)).getAttribute("value").isEmpty()) {
					xpath_GenericMethod_Click(proposedDecisionDrpDown_xpath);
					List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
					for (WebElement webElement : dropdownvalues) {
						if (webElement.getText().equals(value)) {
							webElement.click();
						}
					}
//					if (driver.findElement(By.xpath(proposedDecisionDrpDown_xpath)).getAttribute("value")
//							.equals(value)) {
//						break;
//					}
					Assert.assertTrue(true, "Selected decision successfully ");
				}
			}
		//}
	//}

	public void writeDecisionComment(String comment, String s) throws Exception {
		try {
			//xpath_GenericMethod_scrollIntoView(Dec_comments);
			xpath_GenericMethod_Sendkeys(Dec_comments, comment);
			xpath_GenericMethod_Sendkeys(intl_comments, s);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(Dec_comments, comment);
			xpath_GenericMethod_Sendkeys(intl_comments, s);

		}
	}

	public void clickonInvoiceHeader(String invoice2) throws Exception {
		try {
//			xpath_GenericMethod_Click(invoice2_header);
			WebElement toggleYes = driver.findElement(By.xpath(invoice2_header));
			xpath_GenericMethod_scrollIntoView(invoice2_header);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
		} catch (ElementClickInterceptedException e) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(invoice2_header))).click().build().perform();
		}
	}

	public void selectCurrencyForSecondInvoice(String dropDown, String value) throws Exception {

		try {
			driver.findElement(By.xpath(currency2)).sendKeys(Keys.PAGE_UP);

			for (int i = 1; i < 3; i++) {
				{
					if (driver.findElement(By.xpath(currency2)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(currency2);
						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
						for (WebElement webElement : dropdownvalues) {
							if (webElement.getText().equals(value)) {
								webElement.click();
							}
						}
						if (driver.findElement(By.xpath(currency2)).getAttribute("value").equals(value)) {
							break;
						}
						Assert.assertTrue(true, "Selected currency successfully ");
					} else {
						System.out.println("Currency is already selected");
					}
				}
			}
		} catch (Exception e) {
			driver.findElement(By.xpath(currency2)).sendKeys(Keys.PAGE_UP);

			for (int i = 1; i < 3; i++) {
				{
					if (driver.findElement(By.xpath(currency2)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(currency2);
						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
						for (WebElement webElement : dropdownvalues) {
							if (webElement.getText().equals(value)) {
								webElement.click();
							}
						}
						if (driver.findElement(By.xpath(currency2)).getAttribute("value").equals(value)) {
							break;
						}
						Assert.assertTrue(true, "Selected currency successfully ");
					} else {
						System.out.println("Currency is already selected");
					}
				}
			}
		}

	}

	public void selectIssuingAccValuesInDropdownInSecondInvoice(String dropDown, String value) throws Exception {

		try {
//			for (int i = 1; i < 3; i++) {
//				{
					if (driver.findElement(By.xpath(issu_acc_drp_down2)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(issu_acc_drp_down2);
						xpath_GenericMethod_Click(dropDown_list_xpath);
//						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
//						for (WebElement webElement : dropdownvalues) {
//							if (webElement.getText().equals(value)) {
//								webElement.click();
//							}
//						}
//						if (driver.findElement(By.xpath(issu_acc_drp_down2)).getAttribute("value").equals(value)) {
//							break;
//						}
						Assert.assertTrue(true, "Selected IssuingAcc successfully ");
					}
				//}
			//}
		} catch (Exception e) {
//			for (int i = 1; i < 3; i++) {
//				{
					if (driver.findElement(By.xpath(issu_acc_drp_down2)).getAttribute("value").isEmpty()) {
						xpath_GenericMethod_Click(issu_acc_drp_down2);
						xpath_GenericMethod_Click(dropDown_list_xpath);
//						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
//						for (WebElement webElement : dropdownvalues) {
//							if (webElement.getText().equals(value)) {
//								webElement.click();
//							}
//						}
//						if (driver.findElement(By.xpath(issu_acc_drp_down2)).getAttribute("value").equals(value)) {
//							break;
//						}
						Assert.assertTrue(true, "Selected IssuingAcc successfully ");
					}
				}
			//}
		//}

	}

	public void enterAmountToPaid2(String value) throws Exception {
		if (driver.findElement(By.xpath(amt_to_paid2)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(amt_to_paid2, value);
		}
	}

	public void enterVendorForSecondInvoice(String value) throws Exception {
		xpath_GenericMethod_Click(vendor_2);
		xpath_GenericMethod_Clear(vendor_2);
		xpath_GenericMethod_Sendkeys(vendor_2, value + RandomStringUtils.randomNumeric(5));
	}

	public void enterInvoiceNoForInvoiceTwo() throws Exception {
		String invoiceNo = RandomStringUtils.randomNumeric(5);
		if (driver.findElement(By.xpath(invoice2)).getAttribute("value").isEmpty()) {
			xpath_GenericMethod_Sendkeys(invoice2, invoiceNo);
		}
	}

	public void enterInvDate2() throws Exception {
		// User enters the trade date
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			// If day falls on Saturday or Sunday, append 3 days forward
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

				cal.add(Calendar.DATE, 3);
			} else {
				cal.add(Calendar.DATE, 7);
			}

			String futureDateTime = "" + dateFormat.format(cal.getTime());
			xpath_GenericMethod_Click(inv_date2);
			xpath_GenericMethod_SendkeysWithoutJS(inv_date2, futureDateTime);

			Assert.assertTrue(true, "entered invoice date Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter invoice date ");
		}

	}

	public void enterPayDate2() throws Exception {
		// User enters the trade date
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Calendar cal = Calendar.getInstance();
			// If day falls on Saturday or Sunday, append 3 days forward
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

				cal.add(Calendar.DATE, 3);
			} else {
				cal.add(Calendar.DATE, 7);
			}

			String futureDateTime = "" + dateFormat.format(cal.getTime());
			xpath_GenericMethod_Click(pay_date2);
			xpath_GenericMethod_SendkeysWithoutJS(pay_date2, futureDateTime);

			Assert.assertTrue(true, "entered payment date Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter payment date ");
		}

	}

	public void enterAccNo2(String value) throws Exception {
		if (driver.findElement(By.xpath(acc_no2)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Sendkeys(acc_no2, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(acc_no2, value);
			}
		}
	}

	public void enterABANo2(String value) throws Exception {
		if (driver.findElement(By.xpath(abe_rot2)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Sendkeys(abe_rot2, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(abe_rot2, value);
			}
		}
	}

	public void enterSwiftNo2(String value) throws Exception {
		if (driver.findElement(By.xpath(swift_cod2)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Sendkeys(swift_cod2, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(swift_cod2, value);
			}
		}
	}

	public void enterMemo2(String value) throws Exception {
		if (driver.findElement(By.xpath(memo2)).getAttribute("value").isEmpty()) {
			try {
				xpath_GenericMethod_Sendkeys(memo2, value);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(memo2, value);
			}
		}
	}

	public void selectValuesInDropdownUnderProposedDecisionForSecondInvoice(String dropDown, String value)
			throws Exception {

		try {
			for (int i = 1; i < 3; i++) {
				{
					if (driver.findElement(By.xpath(proposedDecisionDrpDownSecondInvoice_xpath)).getAttribute("value")
							.isEmpty()) {
						xpath_GenericMethod_Click(proposedDecisionDrpDownSecondInvoice_xpath);
						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
						for (WebElement webElement : dropdownvalues) {
							if (webElement.getText().equals(value)) {
								webElement.click();
							}
						}
						if (driver.findElement(By.xpath(proposedDecisionDrpDownSecondInvoice_xpath))
								.getAttribute("value").equals(value)) {
							break;
						}
						Assert.assertTrue(true, "Selected proposedDecision successfully ");
					}
				}
			}
		} catch (Exception e) {
			for (int i = 1; i < 3; i++) {
				{
					if (driver.findElement(By.xpath(proposedDecisionDrpDownSecondInvoice_xpath)).getAttribute("value")
							.isEmpty()) {
						xpath_GenericMethod_Click(proposedDecisionDrpDownSecondInvoice_xpath);
						List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
						for (WebElement webElement : dropdownvalues) {
							if (webElement.getText().equals(value)) {
								webElement.click();
							}
						}
						if (driver.findElement(By.xpath(proposedDecisionDrpDownSecondInvoice_xpath))
								.getAttribute("value").equals(value)) {
							break;
						}
						Assert.assertTrue(true, "Selected proposedDecision successfully ");
					}
				}
			}
		}

	}

	public void writeDecisionComment2(String comments) throws Exception {
		
		//if (driver.findElement(By.xpath(dec_comm2)).getAttribute("value").isEmpty()) {
			try {
				waitVisibilityOfElementLocated(driver, dec_comm2);
				xpath_GenericMethod_Sendkeys(dec_comm2, comments);
			} catch (Exception e) {
				xpath_GenericMethod_Sendkeys(dec_comm2, comments);
			}

		//}
	}

	public void verifyL1LiquidityReviewTitle(String pagetitle) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(L1LiquidityReviewTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void selectAnswer(String ans, String res) throws Exception {
		if (ans.equals("Yes")) {
			WebElement toggleYes = driver.findElement(By.xpath(answer_yes));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
		} else if (ans.equals("No")) {

			try {
				//xpath_GenericMethod_scrollIntoView(liquidity_resolution_xpath);
				
				//for (int i = 0; i <= 5; i++) {
					xpath_GenericMethod_Click(liquidity_resolution_xpath);
					WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
					searchBox.sendKeys(res);
					xpath_GenericMethod_Click(dropDown_list_xpath);
//					List<WebElement> dropdownvalues = driver.findElements(By.xpath(dropDown_list_xpath));
//					for (WebElement webElement : dropdownvalues) {
//						if (webElement.getText().equals(res)) {
//							webElement.click();
//
//						}
//
//					}

//					if (driver.findElement(By.xpath(liquidity_resolution_xpath)).getAttribute("value").equals(res)) {
//						break;
//					}
				//}

				Assert.assertTrue(true, "Liquidity resolution is done successfully");
			} catch (Exception e) {
				Assert.assertTrue(false, "Liquidity resolution is not done");
			}
		}
	}
	
	public void selectAnswerForReviewFundLiquidity(String ans) throws Exception{
		try {
			xpath_GenericMethod_Click(reviewFundLiquidity_xpath);			
		} catch (Exception e) {
			xpath_GenericMethod_Click(reviewFundLiquidity_xpath);
		}
	}

	public void selectFeeType(String value) throws Exception {

		try {
			xpath_GenericMethod_Click(fee_type);
			xpath_GenericMethod_Sendkeys(search_xpath, value);
			xpath_GenericMethod_Click(dropDown_list_xpath);
		} catch (Exception e) {
			xpath_GenericMethod_Click(fee_type);
			xpath_GenericMethod_Sendkeys(search_xpath, value);
			xpath_GenericMethod_Click(dropDown_list_xpath);
		}
	}

	public void enterAmount(String amount) throws Exception {
		amount = xpath_Genericmethod_getElementText(capt_amount);
		xpath_GenericMethod_Sendkeys(amt, amount);

	}

	public void verifyL1ExpensePaymentCallBackTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L1ExpensePaymentCallback)), 60);
		String actualText = getElementText(L1ExpensePaymentCallback);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOnTemplateOption(String edit) throws Exception {
		xpath_GenericMethod_Click(title);
		xpath_GenericMethod_Click(templete_inp_edit);
	}

	public void enterTemplateName(String name) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(template_name, name);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(template_name, name);
		}
	}

	public void enterTemplateBank(String bank) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(template_bank, bank);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(template_bank, bank);
		}
	}

	public void enterClientName(String name) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(client_rep_call, name);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(client_rep_call, name);
		}

	}

	public void selectAnswer(String ans) throws Exception {
		xpath_GenericMethod_Click(call_succ);
	}

	public void clickOnUploadButton(String eKey, String value1) throws Exception {
		try {
			// clicks on upload document button
			xpath_GenericMethod_Click(btn_upload);
			waitForElement(driver.findElement(By.xpath(txt_UploadPopup)), 1);

		} catch (NoSuchElementException e) {
			System.out.println("upload popup not displayed.. entering catch block");
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath(btn_upload))).build().perform();
		}
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

	public void enterTime(String time) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(call_compl_time, time);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(call_compl_time, time);
		}
	}

	public void enterClientNo(String no) throws Exception {
		xpath_GenericMethod_Click(no_of_client);
		xpath_GenericMethod_Sendkeys(no_of_client, no);

	}

	public void verifyL1ExpensePaymentProcessingTitle(String pagetitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(L1ExpensePaymentProcessingTitle)), 60);
		String actualText = getElementText(L1ExpensePaymentProcessingTitle);
		Assert.assertEquals(actualText, pagetitle);

	}

	public void clickOnCheckBox(String box) throws Exception {
		try {
			xpath_GenericMethod_Click(toggle_BankingPlatform);
		} catch (Exception e) {
			xpath_GenericMethod_Click(toggle_BankingPlatform);
		}

	}

	public void clickOnFeeDrp(String value1) throws Exception {
		xpath_GenericMethod_Click(Fee_drp_down);

		try {
			List<WebElement> fee = driver.findElements(By.xpath(value));

			for (WebElement ele : fee) {

				if (ele.getText().contains(value1)) {
					waitFor(2);
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAmount() throws Exception {
		try {
			xpath_GenericMethod_Click(amount);
			String totalCallAmount = RandomStringUtils.randomNumeric(4);
			xpath_GenericMethod_Sendkeys(amount, totalCallAmount);
		} catch (Exception e) {
			xpath_GenericMethod_Click(amount);
			String totalCallAmount = RandomStringUtils.randomNumeric(4);
			xpath_GenericMethod_Sendkeys(amount, totalCallAmount);
		}

	}

	public void enterVendorName(String value) throws Exception {
		xpath_GenericMethod_Click(vendor);
		String No = RandomStringUtils.randomNumeric(5);
		xpath_GenericMethod_Sendkeys(vendor, value + No);
	}

	public void enterRoutingNO() throws Exception {
		String No = RandomStringUtils.randomNumeric(5);
		xpath_GenericMethod_Sendkeys(routingNo, No);

	}

	public void enterSwiftNo() throws Exception {
		xpath_GenericMethod_Click(swift_code);
		String swiftNo = RandomStringUtils.randomNumeric(5);
		xpath_GenericMethod_Sendkeys(swift_code, swiftNo);

	}

	public void writeIntlComment(String comment) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(intl_comments, comment);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(intl_comments, comment);

		}
	}

	public void clickOnSubmitRefreshWarning(String sub) throws Exception

	{
		xpath_Javascriptexecutor_GenericMethod_Click(submit_button_xpath);
		// Mandatory force wait to click "Refresh" warning and re-submit the details
		waitFor(30);

	}

	public void verifyInitationScreen(String scr) {
		waitForElement(driver.findElement(By.xpath(L1ExpensePaymentPreparationTitle)), 30);
		String actualText = getElementText(L1ExpensePaymentPreparationTitle);
		Assert.assertEquals(actualText, scr);

	}

	public void enterClientNameFOFCapitalCall(String name) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_ClientRep, name);
	}

	public void enterTimeFOFCapital(String time) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_CallBackDate, time);

	}

	public void enterClientNoFOFcapitalCall(String no) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_CientPhone, no);

	}

	public void selectAnswerFOFCapitalCall(String ans) {
		WebElement toggleYes = driver.findElement(By.xpath(toggle_CallBackYes));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void enterTemplateNameFOFCapitalCall(String name) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_templateName, name);

	}

	public void enterTemplateBank_FOF_Capital_Call(String name1) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_templateBank, name1);

	}

	public void selectToggleForbankingDetailsProvided() throws Exception {
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox1);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(chkBox1);
		}

	}

	public void enterReasonAfterEnablingToggle(String cmnts) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_ReasonAfterEnablingToggle, cmnts);

	}

	public void enterTheInvestorData(String name, String emailadd) throws Exception {
		xpath_GenericMethod_Sendkeys(txtInvestorcont, name);
		xpath_GenericMethod_Sendkeys(txtInvestorEmail, emailadd);

	}

	public void clickOnCheckBoxDIP(String box) {
		try {

			WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_BankingPlatform));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);

		} catch (Exception e) {

			WebElement toggleYes = driver.findElement(By.xpath(toggle_DIP_BankingPlatform));
			Actions a = new Actions(driver);
			a.moveToElement(toggleYes).click().build().perform();

		}
	}

	public void clickOnCheckBoxBankingDetailsDIP() throws Exception {
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(toggle_DIP_BankingPlatformPresent);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(toggle_DIP_BankingPlatformPresent);
		}

	}

	public void provideReasonForBankingPlatform(String cmnts) throws Exception {
		xpath_GenericMethod_Sendkeys(txt_Banking_Rsn, cmnts);

	}

	public void clickOn_Upload_DocumentPER(String upload) {

	}

	public void clickOn_Upload_DocumentPER(String upload, String docCatgry) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(upload_doc_btn);

		try {

			// Creating string buffer and passing the current project path
			StringBuffer Projectpath = new StringBuffer(System.getProperty("user.dir"));

			// Appending file to current project path where the file
			// path is passed from Examples
			StringBuffer file = Projectpath.append(upload);

			waitFor(1);
			driver.findElement(By.xpath(select_file_button)).sendKeys(file);

			xpath_GenericMethod_Click(drpbox_DocCategory);
			xpath_SelectFromDropdownUsingValue(drpbox_DocCategory, docCatgry);
			Assert.assertTrue(true, "document(s) upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload documents");
		}

	}

}
