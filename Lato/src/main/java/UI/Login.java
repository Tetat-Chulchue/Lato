package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Login implements ActionListener {
    private int winW = 459;
    private int winH = 700;
    private JFrame fr;
    private JPanel P1, P2, P3, boxContainer, boxUser, boxTreasurer, Container, Bar_Top;
    private JButton btn1,btn2;
    private JLabel jLabe0, jLabel,jLabe2;


    public void init() {
        fr = new JFrame("Login");
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        boxContainer = new JPanel();
        boxUser = new JPanel();
        boxTreasurer = new JPanel();
        Container = new JPanel();
        Bar_Top = new JPanel();
        btn1 = new JButton("Treasurer");
        btn1.addActionListener(this);
        btn1.setFont(new Font("Serif", Font.PLAIN, 35));
        btn2 = new JButton("User");
        btn2.setFont(new Font("Serif", Font.PLAIN, 35));
        btn2.addActionListener(this);

        jLabel = new JLabel("LATO");
        jLabel.setBounds(0, 0, 188, 60);
        jLabel.setLocation((fr.getWidth()/2)-(jLabel.getWidth()/2), 120);
        jLabel.setFont(new Font("SansSerif", Font.PLAIN, 70));
        jLabel.setForeground(new Color(255, 203, 155));

        jLabe2 = new JLabel("please select");
        jLabe0 = new JLabel(" ");

        boxContainer.setLayout(new GridLayout(2, 1));
        boxUser.setLayout(new GridLayout(2, 1));
        boxTreasurer.setLayout(new GridLayout(2, 1));
        boxUser.add(btn1);
        boxTreasurer.add(btn2);
        boxContainer.add(boxUser);
        boxContainer.add(boxTreasurer);

        P1.setLayout(null);
        P1.add(jLabel);
        P1.setBackground(new Color(39, 70, 68));

        P2.setLayout(null);
        P2.add(jLabe2);
        P2.add(boxContainer);
        P2.setBackground(new Color(39, 70, 68));

        P3.setLayout(null);
        P3.setBackground(new Color(39, 70, 68));


        fr.setLayout(new BorderLayout());
        Bar_Top.setLayout(new BorderLayout());
        Bar_Top.add(jLabe0);
        fr.add(Bar_Top, BorderLayout.NORTH);
        Container.setLayout(new GridLayout(3, 1));
        Container.add(P1);
        Container.add(P2);
        Container.add(P3);
        fr.add(Container, BorderLayout.CENTER);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();

        jLabel.setBounds(0, 0, 188, 60);
        jLabel.setLocation((fr.getWidth()/2)-(jLabel.getWidth()/2), 120);
        jLabel.setFont(new Font("SansSerif", Font.PLAIN, 70));
        jLabel.setForeground(new Color(255, 203, 155));

        jLabe2.setBounds(0, 0, 188, 60);
        jLabe2.setLocation((fr.getWidth()/2)-(jLabel.getWidth()/2), 0);
        jLabe2.setFont(new Font("SansSerif", Font.PLAIN, 32));
        jLabe2.setForeground(new Color(255, 203, 155));

        Bar_Top.setBackground(new Color(39, 70, 68));

        btn1.setBounds(0, 0, 112, 39);
        btn1.setLocation((fr.getWidth()/2)-(btn1.getWidth()/2), 0);
        btn1.setBackground(new Color(255, 203, 155));

        btn2.setBounds(0, 0, 112, 39);
        btn2.setLocation((fr.getWidth()/2)-(btn1.getWidth()/2), 200);
        btn2.setBackground(new Color(255, 203, 155));

        jLabe0.setForeground(new Color(255, 203, 155));
        jLabe0.setFont(new Font("SansSerif", Font.PLAIN, 40));

        boxContainer.setBounds(0, 0, 280, 130);
        boxContainer.setLocation((fr.getWidth()/2)-(boxContainer.getWidth()/2), 80);
        boxContainer.setBackground(new Color(39, 70, 68));

        boxUser.setBackground(new Color(39, 70, 68));
        boxTreasurer.setBackground(new Color(39, 70, 68));

    }

    public static void main(String[] args) {
        Login test = new Login();
        test.init();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btn1)) {
            TreasurerLogin UI = new TreasurerLogin();
            UI.init(fr);
            fr.setVisible(false);
        } else if (e.getSource().equals(this.btn2)) {
            UserDashboard UI = new UserDashboard();
            UI.init();
            fr.setVisible(false);
        }
    }
}

