package UI;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.mycompany.lato.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Pay implements ActionListener {
    private int winW = 491;
    private int winH = 419;

    private JFrame fr, Other;
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

    public void init(JFrame OtherJF) {
        Other = OtherJF;
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
        fr.setPreferredSize(new Dimension(winW, winH));
        fr.setVisible(true);
//        fr.setResizable(false);
        fr.pack();

//        BTN Listener --------------------------->
        BTN_Confirm.addActionListener(this);
        BTN_Cancel.addActionListener(this);
//        BTN Listener --------------------------->

//        Style --------------------------->
        BTN_Panel.setBackground(new Color(39, 70, 68));
        Forms_Panel_Container.setBackground(new Color(39, 70, 68));
        Forms_Panel_Top.setBackground(new Color(39, 70, 68));
        Forms_Panel_Button.setBackground(new Color(39, 70, 68));
        Forms_Panel_Top_Left.setBackground(new Color(39, 70, 68));
        Forms_Panel_Top_Right.setBackground(new Color(39, 70, 68));

        SID_Text.setForeground(new Color(255, 203, 155));
        Amount_Text.setForeground(new Color(255, 203, 155));
        Description_Text.setForeground(new Color(255, 203, 155));

        SID.setBackground(new Color(96, 106, 106));
        SID.setForeground(new Color(255, 203, 155));
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

            String sid = SID.getText();
            String description = Description.getText();
            int amount = Integer.parseInt(Amount.getText());

            try {
                Init init = new Init();
                Firestore db = init.initializeApp();
                DocumentReference reference = db.collection("Users").document(sid);
                ApiFuture<DocumentSnapshot> snapshot = reference.get();
                DocumentSnapshot document = snapshot.get();
                if (document.exists()) {
                    System.out.println("Document data: " + document.getData());
                } else {
                    System.out.println("Fail to retrieve data");
                    // TODO: Handle not existing SID here ( UI )
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }


            // --------- Next Page ---------

            Confirm UI = new Confirm();
            UI.init(fr);
        } else if (e.getSource().equals(BTN_Cancel)) { //Button Cancel
            Other.setVisible(true);
            fr.dispose();
        }
    }
}
