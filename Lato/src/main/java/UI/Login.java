package UI;

import java.awt.*;
import javax.swing.*;

public class Login {
    private JFrame fr;
    private JPanel P1, P2, P3;
    private JButton btn1;
    private JButton btn2;
    private JLabel jLabel;
    private JLabel jLabe2;

    public void init() {
        fr = new JFrame("Login");
        P1 = new JPanel();
        P2 = new JPanel();
//        P3 = new JPanel();
        btn1 = new JButton("Treasurer");
        btn1.setFont(new Font("Serif", Font.PLAIN, 50));
        btn2 = new JButton("User");
        btn2.setFont(new Font("Serif", Font.PLAIN, 50));

        jLabel = new JLabel("LATO", SwingConstants.CENTER );
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 50));

        jLabe2 = new JLabel("please select", SwingConstants.CENTER );
        jLabe2.setVerticalAlignment(SwingConstants.CENTER);
        jLabe2.setFont(new Font("Serif", Font.PLAIN, 25));

        P1.setLayout(new GridLayout(3, 3));
        P1.add(jLabel);
        P1.setBackground(Color.cyan);

        P2.setLayout(new GridLayout(3, 3));
        P2.add(jLabe2);
        P2.add(btn1);
        P2.add(btn2);
        P2.setBackground(Color.cyan);


        fr.add(P1, BorderLayout.NORTH);
        fr.add(P2, BorderLayout.CENTER);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(459, 700));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();

    }

    public static void main(String[] args) {
        Login test = new Login();
        test.init();
    }
}

