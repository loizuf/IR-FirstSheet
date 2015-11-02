package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import indexing.Document;
import indexing.InvertedIndex;
import indexing.Query;
import searchengines.BooleanSearchEngine;

public class MainController {

	/* Variables */
	private static ArrayList<Document> collection;
	private static InvertedIndex invertedIndex;

	/* Constants */
	private static final String LoremIpsumCollectionDirectoryPath = "collections";

	public static void main(String[] args) throws IOException {
		instantiate();
		readCollection();
		createIndex();
		Query query = getQuery();
		ArrayList<String> mergeResult = performBooleanSearch(query);
		postResults(mergeResult, query);
	}

	private static void postResults(ArrayList<String> mergeResult, Query query) {
		ArrayList<String> queryWordList = query.getUniqueWordList();
		System.out.println("+++++++");
		System.out.println("");
		switch (queryWordList.size()){
		case 0:
			System.out.println("No query recognized.");
			break;
		case 1:
			if(mergeResult.size()>0){
				System.out.println("The word '"+queryWordList.get(0)+"' can be found in the documents:");
			} else {
				System.out.println("No match for the word '"+queryWordList.get(0)+"'");
			}
			break;
		default:
			if(mergeResult.size()>0){
				System.out.println("The words '"+queryWordList.get(0)+"' and '"+queryWordList.get(1)+"' can be found in the documents:");
			} else {
				System.out.println("No match for the words '"+queryWordList.get(0)+"' and '"+queryWordList.get(1)+"'");
			}
			break;
		}
		for (String string : mergeResult) {
			System.out.println(string);
		}
	}

	private static ArrayList<String> performBooleanSearch(Query query) {
		ArrayList<Integer> resultPostingsList = BooleanSearchEngine.performSearch(invertedIndex, query);
		
		ArrayList<String> searchResult  = new ArrayList<>();
		for (int docNumber : resultPostingsList) {
			searchResult.add(invertedIndex.getDocumentName(docNumber));
		}
		return searchResult;
	}

	private static Query getQuery() throws IOException {
		System.out.println("Please enter your query:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		System.out.println("Boolean Retrieval? y/n");
		String testForRetrieval = reader.readLine().toLowerCase();
		boolean booleanRetrieval = true;
		if(testForRetrieval.equals("n")){
			booleanRetrieval = false;
		}
		Query currentQuery = new Query(input, booleanRetrieval);
		return currentQuery;
	}

	private static void createIndex() {
		invertedIndex = new InvertedIndex(collection);
	}

	private static void instantiate() throws FileNotFoundException {
		// Instantiate fields
		collection = new ArrayList<>();
	}

	/*
	 * directory is the overall document location. this method iterates over all
	 * documents in directory. for each file in directory we create a document
	 * object with relevant information and store that in collection.
	 */
	private static void readCollection() throws FileNotFoundException {
		File directory = new File(LoremIpsumCollectionDirectoryPath);
		File[] directoryListing = directory.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				Document document = readDocument(child);
				collection.add(document);
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
	}

	public static Document readDocument(File file) throws FileNotFoundException {
		/*
		 * Scanner uses Whitespace as delimiter. Documents and query should use
		 * the Tokenizer class to change that
		 */
		Scanner scanner = new Scanner(file).useDelimiter("\\A");
		String entireTextFile = scanner.next();
		scanner.close();

		Document document = new Document(entireTextFile, file.getName());
		return document;
	}
}
