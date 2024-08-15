
package com.areteans.ataf.runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = {"classpath:@target/failed_scenarios.txt",
				
		}, 
		glue = {
				"classpath:com.areteans.ataf.stepDef",
				"classpath:com.areteans.ataf.PageObjects",
				"classpath:com.areteans.ataf.TestBase",
				"classpath:com.areteans.ataf.helper",
		}, 

		plugin = {"html:target/cucumber-html-report",
				"json:target/cucumber-report/cucumber.json",
				"pretty:target/cucumber-pretty.txt",
				"junit:target/cucumber-results.xml",
				"rerun:target/failed_scenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	
		},

		monochrome = true,

		dryRun = false



		)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	

}



