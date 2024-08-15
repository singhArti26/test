package com.areteans.ataf.GeneralHelperSel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.areteans.ataf.configreader.ObjectRepo;

public class SeleniumFunNonPega {

	// private static final Function ExpectedCondtions = null;
	private static Logger log = LogManager.getLogger(SeleniumFunNonPega.class);
	Marker markerContent = MarkerManager.getMarker("FLOW");

	protected static WebDriver driver;

	public static String rootdir = System.getProperty("user.dir");
	// public static WebDriver driver;

	@SuppressWarnings("static-access")
	public SeleniumFunNonPega(WebDriver driver) {
		this.driver = driver;
	}

	SeleniumFunNonPega seleniumFunNonPega;

	public void sendSeleniumFunNonPegaObject(SeleniumFunNonPega seleniumFunNonPega) {
		this.seleniumFunNonPega = seleniumFunNonPega;

	}

	public void testSel() {
		System.out.println("In testSel of SeleniumFunc" + driver);
	}

	public static String ElementKey(String elementkey) throws IOException {

		String keyvalue = null;
		try {
			FileInputStream file = new FileInputStream(rootdir + "\\Common.properties");
			Properties prop = new Properties();
			prop.load(file);
			keyvalue = prop.getProperty(elementkey);
		}

		catch (Exception ex) {
			ex.printStackTrace();

		}
		return keyvalue;
	}

