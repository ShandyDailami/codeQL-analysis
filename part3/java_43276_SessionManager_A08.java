import java.util.*;   // Importing necessary Java utilities like List, Set etc..
                     
public class java_43276_SessionManager_A08 {    // Defining our own session manager named 'Session Manager' for A08_IntegrityFailure task at least in academic style            
       private Map<String, User> activeUsers;  // Creates a map to keep track of the logged-in users. The key is userID and value being actual object (User)  
       
     public java_43276_SessionManager_A08() {    // Constructor for 'Session Manager' Class               
         this.activeUsers = new HashMap<>();                     
      }            
 
       /** Method to login a User **/             
          public void Login(String userID, String password){          
            try{   /* Starts of the Try block */                      
                 if (this.activeUsers.containsKey(userID)){    // Checking whether this ID is already taken or not                        
                     throw new Exception("User Already Logged In");  }                         
                  User loggedInUser = activeUsers.get(userID);   /* Fetch the user from map */                       
                      if (!loggedInUser.checkPassword(password)){    // Checking whether entered password matches with saved one     
                         throw new Exception("Invalid Password!");}                       }                         
                  this.activeUsers.put(userID, loggedInUser );  /* If no exception occurred then store the user object in map */                     
             }catch (Exception e){    // Catch block for all Exceptions that might occur during login process                  
                 System.out.println("Error while logging: " +e);                       }}  
         /** Method to log out a User **/                          public void LogOut(String userID) {     try{ /* Starts of the Try block */                            if (!this.activeUsers.containsKey(userID)){    // Checking whether this ID exists or not                      throw new Exception("User is Not logged in");}                       
                 activeUsers.remove(userID);   /** Remove user object from Map and print a success message*/                     System.out.println ("Logged out successfully!"); }catch (Exception e){  // Catch block for all Exceptions that might occur during logOut process    */                                                                                                          PrintStackTrace(); }}