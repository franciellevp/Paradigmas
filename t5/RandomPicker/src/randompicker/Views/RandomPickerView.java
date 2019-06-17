package randompicker.Views;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RandomPickerView {

    TextArea textArea = new TextArea();
    final Menu menuFile = new Menu("File");
    final Menu menuHelp = new Menu("Help");
    ;
    final MenuBar menuBar = new MenuBar();
    final MenuItem subMenuOpen = new MenuItem("Open");
    final MenuItem subMenuExit = new MenuItem("Exit");
    final MenuItem subMenuAbout = new MenuItem("About");
    final FileChooser fileChooser = new FileChooser();
    final Text aboutText = new Text();
    //Model model = new Model();

    public void drawView(Stage stage) {
        Button btnShuffle = new Button("Shuffle");
        Button btnNext = new Button("Next");

        menuBar.getMenus().addAll(menuFile, menuHelp); // desenha a barra de menu
        menuFile.getItems().addAll(subMenuOpen, subMenuExit); // add subMenu no menu File
        menuHelp.getItems().add(subMenuAbout);

        subMenuOpen.setOnAction((ActionEvent ActionEvent) -> { // abre janela para escolha de arquivo
            //File file = model.openFileChooser(stage, fileChooser);
            //elements = model.readFileContent(file.getName(), textArea);
        });

        subMenuExit.setOnAction((WindowEvent) -> { // fecha o programa
            System.exit(0);
        });

        subMenuAbout.setOnAction((ActionEvent) -> { // mostra textinho sobre o programa
            //model.showAboutScreen(aboutText);
        });

        btnShuffle.setOnAction((ActionEvent) -> { // embaralha a lista
            //Collections.shuffle(elements);
            //System.out.println(elements);

        });

        btnNext.setOnAction((ActionEvent) -> { // pega cada elemento da lista
            //model.showAboutScreen(aboutText);
        });

        textArea.setPrefWidth((double) 400); // set TextArea Height
        menuBar.setStyle("-fx-background-color: #4682B4; -fx-color: red;");

        BorderPane.setAlignment(menuBar, Pos.TOP_CENTER);
        BorderPane.setAlignment(textArea, Pos.CENTER_LEFT);
        BorderPane.setAlignment(btnShuffle, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(btnNext, Pos.CENTER_RIGHT);

        BorderPane root = new BorderPane(aboutText, menuBar, btnShuffle, btnNext, textArea);
        root.setPrefSize(800, 600);        // width e height da VBox
        root.setStyle("-fx-padding: 10; -fx-background-color: snow;"); // Set the Style-properties of the BorderPane

        Scene scene = new Scene(root);   // Create the Scene        
        stage.setScene(scene);           // Add the scene to the Stage        
        stage.setTitle("Random Picker"); // Set the title of the Stage
        stage.show();                    // Display the Stage
    }
}
