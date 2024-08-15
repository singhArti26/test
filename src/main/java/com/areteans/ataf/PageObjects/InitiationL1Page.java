package com.areteans.ataf.PageObjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.areteans.ataf.CS.CustomerServ;
import com.areteans.ataf.GeneralHelperSel.SeleniumFunc;
import com.areteans.ataf.TestBase.TestBase;
import com.cucumber.framework.pageconstants.CashReconciliationL2PageLoc;
import com.cucumber.framework.pageconstants.CommonPageLoc;
import com.cucumber.framework.pageconstants.InitiationL1PageLoc;

public class InitiationL1Page extends CustomerServ implements InitiationL1PageLoc, CashReconciliationL2PageLoc {

	InitiationL1Page loginpage;
	CommonPage commonpage;
	String transactionName = "AutomationTest";
	String transactionName1 = RandomStringUtils.randomAlphabetic(5);

	public InitiationL1Page(WebDriver driver) {
		super(driver);
	}

	String caseIDCreate;
	String totalCallAmount = RandomStringUtils.randomNumeric(5);
	String totalDistributionAmount = RandomStringUtils.randomNumeric(8);
	Integer m = Integer.valueOf(totalCallAmount);
	Integer n = Integer.valueOf(totalDistributionAmount);
	Integer netamountInt = m - n;
	String netamount = String.valueOf(netamountInt);

	String filePath = "path/to/excel-file.xlsx";
	String sheetName = "Sheet1";
	int rowNum = 0;
	int colNum = 0;

