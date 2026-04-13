import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginModule;

public class java_16423_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getCaller();

            if (username == null || username.trim().isEmpty()) {
                return new CredentialValidationResult("Username cannot be null or an empty string");
            } else {
                return new CredentialValidationResult("Username is valid");
            }
        } else {
            return new CredentialValidationResult("Invalid credential type");
        }
    }

}