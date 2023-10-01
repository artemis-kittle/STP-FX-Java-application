package controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;
import javafx.scene.image.Image;


public class EmployerController extends Controller<Employer>{
  @FXML private TableView<Employee> employeesTv;
  @FXML private TextField nameTf;
  @FXML private TextField emailTf;
  @FXML private Button addBtn;
  @FXML private Button deleteBtn;
  @FXML private Button selectBtn;
  @FXML private Button paygBtn;
  @FXML private Button stpBtn;
  @FXML private Button closeBtn;
  
  @FXML private void initialize(){
    // need to initialize and diasble the buttons
    employeesTv.getSelectionModel().selectedItemProperty().addListener((Observable,oldVal,newVal)->{
        deleteBtn.setDisable(newVal==null);
        selectBtn.setDisable(newVal==null);
        paygBtn.setDisable(newVal==null);}
    );
    nameTf.textProperty().addListener((Observable,oldVal,newVal)->{
        getEmployer().filterList(newVal,getName());}
    );
    emailTf.textProperty().addListener((Observable,oldVal,newVal)->{
        getEmployer().filterList(newVal,getEmail());}
    );
  }
  @FXML 
  public void handleAdd(ActionEvent event)throws IOException{
    Employee employee = new Employee("","","","","","",0,0.0);
    Stage employeeStage = new Stage();
    employeeStage.getIcons().add(new Image("/view/edit.png"));
    getEmployer().addEmployee(employee);
    int prevIndex = getEmployer().getEmployees().size()-1;
    ViewLoader.showStage(getEmployer().getEmployees().get(prevIndex),"/view/employee.fxml","Adding new Employee",employeeStage);
  }
  @FXML
  public void handleDelete(ActionEvent event)throws IOException{
    getEmployer().removeEmployee(employeesTv.getSelectionModel().getSelectedItem());
  }
  @FXML
  public void handleSelect(ActionEvent event)throws IOException{
    Stage updateStage = new Stage();
    updateStage.getIcons().add(new Image("/view/edit.png"));
    ViewLoader.showStage(getSelectedEmployee(),"/view/employee.fxml","Accesing Files:"+getSelectedEmployee().getName(),updateStage);
    selectBtn.setDisable(true);
    deleteBtn.setDisable(true);
    paygBtn.setDisable(true);
    this.employeesTv.getSelectionModel().clearSelection();
  }//askangela
  @FXML
  public void handlePayg(ActionEvent event) throws IOException{
    Stage paygStage = new Stage();
    paygStage.getIcons().add(new Image("/view/edit.png"));
    ViewLoader.showStage(getSelectedEmployee(),"/view/payg.fxml",getSelectedEmployee().getName()+" PAYG Report",paygStage);
    paygBtn.setDisable(true);
    selectBtn.setDisable(true);
    deleteBtn.setDisable(true);
    this.employeesTv.getSelectionModel().clearSelection();
  }
  @FXML
  public void handleStp(ActionEvent event) throws IOException{
    Stage stpStage = new Stage();
    stpStage.getIcons().add(new Image("/view/stp.jpg"));
    STP stp =new STP();
    ViewLoader.showStage(stp,"/view/stp.fxml","STP Report",stpStage);
  }
  @FXML
  public void handleClose(ActionEvent event) throws IOException{
    stage.close();
  }
  public String getEmail(){
      return emailTf.getText();
  }
  public String getName(){
      return nameTf.getText();
  }
  public final Employer getEmployer(){
      return model;
  }
  private Employee getSelectedEmployee(){
      return employeesTv.getSelectionModel().getSelectedItem();
  }
  /*private Employee getSelectedProperty(){
      return employeesTv.getSelectionModel().selectedItemProperty();
  }*/
}

