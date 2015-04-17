import java.util.*;
import java.io.*;

public class Maze{

    ArrayDeque<Stack<coord>> deck;
    myPQ<Stack<coord>> PQ;
    char[][] map;
    boolean solved;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    boolean printmode;
    int[] solution;
    coord exitnode;
    int mode;
    Stack<coord> a;
    
public boolean runMode(int b){
    mode = b;
    Stack<coord> tmp = new Stack<coord>();
	while(!solved){
	    if(0 == mode || 1 == mode){
	    tmp = deck.removeFirst();
	    deck.addFirst(tmp);
	    }
	    if(2 == mode){
	        tmp = PQ.getS();
	        PQ.add(tmp, 9999*9999 - tmp.peek().getd());
	    }
	    if(3 == mode){
	        tmp = PQ.getS();
	        PQ.add(tmp, 9999*9999 - (tmp.peek().getd() + tmp.peek().dist(exitnode)) );
	    }
	    solved = solution(tmp.peek());
	    if(!solved){
		    nextMode(mode);
	    }
	}
	coord tmpb;
	Stack<coord> copy = (Stack<coord>)tmp.clone();
	int z = 0;
	Stack<coord> newer = new Stack<coord>();
	while(!copy.empty()){
		newer.push(copy.pop());
		z++;
	}
	z-=1;
	int x = 0;
	solution = new int[z+1];
	newer.pop();
	while(x < z){
		solution[x+1] = newer.peek().getx();
		solution[x] = newer.pop().gety();
		x+= 2;
	}
	while(!tmp.empty()){
	    tmpb = tmp.pop();
	    map[tmpb.getx()][tmpb.gety()] = 'x';
	}
	return true;
}

public void nextMode(int f){
    if(f == 0 || f == 1){
    a = deck.removeFirst();
    }
    else{
    a = PQ.getS();
    }
	coord tmpz = new coord(a.peek());
	coord tmpy = new coord(a.peek());
	coord tmpx = new coord(a.peek());
	coord tmpw = new coord(a.peek());
	coord tmpa = new coord(a.pop());
	coord tmpb = new coord(a.peek());
	a.push(tmpa);
	tmpz.setx(tmpz.getx()+1);
	if(check(tmpz,tmpb)){
	    printify(tmpz);
	    Stack<coord> tmpsa = (Stack<coord>)a.clone();
	    tmpsa.push(tmpz);
	    if(f == 0){
	    deck.addLast(tmpsa);
	    }
	    if(f == 1){
	        deck.addFirst(tmpsa);
	    }
	    if(f == 2){
	        PQ.add(tmpsa, 9999*9999 - tmpsa.peek().getd());
	    }
	    if(f == 3){
	        PQ.add(tmpsa, 9999*9999 - (tmpsa.peek().getd() + tmpsa.peek().dist(exitnode)) );
	    }
	}
	tmpy.setx(tmpy.getx()-1);
	if(check(tmpy,tmpb)){
	    printify(tmpy);
	    Stack<coord> tmpsb = (Stack<coord>)a.clone();
	    tmpsb.push(tmpy);
	    if(f == 0){
	    deck.addLast(tmpsb);
	    }
	    if(f == 1){
	        deck.addFirst(tmpsb);
	    }
	    if(f == 2){
	        PQ.add(tmpsb, 9999*9999 - tmpsb.peek().getd());
	    }
	    if(f == 3){
	        PQ.add(tmpsb, 9999*9999 - (tmpsb.peek().getd() + tmpsb.peek().dist(exitnode)) );
	    }
	}
	tmpx.sety(tmpx.gety()+1);
	if(check(tmpx,tmpb)){
	    printify(tmpx);
	    Stack<coord> tmpsc = (Stack<coord>)a.clone();
	    tmpsc.push(tmpx);
	    if(f == 0){
	    deck.addLast(tmpsc);
	    }
	    if(f == 1){
	        deck.addFirst(tmpsc);
	    }
	    if(f == 2){
	        PQ.add(tmpsc, 9999*9999 - tmpsc.peek().getd());
	    }
	    if(f == 3){
	        PQ.add(tmpsc, 9999*9999 - (tmpsc.peek().getd() + tmpsc.peek().dist(exitnode)) );
	    }
	}
	tmpw.sety(tmpw.gety()-1);
	if(check(tmpw,tmpb)){
	    printify(tmpw);
	    Stack<coord> tmpsd = (Stack<coord>)a.clone();
	    tmpsd.push(tmpw);
	    if(f == 0){
	    deck.addLast(tmpsd);
	    }
	    if(f == 1){
	        deck.addFirst(tmpsd);
	    }
	    if(f == 2){
	        PQ.add(tmpsd, 9999*9999 - tmpsd.peek().getd());
	    }
	    if(f == 3){
	        PQ.add(tmpsd, 9999*9999 - (tmpsd.peek().getd() + tmpsd.peek().dist(exitnode)) );
	    }
	}
}
    
	
public Maze(String name){
    mode = 0;
	String str = "";
	int X = -1;
	int Y = 0;
	try{
	    Scanner fi = new Scanner(new File(name));
	    while(fi.hasNext()){
		String tmp = fi.nextLine();
		str += tmp;
		if(Y == 0){
		    X = tmp.length();}
		Y++;
	    }}
	catch(Exception e){
	    System.out.println("All These Wicked Errors, Yo! :C ");
	    System.exit(-1);
	}
	map = new char[Y][X];
	for(int x = 0; x < str.length(); x++){
	    char TMP = str.charAt(x);
	    System.out.println(""+ (x%X) + " " + (x/Y));
	    map[x / X][x % X] = TMP;
	}
	printmode = false;
	solution = new int[1];
	Stack<coord> tmp = new Stack<coord>();
	exitnode = find('E');
	tmp.push(find('S'));
	tmp.push(find('S'));
	deck = new ArrayDeque<Stack<coord>>();
	PQ = new myPQ<Stack<coord>>();
	deck.addLast(tmp);
	deck.addLast(tmp);
	PQ.add(tmp, 9999*9999 - tmp.peek().getd());
}

    
    public static void main(String[]args){
	Maze y = new Maze("map.txt");
	y.solveDFS();
	System.out.println(y);
	int[] c = y.solutionCoordinates();
	String str = "";
	str = "";
	for(int f = 0; f < c.length; f++){
	    str+= c[f] + ",";
	}
	System.out.println(str);
    }
    

