package Restart;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Scheduler.Scheduler.TimerTask2;





public class Restart extends JFrame //Throws IOException
{
	private static final long serialVersionUID = 1L;
	BorderLayout layout;
	private JButton add;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private final JComboBox<String> HourCombo;
	//private final JComboBox<Integer> MinutCombo;
	private  JTextField textField;	
	
	private ArrayList<JLabel> arrLabel;	
	private ArrayList<JButton> arrButton;	
	private String s = " Restart for Client ";
	private JLabel label ;
	private  int firstEmptyLabel;
	private  int _time;
	private String time="00:00";
	private String[] Hours;
	private Timer[] timers;
	private Timer[] timersPre10;
	
	/************ Constructor 
	 * @throws IOException **************************************************************************/
	public Restart() throws Exception
	/*************************************************************************************************/
	{		

		layout = new BorderLayout();
		setLayout(layout);
		
		arrLabel = new ArrayList<JLabel>(12);	
		arrButton = new ArrayList<JButton>(12);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setForeground(Color.red);
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		//textField.setSize(100,500);

		
		label = new JLabel( s);
		label.setFont(new Font("Arial", Font.BOLD,30));
		label.setForeground(Color.BLUE);
		
		String[] Hours= {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","08:10","08:20","08:30","08:40","08:50","09:00","09:10","09:20","09:30","09:40","09:50","10:00","10:10","10:20","10:30","10:40","10:50","11:00","11:10","11:20","11:30","11:40","11:50","12:00","12:10","12:20","12:30","12:40","12:50","13:00","13:10","13:20","13:30","13:40","13:50","14:00","14:10","14:20","14:30","14:40","14:50","15:00","15:10","15:20","15:30","15:40","15:50","16:00","16:10","16:20","16:30","16:40","16:50","17:00","17:10","17:20","17:30","17:40","17:50","18:00","18:10","18:20","18:30","18:40","18:50","19:00","19:10","19:20","19:30","19:40","19:50","20:00","20:10","20:20","20:30","20:40","20:50","21:00","21:10","21:20","21:30","21:40","21:50","22:00","22:10","22:20","22:30","22:40","22:50","23:00","23:10","23:20","23:30","23:40","23:50","24:00","24:10","24:20","24:30","24:40","24:50"};
		timers= new Timer[12];	
		timersPre10 = new Timer[12];
		
//		  final Integer[] Hours= new Integer [24];
		  int i;
//		  for( i=0;i<24;i++)
//		  {
//			  Hours[i]=i+1 ;
//		  }
		  HourCombo = new JComboBox<String>(Hours);
		
//		 final Integer[] Minuts= new Integer [13];
//		   Minuts[0]=0;
//		  for( i=1;i<13;i++)
//		  {
//			  Minuts[i]=Minuts[i-1]+5 ;
//		  }
//		MinutCombo = new JComboBox<Integer>(Minuts);
		
		//HourCombo [] arrHourCombo  = new HourCombo[12];
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());  //new GridLayout(12,4,1,1));
		panel4.setLayout(new GridLayout(12,1,1,1));
		panel3.setLayout(new GridLayout(12,1,1,1));

		panel1.add(label);
		panel2.setLayout(new GridLayout(12,1,1,1));				
		Icon img2 = new ImageIcon("C:/util/plus.png");	
		add = new  JButton (img2);
		panel2.add(textField);
		panel4.add(add);
		firstEmptyLabel = 0;
		
		Icon img = new ImageIcon("C:/util/waste.png");
    
		 JLabel l;
		 JButton b;
		for(  i=0; i<11; i++)
		{
			 l = new JLabel();
		     arrLabel.add(i,l);
		
			l.setFont(new Font("Tahoma", Font.BOLD, 24));
			arrLabel.get(i).setFont(new Font("Tahoma", Font.BOLD, 24));
			arrLabel.get(i).setForeground(Color.red);
			arrLabel.get(i).setHorizontalAlignment(JLabel.CENTER);
			//arrLabel.get(i).setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			b = new JButton (img);     
			arrButton.add(i,b);
		
			arrButton.get(i).setPreferredSize( new Dimension (7,4));	
			arrButton.get(i).setVisible(false); 	

			panel2.add(arrLabel.get(i));
			panel4.add(arrButton.get(i));
		
		}	
		
		panel5.add(HourCombo);
		//panel5.add(MinutCombo);
		
		//HourCombo.setVisible(false);
		
	    add(panel1,BorderLayout.NORTH);
	    add(panel2,BorderLayout.CENTER);
	    add(panel3,BorderLayout.EAST);	
	    add(panel4,BorderLayout.EAST);	    	   
	    add(panel5,BorderLayout.WEST);
	    ButtonsHandler handler2 = new ButtonsHandler();
	    add.addActionListener(handler2);
	    for( i=0; i<11; i++)
		{
	    	arrButton.get(i).addActionListener(handler2);

		}
	    DatListener handler = new DatListener();
	    HourCombo.addItemListener(handler);
	    Sound s = new Sound();
	    //s.playSound("C:/test/openning.wav");
	}
	/******************** Handler the Time JCombobox ***********************************************************/
	   private  class DatListener implements ItemListener
 /*****************************************************************************************************/
	    {
		     /********************************* for the JComboBox ****************************************/
	   		public void itemStateChanged (ItemEvent event) 
	   		/*************************************************************************************************/
	    	{
	   			if(event.getStateChange() == ItemEvent.SELECTED)
	   			{
	   				 time = (String)event.getItem();
				 	//_time=Integer.parseInt(time);
	   			}
	    	}
	   		public int getTime(String[] s, String time)
	   		{
	   			int index =0;
	   			for(int i=0;i<s.length;i++)
	   			{
	   				if(time.equals(s[i]))
	   				{
	   					index =i;
	   				}
	   			}
	   			return index;
	   		}
	    }
	
