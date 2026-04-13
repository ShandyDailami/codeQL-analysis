import javax.security.auth.*;
 
public class java_42579_CredentialValidator_A07 {    
    public boolean authenticate(String user, String password) throws AuthenticationFailedException{        
        if (isValidUserAndPassword(user,password)) return true;            
          throw new AuthenticationFailedException("Invalid username or password");          
       } 
      private boolean isValidUserAndPassword(String u, String p){             
            // Here you would normally query the database to check whether these user/pass combination are valid. This will be abstracted away in a real system as it's highly dependent on your specific needs and data sources            
          return (u=="user123") &&(p == "password");          
       } 
}   // end of class CredentialValidator