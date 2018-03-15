package translator;

import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import external.ExternalDatabase;
import external.SendEMail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import translation.SavePerformedTranslations;

/*public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}*/
public class Main{
	
	public static void main(String[] args) {
		TranslatorFactory translatorFactory = new TranslatorFactory();
		SavePerformedTranslations saveTranslations = SavePerformedTranslations.getInstance();
		ExternalDatabase database = new ExternalDatabase();
		
		Translator trans1 = translatorFactory.getTranslator("NUMBER");
		Translator trans2 = translatorFactory.getTranslator("PHRASE");
		
		String input = "";
	
		
		new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(TranslationRunner.class);
            }
        }.start();
        while(true) {
    		System.out.println("Translate: ");
    		Scanner scanner = new Scanner(System.in);
        	input = scanner.nextLine();

        	if(trans1.translate(input) || trans2.translate(input)) {
        		database.setSavePerformedTranslations(saveTranslations);
        		try {
        			database.storePerformedTranslations();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}else {
        		saveTranslations.setIllegalCount(saveTranslations.getIllegalCoutn()+1);
        		System.out.println("I don't understand");
        	}
        }
	}
}
