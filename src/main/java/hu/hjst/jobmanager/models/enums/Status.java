package hu.hjst.jobmanager.models.enums;

public enum Status {
    IN_PROGRESS("Folyamatban"),
    INVOICE_ABLE("Számlázható"),
    INVOICED("Számlázva"),
    CLOSED("Lezárva");

    private final String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Status fromString(String text) {
        Status s;
        try {
            s = Status.valueOf(text);
            return s;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid Status!");
        }
    }

}
