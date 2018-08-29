package Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class StackOverFlow extends Exception{
	
}
class StackUnderFlow extends Exception{
	
}
public class StackPracticeGeneral<T> {
	private  ArrayList<T> Storage;
	 private int top;
     public StackPracticeGeneral() {
    	 top=-1;
    	 Storage = new ArrayList<>();
     }
     public void push(T data) {
    	 System.out.println("In push....");
//    	 System.out.println("in push...."+top);
		if(isOverflow()) {
			grow();
    	}
		else {
			top++;
   		 Storage.add(data);
   		 System.out.println("Stack is pushed...");
		}
     }
     public T pop() throws StackUnderFlow {
    	System.out.println("In pop....");
      T data;
      if( isUnderFlow()) {
    	  throw new StackUnderFlow();
      }
      data = Storage.get(top);
      top--;
      System.out.println("Stack is poped....");
      System.out.println("Poped element = "+data);
      return data;
     }
     public  void grow() {
       ArrayList<T> temp=Storage;
       Storage = new ArrayList<>(temp.size()*2);
       for(int i=0;i<temp.size();i++) {
    	   Storage.add(temp.get(i));
       }
       System.out.println("Stack is increased...");
     }
      
     public   boolean isUnderFlow() {
    	 System.out.println("UnderFlow = "+top);
         return top ==-1;
     }
     public   boolean isOverflow() {
    	 System.out.println("OverFlow = "+top);
    	 System.out.println(Storage.size());
    	 return top == Storage.size()-1;
     }
     public int size() {
       System.out.println("Size top = "+top);	 
       return top+1;
     }
     public void PrintStack() {
    	 System.out.println();
    	 for(int i=0;i<size();i++) {
    		 System.out.print(Storage.get(i)+" -> ");
    	 }
    	 System.out.print("-1");
    	 System.out.println();
     }
     public static void main(String[] args) throws StackUnderFlow {
    	 StackPracticeGeneral<Integer> sp = new StackPracticeGeneral<>();
//    	 System.out.println();
		System.out.println("size = "+sp.size());
		sp.isOverflow();
		sp.isUnderFlow();
		
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ArrayList<Character> ALC = new ArrayList<Character>();
        ArrayList<Integer> ALI = new ArrayList<Integer>(Collections.nCopies(10, 0));
        ArrayList<String> ALS = new ArrayList<String>(10);
        ArrayList<Integer> ALI2 = new ArrayList<>(Arrays.asList(new Integer[10]));
        System.out.println(ALC.size());
        System.out.println(ALI.size());
        System.out.println(ALI2.size());
        System.out.println(ALS.size());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//		sp.push(1);
//		sp.push(2);
//		sp.push(3);
//		sp.push(4);
//		sp.PrintStack();
//		sp.pop();
//		sp.pop();
//		sp.PrintStack();
	}
}



