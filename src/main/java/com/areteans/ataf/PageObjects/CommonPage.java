package com.areteans.ataf.PageObjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.areteans.ataf.TestBase.TestBase;
import com.cucumber.framework.pageconstants.CommonPageLoc;

public class CommonPage extends CustomerServ implements CommonPageLoc {

	public CommonPage(WebDriver driver) {
		super(driver);
	}

	public void useTemplate(String status) throws Exception {
		// Click on Actions
		xpath_GenericMethod_Click(btn_Header_Actions);
		// Click on Use Template
		xpath_GenericMethod_Click(btn_UseTemplate);
		// Click on ProcessID Select box
		xpath_GenericMethod_Click(drp_ProcessID_Select);
		// Click on first case ID
		xpath_GenericMethod_Click(drp_caseID_value);
		// Click on Search button
		xpath_GenericMethod_Click(btn_Search);
		// Get text of "Description" in first search result
		String desccriptionTxt = getElementText(txt_Description);
		// Click on TransactionName Select box
		xpath_GenericMethod_Click(drp_Select);

		// get TransactionName drop down list values
		List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_list));
		for (WebElement webElement : dropdownvalues) {
			// if desccriptionTxt(variable) matches any of drop down down values it will
			// click that
			if (webElement.getText().equals(desccriptionTxt)) {
				// Clicks element
				webElement.click();
			}
		}
		// Click on Search button
		xpath_GenericMethod_Click(btn_Search);
		// Click on Copy button
		xpath_GenericMethod_Click(btn_Filter_Copy);
		// Status verification
		verifyCompletedStatus(status);
		// Click on "Go" button
		xpath_GenericMethod_Click(btn_Go);

	}

	public void verifyCompletedStatus(String compeletedStatus) throws Exception {
		//WebElement element = driver.findElement(By.xpath("//span[contains (text(), '"+ compeletedStatus +"')]"));
		//updated the method by parameterizing the xpath for verifying the status of case
		WebElement element = driver.findElement(By.xpath(String.format(txt_Status, compeletedStatus)));
		waitForElement(element, 30);
		String ResloveStatus = element.getText();
		Assert.assertEquals(ResloveStatus, compeletedStatus);

	}

	public void clickOnUploadButtoninInitiation(String fileTyp1) throws Exception {

		try {
			// clicks on upload document button
			xpath_GenericMethod_Click(btn_upload);
			waitForElement(driver.findElement(By.xpath(txt_UploadPopup)), 1);
		} catch (Exception e) {
			System.out.println("upload popup not displayed.. entering catch block");
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath(btn_upload))).build().perform();
		}

		// Creating string buffer and passing the current project path
		StringBuffer Projectpath = new StringBuffer(System.getProperty("user.dir"));

		// Appending file to current project path where the file
		// path is passed from Examples
		StringBuffer wordFile = Projectpath.append(fileTyp1);

		try {
			// wait for selectFile button
			waitFor(2);
			// Sending the file path to "select file" locator and all the file types gets
			// uploaded
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(wordFile);
			// Mandatory wait
			waitFor(1);

			Assert.assertTrue(true, "document upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload document");
		}

	}

	public void enterInternalComments(String cmnts) throws Exception {

		try {
			// Enter comments
			xpath_GenericMethod_Sendkeys(txa_intlComments, cmnts);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txa_intlComments, cmnts);
		}
	}

	public void clickOnSubmit() throws Exception {

		xpath_GenericMethod_Click(btn_uploadSubmit);

	}

	public void clickOnSubmitFinal() throws Exception {
		try {
			//xpath_GenericMethod_scrollIntoView(btn_FinalSubmit);
			xpath_GenericMethod_Click(btn_FinalSubmit);

		} catch (Exception e) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_FinalSubmit))).click().build().perform();
		}

	}

	public void validateComments(String actionName, String actionComments, String actionBy) throws Exception {

		// clicks on Case 360 button
		xpath_GenericMethod_Click(btn_Case360);

		// clicks on "comments" section
		xpath_GenericMethod_Click(btn_Comments);

		// wait
		waitForElement(driver.findElement(By.xpath(txt_ActionName)), 60);
		// get Action name text
		String name = getElementText(txt_ActionName);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(actionName, name);

		// get Action comments text
		String comments = getElementText(txt_ActionComments);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(comments, actionComments);

		// get Action By text
		String actionDoneBy = getElementText(txt_ActionBy);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(actionBy, actionDoneBy);

	}

	public void captureCaseID(String caseID) {
		waitForElement(driver.findElement(By.xpath(txt_caseIDtitle)), 60);
		caseID = driver.findElement(By.xpath(txt_caseIDtitle)).getText();
		TestBase.caseID = caseID;
		String path = System.getProperty("user.dir");
		String filePath = path + "\\attachments\\TestData1.xlsx";
		String sheetName = "Sheet1";
		int rowNum = 0;
		int colNum = 0;

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(sheetName);
			XSSFRow row = sheet.createRow(rowNum);
			XSSFCell cell = row.createCell(colNum);
			cell.setCellValue(caseID);

			// Write the workbook to a file
			try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
				waitFor(1);
				workbook.write(outputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void clickOnWorkBench(String value) {

		try {

			xpath_GenericMethod_Click(lnk_wrkbench);

			Assert.assertTrue(true, "Successfully clicked on workbasket");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on workbasket");
		}

	}

	public void clickOnCSL1WorkBench(String value) {

		try {

			xpath_GenericMethod_Click(lnk_CSL1_wrkbench);

			Assert.assertTrue(true, "Successfully clicked on workbasket");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on workbasket");
		}

	}

	public void clickOn_COPPL1_WorkBench(String value) {

		try {

			xpath_GenericMethod_Click(lnk_wrkBench_COPPL1);

			Assert.assertTrue(true, "Successfully clicked on workbasket");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To click on workbasket");
		}

	}

	public void clickOnFilterToChooseRelevantCase(String pathTstData) throws Exception {
		for (int i = 0; i <= 5; i++) {
			// click on filter button
			xpath_GenericMethod_Click(btn_filter);
			xpath_GenericMethod_Click(btn_applyFilter);
			if (driver.findElement(By.xpath(txt_filtrSsearch)).isDisplayed()) {
				break;
			}
		}

		// Search
		xpath_GenericMethod_Sendkeys(txt_filtrSsearch, TestBase.caseID);

		// click on apply button
		xpath_GenericMethod_Click(btn_apply);

		// click on filtered case ID
		xpath_GenericMethod_Click(lnk_filteredCaseId);

	}

	public void clickOnFilterToChooseRelevantCaseToCheckPriority(String priority) throws Exception {

		xpath_GenericMethod_Click(headerClick_xpath);
		// click on filter button
		xpath_GenericMethod_Click(btn_filter_worklist);
		xpath_GenericMethod_Click(btn_applyFilter);
		// Enter the case id from test data in the "search" box
		xpath_GenericMethod_Sendkeys(txt_filtrSsearch, TestBase.caseID);
		// click on apply button
		xpath_GenericMethod_Click(btn_apply);

		// check if "Priority" appears or not
		String actualText = xpath_Genericmethod_getElementText(txt_Priority);
		Assert.assertEquals(actualText, priority);

		// click on filtered case ID
		xpath_GenericMethod_Click(lnk_filteredCaseId);

	}

	public void cancelRequest(String cancelRsn) throws Exception {
		try {

			// Click on Actions
			xpath_GenericMethod_Click(btn_Header_Actions);
			// Click on cancel request
			xpath_GenericMethod_Click(btn_CancelRequest);
			// Enter cancel reason
			xpath_GenericMethod_Sendkeys(txa_CanclReqRsn, cancelRsn);

		} catch (Exception e) {
			// Click on Actions
			xpath_Javascriptexecutor_GenericMethod_Click(btn_Header_Actions);
			// Click on cancel request
			xpath_GenericMethod_Click(btn_CancelRequest);
			// Enter cancel reason
			xpath_GenericMethod_Sendkeys(txa_CanclReqRsn, cancelRsn);
		}
	}

	public void clickOnFilterToChooseCase(String pathTstData) throws Exception {

		// click on filter button
		xpath_GenericMethod_Click(btn_filter);
		xpath_GenericMethod_Click(btn_applyFilter);
		try {
			if (!(TestBase.caseID).isEmpty()) {
				xpath_GenericMethod_Sendkeys(txt_filtrSsearch, TestBase.caseID);
			} else {

				String path = System.getProperty("user.dir");
				String filePath = path + "\\attachments\\TestData1.xlsx";

				FileInputStream fis = new FileInputStream(filePath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
				String caseID = sheet.getRow(0).getCell(0).getStringCellValue();

				xpath_GenericMethod_Sendkeys(txt_filtrSsearch, caseID);

			}

			xpath_GenericMethod_Click(btn_apply);

			// click on case ID
			xpath_GenericMethod_Click(btn_Filter_CancelCase);
		} catch (Exception e) {

		}

	}

	public void cancelRequestApprove(String cancelRsn, String status) throws Exception {

		// Click on approve under "Review decision"
		xpath_GenericMethod_Click(btn_ReviewDecision_Approve);

		// Enter comments
		xpath_GenericMethod_Sendkeys(txa_intlComments, cancelRsn);

		// Click on submit button
		xpath_GenericMethod_Click(btn_FinalSubmit);

		// Verify Resolved-cancelled
		verifyCompletedStatus(status);

	}

	public void assignPriority() throws Exception {
		// Click on Actions
		xpath_GenericMethod_Click(btn_Header_Actions);

		// click on Assign priority
		xpath_GenericMethod_Click(btn_AssignPriority);

		// wait
		waitFor(2);
		// Toggle on "yes" on the questionnaire "Do you want to make this case a
		// priority ?"
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(btn_ToggleOn)));

		// clicks on submit button
		xpath_GenericMethod_Click(btn_FinalSubmit);

		// click on Go button
		xpath_GenericMethod_Click(btn_Go);

	}

	public void clickOnUploadButtoninInitiation(String fileTyp1, String fileTyp2, String fileTyp3, String fileTyp4,
			String fileTyp5, String fileTyp6) throws Exception {
		try {
			// clicks on upload document button
			xpath_GenericMethod_Click(btn_upload);
			waitForElement(driver.findElement(By.xpath(txt_UploadPopup)), 1);

		} catch (NoSuchElementException e) {
			System.out.println("upload popup not displayed.. entering catch block");
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath(btn_upload))).build().perform();
		}

		// Creating 6 string buffer and passing the current project path
		StringBuffer Projectpath = new StringBuffer(System.getProperty("user.dir"));
		StringBuffer Projectpath2 = new StringBuffer(System.getProperty("user.dir"));
		StringBuffer Projectpath3 = new StringBuffer(System.getProperty("user.dir"));
		StringBuffer Projectpath4 = new StringBuffer(System.getProperty("user.dir"));
		StringBuffer Projectpath5 = new StringBuffer(System.getProperty("user.dir"));
		StringBuffer Projectpath6 = new StringBuffer(System.getProperty("user.dir"));

		// Appending ppt, excel, word files etc to current project path where the file
		// paths are passed from Examples
		StringBuffer wordFile = Projectpath.append(fileTyp1);
		StringBuffer excelFile = Projectpath2.append(fileTyp2);
		StringBuffer pptFile = Projectpath3.append(fileTyp3);
		StringBuffer pdfFile = Projectpath4.append(fileTyp4);
		StringBuffer jpegFile = Projectpath5.append(fileTyp5);
		StringBuffer pngFile = Projectpath6.append(fileTyp6);

		try {
			// wait for selectFile button
			waitFor(2);
			// Sending the file path to "select file" locator and all the file types gets
			// uploaded
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(wordFile);
			waitFor(2);
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(excelFile);
			waitFor(2);
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(pptFile);
			waitFor(2);
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(pdfFile);
			waitFor(2);
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(jpegFile);
			waitFor(2);
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(pngFile);

			Assert.assertTrue(true, "document(s) upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload documents");
		}

	}

	public void clickOnWorkbasketFilterToChooseRelevantCase(String pathTstData, String priority) throws Exception {

		// Mandatory "waitFor" added
		waitFor(1);
		// click on filter button
		xpath_Javascriptexecutor_GenericMethod_Click(btn_filterWorkbasket);

		// Enter the case id from test data in the "search" box
		xpath_GenericMethod_Sendkeys(txt_filtrSearchWorkBasket, TestBase.caseID);
		// click on apply button
		xpath_GenericMethod_Click(btn_apply);

		// check if "Priority" appears or not
		String actualText = xpath_Genericmethod_getElementText(txt_Priority);
		Assert.assertEquals(actualText, priority);

		// click on filtered case ID
		xpath_Javascriptexecutor_GenericMethod_Click(lnk_workbasketfilteredCaseId);

	}

	public void enterClientComments(String eKey) throws Exception {
		xpath_GenericMethod_Click(txa_ClientComments);
		xpath_GenericMethod_Sendkeys(txa_ClientComments, eKey);

	}

	public void verifySummaryInitiationTitle(String ekey) {
		waitForElement(driver.findElement(By.xpath(txt_Summary)), 30);
		String actualText = getElementText(txt_Summary).trim(); //added trim in this line to remove white spacesin string
		Assert.assertEquals(actualText, ekey);

	}

	public void clickOnWorkbasketFilterToChooseRelevantCase(String pathTstData) throws Exception {

		// Mandatory "waitFor" added
		waitFor(1);
		// click on filter button
		xpath_GenericMethod_Click(btn_filterWorkbasket);
		xpath_GenericMethod_Click(TEST_ApplyFilter_xpath);

		try {
			if (!(TestBase.caseID).isEmpty()) {
				// Enter the case id from test data in the "search" box
				xpath_GenericMethod_Sendkeys(txt_filtrSearchWorkBasket, TestBase.caseID);
			} else {
				String path = System.getProperty("user.dir");
				String filePath = path + "\\attachments\\TestData1.xlsx";

				FileInputStream fis = new FileInputStream(filePath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
				String caseID = sheet.getRow(0).getCell(0).getStringCellValue();

				xpath_GenericMethod_Sendkeys(txt_filtrSearchWorkBasket, caseID);
			}

			// click on apply button
			xpath_GenericMethod_Click(btn_apply);

			// click on filtered case ID
			xpath_Javascriptexecutor_GenericMethod_Click(lnk_workbasketfilteredCaseId);

		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter caseID");
		}

	}

	public void enterExternalCmnts(String cmnts) throws Exception {
		xpath_GenericMethod_ClickWithoutJS(txt_ExtlCmnts);
		xpath_GenericMethod_SendkeysWithoutJS(txt_ExtlCmnts, cmnts);

	}

	public void verifyRejectionComments(String cmnts) throws Exception {
		try {
			String a = xpath_Genericmethod_getElementText(txt_RejectionComments);
			Assert.assertEquals(a, cmnts);
		} catch (Exception e) {
			String a = xpath_Genericmethod_getElementText(txt_RejectionComments);
			Assert.assertEquals(a, cmnts);
		}

	}

	public void validateCommentsClient(String actionName, String actionComments, String actionBy) throws Exception {

		// clicks on Case 360 button
		xpath_GenericMethod_Click(btn_Case360);

		// clicks on "comments" section
		xpath_GenericMethod_Click(btn_Comments);

		// wait
		waitForElement(driver.findElement(By.xpath(txt_ActionNameClient)), 60);
		// get Action name text
		String name = getElementText(txt_ActionNameClient);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(actionName, name);

		// get Action comments text
		String comments = getElementText(txt_ActionCommentsClient);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(comments, actionComments);

		// get Action By text
		String actionDoneBy = getElementText(txt_ActionByClient);
		// validation to check Action Name matches the value passed in Examples
		Assert.assertEquals(actionBy, actionDoneBy);

	}

	public void waitForLoading() {
		try {
			WebElement loader = driver.findElement(By.xpath(icon_Loading));

			waitForElementToBeGone(loader, 20);
		} catch (Exception e) {
			System.out.println("Loader not present");
		}

	}

	public void validateRelatedCases() throws Exception {

		xpath_GenericMethod_Click(btn_Related);
		xpath_GenericMethod_Click(lnkCaseProcessID);
		xpath_GenericMethod_Click(btnGo);

	}

	public void verifyError(String errorMsg) throws Exception {
		xpath_Genericmethod_VerifyTextContains(txterrorMsg, errorMsg);
	}

	public void waitForSuccessMessage() throws Exception {
		String actualText = xpath_Genericmethod_getElementText(txt_SuccessMsg);
		if (actualText.contains("Thank you")) {
			System.out.println("Success message displayed successfully");
		}

	}

	public void clickOnUploadButtoninInitiationTwo(String fileTyp1) throws Exception {
		try {
			// clicks on upload document button
			xpath_GenericMethod_Click(btn_SecondUpload);
			waitForElement(driver.findElement(By.xpath(txt_UploadPopup)), 1);

		} catch (NoSuchElementException e) {
			System.out.println("upload popup not displayed.. entering catch block");
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath(btn_SecondUpload))).build().perform();
		}

		// Creating string buffer and passing the current project path
		StringBuffer Projectpath = new StringBuffer(System.getProperty("user.dir"));

		// Appending file to current project path where the file
		// path is passed from Examples
		StringBuffer wordFile = Projectpath.append(fileTyp1);

		try {
			// wait for selectFile button
			waitFor(2);
			// Sending the file path to "select file" locator and all the file types gets
			// uploaded
			driver.findElement(By.xpath(btn_selectFile)).sendKeys(wordFile);
			// Mandatory wait
			waitFor(1);

			Assert.assertTrue(true, "document upload is successfull");
		} catch (Exception e) {
			Assert.assertTrue(false, "unable to upload document");
		}

	}

}
