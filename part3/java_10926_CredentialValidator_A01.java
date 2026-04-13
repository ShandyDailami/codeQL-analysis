import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_10926_CredentialValidator_A01 implements CredentialValidator {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public boolean validate(String userName, String password) {
        if (password == null || userName == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidParameterException("Password must contain at least one digit, one uppercase, one lowercase, one special character and at least 8 characters");
        }

        // Here you can add more security-sensitive operations, like checking the password against a list of known weak passwords

        return true;  // or false if the password is invalid
    }
}