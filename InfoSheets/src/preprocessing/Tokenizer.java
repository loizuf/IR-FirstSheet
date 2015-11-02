package preprocessing;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokenizer {
	
	private static final String whiteSpaceRegex = "\\s+";
	private static final String nonAlphaNumericalRegex = "[^a-zA-Z0-9 -]";
	
	public static ArrayList<String> tokenize(String sentence) {
		// This splits the query by whitespace and converts the tokens to an ArrayList
		ArrayList<String> result = new ArrayList<>(Arrays.asList(sentence.split(whiteSpaceRegex)));
		format(result);
		return result;
	}
	
	public static ArrayList<String> tokenize(String sentence, boolean booleanRetrieval) {
		/*
		 *  This splits the query. If booleanRetrieval is true only "AND" is used as a delimiter and
		 *  EVERYTHING on both sides of the end is treated as ONE WORD WITH Whitespace
		 */
		ArrayList<String> result = new ArrayList<>();
		if(booleanRetrieval){
			result = new ArrayList<String>(Arrays.asList(sentence.split("AND")));
		} else {
			result = new ArrayList<String>(Arrays.asList(sentence.split(whiteSpaceRegex)));
		}
		format(result);
		result.removeAll(Arrays.asList("", null));
		return result;
	}

	private static void format(ArrayList<String> result) {
		for (int i=0; i<result.size(); i++) {
			String current = result.get(i);
			current = current.replaceAll(nonAlphaNumericalRegex, "");
			current = current.trim();
			current = current.toLowerCase();
			result.set(i, current);
		}
	}

	/* Only for testpurposes
	private static void testOutput(ArrayList testOutput) {
		System.out.println();
		System.out.println("TESTOUTPUT");
		for (Object object : testOutput) {
			System.out.println(object);
		}
	}
	*/

}
