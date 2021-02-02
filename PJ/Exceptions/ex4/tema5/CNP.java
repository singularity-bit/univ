package tema5;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CNP {
static class ExceptieLungime extends Exception{
	String cnp;
	public ExceptieLungime(String cod) {
		// TODO Auto-generated constructor stub
		cnp=cod;
	}
	public String toString() {
		return ""+cnp+" are lungimea gresita";
	}
}
static class ExceptieSex extends Exception{
	String cnp;
	public ExceptieSex(String cod) {
		cnp=cod;
	}
	public String toString() {
		return ""+cnp+" sex format gresit";
	}
}
static class ExceptieLuna extends Exception{
	String cnp;
	public ExceptieLuna(String str) {
		cnp=str;
	}
	public String toString() {
		return ""+cnp+" luna gresita!";
	}
}
static class ExceptieZi extends Exception{
	String cnp;
	public ExceptieZi(String data) {
		cnp=data;
	}
	public String toString() {
		return ""+cnp+" zi invalida";
	}
}
static Boolean LungimeOK(String cod) throws ExceptieLungime {
	if(cod.length()!=13) {
		throw new ExceptieLungime(cod);
	}else {
		return true;
	}
}

static boolean check(String s) {
    if (s == null)  {
       return false;
    }
    int len = s.length();
    for (int i = 0; i < len; i++) {
       if ((Character.isLetter(s.charAt(i)) == false)) {
          return false;
       }
    }
    return true;
}
static Boolean SexIsOk(String str)throws ExceptieSex {
	if(str.charAt(0)>=1 || str.charAt(0)<=6) {
		return true;
	}else {
		throw new ExceptieSex(str);
	}
}
static Boolean LunaOk(String str)throws ExceptieLuna {
	if(Integer.parseInt(str.substring(3, 5))>=01 && Integer.parseInt(str.substring(3, 5))<=12) {
		return true;
	}else {
		throw new ExceptieLuna(str);
	}
}
static Boolean ZiuaOk(String str)throws ExceptieZi {
	if(Integer.parseInt(str.substring(5, 7))>=0 && Integer.parseInt(str.substring(5, 7))<=31) {
		return true;
	}else {
		throw new ExceptieZi(str);
	}
}

static Boolean validare(String str)throws ExceptieLungime,ExceptieSex,ExceptieLuna,ExceptieZi,NumberFormatException{
	if(LungimeOK(str)&&check(str)&&SexIsOk(str)&&LunaOk(str)&&ZiuaOk(str)) {
		return true;
	}else {
		return false;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boolean bun=false;
		String cnp = null;
		String nume = null;
		DateTimeFormatter formatter=null;
		String data;
		String anul;
		Scanner sc=new Scanner(System.in);
		do {
			try {
				System.out.println("Numele: ");
				nume=sc.nextLine();
				System.out.println("CNP: ");
				cnp=sc.next();
				
				validare(cnp);
				
			}catch(ExceptieLungime lungime) {
				System.out.println("Exceptie lungime..");
			}
			catch(ExceptieSex sex) {
				System.out.println("exceptie sex..");
			}
			catch(ExceptieLuna luna) {
				System.out.println("exceptie luna..");
			}
			catch(ExceptieZi zi) {
				System.out.println("Exceptie zi..");
			}
			catch(NumberFormatException e) {
				System.out.println("exceptie litere..");
			}
			
			System.out.println("data nasterii :");
			System.out.println("anul: "+cnp.substring(1, 3));
			System.out.println("luna: "+cnp.substring(3, 5));
			System.out.println("ziua: "+cnp.substring(5, 7));
			LocalDate now=LocalDate.now();
			LocalDate l1=null;
			anul=cnp.substring(1, 3)+cnp.substring(3, 5)+cnp.substring(5, 7);
			formatter=DateTimeFormatter.ofPattern("yyMMdd");
			now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
			//LocalDate l1=LocalDate.of(Integer.parseInt(cnp.substring(1, 3)), Integer.parseInt(cnp.substring(3, 5)), Integer.parseInt(cnp.substring(5, 7)));
			l1=LocalDate.parse(anul, formatter);
			Period diff=Period.between(l1, now);
			System.out.println(now);
			System.out.println(l1);
			System.out.println(""+nume+" are "+diff.getYears());
		}while(!bun);
	}

}
