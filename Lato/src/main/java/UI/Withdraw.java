package UI;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw implements ActionListener {
    private int winW = 491;
    private int winH = 419;

    private JFrame fr, OtherFR;
    private JPanel Forms_Container, Forms_Top, Forms_Bottom, BTN_Container;
    private JTextArea Description;
    private JTextField Amount;
    private JLabel Amount_Text, Description_Text;
    private JButton BTN_Confirm, BTN_Cancel;
    private JScrollPane scrollPane;

    public void init(JFrame FR) {
        OtherFR = FR;
        fr = new JFrame("Withdraw");
        Forms_Container = new JPanel();
        Forms_Top = new JPanel();
        Forms_Bottom = new JPanel();
        BTN_Container = new JPanel();
        Description = new JTextArea();
        Amount = new JTextField();
        Amount_Text = new JLabel("Amount");
        Description_Text = new JLabel("Description");
        BTN_Confirm = new JButton("Confirm");
        BTN_Cancel = new JButton("Cancel");
        scrollPane = new JScrollPane(Description);

        Forms_Container.setLayout(new BorderLayout());
        Forms_Top.setLayout(new GridLayout(2, 1));
        Forms_Top.add(Amount_Text);
        Forms_Top.add(Amount);
        Forms_Container.add(Forms_Top, BorderLayout.NORTH);
        Forms_Bottom.setLayout(new BorderLayout());
        Forms_Bottom.add(Description_Text, BorderLayout.NORTH);
        Forms_Bottom.add(scrollPane, BorderLayout.CENTER);
        Forms_Container.add(Forms_Bottom, BorderLayout.CENTER);

        BTN_Container.setLayout(new GridLayout(1, 2));
        BTN_Container.add(BTN_Confirm);
        BTN_Container.add(BTN_Cancel);

        fr.setLayout(new BorderLayout());
        fr.add(Forms_Container, BorderLayout.CENTER);
        fr.add(BTN_Container, BorderLayout.SOUTH);

        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setResizable(true);
        fr.setVisible(true);
        fr.pack();

//        Listener --------------------------->
        BTN_Cancel.addActionListener(this);
        BTN_Confirm.addActionListener(this);
//        Listener --------------------------->

//        Style --------------------------->
        Forms_Container.setBackground(new Color(39, 70, 68));
        Forms_Top.setBackground(new Color(39, 70, 68));
        Forms_Bottom.setBackground(new Color(39, 70, 68));
        BTN_Container.setBackground(new Color(39, 70, 68));

        Amount_Text.setForeground(new Color(255, 203, 155));
        Description_Text.setForeground(new Color(255, 203, 155));

        Amount.setBackground(new Color(96, 106, 106));
        Amount.setForeground(new Color(255, 203, 155));
        Description.setBackground(new Color(96, 106, 106));
        Description.setForeground(new Color(255, 203, 155));

        BTN_Confirm.setBackground(new Color(87, 255, 68));
        BTN_Confirm.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Cancel.setBackground(new Color(255, 106, 68));
        BTN_Cancel.setFont(new Font("SansSerif", Font.PLAIN, 20));
//        Style --------------------------->
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BTN_Confirm)) { //Button Confirm

        } else if (e.getSource().equals(BTN_Cancel)) { //Button Cancel
            OtherFR.setVisible(true);
            fr.dispose();
        }
    }
}
