package indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	Document document;
	Scanner scanner;
	ArrayList<String> unalteredWords;

	public Document read(File file) throws FileNotFoundException {
		/*
		 * Scanner uses Whitespace as delimiter. This might have to be changed
		 * for different Retrieval Problems (e.g. what about hyphens?)
		 */
		scanner = new Scanner(file);
		unalteredWords = new ArrayList<>();
		
		// This loop just reads the document word for word. NO alteration should be done here
		while (scanner.hasNext()) {
			String nextWord = scanner.next();
			unalteredWords.add(nextWord);
		}
		document = new Document(unalteredWords, file.getName());
		return document;
	}
}
