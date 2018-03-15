package test;

import javafx.application.Application;
import translator.Translator;
import translator.TranslatorFactory;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TranslatorTest {

    @Test
    public void test() {
        TranslatorFactory translatorFactory = new TranslatorFactory();
        Translator numberTranslator = translatorFactory.getTranslator("NUMBER");
        Translator phraseTranslator = translatorFactory.getTranslator("PHRASE");
        System.out.println(phraseTranslator.translate("hello"));

        if (numberTranslator.getMapping().containsKey("one")) {
            System.out.println(numberTranslator.translate("one"));
        } else {
            System.out.println("error");
        }

        if (numberTranslator.getMapping().containsKey("hello")) {
            System.out.println(numberTranslator.translate("hello"));
        } else {
            System.out.println("error");
        }
    }

 /*   @Test
    public void test2() {
        SavePerformedTranslations savePerformedTranslations = SavePerformedTranslations.getInstance();
        TranslatorFactory translatorFactory = new TranslatorFactory();
        Translator numberTranslator = translatorFactory.getTranslator("NUMBER");
        Translator phraseTranslator = translatorFactory.getTranslator("PHRASE");

        String input = new String("one");

        if (numberTranslator.getMapping().containsKey(input)) {
        	savePerformedTranslations.getPerformedTranslations()
            String[] translated = numberTranslator.translate(input).split(",");
            savePerformedTranslations.add(new PerformedTranslation(translated[0], translated[1]));
            System.out.println(savePerformedTranslations.getPerformedTranslations());
        } else if (phraseTranslator.getMapping().containsKey(input)) {
            String[] translated = phraseTranslator.translate(input).split(",");
            savePerformedTranslations.add(new PerformedTranslation(translated[0], translated[1]));
            System.out.println(savePerformedTranslations.getPerformedTranslations());
        } else {
            System.out.println("error");
        }
    }*/

    @Test
    public void test3() {
    }
}

