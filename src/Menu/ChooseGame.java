package Menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseGame extends JFrame implements ActionListener{
	
	int command = 1;
	
	public ChooseGame(){
		setSize(800,800);
		setLocation(500,100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		try {
			
			JButton button1 = new JButton();
			button1.setBounds(100,0,200,100);
			button1.setText("OX");
			button1.setActionCommand("OX");
			button1.addActionListener(this);
			add(button1);
			
			JButton button2 = new JButton();
			button2.setBounds(400,0,200,100);
			button2.setText("PaperScissorsStone");
			button2.setActionCommand("PSS");
			button2.addActionListener(this);
			add(button2);
			
			JButton button3 = new JButton();
			button3.setBounds(100,200,200,100);
			button3.setText("Cooking");
			button3.setActionCommand("Cooking");
			button3.addActionListener(this);
			add(button3);

			JButton button4 = new JButton();
			button4.setBounds(400,600,200,100);
			button4.setText("Menu");
			button4.setActionCommand("menu");
			button4.addActionListener(this);
			add(button4);
			
			JButton button5 = new JButton();
			button5.setBounds(400,400,200,100);
			button5.setText("Quiz");
			button5.setActionCommand("quiz");
			button5.addActionListener(this);
			add(button5);
			
			JButton button6 = new JButton();
			button6.setBounds(100,400,200,100);
			button6.setText("Mouse");
			button6.setActionCommand("mouse");
			button6.addActionListener(this);
			add(button6);
			
			JButton button7 = new JButton();
			button7.setBounds(100,600,200,100);
			button7.setText("Memory");
			button7.setActionCommand("memory");
			button7.addActionListener(this);
			add(button7);
			
			JButton button8 = new JButton();
			button8.setBounds(400,200,200,100);
			button8.setText("Smile");
			button8.setActionCommand("smile");
			button8.addActionListener(this);
			add(button8);
			
			setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
        if (cmd == "OX") {
        	
        	//new Ox();
        	
        	command = 2;
        }
        
        if(cmd == "PSS"){
        	
        	command = 3;
        }
        if(cmd == "Cooking"){
        	command = 4;
        }
        
        if(cmd == "menu"){
        	dispose();
        	command = 5;
        }
        
        if(cmd == "quiz"){
        	command = 9;
        }
        
        if(cmd == "mouse"){
        	command = 10;
        }
        
        if(cmd == "memory"){
        	
        	command = 11;
        }
        
        if(cmd == "smile"){
        	
        	command = 12;
        }
		

	}
	
	public int Choose(){
		return command;
	}

	
	public void run(){
		this.setVisible(true);
		
	}
}