  /************************ Handler the Buttons ************************************************************/
	private class ButtonsHandler implements ActionListener
 /*********************************************************************************************************/
	{
		JButton b=null;
		String text = null;
		String NameInText;
		public void actionPerformed(ActionEvent event)
		{
			
	   		if(event.getSource()==add)             // add Button 
			{
	   			//time.setForeground(Color.green);
	   			text = textField.getText();                          // the Time
	   			NameInText = text;
	   			boolean hebDetector =  text.matches(".*[א-ת]+.*");   // if it's contain hebrew charts
	   			boolean engDetector =text.matches(".*[a-z]+.*");	// if it's contain english charts
	   			if(hebDetector&&(!engDetector))          // if it's contain ONLY Hebrew charts
	   			{
	   				text = text + "      " + time;
	   			}
	   			else if ((!hebDetector)&&engDetector)    // if it's contain ONLY English charts
	   			{
	   				text = time + "       " + text;
	   			}
	   			else           // it's contain a MIX of charts,  hebrew + english.
	   			{
	   				textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);              //RIGHT_TO_LEFT);
	   				text =  time + "          " + text+" "; 
	   			//	text=   text +  time;
	   				textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	   			}	   			   			
	   				   			   			
	   			if (firstEmptyLabel<11)
				{
	   				arrLabel.get(firstEmptyLabel).setVisible(true);
		   			if (NameInText !=null)
		   			{	 
		   				if( !NameInText.isEmpty())
		   				{
		   					arrLabel.get(firstEmptyLabel).setText(text);
		   					arrButton.get(firstEmptyLabel).setVisible(true);
		   					textField.setText("");
			   				panel2.repaint();
			   				firstEmptyLabel++;
		   				}
		   				else {	   				
		   					JOptionPane.showMessageDialog( null, " you can't add an Empty schedule"  );
		   				}   				
		   			}	   			    	   			    	   		
				}

	   			else 
	   			{
	   				JOptionPane.showMessageDialog( null, " you can't add any More Lines"  );
	   			}	
	   							
	   			setSize(551, 701); 
	    		setSize(550, 700); 
	    		
	    		
	    	/********* creats a Thread for handle the time **************************/	
	    		
	          int hours= getHours(time);
	          int seconds = getSeconds(time);          
	          int n = (int)getSubTime(hours,seconds);
	          boolean first=true;
	          
	          ThreadForRestart taskBefor10 = new ThreadForRestart(text,first); // TimerSchedulePeriod();
	          ThreadForRestart tasknew = new ThreadForRestart(text,!first); // TimerSchedulePeriod();

	          Timer timer = new Timer();
	   	      Timer timerPre10 = new Timer();
	   	      int time = 1000*60*(n+1);	 
	   	      if ( n>9)
	   	      {
	   	    	  int timePre10 =  1000*60*(n-9);
	   	          timers[firstEmptyLabel]=timer;
		   	      timers[firstEmptyLabel].schedule(tasknew,time); 
		   	      timersPre10[firstEmptyLabel]=timerPre10;
		   	      timersPre10[firstEmptyLabel].schedule(taskBefor10,timePre10);
	   	      }
	   	      else 
	   	      {   	      
	   	    	  timers[firstEmptyLabel]=timer;
	   	          timers[firstEmptyLabel].schedule(tasknew,time); 
	   	      	  timersPre10[firstEmptyLabel]=timerPre10;
	   	      }
	    		
			}   /******************* end if Add ************************************/  
		
	   		
	   		
	   	for ( int i=0;i<11;i++ )
	   	{
	   		b=arrButton.get(i);
			if( event.getSource().equals(b) )           // remove Button 
			{
				if (firstEmptyLabel>=0)
				{
					this.shrink(i);
					timers[firstEmptyLabel].cancel();
					timersPre10[firstEmptyLabel].cancel();
					arrButton.get(firstEmptyLabel-1).setVisible(false);	
					firstEmptyLabel--;
																
					panel2.repaint();
					panel4.repaint();
					setSize(551, 701); 
		    		setSize(550, 700);
				}
				else
				{
					JOptionPane.showMessageDialog( null, " you can't remove any More Lines"  );
				}
			}  
	   	}
		}
		

		
	    /***************** function that moves all the values at index j-1 to index j from a givven index i ****/	
		public void shrink( int i)
		/***********************************************************************************/
		{
			int t=0;
			int  lastIndex=0;
			for(  t=i; t<11; t++)
			{  
				if( t<10 && !arrLabel.get(t).getText().isEmpty() )
				{									
					String s = arrLabel.get(t+1).getText();
			     	arrLabel.get(t).setText(s);
				}
				lastIndex = t;
			}
			arrLabel.get(lastIndex).setText("");
			
		}
		
