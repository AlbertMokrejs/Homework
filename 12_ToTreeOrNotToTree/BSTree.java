//Your binary search tree skeleton file:

import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

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
	    if(curr.compareTo(t) < 0){
		if(curr.lcheck()){
		    return add(curr.getLeft(),t);
		}
		curr.setLeft(t);
		return t;
	    }
	    if(curr.compareTo(T) == 0){
		curr.setTally(curr.getTally() + 1);
		return curr;
	    }
	}
    }

    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

   
    public static void main( String[] args ) {

    }

}
