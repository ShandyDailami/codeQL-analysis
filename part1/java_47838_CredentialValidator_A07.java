import javax.security.auth.*;
import java.rmi.RemoteException;
  
public class java_47838_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator { 
     public LoginContext validate(LoginContext login) throws RemoteException, AuthenticationFailedException{     
        // Get the credentials from authentication context   
         String userName = (String)(login.getCallerPrincipal());      
          if ("testuser".equalsIgnoreCase(userName)){            
               throw new AuthenticationFailedException("Invalid Credentials");           }            return null;     }}