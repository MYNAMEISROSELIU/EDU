package Menu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
//import java.util.Scanned;

//湯匙---幾組2互質的數(20,7)(10)
//麵粉要求---8-19克
//條件---59秒完成 (59秒後沒分也不扣分)
//random.nextInt(12)+8
//(8~19)
public class Cooking extends Game implements ActionListener{
	private long serialVersionUID = 1L;//default ID
	Random random = new Random();
	int goal = random.nextInt(12)+8;//目標：亂數8~19克
//	int goal=20;   //測試用
	int bowl=0,bag=200;
	int input=0;
	int point=0;
	//計時--------------
//	JButton start ;
	private JTextPane timer;	
	private TimerThread newThread = new TimerThread();
	//-------------
	//protected  Cooking this = new Cooking();
	private JButton rule;//規則
	private JButton bowl_pic;
	private JButton bag_pic;
	private JButton spoon_pic;
	private JButton spoonBig_pic;
	private JLabel bowl_click;
	private JLabel bag_click;
	private JTextPane goal_show;//顯示目標
	private JTextPane bowl_in;//顯示碗裡面的
	private JTextPane bag_in;//顯示袋子裡面的
	private ImageIcon bag_icon;
	private ImageIcon bowl_icon;
	private ImageIcon spoon_icon;
	private ImageIcon spoonBig_icon;
	private ImageIcon rule_icon;//規則icon
	private Image c ;
	private Cursor cr;

	public  void  run(){
//		Cooking this = new Cooking();
		running=true;
		this.setVisible(true);
		while(running)try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
	}

	public Cooking(){
		setSize(1000,700);
		setResizable(false); //讓使用者不能改變視窗大小
		setTitle("來做蛋糕吧！");
		setLayout(null);//不設任何形式，直接定位
		
		this.addWindowListener(new W_Listener());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		ImageIcon background = new ImageIcon("img/Chihane1002/bg.png");	
		JLabel bg = new JLabel(background);//總之就是把背景圖裝在label裡拉
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大就算他是背景，但要注意如果別人按放大會漏餡
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));  //把label丟到最底層
		JPanel imagePanel = (JPanel) this.getContentPane();  
		imagePanel.setOpaque(false);  //把背景上面那個panel設定為透明，因為背景會被蓋住
		//設定完成	

		rule_icon = new ImageIcon("img/Chihane1002/rule.png");
		bag_icon = new ImageIcon("img/Chihane1002/bag.png");
		bowl_icon = new ImageIcon("img/Chihane1002/bowl.png");
		spoon_icon = new ImageIcon("img/Chihane1002/spoon.png");
		spoonBig_icon = new ImageIcon("img/Chihane1002/spoonBig.png");
		//計時
//		start = new JButton("倒數"); 
//		start.addActionListener(this);
		timer = new JTextPane();
		
		
		rule = new JButton(rule_icon);//規則，典籍任何一處開始
		rule.addActionListener(this);
		rule.setContentAreaFilled(false);
		rule.setBorderPainted(false);
		rule.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大
		this.getLayeredPane().add(rule, new Integer(Integer.MAX_VALUE));  //把label丟到最上層
		add(rule);
		rule.setVisible(true);
		
		bag_pic = new JButton("舀進",bag_icon);//袋子
		bag_pic.addActionListener(this);
		bag_pic.setContentAreaFilled(false);
		bag_pic.setBorderPainted(false);
		bowl_pic = new JButton("舀出",bowl_icon);//碗
		bowl_pic.addActionListener(this);
		bowl_pic.setContentAreaFilled(false);
		bowl_pic.setBorderPainted(false);
		spoon_pic = new JButton("7g",spoon_icon);//小湯匙
		spoon_pic.addActionListener(this);
		spoon_pic.setContentAreaFilled(false);//隱藏按鈕邊框
		spoon_pic.setBorderPainted(false);
		spoonBig_pic = new JButton("20g",spoonBig_icon);//大湯匙
		spoonBig_pic.addActionListener(this);
		spoonBig_pic.setContentAreaFilled(false);
		spoonBig_pic.setBorderPainted(false);
		bowl_click = new JLabel(bowl_icon);//設定一些不能按的圖片
		bowl_click.setText("舀出");
		bag_click= new JLabel(bag_icon);
		bag_click.setText("舀進");


		goal_show = new JTextPane();//顯示目標
		bag_in = new JTextPane();//顯示袋子裡面的(數)
		bowl_in = new JTextPane();//顯示碗裡面的(數)
		goal_show.setText("需要"+goal+"g");
		setText();
		unclickable();
//		run();
		spoon_pic.setVisible(true);
		spoonBig_pic.setVisible(true);
//------------------------------------------------------------------------
		
		bag_click.setLocation(200,60);
		bag_click.setSize(bag_icon.getIconWidth()+100,bag_icon.getIconHeight());
		add(bag_click);
		
		bowl_click.setLocation(550,100);
		bowl_click.setSize(bowl_icon.getIconWidth()+100,bowl_icon.getIconHeight());//+100顯示文字
		add(bowl_click);
		
		bag_pic.setLocation(200,60);
		bag_pic.setSize(bag_icon.getIconWidth()+100,bag_icon.getIconHeight());
		add(bag_pic);
		
		bowl_pic.setLocation(550,100);
		bowl_pic.setSize(bowl_icon.getIconWidth()+100,bowl_icon.getIconHeight());//+100顯示文字
		add(bowl_pic);
		
		spoon_pic.setLocation(50,430);
		spoon_pic.setSize(spoon_icon.getIconWidth()+100,spoon_icon.getIconHeight());
		add(spoon_pic);
		
		spoonBig_pic.setLocation(140,385);
		spoonBig_pic.setSize(spoonBig_icon.getIconWidth()+100,spoonBig_icon.getIconHeight());
		add(spoonBig_pic);
		
		
		bag_in.setLocation(100,260);
		bag_in.setSize(160,100);
		bag_in.setOpaque(false);
		bag_in.setEditable(false);
		add(bag_in);
		
		
		bowl_in.setLocation(700,80);
		bowl_in.setSize(140,100);
