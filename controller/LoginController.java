package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;
import javafx.scene.image.Image;

public class LoginController extends Controller<Employers>{
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordPf;
    @FXML private Text resultTf;
    @FXML Button loginBtn;
    @FXML Button cancelBtn;
    
    @FXML 
    public void handleOk(ActionEvent event) throws IOException{
      if(getEmployers().hasEmployer(getEmail(), getPassword())){
        Employer employer = getEmployers().getEmployer(getEmail(), getPassword());
        Stage employerStage = new Stage();
        employerStage.getIcons().add(new Image("/view/employer.png"));
        ViewLoader.showStage(employer, "/view/employer.fxml", "Session admin:"+employer.getName(), employerStage);
        emailTf.setText("");
        passwordPf.setText("");
        stage.close();
      }
    else 
        resultTf.setText("Incorrect login details");
        emailTf.setText("");
        passwordPf.setText("");
    }
    @FXML 
    public void handleCancel(ActionEvent event)throws Exception{
      stage.close();
    }
    
    private String getEmail(){
        return emailTf.getText();
    }
    private String getPassword(){
        return passwordPf.getText();
    }
    public Employers getEmployers(){
        return model;
    }
}
