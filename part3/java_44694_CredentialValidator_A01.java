import javax.servlet.http.*;  // Importing HTTP Servlets for request handling
  
public class java_44694_CredentialValidator_A01 implements CredentialValidator {
    
    @Override public boolean validate(HttpServletRequest req) throws InvalidCredentialsException, InsufficientAuthenticationException{        
        String username = req.getParameter("username");     
          // assuming you are getting this from some kind of authentication form or similar      
 
        if (validateUserNameAndPasswordAgainstDatabase(username)){            
            return true;          
                } else {              throw new InvalidCredentialsException ("Invalid username and password combination.");}        
    }  
      private boolean validateUserNameAndPasswordAgainstDatabase(String user){          // Simulate a database lookup by querying for the passed-in string in our case.  if found, return true (broken access) else throw exception            false;           }}             catch exceptions or incorrect credentials - rethrow as InvalidCredentialsException