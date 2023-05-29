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
     * Total price of the item.
     */
    private double totalPrice;

    /**
     * Constructs an object of Item with default values.
     */
    public Item() {
        productID = 1;
        name = "Caramel Machiatto";
        quantity = 2;
        unitPrice = 210;
        totalPrice = quantity * unitPrice;
    } // end of Item default constructor

    /**
     * Constructs an object of Item with user-defined values
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
        this.totalPrice = quantity * unitPrice;
    } // end of Item constructor

    /**
     * Constructs an object of Item with user-defined product ID, name, and unit price only.
     * @param productID given product ID
     * @param name given name
     * @param unitPrice given unit price
     */
    public Item(int productID, String name, double unitPrice) {

    } // end of Item constructor

    /**
     * Mutates state of productID with user-given value
     * @param productID given product ID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    } // end of setProductID mutator method

    /**
     * Mutates state of name with user-given value
     * @param name given name
     */
    public void setName(String name) {
        this.name = name;
    } // end of setName mutator method

    /**
     * Mutates state of quantity with user-given value
     * @param quantity given quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // end of setQuantity mutator method

    /**
     * Mutates state of unit price with user-given value
     * @param unitPrice given unit price
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    } // end of setUnitPrice mutator method

    /**
     * Mutates state of total price with user-given value
     * @param totalPrice given total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    } // end of setTotalPrice mutator method

    /**
     * Accesses the state of product ID
     * @return state/value of productID
     */
    public int getProductID() {
        return productID;
    } // end of getProductID accessor method

    /**
     * Accesses the state of name
     * @return state/value of name
     */
    public String getName() {
        return name;
    } // end of getName accessor method

    /**
     * Accesses the state of quantity
     * @return state/value of quantity
     */
    public int getQuantity() {
        return quantity;
    } // end of getQuantity accessor method

    /**
     * Accesses the state of unit price
     * @return state/value of unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    } // end of getUnitPrice accessor method

    /**
     * Accesses the state of total price
     * @return state/value of total price
     */
    public double getTotalPrice() {
        return totalPrice;
    } // end of getTotalPrice accessor method

    /**
     * Concatenates the attributes of object Item
     * @return comma-separated values of the attribute states.
     */
    @Override
    public String toString() {
        return productID + "," +
                name + "," +
                quantity + "," +
                unitPrice;
    } // end of toString method
} // end of class Item
