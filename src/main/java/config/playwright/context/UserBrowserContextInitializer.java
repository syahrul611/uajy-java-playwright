package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.global.GlobalConfig;
import config.playwright.browser.BrowserOptions;
import config.playwright.playwrightsource.PlaywrightSourceManager;

import java.util.List;

public class UserBrowserContextInitializer {
    private static final List<String> GRANT_PERMISSIONS = List.of("geolocation");

    /**
     * Initialize browser context number one
     */
    public static void initializeBrowserContextOne() {
        UserBrowserContext.setBrowserContextOne(PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions()));
    }

    /**
     * Initialize browser context number one page
     */
    public static void initializeBrowserContextOnePageOne() {
        BrowserContext browserContext1 = UserBrowserContext.getBrowserContextOne();
        UserBrowserContext.getBrowserContextOne().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));

        browserContext1.grantPermissions(GRANT_PERMISSIONS);
        browserContext1.setDefaultNavigationTimeout(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        browserContext1.setDefaultTimeout(GlobalConfig.DEFAULT_TIMEOUT);

        UserBrowserContext.setContextOneActivePage(UserBrowserContext.getBrowserContextOne().newPage());
        ActiveContext.setActiveBrowserContext(UserBrowserContext.getBrowserContextOne());
        ActiveContext.setActivePage(UserBrowserContext.getContextOneActivePage());
    }
}
