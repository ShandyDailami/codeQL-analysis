import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.DefaultValidationResult;
import javax.security.auth.validation.RequiredPermissionSubject;

public class java_17806_CredentialValidator_A07 {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public CredentialValidationResult validate(Subject subject) {
        // get the username
        String username = subject.getPrincipal().toString();

        // get the password
        String password = ((RequiredPermissionSubject) subject).getCredentials().toString();

        // check if the username and password match the predefined ones
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return new DefaultValidationResult("Success");
        } else {
            return new DefaultValidationResult("Failure");
        }
    }
}