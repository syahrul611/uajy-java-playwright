package runners;

import com.microsoft.playwright.Playwright;
import com.trivago.cluecumber.core.CluecumberCore;
import com.trivago.cluecumber.engine.exceptions.CluecumberException;
import com.trivago.cluecumber.engine.logging.CluecumberLogger;
import config.global.GlobalConfig;
import config.playwright.browser.BrowserInitialize;
import config.playwright.browser.BrowserOptions;
import config.playwright.playwrightsource.PlaywrightSourceManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

public class BaseTestRunner extends AbstractTestNGCucumberTests {
    private String browserName;
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Playwright Project Run Is Starting");
    }

    @Parameters({"browserName"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName) {
        BrowserInitialize browserInitialize = new BrowserInitialize();
        this.browserName = browserName.isBlank() || browserName.isEmpty() ? GlobalConfig.BROWSER_NAME : browserName;
        PlaywrightSourceManager.setLocalPlaywright(Playwright.create());
        PlaywrightSourceManager.setLocalBrowser(browserInitialize.getBrowser(this.browserName, BrowserOptions.launchOptions()));
        System.out.println("Playwright is using " + this.browserName + " browser");
    }

    @Parameters({"squadName"})
    @AfterTest(alwaysRun = true)
    public void afterTest(String squadName) throws CluecumberException {
        String jsonDirectory = "target/result/" + squadName;
        String reportDirectory = "target/result/" + squadName + "/cluecumber_report";
        PlaywrightSourceManager.getLocalBrowser().close();
        PlaywrightSourceManager.getLocalPlaywright().close();
        new CluecumberCore.Builder()
                .setCustomCssFile("src/test/resources/cluecumber-style/cluecumberStyle.css")
                .setLogLevel(CluecumberLogger.CluecumberLogLevel.MINIMAL)
                .setCustomPageTitle(squadName + "Report")
                .setExpandAttachments(true)
                .build().generateReports(jsonDirectory, reportDirectory);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Playwright Project Run Is Finished");
    }
}