//		bowl_in.setBackground(Color.lightGray);
		bowl_in.setOpaque(false);
		bowl_in.setEditable(false);
		add(bowl_in);
		
		goal_show.setLocation(30,30);
		goal_show.setSize(200,70);
		goal_show.setOpaque(false);
		goal_show.setEditable(false);
		add(goal_show);
		
		timer.setLocation(870,40);
		timer.setSize(100,70);
		timer.setOpaque(false);
		timer.setEditable(false);
		add(timer);
		
//		start.setLocation(770,40);
//		start.setSize(70,40);
//		add(start);
//----------------------------------------------------------------------


	}//end of Cooker(void) constructor

	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();
		if(e.getSource() ==spoon_pic){
			System.out.println("小湯匙");
			clickable();
			input = 7;///暫定
			mouse();
		}else if(actionCommand.equals("20g")){
			System.out.println("大湯匙");
			clickable();
			input = 20;//暫定
			mouse();
		}else if(actionCommand.equals("舀進")){
			System.out.println("袋子/舀進");
			if(bag>=input){
				bowl=bowl+input;
				bag = bag-input;
			}
			setText();
			judge(bowl);
		}else if(actionCommand.equals("舀出")){
			System.out.println("碗/舀出");
			if(bowl>=input){
				bowl=bowl-input;
				bag = bag+input;
			}
			setText();
			judge(bowl);
		}else if(e.getSource() == rule){ //開始計時
			rule.setVisible(false);
			
			newThread.start(); // 啟動執行緒
			
		}else{
			System.out.println("按鍵監聽出問題了!!");
		}

	}//end of actionPerformed(void)




	private void unclickable(){
		bag_pic.setVisible(false);
		bowl_pic.setVisible(false);
		bowl_click.setVisible(true);
		bag_click.setVisible(true);

	}//end of unclickable(void)

	private void clickable(){
		bag_pic.setVisible(true);
		bowl_pic.setVisible(true);
		bowl_click.setVisible(false);
		bag_click.setVisible(false);

	}//end of unclickable(void)

	private void mouse(){
		//另外改變滑鼠圖標請套用以下設定:
		try {
			c = ImageIO.read(new File("img/Chihane1002/spoon_mouse.png"));
			cr = Toolkit.getDefaultToolkit().createCustomCursor( c , new Point(0,0) ,"MyCursor" );
			this.setCursor( cr );
		}
		catch (Exception ex) {
			System.out.println("No spoon_mouse.png!!");
		}

	}

	private void setText(){
		bag_in.setText("袋子裡有：\n"+"    "+bag+"g");
		bowl_in.setText("碗裡有：\n"+"    "+bowl+"g");
		bag_in.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		bowl_in.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		goal_show.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		timer.setFont(new Font("微軟正黑體", Font.BOLD, 60));
		bag_in.setForeground(new Color(0xBC8F8F));
		bowl_in.setForeground(new Color(0xBC8F8F));//玫瑰褐
		goal_show.setForeground(new Color(0x5686BF));//韋奇伍德瓷藍
		timer.setForeground(new Color(0x5DC143C));//緋紅
	}//end of setText(void)


	private void judge(int bowl){
		if(bowl==goal){
			running=false;
			System.out.print(running);
			System.out.println("恭喜你成功了!!\\^O^//");
			ImageIcon bgDone = new ImageIcon("img/Chihane1002/done.png");	
			JLabel bg = new JLabel(bgDone);//總之就是把背景圖裝在label裡拉
			bg.setBounds(0, 0, this.getWidth(), this.getHeight());  //然後把label調的跟視窗一樣大
			this.getLayeredPane().add(bg, new Integer(Integer.MAX_VALUE));  //把label丟到最上層
//			回傳贏了的積分
			
			point=1;
			
		}else{
			System.out.println("加油!");
			point=0;
			//回傳輸了的積分=預設0
		}
	}//end of judge(void)

	
	public boolean result(){
		if(point==1)
			return true;
		else 
			return false;
	}
	
	private void setLabel(int i){
		System.out.println(i);
		timer.setText(""+i);
		timer.revalidate();//畫面更新(參考: https://www.javaworld.com.tw/jute/post/view?bid=5&id=176473)
	}
	
	public void close(){
		this.dispose();		
		this.setVisible(false);
		running=false;
		newThread.stop();
		//這是"做蛋糕"的計時器~~
	
		
	}
	class TimerThread extends Thread { // 新的執行緒
		public void run() { // 新執行緒要執行的內容
//			while(true) { //倒數計時
				for(int i = 59; i>=0;i--){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setLabel(i);
					point = 1;
					}
				point =0;
//			}//end of while
		}//end of run





	}
}//end of class Cooking
