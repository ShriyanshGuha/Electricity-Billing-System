package EBS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HomePage extends JFrame {
    JFrame f;
    JLabel l1;
    JMenuBar m;
    JMenu m1,m2,m3,m4;
    JMenuItem i1,i2,i3,i4;
    
    HomePage()
    {
        try
        {    
        Font font = new Font("monospace",Font.PLAIN,16);
        f = new JFrame("Admin Page");
        f.setSize(1200,690);
        f.setLocation(200,100);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/HomePageBkg.jpg"));
        Image ii = i.getImage().getScaledInstance(1200,690,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(ii);

        l1 = new JLabel(i);
        l1.setBounds(0,0,1600,690);
        l1.setIcon(img1);
        f.add(l1);
        
        m = new JMenuBar();
        
       m1 = new JMenu("Customer");
        m2= new JMenu("Payment");
        m3 = new JMenu("Report");
        m4 = new JMenu("Logout"); 
        
        i1 = new JMenuItem("New Customer");
        i2 = new JMenuItem("Customer Details");
        i3 = new JMenuItem("Pay Bill");
        i4 = new JMenuItem("Report");
        
        m1.setFont(font);
        m2.setFont(font);
        m3.setFont(font);
        m4.setFont(font);
        
        i1.setMnemonic('D');
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        i1.setBackground(Color.WHITE);
        i1.addActionListener(this);
        
        i2.setMnemonic('M');
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        i2.setBackground(Color.WHITE);
        i2.addActionListener(this);
        
        i3.setMnemonic('P');
        i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        i3.setBackground(Color.WHITE);
        i3.addActionListener(this);
        
        i4.setMnemonic('R');
        i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        i4.setBackground(Color.WHITE);
        i4.addActionListener(this);
        
        m1.add(i1);
        m1.add(i2);
        m2.add(i3);
        m3.add(i4);
        
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        
        // Add MouseListener to Logout menu
        m4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.setVisible(false);
                new LoginPage();
            }
        });
            
        f.setJMenuBar(m);
        f.setFont( new Font("senserif",Font.PLAIN,16));
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new HomePage();
    }
    public void actionPerformed(ActionEvent a)
    {
        String s = a.getActionCommand();
        if(s.equals("New Customer"))
        {
            new new_customer();
            
        }
        else if(s.equals("Customer Details")) // <-- fixed here
        {
             new new_details();
        }
        else if(s.equals("Pay Bill"))
        {
             new new_pay_bill();
        }
        else if(s.equals("Report"))
        {
             new new_report();
        }
        else
        {
            System.out.println("Wrong");
        }
    }
}
    




