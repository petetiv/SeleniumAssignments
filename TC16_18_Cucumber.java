package com.qa.TestScripts;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\kovvuria\\Documents\\Selenium\\com.qa.selenium.Batch1.Assignments\\src\\test\\java\\com\\qa\\Features\\OrangeHRM.Feature",
		glue="project.StepDefinition",
		dryRun=false, // dryRun should be false to open the chrome
		strict=true, //strict shoould be true to open the chrome
		monochrome=true,
		format= {"pretty", "html:test-output"},
		tags= {"@SmokeTest"}
		)

public class TC16_18_Cucumber {

}
