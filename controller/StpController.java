package controller;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;


public class StpController  extends Controller<STP>{
    @FXML private TableView<Employee> employeeTv;
    @FXML private TableColumn<Employee, String> wagesColumn;
    @FXML private TableColumn<Employee, String> taxColumn;
    @FXML private TableColumn<Employee, String> netColumn;
    @FXML private TableColumn<Employee, String> superColumn;
    @FXML private Text wagesTf;
    @FXML private Text taxTf;
    @FXML private Text netTf;
    @FXML private Text superTf;
    @FXML private Text basTf;
    
    @FXML private void initialize(){
      employeeTv.setItems(this.getStp().getEmployees());
      
      wagesColumn.setCellValueFactory(cellData-> 
              cellData.getValue().incomeProperty().asString("$%.2f"));
      
      taxColumn.setCellValueFactory(cellData->
              cellData.getValue().deductionProperty().asString("$%.2f"));
      
      netColumn.setCellValueFactory(cellData->
              cellData.getValue().netProperty().asString("$%.2f"));
      
      superColumn.setCellValueFactory(cellData->
              cellData.getValue().superProperty().asString("$%.2f"));
      
      wagesTf.textProperty().bind(this.getStp().totalWagesProperty().asString("$%.2f"));
      taxTf.textProperty().bind(this.getStp().totalTaxProperty().asString("$%.2f"));
      netTf.textProperty().bind(this.getStp().totalNetProperty().asString("$%.2f"));
      superTf.textProperty().bind(this.getStp().totalSuperProperty().asString("$%.2f"));
      basTf.textProperty().bind(this.getStp().basProperty().asString("$%.2f"));
    }
    @FXML 
    private void handleClose(ActionEvent event) throws IOException{
      stage.close();
    } 
    public final STP getStp(){
        return model;
    }
    public final ObservableList<Employee> getEmployees(){
        return getStp().getEmployees();
    }
}
