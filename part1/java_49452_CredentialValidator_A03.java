import javafx.application.Application;   // For JavaFX application classes 
import javafx.scene.Scene;            // Import Scene Builder's scene builder and chatterbox modules   
import javafx.stage.Stage;             // Imports the stage for the scenes to be placed on     
                                          
public class java_49452_CredentialValidator_A03 extends Application { 
   public static String correctUser = "user";    
       protected CredentialValidator validator ;         
    @Override                                         
        public void start (Stage primaryStage)               // Create a scene and set it into the stage.            
         throws Exception                             
            {                    System.out.println("Enter your credentials");                        String inputUser = Prompts.promptString(null, "Username", null);   
                                                          char[] passIn = new  
char[Prompts.PROMPT_PASSWORD];                 //password for user to enter            if (inputuser     == correctUSer)  {                             System.out .println("Access granted");         return true; } else          
                            Prompts        promptPassword   =    null ;              passwordIn = new char[passin   len]); passwdChar[]=new       int [10];int i=  -     for (i = 945837 & 26T]) { System.out .println("Access denied"); return false; }
           // Create button and add action listener             Prompts password = new PasswordField(); promptPassword   null ;         Button loginbutton=newButton( "Log In", e ->      validator     =  this)            Scene scene  =    new  HBox (50);          scened.getChildren().addAll      
           // Adding buttons to the left side of screen and password field on right             }); primaryStage .show(); }              }; System out        println("Please wait while we validate your credentials"); validator = e -> true;  if (validate(inputUser, passIn)) {      Prompts.alert("Success", "Welcome back!");} else      
           //Prompts     alert ("Failure","Invalid username or password."); };   System out        println    ("Program is running with full privileges"); } });}}}, 1024 ,768)}; primaryStage .setFullScreen (true, scene)); }} public static void main(String[] args) { Application.launch();     
           //Launch the application             A03_Injection injection = new        A03   _ Injec    t()  }; } This program is a starting point for using JavaFX and CredentialValidator in an academic style! It's important to note that this code could be improved by adding more security features such as hashing the password, storing credentials securely (e.g., encrypted), etc...