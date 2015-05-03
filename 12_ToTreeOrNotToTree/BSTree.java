import java.io.*;
import java.util.*;

public class BSTreeNode<E extends Comparable> implements Comparable<BSTreeNode<E>>{

    public boolean hasValue;
    public boolean hasLeft;
    public boolean hasRight;
    public E value;
    public BSTreeNode<E> Left;
    public BSTreeNode<E> Right;
    public int tally;

    public int compareTo(BSTreeNode<E> x){
	return value.compareTo((E)x.getValue());
    }

    public BSTreeNode(){
	hasValue = false;
	value = null;
	hasLeft = false;
	hasRight = false;
	Left = null;
	Right = null;
	tally = 0;
    }

    public BSTreeNode(E x){
	hasValue = true;
	value = x;
	hasLeft = false;
	hasRight = false;
	Left = null;
	Right = null;
	tally = 0;
    }

    public void setValue(E x){
	hasValue = true;
	value = x;
    }
    
    public E getData(){
        return getValue();
    }

    public void setTally(int x){
	tally = x;}

    public int getTally(){
	return tally;}


    public E getValue(){
	if(hasValue){
	    return value;
	}
	throw new NullPointerException();
    }

    public void setLeft(BSTreeNode<E> x){
	hasLeft = true;
	Left = x;
    }

    public void setRight(BSTreeNode<E> x){
	hasRight = true;
	Right = x;
    }

    public BSTreeNode<E> getLeft(){
        return Left;
    }

      public BSTreeNode<E> getRight(){
        return Right;
    }

      public boolean lcheck(){
	  hasLeft = (Left != null);
	  return hasLeft;
      }
      
      public boolean rcheck(){
	  hasRight = (Right != null);
	  return hasRight;
      }

      public boolean hasRoom(){
	  return !(hasRight && hasLeft);
      }

      public boolean hasLeft(){
	  return hasLeft;}

      public boolean hasRight(){
	  return hasRight;}

      public String toString(){
	  return "" + value;}


}
