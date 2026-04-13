public class java_31037_CredentialValidator_A01 {

    // Store the credentials and roles
    private Map<String, String> credentials = new HashMap<>();

    // Add a new user
    public void addUser(String username, String password, String role) {
        credentials.put(username, password);
    }

    // Attempt to log in with a username and password
    public boolean validate(String username, String password) {
        // If the username and password are correct, return true
        if (credentials.get(username).equals(password)) {
            return true;
        }

        // If not, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUser("user1", "password1", "admin");
        validator.addUser("user2", "password2", "user");

        // Valid users should be able to access resources
        assert validator.validate("user1", "password1"); // Should return true
        assert !validator.validate("user1", "wrong_password"); // Should return false
        assert !validator.validate("user3", "password3"); // Should return false
        assert validator.validate("user2", "password2"); // Should return true
    }
}