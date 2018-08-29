package Fundamental;
import java.util.Scanner;

public class CharacterPatterns {
	public static void CharPattern(int n) {
		char X=65;
		for(int i=1;i<=n;i++) {
		  for(int j=1;j<=i;j++) {
			  System.out.print(X);	  
		  }
		  X++;
		  System.out.println();
		}
	 
	}
	public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	System.out.println("Enetr the n...");
	int n = scanner.nextInt();
	CharPattern(n);
	scanner.close();
    }
}
