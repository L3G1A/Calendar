import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class eventFrame extends JFrame {
    private static JFrame addEventFrame;
    private static JLabel instructions, instructions2, instructions3, instructions4, instructions5, instructions6;
    private static JComboBox<String> startTime;
    private static JComboBox<String> endTime;
    private static JComboBox<String> timePeriodST;
    private static JComboBox<String> timePeriodET;
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
        addEventFrame.setSize(275,275);


        instructions = new JLabel("Start time: \n");
        String[] period = {"AM", "PM"};
        String[] time = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00"};
        timePeriodST = new JComboBox<>(period); // option for am or pm start time
        timePeriodET = new JComboBox<>(period); // option for am or pm end time
        startTime = new JComboBox<String>(time); // set the start time
        instructions2 = new JLabel("End time: \n"); // creates a user interface label for text
        endTime = new JComboBox<String>(time); // Sets the end time


        instructions3 = new JLabel("Title:");
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        title = new JTextField(50);
        instructions4 = new JLabel("Color: \n" );
        category = new JComboBox<String>(color); // set the color
        instructions5 = new JLabel("Event Description:");
        description = new JTextField(50);
        instructions6 = new JLabel("Enter Frequency:");
        frequency = new JTextField(50);

        saveButton = new JButton("Save Event");
        ActionListener saveListener = new SaveButtonListener();
        saveButton.addActionListener(saveListener);
        cancelButton = new JButton("Cancel");
        ActionListener cancelListener = new CancelButtonListener();
        cancelButton.addActionListener(cancelListener);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Organizes the frame

        // start time
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(instructions, gbc); // start time label
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(startTime, gbc); // time
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(timePeriodST, gbc); // start time period

        // end time
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(instructions2, gbc); // end time label
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(endTime, gbc); // time
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(timePeriodET, gbc); // end time period

        //title
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(instructions3, gbc); // title label
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(title, gbc); // enter title

        //category
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(instructions4, gbc); // category label
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(category, gbc); // category(color)

        // description
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(instructions5, gbc); // description label
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(description, gbc); // description

        // frequency
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(instructions6, gbc); // frequency label
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(frequency, gbc); // frequency

        //save and cancel
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(saveButton, gbc); // save button
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 0;

        panel.add(cancelButton, gbc); // cancel button

        addEventFrame.add(panel);
        //addEventFrame.pack();
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
