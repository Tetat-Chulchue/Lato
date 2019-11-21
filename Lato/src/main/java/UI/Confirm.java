package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Confirm implements ActionListener{
    private int winW = 291;
    private int winH = 191;

    private JFrame fr, OtherFR;
    private JPanel Forms_Container, Forms_Bottom, BTN_Container;
    private JLabel Text;
    private JButton BTN_Confirm, BTN_Cancel;

    public void init(JFrame FR){
        OtherFR = FR;
        fr = new JFrame("Confirm");
        Forms_Container = new JPanel();
        Forms_Bottom = new JPanel();
        BTN_Container = new JPanel();
        Text = new JLabel("Are you sure?");
        BTN_Confirm = new JButton("Confirm");
        BTN_Cancel = new JButton("Cancel");
        Forms_Container.add(Text);
        Forms_Bottom.setLayout(new BorderLayout());

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
        Text.setForeground(new Color(20, 255, 247));
        Text.setLocation((fr.getWidth()/2)-(Text.getWidth()/2),0);;
        Text.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Forms_Container.setBackground(new Color(0, 53, 84));
        Forms_Bottom.setBackground(new Color(0, 53, 84));
        BTN_Container.setBackground(new Color(0, 53, 84));

        BTN_Confirm.setBackground(new Color(87, 255, 68));
        BTN_Confirm.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Cancel.setBackground(new Color(255, 66, 54));
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
