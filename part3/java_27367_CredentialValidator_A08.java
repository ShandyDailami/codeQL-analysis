public class java_27367_CredentialValidator_A08 {

    // The pattern used to check if a username matches the password
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public boolean validate(String username, String password) {
        // Check if the username matches the pattern
        Matcher matcher = USERNAME_PATTERN.matcher(username);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Username is not valid: It should only contain letters and numbers.");
        }

        // Check if the password matches the pattern
        matcher = USERNAME_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Password is not valid: It should only contain letters and numbers.");
        }

        // If both username and password match the pattern, the validator returns true
        return true;
    }
}