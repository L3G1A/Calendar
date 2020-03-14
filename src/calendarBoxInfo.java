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
			String timeCheck = current[3];
			if((timeCheck.equals("1"))) {
				timeEvents.add(events.get(i));
			}
		}
		events = updateCalendarData.getDayData(Integer.toString(month),Integer.toString(day), Integer.toString(year));

		int yPos = 40;
		int eventACounter = 0;
		int eventSizeTop = 0;
		for(int i = 0; i < events.size(); i++){
			String[] current = events.get(i).split(",");
			String printString = current[2];

			String timeCheck = current[3];
			if((timeCheck.equals("0"))) {
				yPos += (20 * i);
				eventACounter += 1;
				g.drawString(printString, 20, yPos);
				eventSizeTop += 20;

			}

		}
		if(eventACounter == 0){
			g.drawString("No Events Today", 20, yPos);
			eventSizeTop += 20;

		}
		for(int i = 0; i < timeEvents.size(); i ++){
			String[] current = timeEvents.get(i).split(",");
			int startHour = Integer.parseInt(current[10]);
			int stopHour = Integer.parseInt(current[16]);
			int startMin = Integer.parseInt(current[11]);
			int stopMin = Integer.parseInt(current[17]);
			String title = current[2];
			String startAP = current[12];
			String stopAP = current[18];

			if(startAP.equals("PM")){
				startHour += 12;
			}
			if(stopAP.equals(("PM"))){
				stopHour += 12;
			}
			int xStart = (((40 + startHour * 40)) + (startMin/6) * 4);

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


			g.fillRect(20, xStart + eventSizeTop, 180, xStop - xStart);



			g.setColor(new Color(0, 0, 0));

			g.setColor(new Color( 230, 230, 230));


		}
		for(int i = 1; i < 1000; i += 1) {
			if (i % 40 == 0) {
				g.drawString(hours[arrayPos], 220, i + eventSizeTop);

				g2D.drawLine(20, i + eventSizeTop, 200, i + eventSizeTop);
				arrayPos += 1;
			}
		}

			for(int i = 0; i < timeEvents.size(); i ++){
				String[] current = timeEvents.get(i).split(",");
				int startHour = Integer.parseInt(current[10]);
				int stopHour = Integer.parseInt(current[16]);
				int startMin = Integer.parseInt(current[11]);
				int stopMin = Integer.parseInt(current[17]);
				String startAP = current[12];
				String stopAP = current[18];

				if(startAP.equals("PM")){
					startHour += 12;
				}
				if(stopAP.equals(("PM"))){
					stopHour += 12;
				}
				String title = current[2];
				int yStart = ((40 + startHour * 40)) + (startMin/6) * 4;

				String rectColor = current[5];

				g.setColor(new Color(0, 0, 0));

				g.drawString(title, 20, yStart + 11 + eventSizeTop);


				g.setColor(new Color( 230, 230, 230));


			}







	}
    
    
  
    

}


