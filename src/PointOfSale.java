import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * @author Johan Rickardo Roxas
 * @version 1.00 2023/05/30
 * The main program.
 * Contains the graphical user interface.
 */
public class PointOfSale extends JFrame {

    /**
     * Template for date.
     * YEAR/MONTH/DATE HH:MM:SS (e.g., 2023/05/22 00:00:00)
     */
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * TODO: Documentation
     */
    private List<Item> purchasedItems = new ArrayList<>();

    /**
     * TODO: Documentation
     */
    private static final PointOfSaleUtility utility = new PointOfSaleUtility();

    /**
     * Main entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PointOfSale pos;
        try {
            pos = new PointOfSale();
            // pos.pack();
        } catch (Exception e) {
            e.printStackTrace();
        } // end of try-catch
    } // end of main method

    /**
     * Constructs an object of PointOfSale
     * Contains the components of the GUI
     */
    public PointOfSale() {
        super("Point of Sale System");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,600);
        setLayout(new GridLayout(2,2));

        // Search bar
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.);
        add(searchPanel);

        // Search bar components
        JLabel idLabel = new JLabel();
        idLabel.setText("Product ID");


        // Holds the table for items being purchased
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.DARK_GRAY);
        add(tablePanel);

        // Holds the text fields
        JPanel salesPanel = new JPanel();
        salesPanel.setBackground(Color.CYAN);
        add(salesPanel);

        // Holds the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.magenta);
        add(buttonsPanel);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    } // end of PointOfSale constructor
} // end of class PointOfSale
