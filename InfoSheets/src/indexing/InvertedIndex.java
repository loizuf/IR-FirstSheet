package indexing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class InvertedIndex extends AbstractIndex {

	/*
	 * This Hashmap represents the Term-Document Matrix. The outer Key is the
	 * Term, the inner ArrayList contains the numbers of all documents which
	 * contain this term.
	 */
	private HashMap<String, ArrayList<Integer>> invertedIndex;

	/*
	 * This Hashmap is just a dictionary to hide the names of the documents
	 * behind numbers
	 */
	private HashMap<Integer, String> documentNameList;

	public InvertedIndex(ArrayList<Document> collection) {
		invertedIndex = new HashMap<>();
		documentNameList = new HashMap<>();
		generateWordsInCollectionList(collection);
	}

	// this is a testmethod. The real search should of course use the Query-class
	public ArrayList<String> searchForSingleWord(String word) {
		ArrayList<String> searchResult  = new ArrayList<>();
		for (int docNumber : invertedIndex.get(word)) {
			searchResult.add(documentNameList.get(docNumber));
		}
		return searchResult;
	}

	private void generateWordsInCollectionList(ArrayList<Document> collection) {
		int counter = 0;
		for (Document document : collection) {
			documentNameList.put(counter, document.getName());
			generateTermDocumentMatrix(document.getUniqueWordList(), counter);
			counter++;
		}
	}

	private void generateTermDocumentMatrix(ArrayList<String> wordsInDocument, int counter) {
		for (String word : wordsInDocument) {
			if (invertedIndex.containsKey(word)) {
				invertedIndex.get(word).add(counter);
			} else {
				ArrayList<Integer> newWordEntry = new ArrayList<>();
				newWordEntry.add(counter);
				invertedIndex.put(word, newWordEntry);
			}
		}
	}
}
