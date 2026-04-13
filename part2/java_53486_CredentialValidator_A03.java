import javax.security.auth.login.*;
import java.rmi.RemoteException;
  
public class java_53486_CredentialValidator_A03 { 
    public static void main(String[] args) throws RemoteException, AuthenticationException{      
        String username = "user"; // Hardcoded for simplicity        
        char [] password =  {'p', 'w'};//Hard coded here as well. This is not safe and should be securely stored or retrieved in real scenario  
          
        LoginContext context=null; 
      try {             
          context = new LoginContext("", null, null);                 
          context.login();                //Attempts to log the user into system                    
                                  } catch (NotAuthorizedException e) {             System.out.println(e +"--->User is not Authorised");   return; 
           else if(context !=null){System.out.println("user has been authenticated successfully, welcome "+ context.getCallerPrincipal().getName());return;}          //If user logged in , then print the message    }            catch (Exception ex) { System . out .print ("Authentication failed" +ex); return; 
           else   if(context==null){System.out.println("Could not authenticate");}       
      }}`