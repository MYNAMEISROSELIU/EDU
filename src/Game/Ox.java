package Game;


import java.awt.event.*;


import javax.swing.*;



public class Ox extends Game implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private ImageIcon em,img_o,img_x;
	private int turn=0,winner=2;
	private int[] map={0,0,0,0,0,0,0,0,0};
	JButton[] icon=new JButton[9];
	
	public Ox(){
		this.loop=true;
		this.name="OOXX";
		em=new ImageIcon("img/e.png");

		img_o=new ImageIcon("img/O.png");

		img_x=new ImageIcon("img/X.png");
		
		ImageIcon img=new ImageIcon("img/OOXX_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(S_X, S_Y);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		this.setSize(500,500);
		this.setLocation(L_X,L_Y);
		this.addWindowListener(new W_Listener());;			
		this.setLayout(null);
		this.setResizable(false);
		
		for(int i=0;i<9;i++){
		icon[i]=empty(i);
		icon[i].addActionListener(this);
		icon[i].setContentAreaFilled(false);
		icon[i].setVisible(false);
		this.add(icon[i]);
		icon[i].setActionCommand(""+i);
		}
		
	}
	
	public void run(){
		running=true;	
		
		this.setVisible(true);
		this.help();
		for(int i=0;i<9;i++)icon[i].setVisible(true);
		
	//	while (running);
		while(running)try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
				
		
	}

	
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("OK")){
			loop=false;
		}
		else{
			int i =Integer.valueOf(e.getActionCommand());		
			if(running){
				if(map[i]==0){
					icon[i].setIcon(img_o);
					map[i]=1;
					turn++;
					checkEnd();
					ai_action();
				}
			}
		}
	}
	private void ai_action(){
		if(running){
			
			
		int i=(int) (Math.random()*10)%9;
		while(map[i]!=0)i=(int) (Math.random()*10)% 9;
		for(int j=0;j<9;j+=3){
	        if(map[j]==map[j+1]){
	            if(map[j]!=0){
	            	if(map[j+2]==0)
	            		i=j+2;
	            }
	        }
	        else if (map[j]==map[j+2]){
	        	if(map[j]!=0){
	            	if(map[j+1]==0)
	            		i=j+1;
	            }
	        }
	        else if (map[j+1]==map[j+2]){
	        	if(map[j+1]!=0){
	            	if(map[j]==0)
	        		i=j;
	            }
	        }	        		
		}
		
		for(int j=0;j<3;j++){
	        if(map[j]==map[j+3]){
	            if(map[j]!=0){
	            	if(map[j+6]==0)
	            		i=j+6;
	            }
	        }
	        else if (map[j]==map[j+6]){
	        	if(map[j]!=0){
	            	if(map[j+3]==0)
	            		i=j+3;
	            }
	        }
	        else if (map[j+3]==map[j+6]){
	        	if(map[j+3]!=0){
	            	if(map[j]==0)
	        		i=j;
	            }
	        }	        		
		}
		
		if(map[0]==map[4]){
            if(map[0]!=0){
                if(map[8]==0)
                	i=8;
            }
        }
		if(map[0]==map[8]){
            if(map[0]!=0){
                if(map[4]==0)
                	i=4;
            }
        }
		if(map[4]==map[8]){
            if(map[4]!=0){
                if(map[0]==0)
                	i=0;
            }
        }
		if(map[2]==map[6]){
            if(map[2]!=0){
                if(map[4]==0)
                	i=4;
            }
        }
		if(map[2]==map[4]){
            if(map[2]!=0){
                if(map[6]==0)
                	i=6;
            }
        }
		if(map[4]==map[6]){
            if(map[4]!=0){
                if(map[2]==0)
                	i=2;
            }
        }
		
		map[i]=2;
		icon[i].setIcon(img_x);
		
		turn++;	
		checkEnd();}
		}
	
	
	private void checkEnd(){
		
		//橫向
		for(int i=0;i<9;i+=3){
	        if((map[i]==map[i+1])&&(map[i]==map[i+2])){
	            if(map[i]!=0){
	                winner=map[i];
	                running=false;
	                
	            }
	        }
	    }
		
		//縱向
		for(int i=0;i<3;++i){
	        if((map[i]==map[i+3])&&(map[i]==map[i+6])){
	            if(map[i]!=0){
	                winner=map[i];
	                running=false;
	            }
	        }
	    }
		//斜向
		
	        if((map[0]==map[4])&&(map[0]==map[8])){
	            if(map[0]!=0){
	                winner=map[0];
	                running=false;
	            }
	        }
	        if((map[2]==map[4])&&(map[2]==map[6])){
	            if(map[2]!=0){
	                winner=map[2];
	                running=false;
	            }
	        }
	    if(turn>8){
	    	winner=0;
	    	running=false;
	    }
	   // if(!running)this.close();
		
		
	}
	
	
	
	private JButton empty(int m){

		int x,y;
		x=(m%3)*100;
		y=(m/3)*100;
		
		JButton icon=new JButton(em);
		icon.setLocation(100+x,100+y);
		icon.setSize(100,100);
		return icon;
	}
	

	public boolean isRunning(){
		return running;
	}
	
	public boolean result(){
		boolean res=false;
		switch(winner){
		case 0:
			int n=(int)(Math.random()*10)%2;
			if(n==0)
				res=true;
			else
				res=false;
			break;
		case 1:
			res=true;
		break;
		case 2:
			res=false;
			break;
		}
		
		return res;
	}

}
