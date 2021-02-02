package tema1;

import java.util.Random;

public class ex_5 {
	static boolean patratPerfect(int x) {
		int p=(int) Math.sqrt(x);
		return  (p*p==x);
	}
	static boolean isFibonacci(int n) {
		return patratPerfect(5*n*n+4) || patratPerfect(5*n*n-4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		int x=rand.nextInt(21);
		System.out.print(isFibonacci(x)? x+" este nr fib": x+" nu este");
		
	}

}
