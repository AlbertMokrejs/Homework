public class LNode<T>{
    T value;
    LNode<T> pointer;

    public void set(T a){
	value = a;}

    public void link(LNode<T> a){
	pointer = a;}
  
    public T get(){
	return value;}
  
    public LNode<T> next(){
	if(hasNext()){
	    return pointer;}
	return null;}
  
    public boolean hasNext(){
	return pointer!=null;}
  
    public void delink(){
	pointer = null;}

    public int findEnd(){
	if(hasNext()){
	    return 1+next().findEnd();}
	return 0;}
  
    public LNode<T> findFromEnd(int n){
	int x = findEnd();
	LNode<T> tmp = this;
	while(x > n && tmp.hasNext()){
	    tmp = tmp.next();
	    x--;
	}
	return tmp;
    }


    public String toString(){
	return ""+value;}

    LNode(T a, LNode<T> b){
	value = a;
	pointer = b;}
  
    LNode(){
	value = 0;
	pointer = null;}
  
    LNode(T a){
	value = a;
	pointer = null;}

}
