import java.security.InvalidParameterException;

public class java_16021_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public java_16021_CredentialValidator_A03() {}

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}