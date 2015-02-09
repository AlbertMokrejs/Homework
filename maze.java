import java.util.*;

public class mase{

public static void main(String[]args){
Char[][] a = new Char[8][];
a[0] = new Char[]{'X','X','X','X','X'};
a[1] = new Char[]{'X','s','X',' ','X'};
a[2] = new Char[]{'X',' ',' ',' ','X'};
a[3] = new Char[]{'X',' ','X',' ','X'};
a[4] = new Char[]{'X','X','X','E','X'};
System.out.println(solver(a));}

public static Char[][] solver(Char[][] a){
for(int x = 0; x < a.length; x++){
for(int y = 0; y < a[0].length; y++){
if(a[x][y] == 's'){
return solve(a,x,y);}}}}

public static Char[][] solve(Char[][] a, int b, int c){
if(a[b][c] == 'E'){
return a;}
if(a[b][c] == '@' || a[b][c] == 'X'){
return new Char[1][1];}
a[b][c] = '@';
Char[][] tmp = solve(a,b+1,c);
if(tmp.length > 1){return tmp;}
Char[][] tmp = solve(a,b-1,c);
if(tmp.length > 1){return tmp;}
Char[][] tmp = solve(a,b,c+1);
if(tmp.length > 1){return tmp;}
Char[][] tmp = solve(a,b,c-1);
if(tmp.length > 1){return tmp;}
return new Char[1][1];}
}
