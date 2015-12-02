package _firstWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import _firstGiven.BooleanDocument;
import _firstGiven.FileReader;

public class MainController {

	/*
	 * LoremIpsumCollectionDirectoryPath - Name des Verzeichnisses das die
	 * Dokumente enthaelt
	 */
	private static final String LOREM_IPSUM_COLLECTION_DIRECTORY_PATH = "collections/lorem";

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<BooleanDocument> collection = FileReader.readCollection(LOREM_IPSUM_COLLECTION_DIRECTORY_PATH);

		// invertedIndex - Repraesentation des InvertedIndex
		InvertedIndex invertedIndex = new InvertedIndex(collection);

		// breakdown the query into two terms
		String[] qterms = getQueryTerms();
		
		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(qterms[0], qterms[1]);

		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	public static String[] getQueryTerms() {
		// let's get a query from the user via the command line
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a query:");
		String query = scanner.nextLine();
		scanner.close();
		
		// Lets clean up those queryterms
		String[] result = query.split("AND");
		result[0] = result[0].trim().toLowerCase();
		result[1] = result[1].trim().toLowerCase();
		
		return result;
	}

	/*
	 * Diese Methode gibt ausschlieslich die Ergebnisse an den User aus
	 */
	private static void postResults(ArrayList<Integer> mergeResult) {
		System.out.println();
		System.out.println("+++++++");
		System.out.println();
		System.out.println("The results are:");
		for (int result : mergeResult) {
			System.out.println(result);
		}
	}
}
