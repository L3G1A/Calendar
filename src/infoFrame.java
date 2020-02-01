import javax.swing.JFrame;

public class infoFrame extends JFrame{
	
	public static void infoFrame(int month, int year, int day) {
		

        JFrame infoFrame = new JFrame();
        infoFrame.setSize(200,200);

        infoFrame.getContentPane().add(new calendarBoxInfo(month, day, year));

        
        infoFrame.setVisible(true);

	}
	


	
}