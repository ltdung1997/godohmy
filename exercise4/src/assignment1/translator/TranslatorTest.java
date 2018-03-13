package translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

public class TranslatorTest {
	private final String errorMessage = "I don't understand";
	Translator trans = Translator.getInstance();
	@Test
	public void testEmptyInput() {
		String output = trans.translate("");
		System.out.println("Input: ");
		System.out.println("Expected Output: I don't understand");
		System.out.println("Actual output: " + output + "\n");
		assertEquals(output, errorMessage);
	}
	
	@Test
	public void testNullInput() {
		String output = trans.translate(null);
		System.out.println("Input: null value");
		System.out.println("Expected Output: I don't understand");
		System.out.println("Actual output: " + output + "\n");
		assertEquals(output, errorMessage);
	}
	
	
	@Test
	public void testCorrectKeyCorrectValue() {
		String output = trans.translate("one");
		System.out.println("Input: one");
		System.out.println("Expected Output: eins");
		System.out.println("Actual output: " + output + "\n");
		assertEquals(output, "eins");
	}
	
	@Test
	public void testCorrectKeyNullValue() {
		String output = trans.translate("six");
		System.out.println("Input: six");
		System.out.println("Expected Output: null value");
		System.out.println("Actual output: " + output + "\n");
		assertNull(trans.translate("six"));
	}
	
	@Test
	public void testWrongKey() {
		String output = trans.translate("abc");
		System.out.println("Input: abc");
		System.out.println("Expected Output: I don't understand");
		System.out.println("Actual output: " + output + "\n");
		assertEquals(output, errorMessage);
	}
}
