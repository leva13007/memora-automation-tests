package dev.memora.storybook;

public enum ComponentAtoms {

    H1("h1", "ui-atoms-h1--default", "test_h1");

    private final String tag;
    private final String storybookId;
    private final String dataTestId;

    private ComponentAtoms(String tag, String storybookId, String dataTestId) {
        this.tag = tag;
        this.storybookId = storybookId;
        this.dataTestId = dataTestId;
    }

    public String tag() {
        return this.tag;
    }

    public String storybookId() {
        return this.storybookId;
    }

    public String dataTestId() {
        return this.dataTestId;
    }
}
