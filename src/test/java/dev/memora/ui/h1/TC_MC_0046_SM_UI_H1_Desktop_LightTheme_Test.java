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
import dev.memora.domAssertion.DomAssertion;
import dev.memora.storybook.ComponentAtoms;
import dev.memora.storybook.StorybookPage;

public class TC_MC_0046_SM_UI_H1_Desktop_LightTheme_Test {

    ComponentAtoms component = ComponentAtoms.H1;
    Theme theme = Theme.LIGHT;

    @Tag("smoke")
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
        }
    }
}
