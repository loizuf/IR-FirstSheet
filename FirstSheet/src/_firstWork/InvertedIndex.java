package _firstWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import _firstGiven.BooleanDocument;
import _firstGiven.BooleanIndexable;

public class InvertedIndex {

	private HashMap<String, ArrayList<Integer>> invertedIndex;

	// Bearbeiten sie Aufgabe 1 hier.
	public InvertedIndex(ArrayList<BooleanDocument> collection) {

	}

	// Bearbeiten sie Aufgabe 2 hier.
	public ArrayList<Integer> searchForSingleWord(String word) {
		return null;
	}

	// Bearbeiten sie Aufgabe 4 hier
	public ArrayList<Integer> performANDMerge(String[] queryTerms) {
		return null;
	}
	
	// For JUNIT-Tests. This Method must not be edited or deleted
	public HashMap<String, ArrayList<Integer>> getInvertedIndexHashmap(){
		return invertedIndex;
	}

	// Für Aufgabe 5 erweitern sie diese Klasse um weitere Methoden
}
