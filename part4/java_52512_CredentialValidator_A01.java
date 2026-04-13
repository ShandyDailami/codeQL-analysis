import javax.security.auth.*;
// import other necessary classes here if required by your application, like CredentialAwareContext, etc., but be creative and realistic!
  
public class java_52512_CredentialValidator_A01 implements CredentialValidator {    // Define a new interface for credential validator 
    
        public AuthStatus validate(final AuthenticationToken arg0) throws java.lang.Exception{         // Overriding the method to provide our custom validation logic               
            String userName = arg0.getIdentifier();                                         /* Get username from token */  
             if (userName == null || "".equals(userName)) {                                  /* Check for blank/null input*/   
                 return AuthStatus.failure("Blank or Null Username");                       // If so, fail the validation and provide a message        
            }                                                                               
              else{                                                    
             if (((String) userName).length() < 6){                                          /* Check for username length */  
                  return AuthStatus.partialSuccess();                                        /* After this point we are only validating with full access, so partial success is appropriate*/ 
                 }                   
                else {                                                                       // If none of the above conditions met then continue validation         
                   if ("admin".equals(userName))                                              /* Check for specific username */  
                       return AuthStatus.success();                                            /* Return Success status and provide a message when user is validated*/   
                  }     
             else {                                                                       // Else fail the authentication  with appropriate error messages           
                 if (((String)userName).contains("password")){                              /* Check for password in username */  
                     return AuthStatus.failure("Password not allowed");                   /* If so, provide failure message*/    }     else {        
                  return AuthStatus.partialSuccess();                                      // In case none of the above conditions met then partial success is appropriate            };  }}                                                                                                                    });}};