package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	}

	private static void instantiate() throws FileNotFoundException {
		fileReader = new FileReader();
		File file = new File("collections/disk1.txt");
		Scanner scanner = new Scanner(file);
		String string = scanner.next();
		System.out.println(string);
	}

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
