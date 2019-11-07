package UI;

import java.awt.*;
import javax.swing.*;
public class TreasurerLogin {
    private JFrame fr;
    private JPanel P1, P2, P3;
    private JButton btn1;
    private JTextField TF1, TF2;
    private Label LB1;

    public void init() {
        fr = new JFrame("Login");
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        TF1 = new JTextField("Username");
        TF2 = new JTextField("Password");
        LB1 = new Label("LATO");
        btn1 = new JButton("Login");

        P1.setLayout(null);
        P1.add(LB1);
        P1.setBackground(Color.green);

        P2.setLayout(null);
        P2.add(TF1);
        P2.add(TF2);
        P2.setBackground(Color.blue);

        P3.setLayout(null);
        P3.add(btn1);
        P3.setBackground(Color.red);

        fr.setLayout(new GridLayout(3, 1));
        fr.add(P1);
        fr.add(P2);
        fr.add(P3);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(459, 700));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();


        LB1.setBounds(0, 0, 110, 40);
        LB1.setLocation(169, 120);
        LB1.setFont(new Font("Serif", Font.PLAIN, 40));
        LB1.setBackground(Color.red);

        btn1.setBounds(0, 0, 112, 39);
        btn1.setLocation(169, 97);

        TF1.setBounds(0, 0, 280, 36);
        TF1.setLocation(89, 80);

        TF2.setBounds(0, 0, 280, 36);
        TF2.setLocation(89, 130);
    }

    public static void main(String[] args) {
        TreasurerLogin test = new TreasurerLogin();
        test.init();
    }
}
