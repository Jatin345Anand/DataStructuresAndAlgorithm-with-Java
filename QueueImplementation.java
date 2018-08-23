package Queue;

import java.util.Scanner;

class QueueFull extends Exception{
	
}
class QueueEmpty extends Exception{
	
}
public class QueueImplementation {
   int[] Storage;
   int front = -1;
   int rear = -1;
   int count =0;
   public QueueImplementation() {
	 Storage = new int[10];
   }
   public QueueImplementation(int size) {
	   Storage = new int[size];
   }
   boolean isEmpty() {
	   return count==0;
   }
   boolean isFull() {
	   return count==Storage.length;
   }
   int size() {
	   return count;
   }
   int dequeue() throws QueueEmpty {
	   if(isEmpty()) {
		   throw new QueueEmpty();
	   }
	   int element = Storage[front];
	   front = (front+1)%Storage.length;
	   count--;
	   if(count==0) {
		   front=rear=-1;
	   }
	   return element;
   }
   void enqueue(int data) throws QueueFull {
	   if(isFull()) {
		   throw new QueueFull();
	   }
	   rear = (rear+1)%Storage.length;
	   if(front==-1) {
		   front=front+1;
	   }
	   Storage[rear]=data;
	   count++;
   }
   public void PrintQueue(QueueImplementation qi) {
	   System.out.println();
	   for(int i=0;i<count;i++) {
		   System.out.print(Storage[i]+" ");
	   }
	   System.out.println();
   }
   public static Scanner scanner= new Scanner(System.in);

   public static void main(String[] args) throws QueueFull {
	   QueueImplementation qi = new QueueImplementation();
	   System.out.println(qi.size());
	   System.out.println(qi.isEmpty());
	   System.out.println(qi.isFull());
	   System.out.println("Enter the values...");
	   qi.enqueue(2);
	   qi.enqueue(3);
	   qi.enqueue(4);
	   qi.enqueue(5);
	   qi.PrintQueue(qi);
}
}
