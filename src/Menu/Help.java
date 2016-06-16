package Menu;
import java.awt.Font;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.*;

public class Help extends JDialog{
	
	public Help(){
		this.setSize(500,500);
		this.setLocation(300, 250);
		this.setTitle("help");
		
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		ImageIcon img=new ImageIcon("img/help_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(500, 500);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		String str="";
		try{
			Scanner s=new Scanner(new FileInputStream("help/help.txt"));
			while(s.hasNext()){
				str=str.concat(s.nextLine()+"\n");
			}
			
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JTextPane text =new JTextPane();
		
		text.setSize(380,350);
		text.setLocation(50,50);
		text.setText(str);
		text.setOpaque(false);
		text.setEditable(false);
		text.setFont(new Font(Font.DIALOG,Font.BOLD ,20));
		text.setVisible(true);
		
		this.add(text);
		this.setVisible(true);
		
	}

}
