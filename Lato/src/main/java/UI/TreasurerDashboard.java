package UI;

import com.mycompany.lato.query.Delete;
import com.mycompany.lato.query.Get;
import com.mycompany.lato.query.Post;
import com.mycompany.lato.query.Update;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreasurerDashboard implements ActionListener {
//    Config ------->
    private int winW = 1396;
    private int winH = 885;
    private String[] columnName = {
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
    private DefaultTableModel  model;
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
        Amount_Student_Text = new JLabel("Number of user(s)");
        Amount_Student = new JLabel("-");
        Amount_Money_Text = new JLabel("Money Pool (THB)");
        Amount_Money = new JLabel("-");
        Amount_Debt_Text = new JLabel("Unpaid Debt (THB)");
        Amount_Debt = new JLabel("-");

        BTN_Pay = new JButton("Pay");
        BTN_Add_Payment = new JButton("Add Debt");
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
        table = new JTable(model) {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
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

        Bar_Forms.setLayout(new BorderLayout());
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
        Bar_Forms.add(Infor_Forms, BorderLayout.CENTER);
        Bar_Forms.add(BTN_Action, BorderLayout.SOUTH);

        Table.setLayout(new GridLayout(1, 1));
        Table.add(scrollPane);

        fr.setLayout(new BorderLayout());
        fr.add(Bar, BorderLayout.NORTH);
        fr.add(Table, BorderLayout.CENTER);

        this.preload();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if (dim.width < winW || dim.height < winH) {
            fr.setPreferredSize(new Dimension(dim.width-200, dim.height-200));
            fr.setLocation(dim.width/2-(dim.width-200)/2, dim.height/2-(dim.height-200)/2);
        } else {
            fr.setPreferredSize(new Dimension(winW, winH));
            fr.setLocation(dim.width/2-winW/2, dim.height/2-winH/2);
        }
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setIconImage(new ImageIcon("icon.png").getImage());
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Pay.addActionListener(this);
        BTN_Add_Payment.addActionListener(this);
        BTN_Withdraw.addActionListener(this);
        BTN_Log.addActionListener(this);

        BTN_Add.addActionListener(this);
        BTN_Update.addActionListener(this);
        BTN_Delete.addActionListener(this);
//        BTN Listener --------------------------->

//        Style --------------------------->
        Bar.setBackground(new Color(0, 53, 84));
        Bar_BTN.setBackground(new Color(0, 53, 84));
        Bar_Forms.setBackground(new Color(0, 53, 84));
        Bar_Lable_Top.setBackground(new Color(0, 53, 84));
        Bar_BTN_Button.setBackground(new Color(0, 53, 84));
        Amount_Student_Container.setBackground(new Color(0, 53, 84));
        Amount_Student_Panel.setBackground(new Color(0, 53, 84));
        Amount_Money_Container.setBackground(new Color(0, 53, 84));
        Amount_Money_Panel.setBackground(new Color(0, 53, 84));
        Amount_Debt_Container.setBackground(new Color(0, 53, 84));
        Amount_Debt_Panel.setBackground(new Color(0, 53, 84));
        Infor_Forms.setBackground(new Color(0, 53, 84));
        Infor_Forms_Top.setBackground(new Color(0, 53, 84));
        Infor_Forms_Buttom.setBackground(new Color(0, 53, 84));
        Infor_Forms_Buttom_Left.setBackground(new Color(0, 53, 84));
        Infor_Forms_Buttom_Right.setBackground(new Color(0, 53, 84));
        BTN_Action.setBackground(new Color(0, 53, 84));

        Amount_Student_Text.setFont(new Font("SansSerif", Font.PLAIN, 17));
        Amount_Student_Text.setForeground(new Color(68, 249, 255));
        Amount_Student.setFont(new Font("SansSerif", Font.PLAIN, 35));
        Amount_Student.setForeground(new Color(68, 249, 255));//
        Amount_Money_Text.setFont(new Font("SansSerif", Font.PLAIN, 17));
        Amount_Money_Text.setForeground(new Color(68, 249, 255));
        Amount_Money.setFont(new Font("SansSerif", Font.PLAIN, 35));
        Amount_Money.setForeground(new Color(87, 255, 68));
        Amount_Debt_Text.setFont(new Font("SansSerif", Font.PLAIN, 17));
        Amount_Debt_Text.setForeground(new Color(68, 249, 255));
        Amount_Debt.setFont(new Font("SansSerif", Font.PLAIN, 35));
        Amount_Debt.setForeground(new Color(255, 106, 68));
        Table.setForeground(new Color(255, 106, 68));

        SID.setForeground(new Color(68, 249, 255));
        First_Name.setForeground(new Color(68, 249, 255));
        Last_Name.setForeground(new Color(68, 249, 255));

        BTN_Pay.setBackground(new Color(68, 118, 255));
        BTN_Pay.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Pay.setForeground(new Color(0, 53, 84));
        BTN_Add_Payment.setBackground(new Color(68, 118, 255));
        BTN_Add_Payment.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Add_Payment.setForeground(new Color(0, 53, 84));
        BTN_Withdraw.setBackground(new Color(68, 118, 255));
        BTN_Withdraw.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Withdraw.setForeground(new Color(0, 53, 84));
        BTN_Log.setBackground(new Color(68, 118, 255));
        BTN_Log.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Log.setForeground(new Color(0, 53, 84));
        BTN_Add.setBackground(new Color(68, 118, 255));
        BTN_Add.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Add.setForeground(new Color(0, 53, 84));
        BTN_Update.setBackground(new Color(87, 255, 68));
        BTN_Update.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Update.setForeground(new Color(0, 53, 84));
        BTN_Delete.setBackground(new Color(255, 106, 68));
        BTN_Delete.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Delete.setForeground(new Color(0, 53, 84));

        SID_Field.setBackground(new Color(96, 106, 106));
        SID_Field.setForeground(new Color(68, 249, 255));
        First_Name_Field.setBackground(new Color(96, 106, 106));
        First_Name_Field.setForeground(new Color(68, 249, 255));
        Last_Name_Field.setBackground(new Color(96, 106, 106));
        Last_Name_Field.setForeground(new Color(68, 249, 255));

        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getTableHeader().setBackground(new Color(0, 53, 84));
        table.getTableHeader().setForeground(new Color(68, 249, 255));
        table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setFont(new Font("SansSerif", Font.PLAIN, 15));
        table.setRowHeight(24);
        table.setBackground(new Color(0, 53, 84));
        table.setForeground(new Color(68, 249, 255));
//        Style --------------------------->


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.BTN_Pay)) { //Button Pay
            Pay UI = new Pay();
            UI.init();
            fr.dispose();
        } else if (e.getSource().equals(this.BTN_Add_Payment)) { //Button Add Payment
            AddPayment UI = new AddPayment();
            UI.init();
            fr.dispose();
        } else if (e.getSource().equals(this.BTN_Withdraw)) { //Button Withdraw
            Withdraw UI = new Withdraw();
            UI.init();
            fr.dispose();
        } else if (e.getSource().equals(this.BTN_Log)) { //Button See log
            Log UI = new Log();
            UI.init();
        } else if (e.getSource().equals(this.BTN_Add)) { //Button Add
            if(new PopUp("Are you sure", "confirm").question()){
                if(Post.addUser(SID_Field.getText(), First_Name_Field.getText(), Last_Name_Field.getText())){
                    //Added
                    refresh();
                } else {
                    // Can't Add
                    new PopUp("Already have this student","Can't Add").error();
                }
            }
        } else if (e.getSource().equals(this.BTN_Update)) { //Button Update
            if(new PopUp("Are you sure", "confirm").question()){
                if(Update.updateUser(SID_Field.getText(), First_Name_Field.getText(), Last_Name_Field.getText())){
                    //Updated
                    refresh();
                } else {
                    // Can't Update
                    new PopUp("Student not found","Can't Update").error();
                }
            }
        } else if (e.getSource().equals(this.BTN_Delete)) { //Button Delete
            if(new PopUp("Are you sure", "confirm").question()){
                if(Delete.deleteUser(SID_Field.getText())){
                    //Deleted
                    refresh();
                } else {
                    // Can't Delete
                    new PopUp("Student not found","Can't Delete").error();
                }
            }
        }
    }

    public void addData(int SID, String FN, String LN, double AM, String crateAt, String updateAt) { // Add Data to Table
        model.addRow(new Object[] {SID, FN, LN, AM, crateAt, updateAt});
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
                Integer.parseInt((String) data.get("SID")),
                (String) data.get("firstName"),
                (String) data.get("lastName"),
                Double.parseDouble((String) data.get("amount")),
                (String) data.get("createAt"),
                (String) data.get("updateAt")
            );
        }

        // get data
        Get data = new Get();
        Map<String, Object> currentdata = data.getByCollectionAndDocumentName("Statistics", "amount");
        Amount_Student.setText(currentdata.get("student") + "");
        Amount_Money.setText(currentdata.get("money") + "");
        Amount_Debt.setText(currentdata.get("debt") + "");
    }

    public void refresh() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        preload();
    }
}
