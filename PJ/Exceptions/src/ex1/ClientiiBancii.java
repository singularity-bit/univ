package ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import ex1.Ex1.Banca;

public class ClientiiBancii extends Ex1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt;
		
		String numarCont,contDest;
		float suma;
		Ex1 ex1=new ClientiiBancii();
		Scanner sc=new Scanner(System.in);
		int contor=1;
	
		ArrayList<Banca> contNou=new ArrayList<Banca>();
		ArrayList<Banca> contTemp=new ArrayList<Banca>();
		
		do {
			System.out.println("1. Adãugare bãnci, clienþi, conturi\r\n" + 
					"2. Afiºare date introduse\r\n" + 
					"3. Depunerea unei sume într-un cont\r\n" + 
					"4. Extragerea unei sume dintr-un cont\r\n" + 
					"5. Transfer de bani între douã conturi");
			opt=sc.nextInt();
			switch(opt) {
			
			case 0: return; 
			
			case 1: {
				
				contTemp=ex1.adauga(contor++);
				contNou.addAll(contTemp);
				
				break;
			}
			case 2:
				for(int i=0;i<contNou.size();i++) {
					System.out.println(contNou.get(i));
				}
				break;
			case 3:
				System.out.println("introduceti codul contului: ");
				numarCont=sc.next();
				for(int i=0;i<contNou.size();i++) {
					
					if(contNou.get(i).getNumarCont().equalsIgnoreCase(numarCont)==true) {
						System.out.println("introduceti suma dorita: ");
						suma=sc.nextFloat();
						contNou.get(i).depunere(suma);
						
					}else {
						System.out.println("acest cont nu exista!");
					}
					
				}
				break;
			case 4:
				System.out.println("introduceti codul contului: ");
				numarCont=sc.next();
				for(int i=0;i<contNou.size();i++) {
					if(contNou.get(i).getNumarCont().equalsIgnoreCase(numarCont)==true) {
						System.out.println("introduceti suma dorita: ");
						suma=sc.nextFloat();
						contNou.get(i).extrage(suma);
					}
				}
				break;
			case 5:
				System.out.println("introduceti codul contului sursa: ");
				numarCont=sc.next();
				
				for(int i=0;i<contNou.size();i++) {
					if(contNou.get(i).getNumarCont().equalsIgnoreCase(numarCont)==true) {
						System.out.println("introduceti codul contului destinatie: ");
						contDest=sc.next();
						for(int j=0;j<contNou.size();j++) {
							if(contNou.get(j).getNumarCont().equalsIgnoreCase(contDest)==true) {
								System.out.println("introduceti suma dorita: ");
								suma=sc.nextFloat();
								contNou.get(j).depunere(suma);
								contNou.get(i).extrage(suma);
							}
							
						}
					}
				}
				
				
				
				
			}
		}while(opt!=0);
	}

}
