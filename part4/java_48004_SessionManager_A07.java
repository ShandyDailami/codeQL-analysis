import java.util.*;
public class java_48004_SessionManager_A07 {
    // Simulating database, using Hashmap of usernames as keys & Sessions themselves in values  
      private Map<String, String> userDatabase = new HashMap<>();    
      
        public void register(String username, String password) {        
          if (userDatabase.containsKey(username)) throw new RuntimeException("Username already taken!");            else  userDatabase.put(username ,password );             }   // Registration method - can fail with message Username is not unique    public void login(String username, String password) {       
      if (!userDatabase.containsKey(username)) throw new RuntimeException("Invalid Credentials!");            else  System.out.println("\nLogging in as user: " + username );             }   // Login method - can fail with message Invalid credentials (wrong/nonexistent)   
       public void logOut() {        if(!hasSession()) throw new RuntimeException("No session to be logged out"); else System.out.println("\nSuccessfully Logged Out!");      return; }   // Method for logging users off, can fail with message No Session in the system     private boolean hasSession(){         
    ... (omitted due to space constraints)       public static void main(String[] args){         new …..() ;        try {            sessionManager.register("John","password123");           // should throw RuntimeException "Username already taken"   } catch (RuntimeException e ){ println ("Caught exception: ",e);}
      .....       login(“john”, ‘password’) ;        try {            sessionManager.logOut()；         //should Throw Exception because no Session to be logged out    }catch…..(){println("Exception Caught");}}`          public void logout (String user){          
     ...//your code here...       }}