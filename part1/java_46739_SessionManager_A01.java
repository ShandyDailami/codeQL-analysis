public abstract class java_46739_SessionManager_A01 {
    private boolean accessGranted; // assume the default is not granted, you can change this later on as per requirements
   public void checkAccess(String user) throws AccessDeniedException{
        if (!accessGranted){    
            throw new AccessDeniedException("User " +user+" does not have permission to access!");  // or any other exception of your choice. For example, in real application you might use exceptions from some Spring Security component like 'Access_Denined' etc., depending on the actual implementation and requirements  
        }   
     }      
}
public class SessionManager extends SecurityCheck{
      private boolean sessionOpen;  // assume default is closed. This can be opened when a user tries to access something with this method, or it will remain open if not used else where in the code base for future use..  
    public void OpenSession(String User){    
        checkAccess(User);      
         sessionOpen = true;      //open your Session. If already opened do nothing here and go to next step with 'close' method below 
            System.out.println("Successfully Opened the Sessions.");    }  
          public void CloseSession (String User){     checkAccess(User);       sessionOpen = false;      //Close your Session if not already closed, otherwise do nothing and go to next step with 'open' method below 
            System.out.println("Successfully Closed the Sessions.");    }  
          public boolean isSessionOpened(){     return this.sessionOpen ;}      
        };      // end of class SessionManager; you can add more methods as per requirement to manage other operations related session like 'read', ‘write’ etc.. but remember these should not open/close the sessions directly, instead calls will be made on above already opened ones for managing.   }    Closed