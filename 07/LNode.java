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
  return pointer;}}
  
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
  while(x > n and tmp.hasNext()){
    tmp = tmp.next();
    x--;
  }
  return tmp;
}

public void insert(LNode a){
  LNode x;
  if(hasNext()){
    x = next();
  }
  a.link(x);
  link(a);
}

public void remove(int n){
  if(n == 0){
    findFromEnd(1).delink();
  }
  else{
    findFromEnd(n+1).link(findFromEnd(n-1));
  }
}

LNode(int a, LNode b){
  value = a;
  pointer = b;}
  
LNode(){
  value = 0;
  pointer = null;}
  
LNode(int a){
  value = a;
  pointer = null;}}
  
