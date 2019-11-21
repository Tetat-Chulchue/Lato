package UI;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mycompany.lato.model.Log;
import com.mycompany.lato.query.Get;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddPayment implements ActionListener {
    private int winW = 491;
    private int winH = 419;

    private JFrame fr;
    private JPanel Forms_Container, Forms_Top, Forms_Bottom, BTN_Container;
    private JTextArea Description;
    private JTextField Amount;
    private JLabel Amount_Text, Description_Text;
    private JButton BTN_Confirm, BTN_Cancel;
    private JScrollPane scrollPane;
    private String timestamp;

    public void init() {
        fr = new JFrame("Add Payment");
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation(dim.width/2-winW/2, dim.height/2-winH/2);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setResizable(true);
        fr.setVisible(true);
        fr.pack();

//        Listener --------------------------->
        BTN_Cancel.addActionListener(this);
        BTN_Confirm.addActionListener(this);
//        Listener --------------------------->

//        Style --------------------------->
        Forms_Container.setBackground(new Color(0, 53, 84));
        Forms_Top.setBackground(new Color(0, 53, 84));
        Forms_Bottom.setBackground(new Color(0, 53, 84));
        BTN_Container.setBackground(new Color(0, 53, 84));

        Amount_Text.setForeground(new Color(68, 249, 255));
        Description_Text.setForeground(new Color(68, 249, 255));

        Amount.setBackground(new Color(96, 106, 106));
        Amount.setForeground(new Color(68, 249, 255));
        Description.setBackground(new Color(96, 106, 106));
        Description.setForeground(new Color(68, 249, 255));

        BTN_Confirm.setBackground(new Color(87, 255, 68));
        BTN_Confirm.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Cancel.setBackground(new Color(255, 106, 68));
        BTN_Cancel.setFont(new Font("SansSerif", Font.PLAIN, 20));
//        Style --------------------------->
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BTN_Confirm)) { //Button Confirm
            int amount = Integer.parseInt(Amount.getText());
            String description = Description.getText();

            boolean confirm = new PopUp("Are you sure", "confirm").question();
            try {
                if(confirm) {
                    Firestore db = FirestoreClient.getFirestore();
                    Date date = new Date(System.currentTimeMillis());
                    Get data = new Get();
                    Get allUsers = new Get();
                    ArrayList rowUserDatas = allUsers.getAll();
                    for (int i = 0; i < rowUserDatas.size();i++){
                        HashMap userdata = new HashMap();
                        String rows = rowUserDatas.get(i) + "";
                        String[] pairs = rows.split(", ");
                        for (int j = 0; j < pairs.length; j++){
                            userdata.put(
                                    pairs[j].split("=")[0].replace("{", "").replace("}", ""),
                                    pairs[j].split("=")[1].replace("{", "").replace("}", "")
                            );
                        }
//                        System.out.println("First data : " + userdata);
                        Double alldebt = Double.parseDouble(userdata.get("amount") + "") + amount;
                        DocumentReference allAmount = db.collection("Users").document(String.valueOf(userdata.get("uuid")));
                        ApiFuture<WriteResult> allUpdate = allAmount.update("amount", alldebt);
                        ApiFuture<WriteResult> writeDate = allAmount.update("updateAt", date);
//                        System.out.println("After Update : " + userdata);
                    }

                    Map<String, Object> currentdata = data.getByCollectionAndDocumentName("Statistics", "amount");
                    Double debt = Double.parseDouble((currentdata.get("debt") + "")) + amount;

                    DocumentReference currentAmount = db.collection("Statistics").document("amount");
                    ApiFuture<WriteResult> writeResult = currentAmount.update("debt", debt);
                    ApiFuture<WriteResult> writeDate = currentAmount.update("updateAt", date);
                    new Log(TreasurerLogin.currentUser.getStudentId(), "-", description, amount);
                    new TreasurerDashboard().init();
                    fr.dispose();
                }
            }catch (IndexOutOfBoundsException ex){
                new PopUp("This SID is not in database.", "Payment fail.").error();
                ex.printStackTrace();
            }
            // NP
        } else if (e.getSource().equals(BTN_Cancel)) { //Button Cancel
            new TreasurerDashboard().init();
            fr.dispose();
        }
    }
}
