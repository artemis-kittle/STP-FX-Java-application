package controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;


public class PaygController  extends Controller<Employee>{
  @FXML private Text weeklyTf;
  @FXML private Text hourlyTf;
  @FXML private Text grossTf;
  @FXML private Text taxRateTf;
  @FXML private Text netIncomeTf;
  @FXML private Text deductionTf;
  @FXML private Text superTf;
  @FXML private Text superRateTf;
  
  @FXML 
  public void initialize(){
      
    weeklyTf.textProperty().bind(getEmployee().hoursProperty().asString().concat(" hours"));
    hourlyTf.textProperty().bind(getEmployee().payPerHourProperty().asString("$%.2f"));
    grossTf.textProperty().bind(getEmployee().incomeProperty().asString("$%.2f"));
    taxRateTf.textProperty().bind(getEmployee().rateProperty().multiply(100).asString("%.2f").concat("%"));
    netIncomeTf.textProperty().bind(getEmployee().netProperty().asString("$%.2f"));
    deductionTf.textProperty().bind(getEmployee().deductionProperty().asString("$%.2f"));
    superTf.textProperty().bind(getEmployee().superProperty().asString("$%.2f"));
    superRateTf.textProperty().bind(getEmployee().superRateProperty().multiply(100).asString("%.2f").concat("%"));
  }
  
  @FXML 
  private void handleClose(ActionEvent event){
    stage.close();
  }
  public final Employee getEmployee(){
      return model;
  }
   
}
