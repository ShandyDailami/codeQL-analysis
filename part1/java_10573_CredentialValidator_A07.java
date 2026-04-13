import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.LoginException;

public class java_10573_CredentialValidator_A07 implements CredentialValidator {

    private String expectedPassword;

    public java_10573_CredentialValidator_A07(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public CredentialValidationResult validate(Credentials credentials) throws LoginException {
        String providedPassword = credentials.getPassword();
        if (providedPassword.equals(expectedPassword)) {
            return new CredentialValidationResult("Successful validation", null);
        } else {
            throw new LoginException("Invalid password");
        }
    }
}