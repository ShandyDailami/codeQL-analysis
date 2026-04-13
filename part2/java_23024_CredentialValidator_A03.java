import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_23024_CredentialValidator_A03 {

    private static final Set<String> commonPasswords = new HashSet<>(Arrays.asList(
            "12345", "password", "admin", "qwerty", "11111", "123123", "admin123", "password123", "123456", "abc123", "111111", "1234567", "abc1234567", "abcdef", "12345678", "11111111", "123456789", "password12345", "admin12345", "1234567890", "abcdef12345", "password1234", "admin1234", "12345678901", "abcdef1234", "password123456", "admin123456", "abcdef123456", "abcdef1234567", "abcdef12345678", "abcdef123456789", "abcdef1234567890", "abcdef12345678901", "abcdef123456789012", "abcdef1234567890123", "abcdef12345678901234", "abcdef123456789012345", "abcdef1234567890123456", "abcdef12345678901234567", "abcdef123456789012345678", "abcdef1234567890123456789", "abcdef12345678901234567890", "abcdef123456789012345678901"));

    public boolean isValid(String password) {
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password is null or empty");
        }
        return !commonPasswords.contains(password);
    }
}