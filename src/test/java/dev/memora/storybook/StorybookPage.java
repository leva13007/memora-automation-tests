package dev.memora.storybook;

import dev.memora.config.TestEnvironment;
import dev.memora.config.Theme;

public final class StorybookPage {

    private static String iframe = "iframe.html?globals=";
    // String element = "&id=ui-atoms-h1--default&viewMode=story";
    // String themeAttr = "&globals=theme:" + TestEnvironment.THEME_LIGHT();
    // String args = "&args=data-testid:" + dataTestId;

    private static String getDataTestId(String dataTestId) {
        return dataTestId != null ? "&args=data-testid:" + dataTestId : "";
    }

    public static String getURL(Components component, Theme theme, String dataTestId) {
        // Components component = Components.valueOf(key.toUpperCase());
        // Theme t = Theme.valueOf(theme.toUpperCase());
        return TestEnvironment.BASE_URL() + StorybookPage.iframe + component.getDescription() + "&globals=theme:" + theme.getDescription() + StorybookPage.getDataTestId(dataTestId);
    }

    private StorybookPage() {
    }
}
