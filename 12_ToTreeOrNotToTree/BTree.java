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


    private void  add( TreeNode<E> curr, TreeNode<E> bn ){
	if(root == null){
	    root = bn;
	}
	else{
	    if(curr.hasRoom()){
	    Random r = new Random();
	    if(!curr.lcheck() && !curr.rcheck()){
		    if(r.nextDouble() > 0.5){
			curr.setLeft(bn);
		    }
		    else{
			curr.setRight(bn);}}
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
	if(!curr.lcheck() && !curr.rcheck()){
	    return 1;
	}
	if(curr.lcheck() && !curr.rcheck()){
	    return 1 + getHeight(curr.getLeft());
	}
	if(curr.rcheck() && !curr.lcheck()){
	    return 1 + getHeight(curr.getRight());
	}
	else{
	    int x = getHeight(curr.getRight());
	    int y = getHeight(curr.getLeft());
	    if(x > y){
		return 1 + x;
	    }
	    return 1 + y;
	}
    }

    
    public String getLevel(int Level){
	return getLevel(root, Level, 1);
    }

    public String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	if(level == currLevel){
	    return "" + curr;
	}
	else{
	    String x = "";
	    if(curr.hasLeft()){
		x += getLevel(curr.getLeft(), level, currLevel++);
	    }
	    if(curr.hasRight()){
		x += getLevel(curr.getRight(), level, currLevel++);
	    }
	    return x;
	}
    }
    
    public String toString() {
	String d = "";
	for(int x = 0; x < getHeight(); x++){
	    d += getLevel(x) + "\n";
	}
	return d;
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
