import java.util.*;

public class Maze{

ArrayDeque<Stack<coord>> deck;
char[][] map;
boolean solved;

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
  Stack<coord> tmp = new Stack<coord>();
  map = x;
  tmp.push(find('S'));
  tmp.push(find('S'));
  deck = new ArrayDeque<Stack<coord>>();
  deck.addLast(tmp);
}

public boolean check(coord a, coord b){
    return a.getx() < map.length && a.getx() > -1 && a.gety() < map[0].length &&  a.gety() > -1 && map[a.getx()][a.gety()] != 'X' && ( a.getx() != b.getx() || a.gety() != b.gety() );
}

public void next(){
  Stack<coord> a = deck.removeFirst();
  coord tmbz = a.peek();
  coord tmby = a.peek();
  coord tmpx = a.peek();
  coord typw = a.peek();
  coord tmpa = a.pop();
  coord tmpb = a.peek();
  a.push(tmpa);
  tmpz.setx(tmpz.getx()+1);
  if(check(tmpz,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpz);
    deck.addLast(tmps);
  }
  tmpy.setx(tmpy.getx()-1);
  if(check(tmpy,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpy);
    deck.addLast(tmps);
  }
  tmpx.sety(tmpx.gety()+1);
  if(check(tmpx,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpx);
    deck.addLast(tmps);
  }
  tmpw.sety(tmpw.gety()-1);
  if(check(tmpw,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpw);
    deck.addLast(tmps);
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
    
}
