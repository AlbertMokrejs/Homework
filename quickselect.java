//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // header stuff MUST go above the first class
import java.util.Random;

public class quickselect{

public static int quickselect(int[] P, int a, int b, int k) {
  int last = b;
  int start = a;
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
  int x = first + r.nextInt(last - first + 1);
  swap(P, last, x);
  for (int y = first; y < last; y++) {
    if (P[y] > P[last]) {
      swap(P, y, first);
      first++;}}
  swap(P, first, last);
  return first;}
 
public static void swap(int[] P, int x, int y) {
  int TMP = G[x];
  P[x] = P[y];
  P[y] = TMP;}

}
