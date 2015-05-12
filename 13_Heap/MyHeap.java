public class MyHeap{
int[] heaplist;
boolean toggle;

public MyHeap(){
  heaplist = new int[1025];
  toggle = false;
  }
  
public MyHeap(boolean x){
  heaplist = new int[1025];
  toggle = x;
  }
  
