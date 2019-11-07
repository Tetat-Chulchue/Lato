package UI;

import java.awt.*;
import javax.swing.*;
public class TreasurerLogin {
    private JFrame fr;
    private JPanel P1, P2, P3;
    private JButton btn1;
    private JTextField TF1;

    public void init() {
        fr = new JFrame("Login");
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        TF1 = new JTextField();
        btn1 = new JButton("Login");

        P1.setLayout(new GridLayout(3, 3));
//        P1.add(btn1);
        P1.setBackground(Color.green);

        P2.setLayout(new FlowLayout());
        P2.add(TF1);
        P2.setBackground(Color.blue);

        P3.add(btn1);
        P3.setBackground(Color.red);

        fr.add(P1, BorderLayout.NORTH);
        fr.add(P2, BorderLayout.CENTER);
        fr.add(P3, BorderLayout.SOUTH);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(459, 700));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();
    }

    public static void main(String[] args) {
        TreasurerLogin test = new TreasurerLogin();
        test.init();
    }
}
