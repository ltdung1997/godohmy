package assignment3;

import java.util.HashMap;

public class PhraseTranslator implements Translator {
	private static HashMap<String, String> mapping = new HashMap<>();
	private PerformedTranslations performedTranslation;
	
	public PhraseTranslator() {
		mapping.put("hello", "hallo");
		mapping.put("play", "spielen");
		mapping.put("read", "lesen");
		mapping.put("how are you", "Wie geht es dir");
		mapping.put("where are you from", "woher kommen Sie");
		mapping.put("teacher","Lehrer" );
		mapping.put("money", "Geld");
		mapping.put("who are you", "Wer bist du?");
		mapping.put("Germany", "Deutschland");
		mapping.put("Vietnamese","Vietnamesisch");
		
	}
	
	@Override
	public boolean translate(String input) {
		//System.out.println("Translate phrase: " + input);
		if(mapping.containsKey(input)) {
			performedTranslation = new PerformedTranslations(input,mapping.get(input));
			System.out.println(mapping.get(input));
			return true;
		} else {
			return false;
		}
	}
}
