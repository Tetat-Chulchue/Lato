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
//    Config ------->

    private JFrame fr;
    private JPanel Table, Bar, Bar_BTN, Bar_Lable_Top, Bar_BTN_Button, Bar_Forms;
    private JLabel Amount_Student, Amount_Money, Amount_Debt;
    private JButton BTN_Pay, BTN_Add_Payment, BTN_Withdraw, BTN_Log;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    private String[] columnName = {
//            "No.",
            "UUID",
            "SID",
            "First Name",
            "Last Name",
            "Amount",
            "CreateAt",
            "UpdateAt"
    };
    private Object[][] data = {
    };

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
        BTN_Pay = new JButton("Pay");
        BTN_Add_Payment = new JButton("Add Payment");
        BTN_Withdraw = new JButton("Withdraw");
        BTN_Log = new JButton("Log");
        Table = new JPanel();
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        model.setColumnIdentifiers(columnName);
        for (int i = 0; i < data.length; i++) {model.addRow(data[i]);};

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

        Table.setLayout(new GridLayout(1, 1));
        Table.add(scrollPane);

        fr.setLayout(new GridLayout(2, 1));
        fr.add(Bar);
        fr.add(Table);

        this.preload();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Pay.addActionListener(this);
//        BTN Listener --------------------------->

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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.BTN_Pay)) {
            this.addData("test",61070999, "test", "test", 900, "xx-xx-xxxx", "xx-xx-xxxx");
        }
    }

    public void addData(String uuid, int SID, String FN, String LN, double AM, String crateAt, String updateAt) {
//        Object counter = table.getModel().getValueAt(table.getRowCount()-1, 0);
        model.addRow(new Object[] {uuid, SID, FN, LN, AM, crateAt, updateAt});
    }

    public void preload() {
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

//    private void addDataFormFirebase(Object sid, Object firstName, Object lastName, Object amount, Object crateAt, Object updateAt) {
//        Object counter = table.getModel().getValueAt(table.getRowCount()-1, 0);
//        model.addRow(new Object[] {(int) counter+1, sid, firstName, lastName, amount, crateAt, updateAt});
//    }
}
