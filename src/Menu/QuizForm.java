package Menu;

import java.io.Serializable;

public class QuizForm implements Serializable {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1233;
	private String anser,q;
	private String[] choice=new String[3];
	public QuizForm(String question,String ans,String c1,String c2,String c3){
		q=question;
		anser=ans;
		choice[0]=c1;
		choice[1]=c2;
		choice[2]=c3;		
	}
	
	public String getAanser(){
		return anser;
	}
	public String getChoice(int n){
		return choice[n];
	}
	public String getQuestion(){
		return q;
	}

}