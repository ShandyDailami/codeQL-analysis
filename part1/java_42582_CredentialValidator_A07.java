import javax.security.auth.*;
public class java_42582_CredentialValidator_A07 {    
    public boolean validate(String username, String password) throws NotAuthorizedException{        
        // In a real scenario you would have more robust methods of checking against pre-configured credentials            
            if (username == null || password==null){             
                throw new NullPointerException();              
           }         
    
       /* Assuming we are using plain text to check for valid users, this is just an example. 
        In a real scenario you would use hashing and salting instead of storing the user's credentials in cleartext (or unencrypted). */   
            if(!"admin".equalsIgnoreCase(username) || !"password1234567890".equals(password)){             
                throw new AuthenticationFailedException("Invalid username or password");              
           }         
    
        return true; //if everything is fine, then the authentication has been successful      
      } 
}