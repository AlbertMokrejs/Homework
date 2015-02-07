public class Recursion implements hw1{
    public String name(){
	return "Mokrejs,Albert";}

    public int fact(int a){
	if(a < 1){
	    return 0;}
	if(a == 1){
	    return a;}
	return a * fact(a - 1);}

    public int fib(int a){
	if(a < 0){
	    return 0;}
	return fibi(0,1,a);}

    public int fibi(int a, int b, int c){
	if(c == 0){
	    return a;}
	return fibi(b, a+b, c-1);}

    public double sqrt(double n){
	if(c < 0){
	    return 0;}
	return sqr(n, (n / (n/2) + (n/2)) / 2);}

    public double sqr(double n, double g){
	if((g*g > 0.9999*n) && (g*g < 1.0001*n)){
	    return g;}
	return sqr(n, (n / g + g)/2);}

}

    
