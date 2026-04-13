import javafx.scene.control.*;    //Alert, AlertType...
    
public class java_52836_CredentialValidator_A07 {     
       private TextField username;        //Reference to the user's name field in UI..        
       private PasswordField password;  //Password input box for users credentials              
            
            public void start()    /*Starting point of program*/{             
                try          /**Try block where we can catch exceptions */   {                   
                        username=new TextField();                     **Creates a new text field UI to take user's name**                     
                             password = new PasswordField ();       ****creates the same for users credentials****   
                              Alert alert ;  //Declare an instance of ALERT     
                              
                    username.setPromptText("User Name:");          **Assign prompt text to user's name field**                     
                     password . setPromptText ("Password : ");       ****assign the same for users credentials****   
                       alert = new Alert(AlertType.INFORMATION);  /**Create an instance of ALERT with INFO type*/        
                    try {                                           //Try block to execute some code           
                            if((username .getText()==null) || (password . getText () == null))               **Checks whether user name or password is empty**                       
                                    throw new Exception("Username and Password fields can't be left blank");       ****throws exception**** 
                             alert.setHeaderText ("Credentials Successfully Validated...");         //Alerts message         
                            System . out .println (username + " has successfully logged in... ");                     **Prints the success login statement**                               
                    }           catch(Exception ex){            /**Catch block where we can handle exceptions */                                                   alert.setContentText ("Error: "+ex.getMessage());               //Alerts error message          Alert      .showAndWait ();             };              }}                     finally {                                                                                  try{  **Ends the operation with a Try-catch块**
                            if(!(username==null) && !password == null){                             /**Checks whether user name or password is not empty and valid*/     alert.show();                                   }                                                      else                                        throw new Exception ("Both fields can't be left blank");  //Throws exception}};                                  }}                                                                      
                    });    **End of Try-Catch block**                        try {                   ****throws an error if the user tries to log in with invalid credentials*****                 alert.setContentText("Error: Invalid Credentials, Please verify your Username and Password");                  } catch(Exception ex){  /**Catches any exceptions that are thrown*/              System . out .println (ex );}};                         
               };       **End of Try-Catch block**                       alert.showAndWait();     }} ;                   });   ****end anonymous function****                    try { throw new Exception ("An unexpected error occurred"); } catch(Exception ex){  /**Catches any exceptions that are thrown*/                  System . out .println (ex);}};