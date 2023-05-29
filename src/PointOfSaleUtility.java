import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Johan Rickardo Roxas
 * @version 1.00 2023/05/29
 */
public class PointOfSaleUtility {
    /**
     * List of items being sold
     */
    private List<Item> inventoryItems = new ArrayList<>();

    /**
     * Adds items to the receipt
     * @param givenItem purchased item
     * @return list of purchased items
     */
    public List<Item> scanItems(Item givenItem) {
        List<Item> purchasedItems = new ArrayList<>();
        purchasedItems.add(givenItem);
        return purchasedItems;
    } // end of addItems method

    /**
     * Computes for the change to be given.
     * @param amountToPay total price of purchased items
     * @param amountPaid amount given by the customer
     * @return change due
     * @throws Exception if error occurs or amountPaid is less than amountToPay
     */
    public double computeChange(double amountToPay, double amountPaid) throws Exception {
        double change = amountPaid - amountToPay;
        if (change < 0) {
            throw new Exception();
        } else
            return change;
    } // end of computeChange method

    /**
     * Computes for discount of amount to be paid.
     * @param amountToPay amount to be paid by the customer
     * @param discount percentage of discount
     * @return new amount to be paid
     * @throws Exception if error occurs during computation
     */
    public double computeDiscount(double amountToPay, double discount) throws Exception {
        double discountedPrice = amountToPay - (amountToPay * discount);
        if (discountedPrice > amountToPay) {
            throw new Exception();
        } else
            return discountedPrice;
    } // end of computeDiscount method

    /**
     * Computes for the total price of all items purchased.
     * @param itemsPurchased List of items purchased by the customer.
     * @return amount to be paid
     * @throws Exception if error occurs
     */
    public double computeTotalPrice(List<Item> itemsPurchased) throws Exception {
        double totalPrice = 0.0;
        for (Item item : itemsPurchased) {
            totalPrice = totalPrice + item.getTotalPrice();
        } // end of for
        return totalPrice;
    } // end of computeTotalPrice method

    /**
     * Populates List of items being sold
     * @throws Exception if error or exception occurs during file reading.
     */
    private void populateInventory() throws Exception {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("inventory/items.csv"));
            String line = "";

            while ((line = inputStream.readLine()) != null) {
                String[] itemMetadata = line.split(",");
                int id = Integer.parseInt(itemMetadata[0]);
                String name = itemMetadata[1];
                double unitPrice = Double.parseDouble(itemMetadata[2]);
                inventoryItems.add(new Item(id, name, unitPrice));
            } // end of while
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error reading file. Restart the program.");
        } // end of try-catch
    } // end of searchItem method

    public Item searchItem(int id, String name) {
        for (Item item : inventoryItems) {
            if (inventoryItems.contains(id || name))
        }
    } // end of searchItem method
} // end of class PointOfSaleUtility
