import java.util.*;
public class java_42385_CredentialValidator_A07 {    
    public static void main(String args[]) throws Exception{            
            CredentialValidator cv = new UsernamePasswordCredentials(); // Replace with the actual implementation of your credential validator later on in code  
              if (cv == null){  throw new AuthFailureException("Unknown Error");}      
               try {   
                String passwordAttempt  = "password";        // This should be obtained from somewhere else or hard-coded for example purposes.     
                   cv.validate(null, passwordAttempt);     } catch (InvalidCredentialsException ex)  {}catch (InternalAuthenticationServiceException ex){}   finally {throw new AuthFailureException("Unknown Error");}}             public static class UsernamePasswordCredentials implements CredentialValidator{         private byte[] decrypt(String cryptoText, String keyName);         
            @Override              boolean doCredentialsMatch ​ (FrameworkEvent event , HttpServletRequest request )throws InternalAuthenticationServiceException;   }      `     // Here's the complete class. You can replace 'null' with your actual implementation of CredentialValidator in this part                  .doAuthFailure(event,request) throws Exception {
            return true ;}  @Override public boolean doCredentialsMatch ( FrameworkEvent event , HttpServletRequest request )throws InternalAuthenticationServiceException{ // Here I am just throwing the exception. You need to replace it with your actual implementation of CredentialValidator in this part                throw new UnsupportedOperationException("Not supported");}}