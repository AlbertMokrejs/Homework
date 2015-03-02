//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
 
import java.lang.Math; // header stuff MUST go above the first class
import java.util.Arrays;
 
// our main class becomes a file but the main method is still found
public class mergesort{
 
 public static int[] merge(int[] a, int[] b){
    int c = 0;
    int d = 0;
    int[] e = new int[a.length+b.length];
    while(c < a.length && d < b.length){
    if(a[c] > b[d]){
      e[c+d] = b[d];
      d++;}
      else{
      e[c+d] = a[c];
      c++;}}
      if(a.length-(c+1) > 0){
        while(c < a.length){
          e[c+d] = a[c];
          c++;}}
      if(b.length-(d+1) > 0){
        while(d < b.length){
          e[c+d] = b[d];
          d++;}}
    return e;}
          
      public static void mergesort(int[] s){
 int[] a= new int[s.length];
        a = Arrays.copyOf(s,s.length);
        if(a.length == 1){}
        else{if(a.length == 2){
          if(a[0] < a[1]){}
          else{
          int TMP = a[0];
          a[0] = a[1];
            a[1] = TMP;}}
        else{int[] b = new int[a.length/2];
          int[] c = new int[a.length - b.length];
          for(int x = 0; x < a.length; x++){
            if(x < b.length){
              b[x] = a[x];}
            else{
              c[x - b.length] = a[x];}}
             mergesort(b);
             mergesort(c);
              a = merge(b,c);}}
for(int x = 0; x<s.length; x++){
s[x] =  a[x];}
}
  
  public static void main(String[]args){
    int[] x = new int[30];
    for(int y = 0; y < x.length; y++){
      x[y] = 100 + y*10 - (y%2)*1000;}
    mergesort(x);
    for(int z = 0; z < x.length; z++){
      System.out.println(x[z]);}}}
