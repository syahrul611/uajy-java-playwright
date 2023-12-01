package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class UserBrowserContext {
    @Setter @Getter
    private static BrowserContext browserContextOne;
    @Setter @Getter
    private static Page contextOneActivePage;
}
