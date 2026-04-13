import javax.security.auth.*;
import java.lang.Exception;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;   
    
public class java_51946_CredentialValidator_A07 implements CredentialValidationResult {     
       private static final Pattern pattern =          // defining regex  for password checking       
           Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");  
    
    public AuthenticationStatus validate(Credential cred) {     
          UsernamePasswordCredential userPass = (UsernamePasswordCredential)cred;         // get username and password       
           if(!isValidated())                              // initial check to see this CredValidator is not used before.      
               return AuthenticationStatus.NOT_PERMITTED;     
            String passWord=userPass.getPassword();          // getting the entered credential        
              Matcher matcher = pattern .matcher(passWord);     // matching regex for password check       
             if(!matcher.find()) {                            // checking whether there is a match or not, returning an appropriate message      
                 return AuthenticationStatus.NOT_PERMITTED;     
            }else{                                           
                setAuthenticated(true);                          // setting authenticate as true        when password matches the criteria    
               return  AuthenticationStatus.SUCCESSFUL ;          // returning authentication status       if match is found it returns success    else NOT_PERMITTED     
            }                                       
         });          
}