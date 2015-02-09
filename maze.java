import java.util.*;

public class mase{

public static void main(String[]args){
char[][] a = new char[8][];
a[0] = new char[]{'X','X','X','X','X'};
a[1] = new char[]{'X','s','X',' ','X'};
a[2] = new char[]{'X',' ',' ',' ','X'};
a[3] = new char[]{'X',' ','X',' ','X'};
a[4] = new char[]{'X','X','X','E','X'};
System.out.println(solver(a));}

public static char[][] solver(char[][] a){
for(int x = 0; x < a.length; x++){
for(int y = 0; y < a[0].length; y++){
if(a[x][y] == 's'){
return solve(a,x,y);}}}}

public static char[][] solve(char[][] a, int b, int c){
if(a[b][c] == 'E'){
return a;}
if(a[b][c] == '@' || a[b][c] == 'X'){
return new char[1][1];}
a[b][c] = '@';
char[][] tmp = solve(a,b+1,c);
if(tmp.length > 1){return tmp;}
char[][] tmp = solve(a,b-1,c);
if(tmp.length > 1){return tmp;}
char[][] tmp = solve(a,b,c+1);
if(tmp.length > 1){return tmp;}
char[][] tmp = solve(a,b,c-1);
if(tmp.length > 1){return tmp;}
return new char[1][1];}
}
