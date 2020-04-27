package tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class exercitiul_2 {
	
	public static int mediaAritmetica() {
		return 0;
	}
	public static int valMin() {
		return 0;
	}
	public static int valMax() {
		return 0;
	}
	public static void main(String[] args) throws Exception {
		File file= new File("in.txt");
		Scanner sc=new Scanner(file);
		BufferedWriter writer=new BufferedWriter(new FileWriter("out.txt"));
		int val=0;
		int i=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		while(sc.hasNextLine()) {
			
			String line=sc.nextLine();
			//System.out.println(line);
			
			int x=Integer.parseInt(line);
			
			val=x+val;//suma
			 min=Math.min(min, x);
			 max=Math.max(max, x);
			 i++;
		}
		sc.close();
		System.out.println(val);
		System.out.println( (float) val/i);
		
		System.out.println(min);
		System.out.println(max);
		writer.write("suma cifrelor este:"+val);
		writer.write("\nmedia aritmetica: "+(float) val/i);
		writer.write("\nvaloarea minima :"+min);
		writer.write("\nvaloarea maxima :"+max);
		writer.close();
	}
}
