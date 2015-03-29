	
	import java.util.*;
	
	public class MyDeque<T>{
	    public int h;
	    public int t;
	    public Object[] S;
	    public boolean TOGGLE;
	
	    public MyDeque(){
		S = new Object[16];
		h = 0;
		t = 0;
	    	TOGGLE = true;
	    }
	    
	    public MyDeque(boolean x){
	    	S = new Object[16];
	    	h = 0;
	    	t = 0;
	    	TOGGLE = x;
	    }
	    
	    public void flop(){
	    	TOGGLE = !TOGGLE;
	    }
	
	    public void addFirst(T x){
		if(h-1 == t){
		    resize();}
		if(h == 0 && t == S.length -1){
		    resize();}
		if(h == t && S[h] == null){
		    S[h] = x;}
		if(h == t-1 && S[h] == null){ //second add is a special case
		    S[h] = x;}
		else{
		    if(h!=0){
			S[h-1] = x;}
		    else{
			h = S.length;
			S[h-1] = x;}}
		h--;
	    }
	
	    public void addLast(T x){
		if(h-1 == t){
		    resize();}
		if(h == 0 && t == S.length -1){
		    resize();}
		if(h == t && S[t] == null){
		    S[h] = x;}
		if(h == t-1 && S[t] == null){ //special case
		    S[t] = x;}
		else{
		    if(t!=S.length-1){
			S[t+1] = x;}
		    else{
			t = -1;
			S[t+1] = x;}}
		t++;}
		  
	
	    public T removeFirst(){
		if(S[h] == null){
		    throw new NoSuchElementException();}
	        T tmp = (T)S[h];
		S[h] = null;
		h++;
		if(h > S.length-1){
		    h = 0;}
		if(S.length < 1000 && TOGGLE && size() <= (int)S.length/4){
			desize();
		}
		return tmp;}
	
	    public T removeLast(){
		if(S[t] == null){
		    throw new NoSuchElementException();}
	    T tmp = (T)S[t];
	    S[t] = null;
	    t--;
	    if(t < 0){
		h = s.length-1;}
		if(S.length < 10000 && TOGGLE && size() <= (int)S.length/4){
			desize();
		}
	    return tmp;}
	
	    public T getFirst(){
		if(S[h] == null){
		    throw new NoSuchElementException();}
		return (T)S[h];}
	
	    public T getLast(){
		if(S[t] == null){
		    throw new NoSuchElementException();}
		return (T)S[t];}
	
	    public void resize(){
		Object[] z = new Object[S.length *2];
		int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			T[c] = S[x];
			x++;
			c++;}
		    x = 0;
		    while(x < t+1){
			T[x] = S[x];
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		S = T;}
		
		public void desize(){
		Object[] z = new Object[(int)S.length/2];
		int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			T[c] = S[x];
			x++;
			c++;}
		    x = 0;
		    while(x < t+1){
			T[x] = S[x];
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		S = T;}
		
		public int size(){
			int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			x++;
			c++;}
		    x = 0;
		    while(x < t+1){
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			x++;
			c++;}}
			return c;}
		
}
