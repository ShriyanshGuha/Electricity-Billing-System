package EBS;
import java.awt.*;
import javax.swing.*;
public class HomePage extends JFrame {
    JFrame f;
    
    HomePage()
    {
        try
        {    
        f = new JFrame("Admin Page");
        f.setSize(1200,690);
        f.setLocation(200,100);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
    


