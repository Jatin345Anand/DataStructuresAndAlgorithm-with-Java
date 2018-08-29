package Recursion;

import java.util.Scanner;

public class StairCase {
	public static int WaysofStairs(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return WaysofStairs(n-1)+WaysofStairs(n-2)+WaysofStairs(n-3);
	}
   public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the number of stairs...");
	int n = scanner.nextInt();
	System.out.println("Number of Possible Ways is = "+WaysofStairs(n));
	scanner.close();
}
}
