import java.util.*;

public class Heapsort{

  public static void heapsort(int[] x){
    int[] y = new int[x.length];
    for(int z = 0; z < x.length; z++){
      y[z] = x[z];
    }
    

  public static void dcheck(int a, int[] heaplist){
    if(a*2 + 1 < heaplist.length){
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
	}
	


