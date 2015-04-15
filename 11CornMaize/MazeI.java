import java.util.*;
import java.io.*;

public class Maze{

    ArrayDeque<Stack<coord>> deck;
    char[][] map;
    boolean solved;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    boolean printmode;
    int[] solution;
    
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
	
public Maze(String name){
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
	tmp.push(find('S'));
	tmp.push(find('S'));
	deck = new ArrayDeque<Stack<coord>>();
	deck.addLast(tmp);
}

    public static void main(String[]args){
	Maze x = new Maze("map.txt");
	Maze y = new Maze("map.txt");
	x.solveBFS(true);
	System.out.println(x);
	y.solveDFS(true);
	System.out.println(y);
	int[] d = x.solutionCoordinates();
	int[] c = y.solutionCoordinates();
	String str = "";
	for(int e = 0; e < d.length; e++){
	    str+= d[e] + ",";
	}
	System.out.println(str);
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

    
    public boolean solveBFS(boolean x){
    	printmode = x;
    	return run();}
    	
    public boolean solveBFS(){
 	return solveBFS(false);
    }
    
    public boolean solveDFS(boolean x){
    	printmode = x;
    	return DFSrun();}
    	
    public boolean solveDFS(){
	 return solveDFS(false);
    }

    public boolean check(coord a, coord b){
	boolean x =  a.getx() < map.length && a.getx() > -1 && a.gety() < map[0].length &&  a.gety() > -1 && map[a.getx()][a.gety()] != '#' && (a.getx() != b.getx() || a.gety() != b.gety());
	return x;
    }

    public void next(){
	Stack<coord> a = deck.removeFirst();
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
	    deck.addLast(tmpsa);
	}
	tmpy.setx(tmpy.getx()-1);
	if(check(tmpy,tmpb)){
	    printify(tmpy);
	    Stack<coord> tmpsb = (Stack<coord>)a.clone();
	    tmpsb.push(tmpy);
	    deck.addLast(tmpsb);
	}
	tmpx.sety(tmpx.gety()+1);
	if(check(tmpx,tmpb)){
	    printify(tmpx);
	    Stack<coord> tmpsc = (Stack<coord>)a.clone();
	    tmpsc.push(tmpx);
	    deck.addLast(tmpsc);
	}
	tmpw.sety(tmpw.gety()-1);
	if(check(tmpw,tmpb)){
	    printify(tmpw);
	    Stack<coord> tmpsd = (Stack<coord>)a.clone();
	    tmpsd.push(tmpw);
	    deck.addLast(tmpsd);
	}
    }
    
    public void DFSnext(){
	Stack<coord> a = deck.removeFirst();
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
	    deck.addFirst(tmpsa);
	}
	tmpy.setx(tmpy.getx()-1);
	if(check(tmpy,tmpb)){
	    printify(tmpy);
	    Stack<coord> tmpsb = (Stack<coord>)a.clone();
	    tmpsb.push(tmpy);
	    deck.addFirst(tmpsb);
	}
	tmpx.sety(tmpx.gety()+1);
	if(check(tmpx,tmpb)){
	    printify(tmpx);
	    Stack<coord> tmpsc = (Stack<coord>)a.clone();
	    tmpsc.push(tmpx);
	    deck.addFirst(tmpsc);
	}
	tmpw.sety(tmpw.gety()-1);
	if(check(tmpw,tmpb)){
	    printify(tmpw);
	    Stack<coord> tmpsd = (Stack<coord>)a.clone();
	    tmpsd.push(tmpw);
	    deck.addFirst(tmpsd);
	}
    }
  
    public boolean solution(coord a){
	return map[a.getx()][a.gety()] == 'E';
    }

    public boolean run(){
	Stack<coord> tmp = new Stack<coord>();
	while(!solved){
	    tmp = deck.removeFirst();
	    deck.addFirst(tmp);
	    solved = solution(tmp.peek());
	    if(!solved){
		next();
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
    
    public boolean DFSrun(){
	Stack<coord> tmp = new Stack<coord>();
	while(!solved){
	    tmp = deck.removeFirst();
	    deck.addFirst(tmp);
	    solved = solution(tmp.peek());
	    if(!solved){
		DFSnext();
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
		Thread.sleep(40);
	    }catch(InterruptedException ex) {
		Thread.currentThread().interrupt();}
	    map[tmpz.getx()][tmpz.gety()] = 'x';
	    System.out.println(clear + go(0,0) + show + this);
	    map[tmpz.getx()][tmpz.gety()] = printtm;
	}}
    
    }
