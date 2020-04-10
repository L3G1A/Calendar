import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.awt.event.*;

public class activityFrame {
    private static JFrame addEventFrame;
    private static JFrame addActivityFrame;
    private static JLabel instructions;
    private static JLabel instruction2;
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
        instructions = new JLabel("Add Title");
        title = new JTextField(50);
        String[] color = {"Blue", "Red", "Green", "Yellow"};
        category = new JComboBox<String>(color); // set the color
        instruction2 = new JLabel("Enter Frequency (Integer only)");
        frequency = new JTextField(50);
        saveButton = new JButton("Save Activity");
        cancelButton = new JButton("Cancel");
        ActionListener saveListener = new SaveButtonListener();
        saveButton.addActionListener(saveListener);
        ActionListener cancelListener = new CancelButtonListener();

        JPanel panel = new JPanel();
        panel.add(instructions);
        panel.add(title);
        panel.add(category);
        panel.add(instruction2);
        panel.add(frequency);
        panel.add(saveButton);
        panel.add(cancelButton);

        addEventFrame.add(panel);
        addEventFrame.setVisible(true);

    }

    class SaveButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent click){
            List<String> choice = new ArrayList<String>();
            if(saveButton.isSelected()){
                choice.add("Saved");
            }
            Component b = (Component) click.getSource();
            JFrame c = (JFrame) SwingUtilities.getRoot(b);
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
