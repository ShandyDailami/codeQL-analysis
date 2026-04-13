import java.security.InvalidParameterException;

public class java_20517_CredentialValidator_A01 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 32;
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#%^&*()_=-+[{]}|;:,.<>?/";

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        int length = password.length();
        if (length < MIN_PASSWORD_LENGTH || length > MAX_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password length must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters");
        }

        if (!password.matches(".*\\d.*")) {
            throw new InvalidParameterException("Password must contain at least one number");
        }

        if (!password.matches(".*[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz].*")) {
            throw new InvalidParameterException("Password must contain at least one of the following characters: A-Z, a-z, 0-9");
        }

        if (!password.matches(".*[~!@#%^&*()_=-+[{]}|;:,.<>?/].*")) {
            throw new InvalidParameterException("Password must contain at least one of the following characters: ~!@#%^&*()_=-+[{]}|;:,.<>?/");
        }

        return true;
    }
}