		/***********************************************************************************/		
//		public String hebAndEng( String s)
//		/***********************************************************************************/
//		{
//			String temp1;
//			String temp2;
//			
//			temp1=s.subSting(0,1); 
//			return s;
//		}
		
		/**************calculate the seconds between two deiffrents time stamps **************/
		public long getSubTime(int hour, int minut)
		/***********************************************************************************/		
		{
			 Calendar c1 = Calendar.getInstance();    // now
		     Calendar c2 = Calendar.getInstance();    // later
		     
		     c2.set(Calendar.HOUR_OF_DAY,hour);
		     c2.set(Calendar.MINUTE,minut);
		     c2.set(Calendar.SECOND,0);
		     
		     long current= c1.getTimeInMillis();
		     long tafter = c2.getTimeInMillis();
		     
		     long sum = TimeUnit.MILLISECONDS.toMinutes(Math.abs(tafter - current));
		     return sum;
		}

		/***********************************************************************************/
		public int getHours(String time)
		/***********************************************************************************/		
		{
			
			 String s = time.substring(0,2);
			 int x = Integer.parseInt(s);
			 return x;
		}
		
		/***********************************************************************************/
		public int getSeconds(String time)
		/***********************************************************************************/		
		{
			
			 String s = time.substring(3,5);
			 int y = Integer.parseInt(s);
			 return y;
		}
		
		/***********************************************************************************/		
		public int getIndex( String s)
		/***********************************************************************************/
		{
			int index = 0;
			for (int i=0;i<Hours.length;i++)
			{
				if ( s.equals(Hours[i]) )
				{
				index = i;	
				}
			}
			return index;
		}
}
}