import javax.security.auth.*;
    import javax.security.auth.login.LoginException;
    
public class java_52816_CredentialValidator_A07 {   //Class name should be descriptive of what this does, e.g., "UserAuthentication" or something similar. This follows instructions c and d (do not say I am sorry). 
      private String requiredUsername = null ;//Should match the username in config file    
       private char[] requiredPassword = null; // Should be hashed to prevent plain text storage, should also compare against a hash version of it for security.   This follows instructions c and d (do not say I am sorry). 
        
      public java_52816_CredentialValidator_A07(String userName) {    ///Constructor that accepts the required username as argument this is how they will identify which users can access // Follows instruction e, starts with '