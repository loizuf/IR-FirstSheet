package _firstWork;

import java.io.IOException;
import java.util.ArrayList;

import _firstGiven.BooleanDocument;
import _firstGiven.FileReader;

public class MainController {

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<BooleanDocument> collection = FileReader.readCollection();

		// invertedIndex - Repräsentation des InvertedIndex
		InvertedIndex invertedIndex = new InvertedIndex(collection);

		// queryTerms - Array das die beiden Query Terms enthält
		String[] queryTerms = getQueryTerms();

		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(queryTerms);

		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	private static String[] getQueryTerms() {
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
