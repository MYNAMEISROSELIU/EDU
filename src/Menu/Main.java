package Menu;

//import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		M control = null;
		int flag = 0;
		String data = "";
		String[] data2 ={};
		
		
		Save sa=new Save(1300,1000,0);		
		
		control=sa.getM();

		
		while(true){
			try{
				
				if(flag == 0){
					Thread.sleep(20);
					Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
					String money = scanner.next();
					control.setText(money);
					scanner.close();
					
					flag = control.choose();
				}
				
				if(flag == 1){
//					control.dispose();
					ChooseGame p = new ChooseGame();

				    while(flag == 1){
				    	try{ 
				    		p.run();
				    		Thread.sleep(20);
				    		flag = p.Choose();
				    		
				    		
				    		if(flag == 0){
				    			p.dispose();
				    			//	control = new M();
				    		}

				    	}catch(Exception e){
				    			e.printStackTrace();
				    	}
				    }
				    p.dispose();
				}
				
				if(flag == 2){
					
					Ox p1 = new Ox();
					p1.run();

					//System.out.println(p1.result());
					if(p1.result() == true){
						
						Growing.grow(1);
						
					}else Growing.fail();
					Thread.sleep(2000);
					p1.close();

					flag = 1;

				}
				
				if(flag == 3){
					
					PaperScissorsStone p2 = new PaperScissorsStone();
					p2.run();

					//System.out.println(p2.result());
					if(p2.result() == true){

						
						Growing.grow(2);
					}
					Thread.sleep(2000);
					p2.close();
					
					flag = 1;

				}
				
				if(flag == 4){
					
					Cooking p3 = new Cooking();
					p3.run();

					//System.out.println(p3.result());
					if(p3.result() == true){
						
						Growing.grow(3);
						
					}
					else Growing.fail();
					
					Thread.sleep(2000);
					p3.close();
					
					flag = 1;

				}
				
				if(flag == 5){
			
					//control.setFlag(0);
//					control = new M();
					flag = 0;
				}
				
				if(flag == 6){
//					control.dispose();
					
					Shop p4 = new Shop();
					int c = p4.close();
					while(c == 0){
						
				    	try{ 

				    		Thread.sleep(20);
				    		c = p4.close();
	
				    	}catch(Exception e){
				    			e.printStackTrace();
				    	}
					}
					p4.dispose();
					flag = 0;
//					control = new M();
					
				}
				
				if(flag == 7){
//					control.dispose();
					
					Depositary p5 = new Depositary();
					int c = p5.close();
					while(c == 0){
						
				    	try{ 

				    		Thread.sleep(20);
				    		c = p5.close();
	
				    	}catch(Exception e){
				    			e.printStackTrace();
				    	}
					}
					if(c == 1){
						p5.dispose();
						flag = 0;
//						control = new M();
					}
					if(c == 2){
						data = p5.Data();
						data2 = p5.Data2();
						p5.dispose();
						flag = 8;
					}
				}
				
				if(flag == 8){		
					Deal p6 = new Deal(data,data2);
					int c = p6.close();
					while(c == 0){
						
				    	try{ 

				    		Thread.sleep(20);
				    		c = p6.close();
	
				    	}catch(Exception e){
				    			e.printStackTrace();
				    	}
					}

						p6.dispose();
						flag = 7;

				}
				
				if(flag == 9){
					
					Quiz p7 = new Quiz();
					p7.run();

					System.out.println(p7.result());
					if(p7.result() == true){
						
						Growing.grow(4);
						
					}else Growing.fail();
					Thread.sleep(2000);
					p7.close();
					
					flag = 1;

				}
				
				if(flag == 10){
					
					Reaction p8 = new Reaction();
					p8.run();

					System.out.println(p8.result());
					if(p8.result() == true){
						
						Growing.grow(5);
						
					}else Growing.fail();
					Thread.sleep(2000);
					p8.close();
					
					flag = 1;

				}
				
				if(flag == 11){
					
					MemoryGame p9 = new MemoryGame();
					p9.run();

					System.out.println(p9.result());
					if(p9.result() == true){
						
						Growing.grow(1);
						
					}else Growing.fail();
					Thread.sleep(500);

					
					flag = 1;

				}
				
				if(flag == 12){
					SmileGame p10 = new SmileGame();
					p10.run();

					System.out.println(p10.result());
					if(p10.result() == true){
						
						Growing.grow(2);
						
					}else Growing.fail();
					Thread.sleep(500);

					
					flag = 1;
					
				}
				
				}catch(Exception e){
					e.printStackTrace();
					}
		}


	}

}
