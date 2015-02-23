import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public String name(){
      return "mokrejs.albert";}
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		ans +="" + board[x][y] + " ";}
	    ans+= "\n";}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		board[x][y] = -1;}}
    }

    public boolean solve(int a, int b){
	if(!solve(a,b,0)){return false;}
	return true;
    }

    
    public boolean solve(){
	if(!solve(0,0,0)){return false;}
	return true;
    }

		
    public boolean solve(int x,int y,int c){
	//wait(10);
	//System.out.println(this);
	if(x < 0 || y < 0 || x >= board.length || y >= board.length){
	    return false;}
	if(board[x][y] != -1){
	    //if(c == board.length*board.length -1 && board[x][y] == 0){
	    //	return true;}
	    return(c == board.length*board.length-1);}
	board[x][y] = c;
	if(solve(x+2,y+1,c+1) || solve(x+2,y-1,c+1) || solve(x-2,y+1,c+1) || solve(x-2,y-1,c+1) || solve(x+1,y-2,c+1) || solve(x+1,y+2,c+1) || solve(x-1,y-2,c+1) || solve(x-1, y+2, c+1)){
	    return true;}
	board[x][y] = -1;
	return false;
    }

    public static void main(String[] args){



    }}
