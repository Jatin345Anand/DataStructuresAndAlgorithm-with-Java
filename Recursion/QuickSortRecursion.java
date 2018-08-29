package Recursion;

import java.util.Scanner;

public class QuickSortRecursion {
	public static void print(int[] arr) {
		 int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	 
//	        System.out.println();
//		    for(int i=0;i<A.length;i++) {
//		     System.out.print(A[i]+" ");	
//		    }
//		    System.out.println();
//		  	}
	}
	public static int Partition(int[] A,int startIndex,int endIndex) {
		int pivot = A[endIndex];// select pivot at rightmost element of array
		int partitionIndex = startIndex; // initially take first element of array as partitionIndex
		for(int j=startIndex;j<endIndex;j++) {
			if(A[j]<=pivot) {
				
				int temp=A[partitionIndex];
				A[partitionIndex]=A[j];
				A[j]=temp;
				partitionIndex++;
			}
		}
		int temp= A[partitionIndex];
		A[partitionIndex]=A[endIndex];
		A[endIndex]=temp;
		return partitionIndex;
	}
	public static void QSR(int[] A,int startIndex,int endIndex) {
		if(startIndex<endIndex) {
			int partitionIndex = Partition(A, startIndex, endIndex);
			System.out.println(partitionIndex);
			QSR(A, startIndex, partitionIndex-1);
			QSR(A, partitionIndex+1, endIndex);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array...");
		int n = scanner.nextInt();
		System.out.println("Enter the elements...");
	    int[] A = new int[n];
	    
	    for(int i=0;i<n;i++) {
	    	A[i]=scanner.nextInt();
	    } 
	    QSR(A, 0, A.length-1);
	    System.out.println("Using Quick Sort Sorted array is... ");
	    print(A);
	    scanner.close();
	}
	
}
