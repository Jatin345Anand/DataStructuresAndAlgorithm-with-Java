package Recursion;

import java.util.Scanner;

public class TowerofHanoi {

	public static int TOH(int n,String A,String B,String C) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			System.out.println(A +"  -->  "+C);
			return 1;
		}
		int o1= TOH(n-1,A,C,B);
		int o2= TOH(1,A,B,C) ;
		int o3= TOH(n-1,B,A,C);
		
		return o1+o2+o3;
		
		 
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of disks...");
		int n = scanner.nextInt();
		//A = Source
		//B = Auxiliary
		//C = Destination
		System.out.println("Number of Possible Ways to move disks Source to Destination : \n");
	System.out.print(	TOH(n,"A","B","C"));
		scanner.close(); 
	}

}
