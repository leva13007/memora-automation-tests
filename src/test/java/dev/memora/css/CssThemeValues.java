package dev.memora.css;

import dev.memora.config.Theme;

public enum CssThemeValues{
  COLOR_TEXT("#0f172a", "#e5e7eb");

  final String light;
  final String dark;
  CssThemeValues(String light, String dark){
    this.light = light;
    this.dark = dark;
  }

  public String light(){
    return this.light;
  }

  public String dark(){
    return this.dark;
  }

  public String value(Theme theme){
    return theme == Theme.DARK ? this.dark : this.light;
  }
}