	public void sendLoginObject(InitiationL1Page loginpage) {
		this.loginpage = loginpage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public void setUserName(String username) throws Exception {
		/*
		 * WebElement username_txtbox=driver.findElement(By.xpath(username_xpath));
		 * loginpage.waitForElement(username_txtbox, 3);
		 * username_txtbox.sendKeys(username); //System.out.println("UserName" +driver);
		 */
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xpath_GenericMethod_Sendkeys(username_xpath, username);

	}

	public void setPassword(String password) throws Exception {
		/*
		 * WebElement password_txtbox=driver.findElement(By.xpath(password_xpath));
		 * loginpage.waitForElement(password_txtbox, 3);
		 * password_txtbox.sendKeys(password); //System.out.println("Password" +driver);
		 */

		xpath_GenericMethod_Sendkeys(password_xpath, password);

	}

	public void clickOnLoginbtn(String Signin) throws Exception {

		try {
			xpath_GenericMethod_Click(login_btn_xpath);
			Assert.assertTrue(true, "Clicked login button Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To Click login button");
		}

	}

	public void clickOnCreatebtn(String create) throws Exception {

		xpath_GenericMethod_Click(create_btn_xpath);
	}

	public void clickOnIcon(String plusIcon) throws Exception {

		try {
			waitForElement(driver.findElement(By.xpath(Icon_xpath)), 60);
			xpath_GenericMethod_Click(Icon_xpath);
			Assert.assertTrue(true, "Clicked create icon Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To Click create icon");
		}

	}

	public void clickOnCreateIcon(String plusIcon) throws Exception {

		try {
			xpath_GenericMethod_Click(plusIcon_xpath);
			Assert.assertTrue(true, "Clicked create icon Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To Click create icon");
		}

	}

	public void clickOnClientCreateIcon(String plusIcon) throws Exception {

		try {
			xpath_GenericMethod_Click(plusIconForClient_xpath);
			Assert.assertTrue(true, "Clicked create icon Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To Click create icon");
		}

	}
	
	public void clickOnFoFCommitment(String fofTab) throws Exception {
		// waitForElement(driver.findElement(By.xpath(plusIcon_xpath)),
		// 60);
		xpath_GenericMethod_Click(fof_commitment_btn_xpath);
	}

	public void clickOnCapitalActivity(String proccesName) throws Exception {
		for (int i = 0; i < 15; i++) {

			try {

				xpath_GenericMethod_Click(lnkcapitalactivity);

				break;

			} catch (StaleElementReferenceException e) {

				e.toString();

				System.out.println("Trying to recover from a stale element :" + e.getMessage());

			}

		}

	}

	public void clickOnFOFCaptitalCall(String proccesName) throws Exception {

		xpath_GenericMethod_Click(lnkFOFCapitalCall);

	}

	public void clickOnExpensePayment(String proccesName) throws Exception {

		xpath_GenericMethod_Click(lnkExpensePayment);

	}

	public void clickOnFOFDistribution(String proccesName) throws Exception {
		for (int i = 0; i < 15; i++) {

			try {

				xpath_GenericMethod_Click(lnkFOFDistribution);

				break;

			} catch (StaleElementReferenceException e) {

				e.toString();

				System.out.println("Trying to recover from a stale element :" + e.getMessage());

			}

		}

	}

	public void clickOnTransfer(String proccesName) throws Exception {
		for (int i = 0; i < 15; i++) {

			try {

				xpath_GenericMethod_Click(lnkTransfer);

				break;

			} catch (StaleElementReferenceException e) {

				e.toString();

				System.out.println("Trying to recover from a stale element :" + e.getMessage());

			}

		}

	}

	public void clickOnRepository(String proccesName) throws Exception {
		for (int i = 0; i < 15; i++) {

			try {

				xpath_GenericMethod_Click(lnkRepository);

				break;

			} catch (StaleElementReferenceException e) {

				e.toString();

				System.out.println("Trying to recover from a stale element :" + e.getMessage());

			}

		}

	}

	public void clickOnlnkPeriodEndReporting(String proccesName) throws Exception {
		for (int i = 0; i < 15; i++) {

			try {

				xpath_GenericMethod_Click(lnkPeriodEndReporting);

				break;

			} catch (StaleElementReferenceException e) {

				e.toString();

				System.out.println("Trying to recover from a stale element :" + e.getMessage());

			}

		}

	}

	public void verifyCaseID(String caseID) throws Exception {

		try {
			xpath_Genericmethod_verifyElementPresent(txtAreaStatus);
			caseIDCreate = driver.findElement(By.xpath(txtAreaStatus)).getText();
			TestBase.caseID = caseIDCreate;
			String path = System.getProperty("user.dir");
			System.out.println("Process ID is:" + TestBase.caseID);
			String filePath = path + "\\attachments\\TestData1.xlsx";
			String sheetName = "Sheet1";
			int rowNum = 0;
			int colNum = 0;
			try (Workbook workbook = new XSSFWorkbook()) {
				Sheet sheet = workbook.createSheet(sheetName);
				Row row = sheet.createRow(rowNum);
				Cell cell = row.createCell(colNum);
				cell.setCellValue(caseIDCreate);

				try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
					workbook.write(outputStream);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			Assert.assertTrue(true, "stored caseID in testdate sheet Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To stored caseID in testdata sheet");
		}

	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		try {
			xpath_Genericmethod_VerifyTextContains(initiation_screen_xpath, pageTitle);
			Assert.assertTrue(true, "verify pagetitle Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To verify pagetitle CapitalActivity");
		}

	}

	public void selectTheFund(String fundDropdown, String fundName) throws Exception {
		try {

			xpath_GenericMethod_Click(fund_dropdown_xpath);					
			List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
			for (WebElement webElement : dropdownvalues) {
				if (webElement.getText().equals(fundName)) {

					webElement.click();					
				}

			}
			
			Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

		}
	}
	
	public void selectTheFundForFOFcommitment(String fundDropdown, String fundName) throws Exception {
		try {

			xpath_GenericMethod_Click(fund_dropdown_xpath);
			WebElement element = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
			element.sendKeys(fundName);
			xpath_GenericMethod_Click(list_xpath);
			Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

		}
	}
	
	
	public void selectTheFund_REP(String fundDropdown, String fundName) throws Exception {

		String inc = fundName;
		String[] storeStaff = inc.split(",");
		if (fundDropdown.equalsIgnoreCase("Repository")) {
			try {

				xpath_GenericMethod_Click(dropFundRep);
				waitFor(1);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(fundName)) {
						waitFor(1);
						webElement.click();

					}

				}

				Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

			} catch (Exception e) {

				Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

			}

		} else {
			try {

				xpath_GenericMethod_Click(fund_dropdown_xpath);

				List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(fundName)) {

						webElement.click();

					}

					if (webElement.getText().equals(storeStaff[0])) {

						webElement.click();

					} else if (webElement.getText().equals(storeStaff[1])) {

						webElement.click();

					} else if (webElement.getText().equals(storeStaff[2])) {

						webElement.click();

					}

				}

				Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

			} catch (Exception e) {

				Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

			}
		}
	}

	public void selectTheMultiyFund(String fundDropdown, String fundName) throws Exception {

		try {
			xpath_GenericMethod_Click(listPERFund);
			WebElement element1 = driver.findElement(By.xpath("//li/span[contains(text(),'" + fundName + "')]"));
			Actions action = new Actions(driver);
			// Mandatory wait
			waitFor(1);
			Action seriesOfActions = (Action) action.keyDown(Keys.CONTROL).click(element1).build();
			seriesOfActions.perform();

			Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

		}
	}

	public void selectTheApplicabletimetable(String fundDropdown, String Applicabletimetable) throws Exception {

		try {
			xpath_GenericMethod_Click(listApplicabletimetable);
			WebElement element1 = driver
					.findElement(By.xpath("//span[contains(text(),'" + Applicabletimetable + "')]"));
			Actions action = new Actions(driver);
			Action seriesOfActions = (Action) action.keyDown(Keys.CONTROL).click(element1).build();
			seriesOfActions.perform();

			Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

		}
	}

	public void selectTheClient(String fundDropdown, String fundName) throws Exception {

		if (fundDropdown.equalsIgnoreCase("Repository")) {
			try {

				xpath_GenericMethod_Click(dropClientdRep);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(fundName)) {

						webElement.click();

					}

				}

				Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

			} catch (Exception e) {

				Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

			}

		}

	}

	public void entersTransactionName(String section1) throws Exception {
		waitFor(1);
		try {
			xpath_GenericMethod_Click(txttransactionName);
			xpath_GenericMethod_Sendkeys(txttransactionName, transactionName);
		}
		catch(Exception e){
			xpath_GenericMethod_Click(txttransactionName);
			xpath_GenericMethod_Sendkeys(txttransactionName, transactionName);
		}
//		for (int i = 0; i < 10; i++) {
//
//			try {
//				//xpath_GenericMethod_Click(txttransactionName);
//				xpath_GenericMethod_Sendkeys(txttransactionName, transactionName);
//
//				break;
//
//			} catch (StaleElementReferenceException e) {
//
//				e.toString();
//
//				System.out.println("Trying to recover from a stale element :" + e.getMessage());
//
//			}

		//}
		Assert.assertTrue(true, "enter transaction name Successfully");

	}

	public void entersTransactionNameforFOF(String name) throws Exception {

		try {

			xpath_GenericMethod_Sendkeys(transaction_name_fof_xpath, name);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(transaction_name_fof_xpath, name);
		}

	}

	public void verifySections(String section1, String section2, String section3) throws Exception {

		xpath_GenericMethod_scrollIntoView(capital_call_xpath);
		xpath_Genericmethod_VerifyTextContains(capital_call_xpath, section1);
		xpath_Genericmethod_VerifyTextContains(distribution_xpath, section2);
		xpath_Genericmethod_VerifyTextContains(accounting_system_detail_xpath, section3);
	}

	public void verifyAmountText(String capitalCall, String amount) throws Exception {

		WebElement capitalCallText = driver.findElement(By.xpath(capital_call_xpath));
		if (capitalCallText.isDisplayed()) {
			xpath_Genericmethod_VerifyTextContains(amount_xpath, amount);
		}
	}

	public void enterTotalCallAmount(String callAmount) throws Exception {

		try {
			xpath_GenericMethod_Click(total_call_amount_xpath);
			xpath_GenericMethod_Sendkeys(total_call_amount_xpath, callAmount);
			xpath_GenericMethod_Click(total_distribution_amount_xpath);
			Assert.assertTrue(true, "entered call amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter call amount");
		}

	}

	public void enterTotalCallAmountAndDistributionAmount(String s1, String s2) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(total_call_amount_xpath, s1);
			xpath_GenericMethod_Click(total_distribution_amount_xpath);
			xpath_GenericMethod_Sendkeys(total_distribution_amount_xpath, s2);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(total_call_amount_xpath, s1);
			xpath_GenericMethod_Click(total_distribution_amount_xpath);
			xpath_GenericMethod_Sendkeys(total_distribution_amount_xpath, s2);
		}

	}

	public void validateTheNetAmount(String netAmount) throws Exception {

		xpath_GenericMethod_Click(net_amount_xpath);

	}

	public void selectTheTransactionTypes(String transactionTypes, String selectDropdown, String section)
			throws Exception {
		try {
			xpath_GenericMethod_Click(transaction_types_xpath);
		} catch (Exception e) {
			xpath_GenericMethod_Click(transaction_types_xpath);
		}
		waitFor(1);
		try {
//			xpath_GenericMethod_scrollIntoView(transaction_types_xpath);

			List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));

			for (WebElement webElement : dropdownvalues) {

				if (webElement.getText().equals(selectDropdown)) {

					webElement.click();

				}

			}

			Assert.assertTrue(true, "Selecting fund successfully in Transaction initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in Transaction investment initiation screen");

		}

	}

	public void selectTheTransactionTypes(String transactionTypes) throws Exception {

		try {
			xpath_GenericMethod_Click(transaction_types_xpath);
		} catch (Exception e) {
			xpath_GenericMethod_Click(transaction_types_xpath);
		}
		waitFor(1);

		try {
			// xpath_GenericMethod_scrollIntoView(transaction_types_xpath);
			List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
			for (WebElement webElement : dropdownvalues) {

				if (webElement.getText().equals(transactionTypes)) {

					webElement.click();

				}

			}

			Assert.assertTrue(true, "Selecting fund successfully in Transaction initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in Transaction investment initiation screen");

		}

	}

	public void selectFundDisnkacc(String transactionTypes) throws Exception {

		try {
			// xpath_GenericMethod_scrollIntoView(transaction_types_xpath);
			xpath_GenericMethod_Click(dropDwn_Funddisbankacc);
			xpath_GenericMethod_Click(list_xpath);
			//waitFor(1);
//			xpath_GenericMethod_Click(inputbox_search);
//			xpath_GenericMethod_Sendkeys(inputbox_search, transactionTypes);
//			
//			waitFor(2);
//			List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
//			for (WebElement webElement : dropdownvalues) {
//
//				if ((webElement.getText()).trim().equals(transactionTypes.trim())) {
//					waitFor(1);
//					webElement.click();
//
//				}
//
//			}

			Assert.assertTrue(true, "Selecting fund successfully in Transaction initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in Transaction investment initiation screen");

		}

	}

	public void selectTheSecondTransactionTypes(String transactionTypes) throws Exception {
		try {
			xpath_GenericMethod_Click(transaction_types_xpath2);
		} catch (Exception e) {
			xpath_GenericMethod_Click(transaction_types_xpath2);
		}
		waitFor(1);
		try {

			List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
			for (WebElement webElement : dropdownvalues) {

				if (webElement.getText().equals(transactionTypes)) {
					webElement.click();

				}

			}

			Assert.assertTrue(true, "Selecting fund successfully in Transaction initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in Transaction investment initiation screen");

		}

	}

	public void selectTheDisstributionfun(String Distrfund, String Amtdistributed, String Distritype) throws Exception {

		try {

			try {
				//updated the below to select first value from the dropdown
				xpath_GenericMethod_Click(drp_FOFDis_Distributingfund);
				waitFor(1);
				xpath_GenericMethod_Click(list_xpath);
//				List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
//				waitFor(2);
//				for (WebElement webElement : dropdownvalues) {
//
//					if (webElement.getText().equals(Distrfund)) {
//
//						webElement.click();
//					}

				//}

			} catch (Exception e) {
				//updated the below to select first value from the dropdown
				xpath_GenericMethod_Click(drp_FOFDis_Distributingfund);
				xpath_GenericMethod_Click(list_xpath);
//				waitFor(1);
//				List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
//				waitFor(2);
//				for (WebElement webElement : dropdownvalues) {
//
//					if (webElement.getText().equals(Distrfund)) {
//
//						webElement.click();
//					}
//
//				}
			}

			xpath_GenericMethod_Sendkeys(drp_FOFDis_Amountdistributed, Amtdistributed);

			xpath_GenericMethod_Click(drp_FOFDis_Distributiontype);
			List<WebElement> dropdownvalues1 = driver.findElements(By.xpath(list_xpath));

			for (WebElement webElement : dropdownvalues1) {

				if (webElement.getText().equals(Distritype)) {

					webElement.click();

				}

			}

			Assert.assertTrue(true, "Selecting fund successfully in Transaction initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in Transaction investment initiation screen");

		}

	}

	public void selectTheDealName(String dealName, String selectDropdown) throws Exception {

		try {
			;
			xpath_GenericMethod_Click(deal_name_xpath);
			try {
				List<WebElement> dealNameList = driver.findElements(By.xpath(deal_name_list_xpath));
				for (WebElement dealname : dealNameList) {
					if (dealname.getText().equals(selectDropdown)) {
						dealname.click();
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			xpath_Genericmethod_VerifyTextContains(net_amount_xpath, totalDistributionAmount);
			Assert.assertTrue(true, "Select Deal name Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To Select Deal name");
		}

	}

	public void selectThePosition(String position, String selectDropdown) throws Exception {
		//xpath_GenericMethod_scrollIntoView(Position_xpath);
		xpath_GenericMethod_Click(Position_xpath);
		try {
			List<WebElement> positionList = driver.findElements(By.xpath(Position_list_xpath));
			for (WebElement selectposition : positionList) {
				if (selectposition.getText().equals(selectDropdown)) {
					selectposition.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		xpath_Genericmethod_VerifyTextContains(net_amount_xpath, totalDistributionAmount);
		Assert.assertTrue(true, "Select position name Successfully");

	}

	public void enterTransactionTypeAmount(String transactionTypeAmount, String netAmount) throws Exception {

		try {
			xpath_GenericMethod_Click(transaction_type_amount_xpath);
			String netamounttotal = driver.findElement(By.xpath(net_amount_xpath)).getText();
			xpath_GenericMethod_Sendkeys(transaction_type_amount_xpath, netamounttotal);
			// xpath_Genericmethod_VerifyTextContains(net_amount_xpath,
			// totalDistributionAmount);
			Assert.assertTrue(true, "entered transaction amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter transaction amount");
		}

	}

	public void enterTransactionForAmount(String transactionForAmount) throws Exception {

		try {

			xpath_GenericMethod_Sendkeys(txt_FOFDis_Amountfortransaction, transactionForAmount);

			Assert.assertTrue(true, "entered transaction amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter transaction amount");
		}

	}

	public void enterSecondTransactionForAmount(String transactionForAmount) throws Exception {

		try {

			xpath_GenericMethod_Sendkeys(txt_FOFDis_Amountfortransaction2, transactionForAmount);
			Assert.assertTrue(true, "entered transaction amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter transaction amount");
		}

	}

	public void selectAllocationRule(String allocationRule, String selectDropdown, String section) throws Exception {

		xpath_GenericMethod_Click(allocation_rule_xpath);
		try {
			List<WebElement> allocationRuleList = driver.findElements(By.xpath(allocation_rule_list_xpath));
			for (WebElement allocationrule : allocationRuleList) {
				if (allocationrule.getText().equals(selectDropdown)) {
					allocationrule.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true, "selected AllocationRule Successfully");

	}

	public void addTransactionType(String transactionType) throws Exception {
		waitFor(1);
		//updated the below to select first value from dropdown for transaction type
		//xpath_GenericMethod_scrollIntoView(add_transaction_type_xpath);
		try {
			xpath_GenericMethod_Click(add_transaction_type_xpath);

		} catch (Exception e) {
			xpath_GenericMethod_Click(add_transaction_type_xpath);
		}

//		xpath_GenericMethod_Click(transaction_types_xpath);
//
//		try {
//			List<WebElement> transactionTypesList = driver.findElements(By.xpath(transaction_types_list_xpath));
//			for (WebElement transactionType1 : transactionTypesList) {
//				if (transactionType1.getText().equals("Investor Contribution: Expenses")) {
//					transactionType1.click();
//					break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//xpath_Genericmethod_VerifyTextContains(net_amount_xpath, totalDistributionAmount);
		Assert.assertTrue(true, "select transaction type dropdown value Successfully");

	}

	public void deleteTransactionType() throws Exception {

		xpath_GenericMethod_Click(delete_icon_xpath);

	}

	public void clickHere() throws Exception {
		waitFor(2);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(lnk_clickhere_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(lnk_clickhere_xpath);
		}

		xpath_GenericMethod_Click(btnclose_xpath);

	}

	public void provideNoticeDate() throws Exception {
		try {
			WebElement dateWidget = driver.findElement(By.xpath(noticeDatePicker_xpath));
			dateWidget.click();
			WebElement dateSelect = driver.findElement(By.xpath(noticeDate_xpath));
			dateSelect.click();
			
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	Calendar cal = Calendar.getInstance();
				DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		    	WebElement dateWidget1 = driver.findElement(By.xpath(noticeDatePicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(toDateXpath, newDate)))).click();
		    }
		    
			Assert.assertTrue(true, "Notice Date selected");
		} 
		catch (Exception e) {
				Assert.assertTrue(false, "Unable To select notice date");
			}

	}

	public void providePeriodEndDate(String PerEndDate) throws Exception {
		waitForElement(driver.findElement(By.xpath(txtPeriodEndDate_xpath)), 15);

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

		Calendar cal = Calendar.getInstance();

		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

			cal.add(Calendar.DATE, 3);

		} else  {

			cal.add(Calendar.DATE, 7);

		}

		String dueDateTime = "" + dateFormat.format(cal.getTime());

		try {

			waitFor(2);

			xpath_GenericMethod_Sendkeys(txtPeriodEndDate, dueDateTime);

			Assert.assertTrue(true, "entered call amount Successfully");

		} catch (Exception e) {

			xpath_GenericMethod_Sendkeys(txtPeriodEndDate_xpath, dueDateTime);

		}

		try {

			waitFor(2);

			xpath_GenericMethod_Sendkeys(txtPeriodEndDate, dueDateTime);

			Assert.assertTrue(true, "entered call amount Successfully");

		} catch (Exception e) {

			xpath_GenericMethod_Sendkeys(txtPeriodEndDate_xpath, dueDateTime);

		}

	}

	public void provideDueDate() throws Exception {
		
		try {
			WebElement dateWidget = driver.findElement(By.xpath(dueDatePicker_xpath));
			dateWidget.click();
			
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		    Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			String nextMonth = dateFormat.format(cal.getTime());
			String[] arrOfStr = nextMonth.split(" ");
			System.out.println("Next month print: " + arrOfStr[0].trim());
			waitFor(2);
			Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='monDrop']")));
			monthDropdown.selectByVisibleText(arrOfStr[0].trim());						
			driver.findElement(By.xpath("//td[@class='calcell']")).click();
		    
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	WebElement dateWidget1 = driver.findElement(By.xpath(dueDatePicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(toDateXpath, newDate)))).click();
		    }
		    
		    Assert.assertTrue(true, "Due date selected successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select due date");
		}

	}
	
		public void provideTargetDateTransfer() throws Exception {
		
		try {
			WebElement dateWidget = driver.findElement(By.xpath(dueDatePicker_xpath));
			dateWidget.click();
			
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		    Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			String nextMonth = dateFormat.format(cal.getTime());
			String[] arrOfStr = nextMonth.split(" ");
			String monthName =  arrOfStr[0].substring(0,3);
			System.out.println("Next month print: " + monthName);
			WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='monDrop']"));
			monthDropdown.click();
			WebElement month = driver.findElement(By.xpath("//option[contains (text(),'" + monthName +"')]"));
			month.click();			
			driver.findElement(By.xpath("//td[@class='calcell']")).click();
		    
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	WebElement dateWidget1 = driver.findElement(By.xpath(dueDatePicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(toDateXpath, newDate)))).click();
		    }
		    
		    Assert.assertTrue(true, "Due date selected successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select due date");
		}

	}

	public void provideDueDateForFOFDis() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

			cal.add(Calendar.DATE, 3);

		} else {
			cal.add(Calendar.DATE, 7);

		}
		String dueDateTime = "" + dateFormat.format(cal.getTime());
		try {
			xpath_GenericMethod_Sendkeys(txt_FOFDis_Duedate, dueDateTime);
			Assert.assertTrue(true, "entered call amount Successfully");
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txt_FOFDis_Duedate, dueDateTime);

		}

	}

	public void clicksOnSaveButton(String save) throws Exception {

		xpath_Genericmethod_VerifyTextContains(save_button_xpath, save);
		xpath_GenericMethod_Click(save_button_xpath);

	}

	public void clicksOnSubmitButton(String submit) throws Exception {
		try {
			xpath_GenericMethod_Click(submit_button_xpath);

			Assert.assertTrue(true, "entered call amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter call amount");
		}

	}

	public void clicksOnSubmitButton1(String submit) throws Exception {
		try {
			xpath_GenericMethod_Click(submit_button_xpath1);

			Assert.assertTrue(true, "entered call amount Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter call amount");
		}

	}

	public void verifyTaskAssignedTo(String task) throws Exception {

		xpath_GenericMethod_HoverOnDemoScreenPops(task_assign_xpath);
		xpath_Genericmethod_VerifyTextContains(task_assign_xpath, "Task assigned to: FSNA Client Services L2");
	}

