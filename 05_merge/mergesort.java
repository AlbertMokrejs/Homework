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
          e[c+d] = a[d];
          d++;}}}
          
      public static void mergesort(int[] a){
        if(a.length == 1){}
        else{if(a.length == 2 && a[0] < a[1]){}
        else{int[] b = new int[a.length/2];
          int[] c = new int[a.length - b.length];
          for(int x = 0; x < a.length; x++){
            if(x < b.length){
              b[x] = a[x];}
            else{
              c[x - b.length] = a[x];}}
              a = merge(b.mergesort(), c.mergesort());}}}}
        
