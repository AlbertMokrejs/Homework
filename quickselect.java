//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // header stuff MUST go above the first class
import java.util.Random;

public class quickselect{
  
  public static void quicksort(int[] P){
    int x = quickselect(P,P.length/2);
    qhelper(P,0,x);
  	qhelper(P,x,P.length);}
  
  public static void qhelper(int[] P, int x,int y){
    int z = quickselect(P,x,y,(y-x)/2);
    if(Math.abs(y-x) >= 3){
      qhelper(P,x,z);
      qhelper(P,z,y);}}
    
  
  public static int quickselect(int[] P, int k){
    int x = P.length-1;
    return quickselect(P,0,x,k);}

public static int quickselect(int[] P, int a, int b, int k) {
  int last = b;
  int first = a;
    int x = partition(P, first, last);
    if (x == k-1) {
      return P[k-1];}
    if (x > k){
      return quickselect(P, first, x-1, k);
    }else{
    return quickselect(P, x+ 1, last, k);}}
 
public static int partition(int[] P, int a, int b) {
  int first = a;
  int last = b;
  Random r = new Random();
  int x = first + (int)r.nextDouble()*(last - first + 1);
  swap(P, last, x);
  for (int y = first; y < last; y++) {
    if (P[y] > P[last]) {
      swap(P, y, first);
      first++;}}
  swap(P, first, last);
    return first;}
 
public static void swap(int[] P, int x, int y) {
  int TMP = P[x];
  P[x] = P[y];
  P[y] = TMP;}
  
  public static void main(String[]args){
int[] x = new int[10];
  Random r = new Random();
for(int y = 0; y < 10; y++){
    x[y] = r.nextInt(15)-8;}
  for(int a: x){
    System.out.println(a);}
  quicksort(x);
  System.out.println("/n");
  for(int a: x){
    System.out.println(a);}}

}
