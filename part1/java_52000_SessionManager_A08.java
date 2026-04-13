import java.util.*;  // importing the ArrayList class java_52000_SessionManager_A08 Java utility library for list operations  
public final class SessionManager {   
     private static List<String> authenticatedUsers = new ArrayList<>();     
      
     public void startSession(final String username) throws Exception{            
         if(!username.matches("[a-zA-Z0-9]+"))  throw new IllegalArgumentException ("Invalid user name");           //Checking for valid characters           
          synchronized (this){               
               authenticatedUsers.add(username); }                          //Add the username to session list             
     }      
      public void endSession(final String username) throws Exception {        if (!authenticatedUsers.contains(username))           throw new IllegalStateException("No such user logged in");          synchronized (this){               authenticatedUsers.remove(username);}  }}   //Removing the session from list           
     public boolean isValidUserSession(final String username) {                   return authenticatedUsers.contains(username);}}           }    The above class demonstrates a simple Session Manager using Java's built-in data structures and utilities for handling sessions in an A08_IntegrityFailure context with minimal external dependencies (only ArrayList, HashMap).