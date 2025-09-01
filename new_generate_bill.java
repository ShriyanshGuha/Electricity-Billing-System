package EBS;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class new_generate_bill extends JFrame {

    JTextArea area;
    JScrollPane pane;

    public new_generate_bill(String meterNo, String month) {
        setTitle("Generated Bill");
        setSize(600, 700);
        setLocation(400, 50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        area.setEditable(false);

        pane = new JScrollPane(area);
        add(pane);

        generateBill(meterNo, month);
        setVisible(true);
    }

    public void generateBill(String meterNo, String month) {
        try {
            ConnectionClass obj = new ConnectionClass();

            ResultSet rs1 = obj.st.executeQuery("SELECT * FROM addcustomer WHERE meterno='" + meterNo + "'");
            ResultSet rs2 = obj.st.executeQuery("SELECT * FROM bill WHERE meterno='" + meterNo + "' AND month='" + month + "'");

            area.setText("********** Electricity Bill **********\n\n");
            if (rs1.next()) {
                area.append("Customer Name : " + rs1.getString("name") + "\n");
                area.append("Meter Number  : " + rs1.getString("meterno") + "\n");
                area.append("Address       : " + rs1.getString("address") + "\n");
                area.append("City          : " + rs1.getString("city") + "\n");
                area.append("State         : " + rs1.getString("state") + "\n");
                area.append("Email         : " + rs1.getString("email") + "\n");
                area.append("Phone Number  : " + rs1.getString("phoneno") + "\n");
                area.append("----------------------------------------\n\n");
            }

            if (rs2.next()) {
                area.append("Month         : " + rs2.getString("month") + "\n");
                area.append("Units Used    : " + rs2.getString("units") + "\n");
                area.append("Amount        : " + rs2.getString("amount") + "\n");
                area.append("----------------------------------------\n");
            } else {
                area.append("⚠ No bill found for " + month + "\n");
            }

            area.append("\n********** Thank You **********");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
