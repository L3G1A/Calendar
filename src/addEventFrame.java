
import javax.swing.JFrame;
import java.sql.*;

public class addEventFrame extends JFrame{

	public static void infoFrame(int month, int year, int day) {


        JFrame addEventFrame = new JFrame();
        addEventFrame.setSize(200,200);


        
        addEventFrame.setVisible(true);

	}

	public void addToDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://freezersports.com:3306/freezers_project","freezers_root","test123");
            Statement stmt=con.createStatement();

            String query = "Test";
            System.out.println("Checking for Activies");
            ResultSet rs=stmt.executeQuery(query);

        }catch(Exception e){ System.out.println(e);}
    }


	
}