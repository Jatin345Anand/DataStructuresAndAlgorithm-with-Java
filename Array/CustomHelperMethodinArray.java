package Array;

import java.util.Scanner;

public class CustomHelperMethodinArray {
    public static int FindPreviosMax(int[] A,int index) {
    	int ans=-1;
    	int MAX=A[index];
    	for(int i=index-1;i>=0;i--) {
    		if(MAX<A[i]) {
    			MAX=A[i];
    			ans=i;
    			break;
    		}
    	}
    	
//    	System.out.println("MAX = "+MAX);
    	return ans;
    }
    public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
    	System.out.println("Enter the size...");
    	int n=scanner.nextInt();
    	System.out.println("Enter the elements...");
    	int[] A=new int[n];
    	for(int i=0;i<n;i++) {
    		A[i]=scanner.nextInt();
    	}
    	System.out.println("Enter the current index....");
    	int index=scanner.nextInt();
    	System.out.println("Previous Max index = "+FindPreviosMax(A, index));
    	System.out.println();
    	for(int i=0;i<A.length;i++) {
    		if(FindPreviosMax(A, i)==-1)
    		System.out.print(((i-FindPreviosMax(A, i))+1)+" ");
    		else
    		System.out.print(((i-FindPreviosMax(A, i)))+" ");	
    	}
    	System.out.println();
//    	System.out.println("Span Number = "+(index-FindPreviosMax(A, index)));
    	scanner.close();
 }
}
