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

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Point of Sale", SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(BorderFactory.createBevelBorder(10));
        mainPanel.add(titleLabel);

        // Search Panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(Color.DARK_GRAY);

        JLabel idLabel = new JLabel("Product ID");

        JTextField idTextField = new JTextField();

        JLabel nameLabel = new JLabel("Product Name");

        JTextField nameTextField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity");

        JComboBox<Integer> quantityComboBox = new JComboBox<>();

        JLabel unitPriceLabel = new JLabel("Unit Price");

        JTextField unitPriceTextField = new JTextField();

        JLabel totalPriceLabel = new JLabel("Total Price");

        JTextField totalPriceTextField = new JTextField();

        JButton addButton = new JButton("Add");


        // Right Panel
        JPanel rightPanel = new JPanel(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    } // end of PointOfSale constructor
} // end of class PointOfSale
