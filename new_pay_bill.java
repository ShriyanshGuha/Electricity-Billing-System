package EBS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class new_pay_bill extends JFrame implements ActionListener {

    Choice cMeter, cMonth;
    JTextField tfUnits;
    JButton bPay, bCancel;

    public new_pay_bill() {
        setTitle("Pay Bill");
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // NORTH: Heading
        JLabel heading = new JLabel("Calculate Electricity Bill", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 22));
        add(heading, BorderLayout.NORTH);

        // --- CENTER PANEL (Image + Form side by side) ---
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // LEFT: Image (smaller now)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bill.png")); // adjust path
        Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setHorizontalAlignment(JLabel.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(image, BorderLayout.CENTER);

        // RIGHT: Form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 20));
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        Font labelFont = new Font("SansSerif", Font.BOLD, 18); // bigger labels
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);

        // Meter No
        JLabel lblMeter = new JLabel("Meter No");
        lblMeter.setFont(labelFont);
        cMeter = new Choice();
        cMeter.setFont(fieldFont);
        cMeter.setPreferredSize(new Dimension(200, 35));
        populateMeterNo(); // fill from addcustomer

        // Month
        JLabel lblMonth = new JLabel("Month");
        lblMonth.setFont(labelFont);
        cMonth = new Choice();
        cMonth.setFont(fieldFont);
        cMonth.setPreferredSize(new Dimension(200, 35));
        String[] months = {"January","February","March","April","May","June",
                           "July","August","September","October","November","December"};
        for (String m : months) cMonth.add(m);

        // Units
        JLabel lblUnits = new JLabel("Units Consumed");
        lblUnits.setFont(labelFont);
        tfUnits = new JTextField();
        tfUnits.setFont(fieldFont);
        tfUnits.setPreferredSize(new Dimension(200, 35));

        // Buttons
        bPay = new JButton("Pay Bill");
        bPay.setBackground(Color.GREEN);
        bPay.setForeground(Color.BLACK);
        bPay.setFont(new Font("SansSerif", Font.BOLD, 16));
        bPay.addActionListener(this);

        bCancel = new JButton("Cancel");
        bCancel.setBackground(Color.LIGHT_GRAY);
        bCancel.setFont(new Font("SansSerif", Font.BOLD, 16));
        bCancel.addActionListener(this);

        // Add to Form Grid
        formPanel.add(lblMeter); formPanel.add(cMeter);
        formPanel.add(lblMonth); formPanel.add(cMonth);
        formPanel.add(lblUnits); formPanel.add(tfUnits);
        formPanel.add(bPay); formPanel.add(bCancel);

        // Add image + form to centerPanel
        centerPanel.add(imagePanel);
        centerPanel.add(formPanel);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Populate Meter Numbers from addcustomer table
    private void populateMeterNo() {
        try {
            ConnectionClass c = new ConnectionClass();
            ResultSet rs = c.st.executeQuery("SELECT meterno FROM addcustomer");
            while (rs.next()) {
                cMeter.add(rs.getString("meterno"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching meters: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCancel) {
            dispose();
        } else if (e.getSource() == bPay) {
            String meterno = cMeter.getSelectedItem();
            String month = cMonth.getSelectedItem();
            String unitsStr = tfUnits.getText();

            if (unitsStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter units consumed.");
                return;
            }

            try {
                int units = Integer.parseInt(unitsStr);

                // Calculate amount
                int amount = (units * 7) + 98 + 42 + 112 + 48;

                // Insert into DB
                ConnectionClass c = new ConnectionClass();
                String query = "INSERT INTO bill (meterno, month, units, amount) " +
                               "VALUES ('" + meterno + "', '" + month + "', '" + units + "', '" + amount + "')";
                c.st.executeUpdate(query);

                JOptionPane.showMessageDialog(this,
                        "Bill Added to Database\nAmount Payable: ₹" + amount);

                tfUnits.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for units.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new new_pay_bill();
    }
}
