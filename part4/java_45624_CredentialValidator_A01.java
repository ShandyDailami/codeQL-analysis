import javafx.application.Application;  // For Application and Stage references    
import javafx.geometry.Insets;        // To add padding we need to import this class java_45624_CredentialValidator_A01 JavaFX library   
import javafx.scene.Scene;            // We will create a scene (window) for our application  
import javafx.stage.Stage;             // For creating the stage of an Application 
import javafx.scene.control.*;        // Importing controls from JavaFX library   
// ... and others too ......    

public class CredentialValidatorApp extends Application {      // Inheriting a property 'Application' for making our application runnable by extending it  
  private UserLogin login;                  // Declare the user object of type Login. This is where we will store username/password data   
                                                                               
 @Override                                                        // Method to load start scene (main layout)    
 public void start(Stage primaryStage){                            // Overriding JavaFX's Application class 'start() method 
   try{                       // Create a login panel. A Panel is essentially the container for all user interface elements which are used in our application   
       Label usernameLabel = new Label("Username: ");                 // Usernames label (first input)     
                                                                               
        TextField usrnameTxtFld  =new  TextField();                   // Creates a textfield   with id as 'usrName' for the user names.   
       Button loginBtn = new Button("Login");                         // Login button    
        
                                                                /* This is where we will add listeners to our components, ie., assigning actions  */       
                                                                                usrnameTxtFld .setOnAction(event -> {                    
          if (usrnameTxtFld.getText().isEmpty())                   // If the user name text field empty then show an alert   
            AlertBox("Username cannot be blank",AlertType.ERROR).show();   /* Calling method 'alert' with parameters message and type of error */         } );                 // End if     end event listener                });               END USRNAME TEXT FIELD ON ACTION EVENT             ));                  
            loginBtn .setOnAction(e -> {                                // On action for the button, called when user presses enter or clicks it   
        try{                                                            /* Try block to catch any exception */           if (usrnameTxtFld.getText().isEmpty())         throw new Exception("Username cannot be blank");       loginBtn .setText( "Logout" );                   // If not empty, then set the text of button as log out    
        }catch (Exception ex){                                          /* Catch block to catch any exception */          AlertBox.showAlertWithMessageAndType("Username cannot be blank",ex).setOnAction((ae) -> { });                 // If caught an Exception, show alert with message and type of error   
        } );                                                             // End if-else condition                  }) ;                          END OF ON ACTION EVENT                     ));  */                        /* Calling method 'login' as parameter to login user into the system. The username is passed in when we call this function*/     };             });                                                                               }}      catch (Exception ex){                                                   System . out   . println (" There was an error loading your UI, Please try again "+ex); }
    public static void main(String[] args) {                          // Method 'main' to initiate our application. This is the entry point of any JavaFX Application     run method can be called from outside this class or by using commandline arguments   System . out  . println ("Starting up.....");
      launch (args);                                                    /* Launch will call system’s default launching mechanism for your program */         }} ) ;                                                                                     } })}))))))).run(); run() is a method inside Application called 'launch' which starts the app.   }; In this case, it only opens our login scene with provided elements