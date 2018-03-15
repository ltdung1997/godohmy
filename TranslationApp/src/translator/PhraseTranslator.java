package translator;

import java.util.HashMap;

import translation.PerformedTranslation;
import translation.SavePerformedTranslations;

public class PhraseTranslator implements Translator {
    private HashMap<String, String> phraseMapping = new HashMap<>();
    SavePerformedTranslations saveTranslations = SavePerformedTranslations.getInstance();
    PhraseTranslator() {
        phraseMapping.put("hello", "hallo");
        phraseMapping.put("play", "spielen");
        phraseMapping.put("read", "lesen");
        phraseMapping.put("how are you", "Wie geht es dir");
        phraseMapping.put("where are you from", "woher kommen Sie");
        phraseMapping.put("teacher","Lehrer" );
        phraseMapping.put("money", "Geld");
        phraseMapping.put("who are you", "Wer bist du?");
        phraseMapping.put("Germany", "Deutschland");
        phraseMapping.put("Vietnamese","Vietnamesisch");
    }

    @Override
    public boolean translate(String input) {
        PerformedTranslation performedTranslation = new PerformedTranslation();
        performedTranslation.addObserver(saveTranslations);

        if (phraseMapping.containsKey(input)) {
            //performedTranslation = new PerformedTranslation(input, phraseMapping.get(input));
            performedTranslation.setGer(phraseMapping.get(input));
            performedTranslation.setTranslationType("phrase");
            performedTranslation.setEn(input);
            System.out.println(phraseMapping.get(input));
           //return performedTranslation.getEn() + "," + performedTranslation.getGer();
            return true;
        } else {
        	return false;
        }
    }

    @Override
    public HashMap<String, String> getMapping() {
        return phraseMapping;
    }
}
