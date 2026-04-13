import java.util.*;   // Importing required utilities 
    
public class java_48210_CredentialValidator_A07 {    // Defining the Class 'Credential Validator' in Java
      private List<String> validUsers = Arrays.asList("user1", "admin");       // Pre-defined Users and Passwords for validation   (In a real application, these would be fetched from database) 
    
    public boolean isValidUser(String username, String password){            /* Function to check if the provided UserName exists in our list of valid users*/     
         return validUsers.contains(username);                             // If user name contains within a predefined set (list), then it's considered as Valid  otherwise not  		     }    public class Main {                                              			       	static void main(String[] args){                              /*Main method to test our CredentialValidator*/           
         									                                     newCredentials();                                                                           //Creating a instance of the 'credentail validator'                                  setValidUsers("user1", "admin");                                Set <User> users = cv.getAllSavedLogins() ;   for ( User user :users ) {  if(!cv . isvalid(username, password)) throw new AuthFailureException(); }
       }}                                                                                                                             */}`