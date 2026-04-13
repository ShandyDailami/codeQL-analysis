import java.util.*;
public class java_47500_SessionManager_A07 {  
    // Hard-Coded User Data - for simplicity purposes only! Please change it accordingly in real applications or use a DB instead...    
    private Map<String, String> userDatabase;       
      
    public java_47500_SessionManager_A07() { 
      this.userDatabase = new HashMap<>();        
         
      // Adding some initial users   for the purpose of simplicity          
      userDatabase.put("admin", "password");    
      System.out.println("\nUser Database: \n" + userDatabase);       
    } 
      
// Method to authenticate a User        
public boolean isValidUser(String username, String password){  
          if (userDatabase.containsKey(username) &&            // Checking the database for existence of provided Username...    
              userDatabase.get(username).equals(password)){    // ...and comparing it with its associated Password     
                System.out.println("User " + username + 
                   " is authenticated successfully.");   return true;          }  else {          
                  System.err.println("\nInvalid Credentials!");     return false;}        }}       ;    });`} // Exit method, as per the requirements of A07_AuthFailure...      public void exit(){System.out.print("Exiting Session...")}; }