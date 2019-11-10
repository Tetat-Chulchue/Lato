package UI;

import javax.swing.*;
import java.awt.*;

public class TreasurerDashboard {
//    Config ------->
    private int winW = 1200;
    private int winH = 750;
//    Config ------->


    private JFrame fr;
    private JPanel Table, Bar, Bar_BTN, Bar_Lable_Top, Bar_BTN_Button, Bar_Forms;
    private JLabel Amount_Student, Amount_Money, Amount_Debt;
    private JButton BTN_Pay, BTN_Add_Payment, BTN_Withdraw, BTN_Log;

    public void init() {
        fr = new JFrame("Dashboard");
        Bar = new JPanel();
        Bar_BTN = new JPanel();
        Bar_Forms = new JPanel();
        Bar_Lable_Top = new JPanel();
        Bar_BTN_Button = new JPanel();
        Amount_Student = new JLabel("9999999");
        Amount_Money = new JLabel("9999999");
        Amount_Debt = new JLabel("9999999");
        BTN_Pay = new JButton("จ่าย");
        BTN_Add_Payment = new JButton("เพิ่มค่าค่างชำลพ");
        BTN_Withdraw = new JButton("ถอน");
        BTN_Log = new JButton("ดูบันทึก");
        Table = new JPanel();

        Bar.setLayout(new GridLayout(1, 2));
        Bar.add(Bar_BTN);
        Bar.add(Bar_Forms);

        Bar_BTN.setLayout(new GridLayout(2, 1));
        Bar_BTN.add(Bar_Lable_Top);
        Bar_BTN.add(Bar_BTN_Button);

        Bar_Lable_Top.setLayout(new GridLayout(1, 3));
        Bar_Lable_Top.add(Amount_Student);
        Bar_Lable_Top.add(Amount_Money);
        Bar_Lable_Top.add(Amount_Debt);

        Bar_BTN_Button.setLayout(new GridLayout(1, 4));
        Bar_BTN_Button.add(BTN_Pay);
        Bar_BTN_Button.add(BTN_Add_Payment);
        Bar_BTN_Button.add(BTN_Withdraw);
        Bar_BTN_Button.add(BTN_Log);

        fr.setLayout(new GridLayout(2, 1));
        fr.add(Bar);
        fr.add(Table);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        Style --------------------------->
        Bar.setBackground(Color.red);
        Bar_BTN.setBackground(Color.CYAN);
        Bar_Forms.setBackground(Color.GRAY);
        Bar_Lable_Top.setBackground(Color.green);
        Bar_BTN_Button.setBackground(Color.MAGENTA);

        Table.setBackground(Color.blue);
//        Style --------------------------->
    }

    public static void main(String[] args) {
        TreasurerDashboard UI = new TreasurerDashboard();
        UI.init();
    }
}
