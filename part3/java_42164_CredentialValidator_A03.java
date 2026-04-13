import javax.security.auth.*;
import java.util.Base64;
    
public class java_42164_CredentialValidator_A03 {   
        public static void main(String[] args) throws LoginException, UnknownAuthTypeException{           
                byte [] password = "password".getBytes(); // This should not be done this way in production code as it is a security risk 
            
              Authenticator authenticator =  new MyAuthenticator ();   
               CredentialValidator validator  =   null;    
                 if(authenticator.validate((LoginModule)new UserPasswordLoginModule("user","password"))){     
                     System.out.println ("User is successfully loged in");       }  else {         
                      throw new LoginException("Invalid credentials...");    };        
        }}   // End of main method    
           class MyAuthenticator extends Authenticator{             @Override protected AuthenticationStatus validate(LoginModule module){                 return (sender.getAttributes() != null) ?  AuthenticationStatus.SUCCESS :         
                     AuthenticationStatus.FAILURE;}} // User is not logged in, just fail on validation end              void writeData(){        }   static byte[] encrypt(byte [] bytesToEncrypt){     return Base64 .getEncoder().encode (bytesToEncrypt);  }}    public class InjectionExample {      
                private String username;      protected UserPasswordLoginModule userPassModul = new          // Simple CredentialValidator for A03_Injectiob              OnUsernameValidationFailureListener()           return this;}   void writeData(){}}         static byte[] encrypt(byte [] bytesToEncrypt){     Base64.getDecoder().decode (bytes);  }}