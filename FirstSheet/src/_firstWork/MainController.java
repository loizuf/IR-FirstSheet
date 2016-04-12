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
	private static final String COLLECTION_3_DIRECTORY_PATH = "collections/testCollections/third";

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<BooleanDocument> collection = FileReader.readCollection(COLLECTION_3_DIRECTORY_PATH);

		// invertedIndex - Repraesentation des InvertedIndex
		InvertedIndex invertedIndex = new InvertedIndex(collection);

		// qterms - array mit allen eingegebenen Termen
		String[] qterms = getQueryTerms();
		
		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(qterms[0], qterms[1]);

		// Diese Methode gibt nur die Ergebnisse in der Konsole aus
		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	public static String[] getQueryTerms() {
		return null;
	}

	// Diese Methode gibt ausschlieslich die Ergebnisse an den User aus
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
