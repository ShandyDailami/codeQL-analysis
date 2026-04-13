import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;

public class java_10535_CredentialValidator_A01 {

    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String password = credential.getCredentialIdentifier();
        if ("test".equals(password)) {
            Subject subject = new Subject.publicInstance();
            return new CredentialValidationResult("Authenticated", subject);
        } else {
            return new CredentialValidationResult("Access Denied", null);
        }
    }
}