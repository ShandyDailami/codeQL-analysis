public class java_32856_CredentialValidator_A01 {

    public static final String PLAIN_TEXT_PASSWORD = "password";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return true;
    }

    private boolean isValidUsername(String username) {
        // This is a placeholder. The actual implementation depends on your specific security requirements.
        // For example, you might want to check if the username contains special characters, or if it matches a predefined list of valid usernames.
        return username.matches("^[a-zA-Z0-9]+$");
    }

    private boolean isValidPassword(String password) {
        // This is a placeholder. The actual implementation depends on your specific security requirements.
        // For example, you might want to hash the password before storing it, or check if the password matches a predefined list of valid passwords.
        return password.equals(PLAIN_TEXT_PASSWORD);
    }
}