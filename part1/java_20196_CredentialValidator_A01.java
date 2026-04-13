import java.security.Credential;
import java.security.InvalidParameterException;

public class java_20196_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public void validate(Credential credential) throws InvalidParameterException {
        if (credential.getUsername() == null || credential.getPassword() == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        if (!USERNAME.equals(credential.getUsername()) || !PASSWORD.equals(credential.getPassword())) {
            throw new InvalidParameterException("Invalid username or password.");
        }
    }

}