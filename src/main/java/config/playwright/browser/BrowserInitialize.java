package config.playwright.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import config.playwright.playwrightsource.PlaywrightSourceManager;

public class BrowserInitialize {
    /**
     * Get browser from playwright
     * @param browserName   broser name supported by playwright
     * @param launchOptions browser launch options
     * @return Browser playwright
     */
    public Browser getBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {
        BrowserType browserType = null;

        switch (browserName.toLowerCase()) {
            case "chrome":
                browserType = PlaywrightSourceManager.getLocalPlaywright().chromium();
                break;
            case "firefox":
                browserType = PlaywrightSourceManager.getLocalPlaywright().firefox();
                break;
            case "webkit":
                browserType = PlaywrightSourceManager.getLocalPlaywright().webkit();
                break;
            default:
                throw new RuntimeException("Unsupported playwright browser: " + browserName + " use these name instead chrome, firefox, webkit");
        }
        assert browserType != null;
        return browserType.launch(launchOptions);
    }
}
