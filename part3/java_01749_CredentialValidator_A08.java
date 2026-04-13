import java.security.InvalidParameterException;

public class java_01749_CredentialValidator_A08 {

    public static final int MIN_PASSWORD_LENGTH = 8;

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}