package controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import javafx.application.*;
import javafx.scene.image.Image;
import model.*;


public class SessionController extends Controller<Session>{

  
  public final Session getSession(){
      return model;
  }
  
  @FXML 
  public void handleLogin(ActionEvent event) throws IOException{
   Stage loginStage = new Stage();
   loginStage.getIcons().add(new Image("/view/book.png"));
   Employers employers = new Employers();
   ViewLoader.showStage(employers, "/view/login.fxml", "Sign In", loginStage);
  }
  
  @FXML 
  private void handleExit(ActionEvent event) throws Exception{
    Platform.exit();
  }
}
  