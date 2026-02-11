package dev.memora.css;

public final class CssColor {
  private final int r;
  private final int g;
  private final int b;

  public CssColor(int r, int g, int b){
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public String toHex() {
    return String.format("#%02x%02x%02x", r, g, b);
  }
}