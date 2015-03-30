public class mazesolver{

deque<stack<coord>> deck;
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
  stack<coord> tmp = new stack<coord>();
  map = x;
  tmp.push(find('S'));
  deck = new deque<stack<coord>>();
  deck.addLast(tmp);
}

public boolean check(coord a, coord b){
  return map[a.getx()][a.gety()] != 'X' && ( a.getx() != b.getx() || a.gety() != b.gety() );
}

public void next(){
  stack<coord> a = deck.removeFirst();
  coord tmpb = a.pop();
  coord tmpa = a.peek();
  tmpa.setx(tmpa.getx()+1);
  if(check(tmpa,tmpb)){
    
