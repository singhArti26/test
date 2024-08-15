
package com.areteans.ataf.configuration.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser {

	public WebDriver getEdgeDriver() {

		return new EdgeDriver();
	}

}
