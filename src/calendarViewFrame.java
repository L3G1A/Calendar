import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class calendarViewFrame extends JFrame{
	
	public static void calendarViewFrame(int month, int year) {
		
		JFrame calendarFrame = new JFrame();
		
	

		calendarFrame.setSize(1000,800);
    
		calendarFrame.getContentPane().add(new calendar(month,year));
		
		calendarFrame.removeAll();
		
		calendarFrame.getContentPane().add(new calendar(1,2019));
		
		calendarFrame.setVisible(true);

	}

	
}
