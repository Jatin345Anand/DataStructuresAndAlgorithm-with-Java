package Recursion;

import java.util.Scanner;

public class BinarySearchRecursion {
	public static void print(int[] A) {
    System.out.println();
    for(int i=0;i<A.length;i++) {
     System.out.print(A[i]+" ");	
    }
    System.out.println();
  	}
	public static int Medium(int[] A,int s,int e) {
//		System.out.println(A.length);
		int L = e-s;
		if((L%2)==0) {
			return s+(L/2);
		}
		else {
		    return s+(L/2);	
		}
		
	}
	public static int BSR(int[] A,int s,int startIndex,int endIndex) {
		
//        print(A);
		
//       System.out.println(Medium(A));
		if(endIndex >= startIndex) {
			int mid = Medium(A,startIndex,endIndex);
			if(A[mid]==s) {
				return mid;
			}
			if(A[mid]>s) {
				return BSR(A, s, startIndex, mid-1);
			}
			if(A[mid]<s) {
				return BSR(A, s, mid+1, endIndex);
			}	
		}
		return -1;
		
	}
 public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the size of array...");
	int n = scanner.nextInt();
	System.out.println("Enter the elements in incresing order...");
    int[] A = new int[n];
    
    for(int i=0;i<n;i++) {
    	A[i]=scanner.nextInt();
    }
    System.out.println("Enter the searching element...");
    int s =scanner.nextInt();
    System.out.println("Seaching Element index in array is "+BSR(A,s,0,A.length-1));
    scanner.close();
}
}
