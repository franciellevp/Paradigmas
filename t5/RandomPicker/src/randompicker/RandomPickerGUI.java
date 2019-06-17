package randompicker;

import randompicker.Views.*;
//import randompicker.Models.*;
//import randompicker.Controllers.*;

import javafx.application.Application;
import javafx.stage.Stage;
 
public class RandomPickerGUI extends Application {
    RandomPickerView vi = new RandomPickerView();
    
    public static void main(String[] args) {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) {
        vi.drawView(stage);
    }
}