package Restart;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Sounds.Sound8;



/******************* Class Thread Foe Handling The Client ***************************************/
//	public class ThreadForRestart extends Thread
//	/**********************************************************************************************/
//	{***********************   *****************************************/	


public  class ThreadForRestart extends  TimerTask 
{
	private String _time;
	private boolean  _first;
	
	public ThreadForRestart (String time, boolean  first)
	{ 
		_time = time;
		 _first=first;
		
	}
	   public void run()
	   {
		   Sound s = new Sound();
		   if (_first) 
		   {
		      s.playSound("C:/util/restart10.wav");
		   }else {
			   s.playSound("C:/util/restart.wav");
		   }
		//   long s = System.currentTimeMillis();
		   UIManager.put("OptionPane.minimumSize",new Dimension(500,300)); 
		   Dimension d = new Dimension(333,333);
		   JOptionPane j = new JOptionPane();
		   j.setSize(d);
		   j.showMessageDialog( null, "  Restart Requared    " + _time  );
		   
	       System.out.println(_time);      
	   }
}
	
		
        
        
        

	
//	  /***********************   *****************************************/	
//	  public  class TimerTask2 extends  TimerTask 
//	    {

	
//	    }
//	  /*********************** Run method *****************************************/
//		public void run()
//		/**********************************************************************/
//		{
//			  int hours= getHours(time);
//	          int seconds = getSeconds(time);
//	          
//	          int n = (int)getSubTime(hours,seconds);
//	          
//	    	  TimerTask2 tasknew = new TimerTask2(); // TimerSchedulePeriod();
//	   	      Timer timer = new Timer();
//	   	      int time = 1000*60*(n+1);	   	     
//	   	      timer.schedule(tasknew,time); 
//		}
		
		
		

