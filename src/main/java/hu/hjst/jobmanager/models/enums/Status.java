package hu.hjst.jobmanager.models.enums;

public enum Status {
    IN_PROGRESS("Folyamatban"),
    INVOICE_ABLE("Számlázható"),
    INVOICED("Számlázva"),
    CLOSED("Lezárva");

    private String text;

    Status (String text){
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Status fromString(String text) {
        for (Status s : Status.values()) {
            if (s.text.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }

}
