import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class infoFrame extends JFrame{
	
	public static void infoFrame(int month, int year, int day) {
		

        JFrame infoFrame = new JFrame();
        JPanel content = new JPanel();
        infoFrame.setSize(200,200);

        String date = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
        
        JLabel dateDisplay = new JLabel();
        
        dateDisplay.setText(date);
        
        content.add(dateDisplay);
        
        infoFrame.add(content);

        infoFrame.setVisible(true);

	}
	


	
}