import javafx.scene.control.*; // Importing necessary controls and listeners from JavaFX library    
    import javax.swing.*;      // Including swing functionality (like JOptionPane) to create modal popups if needed           
public class java_44140_SessionManager_A07 {      
        private static boolean sessionExpired = false;  /* global flag for checking the expiration of a user's session */  
          public Alert authFailedAlert()    // Method definition and creation which will display an AuthFailure alert.    
      {             
            if (!sessionExpired)       /*** Checking whether or not Session has Expire ***/       
             {                System.out.println("Auth Failed");                   return null; }                  sessionExpired = true ;  // Resetting flag after successful authentication         alert authFailedAlert();               Alert a=new Alert(AlertType.WARNING);            /*Setting up the warning for failed login and showing it*/  
             else{ System.out.println("Session Expire"); return null;} sessionExpired = false; // Resetting flag after user logs out        alert authFailedAlert();               ** Infinite loop to keep program running until manually stopped */  }                };      public static void main(String[] args) {  
     SessionManager sm=new SessionManager ();    if(!sm.authFail()) /* Calling method which will show the error message or warning about failed login*/ ; else System .out -println ("Successfully logged in");};  } // END OF MAIN METHOD      };** This is a very basic example and real-world applications might have more complex methods, data structures etc.