import java.security.InvalidParameterException;
import java.util.Base64;

public class java_22032_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPass";

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }

        // Use the Base64 encoding for comparison
        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (encodedUsername.equals(VALID_USERNAME) && encodedPassword.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}