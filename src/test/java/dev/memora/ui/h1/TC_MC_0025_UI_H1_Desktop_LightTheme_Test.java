package dev.memora.ui.h1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import dev.memora.config.TestEnvironment;
import dev.memora.config.Theme;
import dev.memora.cssStyleAssertions.CssStyleAssertions;
import dev.memora.domAssertion.DomAssertion;
import dev.memora.storybook.Components;
import dev.memora.storybook.StorybookPage;

public class TC_MC_0025_UI_H1_Desktop_LightTheme_Test {

    Components component = Components.H1;
    Theme theme = Theme.LIGHT;
    String device = "Desktop";
    
    String dataTestId = "test_h1";

    String textColor = "#0f172a";
    String fontFamily = "Inter";
    String fontSize = "32px";
    String fontWeight = "700";
    String lineHeight = "normal";

    String fontSizeDesignToken = "--font-size-h-1";
    String fontWeightDesignToken = "--font-weight-bold";
    String fontColorDesignToken = "--color-text";

    @Tag("regression")
    @Test
    public void ExecutionTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.setViewportSize(TestEnvironment.DESKTOP_WIDTH_MIN, TestEnvironment.DESKTOP_HEIGHT);

            // Step #1
            page.navigate(StorybookPage.getURL(component, theme, dataTestId));

            // Step #2
            Locator h1 = page.getByTestId(dataTestId);

            // Step #3
            assertThat(h1).isVisible();

            String tagName = component.name().toLowerCase();
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


// TODO craete and move consts to the config Classes!