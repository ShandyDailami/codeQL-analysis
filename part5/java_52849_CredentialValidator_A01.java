import javax.security.auth.*;
public class java_52849_CredentialValidator_A01 {  //Replace this name as per your need, e.g., BrokenAccessControlStrategy  
    private boolean isValid;    
      public void validate(TokenRequest tokenRequest) throws AuthenticationException{      
        String username = null;           
          try{                    
              UsernamePasswordCredential creds =  (UsernamePasswordCredential )tokenRequest.getCredentials();            
                if((creds ==null)) throw new InvalidLoginException("Invalid credentials");          
                   //if the authentication process should fail here, you can set isValid to false and let Authenticator handle it              
              username = creds.getIdentifier();         
            }catch(AuthenticationException e){            
                System.out.println("\n\t An error occured during login.");          
                    // log the exception or possibly rethrow for further handling     
                  throw new InvalidLoginException("Invalid credentials");      
              isValid = false;    
          }}   catch (BadTokenStructureException e) {  /* This can happen if a JCE provider does not support token validation. */         System.out.println("\n\tAn error occurred during login."); throw new InvalidLoginException("Invalid credentials"); }       finally{             isValid = false;     }}
   public boolean getValidationResult(){    //This method returns the final decision as to whether or not authentication has succeeded           return this.isValid;} 
}