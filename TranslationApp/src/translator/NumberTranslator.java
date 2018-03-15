package translator;

import java.util.HashMap;

import translation.PerformedTranslation;
import translation.SavePerformedTranslations;

public class NumberTranslator implements Translator {
    private HashMap<String, String> numberMapping = new HashMap<>();
    SavePerformedTranslations saveTranslations = SavePerformedTranslations.getInstance();
    
    NumberTranslator() {
        numberMapping.put("one", "eins");
        numberMapping.put("two", "zwei");
        numberMapping.put("three", "drei");
        numberMapping.put("four", "vier");
        numberMapping.put("five", "fünf");
        numberMapping.put("six", "sechs");
        numberMapping.put("seven", "sieben");
        numberMapping.put("eight", "acht");
        numberMapping.put("nine", "neun");
        numberMapping.put("ten", "zehn");
        numberMapping.put("eleven", "elf");
        numberMapping.put("twelve", "zwölf");
        numberMapping.put("thirteen", "dreizehn");
        numberMapping.put("fourteen", "vierzehn");
        numberMapping.put("fifteen", "fünfzehn");
        numberMapping.put("sixteen", "sechzehn");
        numberMapping.put("seventeen", "siebzehn");
        numberMapping.put("eighteen", "achtzehn");
        numberMapping.put("nineteen","neunzehn" );
        numberMapping.put("twenty", "zwanzig");
    }

    @Override
    public boolean translate(String input) {
        PerformedTranslation performedTranslation = new PerformedTranslation();
        performedTranslation.addObserver(saveTranslations);
        if (numberMapping.containsKey(input)) {
            //performedTranslation = new PerformedTranslation(input, numberMapping.get(input));
            performedTranslation.setGer(numberMapping.get(input));
            performedTranslation.setTranslationType("num");
            performedTranslation.setEn(input);
        	System.out.println(numberMapping.get(input));
            //return performedTranslation.getEn() + "," + performedTranslation.getGer();
            return true;
        } else {
        	return false;
        }
    }

    @Override
    public HashMap<String, String> getMapping() {
        return numberMapping;
    }
}
