public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    public char[][]board;
    
    public String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "albert.mokrejs";
    }

    public String toString(){
	String tmp = "\n";
	for (int y = 0; y < board.length; y ++){
	    for (int x = 0; x < board[0].length; x ++){
		tmp += " " + board[y][x];}
	    tmp += "\n";}
	return hide + clear + go(0,0) + tmp + "\n" + show;}

    public NQueens(int a){
	board = new char[a][a];
	for (int y = 0; y < a; y ++){
	    for (int x = 0; x < a; x ++){
		board[y][x] = '_';}}}
    
    public boolean solve(){
	return solve(0, board.length);
    }
    
    public boolean solve(int x){
	if (x < 0 || x > board.length){
	    return false;}
	board[0][x] = 'Q';
	return solve(1, board.length - 1);}

    public boolean solve(int y, int n){
	if (n == 0){
	    return true;}
	for (int x = 0; x < board.length; x ++){
	    if (check(x, y)){
	        board[y][x] = 'Q';
		if (solve(y + 1, n - 1)){
		    return true;}
		board[y][x] = '_';}}
	return false;}

    public boolean check(int c, int r){
        for (int y = r; y >= 0; y--){
	    if (board[y][c] == 'Q'){
		return false;}}
	int x = c;
	int y = r;
	while(x >= 0 && y >= 0){
	    if (board[y][x] == 'Q'){
		return false;}
	    x--;
	    y--;}
        while(c < board.length && r >= 0){
	    if (board[r][c] == 'Q'){
		return false;}
	    c++;
	    r--;}
	return true;}

}

