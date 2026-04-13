import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_15384_CredentialValidator_A03 {
    private static final Pattern VALID_USERNAME_PATTERN;

    static {
        // This is a simple regex pattern that matches all alphanumeric characters and underscores, but not special characters or whitespace.
        // This is a very basic pattern and may not cover all possible variations of valid usernames.
        // In a real application, you would likely want to use a more complex pattern.
        String usernamePattern = "^[a-zA-Z0-9_]+$";
        VALID_USERNAME_PATTERN = Pattern.compile(usernamePattern);
    }

    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Username is not valid: " + username);
        }

        // If we've made it this far, the username is valid.
        return true;
    }
}