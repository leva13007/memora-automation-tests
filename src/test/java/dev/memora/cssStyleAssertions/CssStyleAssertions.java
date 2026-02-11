package dev.memora.cssStyleAssertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Locator;

import dev.memora.css.CssColorParser;

public final class CssStyleAssertions {

    public static void fontFamily(String fontName, Locator locator) {
        String fontFamily = locator.evaluate(
                "node => getComputedStyle(node).fontFamily"
        ).toString();
        assertTrue(fontFamily.contains(fontName), "Font family should be Inter");
    }

    public static void fontSize(String fontSize, Locator locator) {
        String actualFontSize = locator.evaluate(
                "node => getComputedStyle(node).fontSize"
        ).toString();
        assertEquals(fontSize, actualFontSize, "Descktop H1 font-size should be " + fontSize);
    }

    public static void fontWeight(String fontWeight, Locator locator) {
        String actualFontWeight = locator.evaluate(
                "node => getComputedStyle(node).fontWeight"
        ).toString();
        assertEquals(fontWeight, actualFontWeight, "Descktop H1 font-weight should be " + fontWeight);
    }

    public static void lineHeight(String lineHeight, Locator locator) {
        String actualLineHeight = locator.evaluate(
                "node => getComputedStyle(node).lineHeight"
        ).toString();
        assertEquals(lineHeight, actualLineHeight, "Descktop H1 line-height should be '" + lineHeight + "'");
    }

    public static void color(String textColor, Locator locator) {
        String actualColor = locator.evaluate(
                "node => getComputedStyle(node).color"
        ).toString();
        String hexColor = CssColorParser.parse(actualColor).toHex();
        assertEquals(textColor, hexColor, "Descktop H1 color should be '" + textColor + "'");
    }
    
    public static void cssVar(String designToken, String styleName, Locator locator) {
        String className = locator.getAttribute("class");

            String fontSizeCSSVar = locator.evaluate(String.format("""
                () => {
                    try {
                        for (const sheet of document.styleSheets) {
                            for (const r of sheet.rules){
                                if (r.selectorText?.includes("%s")){
                                    return r.style?.["%s"];
                                }
                            }
                        }
                    } catch (e) {
                        return "";
                    }
                    return "";
                }
            """, className, styleName)
            ).toString();
            assertTrue(fontSizeCSSVar.contains(designToken), "Design token should be: '"+ designToken + "' but got " + fontSizeCSSVar);
    }
}
