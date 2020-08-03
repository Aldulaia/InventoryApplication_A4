package aldulaia;

public class Inventory {

    private String id = "ABC-1234";
    private String name = "New Item";
    private int qoh = 0;
    private int rop = 25;
    private double sellPrice = 0;

    /**
     * Default constructor sets the ID, name, quantity on hand , re-order point,
     * and sell price to default values
     */
    public Inventory() {
    }

    /**
     * This constructs an item with a specified ID, Name, and Sell price.
     *
     * @param id The ID of the item
     * @param name The name of the item
     * @param sellPrice The item's sell price
     */
    // The first constructor
    public Inventory(String id, String name, double sellPrice) {
        setId(id);
        setName(name);
        setSellPrice(sellPrice);
    }

    /**
     * This constructs an item with a specified ID, Name, , Sell price, quantity
     * on hand, and re-order points.
     *
     * @param id The ID of the item
     * @param name The name of the item
     * @param qoh the quantity of the item
     * @param rop the re-order points of the item
     * @param sellprice the sell price of the item
     */
    // the second constructor
    public Inventory(String id, String name, int qoh, int rop, double sellprice) {
        setId(id);
        setName(name);
        setQoh(qoh);
        setRop(rop);
        setSellPrice(sellPrice);
    }

    /**
     * This method retrieve the current ID of this item.
     *
     * @return the item's ID (Identity)
     */
    // accessors and mutators
    public String getId() {
        id = id.toUpperCase();
        return id;
    }

    /**
     * This method sets the item's ID.
     *
     * @param id To apply and set the item's ID
     */
    public void setId(String id) { // the array has been used to indicate is the entry is unvalid (used as a
        // reference point).
        int letter = 0;
        int digit = 0;

        if (id.length() == 8) {
            for (int i = 0; i < 3; i++) {
                if (Character.isLetter(id.charAt(i)) == true) {
                    letter++;
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (Character.isDigit((id.charAt(i))) == true) {
                    digit++;
                }
            }

            if (letter == 3 && digit == 4 && id.charAt(3) == '-') {
                this.id = id;
            } else {
                throw new IllegalArgumentException("Error: Inventory ID must be in the form ABC-1234 ");
            }

        } else {
            throw new IllegalArgumentException("Error: Inventory ID must be in the form ABC-1234 ");
        }
    }

    /**
     * This method retrieve the current name of the item.
     *
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the item's name.
     *
     * @param name to apply and set the item's name
     */
    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            name = name.trim();
            this.name = name;
        } else {
            throw new IllegalArgumentException("Error, Invalid Input. Must Enter a name");
        }
    }

    /**
     * This method retrieve the current quantity of the item.
     *
     * @return The available quantity of the item
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * This method sets the available quantity of the item.
     *
     * @param qoh to apply and set the available quantity of the item
     */
    public void setQoh(int qoh) {
        if (qoh >= 0) {
            this.qoh = qoh;
        } else {
            throw new IllegalArgumentException("Error, Value must 0 or above");
        }
    }

    /**
     * This method retrieve the current re-order points of the item.
     *
     * @return the re-order points of the item
     */
    public int getRop() {
        return rop;
    }

    /**
     * This method sets the re-order points of the item.
     *
     * @param rop to apply and set the re-order points of the item
     */
    public void setRop(int rop) {
        if (rop > 0) {
            this.rop = rop;
        } else {
            throw new IllegalArgumentException(" Error: value must be greater than 0. ");
        }
    }

    /**
     * This method retrieve the selling price of the item.
     *
     * @return the selling price of the item
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * This method sets the selling price of the item
     *
     * @param price to apply and set the sell price of the item
     */
    public void setSellPrice(double price) {
        if (price > 0) {
            this.sellPrice = price;
        } else {
            throw new IllegalArgumentException("Error: value must be greater than 0. ");
        }
    }

    /**
     * This method retrieve the item's info as a string, text.
     */
    public String toString() {
        return String.format("%s ( %s ), QOH: %d , Price: $%.2f", id, name, qoh, sellPrice);
    }
}


