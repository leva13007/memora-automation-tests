package dev.memora.config;

public enum Theme {
  LIGHT("light"),
  DARK("dark");

  private String desc;

  private Theme(String description){
    this.desc = description;
  }

  public String getDescription() {
        return desc;
    }
}