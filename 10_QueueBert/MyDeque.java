	
	import java.util.*;
	
	public class MyDeque<T>{
	    public int h;
	    public int t;
	    public Object[] S;
	    public boolean TOGGLE;
	    
	    public String name(){
	    	return "Mokrejs,Albert";
	    }
	    
	    public static T findFirst(){
	    	MyDeque<T> tmp = new MyDeque<T>(TOGGLE);
	    	T x = this.getFirst();
	    	try{
	    		while(true){
	    			tmp.addFirst(this.removeFirst());
	    			if(tmp.getFirst().compareTo(x) > 0){
	    				x = tmp.getFirst();
	    			}
	    		}
	    	}
	    	catch(NoSuchElementException e){
	    	}
	    	try{
	    		while(true){
	    			if(!tmp.getFirst().equals(x)){
	    				this.addFirst(tmp.removeFirst());}
	    			else{
	    				tmp.removeFirst();
	    			}
	    		}
	    	}
	    	catch(NoSuchElementException e){
	    	}
	    	return x;
	    }
	    

	    public static void main(String[]args){
		MyDeque a = new MyDeque(true);
		a.addFirst(5);
		a.addFirst(6);
		a.addLast(4);
		a.addLast(3);
		a.addLast(2);
		a.addFirst(7);
		System.out.println(a);
		for(int x = 0; x < 240; x++){
		    System.out.println(a);
		    a.addLast(x%5);}
		for(int y = 0; y < 240; y++){
		    System.out.println(a);
		    a.removeLast();}
		System.out.println(a);}
		
	
	    public MyDeque(){
		S = new Object[16];
		h = 4;
		t = 4;
	    	TOGGLE = true;
	    }
	    
	    public MyDeque(boolean x){
	    	S = new Object[16];
	    	h = 4;
	    	t = 4;
	    	TOGGLE = x;
	    }
	    
	    public String toString(){
		String str = "";
		int x = h;
		if(h > t){
		    while(x < S.length){
			str += S[x] + " , ";
			x++;}
		    x = 0;
		    while(x <= t){
			str += S[x] + " , ";
			x++;}}
		else{
		    while(x <= t){
			str += S[x] + " , ";
			x++;}}
		return str;}


	    public void flop(){
	    	TOGGLE = !TOGGLE;
	    }
	
	    public void addFirst(T x){
		if(h-1 == t){
		    resize();}
		if(h == 0 && t == S.length -1){
		    resize();}
		if(h == t && S[h] == null){
		    S[h] = x;
		    h++;}
		if(h == t-1 && S[h] == null){ //second add is a special case
		    S[h] = x;
		    h++;}
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
		    S[t] = x;
		    t--;}
		if(h == t-1 && S[t] == null){ //special case
		    S[t] = x;
		    t--;}
		else{
		    if(t!=S.length-1){
			S[t+1] = x;}
		    else{
			t = -1;
			S[t+1] = x;}}
		t++;}
		  
	
	    public T removeFirst(){
		h++;
		if(S[h] == null){
		    h--;
		    throw new NoSuchElementException();}
	        T tmp = (T)S[h];
		S[h-1] = null;
		if(h > S.length-1){
		    h = 0;}
		if(S.length < 1000 && TOGGLE && size() <= (int)S.length/4){
			desize();
		}
		return tmp;}
	
	    public T removeLast(){
		t--;
		if(S[t] == null){
		    t++;
		    throw new NoSuchElementException();}
	    T tmp = (T)S[t];
	    S[t+1] = null;
	    if(t < 0){
		t = S.length-1;}
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
		Object[] T = new Object[S.length *2];
		int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			T[c] = S[x];
			x++;
			c++;}
		    x = 0;
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		h = 0;
		t = c-1;
		S = T;}
		
		public void desize(){
		Object[] T = new Object[(int)S.length/2];
		int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			T[c] = S[x];
			x++;
			c++;}
		    x = 0;
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			T[c] = S[x];
			x++;
			c++;}}
		h = 0;
		t = c-1;
		S = T;}
		
		public int size(){
			int c = 0;
		int x = h;
		if(t < h){
		    while(x < S.length){
			x++;
			c++;}
		    x = 0;
		    while(x <= t){
			x++;
			c++;}}
		if(h < t){
		    while(x <= t){
			x++;
			c++;}}
			return c;}
		
}
