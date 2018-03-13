package translator;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TranslatorClient {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Translator trans = Translator.getInstance();
		LinkedHashMap<String,String> loadedTranslation = new LinkedHashMap<>();
		try {
			trans.translate("one");
			trans.translate("ten");
			trans.translate("abc");
			trans.translate("nine");
			trans.translate("");
			trans.translate("seven");
			trans.translate("two");
			trans.translate(null);
			trans.translate("fourteen");
			trans.StorePerformedTranslations();
			loadedTranslation = trans.LoadPerformedTranslations();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
		}
		
		System.out.println("Test : " + (trans.getHistoryTranslation().equals(loadedTranslation)));
	}

}
