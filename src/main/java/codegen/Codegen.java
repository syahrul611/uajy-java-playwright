package codegen;

import com.microsoft.playwright.*;

public class Codegen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            // Make sure to run headed.
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setDevtools(true));
            // Setup context however you like.
            BrowserContext context = browser.newContext(/* pass any options */);
            // Pause the page, and start recording manually.
            Page page = context.newPage();
            page.navigate("https://mamikos.com");
            page.pause();
        }
    }
}
