import java.util.*;

public class RunningMedian{
    MyHeap minl;
    MyHeap maxr;
    int middle;
    boolean has;

    public RunningMedian(){
	minl = new MyHeap();
	maxr = new MyHeap(true);
	middle = 1;
	has = false;
    }

    public void add(int a){
	if(has == false){
	    middle = a;
	    has = true;
	}
	else{
	    if(a > middle){
		maxr.add(a);
		minl.add(middle);
		has = false;
	    }
	    else{
		maxr.add(middle);
		minl.add(a);
		has = false;
	    }
	}
    }

    public double getMedian(){
	if(has == false){
	    return (minl.get() + maxr.get())/2.0;
	}
	else{
	    return middle;
	}
    }

    public String toString(){
	String str = "";
	str += "" + minl + "\n" + getMedian() + "\n" + maxr;
	return str;
    }

    public static void main(String[]Args){
	RunningMedian a = new RunningMedian();
	int[] d = new int[10];
	for(int x = 0; x < 10; x++){
	    int z = (int)(10 * Math.random());
	    d[x] = z;
	    a.add(z);
	    System.out.println(a.getMedian());
	    String t = "";
	    for(int y = 0; y <= x; y++){
		t += d[y] + " ";
	    }
	    System.out.println(t);
	}
    }

}

    
