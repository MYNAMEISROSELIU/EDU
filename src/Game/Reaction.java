package Game;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Reaction extends Game implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon type1,type2,type3;
	private JLabel score_v=new JLabel(),time_v=new JLabel();
	private JButton[] point=new JButton[10];
	private int score=0,time=30,target=80;

	public Reaction (){
		this.name="Reaction";
		this.loop=true;
		
		this.setSize(500,500);
		this.addWindowListener(new W_Listener());				
		this.setLayout(null);
		this.setLocation(L_X,L_Y);
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		this.setResizable(false);
		setMouse();
		
		ImageIcon img=new ImageIcon("img/Reaction_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(S_X, S_Y);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		type1=new ImageIcon("img/type_1.png");
		
		type2=new ImageIcon("img/type_2.png");
		
		type3=new ImageIcon("img/type_3.png");
		
		score_v.setSize(100,50);    
		score_v.setLocation(0,0);
		score_v.setText("Score:"+score);
		score_v.setFont(new Font(Font.DIALOG,Font.BOLD ,20));
		this.add(score_v);
		time_v.setSize(100,50);
		time_v.setLocation(300,0);
		time_v.setText("Time:"+time);
		time_v.setFont(new Font(Font.DIALOG,Font.BOLD ,20));
		this.add(time_v);
		
		for(int i=0;i<10;i++){
		if(i<3){point[i]=new JButton(type2);}
		else if(i<6){point[i]=new JButton(type3);}
		else {point[i]=new JButton(type1);}
			
		point[i].setSize(50,50);
		point[i].setLocation((int)(Math.random()*1000)%8*50,(int)(Math.random()*1000)%5*50+150);
		point[i].addActionListener(this);
		point[i].setActionCommand(""+i);
		this.add(point[i]);
		point[i].setVisible(false);
		point[i].setContentAreaFilled(false);
		point[i].setBorderPainted(false);
		}		
	}
	
	public void run(){
		running=true;				
		this.setVisible(true);
		
		this.help();
		
		int c;
		int t1=0,t2=0,t3=0;
		for(int i=0;i <300;i++){
			if(!running)break;
			c=(int) (Math.random()*100);
			switch(i%20){
			case 1:
				t1=c%3;
				point[c%3].setVisible(true);				
				break;
			case 7:
				t2=c%3+3;
				point[c%3+3].setVisible(true);	
				break;
			case 15:
				t3=c%4+6;
				point[c%4+6].setVisible(true);	
				break;
			default:
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%20==5)point[t1].setVisible(false);
			if(i%20==14)point[t3].setVisible(false);
			if(i%20==17)point[t2].setVisible(false);
			if(i%10==0)time_v.setText("Time:"+time--);
		}
		
		
		
	}	
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("OK")){
			loop=false;
		}
		else{
		
		int state=Integer.valueOf(e.getActionCommand());
		point[state].setVisible(false);
		if(state<3)score+=10;
		else if(state<6)score+=5;
		else score++;
		score_v.setText("Score:"+score);
		}
	}
	
	
	
	
	private void setMouse(){
		Image img=null;
		try {
			img = ImageIO.read (new File("img/humer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Cursor cr =Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(20,20), "humer");
		
		this.setCursor(cr);
		
	}
	
	
	public boolean result(){
		
		boolean res=false;
		//System.out.println("Scole="+score);
		if(score>target){
			res=true;
		}
		else res=false;
		
		return res;
	}
	

}
