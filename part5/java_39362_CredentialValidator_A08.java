import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_39362_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();
        
        // Define a hard-coded pattern for passwords
        String hardCodedPattern = "password";
        
        // If the password matches the pattern, return a success
        if (password.equals(hardCodedPattern)) {
            return CredentialValidatorResult.success();
        } else {
            // Otherwise, throw a custom exception
            throw new SecurityException("Invalid password.");
        }
    }
}