package com.areteans.ataf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.areteans.ataf.CS.CustomerServ;
import com.cucumber.framework.pageconstants.PreparationCOISL1PageLoc;

public class PreparationCOISL1Page extends CustomerServ implements PreparationCOISL1PageLoc {

	PreparationCOISL1Page preparation_COIS_L1_page;

	public PreparationCOISL1Page(WebDriver driver) {
		super(driver);
	}

	public void sendLogoutObject(PreparationCOISL1Page preparationCOISL1page) {
		this.preparation_COIS_L1_page = preparation_COIS_L1_page;
	}

	public void click_On_workbasket_COIS_L1(String workbasket) throws Exception {

		xpath_GenericMethod_Click(workbasket_COISL1_xpath);

	}

	public void verifyInitiationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(investor_registry_confirmation_xpath, pageTitle);

	}

	public void verifyL1KYCScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(pageTitle_xpath, pageTitle);

	}

	public void verifyInvestorRegistryConfirmationScreen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(investor_registry_confirmation_pagetitle, pageTitle);

	}

	public void verify_KYC_Investor_Registry_Pagetitle(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(kyc_investor_registry_pagetitle_xpath, pageTitle);

	}

	public void verify_Initiation_Screen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(KYC_pagetitle_xpath, pageTitle);

	}

	public void verify_KYC_ComfortLetter_Screen(String pageTitle) throws Exception {

		xpath_Genericmethod_VerifyTextContains(KYC_comfortletter_xpath, pageTitle);

	}

	public void clickOn_KYC_toggleYes() throws Exception {

		try {
			// Mandatory wait
			waitFor(3);
			WebElement toggleYes = driver.findElement(By.xpath(kyc_clear_toggle_xpath));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", toggleYes);
		} catch (Exception e) {
			Actions a = new Actions(driver);
			a.click(driver.findElement(By.xpath(kyc_clear_toggle_xpath))).build().perform();
		}

	}

	public void clickOn_investor_registry_toggleYes() throws Exception {
		WebElement toggleYes = driver.findElement(By.xpath(investor_registry_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void clickOn_comfortletter_toggleYes() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(KYC_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void click_On_comfortletter_toggleYes() throws Exception {

		WebElement toggleYes = driver.findElement(By.xpath(comfortletter_toggle_xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", toggleYes);

	}

	public void upload_Documents() throws Exception {

		xpath_GenericMethod_scrollIntoView(upload_documents_xpath);

		xpath_GenericMethod_Click(upload_documents_xpath);

		String path = System.getProperty("user.dir");
		String systemScreenshot = path + "\\attachments\\document1.pdf";
		driver.findElement(By.xpath(select_file_xpath)).sendKeys(systemScreenshot);
		// 3);
		// xpath_GenericMethod_Click(submit_documents_xpath);

		xpath_GenericMethod_scrollIntoView(document_category_xpath);

	}

}
