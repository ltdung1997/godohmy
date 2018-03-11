package assignment3;

import java.util.HashMap;

public class PhraseTranslator implements Translator {
	private static HashMap<String, String> mapping = new HashMap<>();
	private PerformedTranslation performedTranslation;
	
	public PhraseTranslator() {
		mapping.put("hello", "hallo");
		mapping.put("play", "spielen");
		mapping.put("read", "lesen");
		mapping.put("how are you", "Wie geht es dir");
		mapping.put("where are you from", "woher kommen Sie");
	}
	
	@Override
	public void translate(String input) {
		System.out.println("Translate phrase: " + input);
		if(mapping.containsKey(input)) {
			performedTranslation = new PerformedTranslation(input,mapping.get(input));
			System.out.println(mapping.get(input));
		} else System.out.println("I don't understand");
	}
}
