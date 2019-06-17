package random;

import Models.*;
import Controllers.*;

public class RandomPickerCMD {

    public static void main(String[] args) {
        String fileName = "names.txt";
        RandomPickerModel model = new RandomPickerModel(fileName);
        RandomPickerController controller = new RandomPickerController(model, null);
        controller.AppCmd();
    }
}
