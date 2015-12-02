package _firstWork;

import java.io.IOException;
import java.util.ArrayList;

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

		// queryterms - array mit den beiden Queryterms
		String[] queryTerms = getQueryTerms();

		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(queryTerms[0], queryTerms[1]);

		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	// Methode die einen String vom User einlieﬂt, splittet und als array zurueckgibt
	public static String[] getQueryTerms() {
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