    public coord find(char a){
	coord tmp = new coord(0,0);
	for(int x = 0; x < map.length; x++){
	    for(int y = 0; y < map[0].length; y++){
		if(map[x][y] == a){
		    tmp.setx(x);
		    tmp.sety(y);
		}
	    }
	}
	return tmp;
    }

    public boolean solveBest(boolean x){
    	printmode = x;
    	return runMode(2);}

    public boolean solveBest(){
    	return solveBest(false);
    }

    
    public boolean solveBFS(boolean x){
    	printmode = x;
    	return runMode(0);}
    	
    public boolean solveBFS(){
 	return solveBFS(false);
    }
    
    public boolean solveDFS(boolean x){
    	printmode = x;
    	return runMode(1);}
    	
    public boolean solveDFS(){
	 return solveDFS(false);
    }
    
    public boolean solveAstar(){
	return solveAstar(false);
    }

    public boolean solveAstar(boolean x){
	printmode = x;
	return runMode(3);}

    public boolean check(coord a, coord b){
	boolean x =  a.getx() < map.length && a.getx() > -1 && a.gety() < map[0].length &&  a.gety() > -1 && map[a.getx()][a.gety()] != '#' && (a.getx() != b.getx() || a.gety() != b.gety());
	return x;
    }

    public boolean solution(coord a){
	return map[a.getx()][a.gety()] == 'E';
    }


    public String toString(){
	String str = "";
	for(int x = 0; x < map.length; x++){
	    for(int y = 0; y < map[0].length; y++){
		str += map[x][y] + " ";}
	    str += "\n";}
	return str;}

    public void printify(coord tmpz){
	if(printmode){
	    char printtm = map[tmpz.getx()][tmpz.gety()];
	    try {
		Thread.sleep(65);
	    }catch(InterruptedException ex) {
		Thread.currentThread().interrupt();}
	    map[tmpz.getx()][tmpz.gety()] = 'x';
	    System.out.println(clear + go(0,0) + show + this);
	    map[tmpz.getx()][tmpz.gety()] = printtm;
	}}
	
	public String toString(boolean x){
    	for(char[] a: map){
    		for(char b: a){
    			if(b == 'x'){
    				b = ' ';
    			}
    		}
    	}
    	solved = false;
    	solveBFS(true);
    	return toString();
    }
    
    public int[] solutionCoordinates(){
    	return solution;}
    
    public String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");}
    
    }
