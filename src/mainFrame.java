
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;

public class mainFrame extends calendarViewFrame implements ActionListener{
     
    public static void main(String[] args){
        JFrame controlFrame = new JFrame();

        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(600,100);
        
        JPanel content = new JPanel();
        
        JPanel calendarPanel = new JPanel();
        
        JLabel title = new JLabel();
        title.setText("Select Option:");
        JButton openCalendar = new JButton("Open Calendar");
        JButton newEvent = new JButton("Add New Event To Calendar");
        

        
        String[] years = { "2020","2019"};

        JComboBox yearComboBox = new JComboBox(years);
        
        String[] months = { "January","Febuary","March","April","May","June","July","August","September","October","Novemeber","December" };

        JComboBox monthComboBox = new JComboBox(months);
        openCalendar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	
            	int monthInt = 0;
            	if(monthComboBox.getSelectedItem().toString() == "January") {
            		monthInt = 1;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "Febuary") {
            		monthInt = 2;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "March") {
            		monthInt = 3;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "April") {
            		monthInt = 4;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "May") {
            		monthInt = 5;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "June") {
            		monthInt = 6;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "July") {
            		monthInt = 7;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "August") {
            		monthInt = 8;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "September") {
            		monthInt = 9;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "October") {
            		monthInt = 10;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "Novemeber") {
            		monthInt = 11;
            	}
            	if(monthComboBox.getSelectedItem().toString() == "December") {
            		monthInt = 12;
            	}
     
            	
            	calendarViewFrame.calendarViewFrame(monthInt, Integer.parseInt(yearComboBox.getSelectedItem().toString()));
            	
        }  
        }); 

        
        content.add(title);
        content.add(monthComboBox);
  
        content.add(yearComboBox);
        content.add(openCalendar);
        content.add(newEvent);
        controlFrame.add(content);
        
        controlFrame.setVisible(true);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    

}
