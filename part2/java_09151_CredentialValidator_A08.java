import javax.security.auth.Credential;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_09151_CredentialValidator_A08 implements CredentialValidator {

    // predefined set of credentials
    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String username = credential.getCaller();
        String password = credential.getPassword();

        if (username != null && username.equals(expectedUsername) &&
            password != null && password.equals(expectedPassword)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}