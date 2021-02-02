package ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ex_3 {

	public static void main(String[] args) throws IOException {
		File file =new File("judete_in.txt");
		int rand=0;
		String jdt;
		Scanner sc=new Scanner(new FileInputStream(file),"UTF-8");
		Scanner judet=new Scanner(System.in);
		ArrayList<String> list=new ArrayList<String>();
		
		FileWriter fileWriter=new FileWriter("judete_out.txt");
		PrintWriter printWriter=new PrintWriter(fileWriter);
		//String line;
		
		while(sc.hasNextLine()) {
			
			Iterator<String> iter=list.iterator();
			int index=list.size()-1;
			list.add( sc.nextLine());
			Collections.sort(list);
			
			//orase=list.get(rand);
			
			rand++;
		}
		for(int i=0;i<list.size();i++) {
			printWriter.write(list.get(i)+"\n");
		}
		fileWriter.close();
		System.out.println("\nJudetul cautat: ");
		jdt=judet.nextLine();
		if(list.toString().contains(jdt)) {
			System.out.println("\njudetul se afla la indexul: "+(Collections.binarySearch(list, jdt)+1));
		}else {
			System.out.println("\nnu exista");
		}
		
		
		sc.close();
		//System.out.println(list);
	}

}
