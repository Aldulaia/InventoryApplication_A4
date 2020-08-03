package aldulaia;

public enum Fields {

    ITEM_ID(" Item ID"),
    ITEM_NAME(" Item Name"),
    QOH(" Qty. On Hand"),
    ROH(" Re-Order Point"),
    PRICE(" Unit Price");

    private String caption;

    private Fields(String cap) {

        this.caption = cap;
    }

    public String getCaption() {
        return caption;
    }
}
