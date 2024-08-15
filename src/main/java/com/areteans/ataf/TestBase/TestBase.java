package com.areteans.ataf.TestBase;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.areteans.ataf.configreader.ObjectRepo;
import com.areteans.ataf.configreader.PropertyFileReader;
import com.areteans.ataf.configuration.browser.BrowserType;
import com.areteans.ataf.configuration.browser.ChromeBrowser;
import com.areteans.ataf.configuration.browser.EdgeBrowser;
import com.areteans.ataf.configuration.browser.FirefoxBrowser;
//import com.areteans.ataf.configuration.browser.FirefoxBrowser;
//import com.areteans.ataf.configuration.browser.HtmlUnitBrowser;
//import com.areteans.ataf.configuration.browser.IExploreBrowser;
import com.areteans.ataf.helper.Logger.LoggerHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class TestBase {

	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	//below statement is for created an individual thread for each web driver instance
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	private WebDriver driver = null;
	public static String scenarioname = StringUtils.EMPTY;
	public static String caseID = StringUtils.EMPTY;
	public static Object abbyJobID;
	public static String policyNumber;
	public static String taskkey;
	public static String classification;

	public WebDriver getBrowserObject(BrowserType bType) throws Exception {

		try {

			log.info(bType);

			switch (bType) {

			case Chrome:
				//below line creates a new instance of Chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.getDeclaredConstructor().newInstance();
				//this will create instance of Chrome driver with specified capabilities
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.getDeclaredConstructor().newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());
			case Edge:
				EdgeBrowser edge = EdgeBrowser.class.getDeclaredConstructor().newInstance();
				return edge.getEdgeDriver();

			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}

		} catch (Exception e) {

			throw e;
		}

	}

	public void setUpDriver(BrowserType bType) throws Exception {

		System.out.println("Driver Before instantiation is: " + driver);
		driver = getBrowserObject(bType);
		setWebDriver(driver);
		System.out.println("Driver After instantiation is: " + driver);
		log.debug("InitializeWebDrive : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Before
	public void before() throws Exception {

		ObjectRepo.reader = new PropertyFileReader();

		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			System.out.println(ObjectRepo.reader.getRun());
			String browser1 = System.getProperty("Browser");
			setUpDriver(BrowserType.valueOf(browser1));
		} else {
			System.out.println(ObjectRepo.reader.getRun());
			setUpDriver(ObjectRepo.reader.getBrowser());
			log.info(ObjectRepo.reader.getBrowser());
		}
	}

	@AfterStep
	public void after(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "screenshot");

		}

	}

	@After
	public void quitApp() {
		driver.quit();
//		driver.quit();
	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	@BeforeStep
	public static void beforeStep(Scenario scenario) {
		scenarioname = scenario.getName();
	}

//	@AfterStep
//	public void afterStep(Scenario scenario) {
////		 scenario.embed(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES),
////		 "image/png");
//
//	}

}
