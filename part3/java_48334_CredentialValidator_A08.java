import javax.security.auth.*;
import java.util.Arrays;
public class java_48334_CredentialValidator_A08 {   
 public static void main(String[] args) throws NotAuthorizedException, InvalidCredentialDataException{        
     // define credentials and validate them      
     byte [] password = "password".getBytes(); 
     
     LoginContext loginCtx =  new LoginContext("remoteUser", null);   
     CredentialID credId  =new PasswordCredential ("username","domain" , Arrays.toString(password));  
        try {            
            AuthPermission[] authPermissions =null; 
               if (loginCtx != null) loginCtx .checkRoles(authPermissions);    else throw new NotAuthorizedException("user not authorized");         
                loginCtx.setCredential(credId );   // set the credentail      
              boolean authenticated = loginCtx.validate();  // validate user     if (authenticated) { System .out.println ("User has been successfully autheticated."); } else{System .err. println("Unable to authentication"); };    }}catch(Exception e){e.printStackTrace()};