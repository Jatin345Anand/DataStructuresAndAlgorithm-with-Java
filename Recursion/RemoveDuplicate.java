package Recursion;

import java.util.Scanner;

public class RemoveDuplicate {
	 public static String helper(String s,String d)
	    {
	      if(s.length()==0)
	      {
	        return d;
	      }
	      char Currentchar=s.charAt(0);
	       d=d+Currentchar;
	      while(s.length()!=0 && Currentchar==s.charAt(0))
	      {
	        s=s.substring(1);
	      }
	      return helper(s,d);
	    }
	  
		public static String removeConsecutiveDuplicates(String s) 
	    {
	        return helper(s,"");
		}

public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("Enter the string...");
	 String S= scanner.next();
	System.out.println( removeConsecutiveDuplicates(S));
	 
	 scanner.close();
}
}
