import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComponent;

public class calendarBoxInfo extends JComponent{
	int month;
	int day;
	int year;
	String date;
	String weekday;

	public calendarBoxInfo(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.date = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		
		int tempDate = calendar.dayofweek(day, month, year);
		
		if(tempDate == 1) {
			this.weekday = "Monday";
		}
		if(tempDate == 2) {
			this.weekday = "Tuesday";
		}
		if(tempDate == 3) {
			this.weekday = "Wensday";
		}
		if(tempDate == 4) {
			this.weekday = "Thursday";
		}
		if(tempDate == 5) {
			this.weekday = "Friday";
		}
		if(tempDate == 6) {
			this.weekday = "Saturday";
		}
		if(tempDate == 0) {
			this.weekday = "Sunday";
		}
	}
	
	
	public void paintComponent(Graphics g) {
    	
    	String fullPrintDate = weekday + " " + date;
    	
        g.drawString(fullPrintDate, 20, 20);

        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setStroke(new BasicStroke(5F));
        
        
        g2D.drawLine(150, 15, 170, 15);
        g2D.drawLine(160, 5, 160, 25);
		ArrayList<String> events = new ArrayList<>();


		int yPos = 40;
		for(int i = 0; i < events.size(); i++){
			String printEventString = Integer.toString(i + 1) + ". " + events.get(i);
			yPos += (20 * i);
			g.drawString(printEventString, 20, yPos);

		}


	}
    
    
  
    

}


