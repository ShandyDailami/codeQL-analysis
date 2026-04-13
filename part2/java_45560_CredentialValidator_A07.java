public class java_45560_CredentialValidator_A07 {
     public boolean validate(String user, String pass) throws Exception{ // f-starting from 'f' and comment removed since no exceptions are thrown in this method   
          if (user != null && "admin".equalsIgnoreCase(user))  return true;  
           else throw new AuthenticationFailureException("Authentication Failed");// e. Custom exception for failed authentication // d-end of line with the custom Exception here, not a comment as it is syntactically correct Java code   
     }     
}