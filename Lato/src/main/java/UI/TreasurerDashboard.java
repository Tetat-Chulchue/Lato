package UI;

import com.google.common.base.Splitter;
import com.mycompany.lato.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TreasurerDashboard implements ActionListener {
//    Config ------->
    private int winW = 1396;
    private int winH = 885;
    private String[] columnName = {
            "No.",
//            "UUID",
            "SID",
            "First Name",
            "Last Name",
            "Amount",
            "CreateAt",
            "UpdateAt"
    };
//    Config ------->

    private JFrame fr;
    private JPanel Table,
            Bar,
            Bar_BTN,
            Bar_Lable_Top,
            Bar_BTN_Button,
            Bar_Forms,
            Amount_Student_Container,
            Amount_Student_Panel,
            Amount_Money_Container,
            Amount_Money_Panel,
            Amount_Debt_Container,
            Amount_Debt_Panel,
            Infor_Forms,
            Infor_Forms_Top,
            Infor_Forms_Buttom,
            BTN_Action,
            Infor_Forms_Buttom_Left,
            Infor_Forms_Buttom_Right
    ;
    private JLabel Amount_Student,
            Amount_Money,
            Amount_Debt,
            Amount_Student_Text,
            Amount_Money_Text,
            Amount_Debt_Text,
            SID,
            First_Name,
            Last_Name
        ;
    private JButton BTN_Pay, BTN_Add_Payment, BTN_Withdraw, BTN_Log, BTN_Add, BTN_Update, BTN_Delete;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextField SID_Field, First_Name_Field, Last_Name_Field;

    public void init() {
        fr = new JFrame("Dashboard");

        Bar = new JPanel();
        Bar_BTN = new JPanel();
        Bar_Forms = new JPanel();
        Bar_Lable_Top = new JPanel();
        Bar_BTN_Button = new JPanel();

        Amount_Student_Container = new JPanel();
        Amount_Student_Panel = new JPanel();
        Amount_Money_Container = new JPanel();
        Amount_Money_Panel = new JPanel();
        Amount_Debt_Container = new JPanel();
        Amount_Debt_Panel = new JPanel();
        Amount_Student_Text = new JLabel("Amount student");
        Amount_Student = new JLabel("9999999");
        Amount_Money_Text = new JLabel("Amount Money");
        Amount_Money = new JLabel("9999999");
        Amount_Debt_Text = new JLabel("Amount Debt");
        Amount_Debt = new JLabel("9999999");

        BTN_Pay = new JButton("Pay");
        BTN_Add_Payment = new JButton("Add Payment");
        BTN_Withdraw = new JButton("Withdraw");
        BTN_Log = new JButton("Log");

        Infor_Forms = new JPanel();
        Infor_Forms_Top = new JPanel();
        Infor_Forms_Buttom = new JPanel();
        BTN_Action = new JPanel();
        BTN_Add = new JButton("Add");
        BTN_Update = new JButton("Update");
        BTN_Delete = new JButton("Delete");
        SID = new JLabel("** SID **");
        SID_Field = new JTextField();
        First_Name = new JLabel("First Name");
        First_Name_Field = new JTextField();
        Last_Name = new JLabel("Last Name");
        Last_Name_Field = new JTextField();
        Infor_Forms_Buttom_Left = new JPanel();
        Infor_Forms_Buttom_Right = new JPanel();

        Table = new JPanel();
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        model.setColumnIdentifiers(columnName);

        Bar.setLayout(new GridLayout(1, 2));
        Bar.add(Bar_BTN);
        Bar.add(Bar_Forms);

        Bar_BTN.setLayout(new GridLayout(2, 1));
        Bar_BTN.add(Bar_Lable_Top);
        Bar_BTN.add(Bar_BTN_Button);

        Bar_Lable_Top.setLayout(new GridLayout(1, 3));
        Amount_Student_Panel.setLayout(new GridLayout(2, 1));
        Amount_Student_Panel.add(Amount_Student_Text);
        Amount_Student_Panel.add(Amount_Student);
        Amount_Student_Container.add(Amount_Student_Panel, new GridBagConstraints());
        Bar_Lable_Top.add(Amount_Student_Container);
        Amount_Money_Panel.setLayout(new GridLayout(2, 1));
        Amount_Money_Panel.add(Amount_Money_Text);
        Amount_Money_Panel.add(Amount_Money);
        Amount_Money_Container.add(Amount_Money_Panel, new GridBagConstraints());
        Bar_Lable_Top.add(Amount_Money_Container);
        Amount_Debt_Panel.setLayout(new GridLayout(2 ,1));
        Amount_Debt_Panel.add(Amount_Debt_Text);
        Amount_Debt_Panel.add(Amount_Debt);
        Amount_Debt_Container.add(Amount_Debt_Panel, new GridBagConstraints());
        Bar_Lable_Top.add(Amount_Debt_Container);

        Bar_BTN_Button.setLayout(new GridLayout(1, 4));
        Bar_BTN_Button.add(BTN_Pay);
        Bar_BTN_Button.add(BTN_Add_Payment);
        Bar_BTN_Button.add(BTN_Withdraw);
        Bar_BTN_Button.add(BTN_Log);

        Bar_Forms.setLayout(new GridLayout(2, 1));
        Infor_Forms.setLayout(new GridLayout(2, 1));
        Infor_Forms_Top.setLayout(new GridLayout(2, 1));
        Infor_Forms_Top.add(SID);
        Infor_Forms_Top.add(SID_Field);
        Infor_Forms.add(Infor_Forms_Top);
        Infor_Forms_Buttom.setLayout(new GridLayout(1, 2));
        Infor_Forms_Buttom_Left.setLayout(new GridLayout(2, 1));
        Infor_Forms_Buttom_Left.add(First_Name);
        Infor_Forms_Buttom_Left.add(First_Name_Field);
        Infor_Forms_Buttom.add(Infor_Forms_Buttom_Left);
        Infor_Forms_Buttom_Right.setLayout(new GridLayout(2, 1));
        Infor_Forms_Buttom_Right.add(Last_Name);
        Infor_Forms_Buttom_Right.add(Last_Name_Field);
        Infor_Forms_Buttom.add(Infor_Forms_Buttom_Right);
        Infor_Forms.add(Infor_Forms_Buttom);
        BTN_Action.setLayout(new GridLayout(1, 3));
        BTN_Action.add(BTN_Add);
        BTN_Action.add(BTN_Update);
        BTN_Action.add(BTN_Delete);
        Bar_Forms.add(Infor_Forms);
        Bar_Forms.add(BTN_Action);

        Table.setLayout(new GridLayout(1, 1));
        Table.add(scrollPane);

        fr.setLayout(new BorderLayout());
        fr.add(Bar, BorderLayout.NORTH);
        fr.add(Table, BorderLayout.CENTER);

//        this.preload();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Pay.addActionListener(this);
//        BTN Listener --------------------------->

//        Style --------------------------->
//        Bar.setBackground(new Color(39, 70, 68));
//        Bar_BTN.setBackground(new Color(39, 70, 68));
//        Bar_Forms.setBackground(new Color(39, 70, 68));
//        Bar_Lable_Top.setBackground(new Color(39, 70, 68));
//        Bar_BTN_Button.setBackground(new Color(39, 70, 68));

        Table.setBackground(Color.blue);

        Amount_Student.setFont(new Font("SansSerif", Font.PLAIN, 35));
        Amount_Money.setFont(new Font("SansSerif", Font.PLAIN, 35));
        Amount_Debt.setFont(new Font("SansSerif", Font.PLAIN, 35));
//        Style --------------------------->
    }

    public static void main(String[] args) {
        TreasurerDashboard UI = new TreasurerDashboard();
        UI.init();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.BTN_Pay)) { //Button Pay
           this.addData("test",61070999, "test", "test", 900, "xx-xx-xxxx", "xx-xx-xxxx");
        } else if (e.getSource().equals(this.BTN_Add_Payment)) { //Button Add Payment

        } else if (e.getSource().equals(this.BTN_Withdraw)) { //Button Withdraw

        } else if (e.getSource().equals(this.BTN_Log)) { //Button See log

        }
    }

    public void addData(String uuid, int SID, String FN, String LN, double AM, String crateAt, String updateAt) { // Add Data to Table
        model.addRow(new Object[] {table.getRowCount()+1, SID, FN, LN, AM, crateAt, updateAt});
    }

    public void preload() { // Preload Data form Database.
        Get getData = new Get();
        ArrayList rowData = getData.getAll();
        for (int i = 0; i < rowData.size(); i++) {
            HashMap data = new HashMap();
            String string =(String) rowData.get(i);
            String[] pairs = string.split(", ");
            for (int j = 0; j < pairs.length; j++) {
                data.put(
                    pairs[j].split("=")[0].replace("{", "").replace("}", ""),
                    pairs[j].split("=")[1].replace("{", "").replace("}", "")
                );
            }
            this.addData(
                (String) data.get("uuid"),
                Integer.parseInt((String) data.get("SID")),
                (String) data.get("firstName"),
                (String) data.get("lastName"),
                Double.parseDouble((String) data.get("amount")),
                (String) data.get("createAt"),
                (String) data.get("updateAt")
            );
        }
    }
}
