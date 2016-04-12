package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

// This class tests the AND-Merge Algorithm

public class Test_3 {

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
	
	@Test
	public void testFirstTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performANDMerge("marcus", "tiberius");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	@Test
	public void testSecondTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performANDMerge("tiberius", "marcus");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	@Test
	public void testSameTerm() {
		ArrayList<Integer> arrayList = invertedIndex.performANDMerge("enterprise", "enterprise");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 0, 5, 6 }, array);
	}

	@Test
	public void testNoMatches() {
		ArrayList<Integer> arrayList = invertedIndex.performANDMerge("enterprise", "doctor");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	@Test
	public void testSomeMatches() {
		ArrayList<Integer> arrayList = invertedIndex.performANDMerge("spock", "commander");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1, 2 }, array);
	}
}
