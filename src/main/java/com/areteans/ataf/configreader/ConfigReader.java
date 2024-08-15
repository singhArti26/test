package com.areteans.ataf.configreader;

import com.areteans.ataf.configuration.browser.BrowserType;

public interface ConfigReader {
	public String getUserName();

	public String getPassword();

	public String getFundServicesURL();

	public String getCorproURL();

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public BrowserType getBrowser();

	public String getRun();

	public String browserZoom();

}
