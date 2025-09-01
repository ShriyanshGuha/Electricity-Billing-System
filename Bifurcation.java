package EBS;
import java.awt.*;
import javax.swing.*;

public class Bifurcation extends JFrame {

    JTextField tfUnits, tfAmount;

    public Bifurcation() {
        setTitle("Bill Bifurcation");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ---------- Calculator Panel ----------
        JPanel calcPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        tfUnits = new JTextField(10);
        tfAmount = new JTextField(10);
        tfAmount.setEditable(false);
        JButton calcButton = new JButton("Calculate Amount");

        calcButton.addActionListener(e -> calculateAmount());
        calcPanel.add(new JLabel("Units:"));
        calcPanel.add(tfUnits);
        calcPanel.add(calcButton);
        calcPanel.add(new JLabel("Amount:"));
        calcPanel.add(tfAmount);

        add(calcPanel, BorderLayout.NORTH);

        // ---------- Details Section ----------
        JTextArea details = new JTextArea();
        details.setEditable(false);
        details.setFont(new Font("Monospaced", Font.PLAIN, 14));
        details.setText(
            "Bill Calculation Details:\n\n" +
            "1. Cost per unit: ₹7/unit\n" +
            "2. Fixed charges: ₹98 + ₹42 + ₹112 + ₹48\n" +
            "3. Formula: Amount = (Units * 7) + 98 + 42 + 112 + 48\n\n" +
            "Example:\n" +
            "Units = 50\n" +
            "Amount = (50*7) + 98 + 42 + 112 + 48 = ₹650"
        );

        JScrollPane scroll = new JScrollPane(details);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    private void calculateAmount() {
        try {
            int units = Integer.parseInt(tfUnits.getText().trim());
            int amount = (units * 7) + 98 + 42 + 112 + 48;
            tfAmount.setText(String.valueOf(amount));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid number for units.");
        }
    }
}
