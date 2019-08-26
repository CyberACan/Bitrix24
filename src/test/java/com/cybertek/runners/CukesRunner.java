package com.cybertek.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports", //generates every time we run the cukes runner
				"json:target/cucumber.json",
				"junit:target/cucumber.xml"
		},
		
//		tags="@date",
		features= {"src/test/resources/features/activitystream.feature"
		},
		glue= {"com/cybertek/step_definitions"
		}
//		,dryRun = true
)
public class CukesRunner {

}
