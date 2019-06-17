package randompicker.Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutView {
    
    public void ShowAboutScreen(Text aboutText) {
        System.out.print("ABOUT");
        aboutText.setText("Random Picker\nFrancielle Vasconcellos Pereira\nCopyright 2019 - Todos os direitos reservados.");
        aboutText.setTextAlignment(TextAlignment.CENTER);
        Stage stage = new Stage();
        VBox box = new VBox(aboutText);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 350, 150);
        stage.setScene(scene);
        stage.show();
    }
}
