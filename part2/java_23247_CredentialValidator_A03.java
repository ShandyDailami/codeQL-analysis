import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractLoginModule;

public class java_23247_CredentialValidator_A03 extends AbstractLoginModule {

    @Override
    public CredentialValidationResult validate(Subject subject, Object credentials) {
        String username = credentials.toString();
        String password = credentials.toString();

        // Hardcoded credentials
        if ("test".equals(username) && "password".equals(password)) {
            return getSuccessResult(subject);
        } else {
            return getFailureResult("Invalid credentials");
        }
    }
}