import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class activityFrame extends JFrame {
    private static JFrame addEventFrame;
    private static JFrame addActivityFrame;
    private static JLabel instructions, instruction2, instruction3;
    private static JComboBox<String> category;
    private static JTextField title;
    private static JTextField frequency;
    private static JButton saveButton;
    private static JButton cancelButton;



    public activityFrame(JFrame addEventFrame){
        this.addEventFrame = addEventFrame;
        activityFrameGUI();
    }

    private void activityFrameGUI(){
        //create frame
        addActivityFrame = new JFrame();
        addActivityFrame.setSize(200,200);

        //instruction to add title
        instructions = new JLabel("Add Title:");
        title = new JTextField(50);
        instruction2 = new JLabel("Color:");
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        category = new JComboBox<String>(color); // set the color
        instruction3 = new JLabel("Enter Frequency:");
        frequency = new JTextField(50);

        saveButton = new JButton("Save Activity");
        ActionListener saveListener = new activityFrame.SaveButtonListener();
        saveButton.addActionListener(saveListener);

        cancelButton = new JButton("Cancel");
        ActionListener cancelListener = new activityFrame .CancelButtonListener();
        cancelButton.addActionListener(cancelListener);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Organizes the frame

        //title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(instructions, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(title, gbc);

        // category
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(instruction2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(category, gbc);

        //Frequency
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(instruction3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(frequency, gbc);


        //save button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(saveButton, gbc);
        // cancel button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        panel.add(cancelButton, gbc);

        addActivityFrame.add(panel);
        addActivityFrame.setVisible(true);

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
        public void actionPerformed(ActionEvent click){
            Component b = (Component) click.getSource();
            JFrame c = (JFrame) SwingUtilities.getRoot(b);
            c.setVisible(false);
        }
    }
}
