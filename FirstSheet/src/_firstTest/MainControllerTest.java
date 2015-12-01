// This class is the test class for the maincontroller-method which reads and splits the user Input

package _firstTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import _firstWork.MainController;

public class MainControllerTest {
	
	// It is easier here to just built a method for each case instead of using a parameterized tests
	// could be refactored later into a parameterized test
	// tests aim to test the limits (lower and uppercase, whitespace) of what is expected in the first sheet

	@SuppressWarnings("deprecation")
	@Test
	public void testGetQueryTerms1() {		
		String[] testArray = {"wissen", "nacht"};
		
		String testString = "wissen AND nacht";
		
		assertEquals("test1", testArray, MainController.getQueryTerms(testString));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetQueryTerms2() {
		String[] testArray = {"schnee", "wittchen"};
		
		String testString = "SCHNEE AND WITTCHEN";
		
		assertEquals("test2", testArray, MainController.getQueryTerms(testString));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetQueryTerms3() {
		String[] testArray = {"captain", "blaubaer"};
		
		String testString = "Captain AND Blaubaer";
		
		assertEquals("test1", testArray, MainController.getQueryTerms(testString));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetQueryTerms4() {
		String[] testArray = {"volzotan", "smeik"};
		
		String testString = " vOLzoTaN   AND   SmEiK ";
		
		assertEquals("test1", testArray, MainController.getQueryTerms(testString));
	}
}
