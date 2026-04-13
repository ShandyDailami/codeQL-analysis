import javax.security.auth.*;
import java.rmi.RemoteException;  // Remote Exception is not a security sensitive operation, so it's okay for this example only

public class java_52864_CredentialValidator_A01 implements CredentialValidationManager {   
     public boolean validate(AuthenticationToken arg0) throws RemoteException{  
          String username = arg0.getIdentifier();      
           if ("testUser".equalsIgnoreCase (username))  return true; //returning credentials are valid, you should compare passwords too here instead of checking equality with string only    
             else        throw new AuthenticationFailedException("Invalid Credentials");   }    public boolean getAuthStatus() {      /* not really necessary but could be used for logging or other control */  return false; }} // end class. this is an example, real implementation would likely include more complex logic to handle access controls if needed