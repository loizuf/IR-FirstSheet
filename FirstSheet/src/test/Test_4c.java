package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

//This class tests the XOR-Merge Algorithm

public class Test_4c {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of InvertedIndex
	private static InvertedIndex invertedIndex;

	@BeforeClass
	public static void setupBeforeClass() throws FileNotFoundException {
		invertedIndex = new InvertedIndex(FileReader.readCollection(TEST_PATH_3));
	}
	
	// The Results are sorted before Testing because, order isn't important yet
	// Otherwise we just compare the entries in the returned ArrayList

	@Test
	public void testFirstTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performXORMerge("marcus", "tiberius");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1 }, array);
	}

	@Test
	public void testSecondTermMissing() {
		ArrayList<Integer> arrayList = invertedIndex.performXORMerge("tiberius", "marcus");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1 }, array);
	}

	@Test
	public void testSameTerm() {
		ArrayList<Integer> arrayList = invertedIndex.performXORMerge("enterprise", "enterprise");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { }, array);
	}

	@Test
	public void testNoMatches() {
		ArrayList<Integer> arrayList = invertedIndex.performXORMerge("enterprise", "doctor");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 0, 1, 2, 5, 6 }, array);
	}

	@Test
	public void testSomeMatches() {
		ArrayList<Integer> arrayList = invertedIndex.performXORMerge("logic", "enterprise");
		Collections.sort(arrayList);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1, 3 }, array);
	}
}
