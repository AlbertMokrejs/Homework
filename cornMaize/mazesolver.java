public class mazesolver{

deque<Stack<coord>> deck;
char[][] map;
boolean solved;

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

public mazesolver(char[][] x){
  Stack<coord> tmp = new Stack<coord>();
  map = x;
  tmp.push(find('S'));
  deck = new deque<Stack<coord>>();
  deck.addLast(tmp);
}

public boolean check(coord a, coord b){
  return map[a.getx()][a.gety()] != 'X' && ( a.getx() != b.getx() || a.gety() != b.gety() );
}

public void next(){
  Stack<coord> a = deck.removeFirst();
  coord tmpb = a.pop();
  coord tmpa = a.peek();
  tmpa.setx(tmpa.getx()+1);
  if(check(tmpa,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpa);
    deck.addLast(tmps);
  }
  tmpa.setx(tmpa.getx()-2);
  if(check(tmpa,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpa);
    deck.addLast(tmps);
  }
  tmpa.setx(tmpa.getx()+1);
  tmpa.sety(tmpa.gety()+1);
  if(check(tmpa,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpa);
    deck.addLast(tmps);
  }
  tmpa.sety(tmpa.gety()-2);
  if(check(tmpa,tmpb)){
    Stack<coord> tmps = (Stack<coord>)a.clone();
    tmps.push(tmpa);
    deck.addLast(tmps);
  }
}
    
