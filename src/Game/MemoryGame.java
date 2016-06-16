package Game;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
class Location {
 
    void Set(int[] x) {
        int  rem_no, t_no;
        
        int[] t = new int[16];
        for (int i = 0; i < 16; i++) {
            t[i] = 1 + i;
        }
        rem_no = 16;
        for (int i = 0; i < 16; i++) {
            t_no = (int) Math.floor(Math.random() * rem_no);   //random挑出圖的號碼
            x[i] = t[t_no];    //第i個label配對到第幾個圖
            for (int j = t_no; j < (rem_no - 1); j++) {
                t[j] = t[j + 1];
            }
            rem_no--;
        }
    }
}
 

 
public class MemoryGame {
//	  boolean running=false;
      int result=0;
      MeGame frm = new MeGame();
    public  void run() {
    	frm.running=true;
    	frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	
    	
        frm.setLayout(null);
        frm.setTitle("MemoryMeGame");
        frm.setSize(750, 750);
        frm.setLocation(0, 0);
        frm.getContentPane().setBackground(Color.BLACK);
        frm.getContentPane().setLayout(new FlowLayout());
        frm.setVisible(true);
        frm.setResizable(false); 
        frm.help();
        frm.label_v();
      frm.Stop();
      frm.G();
        
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
    		frm.setVisible(false);
    		frm.running = false;
    		frm.setVisible(false);
    		frm.dispose();
    	return true;	
    	}
    	else{
    		frm.setVisible(false);
    		frm.running = false;
    		frm.setVisible(false);
    		frm.dispose();
    		return false;
    	}
    }
    class MeGame extends Game {
    	JButton start ;
    	private JTextPane timer;	
    	private TimerThread newThread = new TimerThread();
        int p_num = 0;
        int press1 = -1, press2 = -1;  //還沒按=-1
        int correct = 0;
        Location location = new Location();
        ImageIcon icon[] = new ImageIcon[17];
        JLabel lab[] = new JLabel[16];
        //int a = 1, b = 16, c = 16;
       // int d = b - a + 1;
        int data[] = new int[16];
        Click click = new Click();
      int wrong=0;
        public  MeGame() {
        	this.loop=true;
        	this.name="memory";
        	this.addWindowListener(new W_Listener());
            
            icon[0] = new ImageIcon("img/peggy/" + "0.jpg");   //一開始圖片  
     
            for (int i = 1; i <= 8; i++) {
                icon[i] = new ImageIcon("img/peggy/" + i + ".jpg");
                icon[i + 8] = new ImageIcon("img/peggy/" + i + ".jpg");
            }
            location.Set(data);
        	for (int i = 0; i <= 15; i++) {
                lab[i] = new JLabel(icon[data[i]]);
                lab[i].setVisible(false);
                this.add(lab[i]);
               
            }
            for (int i = 0; i <= 15; i++) {
                lab[i].addMouseListener(click);
            }
            
            //newThread.start();
            
        }
        public void label_v(){
        for (int i = 0; i <= 15; i++) {
            lab[i].setVisible(true);
        }
        }
        public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("OK")){
				loop=false;
			}
			}
        
        public void Stop(){
        	try{

                Thread.sleep(5000);
            }catch(Exception e)
            {
               System.out.println("Exception caught");
            }
        }
        public void G(){
        	for (int i = 0; i <= 15; i++) {
                lab[i].setIcon(icon[0]);///new JLabel(icon[0]);
               // this.add(lab[i]);

            }
       		//newThread.start();
     
            
        	
        }

     
        class Click extends MouseAdapter {
     
            public void mouseClicked(MouseEvent e) {
            	if(running){
            	if (press1 != -1) {    //避免重複按自己也算一次
                    if (e.getSource() == lab[press1]) {
                        return;
                    }
                }
                if (press2 != -1) {
                    if (e.getSource() == lab[press2]) {
                        return;
                    }
                   
                }
               
                for (int i = 0; i <= 15; i++) {
     
                    if (lab[i].isEnabled()) {
                        if (e.getSource() == lab[i]) {
                            p_num++;    
                            if (p_num > 2) {  //按第3下,表前2個比對不符
                                lab[press1].setIcon(icon[0]);
                                lab[press2].setIcon(icon[0]);
                                press1 = -1;
                                press2 = -1;
                                p_num = 1;
                                wrong++;
                            }
     
                            lab[i].setIcon(icon[data[i]]);   //翻面
                            if (p_num == 1) {
                                press1 = i;
                            }
                            if (p_num == 2) {
                                press2 = i;
                            }
                        }
                    }
                }
                
     
                if (press1 != -1 && press2 != -1) {   //按了2次,判斷是否是相同圖片
                    if (data[press1] - data[press2] == 8 || data[press1] - data[press2] == -8 ) {  //相差8or-8表是同一張圖
                        lab[press1].setEnabled(false);   //不能按
                        lab[press2].setEnabled(false);
                        p_num = 0;
                        press1 = -1;
                        press2 = -1;
                        correct++;
     
                    }
                }
             check();}   
            }
            public void check(){
            	if(wrong==5 || correct==8){
            		if(correct==8){
           			 System.out.println("success!");
           			 result=1;
           		running=false;
           		 }
           		 else{
           			 System.out.println("fail!");
           			 result=-1;
           				running=false;
           		 }
                }
            }
              
        }
    }
}
class TimerThread extends Thread { // 新的執行緒
	public void run() { // 新執行緒要執行的內容
//		while(true) { //倒數計時
		 
		for(int i = 4; i>=0;i--){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
				}
			
//		}//end of while
		
		
	}//end of run





}
