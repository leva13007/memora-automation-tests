package dev.memora.css;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CssColorParser {

    private CssColorParser() {
    }

    public static CssColor parse(String cssColor) { // cssColor = "rgb(1, 98, 177)"
        Pattern pattern = Pattern.compile("\\d{1,3}");
        Matcher matcher = pattern.matcher(cssColor);

        int[] values = new int[3];
        int i = 0;
        while (matcher.find() && i < 3) {
            values[i] = Integer.parseInt(matcher.group());
            i++;
        }
        // TODO add some validations and checks!
        return new CssColor(values[0], values[1], values[2]);
    }
}
