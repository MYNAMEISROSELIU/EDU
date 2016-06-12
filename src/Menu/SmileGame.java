package Menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class SmileGame {
//	 boolean running=true;
	  Smile frm = new Smile();	
	   int result=0;
	 public void run(){
		 frm.running=true;
	  
		 	frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
	        frm.setLayout(null);
	        frm.setTitle("MemoryMeGame");
	        frm.setSize(750, 800);
	        frm.setLocation(0, 0);
	        frm.getContentPane().setBackground(Color.BLACK);
	        frm.getContentPane().setLayout(new FlowLayout());
	        frm.setVisible(true);
	        frm.setResizable(false); 
	        try{
	       	 while(frm.running){
	       		 Thread.sleep(100);
	       	 }
	        }catch(Exception e){
	       	 e.printStackTrace();
	        }
	       
	        
	        
	 }
	 public boolean result(){
     	if(result==1){
     	return true;	
     	}
     	else{
     		return false;
     	}
     }
	 class Smile extends Game{
		 JButton start ;
		 int time= (int) Math.floor(Math.random() * 4)+5;
		  int checktime=-1;
		 int smile;
		 ImageIcon icon[] = new ImageIcon[169];
	        JLabel lab[] = new JLabel[169];
	        int data[] = new int[169];
	        int correct=0;
	        int wrong=0;
	        private JTextPane timer;	
	    	private TimerThread newThread = new TimerThread();
	    	   Click click = new Click();
		 public Smile(){
			 this.addWindowListener(new W_Listener());
			 
			 newThread.start();
			 
			 smile= (int) Math.floor(Math.random() * 169);
			
			 for (int i = 0; i <169 ; i++) {
	             if(i==smile){
	            	 icon[i] = new ImageIcon("smile.jpg");
	             }
	             
	             else{
				 icon[i] = new ImageIcon("cry.jpg");
	             }
	            }
			 for(int i=0;i<169;i++){
				if(i==smile){
					data[i]=1;
				}
				else{
					data[i]=0;
				}
			 }
			 for (int i = 0; i < 169; i++) {
	                lab[i] = new JLabel(icon[i]);
	                this.add(lab[i]);
	               
	            }
			 for (int i = 0; i <169; i++) {
	                lab[i].addMouseListener(click);
	            }
		 }
		 class Click extends MouseAdapter {
		     int press;
	            public void mouseClicked(MouseEvent e) {
	              if(running){
	            	  for (int i = 0; i <169; i++) {
	            		  if(e.getSource() == lab[i]){
	            			 press=i;
	            		  }
	            		 
	            	  
	              }
	            	  if(press==smile){
	            		  correct++;
	            		  
	            	
	            	  }
	            	  else{
	            		  lab[press].setEnabled(false);
	            		  wrong++;
	            	  }
	              check();
	              }
	            }
	       
	              
	        }
	     public void check(){
         	if(wrong>=5 || checktime==time){
         		running=false;
         		for(int i=0;i<169;i++){
         			  lab[i].setEnabled(false);
         		}
         		 try{
        	       	
        	       		 Thread.sleep(1500);
        	       	 
        	        }catch(Exception e){
        	       	 e.printStackTrace();
        	        }
         	result=0;
         	System.out.print("fail");
         	frm.dispose();
         	}
         	else if(correct==1){
         		running=false;
         
         		result=1;
         		
         		
         		System.out.print("success");
             	frm.dispose();
         	}
       
         }
		 
		
		 class TimerThread extends Thread { // �s�������
				public void run() { // �s������n���檺���e		 
					for(int i = time; i>=0;i--){
					if(running){
						try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							checktime++;
							check();
							//System.out.println(i);
					}
							}		
				}//end of run





			}
	 }
}



