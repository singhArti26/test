package com.areteans.ataf.PageObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.InitiationClientPageLoc;

public class InitiationClientPage extends CustomerServ implements InitiationClientPageLoc {

	InitiationClientPage initiation_client_page;
	String caseIDCreate;

	String totalCallAmount = RandomStringUtils.randomNumeric(5);
	String totalDistributionAmount = RandomStringUtils.randomNumeric(8);
	Integer m = Integer.valueOf(totalCallAmount);
	Integer n = Integer.valueOf(totalDistributionAmount);
	Integer netamountInt = m - n;
	String netamountString = String.valueOf(netamountInt);

	public InitiationClientPage(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(InitiationClientPage initiationclientpage) {
		this.initiation_client_page = initiation_client_page;
	}

	public void clickOnCreatebtn(String create) throws Exception {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xpath_GenericMethod_Click(create_btn_xpath);
	}

	public void clickOnPercentage(String percentage, String filed) throws Exception {

		xpath_GenericMethod_Click(rdoPercentage);
	}

	public void enterPercentage(String percentage) throws Exception {

		xpath_GenericMethod_Clear(txtPercentagetobecalled);
		xpath_GenericMethod_Sendkeys(txtPercentagetobecalled, percentage);

	}

	public void enterComments(String comment) throws Exception {
		
		xpath_GenericMethod_Sendkeys(txtComment, comment);
	}

	public void enterExplanation(String comment) throws Exception {

		xpath_GenericMethod_Sendkeys(exp_xpath, comment);
	}

	public void verifyCaseID(String caseID) throws Exception {

		xpath_GenericMethod_Click(left_arrow_xpath);
		xpath_Genericmethod_verifyElementPresent(case_ID_xpath);
		caseIDCreate = driver.findElement(By.xpath(case_ID_xpath)).getText();
		System.out.println(caseIDCreate);
		xpath_GenericMethod_Click(left_arrow_xpath);

		String filePath = "C:\\Users\\Suneel Ratnala\\Documents\\TestAutomation\\distribution\\ATAF_CAPITALCALL\\TestData.xlsx";
		String sheetName = "Sheet1";
		int rowNum = 0;
		int colNum = 0;
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet(sheetName);
			Row row = sheet.createRow(rowNum);
			Cell cell = row.createCell(colNum);
			cell.setCellValue(caseIDCreate);

			// Write the workbook to a file
			try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
				workbook.write(outputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void verifySummaryScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(page_title_xpath, pageTitle);
	}

	public void verify_PageTitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(pagetitle_xpath, pageTitle);
	}

	public void selectResolutionDropDown(String selectDropDown) throws Exception {

		xpath_GenericMethod_Click(resolution_xpath);

		xpath_GenericMethod_Click(search_xpath);

		try {
			List<WebElement> dropDowns = driver.findElements(By.xpath(resolution_list_xpath));
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

	public void enterCommentsOnResolutionPage() throws Exception {

		xpath_GenericMethod_Click(comments_xpath);
		xpath_GenericMethod_Sendkeys(comments_xpath, "Comment");
	}

	public void selectYesNewInvestment() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(newinvestment_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void enterInvestmentName(String invName) throws Exception {

		try {

			xpath_GenericMethod_Sendkeys(investmentname_xpath, invName);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(investmentname_xpath, invName);
		}

	}

	public void selectCurrencyOfCommitment(String selectDropdown, String commitment) throws Exception {

		try {
			if (driver.findElement(By.xpath(currencyOfCommitment_xpath)).getAttribute("value").isEmpty()) {
				WebElement toggleYes = driver.findElement(By.xpath(currencyOfCommitment_xpath));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", toggleYes);
			}
		} catch (Exception e) {
			xpath_GenericMethod_Click(currencyOfCommitment_xpath);
		}

		try {
			List<WebElement> transactionTypesList = driver.findElements(By.xpath(currencyOfCommitment_dropdown_xpath));
			for (WebElement transactionType : transactionTypesList) {
				if (transactionType.getText().contains(selectDropdown)) {

					transactionType.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSaveButton() throws Exception {

		xpath_GenericMethod_Click(save_button_xpath);

	}

	public void clickOnOkButton(String OK, String title) throws Exception {

		xpath_Genericmethod_VerifyTextContains(changes_successfully_text_xpath, title);
		xpath_GenericMethod_Click(ok_xpath);

	}

	public void clickOnCancelButton() throws Exception {

		xpath_GenericMethod_Click(cancel_xpath);

	}

	public void verifyFundName(String fundName) throws Exception {

		xpath_Genericmethod_VerifyTextContains(fund_name_xpath, fundName);

	}

	public void verifyInvestmentName(String investmentName) throws Exception {

		xpath_Genericmethod_VerifyTextContains(investment_name_xpath, investmentName);

	}

	public void verifyPurchaseAgreementExected(String executed) throws Exception {

		xpath_Genericmethod_VerifyTextContains(executed_xpath, executed);

	}

	public void enterPackageName(String name) throws Exception {
		xpath_GenericMethod_Sendkeys(payment_package_name, name);
	}

	public void enterTheNumberOfInvoices(String invoices) throws Exception {
		try {
			xpath_GenericMethod_Clear(noOfInvoices_value);
			xpath_GenericMethod_Sendkeys(noOfInvoices_value, invoices);
		} catch (Exception e) {
			xpath_GenericMethod_Clear(noOfInvoices_value);
			xpath_GenericMethod_Sendkeys(noOfInvoices_value, invoices);
		}
	}

	public void selectTheFund(String fundDropdown, String fundName) throws Exception {

		try {
			xpath_GenericMethod_Click(fund_dropdown_xpath);
			xpath_GenericMethod_Sendkeys(fund_dropdown_xpath, fundName);
			xpath_GenericMethod_Click(fund_list_xpath);

			Assert.assertTrue(true, "Selecting fund successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select fund");
		}

	}

	public void clickOnUploadButton(String eKey, String value1, String value2) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(upload_doc_btn);
		String path = System.getProperty("user.dir");

		try {
			String file1 = path + "\\ExpensePaymentResources\\Invoice.pdf";
			String file2 = path + "\\ExpensePaymentResources\\INV8000943936.pdf";
			waitFor(1);
			driver.findElement(By.xpath(select_file_button)).sendKeys(file1);
			waitFor(1);
			xpath_SelectFromDropdownUsingValue(invoice_xpath, value1);
			waitFor(1);
			driver.findElement(By.xpath(select_file_button)).sendKeys(file2);
			waitFor(1);
			xpath_SelectFromDropdownUsingValue(invoice2_xpath, value2);

			Assert.assertTrue(true, "document(s) upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload documents");
		}

	}

	public void verifySuccessfullMessage(String submit, String message) throws Exception {
		xpath_Genericmethod_verifyElementPresent(successfulMessage);
	}

	public void clickRefresh(String status) throws Exception {
		for (int i = 1; i <= 50; i++) {
			xpath_GenericMethod_Click(actions_click);
			xpath_GenericMethod_Click(refresh_click);
			if (driver.findElement(By.xpath(ocr_status_check)).getText().equals(status)) {
				break;
			}
		}
	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {
		waitForElement(driver.findElement(By.xpath(initiationPageVerify)), 60);
		String actualText = getElementText(initiationPageVerify);
		Assert.assertEquals(actualText, pageTitle);
	}

	public void clickOnUploadButtonForRejectedInvoice(String eKey, String value1) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(upload_doc_btn);
		String path = System.getProperty("user.dir");

		try {
			String file2 = path + "\\ExpensePaymentResources\\INV8000943936.pdf";
			waitFor(1);
			driver.findElement(By.xpath(select_file_button)).sendKeys(file2);

			xpath_GenericMethod_Click(invoice_xpath);
			xpath_SelectFromDropdownUsingValue(invoice_xpath, value1);
			Assert.assertTrue(true, "document(s) upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload documents");
		}

	}

	public void verifyExpensePaymentTitle(String pageTitle) throws Exception {
		String actualText = getElementText(verifyExpensePaymentTitle);
		Assert.assertEquals(actualText, pageTitle);
	}

	public void selectAnswer() throws Exception {
		xpath_GenericMethod_Click(moreFund);

	}

	public void verifyInitiationScreenExpPaymnt(String pageTitle) throws Exception {
		String actualText = xpath_Genericmethod_getElementText(initiationPageVerify);
		Assert.assertEquals(actualText, pageTitle);
	}

	public void clickRefresh() throws Exception {
		xpath_GenericMethod_Click(actions_click);
		xpath_GenericMethod_Click(refresh_click);

	}

}
