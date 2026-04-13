public class java_33643_CredentialValidator_A01 {
    // Hardcoded list of allowed usernames
    private static final String[] ALLOWED_USERNAMES = {"admin", "user1", "user2", "user3"};

    // Method to validate the username
    public boolean validate(String username) {
        // Check if the username is in the allowed usernames
        for (String allowedUsername : ALLOWED_USERNAMES) {
            if (allowedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }
}