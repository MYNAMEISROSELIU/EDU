package Menu;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Shop extends JDialog implements ActionListener{
	
	JLabel label2;
	int flag = 0;
	
	public Shop(){
		setSize(1300,998);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		try {
			
			ImageIcon background = new ImageIcon("img/shop.jpg");
			JLabel bg = new JLabel(background);
			bg.setBounds(0, 0, this.getWidth(), this.getHeight());  
			this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));  
			JPanel imagePanel = (JPanel) this.getContentPane();  
			imagePanel.setOpaque(false);  
			
			
			Image img = ImageIO.read (new File("img/egg1.png"));
			ImageIcon icon = new ImageIcon(img);
			JButton button1 = new JButton(icon);
			button1.setBounds(10, 200, 300, 500); //(x,y,width,height)
			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button1.setActionCommand("egg1");
			button1.addActionListener(this);
			add(button1);
			
			img = ImageIO.read (new File("img/egg3.png"));
			icon = new ImageIcon(img);
			JButton button2 = new JButton(icon);
			button2.setBounds(320, 200, 300, 500); //(x,y,width,height)
			button2.setContentAreaFilled(false);
			button2.setBorderPainted(false);
			button2.setActionCommand("egg3");
			button2.addActionListener(this);
			add(button2);
			
			img = ImageIO.read (new File("img/egg4.png"));
			icon = new ImageIcon(img);
			JButton button3 = new JButton(icon);
			button3.setBounds(630, 200, 300, 500); //(x,y,width,height)
			button3.setContentAreaFilled(false);
			button3.setBorderPainted(false);
			button3.setActionCommand("egg4");
			button3.addActionListener(this);
			add(button3);
			
			img = ImageIO.read (new File("img/egg5.png"));
			icon = new ImageIcon(img);
			JButton button4 = new JButton(icon);
			button4.setBounds(940, 200, 300, 500); //(x,y,width,height)
			button4.setContentAreaFilled(false);
			button4.setBorderPainted(false);
			button4.setActionCommand("egg5");
			button4.addActionListener(this);
			add(button4);
			
			JButton button5 = new JButton();
			button5.setBounds(1150, 0, 150, 150); //(x,y,width,height)
			button5.setIcon(new ImageIcon("img/menu.jpg"));
			button5.setActionCommand("menu");
			button5.addActionListener(this);
			add(button5);

			
			//=========================================
			icon = new ImageIcon(ImageIO.read(new File("img/money.png")));
			JLabel label1 = new JLabel(icon);
			label1.setBounds(10,0,72,71);
			add(label1);
			
			Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
			String money = scanner.next();
			scanner.close();
			label2 = new JLabel();
			label2.setText(money);
			label2.setFont(new Font("標楷體", Font.BOLD, 48));
			label2.setBounds(92,0,300,75);
			add(label2);
			
			JTextArea label3 = new JTextArea();
			
			label3.setEditable(false);
			
			label3.setText("NT100\n最普通的蛋\n");
			label3.setFont(new Font("標楷體", Font.BOLD, 28));
			label3.setBounds(10,700,300,300);
			label3.setOpaque(false);
			add(label3);
			
			JTextArea label4 = new JTextArea();
			
			label4.setEditable(false);
			
			label4.setText("NT300\n一定機率孵出超稀有\n寵物~~\n");
			label4.setFont(new Font("標楷體", Font.BOLD, 28));
			label4.setBounds(320,700,300,300);
			label4.setOpaque(false);
			add(label4);
			
			JTextArea label5 = new JTextArea();
			
			label5.setEditable(false);
			
			label5.setText("NT1000\n超高機率孵出超稀有\n寵物~~ˊˇˋ\n");
			label5.setFont(new Font("標楷體", Font.BOLD, 28));
			label5.setBounds(630,700,300,300);
			label5.setOpaque(false);
			add(label5);
			
			JTextArea label6 = new JTextArea();
			
			label6.setEditable(false);
			
			label6.setText("NT1000\n必定孵出獸族寵物的\n特殊蛋\n");
			label6.setFont(new Font("標楷體", Font.BOLD, 28));
			label6.setBounds(940,700,300,300);
			label6.setOpaque(false);
			add(label6);

			setVisible(true);
			setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}

	
	public void actionPerformed(ActionEvent e){
		String buy = e.getActionCommand();
        if (buy == "egg1") {
        	new Buy(1);
        	try{
        		Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
    			String money = scanner.next();
    			scanner.close();
    			label2.setText(money);

			}catch(FileNotFoundException e2){
				e2.printStackTrace();
			}
        }else if(buy == "egg3"){
        	new Buy(3);
        	try{
        		Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
    			String money = scanner.next();
    			scanner.close();
    			label2.setText(money);

			}catch(FileNotFoundException e2){
				e2.printStackTrace();
			}
        }else if(buy == "egg4"){
        	new Buy(4);
        	try{
        		Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
    			String money = scanner.next();
    			scanner.close();
    			label2.setText(money);

			}catch(FileNotFoundException e2){
				e2.printStackTrace();
			}
        }else if(buy == "egg5"){
        	 new Buy(5);
         	try{
        		Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
    			String money = scanner.next();
    			scanner.close();
    			label2.setText(money);

			}catch(FileNotFoundException e2){
				e2.printStackTrace();
			}
        }else{
        	flag = 1;
        }

	}
	
	public int close(){
		return flag;
	}
}
