
package com.areteans.ataf.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = { "classpath:QA/featurefiles-CapitalCall", "classpath:QA/featurefiles_FOF_Distribution",
				"classpath:QA/featurefiles-DirectInvestmentSale", "classpath:QA/featureFiles-ExpensePayment",
				"classpath:QA/featurefiles_FOF_CapitalCall", "classpath:QA/featurefiles-Transfer",
				"classpath:QA/featurefiles-FOF-Commitment", "classpath:QA/featurefiles-PeriodEndReporting",
				"classpath:QA/featureFiles-DirectInvestmentPurchase", "classpath:QA/featurefiles-Distribution",
				
				"classpath:AutoInstance/featurefiles-CapitalCall", "classpath:AutoInstance/featurefiles_FOF_Distribution",
				"classpath:AutoInstance/featurefiles-DirectInvestmentSale", "classpath:AutoInstance/featureFiles-ExpensePayment",
				"classpath:AutoInstance/featurefiles_FOF_CapitalCall", "classpath:AutoInstance/featurefiles-Transfer",
				"classpath:AutoInstance/featurefiles-FOF-Commitment", "classpath:AutoInstance/featurefiles-PeriodEndReporting",
				"classpath:AutoInstance/featureFiles-DirectInvestmentPurchase", "classpath:AutoInstance/featurefiles-Distribution",

		}, glue = { "classpath:com.areteans.ataf.stepDef", "classpath:com.areteans.ataf.PageObjects",
				"classpath:com.areteans.ataf.TestBase", "classpath:com.areteans.ataf.helper", },

		plugin = { "html:target/cucumber-html-report", "json:target/cucumber-report/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml",
				"rerun:target/failed_scenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", },

		monochrome = true,

		dryRun = false

)
public class CommonRunner extends AbstractTestNGCucumberTests {

}
