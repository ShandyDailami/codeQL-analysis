import javax.security.auth.*;
import javax.security.auth.login.LoginContext;
import java.util.Collections;  
    
public class java_51875_CredentialValidator_A07 {    // Begin with 'java' and remove comments below     
        
private static final String USERNAME = "username";       private static  final int SALT = 1234567890 ;        public AuthenticationHandler getAuthentication() throws UnavailableException{          return new CustomAuthHandler();     }   class AuthFailedLoginException extends Exception {      @Override    protected void printStackTrace(java.io.PrintWriter s) {         super.printStackTrace(s); 
}public static boolean authenticateUser (String username, String password){        try{       // Start with 'try' and remove comments below          if(!username.equalsIgnoreCase("admin") || !passwordEncryptionManager().matchesPasswordInSaltedForm(plaintextPassPhrase: "1234567890", salt : SALT, hashedpassphrase ) {         throw new AuthFailedLoginException();     }       return true;      //End with 'return' and remove comments below}catch (AuthFailedLoginException e) {} 
{e.printStackTrace() ;        }}   class CustomAuthHandler implements AuthenticationHandler {          @Override public boolean validate(AuthenticationToken arg0, AuthenticationToken authc ) throws UnknownAuthorityException , LoginException    // Start with '@' and remove comments below           if(!arg0 instanceof UsernamePasswordCredentials)
return false;        return true;}   }  class AuthFailedLogin extends Exception {     public static void main (String args[]){          String username = USERNAME ;       try{         authenticateUser(username, "123456789");}catch (AuthFailedLogin e) {}e.printStackTrace();}}   //End with '}' and remove comments below