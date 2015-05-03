//My binary search tree skeleton file:

import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable>{

    public BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }

    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }
    
    public void add( T c ) {
	add( root, new BSTreeNode<T>(c) );
    }

    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(root == null){
	    root = t;
	    return t;
	}
	else{
	    if(curr.compareTo(t) > 0){
		if(curr.rcheck()){
		    return add(curr.getRight(),t);
		}
		curr.setRight(t);
		return t;
	    }
	    if(curr.compareTo(t) <= 0){
		if(curr.lcheck()){
		    return add(curr.getLeft(),t);
		}
		curr.setLeft(t);
		return t;
	    }
	    if(curr.compareTo(t) == 0){
		curr.setTally(curr.getTally() + 1);
		return curr;
	    }
	}
    }

    public void remove( T c ) {
	     remove( root, c );
    }
    
    private BSTreeNode restructure(BSTreeNode curr, BSTreeNode x){
        if(x == root){
            BSTreeNode tmp = x;
            if(x.rcheck()){
                tmp = tmp.getRight();
                while(tmp.lcheck()){
                tmp = tmp.getLeft();    
                }
                if(x.lcheck()){
                    tmp.setLeft(x.getLeft());
                }
                if(tmp.rcheck()){
                    BSTreeNode z = tmp.getRight();
                    while(z.rcheck()){
                        z = z.getRight();
                    }
                    z.setRight(x.getRight());
                }
                root = tmp;
                return root;
            }
            if(x.lcheck()){
                tmp = tmp.getLeft();
                while(tmp.rcheck()){
                tmp = tmp.getRight();    
                }
                if(x.rcheck()){
                    tmp.setRight(x.getRight());
                }
                if(tmp.lcheck()){
                    BSTreeNode z = tmp.getLeft();
                    while(z.lcheck()){
                        z = z.getLeft();
                    }
                    z.setLeft(x.getLeft());
                }
                root = tmp;
            }
            return root;
        }
        BSTreeNode tmp = x;
            if(x.rcheck()){
                tmp = tmp.getRight();
                while(tmp.lcheck()){
                tmp = tmp.getLeft();    
                }
                if(x.lcheck()){
                    tmp.setLeft(x.getLeft());
                }
                if(tmp.rcheck()){
                    BSTreeNode z = tmp.getRight();
                    while(z.rcheck()){
                        z = z.getRight();
                    }
                    z.setRight(x.getRight());
                }
                return root;
            }
            if(x.lcheck()){
                tmp = tmp.getLeft();
                while(tmp.rcheck()){
                tmp = tmp.getRight();    
                }
                if(x.rcheck()){
                    tmp.setRight(x.getRight());
                }
                if(tmp.lcheck()){
                    BSTreeNode z = tmp.getLeft();
                    while(z.lcheck()){
                        z = z.getLeft();
                    }
                    z.setLeft(x.getLeft());
                }
            }
            return root;
        
        
    }

    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	    if(curr.lcheck() && curr.getLeft().getValue() == c){
	        if(isLeaf(curr.getLeft())){
	            curr.setLeft(null);
	            return root;
	        }
	        return restructure(curr,curr);
	    }
	    if(curr.rcheck() && curr.getRight().getValue() == c){
	        if(isLeaf(curr.getRight())){
	           curr.setRight(null);
	           return root;
	        }
	        // deal with not a leaf
	    }
	    BSTreeNode a = null;
	    BSTreeNode b = null;
	    if(curr.lcheck()){
	        a = remove(curr.getLeft(), c);
	    }
	    if(curr.rcheck()){
	        b = remove(curr.getRight(),c);
	    }
	    if(a != null && a != root){
	        return a;
	    }
	    if(b != null && b != root){
	       return b;
	    }
	    return root;
    }


    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	    if(t.lcheck()){
	inOrderHelper( t.getLeft() );}
	System.out.print( t.getValue() + " ");
	if(t.rcheck()){
	inOrderHelper( t.getRight() );}
    }
    
    public int getHeight(){
		return getHeight(root);
}

private int getHeight(BSTreeNode<T> r ){
		if(r == null){
				return 0;
		}else{
				//System.out.println("recursion height");
				return 1 + Math.max(getHeight(r.getLeft()),
					            getHeight(r.getRight()));
		}
}

private int maxLength() {
		// returns the minimum number of characters required
		// to print the data from any node in the tree
		if (root == null)
				return 0;
		return maxLength(root);
}

private int maxLength(BSTreeNode<T> curr) {
		int max = curr.toString().length();
		int temp;
		if (curr.getLeft() != null) {
				temp = maxLength(curr.getLeft());
				if (temp > max)
						max = temp;
		}
		if (curr.getRight() != null) {
				temp = maxLength(curr.getRight());
				if (temp > max)
						max = temp;
		}
		return max;
}

private String spaces(double n) {
		// returns a String of n spaces
		String result = "";
		for (int i = 0; i < n; i++)
				result += " ";
		return result;
}

private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
		if (currLevel == 1){
			return curr.toString() + 
                               spaces(wordLength - curr.toString().length()) +
			       spaces(wordLength * 
                                      Math.pow(2, height - targetLevel + 1) - 
                                      wordLength);
		}
		String result = "";
		if (curr.getLeft() != null){
			result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
		}else{
			result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		}
		if (curr.getRight() != null){
			result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
		}else{ 
			result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		}
		return result;
}
		
public String toString() {
		if (root == null)
				return "";
		String result = "";
		int height = getHeight();
		int wordLength = maxLength();
		// add the every level of the tree except the last one
		for (int level = 1; level < height; level++){
			// remove extra spaces from the end of each level's String to prevent lines from
			// getting unnecessarily long and add spaces to the front of each level's String
			// to keep everything centered
			result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
				getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
				"\n";
		}
		// now add the last level (level = height)
		result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
		return result;
}

   
    public static void main( String[] args ) {

    }

}
