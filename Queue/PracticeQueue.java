package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class PracticeQueue {

	public static void reverseQueue(QueueImplementation q) throws QueueEmpty, QueueFull {
      int S=q.size();
      ArrayList<Integer> al=new ArrayList<>();
       
      PriorityQueue<Integer> PQ = new PriorityQueue<>();
       for(int i=1;i<=S;i++) {
         al.add(q.dequeue());
    
     }
     
      for(int i=al.size()-1;i>=0;i--) {
	    	  q.enqueue(al.get(i));
	      }
      
	}
	public static void main(String[] args) throws QueueFull, QueueEmpty {
	System.out.println("Enter the values for queue...");
	QueueImplementation qi = new QueueImplementation();
	
	qi.enqueue(1);
	qi.enqueue(2);
	qi.enqueue(3);
	qi.enqueue(4);
	System.out.println("Before Queue....");
	qi.PrintQueue(qi);
	reverseQueue(qi);
	System.out.println("After Queue....");
	qi.PrintQueue(qi);
    
}
}
