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
  
public void add(int x){
  if(heaplist.length == heaplist[0]){
    resize();
  }
  heaplist[heaplist[0]+1] = x;
  heaplist[0]++;
  check(heaplist[0]);
}

public void resize(){
}

public int remove(){
  int a = heaplist[1];
  heaplist[1] = heaplist[heaplist[0]];
  dcheck(1);
  return a;
}

public void dcheck(int a){
  
}

public void check(int a){
  if(!(a == 1)){
  if(toggle){
    if(heaplist[a] > heaplist[a/2]){
      int x = heaplist[a/2];
      heaplist[a/2] = heaplist[a];
      heaplist[a] = x;
      check(a/2);
    }
  }
  else{
    if(heaplist[a] < heaplist[a/2]){
      int x = heaplist[a/2];
      heaplist[a/2] = heaplist[a];
      heaplist[a] = x;
      check(a/2);
    }
  }
}

  
}

