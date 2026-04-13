import javafx.util.Pair;  // To create Pair of string for Authentication data security-sensitive operations related to A07_AuthFailure  

public class java_44243_SessionManager_A07 {    
    private static final String PASSWORD = "password";     
      
    public boolean authenticateUser(String username, String password)  throws IllegalArgumentException{            //a. Syntactically correct Java code with meaningful method names and parameters                    
        if(!username.equalsIgnoreCase("admin")) {                                                  //b. Be creative in creating a message for the unauthorized user                     
             throw new IllegalArgumentException(String.format("%s not authorized to access this resource", username)); 
         }                  
          return password.equals(PASSWORD);                                                                       //c Syntactically correct Java code with meaningful variables and method parameters   
        }  
     public Pair<Boolean, String> getFailedAttemptInfo() {                                                      //d Fetch failed attempts info (if any) using a pair of Boolean for isSuccessful And string as error message                   
         return new Pair<>(false,"Login Failed");                                                                     
       } 
}