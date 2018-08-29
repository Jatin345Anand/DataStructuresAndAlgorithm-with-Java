package GenericTree;

import java.util.ArrayList;

public class L1 {
 private ArrayList<GTNode<Integer>> LofGTChildren ;
 public L1() {
	 LofGTChildren = new ArrayList<>();
 }
public ArrayList<GTNode<Integer>> getLofGTChildren() {
	return LofGTChildren;
}

public void setLofGTChildren(ArrayList<GTNode<Integer>> lofGTChildren) {
	LofGTChildren = lofGTChildren;
}
 
}
