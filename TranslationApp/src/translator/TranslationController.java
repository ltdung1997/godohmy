package translator;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

public class TranslationController extends VBox {

    @FXML
    TextArea listView;
    private PrintStream printStream;

    public TranslationController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("translation.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

}

