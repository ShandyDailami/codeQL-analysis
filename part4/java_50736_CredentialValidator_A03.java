import javax.naming.AuthenticationException;
   import javax.security.auth.*;
   
public class java_50736_CredentialValidator_A03 implements CredentialValidator {    
      public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException, IllegalStateException{      	        	     		         	   	 	       			 				        // Validate username and password here             if (credentials.getUsername().equals("username") &&               credentials .getPassword()=="password12345")) {              return true;            }           else                              {                  throw new AuthenticationException ("Invalid credentials");         	  		 	       	}      
     public boolean commit(String var) throws IllegalStateException, AuthenticationException{    // In case username is not correct we should logout here.         request .logout();      return false;        }          
}