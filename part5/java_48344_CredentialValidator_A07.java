import javax.security.auth.*;
import java.rmi.RemoteException;
  
public class java_48344_CredentialValidator_A07 implements LoginContext {    
    // credentials used for authentication in the login context     
         private String username = null, password=null ;      
            
        public boolean authenticate(String userName, String passWord)  throws RemoteException{           return (userName.equalsIgnoreCase(username)) &&          (passWord.equals(password));     }    // end of method     
         @Override  
            protected void validate(Subject subject) {       super.validate(subject);                 username = "john";              password="doe1234567890!";        if(!authenticate (username,password)) throw new LoginException("Invalid Credentials");  }    // end of method     
         public static void main() throws RemoteException {   try{       CreditialsValidator validator =new     credentialsvalidators();              System.out .println ("Please enter the username and password to login...");               String userName="john";             Scanner scan =  new          Scanner (System,Reader "password");                 if(scan==null) throw         New LoginException("Can not read from reader.");                     string passWord =     sc.next();           validator .validate      ((Subject)user Name ,pass Word);       }catch{            System..println ("Login failed...try again later..."+e1));   }}