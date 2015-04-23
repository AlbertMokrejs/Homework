import java.io.*;
import java.util.*;

public class TreeNode<E> {

    public boolean hasValue;
    public boolean hasLeft;
    public boolean hasRight;
    public E value;
    public TreeNode<E> Left;
    public TreeNode<E> Right;

    public TreeNode(){
	hasValue = false;
	value = null;
	hasLeft = false;
	hasRight = false;
	Left = null;
	Right = null;
    }

    public TreeNode(E x){
	hasValue = true;
	value = x;
	hasLeft = false;
	hasRight = false;
	Left = null;
	Right = null;
    }

    public void setValue(E x){
	hasValue = true;
	value = x;
    }

    public E getValue(){
	if(hasValue){
	    return value;
	}
	throw new NullPointerException() e;
    }

    public void setLeft(TreeNode<E> x){
	hasLeft = true;
	Left = x;
    }

    public void setRight(TreeNode<E> x){
	hasRight = true;
	Right = x;
    }

    public TreeNode<E> getLeft(){
	if(hasLeft){
	    return Left;
	}
	throw new NullPointerException() e;
    }

      public TreeNode<E> getRight(){
	if(hasRight){
	    return Right;
	}
	throw new NullPointerException() e;
    }

      public boolean lcheck(){
	  hasLeft = (Left != null);
	  return hasLeft;
      }
      
      public boolean rcheck(){
	  hasRight = (Right != null);
	  return hasRight;
      }

}
