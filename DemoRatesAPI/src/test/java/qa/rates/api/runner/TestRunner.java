package qa.rates.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"classpath:features"},
		glue = "qa.rates.api.steps",
		monochrome=true,
		plugin =
			{
					"pretty",
					"json:target/cucumber.json",
					"html:target/cucumber"
					//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extentReport"
			},	
		dryRun=false		
		)
public class TestRunner {

}
