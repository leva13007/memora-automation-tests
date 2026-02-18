package dev.memora.css;

public enum CssGeneral {
    FONT_FAMILY_PRIMIRY("Inter"),
    FONT_WEIGHT_BOLD("700"),
    FONT_LINE_HEIGHT("normal");

    private final String value;
    CssGeneral(String value) {
      this.value = value;
    }

    public String value(){
      return this.value;
    }
}
