import java.util.regex.Pattern;

public class java_30318_CredentialValidator_A08 {
    // Define a regular expression pattern for password
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if the password matches the pattern
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}