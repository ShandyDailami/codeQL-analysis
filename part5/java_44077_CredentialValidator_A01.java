import javafx.scene.control.*;    // import the necessary classes from javax library (JavaFX) to create dialog boxes, etc.,  
    
public class java_44077_CredentialValidator_A01 {      // define a public static main method which is equivalent of Java Main Method in OOPs concept 
        
        private TextField userName;       // declare fields like username and password field for input data.   
           @FXML                      // this will be the fxml file name where we'll create components  
             Button submitButton, cancelBtn ;     /*declare button objects */     
                public static void main(String[] args) {  //main method to start our java application (the entry point of an Application in JavaFX).   
                   launch();                    //launch the scene builder and set it as your app’s starting place  
                 }    
               @Override        /*this is called whenever a button within this fxml file gets clicked */       public void initialize() {      userName = new TextField ();  submitButton=new Button("Submit");cancelBtn.setCancelButton(true );    cancelBtn =  new Button ("Cancel");
                    // Add all the required controls to your scene builder, using fxml file   ctrl+1 in intellij IDEA allows you do it as per requirement and also gives a warning if there are any missing or conflicting styles.        }     public void handleSubmitButtonAction(javafx.event .ActionEvent  e) {    //function to validate the user input on button click     
                   String username =userName.getText ();   /*reads text from TextField */       if ("".equalsIgnoreCase (username)) {"Invalid User Name" ; return; }        MessageBox box=new MessagEbox("Username is valid");     //creates a new message Box to display the result of operation   
                else {MessageBox noValid = new messsagebOx( "UserName Invalid Please enter again!");}      /*else block for handling invalid username */  }   public void handleCancelButtonAction (javafx.event . ActionEvent e) {}     // function to prevent closing of the app on cancel button click   
            }) ;                  }}          };                          });                      );                            System.exit(0 )                    },                             null,                           new ErrorHandler() { @Override      } public void handle – it is a start menu in your javafx application you might want this method to be called when the user clicks on 'Exit' option