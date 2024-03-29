package UI;

import com.mycompany.lato.query.Get;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDashboard implements ActionListener {
    private int winW = 1396;
    private int winH = 885;
    private String[] columnName = {
//            "No.",
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
            Infor_Forms_Buttom_Left,
            Infor_Forms_Buttom_Right
                    ;
    private JLabel Amount_Student,
            Amount_Money,
            Amount_Debt,
            Amount_Student_Text,
            Amount_Money_Text,
            Amount_Debt_Text;
    private JButton  BTN_Log;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    public void init() {
        fr = new JFrame("User Dashboard");

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

        BTN_Log = new JButton("Log");

        Infor_Forms = new JPanel();
        Infor_Forms_Top = new JPanel();
        Infor_Forms_Buttom = new JPanel();
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
        Bar.setLocation((fr.getWidth()/2)-(Bar.getWidth()/2),0);
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
        Bar_BTN_Button.add(BTN_Log);

        Bar_Forms.setLayout(new BorderLayout());
        Infor_Forms.setLayout(new GridLayout(2, 1));
        Infor_Forms_Top.setLayout(new GridLayout(2, 1));
        Infor_Forms.add(Infor_Forms_Top);
        Infor_Forms_Buttom.setLayout(new GridLayout(1, 2));
        Infor_Forms_Buttom_Left.setLayout(new GridLayout(2, 1));
        Infor_Forms_Buttom.add(Infor_Forms_Buttom_Left);
        Infor_Forms_Buttom_Right.setLayout(new GridLayout(2, 1));
        Infor_Forms_Buttom.add(Infor_Forms_Buttom_Right);
        Infor_Forms.add(Infor_Forms_Buttom);
        Bar_Forms.add(Infor_Forms, BorderLayout.CENTER);

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
        fr.setIconImage(new ImageIcon("icon.png").getImage());
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Log.addActionListener(this);

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


        BTN_Log.setBackground(new Color(68, 118, 255));
        BTN_Log.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Log.setForeground(new Color(0, 53, 84));

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
        if (e.getSource().equals(this.BTN_Log)) { //Button See log
            Log UI = new Log();
            UI.init();
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
}
