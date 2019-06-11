package randompicker.Controllers;

import randompicker.Models.Model;
import randompicker.Views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

    private final Model model;
    private final View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void contol(){        
        actionListener = (ActionEvent actionEvent) -> {
            linkBtnAndLabel();
        };                
        view.getButton().addActionListener(actionListener);   
    }
    
    private void linkBtnAndLabel(){
        model.incX();                
        view.setText(Integer.toString(model.getX()));
    }    
}