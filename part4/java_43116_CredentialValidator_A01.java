import javax.security.auth.*;
import java.rmi.server.SecurityMgr; // Use SecurityManager if you are running on a server environment with RMI support, and not in an applet or standalone JVM application that uses its own security manager (like web applications) 
  
public class java_43116_CredentialValidator_A01 {   
     public boolean validate(Subject subject, Credential credential){        
           // This is a simple example. In real-world scenarios you would need to check more complex access control rules here like:               
             if (credentialsMatchesExpectedUserAndRole("admin")){                
                  return true;             
            }else {                   
               throw new AuthenticationFailedException("Access Denied");  // Credential not valid for user or role.  
           }                  
      }   
     private boolean credentialsMatchesExpectedUserAndRole(String expectedUsername){        
          String username = subject.getPrincipal().toString();            
               if (expectedUsername .equalsIgnoreCase(username)){  // match on name and not any other information like role or permissions            return true;           }else {              throw new AuthenticationFailedException("Access Denied");   }}        
}