
import javax.swing.JFrame;
import java.sql.*;
import java.util.UUID;

public class addEventFrame extends JFrame{

	public static void infoFrame(int month, int year, int day) {


        JFrame addEventFrame = new JFrame();
        addEventFrame.setSize(200,200);
        /*
        This frame is going to have 2 parts, a text dropdown will determine the jframe
        The text dropdown will select from either add Event or add activity
        Event has a title description Start time, end time, catagory color and frequency
            Start time and end time should be a dropdown to select from hours 0-23(make it 24 hour time for ease)
            Title is a text box
            Descirption is a larger text field
            Catagory color is a text drop down that has 4 colors, blue red green yellow
            Frequency is a text box that only accepts integers
        Activity has a name, catColor, frequency
            Stuff is the same
        At the bottom there is a save button and a cancel button, save button runs the addToDataBase function and closes the frame
        The cancel button closes the frame without saving any data to the database

           */














        
        //This right here is how you add to the sql database when the save button is pressed.
        //Do not uncoment until we create a few more tables in sql
        //addToDataBase(name, month, year, day, catColor, frequency);
        addEventFrame.setVisible(true);

	}

	public void addToDatabase(String name, int month, int year, int day, String catColor, String frequency){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://freezersports.com:3306/freezers_project","freezers_root","test123");
            Statement stmt=con.createStatement();
            String uniqueID = UUID.randomUUID().toString();
            String users_ID = "1";
            String query = "INSERT INTO activities (" +  uniqueID + ", "+ users_ID+ ", " + name +"," + Integer.toString(month) + "," + Integer.toString(day) + "," + Integer.toString(year) +  ", 1 ," + catColor + "," + frequency + ")";
            System.out.println("Checking for Activies");
            ResultSet rs=stmt.executeQuery(query);

        }catch(Exception e){ System.out.println(e);}
    }


	
}