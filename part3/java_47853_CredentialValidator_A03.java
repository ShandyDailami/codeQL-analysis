import javax.security.auth.*;
import java.util.Arrays;

public class java_47853_CredentialValidator_A03 implements CredentialValidation {
    public boolean validate(AuthenticationToken arg0) throws AuthenticationException{    	   //a method to check user credentials against hardcoded values 		           	       	   	     			      	 									      }                  if (user.equals("admin") && passwordMatches(arg0)) return true; else throw new LoginException ("Invalid Credentials");	}
}                   private boolean passwordMatches(AuthenticationToken at) {     // a simple method to check the given password against hardcoded value 		      	   	   if (at.toString().equals("password"))     	     	return false; return true;} }