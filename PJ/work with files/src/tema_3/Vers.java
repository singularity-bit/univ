package tema_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vers {
	public  String vers;
	public  int nrCuvinte;
	public String getVers() {
		return vers;
	}
	public int getNrCuvinte() {
		return nrCuvinte;
	}
	public void setVers(String vers) {
		this.vers=vers;
	}
	public void setNr(int nr) {
		this.nrCuvinte=nr;
	}
	Vers(String string) {
		super();
		this.vers = string;
	}

	  public  int nrCuvinte() {
		  String[] nr=vers.split(" ");
		nrCuvinte = nr.length;
		return nrCuvinte;
	}
	 public int nrVocale() {
		
		int i,contor=0;
		//String versLowerCase=vers.toLowerCase();
		for(char current:vers.toString().toCharArray()) {
			
			if(     current=='a'|| 
					current=='e'||
					current=='i'||
					current=='o'||
					current=='u'||
					current=='y' )
				contor++;
		}
		return contor;
	}
	 @Override
	public String toString() {
		return "\n "+vers.toString();
		
	}

}
