package tema4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class MainApp {

	static void scrie(Object o,String fis) {
		try {
			FileOutputStream f= new FileOutputStream(fis);
			ObjectOutputStream oos=new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
     @SuppressWarnings("unchecked")
	static  void citeste(String file) {
    	 ArrayList<Echipamente> ech=null;
    	 try {
    		 	FileInputStream fis=new FileInputStream(file);
				ObjectInputStream in=new ObjectInputStream(fis);
				ech=(ArrayList<Echipamente>) in.readObject();
				//echipamenteDeserializate=echipam;
				in.close();
				fis.close();
				
			}
			catch(IOException e) {
				e.printStackTrace();
				return;
			}
    	 catch(ClassNotFoundException c) {
    		 System.out.println("Class not found");
    		 c.printStackTrace();
    		 return;
    	 }
			System.out.println("s-a sfarsit deserializarea..");
			for(Echipamente e:ech) {
				System.out.println(e.toString());
			}
	}
	@SuppressWarnings("unchecked")
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("echipamente.txt");
		Scanner sc=new Scanner(file);
		Scanner sc2=new Scanner(System.in);
		int opt;
		int nrProdus;
		String stare;
		
		//ArrayList<Imprimante> imprimanta=new ArrayList<Imprimante>();
		ArrayList<Echipamente> echipamente=new ArrayList<Echipamente>();
		//ArrayList<Echipamente> echipamenteDeserializate=new ArrayList<>();
		while(sc.hasNextLine()) {
			String data[]=sc.nextLine().split(";");
			switch(data[5]) {
			case "imprimanta": 
				Echipamente ech=new Imprimante(data);
				echipamente.add(ech);
			break;
			case "copiator":
				Echipamente cop=new Copiatoare(data);
				echipamente.add(cop);
				break;
			case "sistem de calcul":
				Echipamente sis=new SistemeDeCalcul(data);
				echipamente.add(sis);
				break;
				
			}
		}
		sc.close();
		
		do {
			System.out.println("1 Afişarea imprimantelor");
			System.out.println("2 Afişarea copiatoarelor");
			System.out.println("3 Afişarea sistemelor de calcul");
			System.out.println("4 Modificarea stării în care se află un echipament");
			System.out.println("5 Setarea unui anumit mod de scriere pentru o imprimantă");
			System.out.println("6 Setarea unui format de copiere pentru copiatoare");
			System.out.println("7 Instalarea unui anumit sistem de operare pe un sistem de calcul");
			System.out.println("8 Afişarea echipamentelor vândute");
			System.out.println("9 Să se realizeze două metode statice pentru serializarea / deserializarea colecției de obiecte în fișierul echip.bin");
			System.out.println("\nalege ceva: ");
			opt=sc2.nextInt();
			switch(opt) {
			case 1:
				for(int i=0;i<echipamente.size();i++) {
					if(echipamente.get(i).getNume().compareToIgnoreCase("imprimanta")==0) {
						System.out.println(echipamente.get(i));
					}
			}
				break;
			case 2:
				for(int i=0;i<echipamente.size();i++) {
					if(echipamente.get(i).getNume().compareToIgnoreCase("copiator")==0) {
						System.out.println(echipamente.get(i));
					}
			}
				break;
			case 3:
				for(int i=0;i<echipamente.size();i++) {
					if(echipamente.get(i).getNume().compareToIgnoreCase("sistem de calcul")==0) {
						System.out.println(echipamente.get(i));
					}
			}
				break;
			case 4:
				System.out.println("care echipament?: ");
				nrProdus=sc2.nextInt();
				System.out.println("ce stare?: ");
				stare=sc2.next();
				echipamente.get(nrProdus).setStare(stare);
				System.out.println(echipamente.get(nrProdus));
				break;
			case 5: 
			System.out.println("care imprimanta? :");
			nrProdus=sc2.nextInt();
			System.out.println("ce stare?: ");
			stare=sc2.next();
			Imprimante imp=(Imprimante) echipamente.get(nrProdus);
			imp.setMod_scriere(stare);
			break;
			case 6: 
				System.out.println("care copiator? :");
				nrProdus=sc2.nextInt();
				System.out.println("ce stare?: ");
				stare=sc2.next();
				Copiatoare copi=(Copiatoare) echipamente.get(nrProdus);
				copi.setFormat(stare);
				break;
			case 7: 
				System.out.println("care sistem? :");
				nrProdus=sc2.nextInt();
				System.out.println("ce sistem de operare?: ");
				stare=sc2.next();
				SistemeDeCalcul sis=(SistemeDeCalcul) echipamente.get(nrProdus);
				sis.setSis_operare(stare);
				break;
			case 8:
				for(int i=0;i<echipamente.size();i++) {
					if(echipamente.get(i).getStare().equalsIgnoreCase("vandut")) {
						System.out.println(echipamente.get(i));
					}
				}
				break;
				
			
			case 9:
				System.out.println("serializare/deserializare (1/2)");
				nrProdus=sc2.nextInt();
				if(nrProdus==1) {
					System.out.println("se serializeaza...");
					scrie(echipamente.toString(),"pers.bin");
					
					System.out.println("sfarsit!");
				}else {
					System.out.println("se deserializeaza..");
					citeste("pers.bin");
					
					
				}
				
				break;
			}
		}while(opt!=0);
		
		//System.out.println(echipamente);
	}

}
