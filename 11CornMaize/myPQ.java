import java.util.*;

public class myPQ<T>{

    public int t;
    public Object[] S;
    public int[] P;
    public boolean TOGGLE;

    public myPQ(){
	S = new Object[16];
	t = 0;
	TOGGLE = true;
    }

    public myPQ(boolean x){
	S = new Object[16];
	t = 0;
	TOGGLE = x;
    }

    public void flop(){
	TOGGLE = !TOGGLE;
    }

    public void add(T x, int y){
	if(t < S.length-1){
	    S[t] = x;
	    P[t] = y;
	    t++;
	}else{
	    resize();
	    add(x,y);
	}
    }

    public void resize(){
	if(t < S.length/4){
	    Object[] tmp = new Object[(int)S.length/4 +1];
	    int[] tmpb = new int[tmp.length];
	    for(int x = 0; x < t; x++){
		tmp[x] = S[x];
		tmpb[x] = P[x];
	    }
	    P = tmpb;
	    S = tmp;
	}
	else{
	    
		
