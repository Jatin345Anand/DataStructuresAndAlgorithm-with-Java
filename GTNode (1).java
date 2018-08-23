package GenericTree;

import java.util.ArrayList;

public class GTNode<T> {
	  T data;
	    ArrayList<GTNode<T>> Children ;
	    GTNode(T data){
	    	this.data=data;
	    	Children = new ArrayList<>();
	    }
}
