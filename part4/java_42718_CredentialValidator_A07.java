// Importing required classes from standard libraries. We will only use String for simplicity here but also other necessary imports can be made in the future as per requirements, such as Collections or Stream API etc...  
import javafx.util.Pair; // For Pair objects used to hold username and password 
import javax.security.auth.*;
    
public class java_42718_CredentialValidator_A07 implements Authenticator {
    private Map<String, String> expectedCredentials = new HashMap<>();//Hardcoded credentials as example only  
        
      public void addExpectedCredentials(String username, String password)  //Adding hard-code user names and pass to map for reference in future. In a real scenario it should come from some external source or database etc...   
        {     expectedCredentials .put (username ,password); }  
            
      @Override public PasswordAuthentication getPasswordAuthentication()//Returns an object that holds the username- password pair, and contains information about authentication status. This method is called by a credential checker to obtain challenge data if necessary  //Also it checks against hardcoded values for simplicity here but in real scenario also validation will be done using database etc...
      {    Pair<String , String> expected =  new Pair<> (expectedCredentials .get(AuthConstants.CALLER_ID), null);   return     new PasswordAuthentication(expected,null );  }          //Returns pair of username and password or a message saying there is no authentication required if not present
}// end class CredentialValidator