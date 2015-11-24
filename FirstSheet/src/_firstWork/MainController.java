package _firstWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import _firstGiven.BooleanDocument;
import _firstGiven.FileReader;

public class MainController {

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<BooleanDocument> collection = FileReader.readCollection();

		// invertedIndex - Repr�sentation des InvertedIndex
		InvertedIndex invertedIndex = new InvertedIndex(collection);

		// let's get a query from the user via the command line
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a query:");
		String query = scanner.nextLine();
		//String query = "david AND theo";
		
		// test for aufgabe 2
		//System.out.println(invertedIndex.searchForSingleWord(query));
		
		//breakdown the query into two terms
		String[] qterms = query.trim().split("AND");
		//for (String q:qterms)
		//	System.out.println(q.trim().toLowerCase());
		

		// Diese Methode liest einen String vom User ein und splittet diesen in 2 Strings
		//getQueryTerms(firstTerm, secondTerm);

		// mergeResult- Liste aller IDs der Dokumente die der Query entsprechen
		ArrayList<Integer> mergeResult = invertedIndex.performANDMerge(qterms[0], qterms[1]);

		postResults(mergeResult);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	private static void getQueryTerms(String firstTerm, String secondTerm) {
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
