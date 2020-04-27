//package Piese.java;

//package corejava.compare;

import java.util.Comparator;

import ex4.Piese;
 
public class AgeSorter implements Comparator<Piese> {
    @Override
    public int compare(Piese o1, Piese o2) {
        return o1.getNr() - o2.getNr();
    }
}