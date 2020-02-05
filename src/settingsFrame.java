
import javax.swing.*;

public class settingsFrame extends JFrame{

    public static void settingsFrame() {


        JFrame settingsFrame = new JFrame();
        settingsFrame.setSize(200,200);


        JLabel title = new JLabel();
        title.setText("Settings Frame");
        settingsFrame.add(title);
        settingsFrame.setVisible(true);

    }




}