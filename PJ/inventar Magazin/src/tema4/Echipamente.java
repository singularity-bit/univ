package tema4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Echipamente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2299123218331023993L;
	private String denumire;
	private int nr_inv;
	private int pret;
	private  String zona_mag;
	private String status;
	private String numeEchipament;
	public Echipamente(String[] s) {
		this.denumire=s[0];
		this.nr_inv=Integer.parseInt(s[1]);
		this.pret=Integer.parseInt(s[2]);
		this.zona_mag=s[3];
		this.status=s[4];
		this.numeEchipament=s[5];
		
		
	}
	public String getNume() {
		return this.numeEchipament;
	}
	public  void setStare(String st) {
		this.status=st;
	}
	public String getStare() {
		return this.status;
	}
private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
	denumire=aInputStream.readUTF();
	nr_inv=aInputStream.readInt();
	pret=aInputStream.readInt();
	zona_mag=aInputStream.readUTF();
	status=aInputStream.readUTF();
}
	@Override
	public String toString() {
		return "\n" +"denumire=" + denumire + ", nr_inv=" + nr_inv + ", pret=" + pret + ", zona_mag=" + zona_mag
				+ ", status=" + status + " ";
	}
	
}
class EchipamenteHartie extends Echipamente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7556301675280613919L;
	private int ppm;

	public EchipamenteHartie(String[] s) {
		// TODO Auto-generated constructor stub
		super(s);
		this.ppm=Integer.parseInt(s[6]);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		
		ppm=aInputStream.readInt();
		
	}

	@Override
	public String toString() {
		return super.toString()+" "+"EchipamenteHartie ppm=" + ppm + " ";
	}
	
	
}
class Imprimante extends EchipamenteHartie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8708965915245855377L;
	private String rezolutie;
	private int p_car;
	public String mod_scriere;

	public Imprimante(String[] s) {
		super(s);
		this.rezolutie=s[7];
		this.p_car=Integer.parseInt(s[8]);
		this.mod_scriere=s[9];
	}

	public String getMod_scriere() {
		return mod_scriere;
	}

	public void setMod_scriere(String mod_scriere) {
		this.mod_scriere = mod_scriere;
	}
private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		rezolutie=aInputStream.readUTF();
		p_car=aInputStream.readInt();
		mod_scriere=aInputStream.readUTF();
		
	}

	@Override
	public String toString() {
		return super.toString()+" "+"Imprimante rezolutie=" + rezolutie + ", p_car=" + p_car + ", mod_scriere=" + mod_scriere + " ";
	}
	
	
}
class Copiatoare extends EchipamenteHartie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7643744274255768338L;
	private int p_ton;
	private String format;
	public Copiatoare(String[] s) {
		super(s);
		this.format=s[8];
		this.p_ton=Integer.parseInt(s[7]);
		
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
	
	p_ton=aInputStream.readInt();
	format=aInputStream.readUTF();
		
	}
	@Override
	public String toString() {
		return super.toString()+" "+"Copiatoare p_ton=" + p_ton + ", format=" + format + " ";
	}
	
	
}
class SistemeDeCalcul extends Echipamente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2866294665591823934L;
	private String  tip_mon;
	private float vit_proc;
	private int c_hdd;
	private String sis_operare;
	public String getSis_operare() {
		return sis_operare;
	}
	public void setSis_operare(String sis_operare) {
		this.sis_operare = sis_operare;
	}
	 public SistemeDeCalcul(String[] s) {
		// TODO Auto-generated constructor stub
		 super(s);
		 this.tip_mon=s[6];
		 this.vit_proc=Float.parseFloat(s[7]);
		 this.c_hdd=Integer.parseInt(s[8]);
		 this.sis_operare=s[9];
	}
	 private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
			tip_mon=aInputStream.readUTF();
			vit_proc=aInputStream.readFloat();
			c_hdd=aInputStream.readInt();
			sis_operare=aInputStream.readUTF();
			
		}

	@Override
	public String toString() {
		return super.toString()+" "+"SistemeDeCalcul tip_mon=" + tip_mon + ", vit_proc=" + vit_proc + ", c_hdd=" + c_hdd + ", sis_operare="
				+ sis_operare + " ";
	}
	
	
}

