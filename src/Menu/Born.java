package Menu;

import java.awt.event.*;


import javax.swing.*;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Born extends JFrame implements ActionListener{

	JTextArea hint = new JTextArea();
	int get = 0;
	JButton button1,button2,button3;
	
	public Born(){
		setSize(1300,1000);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		try{
			//Image img = ImageIO.read (new File("img/star.png"));
			ImageIcon icon = new ImageIcon("img/star.png");
			
			JLabel label1 = new JLabel(icon);
			label1.setBounds(0,0,100,100);
			JLabel label2 = new JLabel(icon);
			label2.setBounds(100, 0, 100, 100);
			JLabel label3 = new JLabel(icon);
			label3.setBounds(200, 0, 100, 100);
			hint.setEditable(false);
			hint.setBounds(1000,50,300,300);
			add(hint);
			
			button1 = new JButton();
			button1.setText("販賣");
			button1.setBounds(1000, 400, 250, 150);
			button1.setActionCommand("btn1");
			button1.addActionListener(this);
			add(button1);
			
			button2 = new JButton();
			button2.setText("放入倉庫");
			button2.setBounds(1000, 600, 250, 150);
			button2.setActionCommand("btn2");
			button2.addActionListener(this);
			add(button2);
			
			button3 = new JButton();
			button3.setText("離開");
			button3.setBounds(1000, 800, 250, 150);
			button3.setActionCommand("btn3");
			button3.addActionListener(this);
			add(button3);
			button3.setEnabled(false);
			
			Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
			int being = scanner.nextInt();
			
			if(being == 0){
				System.out.println("error!");
				dispose();
			}
			
			int egg = scanner.nextInt();
			int[] n = new int[6];
			n[1] = scanner.nextInt();
			n[2] = scanner.nextInt();
			n[3] = scanner.nextInt();
			n[4] = scanner.nextInt();
			n[5] = scanner.nextInt();
			scanner.close();
			
			Random r = new Random();
			r.setSeed(System.currentTimeMillis());
			int gain = r.nextInt(5) + 1;
			
			int i;
			for(i = 1;i <= 5;i++){
				if(n[i] > n[gain])	gain = i;
			}
			
			
			
			
			get = gain;
			
			if(egg == 1){
				add(label1);
				if(n[1]+n[2]+n[3]+n[4]+n[5] < 10)	gain = 6;
				get = gain;
				icon = new ImageIcon("img/cha/star1/" + gain + ".png");
				JLabel label4 = new JLabel(icon);
				label4.setBounds(0,100,900,900);
				add(label4);
			}else if(egg == 3){
				add(label1);
				add(label2);
				icon = new ImageIcon("img/cha/star2/" + gain + ".png");
				JLabel label4 = new JLabel(icon);
				label4.setBounds(0,100,900,900);
				add(label4);
			}else if(egg == 4){
				add(label1);
				add(label2);
				add(label3);
				icon = new ImageIcon("img/cha/star3/" + gain + ".png");
				JLabel label4 = new JLabel(icon);
				label4.setBounds(0,100,900,900);
				add(label4);
			}else{
				add(label1);
				add(label2);
				int tmp;
				if(gain%2 == 0)	tmp = 1;
				else	tmp = 3;
				icon = new ImageIcon("img/cha/star2/" + tmp + ".png");
				JLabel label4 = new JLabel(icon);
				label4.setBounds(0,100,900,900);
				add(label4);
			}
			
			setVisible(true);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd == "btn1"){
			try{
				Scanner scanner0 = new Scanner(new FileInputStream("bin/keep.txt"));
				scanner0.nextInt();
				int which = scanner0.nextInt();
				scanner0.close();
				
				PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/keep.txt"));
				writer0.println("0\t0\t0\t0\t0\t0\t0");
				writer0.flush();
				writer0.close();
				
				Scanner scanner1 = new Scanner(new FileInputStream("bin/money.txt"));
				int money = scanner1.nextInt();
				scanner1.close();
				
				if(which == 1){
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer1.println(money + 500);
					writer1.flush();
					writer1.close();
					
					hint.setText("獲得500!!");

					
				}else if(which == 3){
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer1.println(money + 1000);
					writer1.flush();
					writer1.close();
					
					hint.setText("獲得1000!!");

				}else if(which == 4){
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer1.println(money + 10000);
					writer1.flush();
					writer1.close();
					
					hint.setText("獲得10000!!");
					
					
				}else{
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer1.println(money + 1000);
					writer1.flush();
					writer1.close();
					
					hint.setText("獲得1000!!");
				}
				
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(true);

				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			
		}
		
		
		if(cmd == "btn2"){
			try{
				Scanner scanner0 = new Scanner(new FileInputStream("bin/keep.txt"));
				scanner0.nextInt();
				int which = scanner0.nextInt();
				scanner0.close();
				
				PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/keep.txt"));
				writer0.println("0\t0\t0\t0\t0\t0\t0");
				writer0.flush();
				writer0.close();
				
				Scanner scanner1 = new Scanner(new FileInputStream("bin/fill.txt"));
				int num = scanner1.nextInt();
				scanner1.close();
				if(num == 8){
					hint.setText("Sorry...倉庫已滿");
				}else{
					hint.setText("已放入倉庫!");
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer1.println(num + 1);
					writer1.flush();
					writer1.close();
					
					if(which == 1){
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" star1/" + get + ".png ");
						bw.close();
					}else if(which == 3){
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" star2/" + get + ".png ");
						bw.close();
					}else if(which == 4){
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" star3/" + get + ".png ");
						bw.close();
					}else{
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						
						if(get%2 == 0)	bw.write(" star2/1.png ");
						else	bw.write(" star2/3.png ");
						
						bw.close();
					}
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(true);
				}

				}
				catch(Exception e2){
					e2.printStackTrace();
				}
		}
		
		if(cmd == "btn3"){
			
			dispose();
		}
	}
	
	public void setText(String str){

		
	}
	
}
