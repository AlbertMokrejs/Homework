import java.util.*;

public class Heapsort{

  public static void heapsort(int[] x){
    int[] y = new int[x.length];
    for(int z = 0; z < x.length; z++){
      y[z] = x[z];
    }
    int sorted = 1;
    while(sorted < y.length-1){
    	dcheck(0,y,sorted);
    	int q = y[0];
    	y[0] = y[y.length-sorted];
    	y[y.length-sorted] = q;
    	sorted++;
    }
    for(int d = 0; d < x.length; d++){
    	x[d] = y[d];
    }
  }
    
    

  public static void dcheck(int a, int[] heaplist,int d){
    if(a*2 + 1 <= heaplist.length-x){
	if(heaplist[a] < heaplist[a*2+1]){
	    int x = heaplist[a*2+1];
	    heaplist[a*2+1] = heaplist[a];
	    heaplist[a] = d;
	    dcheck(a*2+1,heaplist,d);
	}
    }
    if(a*2 + 2 <= heaplist.length-d){
	if(heaplist[a] < heaplist[a*2 + 2]){
	    int x = heaplist[a*2 + 2];
	    heaplist[a*2 + 2] = heaplist[a];
	    heaplist[a] = x;
	    dcheck(a*2 + 2,heaplist,d);
	}
    }
	dcheck(a,heaplist,d);
  }
	

}
