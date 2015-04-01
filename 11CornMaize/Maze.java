import java.util.*;

public class Maze{

    ArrayDeque<Stack<coord>> deck;
    char[][] map;
    boolean solved;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    boolean printmode;
    
    public String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");}

    public static void main(String[]args){
	char[][] a = new char[5][5];
	a[0] = new char[]{'X','X','X','X','X'};
	a[1] = new char[]{'X','S','X',' ','X'};
	a[2] = new char[]{'X',' ',' ',' ','X'};
	a[3] = new char[]{'X',' ','X','E','X'};
	a[4] = new char[]{'X','X','X','X','X'};
	Maze x = new Maze(a);
	System.out.println(x);
	x.run();
	System.out.println(x);
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

    public Maze(char[][] x){
	printmode = true;
	Stack<coord> tmp = new Stack<coord>();
	map = x;
	tmp.push(find('S'));
	tmp.push(find('S'));
	System.out.println(tmp);
	deck = new ArrayDeque<Stack<coord>>();
	deck.addLast(tmp);
    }

    public boolean check(coord a, coord b){
	boolean x =  a.getx() < map.length && a.getx() > -1 && a.gety() < map[0].length &&  a.gety() > -1 && map[a.getx()][a.gety()] != 'X' && (a.getx() != b.getx() || a.gety() != b.gety());
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
  
    public boolean solution(coord a){
	
	return map[a.getx()][a.gety()] == 'E';
    }

    public void run(){
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
	while(!tmp.empty()){
	    tmpb = tmp.pop();
	    map[tmpb.getx()][tmpb.gety()] = 'O';
	}
	System.out.println(this);
    }

    public String toString(){
	String str = "";
	for(int x = 0; x < map.length; x++){
	    for(int y = 0; y < map[0].length; y++){
		str += map[x][y] + " ";
	    }
	    str += "\n";
	}
	return str;}

    public void printify(coord tmpz){
	if(printmode){
	    char printtm = map[tmpz.getx()][tmpz.gety()];
	    try {
		Thread.sleep(250);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    map[tmpz.getx()][tmpz.gety()] = '?';
	    System.out.println(clear + go(0,0) + show + this);
	    map[tmpz.getx()][tmpz.gety()] = printtm;
	}
    }
    
    }
