import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class eventFrame extends JFrame {
    private static JFrame addEventFrame;
    private static JLabel instructions, instructions2, instructions3, instructions4, instructions5;
    private static JComboBox<String> startTime;
    private static JComboBox<String> endTime;
    private static JComboBox<String> category;
    private static JTextField title;
    private static JTextField description;
    private static JTextField frequency;
    private static JButton saveButton;
    private static JButton cancelButton;

    public eventFrame(JFrame addEventFrame){
        this.addEventFrame = addEventFrame;
        eventFrameGUI();
    }

    private void eventFrameGUI(){
        addEventFrame = new JFrame();
        addEventFrame.setSize(600,400);


        instructions = new JLabel("Start time: \n");
        String[] time = {"0100", "0200", "0300", "0400", "0500", "0500", "0600", "0700", "0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300", "2400"};
        startTime = new JComboBox<String>(time); // set the start time (Military clock 0-24)
        instructions2 = new JLabel("End time: \n");
        endTime = new JComboBox<String>(time); // Sets the end time (Military clock 0-24)
        instructions3 = new JLabel("Title");
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        title = new JTextField(50);
        instructions4 = new JLabel("Color: \n" );
        category = new JComboBox<String>(color); // set the color
        description = new JTextField("Event Description");
        frequency = new JTextField(50);
        saveButton = new JButton("Save Event");
        ActionListener saveListener = new SaveButtonListener();
        saveButton.addActionListener(saveListener);

        cancelButton = new JButton("Cancel");
        ActionListener cancelListener = new CancelButtonListener();
        cancelButton.addActionListener(cancelListener);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,4,2,2)); // Organizes the frame
        panel.add(instructions); // start time
        panel.add(startTime);
        panel.add(instructions2); // end time
        panel.add(endTime);
        panel.add(instructions3); // title
        panel.add(title);
        panel.add(instructions4); // color
        panel.add(category);
        panel.add(description);
        panel.add(frequency);
        panel.add(saveButton);
        panel.add(cancelButton);

        addEventFrame.add(panel);
        addEventFrame.setVisible(true);
    }

    class SaveButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent click){
            // close the frame, but not the program on click
            //the parameter e of the type ActionEvent refer to the
            //actual click
            List<String> choice = new ArrayList<String>();
            if(saveButton.isSelected()){
                choice.add("Saved");
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

    class CancelButtonListener implements ActionListener{
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

}
