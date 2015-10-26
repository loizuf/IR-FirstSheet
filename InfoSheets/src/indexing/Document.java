package indexing;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * creating and storing these documents might be not sensible in an actual IR-system. This is done here
 * to represent all files (in there original form, so no stemming or anything else) and to give access
 * to all relevant information of the documents.
 */
public class Document implements Indexable {

	private ArrayList<String> wordList;
	private HashMap<String, Integer> wordCounts;
	private String name;
	private int totalWordCount = 0;
	private int uniqueWordCount = 0;

	/**
	 * Constructor for a representation of a document within the code.
	 * 
	 * @param unalteredWords
	 * @param name
	 */
	public Document(ArrayList<String> unalteredWords, String name) {
		this.name = name;
		wordList = unalteredWords;
		totalWordCount = wordList.size();
		wordCounts = new HashMap<>();
		countOccurrences();
		uniqueWordCount = wordCounts.size();
	}

	private void countOccurrences() {
		for (String word : wordList) {
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
	public int getWordCount(String word) {
		return totalWordCount;
	}

	// Interface Method (Indexable)
	public int getUniqueWordCount(String word) {
		return uniqueWordCount;
	}

	// Interface Method (Indexable)
	public ArrayList<String> getWordList() {
		return wordList;
	}

	// Interface Method (Indexable)
	public ArrayList<String> getUniqueWordList() {
		ArrayList<String> uniqueWordList = new ArrayList<String>(wordCounts.keySet());
		return uniqueWordList;
	}

	public String getName() {
		return name;
	}
}