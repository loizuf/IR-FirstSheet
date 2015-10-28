package indexing;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Indexable should be implemented by everything which will become an entry in an index (documents and queries)
 * Not to be confused with the AbstractIndex which is the Parent class to the Index itself.
 */
public interface Indexable {

	/**
	 * Returns a HashMap containing all words in the Document as keys and the
	 * number of occurrences of each word as value
	 * 
	 * @return wordList - HashMap of all words (without duplicates)
	 */
	HashMap<String, Integer> getWordCountList();

	/**
	 * Returns an ArrayList containing all words in the Document (with
	 * duplicates)
	 * 
	 * @return wordList - HashMap of all words (with duplicates)
	 */
	ArrayList<String> getWordList();

	/**
	 * Returns an ArrayList containing all words in the Document (without
	 * duplicates)
	 * 
	 * @return wordList - HashMap of all words (without duplicates)
	 */
	ArrayList<String> getUniqueWordList();

	/**
	 * Returns all words in this Document (with duplicates).
	 * 
	 * @param word
	 *            - The string to be counted
	 * @return count - Number of Occurrences of word
	 */
	int getWordCount(String word);

	/**
	 * Returns all words in this Document (without duplicates).
	 * 
	 * @param word
	 *            - The string to be counted
	 * @return count - Number of Occurrences of word
	 */
	int getUniqueWordCount(String word);
}