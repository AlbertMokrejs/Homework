public class LinkedList{
    LNode start;
    LNode end;
    int Q;

    public LinkedList(int a){
	LNode x = new LNode(a);
	start = x;
	end = x;
	Q = 1;}

    public LinkedList(LNode a){
	start = a;
	end = a;
	Q = 1;}

    public LinkedList(){
	LNode a = new LNode();
	start = a;
	end = a;
	Q = 1;}

    public LNode get(int a){
	if(a < 0 || a > size()){
	    throw new IndexOutOfBoundsException();}
	LNode tmp = start;
    	while(tmp.hasNext() && a > 0){
	    tmp = tmp.next();
	    a--;
    	}
    	return tmp;
    }

    public int size(){
	return Q;}

    public void set(int a, int b){
	get(a).set(a);}

    public boolean add(int a, int b){
        if(a < 0 || a >= size()){
	    throw new IndexOutOfBoundsException();}
	if(a == 0){
	    LNode x = new LNode(b);
	    x.link(start);
	    start = x;}
	if(a == size()){
	    LNode x = new LNode(b);
	    end.link(x);
	    end = x;}
	else{
	    LNode x = new LNode(b);
	    x.link(get(a));
	    get(a-1).link(x);}
	Q++;
	return true;}

    public boolean add(int a){
	LNode x = new LNode(a);
	end.link(x);
	end = x;
	Q++;
	return true;}

    public int remove(){
	LNode y = start;
	LNode x = get(1);
	start.delink();
	start = x;
	Q--;
	return y.get();}

    public int remove(int a){
	if(a >= size()){
	    throw new IndexOutOfBoundsException();}
	Q--;
	if(a == 0){
	    return remove();}
	else{
	    LNode x = get(a);
	    get(a-1).link(get(a+1));
	    x.delink();
	    return x.get();}}

    public int removeLast(){
	Q--;
	LNode tmp = start;
    	while(tmp.hasNext() && tmp.next()!=end){
	    tmp = tmp.next();
    	}
	LNode str = end;
	end = tmp;
	tmp.delink();
	return str.get();
    }
    
    public boolean contains(int a){
	LNode tmp = start;
	while(tmp.hasNext()){
	    if(tmp.get() == a){
		return true;}
	    tmp = tmp.next();}
	return false;}

    public boolean contains(LNode a){
	LNode tmp = start;
	while(tmp.hasNext()){
	    if(tmp == a){
		return true;}
	    tmp = tmp.next();}
	return false;}



    public int indexOf(int a){
	LNode tmp = start;
	int x = 0;
	int str = start.get();
	while(tmp.hasNext() && tmp.get()!= a){
	    str = tmp.get();
	    tmp = tmp.next();
	    x++;}
	if(tmp.get() != a){
	    x = -1;}
	return x;
	}

    public int lastIndexOf(int a){
	LNode tmp = start;
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
	LNode tmp = start;
	while(tmp.hasNext()){
	    a += "" + tmp +",";
	    tmp = tmp.next();}
	a+= "" + tmp + "";
	a+= "]";
	return a;}
	

    public static void main(String[] args){
	LinkedList x = new LinkedList(5);
	x.add(4);
	x.add(3);
	x.add(2);
	x.add(1);
	x.remove(x.indexOf(3));
	System.out.println(x);}
	
	    
}
