import javax.swing.*;
import java.lang.*;
import java.util.*;

/**
 * @author Johan Rickardo Roxas
 * The main program.
 * Contains the graphical user interface.
 */
public class PointOfSale extends JFrame {
    public static void main(String[] args) {
        PointOfSale pos;
        try {
            pos = new PointOfSale();
            pos.pack();
        } catch (Exception e) {
            e.printStackTrace();
        } // end of try-catch
    } // end of main method
} // end of class PointOfSale
