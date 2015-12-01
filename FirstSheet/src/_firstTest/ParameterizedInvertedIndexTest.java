// This is a parameterized Test for the Invertedindex which should index all the documents

package _firstTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _firstGiven.BooleanDocument;
import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

@RunWith(Parameterized.class)
public class ParameterizedInvertedIndexTest {
	
	// Location of two (nonsensical) collections
	// first collection is simple, second contains upper and lowercase as well as unnecessary whitespace (which isn't important for the first sheet as the actual collection isnt lower or uppercase)
	private static final String TEST_PATH_1 = "collections/testCollections/first";
	private static final String TEST_PATH_2 = "collections/testCollections/second";
	
	// These Variables have to be created by hand. Cant use the algorithm or students would just copy it
	// these are only small testcollections anyway (2-10 documents), it's just about the principle after all
	private static HashMap<String, ArrayList<Integer>> testInvertedIndex1;
	private static HashMap<String, ArrayList<Integer>> testInvertedIndex2;
	
	// These variables are needed for the parameterized test
	private ArrayList<BooleanDocument> inputCollection;
	private HashMap<String, ArrayList<Integer>> expectedIndex;
	
	// This constructor is also needed for the parameterized test
	public ParameterizedInvertedIndexTest(ArrayList<BooleanDocument> inputCollection, HashMap<String, ArrayList<Integer>> expectedIndex) throws FileNotFoundException {
		this.inputCollection = inputCollection;
		this.expectedIndex = expectedIndex;
	}

	// This is the test for the cunstructor.
	// expectedIndex - this is the result index we built by hand
	// inputCollection - this is the test-collection from which an invertedIndex is built using the algorithm of the student
	// when the results match the test is successful
	@Test
	public void testInvertedIndex() {
		assertEquals(expectedIndex, new InvertedIndex(inputCollection).getInvertedIndexHashmap());
	}
	
	// This method sets up the data for the tests
	@Parameters
	public static List<Object[]> data() throws FileNotFoundException {
		setupInvertedIndeces();
		// use filereader class to read in testcollections from different locations here
		ArrayList<BooleanDocument> testCollection1 = FileReader.readCollection(TEST_PATH_1);
		ArrayList<BooleanDocument> testCollection2 = FileReader.readCollection(TEST_PATH_2);
		
		return Arrays.asList(new Object[][] {
	    							{testCollection1, testInvertedIndex1},
	    							{testCollection2, testInvertedIndex2}
	    					});
	}
	
	// Horrible!!! has to be done SOMWHERE else
	private static void setupInvertedIndeces() {
		testInvertedIndex1 = new HashMap<>();
		testInvertedIndex2 = new HashMap<>();
		
		setup1(testInvertedIndex1);
		setup2(testInvertedIndex2);
	}

	// Filling the resulting invertedIndex by hand to test the collection
	private static void setup1(HashMap<String, ArrayList<Integer>> testInvertedIndex) {
		testInvertedIndex.put("president", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3})));
		testInvertedIndex.put("swim", new ArrayList<Integer>(Arrays.asList(new Integer[] {1})));
		testInvertedIndex.put("donkey", new ArrayList<Integer>(Arrays.asList(new Integer[] {1})));
		testInvertedIndex.put("poststamp", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3})));
		testInvertedIndex.put("because", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2})));
		testInvertedIndex.put("boat", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 3})));
		testInvertedIndex.put("are", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2})));
		testInvertedIndex.put("stupid", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2})));
		testInvertedIndex.put("all", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("tree", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("good", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("friend", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("with", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("this", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("grow", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("from", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("arizona", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("to", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("california", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("when", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("rain", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		
	}

	// Filling the resulting invertedIndex by hand to test the collection
	private static void setup2(HashMap<String, ArrayList<Integer>> testInvertedIndex) {
		testInvertedIndex.put("there", new ArrayList<Integer>(Arrays.asList(new Integer[] {1})));
		testInvertedIndex.put("is", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3})));
		testInvertedIndex.put("no", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 3})));
		testInvertedIndex.put("green", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2})));
		testInvertedIndex.put("yellow", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 4})));
		testInvertedIndex.put("purple", new ArrayList<Integer>(Arrays.asList(new Integer[] {1})));
		testInvertedIndex.put("corn", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 5})));
		testInvertedIndex.put("on", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 5})));
		testInvertedIndex.put("the", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 5})));
		testInvertedIndex.put("moon", new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 5})));
		testInvertedIndex.put("soylent", new ArrayList<Integer>(Arrays.asList(new Integer[] {2})));
		testInvertedIndex.put("people", new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 4})));
		testInvertedIndex.put("eating", new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 4})));
		testInvertedIndex.put("this", new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 4})));
		testInvertedIndex.put("a", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("space", new ArrayList<Integer>(Arrays.asList(new Integer[] {3})));
		testInvertedIndex.put("station", new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 4, 5})));
		testInvertedIndex.put("of", new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 5})));
		testInvertedIndex.put("are", new ArrayList<Integer>(Arrays.asList(new Integer[] {4})));
		testInvertedIndex.put("when", new ArrayList<Integer>(Arrays.asList(new Integer[] {4})));
		testInvertedIndex.put("dog", new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 5})));
		testInvertedIndex.put("rain", new ArrayList<Integer>(Arrays.asList(new Integer[] {4})));
		testInvertedIndex.put("from", new ArrayList<Integer>(Arrays.asList(new Integer[] {5})));
		testInvertedIndex.put("will", new ArrayList<Integer>(Arrays.asList(new Integer[] {5})));
		testInvertedIndex.put("grow", new ArrayList<Integer>(Arrays.asList(new Integer[] {5})));
		testInvertedIndex.put("bottom", new ArrayList<Integer>(Arrays.asList(new Integer[] {5})));
		testInvertedIndex.put("sea", new ArrayList<Integer>(Arrays.asList(new Integer[] {5})));
	}
}
