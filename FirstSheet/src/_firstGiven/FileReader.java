package _firstGiven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	/*
	 * LoremIpsumCollectionDirectoryPath - Name des Verzeichnisses das die Dokumente enthält
	 */
	private static final String LoremIpsumCollectionDirectoryPath = "collections";

	/*
	 * Diese Methode iteriert über alle Dokumente im Verzeichniss. Für jedes Dokument wird ein
	 * Dokument-Objekt erzeugt und in collection gespeichert
	 */
	public static ArrayList<BooleanDocument> readCollection() throws FileNotFoundException {
		ArrayList<BooleanDocument> collection = new ArrayList<>();
		File directory = new File(LoremIpsumCollectionDirectoryPath);
		File[] directoryListing = directory.listFiles();

		for (File child : directoryListing) {
			/*
			 * Wir benutzen die Scanner-Klasse um die Dokumente einzulesen aber jedes Dokument wird als
			 * ganzer String eingelesen und die Zerlegung in einzelne Wörter wird von unserer eigenen
			 * Tokenizer-Klasse erledigt
			 */
			Scanner scanner = new Scanner(child).useDelimiter("\\A");
			String entireTextFile = scanner.next();
			scanner.close();

			BooleanDocument document = new BooleanDocument(entireTextFile, child.getName());
			collection.add(document);
		}
		return collection;
	}

}
