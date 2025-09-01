package EBS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class new_customer extends JFrame implements ActionListener{
    JFrame f;
    JButton b1, b2;
    JLabel l1, l2, l3 , l4, l5, l6 , l7 , l8 , l9;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    JPanel p1,p2;
    Font f1, f2;

    public new_customer() {
        f = new JFrame("New Customer");
        f.setSize(1000, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f1 = new Font("senserif",Font.BOLD,18);
        f2 = new Font("senserif",Font.BOLD,20);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Customer.png"));
        Image i = img.getImage().getScaledInstance(360, 200, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);

        p1 = new JPanel();
        p2 = new JPanel();
        p1.setLayout(new GridLayout(9,2,10,8));
        p1.setBorder(new EmptyBorder(20, 20, 20, 20));
        p2.setLayout(new GridLayout(1,1));
        

        l1 = new JLabel("Name");
        l2 = new JLabel("Meter Number");
        l3 = new JLabel("Address");
        l4 = new JLabel("State");
        l5 = new JLabel("City");
        l6 = new JLabel("Email");
        l7 = new JLabel("Phone no.");
        l8 = new JLabel("New Customer Details");
        l9 = new JLabel(img1);

        tf1 = new JTextField(15);
        tf2 = new JTextField(15);
        tf3 = new JTextField(15);
        tf4 = new JTextField(15);
        tf5 = new JTextField(15);
        tf6 = new JTextField(15);
        tf7 = new JTextField(15);

        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f2);
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);

        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(tf2);
        p1.add(l3);
        p1.add(tf3);
        p1.add(l4);
        p1.add(tf4);
        p1.add(l5);
        p1.add(tf5);
        p1.add(l6);
        p1.add(tf6);
        p1.add(l7);
        p1.add(tf7);
        p2.add(l9);

        l8.setHorizontalAlignment(JLabel.CENTER);
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        b1.setFont(f1);
        b2.setFont(f1);
        b1.setBackground(Color.black);
        b2.setBackground(Color.black);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.white);
        b1.addActionListener(this);
        b2.addActionListener(this);
        p1.add(b1);
        p1.add(b2);


        f.setLayout(new BorderLayout(30,30));
        f.add(l8,"North");
        f.add(p1,"Center");
        f.add(p2,"West");
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==b1)
        {
            String name = tf1.getText();
            String meterno = tf2.getText();
            String address = tf3.getText();
            String state = tf4.getText();
            String city = tf5.getText();
            String email = tf6.getText();
            String phoneno = tf7.getText();

            try{
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into addcustomer values('"+name+"','"+meterno+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phoneno+"')";
                obj.st.executeUpdate(q);

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Customer was inserted to Database");
            f.setVisible(false);
        }
        if(a.getSource()==b2)
        {
            f.dispose();
        }
    }
    public static void main(String[] args) {
        new new_customer();
    }
}
