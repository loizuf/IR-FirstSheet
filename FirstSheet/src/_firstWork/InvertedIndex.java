package _firstWork;

import java.util.ArrayList;
import java.util.HashMap;

import _firstGiven.BooleanDocument;

public class InvertedIndex {

	private HashMap<String, ArrayList<Integer>> invertedIndex;

	// Bearbeiten sie Aufgabe 1 hier.
	public InvertedIndex(ArrayList<BooleanDocument> collection) {
		invertedIndex = new HashMap<String, ArrayList<Integer>>();
	}

	// Bearbeiten sie Aufgabe 2 hier.
	public ArrayList<Integer> searchForSingleWord(String word) {
		return null;
	}

	// Bearbeiten sie Aufgabe 4 hier
	public ArrayList<Integer> performANDMerge(String firstWord, String secondWord) {
		return null;
	}

	// For JUNIT-Tests. This Method must not be edited or deleted
	public HashMap<String, ArrayList<Integer>> getInvertedIndexHashmap() {
		return invertedIndex;
	}

	// Fuer Aufgabe 5 erweitern sie diese Klasse um weitere Methoden
}
