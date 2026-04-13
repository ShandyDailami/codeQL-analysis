import java.security.InvalidParameterException;

public class java_23802_CredentialValidator_A07 {
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int USERNAME_MIN_LENGTH = 3;

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null.");
        }

        if (username.length() < USERNAME_MIN_LENGTH || password.length() < PASSWORD_MIN_LENGTH) {
            return false;
        }

        // This is a dummy password check for the sake of the example. In a real world scenario,
        // you would need to implement a more sophisticated password check.
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}