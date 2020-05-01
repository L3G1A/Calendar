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
        addActivityFrame.setSize(400,400);

        //instruction to add title
        instructions = new JLabel("Add Title:");
        title = new JTextField(50);
        instruction2 = new JLabel("color:");
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        category = new JComboBox<String>(color); // set the color
        instruction3 = new JLabel("Enter Frequency (Integer only):");
        frequency = new JTextField(50);

        saveButton = new JButton("Save Activity");
        ActionListener saveListener = new activityFrame.SaveButtonListener();
        saveButton.addActionListener(saveListener);

        cancelButton = new JButton("Cancel");
        ActionListener cancelListener = new activityFrame .CancelButtonListener();
        cancelButton.addActionListener(cancelListener);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 2, 2));
        panel.add(instructions);
        panel.add(title);
        panel.add(instruction2);
        panel.add(category);
        panel.add(instruction3);
        panel.add(frequency);
        panel.add(saveButton);
        panel.add(cancelButton);

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
