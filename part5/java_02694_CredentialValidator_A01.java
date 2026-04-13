public class java_02694_CredentialValidator_A01 {
    // Constant for the regular expression pattern
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";

    // Instance variable to store the regular expression pattern
    private java.util.regex.Pattern usernamePattern;

    // Constructor
    public java_02694_CredentialValidator_A01() {
        this.usernamePattern = java.util.regex.Pattern.compile(USERNAME_PATTERN);
    }

    // Method to validate a username
    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Use the pattern to match the username
        return this.usernamePattern.matcher(username).matches();
    }
}