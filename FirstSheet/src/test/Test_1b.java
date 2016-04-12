// This tests the searchmethod of the inverted index. The index constructor has to work for this

package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

//This class tests the Indexing of the Inverted-Index

public class Test_1b {

	// Location of the Test-Collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of InvertedIndex
	private InvertedIndex invertedIndex;

	@BeforeClass
	public void setupBeforeClass() throws FileNotFoundException {
		invertedIndex = new InvertedIndex(FileReader.readCollection(TEST_PATH_3));
	}

	// The Results are sorted before Testing because, order isn't important yet
	// Otherwise we just compare the entries in the returned ArrayList
	
	@Test
	public void testFirstDocument() {
		ArrayList<Integer> arrayList = invertedIndex.searchForSingleWord("tiberius");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 0 }, array);
	}

	@Test
	public void testLastDocument() {
		ArrayList<Integer> arrayList = invertedIndex.searchForSingleWord("chekov");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 6 }, array);
	}

	@Test
	public void testFirstWord() {
		ArrayList<Integer> arrayList = invertedIndex.searchForSingleWord("doctor");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 2 }, array);
	}

	@Test
	public void testLastWord() {
		ArrayList<Integer> arrayList = invertedIndex.searchForSingleWord("fingers");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 3 }, array);
	}

	@Test
	public void testWordInMultipleDocuments() {
		ArrayList<Integer> arrayList = invertedIndex.searchForSingleWord("enterprise");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 0, 5, 6 }, array);
	}
}
