public class coord{

int x;
int y;

public coord(int a, int b){
  x = a;
  y = b;}
  
public getx(){
  return x;}
  
public gety(){
  return y;}

public setx(int a){
  x = a;}
  
public sety(int a){
  y = a;}
  

public setxy(int a, int b){
  sety(b);
  setx(a);
}

}
