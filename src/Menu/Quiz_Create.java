package Menu;


import java.util.*;
import java.io.*;

public class Quiz_Create {
	static public void create(){
		String str;
		String[] exp;
		QuizForm quiz;
		ObjectOutputStream output;
		int n=0;
	try{
		Scanner in = new Scanner(new FileInputStream("quiz.txt"));
		PrintWriter pr=new PrintWriter(new FileOutputStream("quiz/num.txt"));
		 while(in.hasNextLine()){
			 str=in.nextLine();
			 exp=str.split("0");
			// System.out.println(exp[0]+"\t"+exp[1]+"\t"+exp[3]+"\t"+exp[4]);
			 quiz=new QuizForm(exp[0],exp[1],exp[2],exp[3],exp[4]);
		
			 try{
				 output=new ObjectOutputStream(new FileOutputStream("quiz/"+n+".obj"));
				 output.writeObject(quiz);
				 output.flush();
				 output.close();
			 }catch(Exception e){        
				 e.printStackTrace();
			 }
			 n++;
			// System.out.println(n);
		 }
		 
		 pr.print(n);
		 pr.flush();
		 pr.close();
		 
		 
		in.close();
	}catch(Exception e){
		e.printStackTrace();
		}
	
	
	}
}
