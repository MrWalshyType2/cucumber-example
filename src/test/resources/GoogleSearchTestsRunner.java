import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/com/example/cuke" }, glue = {"com/example/cuke"})
public class GoogleSearchTestsRunner {
	// src/test/java/com/example/cuke <- for cucumber tests
}
