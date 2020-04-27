package tema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exercitiul_1 {
	public static int arie(int x,int y) {
		return x*y;
	}
	public static int perimetru(int x,int y) {
		return (x+y)*2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("introduceti lungimea: ");
		int x=scanner.nextInt();
		System.out.println("introduceti latimea: ");
		int y=scanner.nextInt();
		System.out.println("aria este : "+arie(x,y));
		System.out.println("perimetrul este : "+perimetru(x,y));
		
		
		
	}

}
