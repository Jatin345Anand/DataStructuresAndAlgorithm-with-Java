package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static ArrayList<Integer> smallestSubarray(int sum, ArrayList<Integer> input) {
	    System.out.println(input);
	    //6
	    //1 3 5 6 4 3
	    //9
		int sum1=0;
		int sum2=0;
		int Sum =0;
		for(int i=0;i<input.size();i++) {
			Sum +=input.get(i);
			System.out.println(Sum);
		}
		System.out.println("Sum is "+Sum);
		for(int i=0;i<input.size();i++) {
			sum1 += input.get(i);
			System.out.println(sum1);
			if(sum1>sum) {
				System.out.println("Done Sum1 is "+sum1);
				break;
			}
		}
		for(int i=input.size()-1;i>=0;i--) {
			Sum = Sum - input.get(i);
			System.out.println(Sum);
			if(Sum<sum) {
				System.out.println("Done Sum2 is "+Sum);
				break;
			}
		}
		return input;
	}
	public static void FillArrayList(ArrayList<Integer> AL) {
		System.out.println("Enter the size...");
		int n = scanner.nextInt();
		for(int i=0;i<n;i++) {
			AL.add(scanner.nextInt());
		}
		System.out.println("Enter the value of X...");
	}
	public static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> AL = new ArrayList<>();
		FillArrayList(AL);
		int sum=scanner.nextInt();
        smallestSubarray(sum, AL);
        scanner.close();
	}
}
