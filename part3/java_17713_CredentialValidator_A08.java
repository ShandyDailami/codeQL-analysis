public class java_17713_CredentialValidator_A08 {
    // Method to validate username and password
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (username.length() < 6 || password.length() < 6) {
            throw new IllegalArgumentException("Username and password must be at least 6 characters long");
        }

        // Assume if username and password are valid, return true
        return true;
    }
}