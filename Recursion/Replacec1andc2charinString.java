package Recursion;

import java.util.Scanner;

public class Replacec1andc2charinString {

	public static String ReplaceCharacters(String S,char c1,char c2) {
		if(S.length()<1) {
			return S;
		}
		if(S.charAt(0)==c1) {
			S= c2 +S.substring(1);
		}
		/// here firstly we take first character (base case) of the string ...
		System.out.println(S);
		return S.charAt(0)+ReplaceCharacters(S.substring(1, S.length()), c1, c2);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the string...");
		String S= scanner.next();
		System.out.println("Enter the first character...");
		String s1 = scanner.next();
		System.out.println("Enter the second character...");
		String s2 = scanner.next();
		
		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
	     
		
	 	
       		 
		System.out.println( ReplaceCharacters(S,c1,c2));
		 
		 
		 scanner.close();
	}

}
