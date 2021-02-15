package Runner;


import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "./src/test/resources/Features" ,
					glue= {"stepD"},
	plugin = { "pretty", "json:target/cucumber/cucumber.json" },
	 monochrome = true
	 )
	public class runCuke {
	
	}
