import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
 
public class java_51928_CredentialValidator_A01 extends Application {
      // Hardcoded credentials for validation    
    private String hardCodedUserName = "user";  
    private String hardCodedPassword  = "password1234567890!";            
      
    public static void main(String[] args) {        
        launch(args);          // To start the JavaFX application. 
     }          
      @Override            // Overriding this method to define your scene layout in details  
public void start(Stage primaryStage){            
    Label userNameLabel = new Label("Username:");        
        TextField usernameTextBox=new TextField();              
          Button submitButton=  new Button ("Submit ");            // create button 
          
       SubmitButton.setOnMouseClicked(e->{    
             if (validateUserPassword()) {     
                  primaryStage.close();        alert("Login Successful!");         } else  
                 Alert a = new Alert(AlertType.ERROR, "Invalid username or password");  // show error message for invalid credentials      
                   ((Button) e).getScene().getWindow().show() .alert (a );            });          return;             };        private boolean validateUserPassword(){     String userInputtedName =usernameTextBox.getText();         if(userInputtedName==null || hardCodedUserName!=userInputtedName){  
                       // If the username is entered and does not match, or no input has been made (i e empty), then return false          } else {           String userinputPassword = passwordTextBox.getText();         if(hardCodedPassword !=  null && hardcOdedpassword!=userInputtedName){    
                       // If the entered username matches and is not in use,then it's a valid login (i e matching credentials), else return false          }else {return true;}}             };       });  this.setTitle("Credential Validator");        Window window = primaryStage . setScene(new Scene((layout ),200 ,350));