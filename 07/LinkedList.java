public class LinkedList{
    LNode start;
    LNode end;

    public LinkedList(LNode a){
	start = a;
	end = a;}

    public LNode get(int a){
	if(a < 0 or a > start.findEnd()){
	    throw new IndexOutOfBoundsException;}
	LNode tmp = start;
    	while(tmp.hasNext() && a > 0){
    		tmp = tmp.next();
    		a--;
    	}
    	return tmp;
    }

    public void set(int a, int b){
	get(a).set(a);}

    public void add(int a, int b){
        if(a < 0){
	    throw new IndexOutOfBoundsException;}
	if(a > start.findEnd()){
	    LNode x = new LNode(b);
	    end.link(x);
	    end = x;}
	if(a == 0){
	    LNode x = new LNode(b);
	    x.link(start);
	    start = x;}
	else{
	    LNode x = new LNode(b);
	    x.link(get(a));
	    get(a-1).link(x);}}

    public void add(int a){
	LNode x = new LNode(a);
	end.link(x);
	end = x;}

    public void remove(int a){
    	get(a-1).link(get(a+1));}
    
	
	
	
	    
