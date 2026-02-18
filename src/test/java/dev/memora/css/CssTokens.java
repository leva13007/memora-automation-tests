package dev.memora.css;

public enum CssTokens {
  FONT_SIZE_H1("--font-size-h-1", "fontSize"),
  FONT_WEIGHT_BOLD("--font-weight-bold", "fontWeight"),
  COLOR_TEXT("--color-text", "color");

  private final String value;
  private final String cssProperty;
  CssTokens(String value, String cssProperty){
    this.value = value;
    this.cssProperty = cssProperty;
  }

  public String value(){
    return this.value;
  }

  public String cssProperty(){
    return this.cssProperty;
  }
}