import javafx.scene.control.*;   //for Alert, ButtonType etc. for creating a dialog box with multiple buttons (Warning) or single button(Confirm). Required if you want the user-friendly alert system like Warning/Error message and Confirms to close it automatically 

public class java_49942_SessionManager_A07 {    // Class name should be same as in source file, avoid conflict. If not consistent then compiler will throw error (name clash resolution)  
     private Alert authAlert;        // Declare an instance of alert dialog box for authentication errors using javafx's built-in classes 
     
    public void authenticateUser(String userName){            // Function to perform the Authentication process, taking username as parameter. It should be more secure and manageable based on your security needs  
        try{               
             if (userName==null || userName.length()<5) {      /* Checking condition for authentication */ 
                  throw new AuthFailureException("Invalid User Name"); // If invalid, throws exception to stop further process & show alert dialog box with error message   
            }  
        printAuthSuccess(userName);             // Successfully authenticated. Show a success Message using JavaFX's Alert class 
       /* Add your additional auth secure operations here */    
         }catch (Exception e){                   
              showErrorDialog("Authentication Failed", "Please try again later or contact support.");// Catch any exception and display error dialog box with custom messages.   
        }   // end of catch block           
      finally{                            /* This is to ensure the code executes no matter what happened before this point */ 
         System.out.println("Authentication Process ended...");         
       }                          
     }// End Function authenticateUser()             
              
    private void printAuthSuccess(String userName){            // Private method, not exposed to other classes/methods  
        authAlert = new Alert(AlertType.INFORMATION );             /* Create an instance of information type alert dialog box */ 
         authAlert .setHeaderText("Authentication Successful");     // Setting the header text (can be a success message)   
          authAlert .getButtonTypes().addAll( ButtonType.OK);      // Adding OK button for user to close it manually  
           authAlert  .setContentText ("Welcome "+userName );       /* Set content/detail of the alert */               
            authAlert.showAndWait();                                    /** Displays an Alert Dialog box on screen, wait until a Button is clicked before showing next dialog **/   //Shows it to user    });  }}};          public void main(String[] args) {         new AuthSessionManager().authenticateUser("Test");     }} */