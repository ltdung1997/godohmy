package assignment3;

import java.util.Scanner;

public class TranslationMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userInput = "";
		System.out.print("Translate:");
		Scanner scanner = new Scanner(System.in);
		userInput = scanner.nextLine();
		TranslatorFactory translateFactory = new TranslatorFactory();
		
		Translator trans1 = translateFactory.getTranslator("NUMBER");
		Translator trans2 = translateFactory.getTranslator("PHRASE");
		if(trans1.translate(userInput)||trans2.translate(userInput)) {
			
		}else {
			System.out.println("I don't understand");
		}
	}

}
