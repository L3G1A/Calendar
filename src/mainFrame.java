
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class mainFrame extends calendarViewFrame implements ActionListener{
     
    public static void main(String[] args){
    	  UIManager.put( "control", new Color( 45,45,45) );//background color
    	  UIManager.put( "info", new Color(128,128,128) );
    	  UIManager.put( "nimbusBase", new Color( 18, 30, 49) );//color of text fields buttons and dropdowns
    	  UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
    	  UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
    	  UIManager.put( "nimbusFocus", new Color(115,164,209) );
    	  UIManager.put( "nimbusGreen", new Color(176,179,50) );
    	  UIManager.put( "nimbusInfoBlue", new Color( 45,45,45) );
    	  UIManager.put( "nimbusLightBackground", new Color( 45,45,45) );//background of dropdowns and text fields
    	  UIManager.put( "nimbusOrange", new Color(191,98,4) );
    	  UIManager.put( "nimbusRed", new Color(169,46,34) );
    	  UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
    	  UIManager.put( "nimbusSelectionBackground", new Color( 8, 27, 51) );
    	  UIManager.put( "text", new Color( 230, 230, 230) );
    	  try {
    	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    	      if ("Nimbus".equals(info.getName())) {
    	          javax.swing.UIManager.setLookAndFeel(info.getClassName());
    	          break;
    	      }
    	      
    	    }
    	  } catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	  } catch (InstantiationException e) {
    	    e.printStackTrace();
    	  } catch (IllegalAccessException e) {
    	    e.printStackTrace();
    	  } catch (javax.swing.UnsupportedLookAndFeelException e) {
    	    e.printStackTrace();
    	  } catch (Exception e) {
    	    e.printStackTrace();
    	  }

    	  // Show
        JFrame controlFrame = new JFrame();

        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(600,100);
        
        JPanel content = new JPanel();
        
        JPanel calendarPanel = new JPanel();
        
        JLabel title = new JLabel();
        title.setText("Select Option:");
        JButton openCalendar = new JButton("Open Calendar");
        JButton newEvent = new JButton("Add New Event To Calendar");
        

		JFrame calendarFrame = new JFrame();
		
		
		calendarFrame.setBackground(Color.BLACK);



		calendarFrame.setSize(1000,800);
		
		
        String[] years = { "2020","2019"};

        JComboBox yearComboBox = new JComboBox(years);
        
        String[] months = { "January","Febuary","March","April","May","June","July","August","September","October","Novemeber","December" };

        
        

        JComboBox monthComboBox = new JComboBox(months);
        monthComboBox.addActionListener(new ActionListener(){  
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
     
        	
            	calendarFrame.getContentPane().removeAll();

        		calendarFrame.getContentPane().add(new calendar(monthInt,Integer.parseInt(yearComboBox.getSelectedItem().toString())));
    
        	
        		calendarFrame.setVisible(true);

        }  
        }); 

        
        
        calendarFrame.addMouseListener(new MouseAdapter() {
        	
        	public void mousePressed(MouseEvent e) {
        		System.out.println(e.getX() + "," + e.getY());
        	}
        	
        });
        
        yearComboBox.addActionListener(new ActionListener(){  
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
     
        	
            	calendarFrame.getContentPane().removeAll();

        		calendarFrame.getContentPane().add(new calendar(monthInt,Integer.parseInt(yearComboBox.getSelectedItem().toString())));
    
        	
        		calendarFrame.setVisible(true);

        }  
        }); 

		calendarFrame.getContentPane().add(new calendar(1,2020));
	    
    	
		calendarFrame.setVisible(true);
		
		
        content.add(title);
        content.add(monthComboBox);
  
        content.add(yearComboBox);
        content.add(newEvent);
        controlFrame.add(content);

        controlFrame.setVisible(true);
        
        

    
		
		

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
