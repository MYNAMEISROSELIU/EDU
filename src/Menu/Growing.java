package Menu;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Growing {
	
	
	static public void grow(int type){
		
		int v_g=0,w_g=0,x_g=0,y_g=0,z_g=0;
		try{
			Scanner in = new Scanner(new FileInputStream("bin/keep.txt"));
			String being=in.next();
			String which=in.next();
			
			String v=in.next();
			String w=in.next();
			String x=in.next();
			String y=in.next();
			String z=in.next();
			
			in.close();
			
			int n = (int)(Math.random()*100); 
			
			switch(type){
			case 0:
				// v= 0-2,w= 0-4, x=0-2 , y=3-5 , z=0-2  // 突出 Y 小幅
				v_g=n%3;
				w_g=n%5;
				x_g=n%3;
				y_g=n%3+3;
				z_g=n%3;
				break;
			case 1:
				// v= 1-2, w=5-9,x=5-9,y=1-2,z=1-2	// 突出 W X 
				v_g=n%2+1;
				w_g=n%5+5;
				x_g=n%5+5;
				y_g=n%2+1;
				z_g=n%2+1;
				break;
			case 2:
				// v=5-9 ,w=0-3 ,x=0-2 ,y=0-4 , z=0-1 // 突出 V
				v_g=n%5+5;
				w_g=n%4;
				x_g=n%3;
				y_g=n%5;
				z_g=n%2;
				break;
			case 3:
				//v=0-2 ,w=0-4 ,x=0-1 ,y=0-7 ,z=5-9 //突出 Z
				v_g=n%3;
				w_g=n%5;
				x_g=n%2;
				y_g=n%7;
				z_g=n%5+5;
				break;
			case 4:
				// v=0-3 ,w=3-5 ,x=0-1 ,y=0-2 ,z=0-2, // 突出W 小幅
				v_g=n%4;
				w_g=n%3+3;
				x_g=n%2;
				y_g=n%3;
				z_g=n%3;
				break;
			case 5:
				// random 其中一個+ 2-7
				switch(((int) (Math.random()*100)%5)){
				case 0:
					v_g=2+n%5;
					break;
				case 1:
					w_g=2+n%5;
					break;
				case 2:
					x_g=2+n%5;
					break;
				case 3:
					y_g=2+n%5;
					break;
				case 4:
					z_g=2+n%5;
					break;
				}
				break;
			case 6:
				// v= 0-2, w=0-1, x=3-5,y=0-3,z=0-2;
				v_g=n%3;
				w_g=n%2;
				x_g=n%3+3;
				y_g=n%4;
				z_g=n%3;
				break;
			
			default:
				break;
			
			}
			String[] str={""+v_g,""+w_g,""+x_g,""+y_g,""+z_g};
			new Mes(str);
			
			v=String.valueOf(Integer.valueOf(v)+v_g);
			w=String.valueOf(Integer.valueOf(w)+w_g);
			x=String.valueOf(Integer.valueOf(x)+x_g);
			y=String.valueOf(Integer.valueOf(y)+y_g);
			z=String.valueOf(Integer.valueOf(z)+z_g);
			PrintWriter pr = new PrintWriter(new FileOutputStream("bin/keep.txt"));
			pr.print(being+"\t"+which+"\t"+v+"\t"+w+"\t"+x+"\t"+y+"\t"+z);
			pr.flush();
			pr.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
	}
	static public void fail(){
		new Mes();
		
	}
	
	static class Mes extends JFrame implements ActionListener{
		JLabel[] lab=new JLabel[5];
		
		public Mes(String [] str){
			this.setAlwaysOnTop(true);
			ImageIcon img=new ImageIcon("img/main_b.jpg");
			JLabel bg=new JLabel(img);
			bg.setSize(500, 500);
			this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
			JPanel p= (JPanel)this.getContentPane();
			p.setOpaque(false);
			
			this.setSize(500,250);
			this.setLocation(500,400);
			this.setLayout(null);
			
			JButton btn = new JButton("OK");
			btn.setSize(100,50);
			btn.setLocation(200,150);
			btn.setFont(new Font("標楷體",Font.BOLD,24));
			btn.addActionListener(this);
			this.add(btn);
			
			JLabel text=new JLabel("增加了屬性");
			text.setSize(200,50);
			text.setLocation(150,30);
			text.setFont(new Font("標楷體",Font.BOLD,24));
			this.add(text);
			
			for(int i=0;i<5;i++){			
				lab[i]=new JLabel();
				lab[i].setText(str[i]);
				lab[i].setIcon(new ImageIcon("img/"+(i+1)+".PNG"));
				lab[i].setSize(100,60);
				lab[i].setLocation(100*i, 70);
				lab[i].setFont(new Font("標楷體",Font.BOLD ,40));
				this.add(lab[i]);
			}
			this.setVisible(true);
		}
		
		public Mes(){
			this.setAlwaysOnTop(true);
			ImageIcon img=new ImageIcon("img/main_b.jpg");
			JLabel bg=new JLabel(img);
			bg.setSize(500, 500);
			this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
			JPanel p= (JPanel)this.getContentPane();
			p.setOpaque(false);
			
			this.setSize(500,250);
			this.setLocation(500,400);
			this.setLayout(null);
			
			JButton btn = new JButton("OK");
			btn.setSize(100,50);
			btn.setLocation(200,150);
			btn.setFont(new Font("標楷體",Font.BOLD,24));
			btn.setForeground(Color.red);
			btn.addActionListener(this);
			this.add(btn);
			
			JLabel text=new JLabel("成長失敗   QAQ");
			text.setSize(350,100);
			text.setLocation(150,30);
			text.setFont(new Font("標楷體",Font.BOLD,34));
			this.add(text);
			
			
			this.setVisible(true);
		}
	
		public void actionPerformed(ActionEvent e) {
			this.dispose();
			
		}
		
		
		
	}

}
