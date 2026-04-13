import java.util.Base64;
import java.util.regex.Pattern;

public class java_18703_CredentialValidator_A03 {

    // This pattern checks if a string is a valid base64 string
    private static final Pattern BASE64_PATTERN = Pattern.compile("^[A-Za-z0-9+/]+={0,2}$");

    // This method validates a password.
    // A password is valid if it is a valid base64 string,
    // and its length is greater than 8.
    public boolean validatePassword(String password) {
        if (!isBase64String(password)) {
            return false;
        }
        return password.length() > 8;
    }

    // This method validates a username.
    // A username is valid if it is not null or empty,
    // and its length is greater than 5.
    public boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return username.length() > 5;
    }

    // This method checks if a string is a valid base64 string
    private boolean isBase64String(String str) {
        return BASE64_PATTERN.matcher(str).matches();
    }
}