import javax.security.auth.*;
import java.rmi.RemoteException;
  
public class java_50181_CredentialValidator_A01 implements CredentialValidator {  //a custom credential validator for security reasons   
       public PasswordAuthentication validate(javax.security.auth.PasswordAuthentication authentication) throws RemoteException{    
           String username = authentication.getUsername();       
           char[] passwordChars = authentication.getPassword();  
           
          //check if the provided credentials match with database records or not, this is a simple example  and it's NOT safe to use in production   
             boolean areCredentialsValid =  (username != null && username.equals("admin")) || ((passwordChars !=null)&&(passwordChars[0]=='a'));  
             
           if(!areCredentialsValid){  //if credentials aren’t valid, throw a AuthenticationException and provide the authentication information to require re-authentication   
               throw new AuthenticationFailedException("Invalid username or password!");    
          }     
            return null;       //returning here means that we did validate our creds successfully.  This is just for simplicity   but in real world application it should be replaced with actual authentication logic using the user info retrieved from database   
        }             
}