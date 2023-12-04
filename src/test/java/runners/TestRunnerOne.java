package runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"json:target/result/uajy/cucumber-report.json", "html:target/result/uajy/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@login"
)
public class TestRunnerOne extends BaseTestRunner{
}
