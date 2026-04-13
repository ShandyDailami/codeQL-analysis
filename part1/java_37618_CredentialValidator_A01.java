import javax.security.auth.credential.*;
import javax.security.auth.UsernamePasswordCredential;

public class java_37618_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            String username = upCredential.getIdentifier();
            char[] password = upCredential.getPassword();

            // Here you can put your security-sensitive operations, for example checking the password strength,
            // checking if the username and password are correct, or anything else related to access control.

            // If password is weak, return INVALID_CREDENTIAL.
            if (password.length < 8) {
                return new CredentialValidationResult("Weak password", null);
            }

            // If username and password are correct, return VALID_CREDENTIAL.
            return new CredentialValidationResult("Valid Credential", null);
        } else {
            // If the credential is not a UsernamePasswordCredential, return INVALID_CREDENTIAL.
            return new CredentialValidationResult("Invalid Credential", null);
        }
    }
}