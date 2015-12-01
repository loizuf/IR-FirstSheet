// This tests the searchmethod of the inverted index. The index constructor has to work for this

package _firstTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _firstGiven.FileReader;
import _firstWork.InvertedIndex;

@RunWith(Parameterized.class)
public class ParameterizedInvertedIndexMethodTest {

	// Location of two (nonsensical) collections
	// first collection is simple, second contains upper and lowercase as well
	// as unnecessary whitespace (which isn't important for the first sheet as
	// the actual collection isnt lower or uppercase)
	private static final String TEST_PATH_2 = "collections/testCollections/second";

	// Variable containing an instance of InvertedIndex
	private InvertedIndex invertedIndex;

	// parameterized variables
	private String inputString;
	private ArrayList<Integer> expectedResult;

	public ParameterizedInvertedIndexMethodTest(String inputString, ArrayList<Integer> expectedResult)
			throws FileNotFoundException {
		// these Variables are used to test the two methods
		invertedIndex = new InvertedIndex(FileReader.readCollection(TEST_PATH_2));

		this.inputString = inputString;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testSearchForSingleWord() {
		assertEquals(expectedResult, invertedIndex.searchForSingleWord(inputString));
	}

	// This method sets up the data for the tests
	@Parameters
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "is", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3 })) },
						{ "no", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3 })) },
						{ "green", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2 })) },
						{ "yellow", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 4 })) },
						{ "purple", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1 })) },
						{ "corn", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 5 })) },
						{ "on", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 5 })) },
						{ "the", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 5 })) },
						{ "moon", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 5 })) },
						{ "soylent", new ArrayList<Integer>(Arrays.asList(new Integer[] { 2 })) },
						{ "people", new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 4 })) },
						{ "eating", new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 4 })) },
						{ "this", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 4 })) },
						{ "a", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3 })) },
						{ "space", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3 })) },
						{ "station", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 4, 5 })) },
						{ "of", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5 })) },
						{ "are", new ArrayList<Integer>(Arrays.asList(new Integer[] { 4 })) },
						{ "when", new ArrayList<Integer>(Arrays.asList(new Integer[] { 4 })) },
						{ "dog", new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 5 })) },
						{ "rain", new ArrayList<Integer>(Arrays.asList(new Integer[] { 4 })) },
						{ "from", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5 })) },
						{ "will", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5 })) },
						{ "grow", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5 })) },
						{ "bottom", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5 })) },
						{ "sea", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5 })) } });
	}

}
