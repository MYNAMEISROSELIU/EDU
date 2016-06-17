package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
//import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Deal extends JFrame implements ActionListener{
	
	JTextArea hint = new JTextArea();
	String obj;
	int index;
	String[] wb = new String[8]; 
	JButton button1,button2,button3;
	int flag = 0;
	Font font=new Font("標楷體",Font.BOLD ,25);

	public Deal(String str,String[] data){
		hint.setFont(font);
		
		index = Integer.parseInt(str);
		obj = data[index];
		
		int i;
		for(i = 0;i < 8;i++)	wb[i] = data[i];
		
		setSize(1300,1000);
		//setLocation(500,400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
			int num = scanner.nextInt();
			scanner.close();
			
			//System.out.println(obj);
			
			ImageIcon icon;
			if((obj.substring(0,3)).equals("egg")){
				icon = new ImageIcon("img/" + obj);
			}else{
				icon = new ImageIcon("img/cha/" + obj);}
			JLabel label = new JLabel(icon);
			label.setBounds(0,100,900,900);
			add(label);
			
			button1 = new JButton();
			button1.setIcon(new ImageIcon("img/sell.png"));
			button1.setBounds(1000, 400, 250, 150);
			button1.setActionCommand("sell");
			button1.addActionListener(this);
			add(button1);
			
			button2 = new JButton();
			button2.setIcon(new ImageIcon("img/get.png"));
			button2.setBounds(1000, 600, 250, 150);
			button2.setActionCommand("outside");
			button2.addActionListener(this);
			
			if((obj.substring(0,3)).equals("egg")){
				if(num == 0){
					add(button2);
				}
			}
			
			button3 = new JButton();
			button3.setIcon(new ImageIcon("img/cancel.png"));
			button3.setBounds(1000, 800, 250, 150);
			button3.setActionCommand("cancel");
			button3.addActionListener(this);
			add(button3);
			
			hint.setEditable(false);
			hint.setBounds(1000,50,300,300);
			add(hint);
			
			setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("cancel")){
			flag = 1;
		}
		
		if(cmd.equals("sell")){
			//System.out.println("sell "+ obj);
			
			if((obj.substring(0,3)).equals("egg")){
				hint.setText("已售出\n獲得NT10");
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setIcon(new ImageIcon("img/exit_s.png"));
				
				try{
					Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
					int money = scanner.nextInt();
					scanner.close();
					
					PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer0.println(money+10);
					writer0.flush();
					writer0.close();
					
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/save.txt"));
					int i;
					for(i = 0;i < 8;i++)	if(i != index )writer1.print(" " + wb[i] + " ");
					writer1.flush();
					writer1.close();
					
					Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
					int fill = scanner2.nextInt();
					scanner2.close();
					
					PrintWriter writer2 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer2.println(fill-1);
					writer2.flush();
					writer2.close();

					
					
				}catch(FileNotFoundException e2){
					e2.printStackTrace();
				}
			}
			
			if((obj.substring(0,4)).equals("star")){
				//label.setText("已售出\n獲得NT10");
				//System.out.println(obj.charAt(4));
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setIcon(new ImageIcon("img/exit_s.png"));
				
				int earn;
				if(obj.charAt(4) == '1')	earn = 500;
				else if(obj.charAt(4) == '2') earn = 1000;
				else earn = 10000;
				
				hint.setText("已售出\n獲得NT" + earn);
				try{
					Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
					int money = scanner.nextInt();
					scanner.close();
					
					PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer0.println(money+earn);
					writer0.flush();
					writer0.close();
					
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/save.txt"));
					int i;
					for(i = 0;i < 8;i++)	if(i != index )writer1.print(" " + wb[i] + " ");
					writer1.flush();
					writer1.close();
					
					Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
					int fill = scanner2.nextInt();
					scanner2.close();
					
					PrintWriter writer2 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer2.println(fill-1);
					writer2.flush();
					writer2.close();

					
					
				}catch(FileNotFoundException e2){
					e2.printStackTrace();
				}
			}
			
		}
		
		if(cmd.equals("outside")){
			//System.out.println(obj.charAt(3));
			
				hint.setText("已取出!");
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setIcon(new ImageIcon("img/exit_s.png"));
				
				try{
					
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/save.txt"));
					int i;
					for(i = 0;i < 8;i++)	if(i != index )writer1.print(" " + wb[i] + " ");
					writer1.flush();
					writer1.close();
					
					Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
					int fill = scanner2.nextInt();
					scanner2.close();
					
					PrintWriter writer2 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer2.println(fill-1);
					writer2.flush();
					writer2.close();
					
					PrintWriter writer3 = new PrintWriter(new FileOutputStream("bin/keep.txt"));
					writer3.println("1\t" + obj.charAt(3) + "\t0\t0\t0\t0\t0");
					writer3.flush();
					writer3.close();

					
				}catch(FileNotFoundException e2){
					e2.printStackTrace();
				}
			
		}
	
	}
	
	public int close(){
		return flag;
	}
}
