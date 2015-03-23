import java.util.*;

public class myqueue<T>{

MyLinkedList<T> S;

public myqueue(){
  S = new MyLinkedList<T>();}
  
public boolean enqueue(T a){
  if(a == null){
    throw new NullPointerException();}
  S.add(S.size(), a);
  return true;}
  
public T dequeue(){
    if(S.size() > 1){
  return S.remove(1);}
  throw new NoSuchElementException();}
  
  
  }
