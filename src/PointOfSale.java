import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        setLayout(new BorderLayout(5,5));

        // Search bar
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(new Color(47,57,77)); // Charcoal
        searchPanel.setPreferredSize(new Dimension(700, 600));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);

        add(searchPanel, BorderLayout.WEST);

        // Search bar components
        // Title Label
        gbc.gridx = 5;
        gbc.gridy = 0;
        JLabel searchTitlePanel = new JLabel();
        searchTitlePanel.setText("Search/Scan Item");
        searchTitlePanel.setFont(new Font("Arial", Font.BOLD, 20));
        searchTitlePanel.setForeground(Color.white);
        searchTitlePanel.setSize(10,10);
        searchPanel.add(searchTitlePanel, gbc);

        // Separator
        gbc.gridwidth = 2;
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.black);
        searchPanel.add(separator, gbc);

        // Product ID
        // Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JLabel idLabel = new JLabel();
        idLabel.setText("Product ID");
        idLabel.setForeground(Color.white);
        idLabel.setAlignmentX(SwingConstants.EAST);
        searchPanel.add(idLabel,gbc);

        // Text Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JTextField idTextField = new JTextField();
        idTextField.setColumns(5);
        idTextField.setForeground(Color.white);
        idTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        idTextField.setBackground(Color.black);
        searchPanel.add(idTextField,gbc);

        // Product Name
        // Label
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Product Name");
        nameLabel.setForeground(Color.white);
        nameLabel.setAlignmentX(SwingConstants.EAST);
        searchPanel.add(nameLabel, gbc);

        // Text Field
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JTextField nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setForeground(Color.white);
        searchPanel.add(nameTextField, gbc);

        // Quantity
        // Label
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel quantityLabel = new JLabel();
        quantityLabel.setText("Quantity");
        quantityLabel.setForeground(Color.white);
        searchPanel.add(quantityLabel, gbc);

        // Spinner
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        SpinnerModel quantityValues = new SpinnerNumberModel(1,1,100,1);
        JSpinner quantitySpinner = new JSpinner(quantityValues);
        quantitySpinner.setBounds(2,1,1,2);
        searchPanel.add(quantitySpinner, gbc);

        // Unit Price
        // Label
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JLabel priceLabel = new JLabel();
        priceLabel.setText("Unit Price");
        priceLabel.setForeground(Color.white);
        searchPanel.add(priceLabel, gbc);

        // Text Field
        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JTextField priceTextField = new JTextField();
        priceTextField.setColumns(7);
        priceTextField.setForeground(Color.white);
        priceTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        priceTextField.setBackground(new Color(86,102,107)); // Payne's Gray
        priceTextField.setEditable(false);
        searchPanel.add(priceTextField, gbc);

        // Total Price
        // Label
        gbc.gridx = 9;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JLabel totalLabel = new JLabel();
        totalLabel.setText("Total Price");
        totalLabel.setForeground(Color.white);
        searchPanel.add(totalLabel, gbc);

        // Text Field
        gbc.gridx = 9;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JTextField totalTextField = new JTextField();
        totalTextField.setColumns(10);
        totalTextField.setForeground(Color.white);
        totalTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        totalTextField.setBackground(new Color(86,102,107)); // Payne's Gray
        totalTextField.setEditable(false);
        searchPanel.add(totalTextField, gbc);

        // Search Button
        gbc.gridx = 9;
        gbc.gridy = 3;
        JButton searchButton = new JButton();
        searchButton.setText("Search Item");
        searchButton.setVerticalTextPosition(SwingConstants.CENTER);
        searchButton.setHorizontalTextPosition(SwingConstants.CENTER);
        searchButton.setOpaque(false);
        searchPanel.add(searchButton, gbc);

        // Add button
        gbc.gridx = 9;
        gbc.gridy = 4;
        JButton addButton = new JButton();
        addButton.setText("Add Item");
        addButton.setVerticalTextPosition(SwingConstants.CENTER);
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setOpaque(true);
        searchPanel.add(addButton, gbc);

        // Separator
        gbc.gridx = 5;
        gbc.gridy = 5;
        JSeparator jSeparator = new JSeparator();
        jSeparator.setOrientation(SwingConstants.HORIZONTAL);
        jSeparator.setForeground(Color.WHITE);
        searchPanel.add(jSeparator, gbc);

        // Text Fields
        // Title Label
        gbc.gridx = 5;
        gbc.gridy = 6;
        JLabel salesTitleLabel = new JLabel();
        salesTitleLabel.setText("Sales");
        salesTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        salesTitleLabel.setForeground(Color.white);
        salesTitleLabel.setSize(10,10);
        searchPanel.add(salesTitleLabel, gbc);

        // Total Amount
        // Label
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        JLabel totalAmountLabel = new JLabel();
        totalAmountLabel.setText("Total Amount:");
        totalAmountLabel.setForeground(Color.white);
        totalAmountLabel.setAlignmentX(SwingConstants.EAST);
        searchPanel.add(totalAmountLabel,gbc);

        // Text Field
        gbc.gridx = 0;
        gbc.gridy = 8;
        JTextField totalAmountTextField = new JTextField();
        totalAmountTextField.setColumns(8);
        totalAmountTextField.setForeground(Color.white);
        totalAmountTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        totalAmountTextField.setBackground(new Color(86,102,107)); // Payne's Gray
        totalAmountTextField.setEditable(false);
        searchPanel.add(totalAmountTextField,gbc);

        // Discount Percentage
        // Label
        gbc.gridx = 3;
        gbc.gridy = 7;
        JLabel discountLabel = new JLabel();
        discountLabel.setText("Discount %");
        discountLabel.setForeground(Color.white);
        discountLabel.setAlignmentX(SwingConstants.EAST);
        searchPanel.add(discountLabel,gbc);

        // Text Field
        gbc.gridx = 3;
        gbc.gridy = 8;
        JTextField discountTextField = new JTextField();
        discountTextField.setColumns(7);
        discountTextField.setForeground(Color.white);
        discountTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        searchPanel.add(discountTextField, gbc);

        // Discounted Price
        // Label
        gbc.gridx = 5;
        gbc.gridy = 7;
        JLabel discountedPriceLabel = new JLabel();
        discountedPriceLabel.setText("Discounted Price");
        discountedPriceLabel.setForeground(Color.white);
        discountedPriceLabel.setAlignmentX(SwingConstants.EAST);
        searchPanel.add(discountedPriceLabel,gbc);

        // Text Field
        gbc.gridx = 5;
        gbc.gridy = 8;
        JTextField discountedPriceTextField = new JTextField();
        discountedPriceTextField.setColumns(10);
        discountedPriceTextField.setForeground(Color.white);
        discountedPriceTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        discountedPriceTextField.setBackground(new Color(86,102,107)); // Payne's Gray
        discountedPriceTextField.setEditable(false);
        searchPanel.add(discountedPriceTextField, gbc);

        // Print Receipt
        gbc.gridx = 7;
        gbc.gridy = 8;
        JButton printButton = new JButton();
        printButton.setText("Print Receipt");
        printButton.setVerticalTextPosition(SwingConstants.CENTER);
        printButton.setHorizontalTextPosition(SwingConstants.CENTER);
        printButton.setOpaque(true);
        searchPanel.add(printButton, gbc);

        // Clear
        gbc.gridx = 9;
        gbc.gridy = 8;
        JButton clearButton = new JButton();
        clearButton.setText("Clear Items");
        clearButton.setVerticalTextPosition(SwingConstants.CENTER);
        clearButton.setHorizontalTextPosition(SwingConstants.CENTER);
        clearButton.setOpaque(true);
        searchPanel.add(clearButton, gbc);

        // Holds the table for items being purchased
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.DARK_GRAY);
        tablePanel.setPreferredSize(new Dimension(500,600));
        add(tablePanel, BorderLayout.EAST);

        // Table
        String[] columnNames= {"ID", "Name" , "Quantity" , "Unit Price", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable itemTable = new JTable(model);
        itemTable.getTableHeader().setFont(new Font("Arial" , Font.BOLD, 14));
        itemTable.setFont(new Font("Arial" , Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(18,7,102), 1));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    } // end of PointOfSale constructor
} // end of class PointOfSale
