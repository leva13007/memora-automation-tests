package dev.memora.ui.h1;

import com.microsoft.playwright.Locator;
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

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import dev.memora.core.BaseUITest;

public class H1_Tests extends BaseUITest {

    private void runTest(ComponentAtoms component, Theme theme, Viewport viewport) {
        page.setViewportSize(viewport.width(), viewport.height());

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

    @Tag("smoke")
    @Tag("regression")
    @Test
    public void TC_MC_0025_UI_H1_Desktop_LightTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.LIGHT;
        Viewport viewport = Viewport.DESKTOP;

        runTest(component, theme, viewport);
    }

    @Tag("regression")
    @Test
    public void TC_MC_0026_UI_H1_Desktop_DarkTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.DARK;
        Viewport viewport = Viewport.DESKTOP;

        runTest(component, theme, viewport);
    }

    @Tag("regression")
    @Test
    public void TC_MC_0027_UI_H1_Tablet_LightTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.LIGHT;
        Viewport viewport = Viewport.TABLET;

        runTest(component, theme, viewport);
    }

    @Tag("regression")
    @Test
    public void TC_MC_0028_UI_H1_Tablet_DarkTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.DARK;
        Viewport viewport = Viewport.TABLET;

        runTest(component, theme, viewport);
    }

    @Tag("regression")
    @Test
    public void TC_MC_0029_UI_H1_Mobile_LightTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.LIGHT;
        Viewport viewport = Viewport.MOBILE;

        runTest(component, theme, viewport);
    }

    @Tag("regression")
    @Test
    public void TC_MC_0030_UI_H1_Mobile_DarkTheme_Test() {
        ComponentAtoms component = ComponentAtoms.H1;
        Theme theme = Theme.DARK;
        Viewport viewport = Viewport.MOBILE;

        runTest(component, theme, viewport);
    }
}
