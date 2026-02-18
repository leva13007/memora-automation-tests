package dev.memora.ui.h1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import dev.memora.config.Theme;
import dev.memora.config.Viewport;
import dev.memora.css.CssGeneral;
import dev.memora.css.CssThemeValues;
import dev.memora.css.CssTokens;
import dev.memora.css.CssViewportValues;
import dev.memora.cssStyleAssertions.CssStyleAssertions;
import dev.memora.domAssertion.DomAssertion;
import dev.memora.storybook.ComponentAtoms;
import dev.memora.storybook.StorybookPage;

public class TC_MC_0028_UI_H1_Tablet_DarkTheme_Test {

    ComponentAtoms component = ComponentAtoms.H1;
    Theme theme = Theme.DARK;
    Viewport viewport = Viewport.TABLET;

    @Tag("regression")
    @Test
    public void ExecutionTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.setViewportSize(Viewport.DESKTOP.width(), Viewport.DESKTOP.height());

            // Step #1
            page.navigate(StorybookPage.getURL(component, theme));

            // Step #2
            Locator locator = page.getByTestId(component.dataTestId());

            // Step #3
            assertThat(locator).isVisible();

            DomAssertion.tagName(component.tag(), locator);

            CssStyleAssertions.fontFamily(CssGeneral.FONT_FAMILY_PRIMIRY.value(), locator);
            CssStyleAssertions.fontSize(CssViewportValues.FONT_SIZE_H1.valuePX(viewport), locator);
            CssStyleAssertions.fontWeight(CssGeneral.FONT_WEIGHT_BOLD.value(), locator);
            CssStyleAssertions.lineHeight(CssGeneral.FONT_LINE_HEIGHT.value(), locator);
            CssStyleAssertions.color(CssThemeValues.COLOR_TEXT.value(theme), locator);
            CssStyleAssertions.ComponentHasCssToken(CssTokens.FONT_SIZE_H1, locator);
            CssStyleAssertions.ComponentHasCssToken(CssTokens.FONT_WEIGHT_BOLD, locator);
            CssStyleAssertions.ComponentHasCssToken(CssTokens.COLOR_TEXT, locator);
        }
    }
}
