package UI;

import javax.swing.*;

public class PopUp {
    public PopUp(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
