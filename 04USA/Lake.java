public class Lake{

    public int R;
    public int C;
    public int E;
    public int N;
    public int[] A;
    public int[][] B;
    public int Z;

    public Lake(int a, int b, int c, int d, int[][]e, int[] f){
	R = a;
	C = b;
	E = c;
	N = d;
	B = new int[e.length][e[0].length];
	A = new int[f.length];
	for(int x = 0; x < a; x++){
	    for(int y = 0; y < b; y++){
		B[x][y] = e[x][y];}}
	for(int x = 0; x < f.length; x++){
	    A[x] = f[x];}}

    public String toString(){
	return "" + Z;}

    public void start(){
	for(int x = 0; x < A.length; x+= 3){
	    run(A[x],A[x+1],A[x+2]);}
	Z = water();}

    public void run(int a, int b, int c){
	int[][] TMP = new int[3][3];
	int z = 0;
	int u = 0;
	for(int x = 0; x <= 2 && a+x < B.length; x++){
	    for(int y = 0; y < 2 && b+y < B[0].length; y++){
		TMP[z/3][z%3] = B[a+x][b+y];
		if(u < B[a+x][b+y]){
		    u = B[a+x][b+y];}
		z++;}}
	u -= c;
	z = 0;
	for(int x = 0; x < 3; x++){
	    for(int y = 0; y < 3; y++){
		if(TMP[z/3][z%3] > u){
		    B[a+x][b+y] = u;}
		z++;}}}

    public int  water(){
	int d = 0;
	for(int x = 0; x < R; x++){
	    for(int y = 0; y < C; y++){
		if(B[x][y] >= E){
		    B[x][y] = 0;}
		else{
		    B[x][y] = E - B[x][y];}
		d += B[x][y];}}
	return (d+1) * 72 * 72;}

    public static void main(String[]args){
	int[][] D = {
	    {28, 25, 20, 32, 34, 36},{
		27, 25, 20, 20, 30, 34},{
		24, 20, 20, 20, 20, 30},{
		20, 20, 14, 14, 20, 20}};
	int[] E = {1,4,4,1,1,10};
	Lake a = new Lake(4, 6, 22, 2, D, E);
	a.start();
	System.out.println(a);}}


	
	
