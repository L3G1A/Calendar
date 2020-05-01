import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class addEventFrame extends JFrame{

    private static JFrame addEventFrame;
    private static JLabel instructions;
    private static JButton saveButton;
    private static JButton cancelButton;
    private static JButton event;
    private static JButton activity;

    public static void infoFrame(int month, int year, int day) {

        JFrame addEventFrame = new JFrame();
        addEventFrame.setSize(400,200);



        /*
        This frame is going to have 2 parts, a text dropdown will determine the jframe
        The text dropdown will select from either add Event or add activity
        Event has a title description, Start time, end time, catagory color, and frequency
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
        // Check box
        instructions = new JLabel("Please specify the following action you would like \n\n");
        event = new JButton("Create Event");
        activity = new JButton("Create Activity");

        // create the button for both add activity and event which saves
        ActionListener saveListener = new SaveButtonListener();
        event.addActionListener(saveListener);
        activity.addActionListener(saveListener);
        ActionListener closeListener = new CancelButtonListener();

        //close listener for event and activity
        event.addActionListener(closeListener);
        activity.addActionListener(closeListener);

        JPanel panel = new JPanel();
        panel.add(instructions);
        panel.add(activity);
        panel.add(event);
        addEventFrame.add(panel);


        //This right here is how you add to the sql database when the save button is pressed.
        //Do not uncomment until we create a few more tables in sql
        //addToDataBase(name, month, year, day, catColor, frequency);
        addEventFrame.setVisible(true);
    }

    static class SaveButtonListener implements ActionListener{


        private JFrame addEventFrame;
        private JFrame addActivityFrame;

        public void actionPerformed (ActionEvent click){
            if (click.getSource() == event) {
                //addEventFrame.getContentPane().removeAll();
                eventFrame frame = new eventFrame(this.addEventFrame);

            }
            else if (click.getSource() == activity){

                //addEventFrame.getContentPane().removeAll();
                activityFrame frame = new activityFrame(this.addActivityFrame);

            }

            Component b = (Component) click.getSource();

            JFrame c = (JFrame) SwingUtilities.getRoot(b);

            c.setVisible(false);
        }
    }

    static class CancelButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent click){
            // close the frame, but not the program on click
            //the parameter e of the type ActionEvent refer to the
            //actual click
            Component b = (Component) click.getSource();

            // this will get the frame that contains the button
            JFrame c = (JFrame) SwingUtilities.getRoot(b);

            //setting visibility to false
            c.setVisible(false);
        }
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