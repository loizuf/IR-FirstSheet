package indexing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BinaryIndex extends AbstractIndex{
	
	// NOT NECESSARY
	/*
	private boolean[][] binaryIndex;
	private int wordCount;
	private int documentCount;
	
	/*
	 * This Hashmaps are just a dictionary to hide the names of the documents and the terms
	 * behind numbers
	 *
	private HashMap<Integer, String> documentNameList;
	private HashMap<Integer, String> termList;
	
	public BinaryIndex(ArrayList<Document> collection) {
		documentNameList = new HashMap<>();
		termList = new HashMap<>();
		
		HashSet<String>  allWordsinCollection = getAllWordsInCollection(collection);
		wordCount = allWordsinCollection.size();
		documentCount = collection.size();
		binaryIndex = new boolean[wordCount][documentCount];
		index(collection);
	}

	private void index(ArrayList<Document> collection) {
		for (Document document : collection) {
			int docNumber = 
			ArrayList<String> wordsInDocument = document.getUniqueWordList();
			for (String word : wordsInDocument) {
				
			}
		}
	}

	private HashSet<String> getAllWordsInCollection(ArrayList<Document> collection) {
		int documentCounter = 0;
		int termCounter = 0;
		HashSet<String> allWords = new HashSet<>();
		for (Document document : collection) {
			documentNameList.put(documentCounter, document.getName());
			for (String term : document.getUniqueWordList()) {				
				
				// This fills the termList
				if(allWords.add(term)){
					termList.put(termCounter, term);
					termCounter++;
				}
			}
			documentCounter++;
		}
		return allWords;
	}
	*/
}
