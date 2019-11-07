package UI;

import java.awt.*;
import javax.swing.*;
public class TreasurerLogin {
    private JFrame fr;
    private JPanel P1, P2, P3;
    private JTextField txt;
    private JButton btn1;

    public void init() {
        // Construct Object
        fr = new JFrame("Login");
        P1 = new JPanel();
        txt = new JTextField();
        btn1 = new JButton("Login");

        P1.setLayout(new GridLayout(4, 4));
        P1.add(btn1);
        P1.setBackground();

        fr.add(P1, BorderLayout.NORTH);
        fr.add(P2, BorderLayout.CENTER);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(459, 700));
        fr.setVisible(true);
        fr.pack();
    }

    public static void main(String[] args) {
        TreasurerLogin test = new TreasurerLogin();
        test.init();
    }
}
