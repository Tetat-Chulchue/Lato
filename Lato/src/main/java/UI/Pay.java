package UI;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mycompany.lato.model.Log;
import com.mycompany.lato.query.Get;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Pay implements ActionListener {
    private int winW = 491;
    private int winH = 419;

    private JFrame fr;
    private JPanel BTN_Panel,
            Forms_Panel_Container,
            Forms_Panel_Top,
            Forms_Panel_Button,
            Forms_Panel_Top_Left,
            Forms_Panel_Top_Right
        ;
    private JButton BTN_Confirm, BTN_Cancel;
    private JTextField SID, Amount;
    private JTextArea Description;
    private JLabel SID_Text, Amount_Text, Description_Text;
    private JScrollPane scrollPane;

    public void init() {
        fr = new JFrame("Pay");
        BTN_Panel = new JPanel();
        Forms_Panel_Container = new JPanel();
        Forms_Panel_Top = new JPanel();
        Forms_Panel_Button = new JPanel();
        Forms_Panel_Top_Left = new JPanel();
        Forms_Panel_Top_Right = new JPanel();
        BTN_Confirm = new JButton("Confirm");
        BTN_Cancel = new JButton("Cancel");
        SID = new JTextField();
        Amount = new JTextField();
        Description = new JTextArea("");
        SID_Text = new JLabel("** SID **");
        Amount_Text = new JLabel("Amount");
        Description_Text = new JLabel("Description");
        scrollPane = new JScrollPane(Description);

        Forms_Panel_Container.setLayout(new BorderLayout());
        Forms_Panel_Top.setLayout(new GridLayout(1, 2));
        Forms_Panel_Top_Left.setLayout(new BorderLayout());
        Forms_Panel_Top_Left.add(SID_Text, BorderLayout.NORTH);
        Forms_Panel_Top_Left.add(SID, BorderLayout.CENTER);
        Forms_Panel_Top.add(Forms_Panel_Top_Left);
        Forms_Panel_Top_Right.setLayout(new BorderLayout());
        Forms_Panel_Top_Right.add(Amount_Text, BorderLayout.NORTH);
        Forms_Panel_Top_Right.add(Amount, BorderLayout.CENTER);
        Forms_Panel_Top.add(Forms_Panel_Top_Right);
        Forms_Panel_Container.add(Forms_Panel_Top, BorderLayout.NORTH);
        Forms_Panel_Button.setLayout(new BorderLayout());
        Forms_Panel_Button.add(Description_Text, BorderLayout.NORTH);
        Forms_Panel_Button.add(scrollPane, BorderLayout.CENTER);
        Forms_Panel_Container.add(Forms_Panel_Button, BorderLayout.CENTER);

        BTN_Panel.setLayout(new GridLayout(1, 2));
        BTN_Panel.add(BTN_Confirm);
        BTN_Panel.add(BTN_Cancel);

        fr.setLayout(new BorderLayout());
        fr.add(Forms_Panel_Container, BorderLayout.CENTER);
        fr.add(BTN_Panel, BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation(dim.width/2-winW/2, dim.height/2-winH/2);
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Confirm.addActionListener(this);
        BTN_Cancel.addActionListener(this);
//        BTN Listener --------------------------->

//        Style --------------------------->
        BTN_Panel.setBackground(new Color(0, 53, 84));
        Forms_Panel_Container.setBackground(new Color(0, 53, 84));
        Forms_Panel_Top.setBackground(new Color(0, 53, 84));
        Forms_Panel_Button.setBackground(new Color(0, 53, 84));
        Forms_Panel_Top_Left.setBackground(new Color(0, 53, 84));
        Forms_Panel_Top_Right.setBackground(new Color(0, 53, 84));

        SID_Text.setForeground(new Color(20, 255, 247));
        Amount_Text.setForeground(new Color(20, 255, 247));
        Description_Text.setForeground(new Color(20, 255, 247));

        SID.setBackground(new Color(96, 106, 106));
        SID.setForeground(new Color(20, 255, 247));
        Amount.setBackground(new Color(96, 106, 106));
        Amount.setForeground(new Color(20, 255, 247));
        Description.setBackground(new Color(96, 106, 106));
        Description.setForeground(new Color(20, 255, 247));

        BTN_Confirm.setBackground(new Color(87, 255, 68));
        BTN_Confirm.setFont(new Font("SansSerif", Font.PLAIN, 20));
        BTN_Cancel.setBackground(new Color(255, 66, 54));
        BTN_Cancel.setFont(new Font("SansSerif", Font.PLAIN, 20));
//        Style --------------------------->
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BTN_Confirm)) { //Button Confirm

            String sid = SID.getText();
            String description = Description.getText();
            int amount = Integer.parseInt(Amount.getText());

            boolean confirm = new PopUp("Are you sure", "confirm").question();

            try {
                if (confirm) {
                    HashMap user = Get.getBySid(sid);
                    double debt = Double.parseDouble((user.get("amount").toString())) - amount;

                    Firestore db = FirestoreClient.getFirestore();
                    DocumentReference userRef = db.collection("Users").document(String.valueOf(user.get("uuid")));
                    ApiFuture<WriteResult> future = userRef.update("amount", debt);
                    new Log(TreasurerLogin.currentUser.getStudentId(), sid, description, amount);
                    new TreasurerDashboard().init();
                    fr.dispose();
                }
            } catch (IndexOutOfBoundsException ex) {
                new PopUp("This SID is not in database.", "Payment fail.").error();
                ex.printStackTrace();
            }
        } else if (e.getSource().equals(BTN_Cancel)) { //Button Cancel
            new TreasurerDashboard().init();
            fr.dispose();
        }
    }
}
