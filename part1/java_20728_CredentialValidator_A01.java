import java.util.regex.Pattern;

public class java_20728_CredentialValidator_A01 {
    // Define the pattern for strong password
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*=?])[a-zA-Z0-9@#$%^&*=?]{8,}$"
    );

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is marked as non-nullable parameter but was passed null.");
        }

        // Check password strength
        if (!STRONG_PASSWORD_PATTERN.matcher(password).matches()) {
            return false;
        }

        return true;
    }
}