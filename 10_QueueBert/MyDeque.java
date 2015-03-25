//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // header stuff MUST go above the first class
import java.util.*;

public class MyDeque<T>{
    public int h;
    public int t;
    public Object[] S;

    public MyDeque(){
	S = new Object[10];
	h = 0;
	t = 0;}

    public void addFirst(T x){
	if(h-1 == t){
	    resize();}
	if(h == 0 && t == S.length -1){
	    resize();}
	if(h == t && S[h] == null){
	    S[h] = x;}
	if(h == t-1 && S[h] == null){
	    S[h] = x;}
	else{
	    if(h!=0){
		S[h-1] = x;}
	    else{
		h = S.length;
		S[h-1] = x;}}
	h--;
    }

    public void addLast(T x){
	if(h-1 == t){
	    resize();}
	if(h == 0 && t == S.length -1){
	    resize();}
	if(h == t && S[t] == null){
	    S[h] = x;}
	if(h == t-1 && S[t] == null){
	    S[t] = x;}
	else{
	    if(t!=S.length-1){
		S[t+1] = x;}
	    else{
		t = -1;
		S[t+1] = x;}}
	t++;}
	  

    public T removeFirst(){
	if(S[h] == null){
	    throw new NoSuchElementException();}
        T tmp = (T)S[h];
	S[h] = null;
	h++;
	if(h > S.length-1){
	    h = 0;}
	return tmp;}

    public T removeLast(){
	if(S[t] == null){
	    throw new NoSuchElementException();}
    T tmp = (T)S[t];
    S[t] = null;
    t--;
    if(t < 0){
	h = s.length-1;}
    return tmp;}

    public T getFirst(){
	if(S[h] == null){
	    throw new NoSuchElementException();}
	return (T)S[h];}

    public T getLast(){
	if(S[t] == null){
	    throw new NoSuchElementException();}
	return (T)S[t];}

    public void resize(){
	Object[] z = new Object[S.length *2];
	int c = 0;
	int x = h;
	if(t < h){
	    while(x < S.length){
		T[c] = S[x];
		x++;
		c++;}
	    x = 0;
	    while(x < t+1){
		T[x] = S[x];
		x++;
		c++;}}
	if(h < t){
	    while(x <= t){
		T[c] = S[x];
		x++;
		c++;}}
	S = T;}

}
