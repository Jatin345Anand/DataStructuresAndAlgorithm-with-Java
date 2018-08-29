package Fundamental;

import java.util.Scanner;

public class Patterns {
	public static void NumberPattern(int n) {
		for(int i=0;i<n;i++) {
			System.out.println(i+1);
		}
	}
	public static void StarPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("X ");
			}
			System.out.println();
		}
	}
	public static void StarPattern2(int n) {
		for(int i=1;i<=n;i++) {
			for(int k=(n-i);k>=1;k--) {
				System.out.print(" ");
			}
			for(int j=1;j<=(2*i-1);j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	public static void NumberPattern2(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((j+1)+" ");
			}
			System.out.println();
		}
	}
	public static void NumberPattern3OrFluadTraingle(int n) {
		int x=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((x)+" ");
				x++;
			}
			System.out.println();
		}
	}
	public static void NumberPattern4(int n) {
		int x=0;
		for(int i=0;i<n;i++) {
			x=i+1;
			for(int j=0;j<=i;j++) {
				System.out.print((x)+" ");
				x++;
			}
			System.out.println();
		}
	}
	public static void NumberPattern5(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("1");
			}
			System.out.println();
		}
	}
	public static void NumberPattern6(int n) {
		if(n==1) {
			System.out.println("1");
		}
		else if(n>1) {
		 
		System.out.println("1");	
		for(int i=2;i<=n;i++) {
		    
			for(int j=1;j<=i;j++) {
				if(j==i || j==1)
				System.out.print(i-1);
				else
			    System.out.print("0");
				
			}
			
			System.out.println();
		}
		}
	}
	public static void NumberPattern7(int n) {
		int x=1;
		 
		for(int i=1;i<=(n);i++) {
			x=i;
			for(int k=((n-x)*2);k>=1;k--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print((x));
				x++;
			}
			System.out.println();
		}
	}
	public static void NumberPattern8(int n) {
		if(n==1) {
			System.out.println("1");
		}
		else if(n>1) {
		 
		System.out.println("1");	
		for(int i=2;i<=n;i++) {
		    
			for(int j=1;j<=i;j++) {
				if(j==i || j==1)
				System.out.print("1");
				else
			    System.out.print("2");
				
			}
			
			System.out.println();
		}
		}
	}
	public static void NumberPattern9(int n) {
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	System.out.println("Enetr the n...");
	int n = scanner.nextInt();
//	NumberPattern(n);
//	StarPattern(n);
//	NumberPattern2(n);
//	NumberPattern3OrFluadTraingle(n);
//	NumberPattern4(n);
//	NumberPattern5(n);
//	NumberPattern6(n);
//	NumberPattern7(n);
//	NumberPattern8(n);
//	NumberPattern9(n);
 StarPattern2(n);
	scanner.close();
}
}
