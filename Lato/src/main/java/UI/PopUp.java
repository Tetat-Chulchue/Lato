package UI;

import javax.swing.*;

public class PopUp {
    private String message;
    private String title;

    public PopUp(String message, String title) {
        this.message = message;
        this.title = title;
    }

    public PopUp() {
        this.message = "";
        this.title = "";
    }

    public void information() {
        JOptionPane.showMessageDialog(null,
                this.message);
    }

    public void warning() {
        JOptionPane.showMessageDialog(null,
                this.message,
                "Warning: " + this.title,
                JOptionPane.WARNING_MESSAGE);
    }

    public void error() {
        JOptionPane.showMessageDialog(null,
                this.message,
                "Error: " + this.title,
                JOptionPane.ERROR_MESSAGE);
    }

    public void defaultMessage() {
        JOptionPane.showMessageDialog(null,
                this.message,
                "Message: " + this.title,
                JOptionPane.PLAIN_MESSAGE);
    }

    public void iconMessage(String imgPath) {
        final ImageIcon icon = new ImageIcon(getClass().getResource(imgPath));
        JOptionPane.showMessageDialog(null,
                this.message,
                "Message: " + this.title,
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

    public boolean question() {
        int n = JOptionPane.showConfirmDialog(
                null,
                this.message,
                "Question: " + this.title,
                JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    return true;
                } else {
                    return false;
                }
    }
//
//    public static void main(String[] args) {
//        PopUp UI = new PopUp("test", "test");
//        System.out.println(UI.question());
//    }
}
