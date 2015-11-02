package indexing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import preprocessing.Tokenizer;

public class Query implements Indexable {

	// Even though not further specified this Query class handles boolean retrieval
	
	private String plainText;
	private ArrayList<String> tokens;
	private HashMap<String, Integer> wordCounts;
	private int totalWordCount = 0;
	private int uniqueWordCount = 0;

	public Query(String searchText, boolean booleanRetrieval) {
		plainText = searchText;
		tokens = new ArrayList<>();
		tokens = Tokenizer.tokenize(plainText, booleanRetrieval);
		totalWordCount = tokens.size();
		wordCounts = new HashMap<>();
		countOccurrences();
		uniqueWordCount = wordCounts.size();
	}
	
	private void countOccurrences() {
		for (String word : tokens) {
			Integer count = wordCounts.get(word);
			if (count == null) {
				wordCounts.put(word, 1);
			} else {
				wordCounts.put(word, count + 1);
			}
		}
	}

	// Interface Method (Indexable)
	public HashMap<String, Integer> getWordCountList() {
		return wordCounts;
	}

	// Interface Method (Indexable)
	public ArrayList<String> getWordList() {
		System.out.println("getting from query: "+tokens);
		return tokens;
	}

	// Interface Method (Indexable)
	public ArrayList<String> getUniqueWordList() {
		// This step eliminates all duplicates from the arraylist while maintaining the order
		ArrayList<String> uniqueWordList = new ArrayList<String>(new LinkedHashSet<>(tokens));
		return uniqueWordList;
	}

	// Interface Method (Indexable)
	public int getWordCount(String word) {
		return totalWordCount;
	}

	// Interface Method (Indexable)
	public int getUniqueWordCount(String word) {
		return uniqueWordCount;
	}

	// Interface Method (Indexable)
	public String getPlainText() {
		return plainText;
	}

}
