package dev.memora.config;

public enum Viewport {
  DESKTOP(1280, 800),
  TABLET(768, 1024),
  MOBILE(375, 812);

  final int width;
  final int height;
  Viewport(int width, int height){
    this.width = width;
    this.height = height;
  }

  public int width(){
    return this.width;
  }

  public int height() {
    return this.height;
  }
}
