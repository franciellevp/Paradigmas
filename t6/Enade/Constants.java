package Enade;

import java.io.File;

public class Constants {

    public final static int WIDTH = 1200;
    public final static int HEIGHT = 720;
    
    public final static String URL_CC = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";
    public final static String URL_SI = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=1285855524&single=true&output=csv";
    public final static String FILENAME = "enade.csv";
    public final static String FILEPATH = (new File(FILENAME)).getAbsolutePath().replace(FILENAME, "") + "t6/Enade/" + FILENAME;
}
