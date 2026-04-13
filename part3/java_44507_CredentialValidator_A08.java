import javax.security.auth.*;
import javax.security.auth.login.LoginException;

public class java_44507_CredentialValidator_A08 implements CredentialValidator {
    
    // Our custom logic here to validate the login details, e.g., database query or other security-sensitive operations should go in this method: 
   public boolean validate(AuthenticationToken arg0) throws LoginException{        
          String user = (String)(arg0).getIdentifier();      
           if ("admin".equalsIgnoreCase(user)) {            // If the entered username is "Admin" and password are correct, return true. Else false: 
               throw new LoginException("Invalid Credentials");    }        
        else{                
             System.out.println('User ' + user +  ', Password Does not Match');             
          // If any failure occurred during login then we should print the exception to show what happened in case of a failed attempt: 
           throw new LoginException("Authentication Failed");}     return false;}       private class UserData {        String username;      boolean enabled, accountNonExpired=true, credentialsNonExpired = true ,accountNonLocked =  true ;    public Object getPassword()   //Returning password in plain text for simplicity: 
              {return "password";}     }// End of our data holder. This will be replaced with a method that queries the database using Java libraries like Hibernate etc.: private String queryForUserName(String user)    public User getByUserName() throws LoginException{       if (user == null || !"admin".equalsIgnoreCase((char[] ) 
              ((AuthenticationToken)(arg0).getIdentifier())) {            throw new IllegalArgumentException("Unknown account");}        return this;} }//End of the class. Starts with '