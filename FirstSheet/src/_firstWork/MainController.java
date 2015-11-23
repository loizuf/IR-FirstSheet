package _firstWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import _firstGiven.BooleanDocument;
import _firstGiven.FileReader;

public class MainController {

	/*
	 * LoremIpsumCollectionDirectoryPath - Name des Verzeichnisses das die
	 * Dokumente enthält
	 */
	private static final String LOREM_IPSUM_COLLECTION_DIRECTORY_PATH = "collections/lorem";

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<BooleanDocument> collection = FileReader.readCollection(LOREM_IPSUM_COLLECTION_DIRECTORY_PATH);

		// invertedIndex - Repräsentation des InvertedIndex
		InvertedIndex invertedIndex = new InvertedIndex(collection);

		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String query = rd.readLine();

		// queryTerms - Array das die beiden Query Terms enthält
		String[] queryTerms = getQueryTerms(query);

		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(queryTerms);

		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	public static String[] getQueryTerms(String query) {
		return null;
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
