package assignment3;

import java.util.HashMap;

public class NumberTranslator implements Translator {
	private static HashMap<String, String> mapping = new HashMap<>();
	private PerformedTranslations performedTranslation;
	public NumberTranslator() {
		mapping.put("one", "eins");
		mapping.put("two", "zwei");
		mapping.put("three", "drei");
		mapping.put("four", "vier");
		mapping.put("five", "fünf");
		mapping.put("six", "sechs");
		mapping.put("seven", "sieben");
		mapping.put("eight", "acht");
		mapping.put("nine", "neun");
		mapping.put("ten", "zehn");
		mapping.put("eleven", "elf");
		mapping.put("twelve", "zwölf");
		mapping.put("thirteen", "dreizehn");
		mapping.put("fourteen", "vierzehn");
		mapping.put("fifteen", "fünfzehn");
		mapping.put("sixteen", "sechzehn");
		mapping.put("seventeen", "siebzehn");
		mapping.put("eighteen", "achtzehn");
		mapping.put("nineteen","neunzehn" );
		mapping.put("twenty", "zwanzig");
	}
	
	@Override
	public boolean translate(String input) {
		//System.out.println("Translate number: " + input);
		if(mapping.containsKey(input)) {
			performedTranslation = new PerformedTranslations(input,mapping.get(input));
			System.out.println(mapping.get(input));
			return true;
		} else {
			return false;
		}
	}
}
