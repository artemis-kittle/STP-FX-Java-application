package controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class EmployeeController extends Controller<Employee>{
  @FXML private TextField nameTf;
  @FXML private TextField emailTf;
  @FXML private TextField phoneTf;
  @FXML private TextField addressTf;
  @FXML private TextField tfnTf;
  @FXML private TextField hoursTf;
  @FXML private TextField hourrateTf;
  @FXML private TextField typeTf;
  @FXML private Button addBtn;
  @FXML private Button updateBtn;
  @FXML private Button closeBtn;
  
  @FXML 
  private void initialize(){
    
    nameTf.textProperty().set(model.getName());
    if (nameTf.getText().equals(""))
        updateBtn.setDisable(true);
    else
        addBtn.setDisable(true);
      
    emailTf.textProperty().set(model.getEmail());
    //this.emailTf.setText(((Employee)this.model).getEmail());
    phoneTf.textProperty().set(model.getPhone());
    // this.phoneTf.setText(((Employee)this.model).getPhone());
    addressTf.textProperty().set(model.getAddress());
    //this.addressTf.setText(((Employee)this.model).getAddress());
    tfnTf.textProperty().set(model.getTFN());
    //this.tfnTf.setText(((Employee)this.model).getTFN());
    hoursTf.textProperty().set(""+model.getHours());
    //this.hoursTf.setText(((Employee)this.model).getHours() + "");
    hourrateTf.textProperty().set(""+model.getPayPerHour());
    //this.hourrateTf.setText(((Employee)this.model).getPayPerHour() + "");
    typeTf.textProperty().set(model.getType());
  }
  
  @FXML 
  public void handleAdd(ActionEvent event) throws IOException{
   
    try{
      Validator validate = new Validator("");
      
      if(!validate.hasName(getName())) 
          validate.addError("Incorrect name pattern!");
      if(!validate.hasEmail(getEmail()))  
          validate.addError("Incorrect email pattern!");
      if(!validate.hasPhone(getPhone()))  
          validate.addError("Incorrect phone pattern!");
      if(!validate.hasAddress(getAddress()))  
          validate.addError("Incorrect address pattern!");
      if(!validate.hasType(getType()))  
          validate.addError("Incorrect type pattern!");
      if(!validate.hasTfn(getTfn()))  
          validate.addError("Incorrect TFN pattern!");
      
      if( (!(validate.hasName(getName()))) || (validate.hasEmail(getEmail())|| validate.hasPhone(getPhone())|| validate.hasAddress(getAddress()) || validate.hasType(getType()) || validate.hasTfn(getTfn()))&& (validate.error.size()!=0) ) throw validate;
      System.out.println("not catching errors");
      // ask angela about adding employee from employees
      //can we edit employees.java and employers.java? for the bonus
      
      //getEmployee().updateDetails(newname, newemail, newphone, newaddress, newtfn, newtype, newhours, newrate);
      //Employee employee= new Employee(newname, newemail, newphone, newaddress, newtfn, newtype, newhours, newrate);
      //model.getEmployer().addEmployee(newname, newemail, newphone, newaddress, newtfn, newtype, newhours, newrate);
      model.updateDetails(this.getName(), this.getEmail(), this.getPhone(), this.getAddress(), this.getTfn(), this.getType(), this.getHours(), this.getRate());
      //Employee employee = new Employee(this.getName(), this.getEmail(), this.getPhone(), this.getAddress(), this.getTfn(), this.getType(), this.getHours(), this.getRate());
      //getEmployee().getEmployer().addEmployee(employee);
      
      
      stage.close();
      }
    catch(Validator validate) {
        ViewLoader.showStage(validate, "/view/error.fxml", "Input Exceptions", new Stage());
      }
}
  
  
  @FXML 
  public void handleUpdate(ActionEvent event) throws IOException{
     
    try{
        
      Validator validate = new Validator("");
      
      if(!validate.hasName(getName())) 
          validate.addError("Incorrect name pattern!");
      if(!validate.hasEmail(getEmail()))  
          validate.addError("Incorrect email pattern!");
      if(!validate.hasPhone(getPhone()))  
          validate.addError("Incorrect phone pattern!");
      if(!validate.hasAddress(getAddress()))  
          validate.addError("Incorrect address pattern!");
      if(!validate.hasType(getType()))  
          validate.addError("Incorrect type pattern!");
      if(!validate.hasTfn(getTfn()))  
          validate.addError("Incorrect TFN pattern!");
      
      if( !((validate.hasName(getName()))) || (validate.hasPhone(getPhone())|| validate.hasEmail(getEmail()) || validate.hasAddress(getAddress()) || validate.hasType(getType()) || validate.hasTfn(getTfn()))&& (!validate.error.isEmpty()) ) throw validate;
      model.updateDetails(this.getName(), this.getEmail(), this.getPhone(), this.getAddress(), this.getTfn(), this.getType(), this.getHours(), this.getRate());
      
      stage.close();
    }
    catch (Validator validate){
      ViewLoader.showStage(validate, "/view/error.fxml", "Input Exceptions", new Stage());
    }
  }
    
  @FXML 
  public void handleClose(ActionEvent event) throws IOException{
    stage.close();
  }
  
  /*public Employer getEmployer(){ 
      return model.getEmployer();
  }*/
  public String getName(){
      return nameTf.getText();
  }
  public String getEmail(){
      return emailTf.getText();
  }
  public String getPhone(){
      return phoneTf.getText();
  }
  public String getAddress(){
      return addressTf.getText();
  }
  public String getTfn(){
      return tfnTf.getText();
  }
  public int getHours(){
      return Integer.parseInt(hoursTf.getText());
  }
  public double getRate(){
      return Double.parseDouble(hourrateTf.getText());
  }
  public String getType(){
      return typeTf.getText();
  }
    

}
