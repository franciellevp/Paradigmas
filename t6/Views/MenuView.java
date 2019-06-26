package Views;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView {
    private final Menu menuFile = new Menu("File");
    private final Menu menuHelp = new Menu("Help");
    private final MenuBar menuBar = new MenuBar();
    private final MenuItem subMenuReload = new MenuItem("Reload");
    private final MenuItem subMenuSource = new MenuItem("Source");
    private final MenuItem subMenuExit = new MenuItem("Exit");
    private final MenuItem subMenuAbout = new MenuItem("About");
    
    public MenuBar getMenu() {
        return menuBar;
    }
    
    public MenuItem getSubMenuExit() {
        return subMenuExit;
    }
	
    public MenuItem getSubMenuAbout() {
        return subMenuAbout;
    }
    
    public void DrawMenu() {
        menuBar.getMenus().addAll(menuFile, menuHelp);                          // desenha a barra de menu
        menuFile.getItems().addAll(subMenuReload, subMenuSource, subMenuExit); // add subMenu no menu File
        menuHelp.getItems().add(subMenuAbout);
        menuBar.setStyle("-fx-background-color: #4682B4; -fx-color: red;");
    }
}
