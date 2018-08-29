package Recursion;

import java.util.Scanner;

public class RemoveConsecutiveDuplicatesinString {

	public static String RemoveDuplicate(String S) {
		if(S.length()<=1) {
//			System.out.println("yes");
			return S;
		}
		
			if(S.charAt(0) == S.charAt(1)) {
			S= S.charAt(1)+S.substring(2);
			return S;
			}
			
			 
		
//		return S.charAt(index)
//		System.out.println(S.charAt(0));
//		System.out.println(S.length());
//		System.out.println(S.charAt(S.length()-1));
//      return S.charAt(0)+RemoveDuplicate(S.substring(1,S.length()));
//		System.out.println(S.substring(1, S.length()));
		System.out.println("S = "+S);
	    return  S.substring(1);
	}
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the string...");
		 String S= scanner.next();
		System.out.println( RemoveDuplicate(S));
		 
		 scanner.close();
	}

}
