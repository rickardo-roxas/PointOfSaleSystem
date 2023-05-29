/**
 * @author Johan Rickardo Roxas
 * Blueprint for the Item object.
 */
public class Item {
    /**
     * Barcode of object.
     */
    private int productID;

    /**
     * Name of item (e.g., Starbucks House Blend)
     */
    private String name;

    /**
     * Quantity of item being bought.
     */
    private int quantity;

    /**
     * Price of per item sold.
     */
    private double unitPrice;

    /**
     * Constructs an object of Item with default values.
     */
    public Item() {
        productID = 1;
        name = "Caramel Machiatto";
        quantity = 2;
        unitPrice = 210;
    } // end of Item default constructor

    /**
     * Constructs an object of Item with user-defined values/
     * @param productID given product ID
     * @param name given product name
     * @param quantity given quantity
     * @param unitPrice given unitPrice
     */
    public Item(int productID, String name, int quantity, double unitPrice) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    } // end of Item constructor

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    } // end of getQuantity accessor method

    public double getUnitPrice() {
        return unitPrice;
    }
} // end of class Item