	public static String staticData(String dataKey) throws IOException {

		String datavalue = null;
		try {
			FileInputStream file = new FileInputStream(rootdir + "\\StaticDetailsforValidation.properties");
			Properties prop = new Properties();
			prop.load(file);
			datavalue = prop.getProperty(dataKey);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return datavalue;
	}

	public static WebElement element(String elementkey) throws IOException {

		WebElement element = null;
		String keyvalue = ElementKey(elementkey);
		String arg[] = keyvalue.split(">");
		String identifiedby = arg[0];
		String ElementValue = arg[1];

		switch (identifiedby) {
		case "id":
			element = driver.findElement(By.id(ElementValue));
			break;
		case "name":
			element = driver.findElement(By.name(ElementValue));
			break;

		case "classname":
			element = driver.findElement(By.className(ElementValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(ElementValue));
			break;
		case "cssselector":
			element = driver.findElement(By.cssSelector(ElementValue));
			break;

		case "linktext":
			element = driver.findElement(By.linkText(ElementValue));
			break;
		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(ElementValue));
			break;
		case "tagname":
			element = driver.findElement(By.tagName(ElementValue));
			break;

		default:
			System.out.println("Element is not identified");
		}
		return element;

	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * WebDriver interface Methods:
	 * 
	 * 
	 * #############################################################################
	 * 
	 */

	public String pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		log.info("get the pageTitle:" + title);

		return title;
	}

	public String pageSource() {
		String sourceinfo = driver.getPageSource();
		System.out.println(sourceinfo);
		log.info("get the pageSource:" + sourceinfo);
		return sourceinfo;
	}

	public void waitpageLoad() {

		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ObjectRepo.reader.getPageLoadTimeOut()));
	}

	public String currentURL() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		log.info("get the currentURL:" + url);
		return url;
	}

	public void closeBrowser() {

		driver.close();
		log.info("Browser is closed");
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Browser navigation concept
	 * 
	 * 
	 * #############################################################################
	 * 
	 */

	public void navigateToURL(String url) {
		System.out.println(url);
		driver.navigate().to(url);

	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {

		driver.navigate().forward();
	}

	public void pageRefresh() {

		driver.navigate().refresh();
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * WebElement interface Methods:
	 * 
	 * 
	 * #############################################################################
	 * 
	 */

	public void elementClick(String elementkey) throws Exception {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			ele.click();
			log.info("the user clicks on Element:" + ele);

		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not identified" + ele);
			String keyvalue = SeleniumFunc.elementValue(elementkey);
			SeleniumFunc.xpath_GenericMethod_Click(keyvalue);
		}

//      JavascriptExecutor jse = (JavascriptExecutor) driver;
//      jse.executeScript("document.body.style.zoom = '100%';");

	}

	public void elementSubmit(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			ele.submit();
			log.info("the user performs submit request on Element:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not identified" + ele);

		}

	}

	public void inputTextBox(String elementkey, String valuetopass) throws Exception {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			ele.sendKeys(valuetopass);
			log.info("the user enters value in textbox or textarea:" + ele);
		}

		catch (Exception ex) {

			// String keyvalue=SeleniumFunc.elementValue(elementkey);
			// SeleniumFunc.xpath_GenericMethod_Sendkeys(keyvalue, valuetopass);
			ex.printStackTrace();
			log.info("Element is not identified" + ele);
		}
	}

	public void clearinputTextBoxData(String elementkey) throws Exception {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			ele.clear();
			log.info("the user removes the existing data in textbox or textarea:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not identified" + ele);
			String keyvalue = SeleniumFunc.elementValue(elementkey);
			SeleniumFunc.xpath_GenericMethod_Clear(keyvalue);
		}
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Below Methods return some output Data:
	 * 
	 * 
	 * #############################################################################
	 */

	public String getAttributeValue(String elementkey, String attributevalue) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		String attributeValue1 = null;
		try {
			attributeValue1 = ele.getAttribute(attributevalue);
			System.out.println(attributeValue1);
			log.info("the user gets the inputdata from attribute:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not identified" + ele);
		}
		return attributeValue1;
	}

	public String getTextData(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		String gettext = null;

		try {
			gettext = ele.getText();
			System.out.println(gettext);
			log.info("the user gets text data from filed:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not identified" + ele);
		}
		return gettext;
	}

	public Boolean isElementDisplayed(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		Boolean value = null;

		try {
			value = ele.isDisplayed();
			System.out.println(value);
			log.info("the user verifies whether element ispresent:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not present:" + ele);
		}
		return value;
	}

	public Boolean isElementEnabled(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		Boolean value = null;
		try {
			value = ele.isEnabled();
			System.out.println(value);
			log.info("the user verifies whether element isenabled:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not enabled:" + ele);
		}

		return value;
	}

	public Boolean isElementSelected(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		Boolean value = null;

		try {
			value = ele.isSelected();
			System.out.println(value);
			log.info("the user verifies whether element isSelected:" + ele);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("Element is not Selected:" + ele);
		}

		return value;
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Select class methods
	 * 
	 * 
	 * #############################################################################
	 */

	public void pickByVisbleText(String elementkey, String text) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		Select select = new Select(ele);
		List<WebElement> list = select.getOptions();
		int count = list.size();

		try {
			for (int i = 0; i < count; i++) {
				String value = list.get(i).getText();
				if (value.equalsIgnoreCase(text)) {
					select.selectByVisibleText(text);
					log.info("the user selects the dropdown value ByVisibleText:" + ele);

				}
			}

			WebElement ele1 = select.getFirstSelectedOption();
			String value = ele1.getText();
			System.out.println(value);

		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("the dropdown value not selected ByVisibleText:" + ele);
		}

	}

	public void pickByValue(String elementkey, String attributevalue) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		Select select = new Select(ele);
		List<WebElement> list = select.getOptions();
		int count = list.size();

		try {
			for (int i = 0; i < count; i++) {
				String value = list.get(i).getText();
				if (value.equalsIgnoreCase(attributevalue)) {
					select.selectByValue(attributevalue);
					log.info("the user selects the dropdown value ByValue:" + ele);
				}
			}

			WebElement ele1 = select.getFirstSelectedOption();
			String value = ele1.getText();
			System.out.println(value);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("the dropdown value not selected ByValue:" + ele);
		}

	}

	public void pickByIndex(String elementkey, String index) throws IOException {

		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		Select select = new Select(ele);
		List<WebElement> list = select.getOptions();
		int count = list.size();
		int indexvalue = Integer.parseInt(index);

		try {
			for (int i = 0; i < count; i++) {
				select.selectByIndex(indexvalue);
				log.info("the user selects the dropdown value ByIndex:" + ele);

			}
			WebElement ele1 = select.getFirstSelectedOption();
			String value = ele1.getText();
			System.out.println(value);
		}

		catch (Exception ex) {
			ex.printStackTrace();
			log.info("the dropdown value not selected ByIndex:" + ele);
		}
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Alert concept
	 * 
	 * 
	 * #############################################################################
	 */

	Alert alert;

	public void alertAccept() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			alert.accept();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void alertDismiss() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			alert.dismiss();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void sendValueToAlert(String value) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			alert.sendKeys(value);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String getTextFromAlert() {

		String value = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			value = alert.getText();
			System.out.println(value);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * frame concept
	 * 
	 * 
	 * #############################################################################
	 */

	public void switchFrameByIndex(String index) {

		int value = Integer.parseInt(index);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(value));
			// driver.switchTo().frame(value);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchFrameByIdORName(String nameorid) throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameorid));
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		// driver.switchTo().frame(nameorid);

	}

	public void switchFrameByElement(String elementkey) throws IOException {

		WebElement ele = element(elementkey);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		// driver.switchTo().frame(ele);

	}

	public void switchToParentFrame() {

		try {
			driver.switchTo().parentFrame();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void exitFromeFrame() {

		try {
			driver.switchTo().defaultContent();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Explicit wait concept
	 * 
	 * 
	 * #############################################################################
	 */

	public void explicitWait(String elementkey) throws IOException {

		WebElement ele = element(elementkey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Multiple window concept
	 * 
	 * 
	 * #############################################################################
	 */

	public void switchToWindowByIndex(String value) {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(windowHandles);
		int index = Integer.parseInt(value);
		try {
			driver.switchTo().window(al.get(index - 1));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void switchToWindowByURL(String url) {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of Windows/Browsers:" + windowHandles.size());
		try {
			for (String windowID : windowHandles) {
				if (driver.switchTo().window(windowID).getCurrentUrl().equals(url)) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToWindowByTitle(String title) {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of Windows/Browsers:" + windowHandles.size());

		try {
			for (String windowID : windowHandles) {
				if (driver.switchTo().window(windowID).getTitle().equals(title)) {
					break;
				}
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * WebTable concept
	 * 
	 * 
	 * #############################################################################
	 */

	public void handleWebTable(String elementkey, String optionvalue) throws Exception {

		String keyvalue = ElementKey(elementkey);
		List<WebElement> ele = driver.findElements(By.xpath(keyvalue));
		int count = ele.size();
		for (int i = 0; i < count; i++) {
			String value = ele.get(i).getText();
			if (value.equalsIgnoreCase(optionvalue)) {

				Assert.assertEquals(value, optionvalue, "Both the values are equal");
				driver.findElement(By.xpath(keyvalue + "[" + (i + 1) + "]")).click();

			}
		}

	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Actions class concept
	 * 
	 * 
	 * #############################################################################
	 */

	Actions action;

	public void performLeftClick(String elementkey) throws IOException {
		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		try {
			action.click(ele).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void performRightClick(String elementkey) throws IOException {

		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		try {
			action.contextClick(ele).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void performDoubleClick(String elementkey) throws IOException {

		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			action.doubleClick(ele).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void performMoveToElement(String elementkey) throws IOException {

		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			action.moveToElement(ele).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void performDragandDrop(String elementkey, String elementkey1) throws IOException {
		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		WebElement ele1 = element(elementkey1);
		try {
			action.dragAndDrop(ele, ele1).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void performClickAndHold(String elementkey) throws IOException {
		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);

		try {
			action.clickAndHold(ele).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void performinputTextBox(String elementkey, String dataValue) throws IOException {
		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		try {

			action.sendKeys(ele, dataValue).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void performKeyActions(String elementkey, Keys dataValue) throws IOException {
		action = new Actions(driver);
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		try {

			action.sendKeys(ele, dataValue).build().perform();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * #############################################################################
	 * 
	 * 
	 * 
	 * Assertions
	 * 
	 * 
	 * #############################################################################
	 */

	SoftAssert softassertion;

	public void verifyPageTitle(String actualTitle) throws IOException {

		String actualPageTitle = staticData(actualTitle);

		try {
			String title = driver.getTitle();
			System.out.println(title);
			softassertion.assertEquals(actualPageTitle, title);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifyCurrentURL(String actualURL) throws IOException {

		String actualPageURL = staticData(actualURL);
		try {
			String url = driver.getCurrentUrl();
			System.out.println(url);
			softassertion.assertEquals(actualPageURL, url);
		}

		catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void verifygetTextDataFromAlert(String actualData) throws IOException {

		String actualverificationtext = staticData(actualData);

		try {
			String expectedtxt = alert.getText();
			System.out.println(expectedtxt);
			softassertion.assertEquals(actualverificationtext, expectedtxt);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifyAttributeValue(String elementkey, String attributevalue, String actualvalue) throws IOException {
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		String attributeValue = staticData(attributevalue);
		String actualTextvalue = staticData(actualvalue);
		try {
			String attributeTextValue = ele.getAttribute(attributeValue);
			System.out.println(attributeTextValue);
			softassertion.assertEquals(actualTextvalue, attributeTextValue);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifygetText(String elementkey, String actualvalue) throws IOException {
		softassertion = new SoftAssert();
		WebElement ele = element(elementkey);
		explicitWait(elementkey);
		String actualDataValue = staticData(actualvalue);
		System.out.println(actualDataValue);
		try {
			String gettext = ele.getText();
			System.out.println(gettext);
			Reporter.log("Before Assertion: Actual Text is: " + actualDataValue + " Expected Text is: " + gettext);
			softassertion.assertEquals(actualDataValue, gettext);
			Reporter.log("After Assertion: Actual Text is: " + actualDataValue + " Expected Text is: " + gettext);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifyElementisDisplayed(String elementkey) throws IOException {
		Boolean value = isElementDisplayed(elementkey);
		try {
			if (value == true) {
				System.out.println("isDisplayed");
				softassertion.assertTrue(true);
			} else if (value == false) {
				System.out.println("is Not Displayed");
				// Assert.assertTrue(false);
			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifyElementisEnabled(String elementkey) throws IOException {

		Boolean value = isElementEnabled(elementkey);

		try {
			if (value == true) {
				System.out.println("isEnabled");
				softassertion.assertTrue(true);
			} else if (value == false) {
				System.out.println("is Not Enabled");
				// Assert.assertTrue(false);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void verifyElementisSelected(String elementkey) throws IOException {
		Boolean value = isElementSelected(elementkey);

		try {
			if (value == true) {
				System.out.println("isSelected");
				softassertion.assertTrue(true);
			} else if (value == false) {
				System.out.println("is Not Selected");
				// Assert.assertTrue(false);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void endOfAssert() {
		softassertion = new SoftAssert();
		softassertion.assertAll();
		System.out.println("Validating all the verifications");
		/*
		 * try {
		 * 
		 * System.out.println("Validating all the verifications"); }
		 * 
		 * catch (Exception ex) { ex.printStackTrace(); }
		 */

	}

	/*
	 * #############################################################################
	 * ######################
	 * 
	 * Robot
	 * 
	 * #############################################################################
	 * ######################
	 */

	public void key_Enter() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void key_ArrowDown() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

}
