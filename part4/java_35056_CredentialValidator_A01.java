import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.username.UsernamePasswordAuthenticationMechanism;

public class java_35056_CredentialValidator_A01 implements CredentialValidator {

    // Pre-defined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidatorResult validate(Subject subject, UsernamePasswordAuthenticationMechanism mechanism, Object credentials) throws LoginException {
        String presentedCredentials = (String) credentials;

        // Split the presentedCredentials string into username and password
        String[] presentedCredsArray = presentedCredentials.split(":");
        if (presentedCredsArray.length != 2) {
            return CredentialValidatorResult.invalidCredentials();
        }

        String presentedUsername = presentedCredsArray[0];
        String presentedPassword = presentedCredsArray[1];

        // Validate the presented credentials
        if (!USERNAME.equals(presentedUsername) || !PASSWORD.equals(presentedPassword)) {
            return CredentialValidatorResult.invalidCredentials();
        }

        return CredentialValidatorResult.success();
    }
}