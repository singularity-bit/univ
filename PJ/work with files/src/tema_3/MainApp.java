package tema_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {



	public static void main(String[] args) throws IOException {
		File file=new File("cantec_in.txt");
		
		int rand=0;
		float gen;
		ArrayList< Vers> empList=new ArrayList<Vers>();
		Scanner sc=new Scanner(file);
		FileWriter  fileWriter=new FileWriter("cantec_out.txt");
		PrintWriter printWriter=new PrintWriter(fileWriter);
		while(sc.hasNextLine()) {
			Vers cuvinte=null;
			int nrCuvinte;
			String oldVers="";
			
			empList.add(new Vers(sc.nextLine()));
			gen=(float) Math.random();
			cuvinte=empList.get(rand);
			nrCuvinte=cuvinte.nrCuvinte();
			
			//empList.toString();
			oldVers=cuvinte.toString();
			if(gen<0.1) {
				printWriter.write(cuvinte.toString().toUpperCase()+"\t\t---|---- numarul de cuvinte "+nrCuvinte+"------|"+gen);
			}else {
				printWriter.write(cuvinte.toString()+"\t\t---|---- numarul de cuvinte "+nrCuvinte+"------|"+gen);
			}
			
			if(oldVers.endsWith("(oh)")) {
				printWriter.write("\t(*)");
			}
			
			rand++;
			
			
		}
		fileWriter.close();
		sc.close();
		//System.out.println("\n"+empList);
		System.out.println(rand);
		//System.out.println("numarul de cuvinte "+);
		System.out.println("\n numarul de vocale din vers ");
	}

}


