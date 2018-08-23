package Stack;

import java.util.Scanner;

class StackOverFlow extends Exception{
	
}
class StackUnderFlow extends Exception{
	
}
public class StackImplementation {

	private int[] Storage;
	private int top;
	public StackImplementation() {
	 Storage = new int[10];
	 top=-1;
	}
	public StackImplementation(int data){
		Storage = new int[10];
		 top=-1;	
	}
	void grow() {
		int[] temp = Storage;
		Storage = new int[temp.length*2];
		for(int i=0;i<temp.length;i++) {
			Storage[i]=temp[i];
		}
		System.out.println("Stack size increased....");
	}
    void push(int data) {
    	if(isOverflow()) {
    		grow();
    	}
    	top++;
    	Storage[top]=data;
    	System.out.println("Stack pushed...");
    }
    int pop() throws StackUnderFlow {
    	if(isUnderFlow()) {
    		throw new StackUnderFlow();
    	}
    	int data = Storage[top];
    	top--;
    	System.out.println("Stack poped...");
    	return data;
    }
    boolean isOverflow() {
//    	System.out.println("in overflow = "+top);
    	return top==Storage.length-1;
    }
    boolean isUnderFlow() {
//    	System.out.println("in Underflow =  "+top);
    	return top==-1;
    }
    int size() {
    	return top+1;
    }
     void PrintStack() {
   	 System.out.println();
   	 int l = size();
   	 for(int i=0;i<l;i++) {
   		 
   		 System.out.print(Storage[i]+" -> ");
   	 }
   	 System.out.print("-1");
   	 System.out.println();
    }
    int elementAt(int index) {
    	return Storage[index];
    }
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws StackUnderFlow {
		StackImplementation si = new StackImplementation();
		si.push(12);
        si.push(13);
        si.push(14);
        si.push(15);
//	    si.PrintStack();	
//	    System.out.println("Poped Element = "+si.pop());
	    si.PrintStack();
		System.out.println("%%%%%%%%%%%%%%%%%%%%");
		System.out.println(si.isOverflow());
		System.out.println("Size = "+si.size());
		System.out.println(si.isUnderFlow());
		System.out.println("Enter the index...");
		int index = scanner.nextInt();
		System.out.println(si.elementAt(index));
		scanner.close();
	}
}
