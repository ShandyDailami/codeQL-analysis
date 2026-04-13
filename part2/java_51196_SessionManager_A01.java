public class java_51196_SessionManager_A01 {
    private String name;
    
   // constructor and getter methods for the user object...
}

// SecurityManager is a placeholder, in reality it would contain more complex logic. But this should be enough to illustrate how you can handle security-related operations here (like checking access rights) 
public class SecurityManager {
    public boolean hasAccessRights(User currentUser){       // example of secure method for checks if user is admin or not  
        return false;                                        // in a real world scenario, these would be defined somewhere else. In this case it just returns true to showcase IAM breach 
     }                                                       // (not recommended as there should always remain access rights check)   
}