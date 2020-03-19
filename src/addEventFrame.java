import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class addEventFrame extends JFrame{


    private static JLabel instructions;
    private static JComboBox<String> startTime;
    private static JComboBox<String> endTime;
    private static JComboBox<String> category;
    private static JTextField title;
    private static JTextField description;
    private static JTextField instructionField;
    private static JTextField frequency;
    private static JButton saveButton;
    private static JButton cancelButton;
    private static JCheckBox event;
    private static JCheckBox activity;

	public static void infoFrame(int month, int year, int day) {

        JFrame addEventFrame = new JFrame();
        addEventFrame.setSize(200,200);

        /*
        This frame is going to have 2 parts, a text dropdown will determine the jframe
        The text dropdown will select from either add Event or add activity
        Event has a title, description, Start time, end time, catagory color, and frequency
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

        instructions = new JLabel("Please specify the following: ");
        String[] time = {"0100", "0200", "0300", "0400", "0500", "0500", "0600", "0700", "0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300", "2400"};
        startTime = new JComboBox<String>(time); // set the start time (Military clock 0-24)
        endTime = new JComboBox<String>(time); // Sets the end time (Military clock 0-24)
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        category = new JComboBox<String>(color); // set the color
        title = new JTextField(50);
        description = new JTextField(50);
        instructionField = new JTextField(50);
        frequency = new JTextField(50);
        saveButton = new JButton("Save Event");
        cancelButton = new JButton("Cancel Event");
        ActionListener saveListener = new SaveButtonListener();
        saveButton.addActionListener(saveListener);
        ActionListener cancelListener = new CancelButtonListener();
        cancelButton.addActionListener(cancelListener);

        //check box
        event = new JCheckBox("Event");
        activity = new JCheckBox("Activity");

        JPanel panel = new JPanel();
        panel.add(instructions);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(title);
        panel.add(description);
        panel.add(instructionField);
        panel.add(frequency);
        panel.add(event);
        panel.add(saveButton);
        panel.add(cancelButton);

        




        //This right here is how you add to the sql database when the save button is pressed.
        //Do not uncomment until we create a few more tables in sql
        //addToDataBase(name, month, year, day, catColor, frequency);
        addEventFrame.setVisible(true);
	}

	static class SaveButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent click){
            // close the frame, but not the program on click
            //the parameter e of the type ActionEvent refer to the
            //actual click
            List<String> choice = new ArrayList<String>();
            if(event.isSelected()){
                choice.add("Event");
            }
            if(activity.isSelected()){
                choice.add("Activity");
            }
            infoFrame frame = new infoFrame();

            //
            Component b = (Component) click.getSource();

            //this is getting the frame that contains the button
            JFrame c = (JFrame) SwingUtilities.getRoot(b);

            //setting visibility false
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