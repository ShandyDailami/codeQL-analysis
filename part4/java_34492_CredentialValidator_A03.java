public class java_34492_CredentialValidator_A03 {

    // Predefined credentials
    private static final Map<String, String> credentials = new HashMap<String, String>() {
        {
            put("user1", "password1");
            put("user2", "password2");
            put("user3", "password3");
        }
    };

    // CredentialValidator class can't be instantiated
    private java_34492_CredentialValidator_A03() {}

    public static boolean validateCredentials(String username, String password) {
        // Check if the credentials exist in the map
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the credentials
        CredentialValidator.validateCredentials("user1", "password1"); // Should print "Credentials validated successfully!"
        CredentialValidator.validateCredentials("user1", "wrongpassword"); // Should print "Invalid username or password."
        CredentialValidator.validateCredentials("non-existent-user", "non-existent-password"); // Should print "Invalid username or password."
    }
}