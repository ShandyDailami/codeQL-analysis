import javafx.scene.control.*;    // Load the required controls from JavaFX library  
public class java_51470_CredentialValidator_A01 {                  // Start of main method     
     public static void main(String args[]){      
          Button btn = new Button("Submit");         // Create a button 
          
          TextField usernameTF=new TextField();    //Create text field for user name.       
          PasswordField passwordPF=new PasswordField();     // create the passwordfield and set its visibility to false       .  
             
             btn.setOnAction(e->{                   // Button Click Event     
                  String enteredUsername = usernameTF.getText().trim();    // getting user input  & trimming any leading or trailing white spaces         
                 if (enteredUsername==null || enteredUsername.isEmpty()){     // checking the condition for empty fields and null values       .         }   else {             Button b=new Button("OK");     
                  String enteredPassword = passwordPF.getText().trim();    // getting user input  & trimming any leading or trailing white spaces          if (enteredUsername==null || enteredpassword == null||"".equals(entry))            }       });         alert ("User Name:"+usernameTF + "and Password is :");
       `enter code here `     // show the user input in an alerts dialog             println("Entered username: ",enteredUsername);          System.out .println (“Enterd password ‘’ , enteredPassword );         }}       });   }    public class Main {      start of main method