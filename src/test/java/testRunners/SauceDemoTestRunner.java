package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.plugin.Plugin;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/features",
		glue = {"stepDefinitions","AppHooks"},
		plugin = {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "timeline:test-output-thread/"
				
				},
		monochrome = true
		)
public class SauceDemoTestRunner {

}
