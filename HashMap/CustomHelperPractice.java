package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class CustomHelperPractice {
	public static void PrintArray(int[] A) {
		System.out.println();
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
	}
	public static int MaxNode(HashMap<Integer, Integer> HM) {
	  	ArrayList<Integer> list = new ArrayList<>(HM.keySet());
	  	System.out.println(list);
	  	Collections.sort(list);
	  	System.out.println(list);
//	  	int 
//	  	for(int i)
	  	return HM.get(list.get(list.size()-1));
	}
    public static void main(String[] args) {
	TreeMap<Integer, Integer> TM = new TreeMap<>();
	HashMap<Integer, Integer> HM = new HashMap<>();
	int K[]= {80,20,30,140,40,180,50,10};
	int V[]= {270,170,150,290,310,270,560,150};
	
	for(int i=0,j=0;i<K.length && j<V.length;i++,j++) {
		HM.put(V[j],K[i] );
		TM.put(V[j],K[i]);
	}
	System.out.println("Hashmap....");
	System.out.println(HM);
	System.out.println(HM.keySet());
	System.out.println(HM.values());
	System.out.println("Values....");
	for(int i=0;i<V.length;i++) {
		System.out.print("K = "+V[i]+" "+HM.get(V[i])+" ");
	}
	int[] K1= new int[HM.keySet().size()];
	PrintArray(V);
	Arrays.sort(V);
	PrintArray(V);
	System.out.println("Treemap...");
	System.out.println(TM.keySet());
	System.out.println(TM.values());
	System.out.println(HM.get(V[V.length-1]));
	System.out.println("MAX NODE = "+MaxNode(HM));
}
}
