package dev.memora.ui.h1;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import dev.memora.cssStyleAssertions.CssStyleAssertions;
import dev.memora.domAssertion.DomAssertion;

public class TC_MC_0030_UI_H1_Mobile_DarkTheme_Test {

    String dataTestId = "test_h1";
    String theme = "dark";
    String tagName = "h1";

    String hostURL = "https://leva13007.github.io/memora-cards-storybook/";
    String iframe = "iframe.html?globals=";
    String element = "&id=ui-atoms-h1--default&viewMode=story";
    String themeAttr = "&globals=theme:" + theme;
    String args = "&args=data-testid:" + dataTestId;
    int width = 375;
    int height = 480;
    String textColor = "#f5f7fb";

    String fontFamily = "Inter";
    String fontSize = "24px";
    String fontWeight = "700";
    String lineHeight = "normal";

    String fontSizeDesignToken = "--font-size-h-1";
    String fontWeightDesignToken = "--font-weight-bold";
    String fontColorDesignToken = "--color-text";

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

            CssStyleAssertions.fontFamily(fontFamily, h1);
            CssStyleAssertions.fontSize(fontSize, h1);
            CssStyleAssertions.fontWeight(fontWeight, h1);
            CssStyleAssertions.lineHeight(lineHeight, h1);
            CssStyleAssertions.color(textColor, h1);
            CssStyleAssertions.cssVar(fontSizeDesignToken, "fontSize", h1);
            CssStyleAssertions.cssVar(fontWeightDesignToken, "fontWeight", h1);
            CssStyleAssertions.cssVar(fontColorDesignToken, "color", h1);


            // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            // TODO wehere and how to store the screenshots? Pass/Fail + date
            // @Tag()
        }
    }
}
