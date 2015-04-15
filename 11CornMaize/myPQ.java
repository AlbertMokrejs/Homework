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
    	if(y > 9999*9999){
    		y = 9999*9999 - 1;
    	}
	if(t < S.length-1){
	    S[t] = x;
	    P[t] = y;
	    t++;
	}else{
	    resize();
	    add(x,y);
	}
    }

    public void add(T x){
	add(x, 9999*9999);
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
	    Object[] tmp = new Object[S.length*2];
	    int[] tmpb = new int[tmp.length];
	    for(int x = 0; x < t; x++){
		tmp[x] = S[x];
		tmpb[x] = P[x];
	    }
	    P = tmpb;
	    S = tmp;
	}
    }
    
    public int findFirst(){
    	int x = 9999*9999 + 1;
    	int z = 0;
    	for(int y = 0; y < t; y++){
    		if(P[y] < x){
    			x = P[y];
    			z = y;
    		}
    	}
    	return z;
    }
    
    public T getS(){
    	int x = findFirst();
    	T tmp = (T)S[x];
    	for(int y = x; y < t; y++){
    		S[y] = S[y+1];
    		P[y] = P[y+1];
    	}
    	S[t] = null;
    	P[t] = 0;
    	t--;
    	return tmp;
    }

}
