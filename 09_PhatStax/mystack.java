public class mystack<T>{

MyLinkedList<T> S;

public mystack(){
  S = new MyLinkedList<T>();}
  
public T peek(){
  if(S.isEmpty()){
    throw new EmptyStackException();}
  return S.get(0);}
  
public void push(T x){
  if(S.isEmpty()){
    S.set(0, x);}
  else{
  S.add(0, x);}}
  
public boolean empty(){
  return S.isEmpty();}
  
public T pop(){
  if(S.isEmpty()){
    throw new EmptyStackException();}
  return S.remove(0);}
  
public int search(T x){
  mystack tmp = new mystack();
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
  
  

