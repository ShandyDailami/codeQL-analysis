public class java_11097_CredentialValidator_A07 {
    // Hardcoded list of allowed users and passwords
    private static final String[][] allowedUsers = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        // add more users as needed
    };

    // Validate the provided username and password
    public static boolean validateCredentials(String username, String password) {
        for (String[] user : allowedUsers) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println(validateCredentials("user1", "password1") ? "Access granted" : "Access denied");
        System.out.println(validateCredentials("user4", "password4") ? "Access granted" : "Access denied");
    }
}