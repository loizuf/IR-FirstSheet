package indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {

	Document document;
	Scanner scanner;
	HashMap<String, Integer> wordCount;

	public Document read(File file) throws FileNotFoundException {
		/*
		 * Scanner uses Whitespace as delimiter. This might have to be changed
		 * for different Retrieval Problems (e.g. what about hyphens?)
		 */
		scanner = new Scanner(file);
		
		readCompleteFile();

		// document = new Document(wordCount);
		return document;
	}

	private void readCompleteFile() {
		while (scanner.hasNext()) {
			String nextWord = scanner.next();

			// Here is any kind of work with the word (e.g. stemming)

			Integer count = wordCount.get(nextWord);
			if (count == null) {
				wordCount.put(nextWord, 1);
			} else {
				wordCount.put(nextWord, count + 1);
			}
		}
	}
}
