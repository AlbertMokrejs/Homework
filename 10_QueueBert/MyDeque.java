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
	if(h == t && S[h] == null){
	    S[h] = x;}
	if(h == t-1 && S[h] == null){
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
	if(h == t && S[t] == null){
	    S[h] = x;}
	if(h == t-1 && S[t] == null){
	    S[t] = x;}
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

    public T removeLast(){
	if(S[t] == null){
	    throw new NoSuchElementException();}
    T tmp = S[t];
    S[t] = null;
    t--;
    if(t < 0){
	h = s.length-1;}
    return tmp;}

    public T getFirst(){
	if(S[h] == null){
	    throw new NoSuchElementException();}
	return S[h];}

    public T getLast(){
	is(S[t] == null){
	    throw new NoSuchElementException();}
	return S[t];}

    public void resize(){
	T[] z = new T[S.length *2];
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

}
