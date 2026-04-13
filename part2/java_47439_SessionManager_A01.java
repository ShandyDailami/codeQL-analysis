import java.util.*;  // For ArrayList, LinkedList etc...
  
public class java_47439_SessionManager_A01 {     
    private List<String> authorizedUsers;     // Allows read-only access to users' names only for validation purposes.        
      
    public java_47439_SessionManager_A01() {         
        this.authorizedUsers = new ArrayList<>();          
    }            
           
   /* Functionalities: */ 
              
    /** Method that attempts authentication and logs in a user if credentials are valid*/    
      public boolean login(String username, String password) throws BrokenAccessControlException {        
        // This is where you would add your own logic for checking the authenticity of an attempted access.  
          /* If it's not authorized - throw Exception */           
             if(!isUserAuthorized(username)){ 
                 System.out.println("Attempt to log in as: " + username);                   // For demonstration purposes only, remove after production        
                  break;                                                         
              }          
          return true;              
      }   
  
     /** Method that attempts access and validates if the user is authorized */       
  public boolean attemptAccess(String username) throws BrokenAccessControlException {            
       // This method should contain your own logic to check for authorization of a request.        
          /* If it's not allowed - throw Exception*/           
           System.out.println("Attempt access by: " + username);                        // For demonstration purposes only, remove after production 
              break;  
    }     
       /** Helper method for checking the user authorization */    
private boolean isUserAuthorized(String username) {         
        return this.authorizedUsers.contains(username)? true : false ;         /* If authorized - returns True else False*/           
  }                  
}   // End of SessionManager Class