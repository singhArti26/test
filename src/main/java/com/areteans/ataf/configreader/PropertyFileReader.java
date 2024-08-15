
package com.areteans.ataf.configreader;

import java.util.Properties;

import com.areteans.ataf.configuration.browser.BrowserType;
import com.areteans.ataf.utility.ResourceHelper;

public class PropertyFileReader implements ConfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {

			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getFundServicesURL() {
		return prop.getProperty("FundServicesURL");
	}

	public String getCorproURL() {
		return prop.getProperty("CorproURL");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DataBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public String getRun() {
		return prop.getProperty("Run");
	}

	public String browserZoom() {
		return prop.getProperty("BrowserZoom");
	}

}
