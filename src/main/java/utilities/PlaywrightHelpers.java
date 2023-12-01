package utilities;

import com.microsoft.playwright.Page;

public class PlaywrightHelpers {
    private Page page;
    public PlaywrightHelpers(Page page) {
        this.page = page;
    }

    /**
     * This method navigates to a specified URL
     * default timeout
     */
    public void navigateTo(String url) {
        page.navigate(url);
    }
}
