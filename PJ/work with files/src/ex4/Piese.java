package ex4;

// corejava.compare;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import corejava.compare.AgeSorter;

public class Piese {
	private String nume_melodie;
	private String nume_artist;
	private int an_lansare;
	private int numar_vizualizari;

	Piese(String mel, String art, int an, int nr) {
		nume_melodie = mel;
		nume_artist = art;
		an_lansare = an;
		numar_vizualizari = nr;
	}

	public String getMelodie() {
		return nume_melodie;
	}

	public void setMelodie(String mel) {
		this.nume_melodie = mel;
	}

	public String getArtist() {
		return nume_artist;
	}

	public void setArtist(String art) {
		this.nume_artist = art;
	}

	public int getAn() {
		return an_lansare;
	}

	public void setAn(int an) {
		this.an_lansare = an;
	}

	public int getNr() {
		return numar_vizualizari;
	}

	public void setNr(int nr) {
		this.numar_vizualizari = nr;
	}

	public String toString() {
		return "\n" + nume_melodie + " " + nume_artist + " " + an_lansare + " " + numar_vizualizari;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("melodii.txt");
		Scanner sc = new Scanner(file);
		String artis;
		Scanner vl = new Scanner(System.in);
		ArrayList<Piese> empList = new ArrayList<>();
		// ArrayList<String> artisti=new ArrayList<>();
		ArrayList<Integer> views = new ArrayList<>();
		List<String> artisti = new ArrayList<>();
		List<String> piese = new ArrayList<>();
		String id = null;
		int rand=0;
		while (sc.hasNextLine()) {
			String data[] = sc.nextLine().split(";");

			empList.add(new Piese(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
			views.add(Integer.parseInt(data[3]));
			
		}
		sc.close();
		Collections.sort(empList, new AgeSorter());

		
		System.out.println("ce artist cautati: ");
		artis = vl.nextLine();
		for(int i=0;i<empList.size();i++) {
			if(empList.get(i).nume_artist.contains(artis)) {
				System.out.println(empList.get(i).nume_melodie);
			}
		}
			
		
		
		// System.out.println("\n\n"+views);
	}

}
