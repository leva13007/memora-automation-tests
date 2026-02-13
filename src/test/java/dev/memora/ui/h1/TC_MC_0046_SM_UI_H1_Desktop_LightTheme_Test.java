package dev.memora.ui.h1;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import dev.memora.domAssertion.DomAssertion;

public class TC_MC_0046_SM_UI_H1_Desktop_LightTheme_Test {

    String dataTestId = "test_h1";
    String theme = "light";
     String tagName = "h1";

    String hostURL = "https://leva13007.github.io/memora-cards-storybook/";
    String iframe = "iframe.html?globals=";
    String element = "&id=ui-atoms-h1--default&viewMode=story";
    String themeAttr = "&globals=theme:" + theme;
    String args = "&args=data-testid:" + dataTestId;
    int width = 1280;
    int height = 480;

    @Test
    public void ExecutionTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.setViewportSize(width, height);

            // Step #1
            page.navigate(hostURL + iframe + element + themeAttr + args);

            // Step #2
            Locator h1 = page.getByTestId(dataTestId);

            // Step #3
            assertThat(h1).isVisible();

            DomAssertion.tagName(tagName, h1);

            // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            // TODO wehere and how to store the screenshots? Pass/Fail + date
            // @Tag()
        }
    }
}
