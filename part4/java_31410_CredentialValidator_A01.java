public class java_31410_CredentialValidator_A01 {

    // Simple in-memory store of credentials
    private Map<String, String> credentials = new HashMap<>();

    public java_31410_CredentialValidator_A01() {
        // Add some dummy credentials for testing
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // CredentialValidator interface
    public boolean validate(String username, String password) {
        // Check if the provided password matches the stored password for the given username
        return Objects.equals(password, credentials.get(username));
    }

    public static void main(String[] args) {
        // Create a new CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is user1 valid? " + isValid); // Outputs: Is user1 valid? true

        isValid = validator.validate("user3", "password3");
        System.out.println("Is user3 valid? " + isValid); // Outputs: Is user3 valid? false
    }
}