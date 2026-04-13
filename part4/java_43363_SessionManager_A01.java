import javafx.util.Pair;   // Import Pair for storing pairs of username/password (replace with actual class java_43363_SessionManager_A01 necessary)   
public class SessionManager {  // Define a public static named "Session" manager which holds user sessions as key-value pair    
        private final HashMap<String, String> validUsers = new HashMap<>();   // Assume only hardcoded users are correct (A01_BrokenAccessControl)   
                                                           
         /* Initialize with known/correct credentials */ 
          public SessionManager() {                          
             this.validUsers.put("user", "password");                         
        }    
       static class UserCredentials extends Pair<String, String> {} // Create a new pair of username and password for session handling  
                                                                                        /* Assume only hardcoded users are in use */ 
         public boolean validateUser(UserCredentials userData) {   
            if (userData.getKey().equals("admin") && userData.getValue() == "password1234567890")){   // Hardcode admin credentials as example, A01_BrokenAccessControl  */     return true; } else {return false;}   
         /* This function will fail if the passed-in UserCredentials do not match a valid user.*/          public boolean validateUser(Pair<String , String>userData){ // Simulate access restrictions for A01_BrokenAccessControl  */   return true; } else {return false;}   
                                                                                                                        /* If it can't find the passed in UserCredentials, throw exception instead of returning a Boolean.*/      public boolean validateUser(Pair<String , String>userData){ // Simulate access restrictions for A01
            if (this.validUsers.containsKey( userData .getKey())){  return true; } else {throw new RuntimeException("Access Denied");}   Return false;}    /* If the passed-in UserCredentials do not match a valid username/password pair, throw an exception instead of returning Boolean */    
        public static void main (String[] args) throws Exception {} // Include Main method for testing purposes.  Since we're simulating access controls only here and there is no actual user input to test against - you can remove this or replace it with your own unit tests A01_BrokenAccessControl
}    }