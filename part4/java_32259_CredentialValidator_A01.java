import java.security.InvalidParameterException;

public class java_32259_CredentialValidator_A01 {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }

        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Password must contain at least one lowercase letter, one uppercase letter, one number and one special character");
        }

        return true;
    }
}