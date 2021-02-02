package tema5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import tema5.Ex2.TratareExceptie;

public class Ex2 {
	static class  TratareExceptie extends Exception {
		private int primul;
		private int second;

		public TratareExceptie(int prim, int sec) {
			primul = prim;
			second = sec;
		}

		public String toString() {
			return " " + primul + "este mai mare decat " + second;
		}
	}

	
		public static Boolean check(int prim, int sec, String filename) throws TratareExceptie, IOException {
			FileWriter file = new FileWriter(filename);
			PrintWriter print = new PrintWriter(file);
			if (prim < sec) {
				print.write(prim + " " + sec);
				file.close();
				return true;
			} else {
				throw new TratareExceptie(prim, sec);
			}
		}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			boolean gata=false;
			int prim,sec;
			
			Scanner sc=new Scanner(System.in);
			do {
				try {
					System.out.println("Primul numar: ");
					prim=sc.nextInt();
					System.out.println("al doilea: ");
					sec=sc.nextInt();
					gata=check(prim,sec,"verifica.txt");
				}catch(TratareExceptie tr) {
					System.out.println("tratare exceptie..");
				}
			}while(!gata);
		}
	
	

}
