import java.util.*;

public class coord{

int x;
int y;
int d;

public coord(int a, int b){
  x = a;
  y = b;
  d = 0;
}

public coord(coord a){
	x = a.getx();
	y = a.gety();
	d = a.getd();
}

public int dist(coord a){
	int b = 0;
	b+= Math.abs(a.getx() - x);
	b+= Math.abs(a.gety() - y);
	return b;
}
  
public int getd(){
 return d;
}

public void setd(int a){
 d = a;
}

public void incd(){
 d++;
}
  
public int getx(){
  return x;}
  
public int gety(){
  return y;}

public void setx(int a){
  x = a;}
  
public void sety(int a){
  y = a;}
  

public void setxy(int a, int b){
  sety(b);
  setx(a);
}

    public String toString(){
	return "" + getx() +"," + gety();}

}
