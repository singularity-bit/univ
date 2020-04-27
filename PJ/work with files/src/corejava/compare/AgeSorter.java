package corejava.compare;

import java.util.Comparator;

import ex4.Piese;


public class AgeSorter implements Comparator<Piese>{
	
	    public int compare(Piese o1, Piese o2) {
	        return o2.getNr() - o1.getNr();
	    }
	
}
