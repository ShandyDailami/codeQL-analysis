public class java_34677_CredentialValidator_A07 {
    // Hardcoded list of accepted usernames and passwords
    private static final String[][] ACCEPTED_CREDENTIALS = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Method to validate the credentials
    public static boolean validateCredentials(String username, String password) {
        for (String[] credential : ACCEPTED_CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(validateCredentials("user1", "password1")); // Should print true
        System.out.println(validateCredentials("user4", "password4")); // Should print false
    }
}