package dev.memora.css;

import dev.memora.config.Viewport;

public enum CssViewportValues{
  FONT_SIZE_H1(2, 1.75, 1.5);

  final double desktop;
  final double tablet;
  final double mobile;
  CssViewportValues(double desktop, double tablet, double mobile){
    this.desktop = desktop;
    this.tablet = tablet;
    this.mobile = mobile;
  }

  public String valuePX(Viewport viewport) {
    switch (viewport) {
        case DESKTOP -> {
            return ((int) (this.desktop * 16)) + "px";
          }
        case TABLET -> {
            return ((int) (this.tablet * 16)) + "px";
          }
        case MOBILE -> {
            return ((int) (this.mobile * 16)) + "px";
          }
        default -> throw new AssertionError("Wrong viewport value");
    }
  }
}