package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textName, textFname, textEmail, textAdd, textCity, textState, textPin;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        // Panel for content
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adding components
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(label1, gbc);

        gbc.gridwidth = 1; // Reset width

        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelName, gbc);

        textName = new JTextField();
        gbc.gridx = 1;
        panel.add(textName, gbc);

        JLabel labelFname = new JLabel("Father's Name:");
        labelFname.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelFname, gbc);

        textFname = new JTextField();
        gbc.gridx = 1;
        panel.add(textFname, gbc);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(dobLabel, gbc);

        dateChooser = new JDateChooser();
        gbc.gridx = 1;
        panel.add(dateChooser, gbc);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(genderLabel, gbc);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JPanel genderPanel = new JPanel();
        genderPanel.add(r1);
        genderPanel.add(r2);
        gbc.gridx = 1;
        panel.add(genderPanel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(emailLabel, gbc);

        textEmail = new JTextField();
        gbc.gridx = 1;
        panel.add(textEmail, gbc);

        JLabel maritalLabel = new JLabel("Marital Status:");
        maritalLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(maritalLabel, gbc);

        m1 = new JRadioButton("Married");
        m2 = new JRadioButton("Unmarried");
        m3 = new JRadioButton("Other");
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        JPanel maritalPanel = new JPanel();
        maritalPanel.add(m1);
        maritalPanel.add(m2);
        maritalPanel.add(m3);
        gbc.gridx = 1;
        panel.add(maritalPanel, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(addressLabel, gbc);

        textAdd = new JTextField();
        gbc.gridx = 1;
        panel.add(textAdd, gbc);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(cityLabel, gbc);

        textCity = new JTextField();
        gbc.gridx = 1;
        panel.add(textCity, gbc);

        JLabel pinLabel = new JLabel("Pin Code:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(pinLabel, gbc);

        textPin = new JTextField();
        gbc.gridx = 1;
        panel.add(textPin, gbc);

        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(stateLabel, gbc);

        textState = new JTextField();
        gbc.gridx = 1;
        panel.add(textState, gbc);

        next = new JButton("Next");
        next.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(next, gbc);

        // Add panel to scroll pane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);

        setSize(600, 600); // Window size
        setLocationRelativeTo(null); // Center window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collect data and insert into database
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null;
        String email = textEmail.getText();
        String marital = m1.isSelected() ? "Married" : m2.isSelected() ? "Unmarried" : m3.isSelected() ? "Other" : null;
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            } else {
                // Database connection
                Connn c = new Connn();
                String q = "insert into signup values('" + formno + "', '" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "', '" + address + "', '" + city + "','" + pincode + "','" + state + "')";
                c.statement.executeUpdate(q);

                new Signup2(formno);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}