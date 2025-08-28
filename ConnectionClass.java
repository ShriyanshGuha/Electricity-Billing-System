package EBS;
import java.sql.*;
public class ConnectionClass 
{
    Connection con;
    Statement st;
    ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill","root","200305");
            st = con.createStatement();
            /*if(con.isClosed())
            {
                System.out.println("Noooooo");
            }
            else
            {
                System.out.println("Yes!!");
            }*/
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
