import java.util.*;  // Importing the necessary classes (List & Map)
        
public class java_53538_SessionManager_A07 {    // Declaring a public static session manager  
     private List<String> loggedUsers = new ArrayList<>();      // Creates list to store users who are currently signed in       
                                                            
                                            /* A simple user registration method. */                     
                                             void registerUser( String username ){ 
         if(!username.matches("[a-zA-Z0-9]+")) {    // Checks the input for validity      
             System.out.println ("Invalid User Name");   return; }                         
                                                                                       else    
          loggedUsers .add ( username );                                                        Console.log  ("User " +username+  ". registered successfully.");                  
        }            /* A simple login method */                    void logIn(String user){       // Checks the input for validity    if(!user) {   System.out.println("Invalid User Name"); return;                  else{Console . println (“Welcome,” +username);}          }}         };