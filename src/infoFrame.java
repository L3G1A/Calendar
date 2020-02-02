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
        					System.out.println(objectsOnScreen.size());
        					//Here you have to open the add new item frame. the print statement is just there are a placeholder. Make the frame visible and pass the Day Month and Year to the
        					//Frame so you know to which SQL line you are adding it to
        					
        					
        				}
        			}
        		}
        		
        		
        		
        	}	
        });
        
        
        
        infoFrame.setVisible(true);

	}
	


	
}