package ex2;

import java.util.Scanner;

public class Ex2 {

	/*public static String insertString(String original,String stringInserted,int index) {
		String newString=new String();
		for (int i=0;i<original.length();i++) {
			newString+=original.charAt(i);
			if(i==index) {
				newString+=stringInserted;
			}
		}
		return newString;
	}*/
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		StringBuilder st1=new StringBuilder("Să într-o anumită poziție a unui șir de caractere, un alt șir.");
		String st2;
		String st3;
		int indexRemove;
		System.out.println(st1);
		int index;
		System.out.println("Introduceti un sir: ");
		Scanner sc=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		st2=sc.nextLine();
		
		System.out.print("la ce index doriti sa-l introduceti?: ");
		index=sc.nextInt();
		System.out.print("noul sir este: "+st1.insert(index, st2));
		System.out.print("\nDe unde doriti sa stergeti?:");
		indexRemove=sc.nextInt();
		System.out.print("\nce cuvant doriti sa stergeti? : ");
		st3=sc2.nextLine();
		if(st1.toString().contains(st3)){
			st1.delete(indexRemove, (indexRemove+st3.length()));
			System.out.print(st1);
		}else {
			System.out.print("\nnu exista");
		}
		
		
		
		
	
	}

}
