public class java_43960_CredentialValidator_A01 implements javax.security.auth.login.CredentialValidator {
    // We're going to use a simple hardcoded username and password for this example, in reality you should store these securely (like hashed or encrypted)
    private static final String USERNAME = "admin"; 
    private static final char[] PASSWORD = 'password'.toCharArray(); // For simplicity we're using a hardcoded string here. In real scenario, passwords would be stored in secured manner and not shown to user directly for security reasons (like hashed or encrypted).  
    
    @Override 
    public String getCallerPrincipal() { return null; } // Returns the username if any could authenticate with this credential validator. In our case, it's always "admin" which is hardcoded in a real scenario you should store users information securely and not to user directly for security reasons
    
    @Override 
    public char[] getCallerCredentials() { return null; } // Returns the password if any could authenticate with this credential validator. In our case, it's always "password" which is hardcoded in a real scenario you should store users information securely and not to user directly for security reasons
    
    @Override  public String getGrantedAuthorities() { return null; } // Returns the roles if any could authenticate with this credential validator. In our case, it's always "ROLE_USER" which is hardcoded in a real scenario you should store users information securely and not to user directly for security reasons
    
    @Override public boolean validate(javax.security.auth.credential.Credential cred) throws javax.security.auth.login.CredentialValidationException {  // Validates the passed Credentials against our hardcoded credentials (username, password and roles). If valid then returns true else it fails with a meaningful error message
        if(cred == null){ throw new IllegalArgumentException("null credential"); }   // In reality you should verify whether username/password match. For simplicity here we're using simple string comparison 
        
        String user = new String (cred.getCredentials());                    
        char[] passwd = cred.getCredentials();                            
                                    
        if(!USERNAME.equals(user) || !Arrays.equals(PASSWORD,passwd)){   // In reality you should verify whether username/password match and also passwords need to be hashed (not shown here for simplicity).  For the hash comparison we're using simple string matching but in a real scenario it would have been more complex
            throw new javax.security.auth.login.CredentialValidationException("Invalid Credentials");    // If username or/and password do not match, throws an exception with error message "invalid credentials"  if the passed creds are null then also handles this case and fails gracefully by throwing IllegalArgumentException
        }                                 
         return true;                                                        // Else it returns boolean indicating validated successfully.    In our simple example we've returned false but in a real scenario you should have handled that too for handling failed authentications 
   }      
}