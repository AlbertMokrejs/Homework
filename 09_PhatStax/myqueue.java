public class myqueue<T>{

myLinkedList<T> S;

public myqueue(){
  S = new myLinkedList<T>();}
  
public boolean enqueue(T a){
  if(a == null){
    throw new NullPointerException();}
  S.add(S.size(), a);
  return true;}
  
public T dequeue(){
  if(S.size > 1){
  return S.remove(1);}
  throw new NoSuchElementException();}
  
  
  }
