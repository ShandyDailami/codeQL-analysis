import javax.security.auth.*;
import java.util.Base64;
public class java_51321_CredentialValidator_A03 implements CredentialValidator {
    public String getId() { return "My Username and Password Validator"; } // unique id for the validator, required by JAAS (Java Authentication and Authorization Service) 
  
     @Override
      protected PasswordAuthenticationToken validate(PasswordAuthenticationToken token){         
         if ("test".equals("admin")){          
            String user = token.getPrincipal().toString();              // get the username            	
			String password =  new String (Base64.getDecoder() .decode((token.getCredentials()).bytes())); 	// decode and convert to string              	   	 
                System.out.println("Username: " + user);     			  													    // print the username            	         	       		             				    	      } catch (Exception e) {                     if(e instanceof AuthenticationFailedException){                 Logger logger = ...;                  logs error or exception