import javax.security.auth.*;
import javax.security.auth.login.LoginException;

public class java_52898_CredentialValidator_A08 {  
    public static void main(String[] args) throws LoginException, NotAuthorizedException{       
            CredentialValidator validator = new NewPasswordValidatingAuthPolicy();    
             if (validator == null || !validator.validate(new AuthTokenImpl("user"))){  //Replace "username" and password with actual values  
                throw new AuthenticationFailedException("Invalid user name or/and Password");        }      else{         System.out.println("\n Successfully Logged in ");       }}    catch (NotAuthorizedException e) {    	e.printStackTrace(); 	}}}`catch block, if validator==null then login failed and the message to user is printed on console otherwise successfull loging info will be shown