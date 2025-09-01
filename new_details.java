package EBS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class new_details extends JFrame implements ActionListener {

    JTable table;
    JButton closeBtn;
    JPanel panel;

    public new_details() {
        setTitle("Customer Details");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel = new JPanel(new BorderLayout());

        // Table Columns
        String[] columns = {"Name", "Meter No", "Address", "State", "City", "Email", "Phone No"};

        // Table Model
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        fetchCustomerData(model);

        // JTable setup
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Close Button
        closeBtn = new JButton("Close");
        closeBtn.addActionListener(this);
        JPanel btnPanel = new JPanel();
        btnPanel.add(closeBtn);

        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    // Fetch all customer records using connectionclass
    private void fetchCustomerData(DefaultTableModel model) {
        try {
            ConnectionClass c = new ConnectionClass(); // create object
            ResultSet rs = c.st.executeQuery("SELECT * FROM addcustomer");

            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"),
                        rs.getString("meterno"),
                        rs.getString("address"),
                        rs.getString("state"),
                        rs.getString("city"),
                        rs.getString("email"),
                        rs.getString("phoneno")
                };
                model.addRow(row);
            }

            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new new_details();
    }
}
