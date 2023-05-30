import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Johan Rickardo Roxas
 * @version 1.00 2023/05/29
 */
public class PointOfSaleUtility {

    /**
     * Template for date.
     * YEAR/MONTH/DATE HH:MM:SS (e.g., 2023/05/22 00:00:00)
     */
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


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

    /**
     * Searches specified item in the list of items in the inventory
     * Uses the linear search algorithm.
     * @param id given keyword
     * @param name given keyword
     * @return specified Item
     */
    public Item searchItem(int id, String name) throws Exception {
        Item indexedItem = null;
        for (Item item : inventoryItems) {
            if (item.getName().equalsIgnoreCase(name) || item.getProductID() == id) {
                indexedItem = new Item(item.getProductID(), item.getName(), 1, item.getUnitPrice());
            } else
                throw new Exception();
        } // end of for
        return indexedItem;
    } // end of searchItem method

    /**
     * Prints receipt
     * @param purchasedItems List of purchased Items
     * @param customerName name of customer
     */
    public void printReceipt(List<Item> purchasedItems, String customerName,
                             double totalPrice, double tenderedAmount, double change, double discount) throws IOException {
        try {
            LocalDateTime now = LocalDateTime.now(); // Date of application use
            BufferedWriter outputStream = new BufferedWriter(
                    new PrintWriter("purchased-items/" + dateFormat.format(now)));


            outputStream.write("========================================================\n");
            outputStream.write("                          Receipt                       \n");
            outputStream.write("========================================================\n");

            int counter = 1;
            for (Item item : purchasedItems) {
                outputStream.write(String.format
                        ("%-5d %-10d %-3d %-10.2f %n" , counter, item.getProductID(), item.getQuantity() , item.getUnitPrice()));
                outputStream.write(String.format
                        ("%-5s %-10s %-3s %-10.2f %n %n" , " ", item.getName(), " " , item.getTotalPrice()));
                counter++;
            } // end of for
            outputStream.write(String.format("%-20s %-20s %n" , "Customer Name:" , customerName));
            outputStream.write(String.format("%-20s %-5.2f %n" , "Total Price:" , totalPrice));
            outputStream.write(String.format("%-20s %-5.2f %n" , "Discounted Price:" , discount));
            outputStream.write(String.format("%-20s %-5.2f %n" , "Amount Paid:" , tenderedAmount));
            outputStream.write(String.format("%-20s %-5.2f %n" , "Change:" , change));
            outputStream.newLine();
            outputStream.write("Date of Purchase:" + dateFormat.format(now));

            outputStream.write("========================================================\n");
            outputStream.write("               Thank you for your purchase              \n");
            outputStream.write("========================================================\n");

            outputStream.close();
        } catch (IOException e1) {
            throw new IOException();
        } // end of try-catch
    } // end of printReceipt method
} // end of class PointOfSaleUtility
