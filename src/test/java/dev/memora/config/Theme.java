package dev.memora.config;

public enum Theme {
    LIGHT("light"),
    DARK("dark");

    private final String value;
    private Theme(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
