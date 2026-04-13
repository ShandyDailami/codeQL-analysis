import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_10239_CredentialValidator_A03 implements CredentialValidator {

    private static final String USER_DB = "myUser";
    private static final String USER_PASSWORD = "myPassword";

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {

        CredentialValidationResult result = CredentialValidationResult.NOT_VALIDATED_RESULT;

        // We assume that the credentials are the user name and password.
        String user = credential.getCredentialIdentifier();
        String password = new String(credential.getCredential());

        if (USER_DB.equals(user) && USER_PASSWORD.equals(password)) {
            // If the user is authenticated, set the result to VALID_RESULT.
            result = CredentialValidationResult.VALID_RESULT;
        }

        return result;
    }

    @Override
    public void initialize(Subject subject, Credential credential) throws LoginException {
        // This method is not used in this example.
    }
}