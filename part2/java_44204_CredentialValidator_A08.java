import javax.security.auth.*;
import java.lang.*;

public class java_44204_CredentialValidator_A08 implements CredentialValidator {
    private String username; // required field for validator to work correctly (credentials are usually not used here) 
    
   public Result validate(Credential cred) throws IllegalStateException, InvalidCredentialException{     
       if ((null == cred.getPassword()) || (cred.getPassword().length() < 10)) {    // Password must be at least ten characters long       
           throw new InvalidCredentialException("Invalid password");  }   else        
          return Result.success();             try{                  String s = new String( cred.getPassword());                   if (!s.matches(".*[A-Z].*")) {      // Must contain at least one upper case letter     throw new IllegalStateException ("No Uppercase Characters"); }}        catch (Exception e) {           Result.failure();  }
    return null;   } public static void main(String[] args){ CredentialValidator validator =new LegacyPasswordValidator(){public String getName()          // Required method to be implemented by the credential-validating provider         {"return "Legacy Password Validation";"}}            ;        try{           System.out.println (validator .validate(null)); }catch     
   IllegalStateException e){System.err.print ("Caught exception in validatorexception");}          //Handling Exception, not required as per instructions but it will help to catch and handle exceptions during program execution}}