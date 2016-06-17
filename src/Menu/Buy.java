package Menu;

//import java.awt.event.*;
//import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
//import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Buy extends JDialog{
	
	public Buy(int num){
		Font font=new Font("標楷體",Font.BOLD ,20);
		setSize(300,300);
		setLocation(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setAlwaysOnTop(true);
		try {
			
			JTextArea label1 = new JTextArea();
			label1.setBounds(0,0,300,300);
			label1.setEditable(false);
			label1.setFont(font);
			
			Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
			int money = scanner.nextInt();
			scanner.close();
			
			Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
			int fill = scanner2.nextInt();
			scanner2.close();
					
			if(num == 1){
				if(money < 100){
					label1.setText("Sorry!您的金幣不足...");
				}else if(fill == 8){
					label1.setText("Sorry!您的倉庫已滿...");
				}else{
					label1.setText("購買成功!\n已將您購買的寵物蛋送入倉庫!");
					try{
						PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
						writer0.println(money-100);
						writer0.flush();
						writer0.close();
						
						PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
						writer1.println(fill+1);
						writer1.flush();
						writer1.close();
						
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" egg1.png ");
						//bw.flush();
						bw.close();
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}
				}
			}else if(num == 3){
				if(money < 300){
					label1.setText("Sorry!您的金幣不足...");
				}else if(fill == 8){
					label1.setText("Sorry!您的倉庫已滿...");
				}else{
					label1.setText("購買成功!\n已將您購買的寵物蛋送入倉庫!");
					try{
						PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
						writer0.println(money-300);
						writer0.flush();
						writer0.close();
						
						PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
						writer1.println(fill+1);
						writer1.flush();
						writer1.close();
						
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" egg3.png ");
						//bw.flush();
						bw.close();
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}
				}
			}else if(num == 4){
				if(money < 1000){
					label1.setText("Sorry!您的金幣不足...");
				}else if(fill == 8){
					label1.setText("Sorry!您的倉庫已滿...");
				}else{
					label1.setText("購買成功!\n已將您購買的寵物蛋送入倉庫!");
					try{
						PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
						writer0.println(money-1000);
						writer0.flush();
						writer0.close();
						
						PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
						writer1.println(fill+1);
						writer1.flush();
						writer1.close();
						
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" egg4.png ");
						//bw.flush();
						bw.close();
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}
				}
			}else{
				if(money < 1000){
					label1.setText("Sorry!您的金幣不足...");
				}else if(fill == 8){
					label1.setText("Sorry!您的倉庫已滿...");
				}else{
					label1.setText("購買成功!\n已將您購買的寵物蛋送入倉庫!");
					try{
						PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
						writer0.println(money-1000);
						writer0.flush();
						writer0.close();
						
						PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
						writer1.println(fill+1);
						writer1.flush();
						writer1.close();
						
						File write2 = new File("bin/save.txt");
						BufferedWriter bw = new BufferedWriter(new FileWriter(write2,true));
						bw.write(" egg5.png ");
						//bw.flush();
						bw.close();
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}
				}
			}

			add(label1);
			


			setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	

}
