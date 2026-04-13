public class java_40495_CredentialValidator_A03 {

    // Custom class for checking if a username is valid
    private class Validator {
        public boolean isValid(String username) {
            // Here you can add your own logic for checking if the username is valid
            // For simplicity, we just check if it contains only alphanumeric characters
            return username.matches("^[A-Za-z0-9]+$");
        }
    }

    // Inject the custom validator
    private Validator validator = new Validator();

    // Method for checking if the password is valid
    public boolean isValidPassword(String username, String password) {
        // First, validate the username
        if (!validator.isValid(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        // Then, check the password based on your own rules (e.g., length, complexity)
        // For simplicity, we just check if the password is longer than 8 characters
        return password.length() > 8;
    }
}