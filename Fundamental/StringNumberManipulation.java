package Fundamental;

import java.util.ArrayList;
import java.util.Scanner;

public class StringNumberManipulation 
{
	public static void FindSumEvenOdd(int n) {
 		int EVEN =0;
		int ODD=0;
		for(int i=0;i<String.valueOf(n).length();i++) {
			if(Integer.parseInt(String.valueOf(String.valueOf(n).charAt(i)))%2==0) {
				EVEN=EVEN+Integer.parseInt(String.valueOf(String.valueOf(n).charAt(i)));
			}
			else {
				ODD=ODD+Integer.parseInt(String.valueOf(String.valueOf(n).charAt(i)));
			}
		}
		System.out.println(EVEN+" "+ODD);
	}
	public static int FindFactor(int n) {
		int ans;
		ArrayList<Integer> AL = new ArrayList<>();
		for(int i=2;i<n;i++) {
		 	if(n%i==0) {
		 		AL.add(i);
		 	}
		}
		return AL.size();
		}
	public static void PrintALLPrime(int n) {
		ArrayList<Integer> AL= new ArrayList<>();
		for(int i=2;i<=n;i++) {
			 if(FindFactor(i)==0) {
				 AL.add(i);
			 }
		} 
		for(int i=0;i<AL.size();i++) {
			System.out.println(AL.get(i));
		}
	}
	public static void FindSalary(int BASIC,char GRADE) {
		int hra=(int) (0.2*BASIC);
		int da =(int) (0.5*BASIC);
		int pf =(int) (0.11*BASIC);
		int allow=0;
	 
		if(GRADE=='A') {
			allow=1700;
		}
		else if(GRADE=='B') {
			allow=1500;
		}
		else {
			allow=1300;
		}
		System.out.println(((BASIC+hra+da+allow)-pf));
	}
	public static Scanner scanner = new Scanner(System.in);
	   public static long Power(int x,int n){
	     if(n==0){
	       return 1;
	     }
	     if(n==1){
	       return x;
	     }
	     return x*Power(x, n-1);
	     
	   }
	   public static void isUpperLowerChar(char C){
		    System.out.println(C);
		  }
	   public static void printFahrenheitTable(int start, int end, int step) {
		//90 432 31 2
	    
		//36 618 78 1
        //1
//		   36	2
//		   114	45
//		   192	88
//		   270	132
//		   348	175
//		   426	218
//		   504	262
//		   582	305
//         2
		 //29 221 55 
//29	-1
//84	28
//139	59
//194	90
//		   90	32
//		   121	49
//		   152	66
//		   183	83
//		   214	101
//		   245	118
//		   276	135
//		   307	152
//		   338	170
//		   369	187
//		   400	204
//		   431	221
		   double S= ((start-32)/(1.8));
		   System.out.println(S);
		   String S1="";  
		   S1.valueOf(S);
           System.out.println(S1);

			
		}
public static void main(String[] args) {
	System.out.println("Enter input...");
//	 String S= scanner.next();
//     isUpperLowerChar(S.charAt(0));
//	int x = scanner.nextInt();
	int start = scanner.nextInt();
	int end =scanner.nextInt();
	int step =scanner.nextInt();
	printFahrenheitTable(start, end, step);
//	String s = scanner.next();
//	FindSalary(n, s.charAt(0));
//	   System.out.println(Power(x,n));
	//   FindSumEvenOdd(n);
//	PrintALLPrime(n);
	      scanner.close();
}
}
