public class myotherstack<T>{

LinkedList<T> S;

public myotherstack(){
  S = new LinkedList<T>();}
  
public T peek(){
  if(S.isEmpty()){
    throw new EmptyStackException();}
  return S.get(0);}
  
public void push(T x){
  S.add(0, x);}
  
public boolean empty(){
  return S.size()<1;}
  
public T pop(){
  if(empty()){
    throw new EmptyStackException();}
  return S.remove(0);}
  
public int search(T x){
  myotherstack tmp = new myotherstack();
  int z = 1;
  boolean found = false;
  while(!empty() && !found){
    if(peek() == x){
      found = true;}
    else{
      tmp.push(pop());
      z++;}}
  while(!tmp.empty() && tmp.S.size() > 0){
    push(tmp.pop());
    }
  push(tmp.peek());
  if(found){
    return z;}
  return -1;}
  
  }
  
  

