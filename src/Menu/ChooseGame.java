package Menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseGame extends JFrame implements ActionListener{
	
	int command = 1;
	private ImageIcon b1;
	private ImageIcon b2;
	private ImageIcon b3;
	private ImageIcon b4;
	private ImageIcon b5;
	private ImageIcon b6;
	private ImageIcon b7;
	private ImageIcon b8;
	
	public ChooseGame(){
		setSize(800,600);
		setLocation(500,100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		ImageIcon background = new ImageIcon("img/Chihane1002/choose.jpg");	
		JLabel bg = new JLabel(background);//總之就是把背景圖裝在label裡拉
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大就算他是背景，但要注意如果別人按放大會漏餡
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));  //把label丟到最底層
		JPanel imagePanel = (JPanel) this.getContentPane();  
		imagePanel.setOpaque(false);  //把背景上面那個panel設定為透明，因為背景會被蓋住
		//設定完成
		
		b1 = new ImageIcon("img/Chihane1002/1.png");//OX
		b2 = new ImageIcon("img/Chihane1002/2.png");//PPS
		b3 = new ImageIcon("img/Chihane1002/3.png");//Cook
		b4 = new ImageIcon("img/Chihane1002/4.png");//Smile
		b5 = new ImageIcon("img/Chihane1002/5.png");//Mouse
		b6 = new ImageIcon("img/Chihane1002/6.png");//Quiz
		b7 = new ImageIcon("img/Chihane1002/7.png");//Memory
		b8 = new ImageIcon("img/Chihane1002/8.png");//Menu
		
		try {
			
			JButton button1 = new JButton(b1);
			button1.setBounds(100,0,200,100);
//			button1.setText("OX");
			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button1.setActionCommand("OX");
			button1.addActionListener(this);
			add(button1);
			
			JButton button2 = new JButton(b2);
			button2.setBounds(400,0,200,100);
//			button2.setText("PaperScissorsStone");
			button2.setContentAreaFilled(false);
			button2.setBorderPainted(false);
			button2.setActionCommand("PSS");
			button2.addActionListener(this);
			add(button2);
			
			JButton button3 = new JButton(b3);
			button3.setBounds(100,150,200,100);
//			button3.setText("Cooking");
			button3.setContentAreaFilled(false);
			button3.setBorderPainted(false);
			button3.setActionCommand("Cooking");
			button3.addActionListener(this);
			add(button3);

			JButton button4 = new JButton(b8);
			button4.setBounds(400,450,200,100);
//			button4.setText("Menu");
			button4.setContentAreaFilled(false);
			button4.setBorderPainted(false);
			button4.setActionCommand("menu");
			button4.addActionListener(this);
			add(button4);
			
			JButton button5 = new JButton(b6);
			button5.setBounds(400,300,200,100);
//			button5.setText("Quiz");
			button5.setContentAreaFilled(false);
			button5.setBorderPainted(false);
			button5.setActionCommand("quiz");
			button5.addActionListener(this);
			add(button5);
			
			JButton button6 = new JButton(b5);
			button6.setBounds(100,300,200,100);
//			button6.setText("Mouse");
			button6.setContentAreaFilled(false);
			button6.setBorderPainted(false);
			button6.setActionCommand("mouse");
			button6.addActionListener(this);
			add(button6);
			
			JButton button7 = new JButton(b7);
			button7.setBounds(100,450,200,100);
//			button7.setText("Memory");
			button7.setContentAreaFilled(false);
			button7.setBorderPainted(false);
			button7.setActionCommand("memory");
			button7.addActionListener(this);
			add(button7);
			
			JButton button8 = new JButton(b4);
			button8.setBounds(400,150,200,100);
//			button8.setText("Smile");
			button8.setContentAreaFilled(false);
			button8.setBorderPainted(false);
			button8.setActionCommand("smile");
			button8.addActionListener(this);
			add(button8);
			
			setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
        if (cmd == "OX") {
        	
        	//new Ox();
        	
        	command = 2;
        }
        
        if(cmd == "PSS"){
        	
        	command = 3;
        }
        if(cmd == "Cooking"){
        	command = 4;
        }
        
        if(cmd == "menu"){
        	dispose();
        	command = 5;
        }
        
        if(cmd == "quiz"){
        	command = 9;
        }
        
        if(cmd == "mouse"){
        	command = 10;
        }
        
        if(cmd == "memory"){
        	
        	command = 11;
        }
        
        if(cmd == "smile"){
        	
        	command = 12;
        }
		

	}
	
	public int Choose(){
		return command;
	}

	
	public void run(){
		this.setVisible(true);
		
	}
}
