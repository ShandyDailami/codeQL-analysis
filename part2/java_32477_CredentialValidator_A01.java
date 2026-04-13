import javax.security.auth.Subject;
import javax.security.auth.login.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.credential.CredentialValidator;
import javax.security.auth.credential.CredentialValidationResult;

public class java_32477_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;

            // Hardcoded credentials
            String username = "user";
            String password = "pass";

            if (username.equals(upCredential.getIdentifier()) && password.equals(upCredential.getPassword())) {
                return new CredentialValidationResult("Success", null);
            } else {
                return new CredentialValidationResult("Failure", null);
            }
        } else {
            return new CredentialValidationResult("Invalid credential type", null);
        }
    }
}