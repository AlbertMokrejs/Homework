public class LNode{
    int value;
    LNode pointer;

    public void set(int a){
	value = a;}

    public void link(LNode a){
	pointer = a;}
  
    public int get(){
	return value;}
  
    public LNode next(){
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
  
    public LNode findFromEnd(int n){
	int x = findEnd();
	LNode tmp = this;
	while(x > n && tmp.hasNext()){
	    tmp = tmp.next();
	    x--;
	}
	return tmp;
    }


    public String toString(){
	return ""+value;}

    LNode(int a, LNode b){
	value = a;
	pointer = b;}
  
    LNode(){
	value = 0;
	pointer = null;}
  
    LNode(int a){
	value = a;
	pointer = null;}

}
