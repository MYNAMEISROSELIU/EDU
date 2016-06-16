package Game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PaperScissorsStone extends Game implements ActionListener{
	private long serialVersionUID = 1L;//default ID
	Random random = new Random();//電腦出拳=隨機
	int round = 3;//有#define的寫法嗎?
	int cnt=1,win=0,lost=0,same=0,result=0;//計分
	int input=0,output=0;//兩方出拳
	/*
	 * 剪刀=1 石頭=2布 =3
	 * 1>3
	 * 2>1
	 * 3>2
	 * round=訂贏/輸幾杯判定,cnt=回合,win=玩家贏次數,lost=玩家輸次數
	 */
	private JButton rule;//規則
	private JLabel user;//玩家出拳
	private JLabel pc;//對手出拳
	private JTextPane getPoint;//玩家得分
	private JTextPane losePoint;//對手得分
	private JButton btn1 ;//剪刀
	private JButton btn2 ;//石頭
	private JButton btn3 ;//布
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ImageIcon rule_icon;//規則icon
	

	public void run(){
		running=true;
		//PaperScissorsStone this = new PaperScissorsStone();
		this.setVisible(true);
		while(running)try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
	}
	public PaperScissorsStone(){

		setSize(500,528);
		setResizable(false); //讓使用者不能改變視窗大小
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("剪刀、石頭、布");
		setLayout(null);
		this.addWindowListener(new W_Listener());
		
		ImageIcon background = new ImageIcon("img/Chihane1002/bgPSS.png");	
		JLabel bg = new JLabel(background);//總之就是把背景圖裝在label裡拉
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大就算他是背景
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));  //把label丟到最底層
		JPanel imagePanel = (JPanel) this.getContentPane();  
		imagePanel.setOpaque(false);  //把背景上面那個panel設定為透明，因為背景會被蓋住
		//設定完成	
		
		rule_icon = new ImageIcon("img/Chihane1002/rulePSS.png");
		icon1 = new ImageIcon("img/Chihane1002/scissors.png");
		icon2 = new ImageIcon("img/Chihane1002/stone.png");
		icon3 = new ImageIcon("img/Chihane1002/paper.png");
		user = new JLabel(icon2);//玩家出拳
		pc = new JLabel(icon2);//電腦出拳
		getPoint = new JTextPane();//得分
		losePoint = new JTextPane();//失分
		setText();//文字設定
		pc.setVisible(true);
		user.setVisible(true);
		
		rule = new JButton(rule_icon);//規則，典籍任何一處開始
		rule.addActionListener(this);
		rule.setContentAreaFilled(false);
		rule.setBorderPainted(false);
		rule.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大
		this.getLayeredPane().add(rule, new Integer(Integer.MAX_VALUE));  //把label丟到最上層
		add(rule);
		rule.setVisible(true);
		
		pc.setLocation(75,100);
		pc.setSize(166,166);
		add(pc);
		
		user.setLocation(275,100);
		user.setSize(166,166);
		add(user);
		
		losePoint.setLocation(100,25);
		losePoint.setSize(140,70);
		losePoint.setOpaque(false);
//		losePoint.setBackground(Color.lightGray);
		losePoint.setEditable(false);
		add(losePoint);
		
		getPoint.setLocation(300,25);
		getPoint.setSize(140,70);
		getPoint.setOpaque(false);
//		getPoint.setBackground(Color.gray);
		getPoint.setEditable(false);
		add(getPoint);
		
		btn1 = new JButton("剪刀");
		btn2 = new JButton("石頭");
		btn3 = new JButton("布");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		
		btn1.setLocation(400,300);
		btn1.setSize(70,25);
		add(btn1);
		
		btn2.setLocation(400,340);
		btn2.setSize(70,25);
		add(btn2);
		
		btn3.setLocation(400,380);
		btn3.setSize(70,25);
		add(btn3);


	}//end of PaperScissorsStone() constructor

	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();

		if(actionCommand.equals("剪刀")){
			//System.out.println("剪刀");
			user.setIcon(icon1);
			input =1;
			output=random.nextInt(3)+1;
			setOutput(output);
			judge(input,output);
			setText();
			isEnd();

		}else if (actionCommand.equals("石頭")){
			//System.out.println("石頭");
			user.setIcon(icon2);
			input =2;
			output=random.nextInt(3)+1;
			setOutput(output);
			judge(input,output);
			setText();
			isEnd();

		}else if(e.getSource() == rule){ //開始遊戲
			rule.setVisible(false);
			
		}else if (actionCommand.equals("布")){
			//System.out.println("布");
			user.setIcon(icon3);
			input =3;
			output=random.nextInt(3)+1;
			setOutput(output);
			judge(input,output);
			setText();
			isEnd();

		}else{
			System.out.println("按鍵監聽出問題了!!");
		}

		


	}//end of actionPerformed(void)

	
	
	private void isEnd(){
		if((win==round)||(lost==round)){

			JLabel gameOver = new JLabel();//顯示輸贏
			if(win==round){

				//gameOver.setText("恭喜你贏了!!\\^O^//");
				ImageIcon bgDone = new ImageIcon("img/Chihane1002/winPSS.png");	
				JLabel bg = new JLabel(bgDone);//總之就是把背景圖裝在label裡拉
				bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大
				this.getLayeredPane().add(bg, new Integer(Integer.MAX_VALUE));  //把label丟到最上層
				result=1;

			}else{

				//gameOver.setText("輸了T___T");
				ImageIcon bgLost = new ImageIcon("img/Chihane1002/lostPSS.png");	
				JLabel bg = new JLabel(bgLost);//總之就是把背景圖裝在label裡拉
				bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大
				this.getLayeredPane().add(bg, new Integer(Integer.MAX_VALUE));  //把label丟到最上層
				result=0;

			}
			running=false;
			
		}
	}
	
	
	private void setOutput(int output){
		int a = output;
		switch(a){
		case 1:
			pc.setIcon(icon1);
//			System.out.println("電腦:剪刀");
			break;
		case 2:
			pc.setIcon(icon2);
//			System.out.println("電腦:石頭");
			break;
		case 3:
			pc.setIcon(icon3);
//			System.out.println("電腦出:布");
			break;
		default:
			System.out.println("電腦出拳出問題了!!");
			break;
		}
	}//end of setOutput(void)

	private void judge(int input,int output){
		int user = input;
		int pc = output;
		if(user == pc){
			//平手
			same++;
			//System.out.println("平手");
		}else if((user==1 && pc==3)
				||user==2 && pc==1
				||user==3 && pc==2){
			//玩家贏
			//System.out.println("玩家贏");
			win++;
		}else{
			//玩家輸
			//System.out.println("玩家輸");
			lost++;
		}
	}//end of judge(void)


	private void setText(){
		getPoint.setText("玩家得分：\n"+"     "+win);
		getPoint.revalidate();
		losePoint.setText("對手得分：\n"+"     "+lost);
		losePoint.revalidate();
		getPoint.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		getPoint.setForeground(new Color(0x3CB371));
		losePoint.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		losePoint.setForeground(new Color(0x3CB371));//中海綠
		
	}

	public boolean result(){
		if(result==1)
			return true;
		else 
			return false;
	}
	
	
	public void close(){
		this.dispose();		
		this.setVisible(false);
		running=false;
	}
}//end of class

