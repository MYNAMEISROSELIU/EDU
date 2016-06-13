package Menu;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.PrintWriter;
import java.util.Scanner;


import javax.swing.*;


public class Save extends JFrame{
	private JFrame load_f,save_f,new_s,del_f;
	private int state;
	private boolean loop=true;
	static JTextField name = new JTextField("", 30);
	public Save(int s_x,int s_y,int type){
		
		ImageIcon img=new ImageIcon("img/main_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(500, 500);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		
		this.setSize(500,500);
		if(type==0)this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		else this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		this.setLayout(null);
		this.setLocation(s_x/4, s_y/4);
		this.getContentPane().setBackground(Color.white);
		
		JButton button0 = new JButton();
		button0.setSize(300,90);
		button0.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button0.setLocation(100,315);
		button0.setIcon(new ImageIcon("img/delete.jpg"));
		button0.setActionCommand("delete");
		button0.addActionListener(new Click_on());
		button0.setContentAreaFilled(false);
		button0.setOpaque(false);
		
		if(type==1)this.add(button0);
		
		
		JButton button1 = new JButton();
		button1.setSize(300,90);
		button1.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button1.setLocation(100,165);
		button1.setIcon(new ImageIcon("img/save.jpg"));
		button1.setActionCommand("save");
		button1.addActionListener(new Click_on());
		button1.setContentAreaFilled(false);
		button1.setOpaque(false);
		if(type==1)this.add(button1);
		
		
		
		JButton button2 = new JButton();
		button2.setSize(300,90);
		button2.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button2.setLocation(100,315);
		button2.setIcon(new ImageIcon("img/load.jpg"));
		button2.setActionCommand("load");
		button2.addActionListener(new Click_on());
		button2.setContentAreaFilled(false);
		button2.setOpaque(false);
		
		if(type==0)this.add(button2);
		
		JButton button3 = new JButton();
		button3.setSize(300,90);
		button3.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button3.setLocation(100,15);
		button3.setIcon(new ImageIcon("img/newgame.jpg"));
		button3.setActionCommand("newgame");
		button3.addActionListener(new Click_on());
		button3.setContentAreaFilled(false);
		button3.setOpaque(false);
		if(type==0)this.add(button3);
		
		JButton button4 = new JButton();
		button4.setSize(300,90);
		button4.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button4.setLocation(100,165);
		button4.setIcon(new ImageIcon("img/help.jpg"));
		button4.setActionCommand("help");
		button4.addActionListener(new Click_on());
		button4.setContentAreaFilled(false);
		button4.setOpaque(false);
		if(type==0)this.add(button4);
			
		name = new JTextField("", 30);
		name.setLocation(100,15);
		name.setSize(300,50);
		name.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		
		
		
//		load_f.add(btn3);
		
		
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	static public void save(String name){
	
		if(name.equals("")){
			
		}else{
		
		try{
		Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
		PrintWriter pr=new PrintWriter(new FileOutputStream("data/"+name+"/keep.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		scanner = new Scanner(new FileInputStream("bin/money.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/money.txt"));
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/fill.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/fill.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/save.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/save.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		}
	}
	
	static public void new_save(String name){
		
		
		File file =new File("data/"+name);
		file.mkdirs();
		
		
		try{
		Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
		PrintWriter pr=new PrintWriter(new FileOutputStream("data/"+name+"/keep.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		scanner = new Scanner(new FileInputStream("bin/money.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/money.txt"));
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/fill.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/fill.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/save.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/save.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		
		pr=new PrintWriter(new FileOutputStream("data/ID",true));
		pr.print(name+"\t");
		pr.flush();
		pr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	static public void load(String name){
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/"+name+"/keep.txt"));
			PrintWriter pr=new PrintWriter(new FileOutputStream("bin/keep.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();
			
			
			scanner = new Scanner(new FileInputStream("data/"+name+"/money.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/money.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
			
			scanner = new Scanner(new FileInputStream("data/"+name+"/fill.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/fill.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
		
			scanner = new Scanner(new FileInputStream("data/"+name+"/save.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/save.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
	
	public void delete(String name){
		File file=new File("data/"+name+"/keep.txt");
		file.delete();
		file=new File("data/"+name+"/save.txt");
		file.delete();
		file=new File("data/"+name+"/money.txt");
		file.delete();
		file=new File("data/"+name+"/fill.txt");
		file.delete();
		file=new File("data/"+name);
		
		
		if(file.delete()){
			
			System.out.println("susscces");
		
		
		String str="",s;
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/ID"));
			while (scanner.hasNext()){
				s=scanner.next();
				if(s.equals(name)){
					
				}
				else str=str.concat(s+"\t");
			}
			scanner.close();
			
			
			PrintWriter pr=new PrintWriter(new FileOutputStream("data/ID"));
			pr.print(str);
			pr.flush();
			pr.close();
			
			
		}catch(Exception e){
			e.printStackTrace();			
		}
		}
	}
	
	public M getM(){
		M m=null ;
		try{
			while(loop){Thread.sleep(100);}
		switch(state){
		case 0:
			 m=new M();
			 break;
		case 1:
			m= new M(name.getText());
			break;
		default:
			m=new M();
			break;
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dispose();
		return m;
	}
	
	
	
	private JFrame save_frame(){
		
		JFrame frame=new JFrame();
		
		JLabel bg1=new JLabel(new ImageIcon("img/main_b.jpg"));
		bg1.setSize(500, 500);
		frame.getLayeredPane().add(bg1,new Integer(Integer.MIN_VALUE));
		JPanel p1= (JPanel)frame.getContentPane();
		p1.setOpaque(false);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		frame.setLayout(null);
		frame.setLocation(1300/4, 1000/4);
		frame.getContentPane().setBackground(Color.white);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/ID"));
			
			JButton[] btn_s=new JButton[4];
			JLabel[] back_b=new JLabel[4];

			
			
			
			for(int i=0;i<4;i++){
				btn_s[i]=new JButton();
				btn_s[i].addActionListener(new Click_on());
				btn_s[i].setContentAreaFilled(false);
				btn_s[i].setLocation(100,50+i*100);
				btn_s[i].setSize(300,90);
				btn_s[i].setFont(new Font("lucida handwriting",Font.BOLD,48));
				btn_s[i].setForeground(Color.lightGray);
				back_b[i]=new JLabel(new ImageIcon("img/button_b.jpg"));			
				back_b[i].setLocation(100,50+i*100);
				back_b[i].setSize(300,90);
				
				
				
				
				if(scanner.hasNext()){
					btn_s[i].setText(scanner.next());
					
				}
				btn_s[i].setActionCommand("s_"+btn_s[i].getText());
				frame.add(btn_s[i],new Integer (Integer.MAX_VALUE));
				frame.add(back_b[i]);
				
				
			}
			scanner.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return frame;
	}
	
	
	
	
	private JFrame load_frame(){
		JFrame frame=new JFrame();
		
		JLabel bg1=new JLabel(new ImageIcon("img/main_b.jpg"));
		bg1.setSize(500, 500);
		frame.getLayeredPane().add(bg1,new Integer(Integer.MIN_VALUE));
		JPanel p1= (JPanel)frame.getContentPane();
		p1.setOpaque(false);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		frame.setLayout(null);
		frame.setLocation(1300/4, 1000/4);
		frame.getContentPane().setBackground(Color.white);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/ID"));
			JButton[] btn_l=new JButton[4];
			JLabel[] back_l=new JLabel[4];
			
			
			
			for(int i=0;i<4;i++){
				if(scanner.hasNext()){
					
					btn_l[i]=new JButton();
					btn_l[i].addActionListener(new Click_on());
					btn_l[i].setContentAreaFilled(false);
					btn_l[i].setLocation(100,50+i*100);
					btn_l[i].setSize(300,90);
					btn_l[i].setFont(new Font("lucida handwriting",Font.BOLD,48));
					btn_l[i].setForeground(Color.lightGray);
					
					back_l[i]=new JLabel(new ImageIcon("img/button_b.jpg"));			
					back_l[i].setLocation(100,50+i*100);
					back_l[i].setSize(300,90);
					btn_l[i].setText(scanner.next());
					btn_l[i].setActionCommand("l_"+btn_l[i].getText());
					frame.add(btn_l[i],new Integer(Integer.MAX_VALUE));
					frame.add(back_l[i]);
					
				}				
			}
			scanner.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return frame;
		
		
	}
	
	
	private JFrame del_frame(){
		JFrame frame=new JFrame();
		
		JLabel bg1=new JLabel(new ImageIcon("img/main_b.jpg"));
		bg1.setSize(500, 500);
		frame.getLayeredPane().add(bg1,new Integer(Integer.MIN_VALUE));
		JPanel p1= (JPanel)frame.getContentPane();
		p1.setOpaque(false);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		frame.setLayout(null);
		frame.setLocation(1300/4, 1000/4);
		frame.getContentPane().setBackground(Color.white);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/ID"));
			JButton[] btn_l=new JButton[4];
			JLabel[] back_l=new JLabel[4];
			
			
			
			for(int i=0;i<4;i++){
				if(scanner.hasNext()){
					
					btn_l[i]=new JButton();
					btn_l[i].addActionListener(new Click_on());
					btn_l[i].setContentAreaFilled(false);
					btn_l[i].setLocation(100,50+i*100);
					btn_l[i].setSize(300,90);
					btn_l[i].setFont(new Font("lucida handwriting",Font.BOLD,48));
					btn_l[i].setForeground(Color.lightGray);
					
					back_l[i]=new JLabel(new ImageIcon("img/button_b.jpg"));			
					back_l[i].setLocation(100,50+i*100);
					back_l[i].setSize(300,90);
					btn_l[i].setText(scanner.next());
					btn_l[i].setActionCommand("d_"+btn_l[i].getText());
					frame.add(btn_l[i],new Integer(Integer.MAX_VALUE));
					frame.add(back_l[i]);
					
				}				
			}
			scanner.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return frame;
		
		
	}
	
	class Click_on implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().contains("s_")){
				String str=e.getActionCommand().substring(2);
				switch(str){
				case "":
					new_s=new JFrame();
					ImageIcon img=new ImageIcon("img/main_b.jpg");
					JLabel bg=new JLabel(img);
					bg.setSize(500, 500);
					new_s.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
					JPanel p= (JPanel)new_s.getContentPane();
					p.setOpaque(false);
					
					new_s.setBounds(300, 250, 500, 500);
					new_s.add(name);
					new_s.setLayout(null);
					JButton btn1 = new JButton(new ImageIcon("img/new.jpg"));
					btn1.setActionCommand("new");
					btn1.addActionListener(new Click_on());
					btn1.setBounds(100,250,300, 90);
					new_s.add(btn1);
					new_s.setVisible(true);
					break;
					
				default:
					save(str);
					Mes m=new Mes("已存檔");
					m.setVisible(true);
					break;
				
				}				
			}
			else if(e.getActionCommand().contains("l_")){
					String str=e.getActionCommand().substring(2);
					load(str);
					name.setText(str);
					state=1;
					load_f.setVisible(false);
					loop=false;
					
									
				}
			else if(e.getActionCommand().contains("d_")){
				String str=e.getActionCommand().substring(2);
				delete(str);
				Mes m=new Mes("已刪除");
				m.setVisible(true);
				del_f.setVisible(false);

				
								
			}
			else{
			
				switch(e.getActionCommand()){
			
				case "save":
//					save_f.add(name);
					save_f=save_frame();
					save_f.setVisible(true);
					break;
				case "load":
//				load_f.add(name);
					load_f=load_frame();
					load_f.setVisible(true);
					break;
				case "delete":
//					load_f.add(name);
						del_f=del_frame();
						del_f.setVisible(true);
						break;
				case "newgame":
					state=0;
					loop=false;
					break;
					
				case "help":
					new Help();
					
					break;
					
				case "exist":
					save(name.getText());
					save_f.setVisible(false);
					break;
				
				case "new":
					if(name.getText().equals("")){
					Mes m=new Mes("存檔失敗");
					m.setVisible(true);
					}else{
					new_save(name.getText());
					save_f.setVisible(false);
					new_s.setVisible(false);
					}
					break;
			
			}
			
			}

		}
		
		
		
	}
	
	
	class Mes extends JFrame{
		JLabel lab=new JLabel();
		public Mes(String str){
			ImageIcon img=new ImageIcon("img/main_b.jpg");
			JLabel bg=new JLabel(img);
			bg.setSize(500, 500);
			this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
			JPanel p= (JPanel)this.getContentPane();
			p.setOpaque(false);
			
			this.setSize(200,100);
			lab.setText(str);
			lab.setSize(150,100);
			this.setLocation(500,400);
			lab.setFont(new Font("標楷體",Font.BOLD ,40));
			this.add(lab);
		}
	}
}
