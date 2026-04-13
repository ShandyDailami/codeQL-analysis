import javax.security.auth.CredentialValidator;
import javax.security.auth.login.CredentialException;

public class java_19403_CredentialValidator_A08 implements CredentialValidator {

    private String validUsername;
    private String validPassword;

    public java_19403_CredentialValidator_A08(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    @Override
    public String getCallerName() {
        return "Simple Credential Validator";
    }

    @Override
    public String getIdentifier() {
        return "Simple Credential Validator";
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void validate(String arg0) throws CredentialException {
        if (!arg0.equals(validUsername)) {
            throw new CredentialException("Invalid username");
        }

        if (!arg0.equals(validPassword)) {
            throw new CredentialException("Invalid password");
        }
    }
}