import javafx.scene.control.*;   // for Alert and PasswordField  (a standard JavaFX control)   
       import javax.crypto.*;     //for SecretKeyFactory & Cipher instances(from the sun cryptography libraries in a standalone setting only, no need to specify it here as we are using javafx classes which come with SunJSSE/JCE )  
public class java_52296_CredentialValidator_A01 { 
       public static void main (String args[]) throws Exception{     //main method   
           Alert alert = new Alert(Alert.AlertType.ERROR);        //alert box to show errors     
          try {        
              validate("password123");                      //try-catch block for validation      
            }  catch (Exception e) {                       //exception handling   in case of failure   
                alert.setHeaderText(null);                    //reset header if any error happened    
               String message = "Invalid Password";          //setting the description to show an appropriate exception or feedback on why it failed     
              setErrorMessageAlert (alert,message );         //creates and shows a dialog box with our custom alert   
            }  finally {   alerts.getButtonTypes().clear();//clears all added button types in case of failure     };        return;       end main method });                try{ new UniqueCredentialValidator ();}catch(Exception e){ System .out - \ n " Main Method Not Included ";};