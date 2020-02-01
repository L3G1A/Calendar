import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class infoFrame extends JFrame{
	
	public static void infoFrame(int month, int year, int day) {
		

        JFrame infoFrame = new JFrame();
        infoFrame.setSize(200,200);

        infoFrame.getContentPane().add(new calendarBoxInfo(month, day, year));

        
        
        infoFrame.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		int clickx = e.getX();
        		int clicky = e.getY();
        		
        		System.out.print(clickx);
        		System.out.print(",");
        		System.out.print(clicky);
        		System.out.println("");
        		System.out.println(calendarBoxInfo.objectsOnScreen.size());
        		for(int i = 0; i < calendarBoxInfo.objectsOnScreen.size(); i++) {
        			if(calendarBoxInfo.objectsOnScreen.get(i).checkClick(clickx, clicky) == true) {
        				if(calendarBoxInfo.objectsOnScreen.get(i).getName().equals("addItemPlus")) {
        					System.out.println("Request to add new item");
        				}
        			}
        		}
        		
        		
        		
        	}	
        });
        
        
        
        infoFrame.setVisible(true);

	}
	


	
}