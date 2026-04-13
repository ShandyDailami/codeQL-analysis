import org.springframework.security.authentication.*;
import java.util.*;
public class java_44727_CredentialValidator_A03 implements CredentialsValidation {    
    @Override     
    public Authentication validate(Authentication authentication)          throws AuthenticationException{          
        String name = authentication.getName();             // getting userName        
        char[] password = (char[])(authentication.getCredentials());  // converting credentials into character array           
       /* Now we need to compare the given username and hashed version of a stored one, using methods like:    */     
		/*1- Use inbuilt method - equals(Object) for String class*/         Strategy strategy = new MyStrategy();        if (!strategy.validateCredentials("username", password)) {              throw new AuthenticationException("Invalid Credential");          }     return authentication;       }}   public static void main (String args []) 
{    CustomAuthenticator authenticator=new      // creating an instance of our custom validation class        MyCustomAuthProvider provider =        	          			//create a bean for your credsValidator & provide name	    new CredentialValidationBean(provider);     }}}`  ^_^ `//This is just to demonstrate how we can use it