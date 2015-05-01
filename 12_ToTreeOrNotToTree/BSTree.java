//My binary search tree skeleton file:

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
	    if(curr.compareTo(t) <= 0){
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

    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	BSTreeNode<T> a = null;
	if(curr.getValue().compareTo(c) == 0){
	    a = curr;
	}
	if(curr.getValue().compareTo(c) > 0){
	    return remove(curr.getLeft(), c);
	}
	if(curr.getValue().compareTo(c) < 0){
	    return remove(curr.getRight(), c);
	}
    }


    private BSTreeNode<T> restructure(BSTreeNode<T> curr, BSTreeNode<T> torep, BSTreeNode<T> par){
	if(curr.compareTo(torep) == 0){
	    if(curr.lcheck()){
		return restructure(curr.getLeft() , torep, curr);
	    }
	    if(curr.rcheck()){
		return restructure(curr.getRight() , torep, curr);
	    }
	    if(par != null && par.lcheck() && par.getLeft().compareTo(curr) == 0){
		par.setLeft(null);
	    }
	    if(par != null && par.rcheck() && par.getRight().compareTo(curr) == 0){
		par.setRight(null);
	    }
	    
	    
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
