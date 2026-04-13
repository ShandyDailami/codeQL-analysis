import java.security.InvalidParameterException;
import java.util.Base64;

public class java_32452_CredentialValidator_A08 {

    // This method validates the username and password.
    // It uses Base64 for encoding/decoding process.
    // InvalidParameterException is thrown when the username or password is null.
    // It also throws an InvalidParameterException when the username or password is not valid (length is less than 4 or more than 16).
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        if (username.length() < 4 || username.length() > 16 || password.length() < 4 || password.length() > 16) {
            throw new InvalidParameterException("Username and password must be at least 4 characters long and not more than 16 characters long");
        }

        String encoded = Base64.getEncoder().encodeToString(username.getBytes());
        String decoded = new String(Base64.getDecoder().decode(encoded), "UTF-8");
        if (decoded.equals(username)) {
            return false;
        }

        encoded = Base64.getEncoder().encodeToString(password.getBytes());
        decoded = new String(Base64.getDecoder().decode(encoded), "UTF-8");
        if (decoded.equals(password)) {
            return false;
        }

        return true;
    }
}