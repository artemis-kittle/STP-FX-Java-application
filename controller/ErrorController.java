package controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import au.edu.uts.ap.javafx.*;

public class ErrorController extends Controller<Validator>{
  
    @FXML private ListView<String> errorLv;
    public final Validator getException(){
       return model;
   }
   @FXML 
   private void initialize(){
        errorLv.setItems(getException().getErrors());
   }
    @FXML 
    private void handleOkay(ActionEvent event){
        stage.close();
    }
}
