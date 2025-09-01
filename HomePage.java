package EBS;
import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame {
    JFrame f;
    JLabel l1;
    JPanel sidebar;
    JButton b1, b2, b3, b4;

    HomePage() {
        try {
            f = new JFrame("Admin Page");
            f.setSize(1200, 690);
            f.setLocation(200, 100);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // -------- Background Image --------
            ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/HomePageBkg.jpg"));
            Image ii = i.getImage().getScaledInstance(1200, 690, Image.SCALE_SMOOTH);
            ImageIcon img1 = new ImageIcon(ii);
            l1 = new JLabel(img1);
            l1.setBounds(0, 0, 1200, 690);

            // -------- Sidebar (instead of toolbar) --------
            sidebar = new JPanel();
            sidebar.setLayout(new GridLayout(10, 1, 0, 10));
            sidebar.setBackground(new Color(40, 44, 52));
            sidebar.setPreferredSize(new Dimension(180, f.getHeight()));

            Font font = new Font("Segoe UI", Font.BOLD, 16);

            b1 = createSidebarButton("Customer", font);
            b2 = createSidebarButton("Payment", font);
            b3 = createSidebarButton("Report", font);
            b4 = createSidebarButton("Logout", font);

            sidebar.add(b1);
            sidebar.add(b2);
            sidebar.add(b3);
            sidebar.add(Box.createVerticalGlue());
            sidebar.add(b4);

            // -------- Popup Menus --------
            JPopupMenu customerMenu = new JPopupMenu();
            styleMenu(customerMenu);
            JMenuItem i1 = createMenuItem("New Customer");
            JMenuItem i2 = createMenuItem("Customer Details");
            customerMenu.add(i1);
            customerMenu.add(i2);

            JPopupMenu paymentMenu = new JPopupMenu();
            styleMenu(paymentMenu);
            JMenuItem i3 = createMenuItem("Pay Bill");
            paymentMenu.add(i3);

            JPopupMenu reportMenu = new JPopupMenu();
            styleMenu(reportMenu);
            JMenuItem i4 = createMenuItem("Report");
            reportMenu.add(i4);

            // Show popup on button click
            b1.addActionListener(e -> customerMenu.show(b1, b1.getWidth(), 0));
            b2.addActionListener(e -> paymentMenu.show(b2, b2.getWidth(), 0));
            b3.addActionListener(e -> reportMenu.show(b3, b3.getWidth(), 0));
            b4.addActionListener(e -> f.setVisible(false));

            // -------- Actions --------
            i1.addActionListener(e -> new new_customer());
            i2.addActionListener(e -> new new_details());
            i3.addActionListener(e -> new new_pay_bill());
            i4.addActionListener(e -> new new_report());

            // -------- MenuBar at Top --------
            JMenuBar menubar = new JMenuBar();
            JMenu menu1 = new JMenu("File");
            JMenu menu2 = new JMenu("Edit");
            JMenu menu3 = new JMenu("Help");
            menubar.add(menu1);
            menubar.add(menu2);
            menubar.add(menu3);
            f.setJMenuBar(menubar);

            // -------- Frame Layout --------
            f.setLayout(new BorderLayout());
            f.add(sidebar, BorderLayout.WEST);
            f.add(l1, BorderLayout.CENTER);

            f.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JButton createSidebarButton(String text, Font font) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        btn.setFocusPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(40, 44, 52));
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(12, 20, 12, 10));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(60, 65, 75));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(40, 44, 52));
            }
        });

        return btn;
    }

    private void styleMenu(JPopupMenu menu) {
        menu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        menu.setBackground(Color.WHITE);
        menu.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
    }

    private JMenuItem createMenuItem(String text) {
        JMenuItem item = new JMenuItem(text);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        item.setPreferredSize(new Dimension(180, 35)); // bigger height
        return item;
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
