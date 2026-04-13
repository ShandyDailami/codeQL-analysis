public class java_39102_CredentialValidator_A03 {

    // Hardcoded list of allowed usernames
    private static final String[] ALLOWED_USERNAMES = {"admin", "user1", "user2", "user3"};

    // Method to validate username
    public boolean validateUsername(String username) {
        // Check if the provided username is in the allowed list
        for (String allowedUsername : ALLOWED_USERNAMES) {
            if (allowedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }
}