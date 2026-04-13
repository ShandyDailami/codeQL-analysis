import org.springframework.security.authentication.*;
import javax.servlet.*;  
import java.io.*;   
public class java_51787_CredentialValidator_A08 implements Authenticator {    
@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{        
String password = ( String ) authentication .getCredentials();         
if ((password == null ))             throw new BadCredentialsException("No Password Set");        //throw exception if no pass in request            return null;      }       @Override public boolean supports(Class<?> aClass){    	return true;}   }}`);    for (int i = 0 ;i < password .length(); ++I) {        
char ch =password. charAt( I );        //get each character of the pass             if (!CharacterUtils - _isLetterOrDigit ((ch))) throw new BadCredentialsException("Password must contain only letters and digits"); }  for (int i = 0;i < password .length()-1 ; ++I) {          char ch =password.charAt( I );       
if (!CharacterUtils - _isGreaterThanMinimumLength (" + "8",ch)) throw new BadCredentialsException("Password must be at least 8 characters long"); } return authentication; }}`);    // if all checks pass, else throws exception     Authentication failed (return null)}}}