import java.util.regex.Pattern;

public class java_29082_CredentialValidator_A03 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(.{8,})$");

    public boolean isUsernameValid(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isPasswordStrongEnough(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isUsernameValid(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!isPasswordStrongEnough(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain a lowercase letter, an uppercase letter, a number, and a special character");
        }
        // Other checks...
        return true; // Return true if credentials are valid, otherwise return false
    }
}