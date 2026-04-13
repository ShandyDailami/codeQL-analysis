import java.security.InvalidParameterException;

public class java_20507_CredentialValidator_A07 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Password must contain at least one number, one uppercase letter, one lowercase letter, one special character and no whitespace");
        }

        // If we made it this far, the password is valid
        return true;
    }
}