import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class infoFrame extends JFrame{
	public static ArrayList<clicableObject> objectsOnScreen = new ArrayList<clicableObject>();

	public static void infoFrame(int month, int year, int day) {
		

        JFrame infoFrame = new JFrame();
        infoFrame.setSize(200,200);

        infoFrame.getContentPane().add(new calendarBoxInfo(month, day, year));

        objectsOnScreen.add(new clicableObject(150,  5,  40,  40, "addItemPlus"));

        
        infoFrame.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		int clickx = e.getX();
        		int clicky = e.getY();

  
        		for(int i = 0; i < objectsOnScreen.size(); i++) {
        			if(objectsOnScreen.get(i).checkClick(clickx, clicky) == true) {
        				if(objectsOnScreen.get(i).getName().equals("addItemPlus")) {
        					System.out.println("Request to add new item");
        				}
        			}
        		}
        		
        		
        		
        	}	
        });
        
        
        
        infoFrame.setVisible(true);

	}
	


	
}