import java.util.*;

public class nqueens{

    public char[][] board;
    
    public nqueens(){
	this(5);}

    public nqueens(int a){
	char[][] board = new char[a][a];
	for(int x = 0; x<board.length; x++){
	    for(int y =0; y<board.length; y++){
		board[x][y] = ' ';}}}
 
  public String toString(){
	String str = "";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y<board.length;y++){
		str+= board[x][y];}
	    str+= "\n";}
	return str;}


    public boolean solve(){
	for(int x = 0; x < board.length; x++){
	    if(solve(0,x)){
		return true;}}
	return false;}

    public boolean solve(int a, int b){
	return solver(a,b,0);}

    public boolean line(int a, int b, int c, int d){
	if(a < 0 || b < 0 || b > board.length || a > board.length || board[a][b] == '@'){
	    return false;}
	else{
	    boolean tmp = line(a+c,b+d,c,d);
	    if(tmp){
		board[a][b] = 'x';
	    }
	    return tmp;}}
	    

    public boolean solver(int a, int b, int c){
	if(board[a][b] == 'x' || board[a][b] == '@'){
	    return false;}else{
	    if(line(a,b,1,1) && line(a,b,-1,-1) && line(a,b,-1,1) && line(a,b,1,-1) && line(a,b,0,1) && line(a,b,0,-1) && line(a,b,1,0) && line(a,b,-1,0)){
		board[a][b] = '@';
		c++;
		if(c == board.length){
		    return true;}
		for(int x = 0; x < board.length; x++){
		    if(solver(a+1,x,c)){
			return true;}}
		return false;}
	}
	return false;}

    public static void main(String[] args){
	nqueens a = new nqueens();
	a.solve();
	System.out.println(a);}}
