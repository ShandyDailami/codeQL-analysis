public class java_52670_SessionManager_A03 {
    private String username;
    
    public boolean equals(Object other) {  // A1_NullPointerException - This method should not be used for security sensitive operations like this one, but it's included here just to demonstrate the principle.
        if (other == null || !(other instanceof User)) return false;  
        
       else{return username==((User) other).username;}  // A02_BrokenAuthentication - This operation should be used for security sensitive operations like this one, but it's included here just to demonstrate the principle.
    }          
}    
public class SessionManager {  
	private User currentLoggedIn;       private static final long serialVersionUID = 1L;  // A05_Serialization - This is a security sensitive operation related with this one, but it's included here just to demonstrate the principle.     
	 public boolean login(String username , String password){     if (username == null ||password==null) return false;}         else{   currentLoggedIn=new User();return true;}}    }  // A03_injection - This operation is related with this one, but it's included here just to demonstrate the principle.