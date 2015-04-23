/*========== BTree.java ==========  
  Lab: Complete
  1. TreeNode.java
  2. add()
  3. pre/post/in Order()
  4. getHeight
  5. getLevel
  6. toString
  
  Basic binary tree.
  Uses TreeNode
=========================*/

import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    public void add( E d ) {
	add(root, new TreeNode<E>(d));
    }


    private TreeNode<T> add( TreeNode<E> curr, TreeNode<E> bn ){
	if(curr.hasRoom()){
	    Random r = new Random()
	    if(!curr.lcheck() && !curr.rcheck()){
		    if(r.nextDouble() > 0.5){
			curr.setLeft(bn);
		    }
		    else{
			curr.setRight(bn);
		    }
		}
	    else{
		if(!curr.lcheck()){
		    curr.setLeft(bn);
		}
		else{
		    curr.setRight(bn);
		}
	    }
	}
	else{
	    Random r = new Random();
	    if(r.nextDouble() > 0.5){
		add(curr.getLeft(), bn);
	    }
	    else{
		add(curr.getRight(), bn);
	    }
	}
    }
		    
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
    }
    
    public void preOrder( TreeNode<E> curr ) {
	System.out.println(curr);
	if(curr.lcheck()){
	    preOrder(curr.getLeft());
	}
	if(curr.rcheck()){
	    preOrder(curr.getRight());
	}
    }

    public void inOrder( TreeNode<E> curr ) {	
	if(curr.lcheck()){
	    inOrder(curr.getLeft());
	}
	System.out.println(curr);
	if(curr.rcheck()){
	    inOrder(curr.getRight());
	}
    }

    public void postOrder( TreeNode<E> curr ) {	
	if(curr.lcheck()){
	    postOrder(curr.getLeft());
	}
	if(curr.rcheck()){
	    postOrder(curr.getRight());
	}
	System.out.println(curr);
    }
    
    public int getHeight() {
	return getHeight( root );
    }
    
    public int getHeight( TreeNode<E> curr ) {
	if(!curr.hasLeft() && !curr.hasRight()){
	    return 1;
	}
	if(!curr.hasLeft()){
	    return getHeight(curr.getRight());
	}
	if(!curr.hasRight()){
	    return getHeight(curr.getLeft());
	}
	else{
	    int x = getHeight(curr.getRight());
	    int y = getHeight(curr.getLeft());
	    if(x > y){
		return x;
	    }
	    return y;
	}
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    public String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	return "";
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0
          1      2
            3  4   5
      ====================*/
    public String toString() {
	return "";
    }
	

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}
