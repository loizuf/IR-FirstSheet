package indexing;

import java.util.ArrayList;
import java.util.HashMap;

public class InvertedIndex extends AbstractIndex implements Index {

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
		goThroughCollection(collection);
	}

	// this is a testmethod. The real search should of course use the Query-class
	public ArrayList<Integer> searchForSingleWord(String word) {
		ArrayList<Integer> result = invertedIndex.get(word);
		if(result==null){
			return new ArrayList<Integer>();
		}
		return result;
	}
	
	public String getDocumentName(int number) {
		String name;
		name = documentNameList.get(number);
		return name;
	}

	private void goThroughCollection(ArrayList<Document> collection) {
		int counter = 0;
		for (Document document : collection) {
			documentNameList.put(counter, document.getName());
			generateInvertedIndex(document.getUniqueWordList(), counter);
			counter++;
		}
		// No further sorting necessary because the inverted Index is already in ascending order
	}

	private void generateInvertedIndex(ArrayList<String> wordsInDocument, int counter) {
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
