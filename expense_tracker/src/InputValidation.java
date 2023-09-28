//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class InputValidation {


    public void intake_verify(double amount, String category) {
        if (amount < 0.0 | amount > 1000.0) {
            JOptionPane.showMessageDialog((Component)null, "Error ! The amount should be greater than 0 and less than 1000");
            throw new IllegalArgumentException("Error! The amount should be greater than 0 and less than 1000");
        } else {
            List<String> valid_list_of_items = Arrays.asList("food", "travel", "bills", "entertainment", "other");
            if (!valid_list_of_items.contains(category)) {
                JOptionPane.showMessageDialog((Component)null, "Error! The category must be from this list \"food\", \"travel\", \"bills\", \"entertainment\",\"other\"");
                throw new IllegalArgumentException("Error! The category must be from this list \"food\",\"travel\", \"bills\", \"entertainment\", and \"other\"");
            }
        }
    }
}
