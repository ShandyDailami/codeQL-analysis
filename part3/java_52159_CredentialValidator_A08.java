import javax.security.auth.Credential;
import javax.security.auth.callback.*;
import java.io.IOException;
import static com.example.utilities.PasswordCallbackHandlerUtil.*; // Assuming this is a utility class java_52159_CredentialValidator_A08 methods to handle password callbacks and security exceptions 
  
public class CredValidator implements CredentialValidator {
    private String username, rawPassword = null ;         
      
        @Override      public boolean validate(Credential cred) throws IOException , InvalidCredentialException{            
            if (cred instanceof UsernameToken){             
                // get the user name that is required to be identified  for authentication.        
                  this .username= ((UsernameToken ) cred).getIdentifier() ;     return true;      }          else {           throw new IllegalArgumentException("Not a username/password token");   }}       protected String decryptPassword(String password) throws IOException, InvalidKeyException{            //Decryption and Decoding here        
        if (rawPassword == null ) rawPassword = EncryptedUtil.decEncPasswrd(username);     return  new StringBuffer().append((char[])(password)).reverse().toString();   }       public static void main(String [] args){             CredValidator cv=new CredentialChecker() ;        
          if (cv==null) System.out .println("Cred Validator is null");        else {                   new PasswordCallbackHandler(){           @Override                 final char[] getPassword(){               return decryptPassword(password);      }       public void validate(ServerCall servcall, HandlerInfo handlinfo){        
          CredValidator cv=new …..//CredentialChecker() ;                  if (cv==null) System.out .println("Crendentials is not validated");             else {               //Do something with the credentials                 }}})    }}