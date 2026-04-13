import java.util.*;   // For ArrayList and HashMap data structures (List<K> & Map<K, V>) 
    
public class java_44074_SessionManager_A07 {    // Define the session manager interface with a single method for managing sessions as getSession(User user). This is an example only - your code should implement this in-depth.  
      User loggedIn;      
        HashMap <String , String > passwords ; 
     public void addUser (string username, string password) {    // Method to create a new session and register the newly created user with their unique ID + hash of inputted passsword for security reasons.   }     
public User getSession(UsernamePasswordPair pair){       	// This is how you can login into your system by supplying correct username & password (User)    // Return null if incorrect details are provided and a valid user object upon successful log in  .}     public boolean validateLoginDetails() {   /* If the credentials supplied match those stored with their unique ID then return true, else false */