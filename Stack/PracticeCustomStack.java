package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PracticeCustomStack {
	public static boolean checkBalanced(String exp) {
	 	Stack<Character> stLeft = new Stack<>();
		  char[] lo = {'(','{','['};
	   char[] ro = {')','}',']'};
 	   boolean ans=false; 
	   boolean isAuth=false; 
	   
	   for(int i=0;i<exp.length();i++) {
		   if(exp.charAt(i)==lo[0] || exp.charAt(i)==lo[1] || exp.charAt(i)==lo[2] || exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2]) {
			   if( exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2] ) {
	 			   ans=false;
				   isAuth=true;
 			   }
			   break;
		   }
	   }
 	    if(!isAuth) {
		for(int i=0;i<exp.length();i++) {
			if(exp.charAt(i)==lo[0] || exp.charAt(i)==lo[1] || exp.charAt(i)==lo[2] ) {
				stLeft.push( exp.charAt(i) );
			}
			else if( exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2] ) {
 				if(  (exp.charAt(i)==ro[0]   && stLeft.peek()==lo[0]) || (exp.charAt(i)==ro[1]   && stLeft.peek()==lo[1]) || (exp.charAt(i)==ro[2]   && stLeft.peek()==lo[2]) ) {
 					stLeft.pop();
				}
			}
		}
	    
 		if(stLeft.size()==0) {
			ans=true;
		}
	}
		return ans;


	}
	public static  Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
     System.out.println("Enter the String Expression....");     	
     String Expression = scanner.nextLine();
     System.out.println(checkBalanced(Expression));
     scanner.close();
    }
}
