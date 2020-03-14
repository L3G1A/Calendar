import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public class infoFrame extends JFrame{

	public static void infoFrame(int month, int year, int day) {
		ArrayList<clicableObject> objectsOnScreen = new ArrayList<clicableObject>();


        JFrame infoFrame = new JFrame();
        infoFrame.setSize(300,1200);

        infoFrame.getContentPane().add(new calendarBoxInfo(month, day, year));



		objectsOnScreen.add(new clicableObject(150,  5,  55,  30, "addItemPlus"));

        infoFrame.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		int clickx = e.getX();
        		int clicky = e.getY();

  
        		for(int i = 0; i < objectsOnScreen.size(); i++) {
        			if(objectsOnScreen.get(i).checkClick(clickx, clicky) == true) {
        				if(objectsOnScreen.get(i).getName().equals("addItemPlus")) {
        						addEventFrame.infoFrame(month, year, day);
        					
        				}
        			}
        		}
        		
        		
        		
        	}	
        });
        


		infoFrame.setVisible(true);

	}



	
}