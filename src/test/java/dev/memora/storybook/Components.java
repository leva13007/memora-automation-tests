package dev.memora.storybook;

public enum Components {

    H1("&id=ui-atoms-h1--default&viewMode=story");

    private String description;

    private Components(String description) {
        this.description = description;
    }

    public String getDescription() {
      System.out.println("");
        return description;
    }
}
