package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import indexing.Document;
import indexing.FileReader;

public class MainController {

	/* Variables */
	private static FileReader fileReader;
	private static ArrayList<Document> collection;

	/* Constants */
	private static final String LoremIpsumCollectionDirectoryPath = "collections";

	public static void main(String[] args) throws FileNotFoundException {
		instantiate();
		readCollection();
		
		// only for test purposes
		test();
	}

	private static void test() {
		System.out.println(collection.size());
		
		Document test = collection.get(0);
		System.out.println(test.getName());
		
		ArrayList<String> uniqueWords = test.getUniqueWordList();
		System.out.println(uniqueWords.toString());
		
		ArrayList<String> allWords = test.getWordList();
		System.out.println(allWords.size());
	}

	private static void instantiate() throws FileNotFoundException {
		// Instantiate fields
		fileReader = new FileReader();
		collection = new ArrayList<>();
	}

	/*
	 * directory is the overall document location. this method iterates over all documents in directory.
	 * for each file in directory we create a document object with relevant information and store
	 * that in collection.
	 */
	private static void readCollection() throws FileNotFoundException {
		File directory = new File(LoremIpsumCollectionDirectoryPath);
		File[] directoryListing = directory.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				Document document = fileReader.read(child);
				collection.add(document);
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
	}
}
