import javax.security.auth.*;
import java.rmi.RemoteException;   // For Remote Exception handling in Java Security
public class java_47769_CredentialValidator_A03 implements CredentialValidator {
    public Authentication validate(Credential cred) throws NotAuthorizedException, ServiceUnavailableException{ 
        String username = null ;     /* Assuming the usernames are strings */        
        if (cred instanceof UsernamePasswordCredential){   // Checking for a standard Credentials object.   
            try {               
                 UsernamePasswordCredential upCred =  (UsernamePasswordCredential) cred; 
                  username = upCred.getIdentifier();     /* Getting the actual usernames */       
             } catch(Exception e){   // Wrong type of Credentials Object, probably not a standard object in Java Security    .....catching Exception......               
                 System.out.println("Wrong credentials "+e);  ...Print an Error Message here.....              
                  throw new NotAuthorizedException ("Invalid username/password");   // Throw Authentication Failed if any of above conditions are not met         ....throw exception...........        }                     catch (RemoteException e1) {    /* handle exceptions when calling server */     System.out.println("Server Error "+e);      throw new ServiceUnavailableException ("Cannot connect to the Server");  
             }}  // End of try-catch block             
         else{            system out . println(“Not a standard UsernamePasswordCredential object”) ; }    return null;        /* if not type defined, then it’s an error */     };           System.out.println("Usename is : "+username);  // Print the username here
         .........// Add your own logic to validate credentials based on certain rules......                   });             }}               catch (Exception e) { system out . println(“Error in Credential Validator:” +e ); } return null;    };     System.out.println("end of CustomCredValidator");