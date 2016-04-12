package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

//This class tests the ANDNOT-Merge Algorithm

public class Test_4a {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of InvertedIndex
	private InvertedIndex invertedIndex;

	@BeforeClass
	public void setupBeforeClass() throws FileNotFoundException {
		invertedIndex = new InvertedIndex(FileReader.readCollection(TEST_PATH_3));
	}
	
	// The Results are sorted before Testing because, order isn't important yet
	// Otherwise we just compare the entries in the returned ArrayList
	
	// Keep in Mind that order is important with the ANDNOT-Operator

	// "marcus" is in no documents, "tiberius" is in some document => no results
	@Test
	public void testFirstTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("marcus", "tiberius");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	// "tiberius" is in some documents, "marcus" is in no document => some results
	@Test
	public void testSecondTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("tiberius", "marcus");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1 }, array);
	}

	@Test
	public void testSameTerm() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("enterprise", "enterprise");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	@Test
	public void testNoSameDocuments() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("enterprise", "doctor");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 0, 5, 6 }, array);
	}

	// "commander" is not in every document that "spock" is in => some results
	@Test
	public void testSomeSameDocumentsWithResults() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("spock", "commander");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 4 }, array);
	}
	
	// "spock" is in every document that "commander" is in => no results
	@Test
	public void testSomeSameDocumentsWithoutResults() {
		ArrayList<Integer> arrayList = invertedIndex.performANDNOTMerge("commander", "spock");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}
}
