package randompicker;

import randompicker.Models.*;
import randompicker.Controllers.*;

public class RandomPickerCmd {

    public static void main(String[] args) {
        String fileName = "nomes.txt";
        Model model = new Model(fileName);
        Controller controller = new Controller(model, null);
        controller.AppCmd();
    }
}
