package translator;

public class TranslatorFactory {
    public Translator getTranslator(String translatorType) {
        if (translatorType == null) {
            return null;
        }

        if (translatorType.equalsIgnoreCase("NUMBER")) {
            return new NumberTranslator();
        } else if (translatorType.equalsIgnoreCase("PHRASE")) {
            return new PhraseTranslator();
        }

        return null;
    }
}
