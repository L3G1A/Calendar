import java.awt.*;
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

		g2D.setStroke(new BasicStroke(2F));
		String[] hours = new String[]{"12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am", "12 pm", "1 pm","2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11 pm"};
		int arrayPos = 0;

		ArrayList<String> events = updateCalendarData.getDayData(Integer.toString(month),Integer.toString(day), Integer.toString(year));
		ArrayList<String> timeEvents = new ArrayList<String>();
		for(int i = 0; i < events.size(); i++){
			String[] current = events.get(i).split(",");
			String timeCheck = current[10];
			if(!(timeCheck.equals("null"))) {
				timeEvents.add(events.get(i));
			}
		}
		for(int i = 0; i < timeEvents.size(); i ++){
			String[] current = timeEvents.get(i).split(",");
			int startHour = Integer.parseInt(current[10]);
			int stopHour = Integer.parseInt(current[15]);
			int startMin = Integer.parseInt(current[11]);
			int stopMin = Integer.parseInt(current[16]);

			int xStart = ((40 + startHour * 40)) + (startMin/6) * 4;

			int xStop = ((40 + stopHour * 40) + (stopMin/6) * 4);
			System.out.println(xStart);
			String rectColor = current[5];

			if(rectColor.equals("Blue")){
				g.setColor(new Color(69, 171, 230));
			}
			if(rectColor.equals("Red")){
				g.setColor(new Color(230, 83, 101));
			}
			if(rectColor.equals("Green")){
				g.setColor(new Color(141, 230, 62));
			}
			if(rectColor.equals("Yellow")){
				g.setColor(new Color(225, 230, 101));
			}

			g.fillRect(xStart, 200, xStop - xStart, 200);



			g.setColor(new Color( 230, 230, 230));


		}
		for(int i = 1; i < 1000; i += 1) {
			if(i % 40 == 0) {
				g.drawString(hours[arrayPos], i, 190);

				g2D.drawLine(i, 200, i, 400);
				arrayPos += 1;
			}

		}


		events = updateCalendarData.getDayData(Integer.toString(month),Integer.toString(day), Integer.toString(year));

		int yPos = 40;
		for(int i = 0; i < events.size(); i++){
			String[] current = events.get(i).split(",");
			String printString = current[2];
			yPos += (20 * i);
			g.drawString(printString, 20, yPos);

		}


	}
    
    
  
    

}


