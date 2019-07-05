package Views;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView {

    private Menu menuFile;
    private Menu menuHelp;
    private Menu menuTools;
    private MenuBar menuBar;
    private final MenuItem subMenuOpen;
    private final MenuItem subMenuExit;
    private final MenuItem subMenuCommit;
    private final MenuItem subMenuAbout;

    public MenuView() {
        this.menuFile = new Menu("File");
        this.menuHelp = new Menu("Help");
        this.menuTools = new Menu("Tools");
        this.menuBar = new MenuBar();
        this.subMenuOpen = new MenuItem("Open");
        this.subMenuExit = new MenuItem("Exit");
        this.subMenuCommit = new MenuItem("Commit analyzer");
        this.subMenuAbout = new MenuItem("About");
    }

    public Menu getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(Menu menuFile) {
        this.menuFile = menuFile;
    }

    public Menu getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelp(Menu menuHelp) {
        this.menuHelp = menuHelp;
    }

    public Menu getMenuTools() {
        return menuTools;
    }

    public void setMenuTools(Menu menuTools) {
        this.menuTools = menuTools;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public MenuBar getMenu() {
        return menuBar;
    }

    public MenuItem getSubMenuExit() {
        return subMenuExit;
    }

    public MenuItem getSubMenuAbout() {
        return subMenuAbout;
    }
    
    public MenuItem getsubMenuOpen() {
        return subMenuOpen;
    }

    public void DrawMenu() {
        menuBar.getMenus().addAll(menuFile, menuTools, menuHelp); // desenha a barra de menu
        menuFile.getItems().addAll(subMenuOpen, subMenuExit);     // add subMenu no menu File
        menuTools.getItems().add(subMenuCommit);                  // add subMenu no menu File
        menuHelp.getItems().add(subMenuAbout);
        menuBar.setStyle("-fx-background-color: #4682B4; -fx-color: red;");
    }
}
