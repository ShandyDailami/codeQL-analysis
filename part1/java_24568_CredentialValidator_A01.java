public class java_24568_CredentialValidator_A01 {

    // Mock database of users and their passwords
    private static Map<String, String> users = new HashMap<>();
    static {
        users.put("admin", "password");
        users.put("user", "password");
    }

    // Validate the provided username and password
    public static boolean validate(String username, String password) {
        // We will just check if the username and password match up to our mock database
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Entry point for the application
    public static void main(String[] args) {
        // Initialize the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Test the validation process
        try {
            validator.validate("admin", "password");
            System.out.println("Access granted for 'admin'");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        try {
            validator.validate("user", "wrongpassword");
            System.out.println("Access granted for 'user'");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}