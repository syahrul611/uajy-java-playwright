package utilities;

import com.microsoft.playwright.Locator;
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

    /**
     * Clicks on the element identified by the given Locator.
     * @param locator The Locator object identifying the element to be clicked.
     */
    public void clickOn(Locator locator) {
        locator.click();
    }

    /**
     * Fills the input field identified by the given Locator with the specified text.
     * @param locator The Locator object identifying the input field.
     * @param text    The text to be entered into the input field.
     */
    public void fillInput(Locator locator, String text) {
        locator.fill(text);
    }

    /**
     * Retrieves the text content of the element identified by the given Locator.
     * @param locator The Locator object identifying the element to retrieve text from.
     * @return The text content of the identified element.
     */
    public String getText(Locator locator) {
        return locator.innerText();
    }
}
