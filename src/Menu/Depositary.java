package Menu;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Depositary extends JFrame implements ActionListener{
	
	String[] record = new String[8];
	int flag = 0;
	String a = "";
	String[] b;
	
	public Depositary(){
		setSize(1300,1000);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		int i;
		for(i=0;i<8;i++)	record[i] = "";
		
		try {
			
			ImageIcon background = new ImageIcon("img/wall.jpg");
			JLabel bg = new JLabel(background);
			bg.setBounds(0, 0, this.getWidth(), this.getHeight());  
			this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));  
			JPanel imagePanel = (JPanel) this.getContentPane();  
			imagePanel.setOpaque(false);  
			
			Scanner scanner = new Scanner(new FileInputStream("bin/fill.txt"));
			int num = scanner.nextInt();
			//scanner.close();
			
			Scanner scanner2 = new Scanner(new FileInputStream("bin/save.txt"));
			String ImageName;
			//scanner2.close();
			
			Image img ;//= ImageIO.read (new File("small/egg5.png"));
			ImageIcon icon ;//= new ImageIcon(img);
			
			
			
			if(num >= 1){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button1 = new JButton(icon);
				button1.setBounds(0, 30, 300, 300); //(x,y,width,height)
				button1.setContentAreaFilled(false);
				button1.setBorderPainted(false);
				button1.setActionCommand("0");
				button1.addActionListener(this);
				add(button1);
				
				record[0] = ImageName; 
			}

			if(num >= 2){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button2 = new JButton(icon);
				button2.setBounds(300, 30, 300, 300); //(x,y,width,height)
				button2.setContentAreaFilled(false);
				button2.setBorderPainted(false);
				button2.setActionCommand("1");
				button2.addActionListener(this);
				add(button2);
				
				record[1] = ImageName; 
			}
			
			if(num >= 3){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button3 = new JButton(icon);
				button3.setBounds(600, 30, 300, 300); //(x,y,width,height)
				button3.setContentAreaFilled(false);
				button3.setBorderPainted(false);
				button3.setActionCommand("2");
				button3.addActionListener(this);
				add(button3);
				
				record[2] = ImageName; 
			}
			
			if(num >= 4){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button4 = new JButton(icon);
				button4.setBounds(900, 30, 300, 300); //(x,y,width,height)
				button4.setContentAreaFilled(false);
				button4.setBorderPainted(false);
				button4.setActionCommand("3");
				button4.addActionListener(this);
				add(button4);
				
				record[3] = ImageName; 
			}
			
			if(num >= 5){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button5 = new JButton(icon);
				button5.setBounds(0, 360, 300, 300); //(x,y,width,height)
				button5.setContentAreaFilled(false);
				button5.setBorderPainted(false);
				button5.setActionCommand("4");
				button5.addActionListener(this);
				add(button5);
				
				record[4] = ImageName; 
			}
			
			if(num >= 6){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button6 = new JButton(icon);
				button6.setBounds(300, 360, 300, 300); //(x,y,width,height)
				button6.setContentAreaFilled(false);
				button6.setBorderPainted(false);
				button6.setActionCommand("5");
				button6.addActionListener(this);
				add(button6);
				
				record[5] = ImageName; 
			}
			
			if(num >= 7){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button7 = new JButton(icon);
				button7.setBounds(600, 360, 300, 300); //(x,y,width,height)
				button7.setContentAreaFilled(false);
				button7.setBorderPainted(false);
				button7.setActionCommand("6");
				button7.addActionListener(this);
				add(button7);
				
				record[6] = ImageName; 
			}
			
			if(num == 8){
				ImageName = scanner2.next();
				img = ImageIO.read (new File("small/" + ImageName));
				icon = new ImageIcon(img);
				JButton button8 = new JButton(icon);
				button8.setBounds(900, 360, 300, 300); //(x,y,width,height)
				button8.setContentAreaFilled(false);
				button8.setBorderPainted(false);
				button8.setActionCommand("7");
				button8.addActionListener(this);
				add(button8);
				
				record[7] = ImageName; 
			}
			scanner2.close();
			scanner.close();
			JButton menu = new JButton();
			menu.setBounds(900, 700, 150, 150); //(x,y,width,height)
			menu.setIcon(new ImageIcon("img/menu.jpg"));
			
			menu.setActionCommand("menu");
			menu.addActionListener(this);
			add(menu);


			setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void actionPerformed(ActionEvent e){
		String choose = e.getActionCommand();
		
		if(choose == "menu"){
			flag = 1;
		}else{
			//new Deal(choose,record);
			flag = 2;
			a = choose;
			b = record;
			}

	}
	
	public int close(){
		return flag;
	}
	
	public String Data(){
		return a;
	}
	
	public String[] Data2(){
		return b;
	}

}
