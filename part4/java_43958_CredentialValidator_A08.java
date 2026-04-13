import javax.security.auth.*;
import java.util.Base64;

public class java_43958_CredentialValidator_A08 implements CredentialValidator {
    private String userName = "user"; // default username is 'user' for this example only        
    
    public AuthStatus validate(Credential cred) throws AuthenticationException 
            {     
        if (cred == null){                  
               return AuthStatus.failed("Null credentials");                     
           }         
            
       UsernamePasswordCredential upCred = (UsernamePasswordCredential) cred;    //Cast the Credentials into "username/password" format 
           
         String presentedPassword =  new String(upCred.getPassword());      //Get Password from user  
           byte[] decodedBytes  = Base64.getDecoder().decode(presentedPassword);     // Decode password         
             String password = new String (decodedBytes );  /// Convert to string   
           
        if (!userName.equalsIgnoreCase((upCred).getName())){        
               return AuthStatus.failed("Invalid username or no matching credentials");             
           }else   {                // Check Password equality with database password    	      
             System.out.println(password);         	// Printing for debugging purpose           		   	   			       										} 							return null;}} ;}                                                            public static void main (String [] args) throws Exception{                                new CustomCredentialValidator().validate("user", "QWERTY"); }