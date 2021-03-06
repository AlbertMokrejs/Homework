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
	return root;
    }

    public void remove( T c ) {
	     remove( root, c );
    }
    
   
    //stolen from alvin
    public BSTreeNode<T> findReplacement(BSTreeNode<T> current) {
    if (current == null) {
      return null;
    }
    return current.hasLeft() ? findReplacement(current.getLeft()) : current;
  }
  
  private BSTreeNode<T> remove(BSTreeNode<T> root, T value) {
    if (root == null) {
      return root;
    } else if (root.isLeaf() && root.compareData(value) == 0) {
      return null;
    } else if (root.compareData(value) > 0) {
      root.setLeft(remove(root.getLeft(), value));
    } else if (root.compareData(value) < 0) {
      root.setRight(remove(root.getRight(), value));
    } else {
      root.setData(findReplacement(root.getRight()).getData());
      root.setRight(remove(root.getRight(), root.getData()));
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
        BSTree x = new BSTree();
        x.add(5);
        x.add(2);
        x.add(3);
        x.add(6);
        x.add(7);
        x.add(4);
        x.add(8);
        x.add(14);
        x.add(13);
        x.add(-4);
        x.add(-3);
        System.out.println(x);
        x.remove(6);
        System.out.println(x);
        x.remove(1);
        System.out.println(x);
        x.remove(3);
        System.out.println(x);
        x.remove(2);
        System.out.println(x);
        x.remove(13);
        System.out.println(x);
        x.remove(6);
        System.out.println(x);
    }

}
