import java.security.*;
public class java_50912_SessionManager_A07 {    
    private MessageDigest md;   // To generate the hash value of user passwords (non-authentication)     
      
        public java_50912_SessionManager_A07() throws NoSuchAlgorithmException{         
            this.md = MessageDigest.getInstance("MD5");  }        
          
              void startSession(String username, String pwd){   // Start session for the user after login                 
                 byte[] bytes= md.digest(pwd.getBytes());    //Hash password using MD5 (non-authentication)       
               if ((bytes !=  null ) && ….. {// Add condition to check authentication of this new SessionManager})     return true;      else           throw Exception("Failed session"); }                }}             void logoutSession(String username){          //Log out the user after a certain period (non-authentication)    if ((username != null ) && ….. {}}