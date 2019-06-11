package randompicker;

// import dos demais arquivos do programa
import randompicker.Models.*;
import randompicker.Views.*;
import randompicker.Controllers.*;

// arquivos para desenhar na telinha
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public class RandomPicker extends Application {
    
    TextArea outputArea = new TextArea();
    final Menu menuFile = new Menu("File");
    final Menu menuOption = new Menu("Options");
    final Menu menuHelp = new Menu("Help");;
    final MenuBar menuBar = new MenuBar();
    final MenuItem subMenuOpen = new MenuItem("Open");
    final MenuItem subMenuExit = new MenuItem("Exit");
    final FileChooser fileChooser = new FileChooser();
    
    public static void main(String[] args) {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) {
        Text centerText = new Text("Center");
        Text rightText = new Text("Right");
        Text leftText = new Text("Left");
        
        menuBar.getMenus().addAll(menuFile, menuOption, menuHelp); // desenha a barra de menu
        menuFile.getItems().addAll(subMenuOpen, subMenuExit); // add subMenu no menu File
        
        subMenuOpen.setOnAction((ActionEvent) -> { // evento para abrir arquivo
            fileChooser.setTitle("Abrir Arquivo");
            fileChooser.showOpenDialog(stage);
        });
        
        subMenuExit.setOnAction((WindowEvent) -> { // evento para fechar o programa
                System.exit(0);
        });
        
        // Set the alignment of the Top Text to Center
        BorderPane.setAlignment(menuBar, Pos.TOP_CENTER);
        BorderPane.setAlignment(outputArea, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(leftText,Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightText,Pos.CENTER_RIGHT);
         
        // Create a BorderPane with a Text node in each of the five regions
        BorderPane root = new BorderPane(centerText, menuBar, rightText, outputArea, leftText);
        root.setPrefSize(800, 600); // width e height da VBox
        root.setStyle("-fx-padding: 10;"); // Set the Style-properties of the BorderPane
        
        Scene scene = new Scene(root);                 // Create the Scene        
        stage.setScene(scene);                         // Add the scene to the Stage        
        stage.setTitle("A simple BorderPane Example"); // Set the title of the Stage
        stage.show();                                  // Display the Stage
    }
}