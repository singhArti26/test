
package com.areteans.ataf.configuration.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.areteans.ataf.utility.ResourceHelper;

public class FirefoxBrowser {

	public FirefoxOptions getFirefoxCapabilities() {
		FirefoxOptions firefox = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
//		firefox.setCapability("marionette", true);
		firefox.setProfile(profile);
		return firefox;
	}

	public WebDriver getFirefoxDriver(FirefoxOptions cap) {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver"));
			// WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
//			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver.exe"));
			// WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(cap);
		}
		return null;
	}

}
