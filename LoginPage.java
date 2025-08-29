package EBS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener 
{
    JFrame f;
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1 ,b2;
    JPanel p1,p2,p3,p4;
    LoginPage()
    {
        f = new JFrame("Login Page");
        f.setSize(400,250);
        f.setResizable(false);
        f.setBackground(Color.lightGray);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocation(600,300);
        f.setLayout(null);
        
        ImageIcon img = new ImageIcon("Lock.png");
        f.setIconImage(img.getImage());
        
        l1 = new JLabel();
        l1.setBounds(40, 50, 100, 100);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Lock.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        l1.setIcon(i3);
        f.add(l1);
        
        l2 = new JLabel("Username");
        l2.setBounds(160,5,100,50);
        l2.setFont(new Font("Arial",Font.BOLD,12));
        f.add(l2);
        
        tf1 = new JTextField(30);
        tf1.setBounds(160,40,170,30);
        f.add(tf1);
        
        l3 = new JLabel("Password");
        l3.setBounds(160,70,100,50);
        l3.setFont(new Font("Arial",Font.BOLD,12));
        f.add(l3);
        
        pf1 = new JPasswordField(20);
        pf1.setBounds(160,105,170,30);
        f.add(pf1);
        
        b1 = new JButton("Login");
        b1.setBounds(150,160,90,30);
        b1.addActionListener(this);
        f.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(250,160,90,30);
        b2.addActionListener(this);
        f.add(b2);
        f.setVisible(true);

        
        
    }
    public static void main(String[] args) {
        new LoginPage();
    }
     public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==b1)
       {
           try
           {
               ConnectionClass obj = new ConnectionClass();
               String username = tf1.getText();
               String password = new String(pf1.getPassword());
               
               
               String q = "select * from customer where username='"+username+"' and password='"+password+"';";
               ResultSet rs =obj.st.executeQuery(q);
               if(rs.next())
               {
                   new HomePage();
                   System.out.println("Login Successful");
                   JOptionPane.showMessageDialog(null,"Login Successful\nWelcome "+username);
                   f.setVisible(false);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "You have entered wrong username and password");
                   
               }
               
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       if(e.getSource()== b2)
       {
           f.setVisible(false);
       }
    }
        
            
            
    
}
