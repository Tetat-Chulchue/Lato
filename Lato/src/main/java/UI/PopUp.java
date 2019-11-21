package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

    public JFrame loading() {
        JLabel GIF = new JLabel(new ImageIcon("loading.gif"));
        JFrame fr = new JFrame("Loading");
        JLabel TX = new JLabel("Loading...");
        JPanel PN = new JPanel();
        TX.setFont(new Font("SansSerif", Font.PLAIN, 40));

        fr.setLayout(new GridLayout(1, 1));
        PN.setLayout(new GridLayout(1, 1));
        PN.add(TX);
        fr.add(PN);

        PN.setBackground(new Color(96, 106, 106));
        TX.setForeground(new Color(255, 203, 155));

        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(180, 80));
        fr.setUndecorated(true);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.pack();
        return fr;
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
    public static void main(String[] args) {
        PopUp UI = new PopUp("test", "test");
        UI.loading();
    }
// .getRootFrame().dispose();
}
