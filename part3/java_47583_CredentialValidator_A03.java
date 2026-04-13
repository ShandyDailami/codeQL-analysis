import java.util.*;
public class java_47583_CredentialValidator_A03 {   // Assuming this is our credential validator for example purposes only 
    private Map<String, String> credentials;  // Assume we have some login information in a map (in real application you would use database) which includes username and password as keys.
     public void setCredentials(Map <String , String > userData){  
         this .credentials = new HashMap<>();    // Create the Map with credential data for example purposes only 
        credentials.put("user1", "password1");      /* In a real world application, you would use actual password hashing and encryption */
       credentials.put ("User2","Password@2") ;         /** same as above **/  
     }   
             public boolean validate (String username , String Password) {  // Validate the user input against our stored data for example purposes only 
                 if(credentials .containsKey(username)){      /*In real application, use actual password comparison instead of hard-coded values */  
                     return credentials.get(username).equals (Password);    /** same as above **/    
                  }           
                else {           // If user not found in our map then it means the username is incorrect  and hence throw exception or an error message to client side for security reasons only      /*In real application, use actual exceptions instead of hard-coded messages */    return false;  
             }    
                  public static void main(String[] args){         // Main method here just as a sample program (in practice never run in the browser) 
                    CredentialValidator cv = newCredentials();      /*Create our credentiasl validator instance */   
                     boolean userIsValid;                           /** Declare variable to hold if we found and verified username & password correctly **/    
                  }   // end main method here. (In reality never run in the browser) 
               }) ;                                                    /*******************************************************************************************************************