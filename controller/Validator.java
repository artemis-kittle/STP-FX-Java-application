package controller;
import javafx.collections.*;
import model.*;

public class Validator extends Exception{  
    public ObservableList<String> error = FXCollections.observableArrayList();
    public Validator(String message){
        super(message);   
    }
    public void addError(String type){error.add(type);}
    
    public final ObservableList<String> getErrors() {
		return error;
	}
    //false for null in all
    public boolean hasName(String text){
        if(text.equals("")) return false;
        String name;
        name = text.trim();
        if(Character.isUpperCase(name.charAt(0))) {
            for(int i=0;i<name.length();i++){
                char ch=name.charAt(i);
                if(Character.isWhitespace(ch)){
                    char c=name.charAt(i+1);
                    if(Character.isLetter(c))
                        return Character.isUpperCase(c);
                    return false;
                }
            }
        }
      return false;
   }
   public boolean hasPhone(String phone){
       if(phone.equals("")) return false;
        return phone.length()==8 && phone.matches("^\\d{8}");
  }
   public boolean hasEmail(String email){
       if(email.equals("")) return false;
        return email.endsWith("@uts.com")&& (email.indexOf('.')<9);
   }
   public boolean hasTfn(String tfn){
       if(tfn.equals("")) return false;
        return (tfn.charAt(3)=='-')&&(tfn.length()==7);
   }
   public boolean hasType(String type){
       if(type.equals("")) return false;
        if(type.equals("Casual")) return true;
        for(int i=0;i<type.length();i++){
            char ch=type.charAt(i);
            if(ch=='-'){
                char c=type.charAt(i+1);
                if(Character.isLetter(c)) return true;
            }
        }
        return false;
   }
    public boolean hasAddress(String address){//ask angela
        if(address.equals("")) return false;
        return (Character.isDigit(address.charAt(0)))
                && (Character.isDigit(address.charAt((address.length())-1)))
                && (address.contains("St."));
    }
   
}

