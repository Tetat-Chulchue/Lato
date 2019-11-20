package UI;

import com.mycompany.lato.query.Get;
import com.mycompany.lato.model.Treasurer;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;

public class TreasurerLogin implements ComponentListener, ActionListener {

    Treasurer currentUser;

//    Config ------->
    private int winW = 459;
    private int winH = 700;
//    Config ------->

    private JFrame fr, OtherFR;
    private JPanel P1, P2, P3, boxContainer, boxUser, boxPass, Container, Bar_Top;
    private JButton btn1;
    private JTextField TF1, TF2;
    private JLabel LB1, userText, passText, BTN_Back;


    public void init(JFrame FR) {
        OtherFR = FR;
        fr = new JFrame("TreasurerLogin");
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        boxContainer = new JPanel();
        boxUser = new JPanel();
        boxPass = new JPanel();
        TF1 = new JTextField(""); //lato@dev.com
        TF2 = new JPasswordField(""); //admin1234
        LB1 = new JLabel("LATO");
        userText = new JLabel("Username");
        passText = new JLabel("Password");
        btn1 = new JButton("Login");
        Container = new JPanel();
        Bar_Top = new JPanel();
        BTN_Back = new JLabel("<");

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
        btn1.addActionListener(this);
        P3.setBackground(new Color(39, 70, 68));

        fr.setLayout(new BorderLayout());
        Bar_Top.setLayout(new BorderLayout());
        Bar_Top.add(BTN_Back, BorderLayout.WEST);
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

        // Listener --------------------------->
        fr.getContentPane().addComponentListener(this);
        BTN_Back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OtherFR.setVisible(true);
                fr.dispose();
            }
        });
        // Listener --------------------------->

        // Style --------------------------->
        LB1.setBounds(0, 0, 188, 60);
        LB1.setLocation((fr.getWidth()/2)-(LB1.getWidth()/2), 120);
        LB1.setFont(new Font("SansSerif", Font.PLAIN, 70));
        LB1.setForeground(new Color(255, 203, 155));

        Bar_Top.setBackground(new Color(39, 70, 68));

        btn1.setBounds(0, 0, 112, 39);
        btn1.setLocation((fr.getWidth()/2)-(btn1.getWidth()/2), 97);
        btn1.setBackground(Color.red);
        BTN_Back.setForeground(new Color(255, 203, 155));
        BTN_Back.setFont(new Font("SansSerif", Font.PLAIN, 40));

        boxContainer.setBounds(0, 0, 280, 130);
        boxContainer.setLocation((fr.getWidth()/2)-(boxContainer.getWidth()/2), 80);
        boxContainer.setBackground(new Color(39, 70, 68));

        boxUser.setBackground(new Color(39, 70, 68));
        boxPass.setBackground(new Color(39, 70, 68));

        userText.setBackground(new Color(39, 70, 68));
        userText.setForeground(new Color(255, 203, 155));
        TF1.setBackground(new Color(96, 106, 106));
        TF1.setForeground(new Color(255, 203, 155));
        passText.setBackground(new Color(39, 70, 68));
        passText.setForeground(new Color(255, 203, 155));
        TF2.setBackground(new Color(96, 106, 106));
        TF2.setForeground(new Color(255, 203, 155));
        // Style --------------------------->
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        LB1.setLocation((fr.getWidth()/2)-(LB1.getWidth()/2), 120);
        btn1.setLocation((fr.getWidth()/2)-(btn1.getWidth()/2), 97);
        boxContainer.setLocation((fr.getWidth()/2)-(boxContainer.getWidth()/2), 80);
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {

    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {

    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btn1)) { // When click login handler is doing in here
//            String email = Treasurer.login(TF1.getText(), TF2.getText());
            String email = Treasurer.login(TF1.getText(), TF2.getText());
            if (email != null) {
                // GET USER HERE //
                Get userData = new Get();
                Map<String, Object> user = userData.getByCollectionAndDocumentName("Treasurers", email);
                currentUser = new Treasurer((String)user.get("name"), (String)user.get("lastname"), (String)user.get("studentId"));
                TreasurerDashboard UI = new TreasurerDashboard();
                UI.init();
                fr.dispose();
            } else {
                new PopUp("Unable to login", "Login").error();
            }
        }
    }
}
