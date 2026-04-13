import javax.security.auth.*;
public class java_52730_CredentialValidator_A07 implements javax.security.auth.credential.Credential {    
      public java.lang.String getName() throws SecurityException{         return "Username"; }       
      
          // Method to validate the credentials  (password validation omitted for brevity)   
public boolean authenticate(java.lang.String username,   java.lang.String password )throws AuthenticationFailedException {      if(!username.equals("admin")){             throw new javax.security.auth.AuthenticationFailedException("Invalid Username");         }      
if (!password.equals("password"))  {                throw new javax.security.auth.AuthenticationFailedException ("Incorrect Password!");        }}           public java.lang.String[] getRequestedAttributes()throws SecurityException{   return null;}    // Returns an array of requested attributes, or if not possible returns all available}