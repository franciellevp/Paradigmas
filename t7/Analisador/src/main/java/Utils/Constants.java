package Utils;

import java.io.File;

public class Constants {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    public final static String FILENAME = "urls.txt";
    public final static String FILEPATH = (new File(FILENAME)).getAbsolutePath().replace(FILENAME, "") + "/src/main/resources/files/";
}
