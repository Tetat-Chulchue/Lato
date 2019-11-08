package UI;

import java.awt.*;
import javax.swing.*;
public class TreasurerLogin {
    private JFrame fr;
    private JPanel P1, P2, P3, boxContainer, boxUser, boxPass;
    private JButton btn1;
    private JTextField TF1, TF2;
    private Label LB1, userText, passText;

    public void init() {
        fr = new JFrame("TreasurerLogin");
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        boxContainer = new JPanel();
        boxUser = new JPanel();
        boxPass = new JPanel();
        TF1 = new JTextField();
        TF2 = new JPasswordField();
        LB1 = new Label("LATO");
        userText = new Label("Username");
        passText = new Label("Password");
        btn1 = new JButton("Login");

        P1.setLayout(null);
        P1.add(LB1);
        P1.setBackground(new Color(39, 70, 68));

        P2.setLayout(null);
        boxContainer.setLayout(new GridLayout(2, 1));
        boxUser.setLayout(new GridLayout(2, 1));
        boxPass.setLayout(new GridLayout(2, 1));
        boxUser.add(userText);
        boxUser.add(TF1);
        boxPass.add(passText);
        boxPass.add(TF2);
        boxContainer.add(boxUser);
        boxContainer.add(boxPass);
        P2.add(boxContainer);
        P2.setBackground(new Color(39, 70, 68));

        P3.setLayout(null);
        P3.add(btn1);
        P3.setBackground(new Color(39, 70, 68));

        fr.setLayout(new GridLayout(3, 1));
        fr.add(P1);
        fr.add(P2);
        fr.add(P3);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(459, 700));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();

//        Style --------------------------->

        LB1.setBounds(0, 0, 188, 60);
        LB1.setLocation((fr.getWidth()/2)-(LB1.getWidth()/2), 120);
        LB1.setFont(new Font("SansSerif", Font.PLAIN, 70));
        LB1.setForeground(new Color(255, 203, 155));

        btn1.setBounds(0, 0, 112, 39);
        btn1.setLocation((fr.getWidth()/2)-(btn1.getWidth()/2), 97);
        btn1.setBackground(Color.red);

        boxContainer.setBounds(0, 0, 280, 130);
        boxContainer.setLocation((fr.getWidth()/2)-(boxContainer.getWidth()/2), 80);
        boxContainer.setBackground(new Color(39, 70, 68));

        boxUser.setBackground(new Color(39, 70, 68));
        boxPass.setBackground(new Color(39, 70, 68));

        userText.setBackground(new Color(39, 70, 68));
        userText.setForeground(new Color(255, 203, 155));
        passText.setBackground(new Color(39, 70, 68));
        passText.setForeground(new Color(255, 203, 155));

//        Style --------------------------->
    }

    public static void main(String[] args) {
        TreasurerLogin test = new TreasurerLogin();
        test.init();
    }
}
