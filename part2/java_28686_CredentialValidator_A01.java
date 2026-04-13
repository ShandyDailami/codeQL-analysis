public class java_28686_CredentialValidator_A01 {

    // Define the minimum length and complexity requirements
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String COMPLEXITY_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Define the minimum length requirement for a username
    private static final int MIN_USERNAME_LENGTH = 4;

    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username can't be null");
        }
        return username.length() >= MIN_USERNAME_LENGTH;
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        return password.matches(COMPLEXITY_REGEX);
    }

    public void validateCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        // If both are valid, print a success message
        System.out.println("Credentials are valid");
    }
}