package UI;

import com.mycompany.lato.query.Get;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Log implements ActionListener {
//    Config ------->
    private int winW = 1000;
    private int winH = 600;
    private String[] columnName = {
//
            "Treasurer ID",
            "Particular",
            "Description",
            "Amount",
            "Timestamp"
    };
//    Config ------->

    private JFrame fr;
    private JPanel Table_Container;
    private JTable Table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private JButton TestAddData;

    public void init() {
        fr = new JFrame("Log");
        Table_Container = new JPanel();
        model = new DefaultTableModel();
        Table = new JTable(model) {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        scrollPane = new JScrollPane(Table);
        TestAddData = new JButton("Add Data");

        model.setColumnIdentifiers(columnName);

        Table_Container.setLayout(new GridLayout(1 ,1));
//        Table_Container.add(TestAddData);
        Table_Container.add(scrollPane);

        fr.setLayout(new GridLayout(1, 1));
        fr.add(Table_Container);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation(dim.width/2-winW/2, dim.height/2-winH/2);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setIconImage(new ImageIcon("icon.png").getImage());
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

        this.preload();

//        TestAddData.addActionListener(this);

//        Style --------------------------->
        Table.getTableHeader().setBackground(new Color(0, 53, 84));
        Table.getTableHeader().setForeground(new Color(20, 255, 247));
        Table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 13));
        Table.setFont(new Font("SansSerif", Font.PLAIN, 15));
        Table.setRowHeight(24);
        Table.setBackground(new Color(0, 53, 84));
        Table.setForeground(new Color(20, 255, 247));
        Table.getColumnModel().getColumn(0).setPreferredWidth(40);
//        Style --------------------------->
    }

    public void addData(String Name, String Particular, String Description, Double Amount, String Timestamp) { // Add Data to Table
        model.addRow(new Object[] {Name, Particular, Description, Amount, Timestamp});
    }

    public void preload() { // Preload Data form Database.
        Get getData = new Get();
        ArrayList rowData = getData.getLog();
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
                    (String) data.get("name"),
                    (String) data.get("particular"),
                    (String) data.get("description"),
                    Double.parseDouble(data.get("amount").toString()),
                    (String) data.get("createAt")
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(TestAddData)) {
            addData("test", "test", "test", 1234.0, "xx-xx-xxxx");
        }
    }
}
