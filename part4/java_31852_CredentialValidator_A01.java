import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_31852_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    // Hard-coded password for simplicity
    private String hardCodedPassword = "password";

    @Override
    public Credential validate(Subject subject, Credential credential) {
        String passwordAttempt = credential.getPassword();

        if (passwordAttempt.equals(hardCodedPassword)) {
            return credential;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(String authenticationScheme) {
        // This validator supports only the "password" scheme
        return "password".equals(authenticationScheme);
    }

}