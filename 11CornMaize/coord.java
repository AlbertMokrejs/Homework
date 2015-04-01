public class coord{

int x;
int y;

public  coord(int a, int b){
  x = a;
  y = b;}

    public coord(coord a){
	x = a.getx();
	y = a.gety();}
  
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
