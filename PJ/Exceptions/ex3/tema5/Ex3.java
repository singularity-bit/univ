package tema5;

import java.util.Scanner;

public class Ex3 {
 static class TratareExcDivzZero extends Exception{
	 private String impartitor;
	 private String deimpartit;
	 public TratareExcDivzZero(String impartit,String deim) {
		// TODO Auto-generated constructor stub
		 impartitor=impartit;
		 deimpartit=deim;
	}
	 public String toString() {
		 return "deimpartitul nu poate fi 0: "+ deimpartit;
	 }
 }
 static class TratareExcLitere extends Exception{
	 private String impartitor;
	 private String deimpartit;
	 TratareExcLitere(String impartit,String deim){
		 impartitor=impartit;
		 deimpartit=deim;
	 }
	 public String toString() {
		 return "nu pot fi litere: "+ deimpartit+impartitor;
	 }
 }
 public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
 public static boolean isZero(String str) {
	 if(isNumeric(str)&& Integer.parseInt(str)==0) {
		 return true;
	 }
	return false;
	
 }
 public static float impartirea(String impartit,String deim)throws TratareExcDivzZero,TratareExcLitere {
	
	 if(isZero(impartit)==true) {
		 throw new TratareExcDivzZero(impartit, deim);
	 }else if(isNumeric(deim)==false || isNumeric(impartit)==false) {
		 throw new TratareExcLitere(impartit, deim);
	 }else {
		 return Integer.parseInt(deim)/Integer.parseInt(impartit);
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean gata=false;
		String prim;
		String sec;
		float rezultat=0;
		Scanner sc=new Scanner(System.in);
		do {
			try {
				System.out.println("introduceti deimpartitul: ");
				prim=sc.nextLine();
				System.out.println("introduceti impartitorul: ");
				sec=sc.nextLine();
				
				rezultat=impartirea(sec,prim);
				System.out.println(rezultat);
			}catch(TratareExcDivzZero zero) {
				System.out.println("exceptie de aritmetica..");
			}
			catch(TratareExcLitere litere) {
				System.out.println("exceptie cu litere...");
			}
			
		}while(!gata);
	}

}
