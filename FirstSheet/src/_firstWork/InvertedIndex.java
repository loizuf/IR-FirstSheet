package _firstWork;

import java.util.ArrayList;
import java.util.HashMap;

import _firstGiven.Document;

public class InvertedIndex {

	// Diese Variable KANN verwendet werden um den Inverted-Index zu speichern.
	// Sie können auch eine eigene Variable anlegen.
	private HashMap<String, ArrayList<Integer>> invertedIndex;

	// Bearbeiten sie Aufgabe 1.a hier.
	public InvertedIndex(ArrayList<Document> collection) {

	}

	// Bearbeiten sie Aufgabe 1.b hier.
	public ArrayList<Integer> searchForSingleWord(String word) {
		return new ArrayList<Integer>();
	}

	// Bearbeiten sie Aufgabe 3 hier
	public ArrayList<Integer> performANDMerge(String firstWord, String secondWord) {
		return new ArrayList<Integer>();
	}

	// Bearbeiten sie Aufgabe 4.a hier
	public ArrayList<Integer> performANDNOTMerge(String firstWord, String secondWord) {
		return new ArrayList<Integer>();
	}

	// Bearbeiten sie Aufgabe 4.b hier
	public ArrayList<Integer> performORMerge(String firstWord, String secondWord) {
		return new ArrayList<Integer>();
	}

	// Bearbeiten sie Aufgabe 4.c hier
	public ArrayList<Integer> performXORMerge(String firstWord, String secondWord) {
		return new ArrayList<Integer>();
	}
}
