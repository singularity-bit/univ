package tema1;

import java.util.Random;
import java.util.Scanner;

public class exercitiul_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		int x=rand.nextInt(31);
		int y=rand.nextInt(31);
		int i,z;
		System.out.println("x= "+x);
		System.out.println("y= "+y);
		z=Math.min(x, y);
		for(i=z;i>1;i--) {
			if(x%i==0) {
				if(y%i==0) {
					System.out.println(" "+i+" este cmmd al lui "+y+" "+x);
					break;
				}
			}
		}
		
		
	}

}
