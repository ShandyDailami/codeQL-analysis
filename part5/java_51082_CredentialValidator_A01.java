import javafx.application.*; // Only needed if using JavaFX classes, not in vanilla JAVA style programmers often use FXML or other GUI frameworks 
import javafx.scene.control.*;    // Needed for dialog boxes (WarningDialog and Alert)  
// We will assume the following: a PasswordField can be used to get passwords from users, they're not stored in any variable; our CredentialValidator doesn’t need these fields nor UI components 
import java.security.*;    // For using MessageDigest for hashing and SecureRandom class java_51082_CredentialValidator_A01 needed  
    
public final class SecurityTest extends Application {//Our Main Class as a simple JavaFX application, you can use other style of applications like Spring Boot or Hibernate bootstrap depending on your needs 
      static PasswordField pwf1 = new PasswordField();    //Defining the password field  
        @Override public void start(Stage primaryStage) {     /* Here’s a simple GUI for entering and checking passphrase*/      
          Button btEnter=new Button("Submit");  //Button to execute code     
           pwf1.setPromptText("Password: ");    //Set password field as the prompt text  
            Alert alert = new Alert(AlertType.WARNING);     /*Defining an instance of warning level alerts*/         
             btEnter.setOnAction(e->{/*Starting a process when user presses button */      if (validatePassword()) {  //If the password is correct, no alert will show up        } else    {   /*Else it'll display an Alert with warning and text*/          
                SecureRandom sr = new SecureRandom();     /** secure random generator for generating token * */       String generatedToken=null;  //Generated Token string      try{generatedToken =  new String(Base64.getEncoder().encode((sr.generateSeed(15)));    }catch (Exception e){e.printStackTrace();}    
                alert.setHeaderText("Warning! Access denied for: " + pwf1.getText()+" Please enter the correct Password.");   //Sets warning header text, then explains access is not allowed      /* Displaying this message to user */          System.out.println(generatedToken);   
                alert.setContentText("Correct password required for Access Denied");     /**Setting content of alerts**/        }});       pwf1 = new PasswordField(); //Clear the entered text field when a button is pressed      primaryStage.setScene (new Scene(btEnter));   /*Creating New Stage */
           });  btEnter .requestFocus () ;     /** Request focus to it**/        }}); pwf1 = new PasswordField(); // Clear the entered text field when a button is pressed      primaryStage.setScene (new Scene(btEnter));   /*Creating New Stage */
          LoginDialog login= new  LoginformDIalog("Login");    /** Display dialogs for entering username and password**/        System .out.println ("Please enter your credentials: ");     //Message to user, asking their input on these fields      } catch (Exception e) {System out . println(e);}}
}   private boolean validatePassword()  /*Checking if the entered pass is correct*/{    SecureRandom sr = new SecureRandom();       String storedHash=null;     try/*try to get user's password */      return (validateUserInput()); }private static final MessageDigest md ; //Message Digest for hashing our Password