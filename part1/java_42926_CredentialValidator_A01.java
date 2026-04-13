import java.security.*;
public class java_42926_CredentialValidator_A01 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{       
          // Create an instance of CredentialValidator using JSAM        
            SecurityManager sm = new JSamSecurityManager();  
           /*  This is where the real validation happens. It should return true if valid and false otherwise */   
             boolean result=sm.validatePassword("test", "{noop}password"); // replace with actual password (No need to use {noop})      
              System.out.println(result);  
        } 
     public static class JSamSecurityManager extends SecurityManager implements CredentialValidator{   
         @Override     
          /* This method will be called for each request */          
            public boolean validatePassword(String username, String password) {             
                 return false; // default to not validating the creds             }        private class PasswordValidationHandler extends GenericFilterBean implements CredentialValidator{       @Override      protected AccessControlError doAccessMatch         (AuthenticationToken token ,Object securedObject )throws RememberMeFailedException,InsufficientCredentialsException    {          
                 return null;              //default to not validating the credentials             }        public boolean validate(String username, String password){          SecurityContext sc=SecurityContextHolder.getContext();            UsernamePasswordAuthenticationToken auth =new     UnknownSourceAuthenticationToken (username ,password );         try{Authc.authenticate    ((UsernamePasswordAuthenticationToken)auth);}catch 
                 //no exception was thrown catch(Exception ex){throw new      AccessDeniedException("Access is denied.");   }        return true;       }}