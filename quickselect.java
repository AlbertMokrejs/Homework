//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // header stuff MUST go above the first class
import java.util.Random;

public class qselect{

public static int partitionS(int[] p, int start, int end){
int[] a = new int[p.length];
Random r = new Random();
int L = 0;
int R = end-1;
int z = (int)r.nextDouble()*end;
for(int x = 0; x < end; x++){
if(x!=z){
if(p[x] < p[z]){
a[L++] = p[x];}
else{
a[R--] = p[x];}}}
a[L] = p[z];
for(int q = end; q< p.length; q++){
  a[q] = p[q];}    
for(int y = 0; y < p.length; y++){
p[y] = a[y];}
return L;}
  
public static int partitionB(int[] p, int start, int end){
int[] a = new int[p.length];
Random r = new Random();
int R = 0;
int L = end-1;
int z = (int)r.nextDouble()*end;
for(int x = 0; x < end; x++){
if(x!=z){
if(p[x] < p[z]){
a[L--] = p[x];}
else{
a[R++] = p[x];}}}
a[L] = p[z];
for(int q = end; q< p.length; q++){
  a[q] = p[q];}    
for(int y = 0; y < p.length; y++){
p[y] = a[y];}
return L;}
  
  public static int findkS(int[] p, int k){
    int x = p.length;
    while(x > k-1){
      x = partitionS(p,0,x);}
    return p[k-1];}
  
    public static int findkB(int[] p, int k){
    int x = p.length;
    while(x > k-1){
      x = partitionB(p,0,x);}
    return p[k-1];}
  
  

public static void main(String[]args){
int[] x = new int[10];
  Random r = new Random();
for(int y = 0; y < 10; y++){
    x[y] = r.nextInt(15)-8;}
  for(int a: x){
    System.out.println(a);}
  int d = findkB(x,3);
  System.out.println("/n" + d);
  for(int a: x){
    System.out.println(a);}}}