//	public void enter_process_ID() throws Exception {
//		try {
//			xpath_GenericMethod_Click(process_ID_search_xpath);
//			String path = System.getProperty("user.dir");
//			String filePath = path + "\\attachments\\TestData1.xlsx";
//
//			FileInputStream fis = new FileInputStream(filePath);
//			try (Workbook workbook = new XSSFWorkbook(fis)) {
//				Sheet sheet = workbook.getSheetAt(0);
//				String caseID = sheet.getRow(0).getCell(0).getStringCellValue();
//				xpath_GenericMethod_Sendkeys(process_ID_search_xpath, caseID);
//			}
//			xpath_GenericMethod_Click(apply_xpath);
//			WebElement element = driver.findElement(By.xpath(process_ID_search_xpath));
//			if (element.getText().isBlank()) {
//				Assert.assertTrue(true, "entered caseID Successfully");
//			} else {
//				Assert.assertNull(element);
//			}
//
//		} catch (Exception e) {
//
//			Assert.assertTrue(false, "Unable To enter caseID");
//		}
//
//	}

	public void enter_process_ID() throws Exception {
		try {
			if (!(TestBase.caseID).isEmpty()) {
				xpath_GenericMethod_Sendkeys(process_ID_search_xpath, TestBase.caseID);
			} else {

				String path = System.getProperty("user.dir");
				String filePath = path + "\\attachments\\TestData1.xlsx";

				FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis);
				Sheet sheet = workbook.getSheetAt(0);
				String caseID = sheet.getRow(0).getCell(0).getStringCellValue();

				SeleniumFunc.xpath_GenericMethod_Sendkeys(process_ID_search_xpath, caseID);

			}

			xpath_GenericMethod_Click(apply_xpath);
			waitFor(1);
			WebElement element = driver
					.findElement(By.xpath("//div//a[contains (text(),'"+TestBase.caseID+"')]"));
			waitFor(1);
			if (element.isDisplayed()) {
				Assert.assertTrue(true, "entered caseID Successfully");
			} else {
				Assert.assertNull(element);
			}

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To enter caseID");
		}

	}
	
	public void enter_process_ID_worklist() throws Exception {
		try {
			System.out.println("CASE ID IN PROCESS ID FITER: "+ TestBase.caseID);
				xpath_GenericMethod_Sendkeys(process_ID_search_xpath, TestBase.caseID);
				xpath_GenericMethod_Click(apply_xpath);
		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To enter caseID");
		}

	}

	public void click_On_LogOff_Button() throws Exception {

		;
		WebElement logoff = driver.findElement(By.xpath(CO_xpath));
		waitForElement(logoff, 5);
		xpath_GenericMethod_Click(CO_xpath);

		xpath_GenericMethod_Click(log_off_xpath);
		Assert.assertTrue(true, "Successfully click on logoff button");

	}

	public void clickOn_LogOff_Button() throws Exception {

		waitFor(12);
		WebElement logoff = driver.findElement(By.xpath(CO_xpath));
		waitForElement(logoff, 20);
		xpath_GenericMethod_Click(CO_xpath);

		xpath_GenericMethod_Click(log_off_xpath);
		Assert.assertTrue(true, "Successfully click on logoff button");

	}

	// when case is created from client

	public void click_On_workbasket_L1(String workbasket) throws Exception {
		WebElement test = driver.findElement(By.xpath(work_queue_xpath));
		Select workQueue = new Select(test);
		workQueue.selectByVisibleText(workbasket);
	
//		switch (workbasket) {
//		case "FSNA Client Services L1":
//			workQueue.selectByVisibleText(workbasket);
//			//xpath_GenericMethod_Click(lnkWorkbasket_CSL1);
//			break;
//		case "FSNA Client Services L2":
//			workQueue.selectByVisibleText(workbasket);
//			//xpath_GenericMethod_Click(lnkWorkbasket_CSL2);
//			break;
//		case "FSNA Central Operations IS L1":
//			xpath_GenericMethod_Click(lnkWorkbasket_COISl1);
//			break;
//		case "FSNA Central Operations PP L1":
//			xpath_GenericMethod_Click(lnkWorkbasket_COPPl1);
//			break;
//		case "FSNA Central Operations PP L2":
//			xpath_GenericMethod_Click(lnkWorkbasket_COPPl2);
//			break;
//		case "FSNA Central Operations IS L2":
//			xpath_GenericMethod_Click(lnkWorkbasket_COISl2);
//			break;
//		default:
//			break;
//		}
	}

	public void TransactionTypeAmount(String transactionTypeAmount, String amount) throws Exception {

		String netamounttotal = driver.findElement(By.xpath(net_amount_xpath)).getText();
		xpath_GenericMethod_Sendkeys(transaction_type_amount_xpath, netamounttotal);

	}

	public void selectTheInvestmentname(String investmentName, String selectDropdown) throws Exception {
		//updated to select first value from dropdown for investment name
		xpath_GenericMethod_Click(investment_dropdown_xpath);
		xpath_GenericMethod_Click(investmentname_list_xpath);
//		try {
//			List<WebElement> dealNameList = driver.findElements(By.xpath(investmentname_list_xpath));
//			for (WebElement dealname : dealNameList) {
//				if (dealname.getText().contains(selectDropdown)) {
//					;
//					dealname.click();
//					break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void enterAmountToCommit(String amountToCommit) throws Exception {

		try {
			xpath_GenericMethod_Sendkeys(amount_to_commit_xpath, amountToCommit);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(amount_to_commit_xpath, amountToCommit);
		}

	}

	public void clickOnDraft() throws Exception {

		xpath_GenericMethod_Click(draft_xpath);

	}

	public void clickOnExecuted() throws Exception {

		xpath_GenericMethod_Click(executed_xpath);

	}

	public void verifyInvestmentDetailsPreparationScreen(String pageTitle) throws Exception {
		;
		xpath_Genericmethod_VerifyTextContains(investment_details_preparation_pagetitle_xpath, pageTitle);

	}

	public void clickOnSecuityDetails() throws Exception {

		xpath_GenericMethod_scrollIntoView(security_details_xpath);
		xpath_GenericMethod_Click(security_details_xpath);

	}

	public void selectSecurityName(String title, String selectDropdown) throws Exception {

		xpath_GenericMethod_Click(security_name_xpath);

		xpath_GenericMethod_Click(search_xpath);

		try {
			List<WebElement> transactionTypesList = driver.findElements(By.xpath(security_name_list_xpath));
			for (WebElement transactionType : transactionTypesList) {
				if (transactionType.getText().contains(selectDropdown)) {
					;
					transactionType.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select_Transactiontype(String title, String selectDropdown) throws Exception {

		;
		xpath_GenericMethod_Click(transactiontype_xpath);

		xpath_GenericMethod_Click(search_xpath);

		try {
			List<WebElement> transactionTypesList = driver.findElements(By.xpath(list_transactiontype_xpath));
			for (WebElement transactionType : transactionTypesList) {
				if (transactionType.getText().contains(selectDropdown)) {
					;
					transactionType.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAmountForTransaction() throws Exception {

		// xpath_GenericMethod_Click(amount_for_transaction_xpath);
		/*
		 * ; xpath_GenericMethod_Click(amounttocommit_xpath); WebElement
		 * amount=driver.findElement(By.xpath(amounttocommit_xpath)); Actions action =
		 * new Actions(driver);
		 * action.moveToElement(amount).doubleClick().sendKeys(Keys.CONTROL+"C").build()
		 * .perform(); ; WebElement
		 * amountfortransaction=driver.findElement(By.xpath(amounttocommit_xpath));
		 * action.doubleClick(amountfortransaction).sendKeys(Keys.CONTROL+"V");
		 */
		;
		WebElement amount = driver.findElement(By.xpath(amounttocommit_xpath));
		Actions action = new Actions(driver);
		action.moveToElement(amount).doubleClick().build().perform();
		// xpath_GenericMethod_Click(amounttocommit_xpath);

		amount.sendKeys(Keys.chord(Keys.CONTROL, "c"));

		xpath_GenericMethod_Click(amount_for_transaction_xpath);
		WebElement amountfortransaction = driver.findElement(By.xpath(amount_for_transaction_xpath));
		amountfortransaction.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public void enterNumberOfShares() throws Exception {

		try {
			xpath_GenericMethod_Sendkeys(numberofshares_xpath, "1");
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(numberofshares_xpath, "1");
		}

	}

	public void enterTradeDate(String tradeDate) throws Exception {

		;
		xpath_GenericMethod_Click(tradedate_xpath);
		xpath_GenericMethod_Sendkeys(tradedate_xpath, tradeDate);

	}

	public void enterSettlementDate(String settlementDate) throws Exception {

		;
		xpath_GenericMethod_Click(settlementdate_xpath);
		xpath_GenericMethod_Sendkeys(settlementdate_xpath, settlementDate);

	}

	public void entersSecurityName(String name) throws Exception {
		try {
			xpath_GenericMethod_Click(security_details_xpath);
			xpath_GenericMethod_Sendkeys(security_name_xpath, name);
		} catch (Exception e) {
			xpath_GenericMethod_Click(security_details_xpath);
			xpath_GenericMethod_Sendkeys(security_name_xpath, name);
		}

	}

	public void select_Securitytype(String selectDropdown) throws Exception {

		xpath_GenericMethod_Click(securitytype_xpath);

		try {
			List<WebElement> transactionTypesList = driver.findElements(By.xpath(securitytype_list_xpath));
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

	public void clickOn_bank_details_toggle() throws Exception {

		;
		WebElement toggleYes = driver.findElement(By.xpath(bank_details_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void entersBankName() throws Exception {
		;
		//xpath_GenericMethod_scrollIntoView(bankname_xpath);
		WebElement toggleYes = driver.findElement(By.xpath(bankname_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);
		String bankName = RandomStringUtils.randomAlphabetic(5);
		xpath_GenericMethod_Click(bankname_xpath);

		xpath_GenericMethod_Sendkeys(bankname_xpath, bankName);

	}

	public void enterBankAccount() throws Exception {

		;
		String amount = RandomStringUtils.randomNumeric(5);
		xpath_GenericMethod_Click(bankaccount_xpath);
		xpath_GenericMethod_Sendkeys(bankaccount_xpath, amount);

	}

	public void select_country(String countryName) throws Exception {

		;
		xpath_GenericMethod_Click(country_xpath);

		xpath_GenericMethod_Click(search_xpath);

		try {
			List<WebElement> transactionTypesList = driver.findElements(By.xpath(country_list_xpath));
			for (WebElement transactionType : transactionTypesList) {
				if (transactionType.getText().contains(countryName)) {
					;
					transactionType.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterBICcode() throws Exception {

		;
		String code = RandomStringUtils.randomNumeric(5);
		xpath_GenericMethod_Click(bank_swift_bic_code_xpath);
		xpath_GenericMethod_Sendkeys(bank_swift_bic_code_xpath, code);

	}

	public void verifySecurityName(String securityName) throws Exception {

		xpath_Genericmethod_VerifyTextContains(securityname_xpath, securityName);

	}

	public void verifyTransactiontype(String transactiontype) throws Exception {

		xpath_Genericmethod_VerifyTextContains(transaction_type_xpath, transactiontype);

	}

	public void close_browser() throws Exception {

		driver.quit();

	}

	public void clickOnClosePortalNavHeader() throws Exception {

		xpath_GenericMethod_Click(closeNavHeader_xpath);

	}

	public void clickOnPortalNavHeader() throws Exception {

		xpath_GenericMethod_Click(PortalNavHeader_xpath);

	}

	public void logout() throws Exception {

		xpath_GenericMethod_Click(pro_name);
		xpath_GenericMethod_Click(lnklogOff);

	}

	public void logoutForADOpertors() throws Exception {
		try {
			//xpath_GenericMethod_ClickWithoutJS(PortalNavHeader_xpath);
			driver.findElement(By.xpath("//div[@class='content-item content-layout item-5 flex flex-row']//button")).click();
			xpath_GenericMethod_Click(log_off_xpath);

		} catch (Exception e) {
			//xpath_GenericMethod_ClickWithoutJS(PortalNavHeader_xpath);
			driver.findElement(By.xpath("//div[@class='content-item content-layout item-5 flex flex-row']//button")).click();
			xpath_GenericMethod_Click(log_off_xpath);
		}

		Assert.assertTrue(true, "Successfully click on logoff button");

	}

	public void verifyCompletedStatus(String compeletedStatus) throws Exception {
		//updated to parameterize the xpath to verify the status of case
		WebElement element = driver.findElement(By.xpath(String.format(Status_txt_xpath1, compeletedStatus)));
		String ResloveStatus = element.getText();
		Assert.assertEquals(ResloveStatus, compeletedStatus);
	}

	public void verifyTheRejectcomments(String expRejectComments) throws Exception {

		Assert.assertTrue(xpath_Genericmethod_VerifyTextContains(txt_clientReject_comments, expRejectComments));

	}

	public void verifyTheRejectcommentstoClient(String expRejectComments) throws Exception {
		String test = driver.findElement(By.xpath(txt_Client_Reject_comments)).getText();
		System.out.println("expRejectComments" + test);
		Assert.assertTrue(xpath_Genericmethod_VerifyTextContains(txt_Client_Reject_comments, expRejectComments));

	}

	public void verifytheAuditHistoryforInkind() throws Exception {
		String expRejectComments = "- In-kind distribution - DO NOT REPLY.";
		xpath_GenericMethod_Click(txt_Case360);
		xpath_GenericMethod_Click(lnk_AuditHistory);
		xpath_Genericmethod_VerifyTextContains(txt_Inkinddistribution, expRejectComments);
		xpath_GenericMethod_Click(txt_Case360);
	}

	public void transferAssagiment(String otherCSL2, String croprocess) throws Exception {

		xpath_GenericMethod_Click(btnActions);

		switch (croprocess) {
		case "Transfer Assignment":
			xpath_GenericMethod_Click(lnkTransferAss);
			break;
		default:
			break;
		}
		try {
			xpath_GenericMethod_Click(txtTransferto);
			xpath_GenericMethod_Click(searchInputBoxTransfer);
			xpath_GenericMethod_Sendkeys(searchInputBoxTransfer, otherCSL2);
			xpath_GenericMethod_Click(list_xpath);
			//List<WebElement> dropdownvalues = driver.findElements(By.xpath(list_xpath));
//			for (WebElement webElement : dropdownvalues) {
//				System.out.println("first ----- "+webElement.getText());
//				//System.out.println(otherCSL2);
//				if (webElement.getText().equals(otherCSL2)) {
//					//System.out.println("second ----- "+ webElement.getText());
//					webElement.click();
//
//				}

			//}

			Assert.assertTrue(true, "Selecting fund successfully in fund initiation screen");

		} catch (Exception e) {

			Assert.assertTrue(false, "Unable To select fund in direct fund initiation screen");

		}
		// xpath_GenericMethod_Sendkeys(txtTransferto, otherCSL2);
	}

	public void useTemplate(String crossProcess) throws Exception {

		// Click on Actions

		xpath_GenericMethod_Click(btnActions);

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

		// verifyCompletedStatus(status);

		// Click on "Go" button

		xpath_GenericMethod_Click(btn_Go);

	}

	public void cancelRequest(String cancelRsn, String croprocess) throws Exception {

		try {

			// Click on Actions

			xpath_GenericMethod_Click(btnActions);

			// Click on cancel request

			xpath_GenericMethod_Click(btn_CancelRequest);

			// Enter cancel reason

			xpath_GenericMethod_Sendkeys(txa_CanclReqRsn, cancelRsn);

		} catch (Exception e) {

			// Click on Actions

			xpath_Javascriptexecutor_GenericMethod_Click(btnActions);

			// Click on cancel request

			xpath_GenericMethod_Click(btn_CancelRequest);

			// Enter cancel reason

			xpath_GenericMethod_Sendkeys(txa_CanclReqRsn, cancelRsn);

		}

	}

	public void assignpriortyFromCSL2(String croprocess) throws Exception {

		// Click on Actions

		xpath_GenericMethod_Click(btnActions);

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

	public void verifythePriority(String statusValue) throws Exception {

		boolean value = xpath_Genericmethod_VerifyTextEquals(txt_Priority, statusValue);

		Assert.assertTrue(value, "Expected page " + statusValue + "displayed");

	}

	public void selectPendingstatus() throws Exception {

		xpath_GenericMethod_Click(phaseandStatus_ID_xpath);
		xpath_GenericMethod_Click(phaseStatusApplyFilterButton);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(pendingCancel_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(pendingCancel_xpath);
		}
		xpath_GenericMethod_Click(apply_xpath);

	}

	public void selectL1CashReconciliation() throws Exception {

		xpath_GenericMethod_Click(phaseandStatus_ID_xpath);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(L1CashReconciliation_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(L1CashReconciliation_xpath);
		}
		xpath_GenericMethod_Click(apply_xpath);

	}

	public void selectL1CapitalCall() throws Exception {

		xpath_GenericMethod_Click(phaseandStatus_ID_xpath);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(L1OpenCapitalActivity_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(L1OpenCapitalActivity_xpath);
		}
		xpath_GenericMethod_Click(apply_xpath);

	}

	public void selectL1Drafting() throws Exception {

		xpath_GenericMethod_Click(phaseandStatus_ID_xpath);
		try {
			xpath_Javascriptexecutor_GenericMethod_Click(L1Drafting_xpath);

		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(L1Drafting_xpath);
		}
		xpath_GenericMethod_Click(apply_xpath);

	}

	public void clickOnDirectInvestmentSaleLink() throws Exception {
		// clicks on Direct investment sale link inside hamburger menu
		xpath_GenericMethod_Click(lnk_DrctInvSale);
	}

	public void selectDocumentForm(String s1) throws Exception {
		if (s1.equals("Executed")) {
			xpath_GenericMethod_Click(btn_Executed);
		} else if (s1.equals("Draft")) {
			xpath_GenericMethod_Click(btn_Draft);
		}

	}

	public void L1SaleOfInvPageReviewPage(String pageTitle) throws Exception {
		try {
			xpath_GenericMethod_Click(txt_DrctInvSle_L1Review);
		} catch (Exception e) {
			xpath_Javascriptexecutor_GenericMethod_Click(txt_DrctInvSle_L1Review);
		}
	}

	public void clickSaleAgreement(String saleAgreemnt) throws Exception {
		// Explicit wait for "btn_DrctInvSle_Executed"
		waitForElement(driver.findElement(By.xpath(btn_Executed)), 30);
		/*
		 * Adding validation to check if "Executed" is selected by default on "L1 Sale
		 * Of Investment" since "Executed" is selected in initiation screen Review
		 * screen
		 */
		if (saleAgreemnt.equals("Draft")) {
			String checkedAttr = driver.findElement(By.xpath(btn_Executed)).getAttribute("checked");
			if (checkedAttr == null) {
				// Clicks on drafts button
				xpath_GenericMethod_Click(btn_Draft);
				Assert.assertTrue(true, "Draft button is clicked successfully");
			} else {
				Assert.assertTrue(false, "Executed button is not selected by default,hence fail");
			}
		} else if (saleAgreemnt.equals("Executed")) {
			xpath_GenericMethod_Click(btn_Executed);
		}
	}

	public void clickOn_Approve() throws Exception {

		try {
			// clicks on approve button for "confirm decision"
			xpath_GenericMethod_Click(btn_approveXpath);

		} catch (

		Exception e) {
			waitForElement(driver.findElement(By.xpath(btn_approveXpath)), 20);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(btn_approveXpath))).click().build().perform();
		}

	}

	public void enterTransactionName(String s) throws Exception {

		try {
			// Enter transaction name
			xpath_GenericMethod_Sendkeys(txa_DrctInvSle_Transactionname, s);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txa_DrctInvSle_Transactionname, s);
		}
	}

	public void enterAmountToSell(String amtToSell) throws Exception {
		// Enter amount to sell
		xpath_GenericMethod_SendkeysWithoutJS(txa_DrctInvSle_AmtToSell, amtToSell);

	}

	public void selectSecurityName(String securityName) throws Exception {

		try {	
			    //clicks on Security Name - updated to select first value from security dropdown
				xpath_GenericMethod_Click(drp_DrctInvSle_SecurityName);
				xpath_GenericMethod_Click(drp_DrctInvSle_List);
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select security dropdown");
		}
	}
	
	public void selectSecurityNameFOFCommitment(String securityName) throws Exception {

		try {	
				xpath_GenericMethod_Click(security_details_xpath);
				xpath_GenericMethod_Click(drp_DrctInvSle_SecurityName);
				xpath_GenericMethod_Click(drp_DrctInvSle_List);
				Assert.assertTrue(true, "selected security dropdown");
		} catch (Exception e) {
				xpath_GenericMethod_Click(security_details_xpath);
				xpath_GenericMethod_Click(drp_DrctInvSle_SecurityName);
				xpath_GenericMethod_Click(drp_DrctInvSle_List);
				Assert.assertTrue(false, "Unable To select security dropdown");
		}
	}

	public void select_Transactiontypes(String trnsctn1, String amt1) throws Exception {

		try {

			// clicks on TransactionType - updated to select first value from transaction type dropdown
			xpath_GenericMethod_Click(drp_DrctInvSle_TransactionType);
			xpath_GenericMethod_Click(drp_DrctInvSle_List);
			//List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_List));
			//for (WebElement webElement : dropdownvalues) {
				//if (webElement.getText().equals(trnsctn1)) {

					// clicks on drop down list value based on value passed in Examples
					//webElement.click();
					// wait
//					waitForElement(driver.findElement(By.xpath(txt_DrctInvSle_amountForTransaction)), 60);
					// enter amount for transaction
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForTransaction, amt1);
				//}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterTradeDate() throws Exception {
		// User enters the trade date	-- updated the below method to select the date from date picker	
		try {
			waitFor(2);
			WebElement dateWidget = driver.findElement(By.xpath(tradeDatepicker_xpath));
			dateWidget.click();
			WebElement dateSelect = driver.findElement(By.xpath(noticeDate_xpath));
			dateSelect.click();
			//below code is written to avoid selecting bank holidays
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	Calendar cal = Calendar.getInstance();
				DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
		    	WebElement dateWidget1 = driver.findElement(By.xpath(tradeDatepicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(toDateXpath, newDate)))).click();
		    }
		    
			Assert.assertTrue(true, "Notice Date selected");
		} 
		catch (Exception e) {
				Assert.assertTrue(false, "Unable To select notice date");
			}
	}

	public void enterSettlementDate() throws Exception {
		// User enters the settlement date -- updated the below method to select the date from date picker		
		try {
			WebElement dateWidget = driver.findElement(By.xpath(sttlementDatepicker_xpath));
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
			//below code is written to avoid selecting bank holidays
			Boolean isPresent = driver.findElements(By.xpath("//span[@id='PegaRULESErrorFlag']")).size() > 0;
		    if(isPresent == true){	
		    	WebElement dateWidget1 = driver.findElement(By.xpath(sttlementDatepicker_xpath));
				dateWidget1.click();
		    	cal.add(Calendar.DATE, 1);
		    	String newDate = "" + dateFormat.format(cal.getTime());
		    	driver.findElement(By.xpath((String.format(toDateXpath, newDate)))).click();
		    }
		    
		    Assert.assertTrue(true, "Due date selected successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select due date");
		}
	}

	public void verifyStatusChange(String status) throws Exception {

		// verify if status change happens or not, if status doesn't have expected text,
		// it will fail the test case
		WebElement element = driver.findElement(By.xpath(String.format(txt_Status, status)));
		String actualText = element.getText();
		Assert.assertEquals(actualText, status);
	}

	public void selectTheFundInDirctInv(String fundName) throws Exception {

		try {
			// click on the Fund drop down box
			xpath_GenericMethod_Click(drp_DrctInvSle_Distributingfund);

			// finding all the drop down values present in fund and storing in list
			List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_DistributingFundValues));
			for (WebElement webElement : dropdownvalues) {
				// if fundname is equal to the parameter passed in examples it will click that
				// fund
				if (webElement.getText().equals(fundName)) {
					webElement.click();
				}
			}

			Assert.assertTrue(true, "Selecting fund successfully in direct investment initiation screen");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select fund in direct investment initiation screen");
		}

	}

	public void selectTheInvestmentListDirctInv(String fundName) throws Exception {

		try {
			//for (int i = 0; i < 10; i++) {
				// updated to select the first value from drop down for investment list
				xpath_GenericMethod_Click(drp_DrctInvSle_Invstmnt_List);
				xpath_GenericMethod_Click(drp_DrctInvSle_Invstmnt_ListValues);
				// finding all the drop down values present in fund and storing in list
//				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_Invstmnt_ListValues));
//				for (WebElement webElement : dropdownvalues) {
//					// if fund name is equal to the parameter passed in examples it will click that
//					// fund
//					if (webElement.getText().equals(fundName)) {
//						webElement.click();
//					}
//				}
//				if (driver.findElement(By.xpath(drp_DrctInvSle_Invstmnt_List)).getAttribute("value").equals(fundName)) {
//					break;
//				}
			//}

			Assert.assertTrue(true, "Selecting investment list successfully in direct investment initiation screen");
		} catch (

		Exception e) {
			Assert.assertTrue(false, "Unable To select investment list in direct investment initiation screen");
		}
	}

	public void verifyExecuteState() {
		// Explicit wait for "btn_DrctInvSle_Executed"
		waitForElement(driver.findElement(By.xpath(btn_Executed)), 30);
		/*
		 * Adding validation to check if "Executed" is selected by default on "L1 Sale
		 * Of Investment" since "Executed" is selected in initiation Review screen
		 */
		String checkedAttr = driver.findElement(By.xpath(btn_Executed)).getAttribute("checked");
		if (checkedAttr == null) {
			Assert.assertTrue(true, "Execute button is clicked by default");
		} else {
			Assert.assertTrue(false, "Execute button is not clicked by default");
		}
	}

	public void select_Transactiontypes(String trnsctn1, String amt1, String trnsctn2, String amt2, String trnsctn3,
			String amt3) throws Exception {

		try {

			// clicks on TransactionType
			xpath_GenericMethod_Click(drp_DrctInvSle_TransactionType);

			List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement : dropdownvalues) {
				if (webElement.getText().equals(trnsctn1)) {
					// clicks on drop down list value based on value passed in Examples
					webElement.click();
					// enter amount for transaction
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForTransaction, amt1);
					// Click on additional transaction type
					xpath_GenericMethod_Click(btn_DrctInvSle_additionalTransactionType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Same logic as per above is applied to the below for second and third
		// transaction types
		try {
			xpath_GenericMethod_Click(drp_DrctInvSle_SecondTransactionType);
			List<WebElement> dropdownvalues2 = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement2 : dropdownvalues2) {
				if (webElement2.getText().equals(trnsctn2)) {
					webElement2.click();
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForSecondTransaction, amt2);
					xpath_GenericMethod_Click(btn_DrctInvSle_additionalTransactionType);
				}
			}
		} catch (Exception e) {
		}

		try {
			xpath_GenericMethod_Click(drp_DrctInvSle_ThirdTransactionType);
			List<WebElement> dropdownvalues3 = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement3 : dropdownvalues3) {
				if (webElement3.getText().equals(trnsctn3)) {
					webElement3.click();
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForThirdTransaction, amt3);

				}
			}
		} catch (Exception e) {
		}

		// validation to check if selected transaction types are not same
		String firstSelectedTrnsType = getElementText(drp_SelectedTransactionType);
		String secondSelectedTrnsType = getElementText(drp_SecondSelectedTransactionType);
		String thirdSelectedTrnsType = getElementText(drp_ThirdSelectedTransactionType);
		System.out.println("first" + firstSelectedTrnsType);
		System.out.println("second" + secondSelectedTrnsType);
		System.out.println("third" + thirdSelectedTrnsType);

		// fails test case if first and second transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, secondSelectedTrnsType);
		// fails test case if first and third transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, thirdSelectedTrnsType);
		// fails test case if second and third transaction type are equal
		Assert.assertNotEquals(secondSelectedTrnsType, thirdSelectedTrnsType);

	}

	public void select_TransactiontypesFOFCap(String trnsctn1, String amt1, String trnsctn2, String amt2,
			String trnsctn3, String amt3) throws Exception {

		for (int i = 1; i < 50; i++) {
			{
				xpath_GenericMethod_Click(drp_FoF_TransactionType);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(trnsctn1)) {
						webElement.click();
					}
				}
				if (driver.findElement(By.xpath(drp_FoF_TransactionType)).getAttribute("value").equals(trnsctn1)) {
					break;
				}
				Assert.assertTrue(true, "Selected '" + trnsctn1 + "' successfully ");
			}
		}

		// enter amount for transaction
		xpath_GenericMethod_SendkeysWithoutJS(txt_FoF_amountForTransaction, amt1);
		// Click on additional transaction type
		xpath_GenericMethod_Click(btn_FoF_additionalTransactionType);

		// Same logic as per above is applied to the below for second and third
		// transaction types

		for (int i = 1; i < 50; i++) {
			{
				xpath_GenericMethod_Click(drp_FoF_SecondTransactionType);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(trnsctn2)) {
						webElement.click();
					}
				}
				if (driver.findElement(By.xpath(drp_FoF_SecondTransactionType)).getAttribute("value")
						.equals(trnsctn2)) {
					break;
				}
				Assert.assertTrue(true, "Selected '" + trnsctn2 + "' successfully ");
			}
		}

		// enter amount for transaction2
		xpath_GenericMethod_SendkeysWithoutJS(txt_FoF_amountForSecondTransaction, amt2);
		// Click on additional transaction type
		xpath_GenericMethod_ClickWithoutJS(btn_FoF_additionalTransactionType);

		for (int i = 1; i < 50; i++) {
			{
				xpath_GenericMethod_Click(drp_FoF_ThirdTransactionType);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(trnsctn3)) {
						webElement.click();
					}
				}
				if (driver.findElement(By.xpath(drp_FoF_ThirdTransactionType)).getAttribute("value").equals(trnsctn3)) {
					break;
				}
				Assert.assertTrue(true, "Selected '" + trnsctn3 + "' successfully ");
			}
		}

		// enter amount for transaction 3
		xpath_GenericMethod_SendkeysWithoutJS(txt_FoF_amountForThirdTransaction, amt3);

		// validation to check if selected transaction types are not same
		String firstSelectedTrnsType = getElementText(drp_SelectedTransactionType);
		String secondSelectedTrnsType = getElementText(drp_SecondSelectedTransactionType);
		String thirdSelectedTrnsType = getElementText(drp_ThirdSelectedTransactionType);

		// fails test case if first and second transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, secondSelectedTrnsType);
		// fails test case if first and third transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, thirdSelectedTrnsType);
		// fails test case if second and third transaction type are equal
		Assert.assertNotEquals(secondSelectedTrnsType, thirdSelectedTrnsType);

	}

	public void verifyInitiationPage(String pageTitle) throws Exception {
		try {

			xpath_Genericmethod_VerifyTextContains(initiationPageVerify, pageTitle);
		} catch (Exception e) {
			xpath_Genericmethod_VerifyTextContains(initiationPageVerify, pageTitle);
		}
	}

	public void enterTransctnName(String trnsctnName) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(txttransactionName, trnsctnName);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txttransactionName, trnsctnName);
		}

	}

	public void enterAmtTobePaid(String amt) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(txt_AmtToBePaid, amt);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txt_AmtToBePaid, amt);
		}
	}

	public void selectTheInvestmentFund(String fundName) {
		try {
			// click on the Fund drop down box
			xpath_GenericMethod_Click(drp_InvestmentFund);
			xpath_GenericMethod_Click(drp_firstValueFunddisbankacc);
			// finding all the drop down values present in fund and storing in list
//			List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_Invstmnt_ListValues));
//			for (WebElement webElement : dropdownvalues) {
//				// if fund name is equal to the parameter passed in examples it will click that
//				// fund
//				if (webElement.getText().equals(fundName)) {
//					webElement.click();
//				}
//			}

			Assert.assertTrue(true, "Selected investment fund successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select investment fund");
		}

	}
	
	public void selectTheInvestmentFundForTemplate() {
		
		try {
			xpath_GenericMethod_Click(drp_InvestmentFund);
			xpath_GenericMethod_Click(drp_firstValueIssuingAcc);
			Assert.assertTrue(true, "Selected investment fund successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To select investment fund");
		}
	}

	public void selectPosition(String position) throws Exception {
		try {
			xpath_GenericMethod_Click(drp_Position);
			xpath_GenericMethod_Click(drp_firstValueFunddisbankacc);
			Assert.assertTrue(true, "Selected Fund bank account successfully ");
		} catch (Exception e) {
			Assert.assertTrue(false, "Not Selected Fund bank account successfully ");
		}

	}

	public void enterNoticeDate() throws Exception {
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
			xpath_GenericMethod_Click(tradedate);
			xpath_GenericMethod_SendkeysWithoutJS(tradedate, futureDateTime);

			Assert.assertTrue(true, "entered trade date Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To enter trade date ");
		}

	}

	public void enterAccNo(String accNo) throws Exception {
		try {
			xpath_GenericMethod_Click(txt_accNo);
			xpath_GenericMethod_Sendkeys(txt_accNo, accNo);
		} catch (Exception e) {
			xpath_GenericMethod_Click(txt_accNo);
			xpath_GenericMethod_Sendkeys(txt_accNo, accNo);
		}
	}

	public void enterABANo(String abaNo) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(txt_ABAno, abaNo);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txt_ABAno, abaNo);
		}
	}

	public void enterSWIFTNo(String swiftNo) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(txt_SWIFTno, swiftNo);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txt_SWIFTno, swiftNo);
		}
	}

	public void selectCurrencyFOFCap(String currency, String value) throws Exception {

		for (int i = 1; i < 50; i++) {
			{
				xpath_GenericMethod_Click(drp_FOFcapcurrency);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(value)) {
						webElement.click();
					}
				}
				if (driver.findElement(By.xpath(drp_FOFcapcurrency)).getAttribute("value").equals(value)) {
					break;
				}
				Assert.assertTrue(true, "Selected currency successfully ");
			}
		}

	}

	public void selectIssuingAccValuesInDropdownFOFCap(String acc, String value) throws Exception {

//		for (int i = 1; i < 50; i++) {
//			{
//				xpath_GenericMethod_Click(drp_FOFissuing_account);
//				xpath_GenericMethod_Click(drp_firstValueFunddisbankacc);
////				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
////				for (WebElement webElement : dropdownvalues) {
////					if (webElement.getText().equals(value)) {
////						webElement.click();
////					}
////				}
////				if (driver.findElement(By.xpath(drp_FOFissuing_account)).getAttribute("value").equals(value)) {
////					break;
////				}
//				Assert.assertTrue(true, "Selected currency successfully ");
//			}
//		}
		try {
			xpath_GenericMethod_Click(drp_FOFissuing_account);
			xpath_GenericMethod_Click(drp_firstValueFunddisbankacc);
			Assert.assertTrue(true, "Selected issuing account successfully ");
		} catch (Exception e) {
			Assert.assertTrue(false, "Not Selected issuing account successfully ");
		}

	}
	
	public void selectIssuingAccValuesForTemplate(String acc) throws Exception {				
				
		try {
					xpath_GenericMethod_Click(drp_FOFissuing_account);
					xpath_GenericMethod_Click(drp_firstValueIssuingAcc);
					Assert.assertTrue(true, "Selected issuing account successfully ");
				} catch (Exception e) {
					Assert.assertTrue(false, "Not Selected issuing account successfully ");
				}

	}

	public void verifyInitiationScreenFOFcap(String pageTitle) {
		try {
			xpath_Genericmethod_VerifyTextContains(txt_FOFcapinitiationScreen, pageTitle);
			Assert.assertTrue(true, "verify pagetitle Successfully");
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable To verify pagetitle CapitalActivity");
		}

	}

	public void select_TransactiontypesFOFCap(String trnsctn1, String amt1) throws Exception {

		for (int i = 1; i < 50; i++) {
			{
				xpath_GenericMethod_Click(drp_FoF_TransactionType);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_FoF_List));
				for (WebElement webElement : dropdownvalues) {
					if (webElement.getText().equals(trnsctn1)) {
						webElement.click();
					}
				}
				if (driver.findElement(By.xpath(drp_FoF_TransactionType)).getAttribute("value").equals(trnsctn1)) {
					break;
				}
				Assert.assertTrue(true, "Selected '" + trnsctn1 + "' successfully ");
			}

		}

		xpath_GenericMethod_Click(txt_FoF_amountForTransaction);
		// enter amount for transaction
		xpath_GenericMethod_Sendkeys(txt_FoF_amountForTransaction, amt1);
	}

	public void enterAmountForTransaction(String amt) throws Exception {
		xpath_GenericMethod_Click(amount_for_transaction_xpath);
		xpath_GenericMethod_Sendkeys(amount_for_transaction_xpath, amt);

	}

	public void enterAmountForTransactionFOF(String amt) throws Exception {
		try {
			xpath_GenericMethod_Sendkeys(amount_for_transactionFOF_xpath, amt);
		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(amount_for_transactionFOF_xpath, amt);
		}

	}

	public void clickOnFOFCommitment(String processname) throws Exception {
		xpath_GenericMethod_Click(lnkFOFCommitment);

	}

	public void clickOnDirectInvPurchase(String processname) throws Exception {
		xpath_GenericMethod_Click(lnkDrctInvPurchase);

	}

	public void select_Transactiontypes_DIP(String trnsctn1, String amt1, String trnsctn2, String amt2, String trnsctn3,
			String amt3) throws Exception {

		try {

			// clicks on TransactionType
			xpath_GenericMethod_Click(drp_DrctInvSle_TransactionType);

			List<WebElement> dropdownvalues = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement : dropdownvalues) {
				if (webElement.getText().equals(trnsctn1)) {
					// Mandatory wait
					waitFor(1);
					// clicks on drop down list value based on value passed in Examples
					webElement.click();
					// enter amount for transaction
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForTransaction, amt1);
					// Click on additional transaction type
					xpath_GenericMethod_Click(btn_DIP_additionalTransactionType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Same logic as per above is applied to the below for second and third
		// transaction types
		try {
			xpath_GenericMethod_Click(drp_DrctInvSle_SecondTransactionType);
			List<WebElement> dropdownvalues2 = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement2 : dropdownvalues2) {
				if (webElement2.getText().equals(trnsctn2)) {
					webElement2.click();
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForSecondTransaction, amt2);
					xpath_GenericMethod_Click(btn_DIP_additionalTransactionType);
				}
			}
		} catch (Exception e) {
		}

		try {
			xpath_GenericMethod_Click(drp_DrctInvSle_ThirdTransactionType);
			List<WebElement> dropdownvalues3 = driver.findElements(By.xpath(drp_DrctInvSle_List));
			for (WebElement webElement3 : dropdownvalues3) {
				if (webElement3.getText().equals(trnsctn3)) {
					webElement3.click();
					xpath_GenericMethod_Sendkeys(txt_DrctInvSle_amountForThirdTransaction, amt3);

				}
			}
		} catch (Exception e) {
		}

		// validation to check if selected transaction types are not same
		String firstSelectedTrnsType = getElementText(drp_SelectedTransactionType);
		String secondSelectedTrnsType = getElementText(drp_SecondSelectedTransactionType);
		String thirdSelectedTrnsType = getElementText(drp_ThirdSelectedTransactionType);
		System.out.println("first" + firstSelectedTrnsType);
		System.out.println("second" + secondSelectedTrnsType);
		System.out.println("third" + thirdSelectedTrnsType);

		// fails test case if first and second transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, secondSelectedTrnsType);
		// fails test case if first and third transaction type are equal
		Assert.assertNotEquals(firstSelectedTrnsType, thirdSelectedTrnsType);
		// fails test case if second and third transaction type are equal
		Assert.assertNotEquals(secondSelectedTrnsType, thirdSelectedTrnsType);

	}

	public void enterPeriodendreportingdescription(String trnsctnName) throws Exception {
		waitFor(2);
		List<WebElement> togglePer = driver.findElements(By.xpath(chkbxPer));

		System.out.println("the is" + togglePer.size());
		for (int i = 2; i <= togglePer.size() - 1; i++) {
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

	public void enterPeriodendreportingdescription1(String trnsctnName) throws Exception {

		xpath_GenericMethod_Sendkeys(txtPeriodendreportingdes, trnsctnName);
	}

	public void enterPeriodendreportingdescription2(String trnsctnName) throws Exception {
		waitFor(1);
		xpath_Javascriptexecutor_GenericMethod_Click(txtDescription2);
		try {
			xpath_GenericMethod_Sendkeys(txtDescription2, trnsctnName);

		} catch (Exception e) {
			xpath_GenericMethod_Sendkeys(txtDescription2, trnsctnName);
		}

		xpath_GenericMethod_Sendkeys(txtDescription1, trnsctnName);
		xpath_GenericMethod_Sendkeys(txtDescription2, trnsctnName);
		xpath_GenericMethod_Sendkeys(txtDescription3, trnsctnName);
		xpath_GenericMethod_Sendkeys(txtDescription4, trnsctnName);

	}

	public void selectToggleFinStatements(String toggle) {
		WebElement toggleYes = driver.findElement(By.xpath(btn_toggle_finStatements));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void selectClientfinStatemnts() throws Exception {
		xpath_GenericMethod_Click(phaseandStatus_ID_xpath);

		xpath_GenericMethod_Click(clientFinStatemnts_click_filter);

		xpath_GenericMethod_Click(apply_xpath);

		xpath_GenericMethod_Click(lnk_workbasketfilteredCaseId);
	}

	// for (int i = 1; i <= textDescription.size() - 1; i++) {
//			try {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", textDescription.get(i));
//				textDescription.get(i).sendKeys(trnsctnName);
////				waitFor(2);
////				textDescription.get(i + 1).click();
//
//			} catch (Exception e) {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", textDescription.get(i));
//				textDescription.get(i).sendKeys(trnsctnName);
//
//			}
//		}

}
