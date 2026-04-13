public class java_29431_CredentialValidator_A07 {

    // Define the predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the credentials map with predefined data
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate the provided username and password
    public boolean validate(String username, String password) {
        // Check if the credentials map contains the provided username
        if (credentials.containsKey(username)) {
            // Check if the provided password matches the stored password
            return credentials.get(username).equals(password);
        } else {
            // The username does not exist in the credentials map
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        boolean valid = validator.validate("user1", "password1");
        System.out.println("Valid: " + valid); // Should print: Valid: true

        // Test with invalid credentials
        valid = validator.validate("invalid_user", "wrong_password");
        System.out.println("Valid: " + valid); // Should print: Valid: false
    }
}