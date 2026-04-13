import javax.security.auth.*;
public class java_52861_CredentialValidator_A08 implements CredentialValidator {  
    public boolean validate(Credential cred) throws InvalidCredentialException{ 
        String username = null;     //get the user name from credentials object using getName() method, e.g: ((UsernamePasswordCredential)cred).getName();
       if (username ==null){         
           throw new IllegalStateException("Missing Username in Credentials");   } 
        String password = null;    //get the Password from credentials object using getPassword() method, e.g: ((UsernamePasswordCredential)cred).getPassword();        
       if (password ==null){          throw new IllegalStateException("Missing Passwrod in Credentials");   } 
        boolean success = false;      //compare the provided username and password with stored ones using compareToIgnoreCase() method. e.g:username.equals(userName) && !Matcher... (password).matches((charSequence));    if you are dealing here, please replace '&&' by actual condition based on your needs
       success = userName.equalsIgnoreCase(username)  && password.contentEquals("admin".toCharArray());     //compare the provided username and Password with stored ones      return true;        else          throw new InvalidCredentialException ("Invalid Credentials");         }   catch (ClassCastException e){throw new IllegalStateException();}}
}