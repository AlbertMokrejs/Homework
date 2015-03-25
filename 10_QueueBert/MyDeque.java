public class MyDeque<T>{
    public int h;
    public int t;
    public T[] S;

    public MyDeque()<T>(){
	S = new T[10];
	h = 0;
	t = 0;}

    public void addFirst(T x){
	if(h-1 == t){
	    resize();}
	if(h == 0 && t == S.length -1;){
	    resize();}
	if(h == t){
	    S[h] = x;}
	else{
	    if(h!=0){
		S[h-1] = x;}
	    else{
		h = length;
		S[h-1] = x;}}
	h--;
    }

    public void addLast(T x){
	if(h-1 == t){
	    resize();}
	if(h == 0 && t == S.length -1;){
	    resize();}
	if(h == t){
	    S[h] = x;}
	else{
	    if(t!=length-1;){
		S[t+1] = x;}
	    else{
		t = -1;
		S[t+1] = x;}}
	t++;}
	  

    public T removeFirst(){
	if(S[h] == null){
	    throw new NoSuchElementException();}
        T tmp = S[h];
	S[h] = null;
	h++;
	if(h > S.length-1){
	    h = 0;}
	return tmp;}
	
	}
