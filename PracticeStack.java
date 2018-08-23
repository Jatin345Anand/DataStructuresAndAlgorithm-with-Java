package Stack;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PracticeStack {

	public static boolean checkBalanced(String exp) {
	 	Stack<Character> stLeft = new Stack();
	   char[] lo = {'(','{','['};
	   char[] ro = {')','}',']'};
 	   boolean ans=false; 
	   boolean isAuth=false; 
	   // firstly we take two character array for keeping symbols....
	   
	   for(int i=0;i<exp.length();i++) {
		   if(exp.charAt(i)==lo[0] || exp.charAt(i)==lo[1] || exp.charAt(i)==lo[2] || exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2]) {
			   if( exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2] ) {
	 			   ans=false;
				   isAuth=true;
				   // this loop is help for the tell about if extra left and right operator exist in expression ...
				   // isAuth variable will tell about this issue...
 			   }
			   break;
		   }
	   }
 	    if(!isAuth) {
		for(int i=0;i<exp.length();i++) {
			if(exp.charAt(i)==lo[0] || exp.charAt(i)==lo[1] || exp.charAt(i)==lo[2] ) {
				stLeft.push( exp.charAt(i) );
				// here we use stack to solve the problem 
				// push operation help to take left operator ....
			}
			else if( exp.charAt(i)==ro[0] || exp.charAt(i)==ro[1] || exp.charAt(i)==ro[2] ) {
 				if(  (exp.charAt(i)==ro[0]   && stLeft.peek()==lo[0]) || (exp.charAt(i)==ro[1]   && stLeft.peek()==lo[1]) || (exp.charAt(i)==ro[2]   && stLeft.peek()==lo[2]) ) {
 					stLeft.pop();
 					/// pop operation help to take right operation ...
				}
			}
		}
	    /// to find final answer we will have to see the size of stack if stack is empty then our expression has equal left and right operator ....
 		if(stLeft.size()==0) {
			ans=true;
		}
	}
		return ans;


	}
	public static void swap(Stack<Integer> a,Stack<Integer> b) {
		int tempSize1=0;
		int tempSize=a.size()-1;
		 for (int i = b.size()-1; i >=0; i--) {
			a.insertElementAt(b.elementAt(i),tempSize1++ );
		 }
		 // here we will use some predefined function of stack..
		 // using b we change the stack of a......
		 
		 b.clear();
		 for(int i=tempSize1;i<a.size();i++) {
			 b.push(a.elementAt(i));
			 
		 }
		 int mid=a.size()/2;
	 	 for(int i=1;i<=mid;i++) {
	 	 	 a.pop();
	 	 }
	}
	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
		// here we have to discuss two scenario even and odd size of stack....
		   if(s1.size()%2==0) {
		 int mid=s1.size()/2;
		  // we will have to use empty stack to keep half stack of first stack
		  for(int i=mid;i<s1.size();i++) {
			  s2.push(s1.elementAt(i));
		  }
		  for(int i=1;i<=mid;i++) {
			  s1.pop();
		  }
		 // above loop used to copy elements of first stack to second emty stack.....
	    swap(s1,s2);
	  // swap exact half stack using second stack...
	    // swap method help to swaping...
		for(int i=s2.size()-1;i>=0;i--) {
			s1.push(s2.elementAt(i));
			s2.pop();
		}
	 	
	   } 
	   else {
		   // we will solve in odd scenario....
		   // same procedure repeat as even case....
		   int mid1=s1.size()/2;
		  
		   for(int i=mid1;i<s1.size();i++) {
				  s2.push(s1.elementAt(i));
			  }
			  for(int i=1;i<=mid1;i++) {
				  s1.pop();
			  } 
		 
	    swap(s1,s2);
		 
		    s1.pop();
		    for(int i=s2.size()-1;i>=0;i--) {
				s1.push(s2.elementAt(i));
				s2.pop();
			}
		 
	   }
	}
	public static void PrintArray(int[] A) {
		System.out.println();
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public static int[] stockSpan2(int[] price) {
		// this method solve by O(n^2) time comlexity...
		// because it has two nested loop exist....
	 int ans[]=new int[price.length];
	 Stack<Integer> S = new Stack<>();
	 for(int i=0;i<price.length-1;i++) {
		 if(price[i]<price[i+1]) {
			 S.push(1);
		 }
		 else {
			 S.push(0);
		 }
	 }
	 
	 ans[0]=1;
	 for(int i=0;i<S.size();i++) {
		 if(S.elementAt(i)==1) {
			 
			 ans[i+1]=FindPreviousMax(price,i+1);
		 }
		 else {
			 ans[i+1]=1;
		 }
	 }
	 System.out.println(S);
	 return ans;
	}
	  public static int FindPreviousMax(int[] A,int index) {
		  int ans=-1;
	    	int MAX=A[index];
	    	for(int i=index-1;i>=0;i--) {
	    		if(MAX<A[i]) {
	    			MAX=A[i];
	    			ans=i;
	    			break;
	    		}
	    	}
	    	// custom input and output
	    	// I ->1 24
	    	// O ->1
	    	// I ->10 110 14 8 115 193 127 27 186 47 30 
	    	// O ->1 1 1 4 5 1 1 3 1 1 
  	    	// I ->20 92 60 29 118 124 32 91 58 7 63 125 177 156 51 60 15 65 194 119 154 
	    	// O ->1 1 1 4 5 1 2 1 1 3 11 12 1 1 2 1 4 18 1 2 
	    	if(ans==-1) {
	    		ans=(index)+1;
	    	}
	    	else {
	    		ans=index-ans;
	    	}
//	    	System.out.println("MAX = "+MAX);
	    	return ans;
	    }
//	public static int FindPreviousMax(int[] A,int index) {
//		int ans=0;
//		
//		return ans;
//	}
	  public static int[] stockSpan(int[] price) {
		  int[] ans =new int[price.length];
		  // span of the first price day is always one....
		  ans[0]=1;
		  // To get minimum complexity O(n) we use stack....
		  Stack<Integer> S = new Stack<>();
		  S.push(0);
		  // here we assume first element is maximum of the price array....
		  // so we push 0 at top of the taking stack...
		  for(int i=1;i<price.length;i++) {
			  //// Pop elements from stack while stack is not empty and top of
	            // stack is smaller than price[i]
			  while((!S.isEmpty()) && (price[S.peek()] <= price[i]))
				  S.pop();
			 // here S top carry always maximum value of the price array....
			// If stack becomes empty, then price[i] is greater than all elements
	            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
	            // is greater than elements after top of stack
			  if(S.empty()) {
				  ans[i]=i+1;
			  }
			  else {
				  ans[i]=i-S.peek();
			  }
 			  // Push this element to stack
			  S.push(i);
		  }
		  System.out.println(S);
		  
		  return ans;
	  }
	  
	public static  Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
//     System.out.println("Enter the String Expression....");     	
//     String Expression = scanner.nextLine();
//     System.out.println(checkBalanced(Expression));
//     System.out.println("Enter the first stack to reverse....");
//     Stack<Integer> s1 = new Stack<>();
//     Stack<Integer> s2 = new Stack<>();
//     s1.push(scanner.nextInt());
//     s1.push(scanner.nextInt());
//     s1.push(scanner.nextInt());
//     s1.push(scanner.nextInt());
//     reverseStack(s1, s2);
//     System.out.println("After Reverse First stack is...");
//     System.out.println(s1);
     System.out.println("Enter the size of prize array ... ");
     int n = scanner.nextInt();
     int[] A = new int[n];
     System.out.println("Enter the elements...");
     for(int i=0;i<A.length;i++) {
    	 A[i]=scanner.nextInt();
     }
//     PrintArray(stockSpan2(A));
     PrintArray(stockSpan(A));
     scanner.close();
    }
}