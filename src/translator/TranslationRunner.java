package translator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.Group; 
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import translation.PerformedTranslation;
import translation.SavePerformedTranslations;



public class TranslationRunner extends Application {

	private PerformedTranslation performedTranslation;
	private ListView<PerformedTranslation> listView;
	private ObservableList<PerformedTranslation> myObservableList;
	private SavePerformedTranslations savePerformedTranslation = SavePerformedTranslations.getInstance();
	
	List<PerformedTranslation> transactionList = new ArrayList<>();
	
  //  @FXML private ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) throws Exception {	
    	primaryStage.setTitle("Transaction List");
		listView = new ListView<>();
		myObservableList = FXCollections.observableList(transactionList);
		listView.setItems(myObservableList);
	
        listView.setCellFactory(new Callback<ListView<PerformedTranslation>, ListCell<PerformedTranslation>>(){

            @Override
            public ListCell<PerformedTranslation> call(ListView<PerformedTranslation> p) {
                ListCell<PerformedTranslation> cell = new ListCell<PerformedTranslation>(){
                    @Override
                    protected void updateItem(PerformedTranslation t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getEn() + ":        " + t.getGer());
                        }
                    }
                };      
                return cell;
            }
        });
        
        Button btn = new Button("Refresh");
        btn.setOnAction((ActionEvent event) -> {
        	transactionList = savePerformedTranslation.getPerformedTranslations();
        	myObservableList = FXCollections.observableList(transactionList);
    		listView.setItems(myObservableList);
        });
       
        VBox root = new VBox(listView, btn);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        // statistic view
        Text text = new Text();      
        text.setText("Distribution of performed translation:"); 
        Text text1 = new Text();
        text1.setText("Performed translation of numbers(1-20):");
        Text text2 = new Text();
        text2.setText("Performed translation of phrases and terms: ");
        Text text3 = new Text();
        text3.setText("Illegal translations (no translation given):");
        
        Button btn1 = new Button("Refresh");
    
        btn1.setOnAction((ActionEvent event) -> {
        	int num = savePerformedTranslation.getNumCount();
        	int phrase = savePerformedTranslation.getPhraseCount();
        	int illegal = savePerformedTranslation.getIllegalCoutn();
        	int total = num+phrase+illegal;
        	
        	text.setText("Distribution of performed translation:"); 
        	text1.setText("Performed translation of numbers(1-20):" + num*100/total + "%");
        	text2.setText("Performed translation of phrases and terms: " + phrase*100/total +"%");
        	text3.setText("Illegal translations (no translation given): "+ illegal*100/total + "%");
        });
        
        VBox root2 = new VBox(text,text1,text2,text3,btn1);
    
        Scene scene2 = new Scene(root2,300,300);
        Stage secondStage = new Stage();
        secondStage.setScene(scene2);
        secondStage.show();

    }

    
    public static void main(String[] args) {
        // Launch application in GUI
        launch(args);
    }
}
