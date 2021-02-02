package ex1;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ex1.Ex1.Banca;

class Ex1 {
	public interface Operatiuni {
		public float calculeaza_dobanda();

		public float actualizare_suma();

		public void depunere(float suma);

		public void extrage(float suma);
	}

	public class ContBancar  implements Operatiuni {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		private String numarCont;
		private float suma;
		private String moneda;
		Calendar data_deschiderii;
		Calendar data_ultimei_operatiuni;
		Calendar currentTime;

		
		
		public ContBancar(String numarCont, float suma, String moneda, Calendar data_deschiderii,
				Calendar data_ultimei_operatiuni) {
			super();
			this.numarCont = numarCont;
			this.suma = suma;
			this.moneda = moneda;
			this.data_deschiderii = data_deschiderii;
			this.data_ultimei_operatiuni = data_ultimei_operatiuni;
		}

		public float getSuma() {
			return suma;
		}

		public void setSuma(float suma) {
			this.suma = suma;
		}
		public String getNumarCont() {
			return numarCont;
		}
		public void setNumarCont(String numarCont) {
			this.numarCont=numarCont;
		}
		

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public int diferentaZile(Calendar startDate,Calendar endDate) {
			int daysBetween = (int) ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
			return daysBetween;
		}
		public float calculeaza_dobanda() {
			// TODO Auto-generated method stub
			//int nrZile;
			float dobanda = 0;
			
			if (moneda.equalsIgnoreCase("RON")) {
				if (suma < 500) {
					dobanda = (float) (0.3 * diferentaZile(data_ultimei_operatiuni,Calendar.getInstance()));
				} else {
					dobanda = (float) (0.8 * diferentaZile(data_ultimei_operatiuni,Calendar.getInstance()));
				}
			} else {
				dobanda = (float) (0.1 * diferentaZile(data_ultimei_operatiuni,Calendar.getInstance()));
			}

			return dobanda;
		}

		@Override
		public float actualizare_suma() {
			// TODO Auto-generated method stub
			this.suma=this.suma+calculeaza_dobanda();
			this.data_ultimei_operatiuni=Calendar.getInstance();
			return this.suma;
		}


		public void depunere(float suma) {
			actualizare_suma();
			
			this.suma =this.suma+ suma;
			
		}

	
		public void extrage(float suma) {
			// TODO Auto-generated method stub
			actualizare_suma();
			this.suma =this.suma- suma;
			
		}
		

		@Override
		public String toString() {
			return "\nContBancar |||---->numarCont=" + numarCont + ", suma=" + suma + ", moneda=" + moneda
					+ ", data_deschiderii=" + data_deschiderii.getTime() + ", data_ultimei_operatiuni=" + data_ultimei_operatiuni.getTime();
		}

		
	}

	public class Client extends ContBancar {
		private String nume;
		private String adresa;
		
		public Client(String numarCont, float suma, String moneda, Calendar data_deschiderii,
				Calendar data_ultimei_operatiuni, String nume, String adresa) {
			super(numarCont, suma, moneda, data_deschiderii, data_ultimei_operatiuni);
			this.nume = nume;
			this.adresa = adresa;
		}

		@Override
		public String toString() {
			return "\nClient  |||--->nume=" + nume + ", adresa=" + adresa + ",\n" + super.toString();
		}
		

		
	}
	public class Banca extends Client {
		private String denumire_banca;
		int contor;

		

		public Banca(int contor,String numarCont, float suma, String moneda, Calendar data_deschiderii,
				Calendar data_ultimei_operatiuni, String nume, String adresa, String denumire_banca) {
			super(numarCont, suma, moneda, data_deschiderii, data_ultimei_operatiuni, nume, adresa);
			this.denumire_banca = denumire_banca;
			this.contor=contor;
		}



		@Override
		public String toString() {
			return "-------------------------\n"+""+contor+". "+"Banca |||---> denumire_banca=" + denumire_banca + ",\n" + super.toString();
		}
		
		
	
		
	}
    
	public ArrayList<Banca> adauga(int contor){
		String denBanca,nume,adresa,moneda;
		String numarCont;
		float suma;
		Scanner numere=new Scanner(System.in);
		Scanner cuvinte=new Scanner(System.in);
		ArrayList<Banca> banca=new ArrayList<Banca>();
		 
			
		
		System.out.println("----------------------");
		System.out.println("Denumire banca: ");
		denBanca=cuvinte.nextLine();
		System.out.println("-------------------");
		System.out.println("Client..");
		System.out.println("Nume: ");
		nume=cuvinte.nextLine();
		System.out.println("Adresa: ");
		adresa=cuvinte.nextLine();
		System.out.println("-------------------");
		System.out.println("Cont...");
		System.out.println("Numar cont: ");
		numarCont=numere.nextLine();
		System.out.println("Suma: ");
		suma=numere.nextFloat();
		System.out.println("Moneda: ");
		moneda=cuvinte.nextLine();
		System.out.println("data deschiderii contului se actualizeaza..");
		Calendar dataCalendar=Calendar.getInstance();
		Calendar dataDeschiderii=new GregorianCalendar(2019,Calendar.JANUARY,19); 
		System.out.println("-------------------");
		banca.add(new Banca(contor,numarCont, suma, moneda, dataDeschiderii, dataCalendar, nume, adresa, denBanca));
		System.out.println("datele au fost adaugate cu succes!");
		
		return banca;
	}
	
}



