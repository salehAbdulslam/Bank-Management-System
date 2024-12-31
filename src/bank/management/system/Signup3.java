package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;

        // إنشاء عنوان النافذة
        setTitle("Signup Page 3 - Account Details");

        // إنشاء Panel رئيسي قابل للتمرير
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(215, 252, 252));
        mainPanel.setPreferredSize(new Dimension(850, 850));

        // إضافة العناصر إلى الـ Panel
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        mainPanel.add(l1);

        JLabel l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        mainPanel.add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(100, 180, 200, 30);
        mainPanel.add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(350, 180, 250, 30);
        mainPanel.add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(100, 220, 200, 30);
        mainPanel.add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(350, 220, 250, 30);
        mainPanel.add(r4);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        JLabel l3 = new JLabel("Services Required:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 450, 200, 30);
        mainPanel.add(l3);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(215, 252, 252));
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        mainPanel.add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215, 252, 252));
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        mainPanel.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215, 252, 252));
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        mainPanel.add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(215, 252, 252));
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        mainPanel.add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215, 252, 252));
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        mainPanel.add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(215, 252, 252));
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        mainPanel.add(c6);

        c7 = new JCheckBox("I hereby declare that the details are correct to the best of my knowledge.", true);
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 650, 600, 30);
        mainPanel.add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        mainPanel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        mainPanel.add(cancel);

        // إضافة ScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        setSize(850, 800);
        setLocation(350, 10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            String facilities = "";
            if (c1.isSelected()) facilities += "ATM CARD, ";
            if (c2.isSelected()) facilities += "Internet Banking, ";
            if (c3.isSelected()) facilities += "Mobile Banking, ";
            if (c4.isSelected()) facilities += "EMAIL Alerts, ";
            if (c5.isSelected()) facilities += "Cheque Book, ";
            if (c6.isSelected()) facilities += "E-Statement, ";

            Random random = new Random();
            String cardNumber = "" + Math.abs(random.nextLong() % 9000000000000000L + 1000000000000000L);
            String pin = "" + Math.abs(random.nextInt(9000) + 1000);

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Please select an account type.");
                } else {
                    Connn c = new Connn();
                    String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pin + "', '" + facilities + "')";
                    String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardNumber + "', '" + pin + "')";
                    c.statement.executeUpdate(query1);
                    c.statement.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pin);
                    setVisible(false);
                    new Deposit(pin);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}