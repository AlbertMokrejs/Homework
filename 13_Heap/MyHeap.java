import java.util.*;

public class MyHeap{
int[] heaplist;
boolean toggle;

public MyHeap(){
  heaplist = new int[1025];
  toggle = !false;
  }
  
public MyHeap(boolean x){
  heaplist = new int[1025];
  toggle = !x;
  }
  
public void add(int x){
  if(heaplist.length == heaplist[0]){
    resize();
  }
  heaplist[heaplist[0]+1] = x;
  heaplist[0]++;
  check(heaplist[0]);
  dcheck(1);
}

public void resize(){
    int[] glub = new int[heaplist.length*2];
    for(int x = 0; x<heaplist.length;x++){
	glub[x] = heaplist[x];
    }
    heaplist = glub;
}

public int remove(){
  int a = heaplist[1];
  heaplist[1] = heaplist[heaplist[0]];
  dcheck(1);
  heaplist[0]--;
  return a;
}

public void dcheck(int a){
    if(a*2 + 1 < heaplist[0]){
	if(toggle){
	if(heaplist[a] < heaplist[a*2]){
	    int x = heaplist[a*2];
	    heaplist[a*2] = heaplist[a];
	    heaplist[a] = x;
	    dcheck(a*2);
	    //dcheck(a);
	}
	if(heaplist[a] < heaplist[a*2 + 1]){
	    int x = heaplist[a*2 + 1];
	    heaplist[a*2 + 1] = heaplist[a];
	    heaplist[a] = x;
	    dcheck(a*2 + 1);
	    //dcheck(a);
	}
	}
	else{
	  if(heaplist[a] > heaplist[a*2]){
	    int x = heaplist[a*2];
	    heaplist[a*2] = heaplist[a];
	    heaplist[a] = x;
	    dcheck(a*2);
	    //dcheck(a);
	}
	if(heaplist[a] > heaplist[a*2 + 1]){
	    int x = heaplist[a*2 + 1];
	    heaplist[a*2 + 1] = heaplist[a];
	    heaplist[a] = x;
	    dcheck(a*2 + 1);
	    //dcheck(a);
	}  
	}
    }
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
  }}}

    public String toString(){
	String str = "";
	for(int x = 0; x<heaplist[0]+1;x++){
	    str += " " + heaplist[x];
	}
	return str;
    }

    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add(1);
	System.out.println(a);
	a.add(2);
	System.out.println(a);
	a.add(4);
	System.out.println(a);
	a.add(3);
	System.out.println(a);
	a.remove();
	System.out.println(a);
	a.remove();
	for(int x = 0; x <10; x++){
	    a.add((int)(Math.random() * 100));
	    System.out.println(a);
	}
	System.out.println(a);
	a.remove();
	System.out.println(a);
	a.remove();
	
    }



  
}

