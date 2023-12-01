package steps;

import com.microsoft.playwright.Tracing;
import config.global.GlobalConfig;
import config.playwright.context.ActiveContext;
import config.playwright.context.UserBrowserContextInitializer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {
    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        UserBrowserContextInitializer.initializeBrowserContextOne();
        UserBrowserContextInitializer.initializeBrowserContextOnePageOne();
        System.out.println(scenario.getName() + " is started");
    }

    /**
     * Will invoke after every scenario
     * @param scenario method
     */
    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName() + " is failed");
            scenario.attach(ActiveContext.getActivePage().screenshot(), "image/png", scenario.getName());
            if (GlobalConfig.SET_TRACING) {
                ActiveContext.getActiveBrowserContext().tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get("target/trace/" + scenario.getName().replace(" ", "-").toLowerCase() + "-trace.zip")));
            }
            System.out.println("Failed URL is: " + ActiveContext.getActivePage().url());
        } else {
            if (GlobalConfig.SET_TRACING) {
                ActiveContext.getActiveBrowserContext().tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get("target/trace/" + scenario.getName().replace(" ", "-").toLowerCase() + "-trace.zip")));
            }
        }
        System.out.println(scenario.getName() + " is finished");
    }
}
