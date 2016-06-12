package Menu;



import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;



abstract public class Game extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean running=false,c_flag=false,loop=false;
	static public final int L_X=700,L_Y=300,S_X=500,S_Y=500; //視窗位置 尺寸
	protected String name;
	

	
	void run(){
		running=true;				
		this.setVisible(true);
	}

	public void close(){
			
		this.setVisible(false);		
		this.running=false;
		this.loop=false;
		this.setVisible(false);	
		this.dispose();	
	}
	public boolean result(){
		return false;
	}
	
	protected void setMouse(String route){
		Image img=null;
		try {
			img = ImageIO.read (new File(route));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Cursor cr =Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(), "humer");
		
		this.setCursor(cr);
		
	}
	
	protected void help(){
		String str="";
		try{
			Scanner in=new Scanner(new FileInputStream("help/"+name+".txt"));
			while(in.hasNext()){
			str=str.concat(in.nextLine());}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JLabel back_h=new JLabel(new ImageIcon("img/"+name+"_h.jpg"));
		back_h.setSize(S_X/2, S_Y/2);
		back_h.setLocation(S_X/4,S_Y/5);
		back_h.setOpaque(true);
		JPanel frame=new JPanel();
		this.add(back_h,new Integer(Integer.MAX_VALUE));
		
		frame.setOpaque(false);
		frame.setSize(S_X/2, S_Y/2);
		frame.setLocation(S_X/4,S_Y/5);
		frame.setLayout(new BorderLayout());
		
		JTextPane text=new JTextPane();
		text.setSize(400,300);
		text.setEditable(false);
		text.setText(str);
		text.setOpaque(false);
		text.setFont(new Font(Font.DIALOG,Font.BOLD ,20));
		
		
		JButton btn=new JButton("OK");
		btn.setSize(50,40);
		btn.setContentAreaFilled(false);		
		btn.addActionListener(this);
		frame.add(text,BorderLayout.CENTER);
		frame.add(btn,BorderLayout.SOUTH);
		frame.setVisible(true);
		this.getLayeredPane().add(frame,new Integer(Integer.MAX_VALUE));
		try{
			while(loop){Thread.sleep(200);}
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setVisible(false);
		back_h.setVisible(false);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	class W_Listener implements WindowListener {
		
		public void windowActivated(WindowEvent e) {
					
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			CheckWindow ch=new CheckWindow();
			if(!loop){
			ch.setVisible(true);
			c_flag=true;
			}
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	class CheckWindow extends JFrame implements ActionListener{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;


		public CheckWindow(){
			this.setAlwaysOnTop(true);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.setResizable(false);
			ImageIcon img=new ImageIcon("img/check_b.jpg");
			JLabel bg=new JLabel(img);
			bg.setSize(250,150);
			this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
			JPanel p= (JPanel) this.getContentPane();
			p.setOpaque(false);
			
			setSize(250,150);
			setLocation(L_X+S_X/4,L_Y+S_Y/4);
			setLayout(new BorderLayout());									
			JLabel text=new JLabel(" 確定關閉? \n(未完成遊戲以失敗論)");
			text.setFont(new Font("SansSerif",Font.BOLD,15));
			text.setOpaque(false);
			add(text,BorderLayout.CENTER);
			
			JPanel button = new JPanel();
			button.setLayout(new FlowLayout());
			button.setOpaque(false);
			
			JButton exit=new JButton("離開");
			exit.setActionCommand("exit");
			exit.setFont(new Font("SansSerif",Font.BOLD,15));
			exit.addActionListener(this);
			exit.setContentAreaFilled(false);;
			
			JButton back=new JButton("返回");
			back.setActionCommand("back");
			back.setFont(new Font("SansSerif",Font.BOLD,15));
			back.addActionListener(this);
			back.setContentAreaFilled(false);
			
			button.add(exit);
			button.add(back);
			add(button,BorderLayout.SOUTH);
		}

		
		public void actionPerformed(ActionEvent e) {
			c_flag=false;
			if(e.getActionCommand().equals("exit")){
				close();						
				dispose();
			}
			else {
				dispose();
				
			
			}
			
		
			
		}

	}
}

