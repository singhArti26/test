
package com.areteans.ataf.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

	public Capabilities getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();

		option.addArguments("start-maximized");
		option.addArguments("--headless");
		option.addArguments("--disable-gpu");
		option.addArguments("--window-size=1920,1080");
		option.addArguments("--allow-insecure-localhost");
		option.addArguments("--disable-extensions");
		option.setExperimentalOption("useAutomationExtension", false);
		option.addArguments("--proxy-server='direct://'");
		option.addArguments("--proxy-bypass-list=*");
		option.addArguments("disable-blink-features=AutomationControlled");
		// DesiredCapabilities chrome = DesiredCapabilities.chrome();
//		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, option);

		return option;
	}

	public WebDriver getChromeDriver(Capabilities cap) {
		if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			// WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if (System.getProperty("os.name").contains("Mac")) {
			// System.setProperty("webdriver.chrome.driver",
			// ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
			// WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
		return null;
	}

}
