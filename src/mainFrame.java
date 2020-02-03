
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import javax.swing.JFrame;



public class mainFrame extends calendarViewFrame implements ActionListener{
     
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
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
        
        
        JLabel title = new JLabel();
        title.setText("Select Option:");
        JButton newEvent = new JButton("Add New Event To Calendar");
        

		JFrame calendarFrame = new JFrame();
		
		
		calendarFrame.setBackground(Color.BLACK);



		calendarFrame.setSize(1000,900);
		
		
        String[] years = { "2020","2019"};

        @SuppressWarnings({ "rawtypes" })
		JComboBox yearComboBox = new JComboBox(years);
        
        String[] months = { "January","Febuary","March","April","May","June","July","August","September","October","Novemeber","December" };

        
        

        @SuppressWarnings("rawtypes")
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
        		int clickx = e.getX();
        		int clicky = e.getY();
        		for(int i = 0; i < calendar.boxesOnScreen.size(); i++) {
        			if(calendar.boxesOnScreen.get(i).checkClick(clickx, clicky) == true) {

        				infoFrame.infoFrame(calendar.boxesOnScreen.get(i).getMonth(), calendar.boxesOnScreen.get(i).getYear(),calendar.boxesOnScreen.get(i).getDay());
        			}
        		}
        		

    			for(int xCord = 0; xCord <= (0 + 80); xCord ++) {
    				for(int yCord = 0; yCord < (0 + 80); yCord ++) {
    	
    	        		
    	    					if(clickx == xCord && clicky == yCord) {
    	    			        	
    	    		            	calendarFrame.getContentPane().removeAll();
    	    		            	
    	    		            	int currentMonth = calendar.getMonth() - 1;
    	    		            	int currentYear = calendar.getYear();
    	    		            	
    	    		            	if(currentMonth == 0) {
    	    		            		currentMonth = 12;
    	    		            		currentYear -= 1;
    	    		            	}

    	    		        		calendarFrame.getContentPane().add(new calendar(currentMonth, currentYear));
    	    		    
    	    		        	
    	    		        		calendarFrame.setVisible(true);
    					
    		        		
    					}
    				}
    			}
    			
			
    			
   
    			for(int xCord = 940; xCord <= (940 + 80); xCord ++) {
    				for(int yCord = 0; yCord < (0 + 80); yCord ++) {
    	
    						if(clickx == xCord && clicky == yCord) {
    			        	
    		            	calendarFrame.getContentPane().removeAll();
    		            	
    		            	int currentMonth = calendar.getMonth() + 1;
    		            	int currentYear = calendar.getYear();
    		            	if(currentMonth == 13) {
        		        		currentMonth = 1;

    		            		currentYear += 1;

    		            	}
    		          
        		        		calendarFrame.getContentPane().add(new calendar(currentMonth, currentYear));

    		      

    		    
    		        	
    		        		calendarFrame.setVisible(true);
    		        		
    					}
    				}
    			}
    			

    			
    			
    			
    			
    		
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
    	LocalDate localDate = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
    	LocalDate localYear = LocalDate.now();
    	String currenentYear = dtf.format(localDate); 
    	

        
    	dtf = DateTimeFormatter.ofPattern("MM");
    	LocalDate localMonth = LocalDate.now();
    	String currentMonth = dtf.format(localDate);
    	
		calendarFrame.getContentPane().add(new calendar(Integer.parseInt(currentMonth),Integer.parseInt(currenentYear)));
		
		calendarFrame.setLocationRelativeTo(null);
		calendarFrame.setVisible(true);
		
		
        content.add(title);
        content.add(monthComboBox);
  
        content.add(yearComboBox);
        content.add(newEvent);
        controlFrame.add(content);


        
		

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




}
