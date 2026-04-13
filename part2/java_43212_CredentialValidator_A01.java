import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_43212_CredentialValidator_A01 implements CredentialsValidator {
    @Override //This method will be called by Spring Security when a request comes in to validate the creds 
    public Authentication verifyCredentials(Authentication auth) throws AuthenticationException{//Spring security provides several built-in authentication providers, so you can use it directly. For example: if (auth instanceof UsernamePasswordAuthenticationToken ) {...} etc.. for other types of authentications too such as OAuth2ClientContext or JdbcDatabaseAuthentication....
        //get the credentials and roles from auth object 
    String presentedUsername = auth.getName();//this is usually username/email provided by client (in case we're using form login)  
      if(auth instanceof UsernamePasswordAuthenticationToken){    	
          Object principal = ((UsernamePasswordAuthenticationToken) auth).getPrincipal(); // this will be the user id passed from frontend  like email or mobile no.    } else {...} For other types of authentication use appropriate methods to get them  		      String credentials= (String)auth.getCredentials() ;
      		// add your rules here, return true if creds are valid and false otherwise e.g: check password policy etc.. 
    	  //for simplicity I'll just validate against a hardcoded username/password combination  		    boolean result = presentedUsername != null && presentedUsername.equals("admin") && credentials!=null&&credentials.equals("secret");//validate with admin / secret passwords only, in real application more rules would be needed to make the system secure 
    		if (result){ // if credential are correct then authenticate and return Authentication object  		        throw new CredentialsExpiredException("Credentials have expired!");}//if result is true or false throws exception, in real application will handle this by returning a specific message. e.g: authFailed()
    		else {return null;} // otherwise authentication failed and return Null Authentication object  		    }  else{...}} for other types of tokens use appropriate methods to get them .} In the end if nothing is returned, Spring Security will default this method (which throws an UnknownAuthException).. For more info on creating custom authenticator see https://spring.io/guides/gs/authentication-db/
    }  	     public static void main(String args[]){...} // You can run the program from here and use postman or any other tool to test your application using POSTMAN, you just need a URL for testing with username:admin ,password :secret  e.g https://localhost:8443/login
 }