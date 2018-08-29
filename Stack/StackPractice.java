package Stack;
class StackOverFlow extends Exception{
	
}
class StackUnderFlow extends Exception{
	
}
public class StackPractice { 
	private  int[] Storage;
	 private int top;
     public StackPractice() {
    	 top=-1;
    	 Storage = new int[10];
     }
     public void push(int data) {
    	 System.out.println("in push...");
//    	 System.out.println("in push...."+top);
		if(isOverflow()) {
			grow();
    	}
		else {
			top++;
   		 Storage[top]=data;
   		 System.out.println("Stack is pushed...");
		}
     }
     public int pop() throws StackUnderFlow {
      int data=0;
      if( isUnderFlow()) {
    	  throw new StackUnderFlow();
      }
      data = Storage[top];
      top--;
      System.out.println("Stack is poped....");
      System.out.println("Poped element = "+data);
      return data;
     }
     public  void grow() {
       int[] temp =Storage;
       Storage = new int[temp.length*2];
       for(int i=0;i<temp.length;i++) {
    	   Storage[i]=temp[i];
       }
       System.out.println("Stack is increased...");
     }
      
     public   boolean isUnderFlow() {
//    	 System.out.println("UnderFlow = "+top);
         return top ==-1;
     }
     public   boolean isOverflow() {
//    	 System.out.println("OverFlow = "+top);
    	 return top == Storage.length-1;
     }
     public int size() {
       return top+1;
     }
     public void PrintStack() {
    	 System.out.println();
    	 for(int i=0;i<size();i++) {
    		 System.out.print(Storage[i]+" -> ");
    	 }
    	 System.out.print("-1");
    	 System.out.println();
     }
     public static void main(String[] args) throws StackUnderFlow {
    	 StackPractice sp = new StackPractice();
		System.out.println(sp.size());
		sp.isOverflow();
		sp.isUnderFlow();
		sp.push(1);
//		sp.push(2);
//		sp.push(3);
//		sp.push(4);
		sp.PrintStack();
//		sp.pop();
//		sp.pop();
//		sp.PrintStack();
	}
}
