import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_11287_CredentialValidator_A01 {

    public CredentialValidationResult validate(Subject subject, UsernamePasswordCredential credential) throws LoginException {
        // Check if username and password are not null
        if (credential.getUsername() == null || credential.getPassword() == null) {
            return CredentialValidationResult.failed();
        }

        // Check if username and password match hard-coded values
        if ("admin".equals(credential.getUsername()) && "password".equals(credential.getPassword())) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}