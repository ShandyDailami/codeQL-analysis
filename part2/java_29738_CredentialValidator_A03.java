import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_29738_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) throws LoginException {
        String username = credential.getUsername();
        char[] password = credential.getPassword();

        // Check if username starts with 'M' or 'A' and password is more than 5 characters long
        if ((username.charAt(0) == 'M' || username.charAt(0) == 'A') && password.length > 5) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.failure();
        }
    }
}