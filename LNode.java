public class LNode{
int value;
LNode pointer;

public void set(int a){
  value = a;}

public void link(LNode a){
  pointer = a;}
  
public int get(){
  return value;}
  
public int next(){
  return pointer;}
  
public boolean hasNext(){
  return pointer!=null;}
  
LNode(int a, LNode b){
  value = a;
  pointer = b;}
  
LNode(){
  value = 0;
  pointer = null;}
  
LNode(int a){
  value = a;
  pointer = null;}
  
