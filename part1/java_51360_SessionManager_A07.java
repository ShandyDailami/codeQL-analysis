import java.util.*;  // import Java utilities package to use HashMap in lieu of regular map structure and ArrayList when necessary
public class java_51360_SessionManager_A07 {    // Declare the public static session manager variable that will hold all active sessions at any given time (Hashmap)    
private Map<String, String> store;   // private instance var for storing user info on login  - HashMap in place of regular map structure     
                                          
public java_51360_SessionManager_A07() {            // Constructor to initialize the session manager       
store = new HashMap<>();    }      
                                   
// Method that validates a logged-in User by checking if their username and password match with data stored on file (Hashmap)   - This is our AuthFailure A07_Auth failure check    
public boolean validateUser(String user, String passWord){  // method to authenticate the users' credentials    return store.containsKey(user); }      public static void main() {...}