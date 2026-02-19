package dev.memora.storybook;

import dev.memora.config.Theme;

public final class StorybookPage {

    private static String BASE_URL = "https://leva13007.github.io/memora-cards-storybook/";
    private static String IFRAME = "iframe.html?";

    private static String getDataTestId(String dataTestId) {
        return dataTestId != null ? "&args=data-testid:" + dataTestId : "";
    }

    public static String getURL(ComponentAtoms component, Theme theme) {
        return StorybookPage.BASE_URL
        + StorybookPage.IFRAME
        + "&viewMode=story"
        + "&id=" + component.storybookId()
        + "&globals=theme:" + theme.value()
        + StorybookPage.getDataTestId(component.dataTestId());
    }

    private StorybookPage() {
    }
}
