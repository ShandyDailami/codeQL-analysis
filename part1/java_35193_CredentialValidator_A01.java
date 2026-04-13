public class java_35193_CredentialValidator_A01 {
    // Predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the set of credentials
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // The main validator method
    public static boolean validateCredentials(String username, String password) {
        // Check if the user exists in the credentials map
        if (credentials.containsKey(username)) {
            // Check if the password matches the stored password
            return credentials.get(username).equals(password);
        } else {
            // If the user does not exist, return false
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Test the validation
        System.out.println(validateCredentials("user1", "password1")); // true
        System.out.println(validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validateCredentials("unknownuser", "password")); // false
    }
}