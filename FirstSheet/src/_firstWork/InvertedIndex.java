package _firstWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import _firstGiven.BooleanDocument;
import _firstGiven.BooleanIndexable;

public class InvertedIndex {

	private HashMap<String, ArrayList<Integer>> invertedIndex;
	
	
	
	// Bearbeiten sie Aufgabe 1 hier.
	public InvertedIndex(ArrayList<BooleanDocument> collection) {
		
		invertedIndex = new HashMap<String,ArrayList<Integer>>();
		
		Iterator<BooleanDocument> it = collection.iterator();
		int docId = -1;
		while (it.hasNext()){
			BooleanDocument doc = it.next();
			docId++;
			System.out.println("adding doc" + docId);
			
			// we will only take unique terms just now as this is a boolean model
			ArrayList<String> terms = doc.getUniqueWordList();
			Iterator<String> termIt = terms.iterator();
			while (termIt.hasNext()) {
				String term = termIt.next();
				indexTerm(term,docId);
			}
			
		}
		
		System.out.println("The index has "+ invertedIndex.keySet().size() +"terms");
	}

	// Second method required for Aufgabe 1; index term

	public void indexTerm(String t, int doc){
		
		ArrayList<Integer> docList = invertedIndex.get(t);
		
		if (docList==null)
			invertedIndex.put(t, new ArrayList<Integer>());
		else {
			docList.add(doc);
		}
		
	}
	
	// Bearbeiten sie Aufgabe 2 hier.
	public  ArrayList<Integer> searchForSingleWord(String word) {
		return invertedIndex.get(word);
	}
	
	// Bearbeiten sie Aufgabe 4 hier
	public ArrayList<Integer> performANDMerge(String firstWord, String secondWord) {
		//empty arraylist to place results
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		//get postingslist and an iterator for firstWord
		Iterator<Integer>postingsX = searchForSingleWord(firstWord).iterator();
		//get postingslist and an iterator for secondWord
		Iterator<Integer>postingsY = searchForSingleWord(secondWord).iterator();
		
		int x = postingsX.next();
		int y = postingsY.next();
		
		while (postingsX.hasNext() || postingsY.hasNext()){
			if (x == y) {
				results.add(x);
				if (postingsX.hasNext()){x = postingsX.next();}
				if (postingsY.hasNext()){y = postingsY.next();}
			}
			else if (x < y){
				if (postingsX.hasNext()){x = postingsX.next();}
			}
			else{
				if (postingsY.hasNext()){y = postingsY.next();}
			}
		}
		
		return results;
		
	}
	
	// F�r Aufgabe 5 erweitern sie diese Klasse um weitere Methoden
}
