public class MyLinkedList<T>{
    LNode<T> start;
    LNode<T> end;
    int Q;
    
    public String name(){
	return "Mokrejš, Albert";
    }

    public MyLinkedList(T a){
	LNode<T> x = new LNode<T>(a);
	start = x;
	end = x;
	Q = 1;}

    public MyLinkedList(LNode<T> a){
	start = a;
	end = a;
	Q = 1;}

    public MyLinkedList(){
	LNode<T> a = new LNode<T>();
	start = a;
	end = a;
	Q = 1;}

    public LNode<T> get(int a){
	if(a < 0 || a > size()){
	    throw new IndexOutOfBoundsException();}
	LNode<T> tmp = start;
    	while(tmp.hasNext() && a > 0){
	    tmp = tmp.next();
	    a--;
    	}
    	return tmp;
    }

    public int size(){
	return Q;}

    public void set(int a, T b){
	get(a).set(b);}

    public boolean add(int a, T b){
        if(a < 0 || a >= size()){
	    throw new IndexOutOfBoundsException();}
	if(a == 0){
	    LNode<T> x = new LNode<T>(b);
	    x.link(start);
	    start = x;}
	if(a == size()){
	    LNode<T> x = new LNode<T>(b);
	    end.link(x);
	    end = x;}
	else{
	    LNode<T> x = new LNode<T>(b);
	    x.link(get(a));
	    get(a-1).link(x);}
	Q++;
	return true;}

    public boolean add(T a){
	LNode<T> x = new LNode<T>(a);
	end.link(x);
	end = x;
	Q++;
	return true;}

    public T remove(){
	LNode<T> y = start;
	LNode<T> x = get(1);
	start.delink();
	start = x;
	Q--;
	return y.get();}

    public T remove(int a){
	if(a >= size()){
	    throw new IndexOutOfBoundsException();}
	Q--;
	if(a == 0){
	    return remove();}
	else{
	    LNode<T> x = get(a);
	    get(a-1).link(get(a+1));
	    x.delink();
	    return x.get();}}

    public T removeLast(){
	Q--;
	LNode<T> tmp = start;
    	while(tmp.hasNext() && tmp.next()!=end){
	    tmp = tmp.next();
    	}
	LNode<T> str = end;
	end = tmp;
	tmp.delink();
	return str.get();
    }
    
    public boolean contains(T a){
	LNode<T> tmp = start;
	while(tmp.hasNext()){
	    if(tmp.get() == a){
		return true;}
	    tmp = tmp.next();}
	return false;}

    public boolean contains(LNode a){
	LNode<T> tmp = start;
	while(tmp.hasNext()){
	    if(tmp == a){
		return true;}
	    tmp = tmp.next();}
	return false;}



    public int indexOf(T a){
	LNode<T> tmp = start;
	int x = 0;
	T str = start.get();
	while(tmp.hasNext() && tmp.get()!= a){
	    str = tmp.get();
	    tmp = tmp.next();
	    x++;}
	if(tmp.get() != a){
	    x = -1;}
	return x;
	}

    public int lastIndexOf(T a){
	LNode<T> tmp = start;
	int x = 0;
	int y = -1;
	while(tmp.hasNext()){
	    if(tmp.get() == a){
		y = x;}
	    tmp = tmp.next();
	    x++;}
	return y;}


    public String toString(){
	String a = "[";
	LNode<T> tmp = start;
	while(tmp.hasNext()){
	    a += "" + tmp +",";
	    tmp = tmp.next();}
	a+= "" + tmp + "]";
	return a;}
	

	
	    
}
