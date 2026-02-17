package dev.memora.config;

// enum Theme {
//   LIGHT("light"),
//   DARK("dark");

//   private String desc;

//   private Theme(String description){
//     this.desc = description;
//   }

//   public String getDescription() {
//         return desc;
//     }
// }

public final class TestEnvironment {

  public static final String BASE_URL() {
    return "https://leva13007.github.io/memora-cards-storybook/";
  }

  public static final int DESKTOP_WIDTH_MIN = 1280;

  public static final int DESKTOP_WIDTH_MAX = 1400;

  public static final int DESKTOP_HEIGHT = 480;

  public static final String THEME_DARK = Theme.DARK.getDescription();

  public static final String THEME_LIGHT = Theme.LIGHT.getDescription();

  private TestEnvironment() {}
}