package dev.memora.domAssertion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microsoft.playwright.Locator;

public final class DomAssertion {

    public static void tagName(String tagName, Locator locator) {
        String actualTagName = locator.evaluate(
                "node => node.tagName.toLowerCase();"
        ).toString();
        assertEquals(tagName, actualTagName, "Expected tag is <" + tagName + "> but was <" + actualTagName + ">");
    }
}
