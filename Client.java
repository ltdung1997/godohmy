package assignment3;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TranslatorFactory translateFactory = new TranslatorFactory();
		Translator trans1 = translateFactory.getTranslator("NUMBER");
		trans1.translate("one");
		Translator trans2 = translateFactory.getTranslator("PHRASE");
		trans2.translate("how are you");
	}

}
