public class java_20381_CredentialValidator_A08 {

    // Hard-coded list of blocked usernames
    private static final String[] BLOCKED_USERNAMES = {"blocked1", "blocked2", "blocked3"};

    // Method to check if a username is blocked
    public boolean isUsernameBlocked(String username) {
        for (String blockedUsername : BLOCKED_USERNAMES) {
            if (blockedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with a username that should be blocked
        String blockedUsername = "blocked1";
        if (validator.isUsernameBlocked(blockedUsername)) {
            System.out.println("Username: " + blockedUsername + " is blocked.");
        } else {
            System.out.println("Username: " + blockedUsername + " is not blocked.");
        }

        // Testing with a username that should not be blocked
        String normalUsername = "normalUser";
        if (!validator.isUsernameBlocked(normalUsername)) {
            System.out.println("Username: " + normalUsername + " is not blocked.");
        } else {
            System.out.println("Username: " + normalUsername + " is blocked.");
        }
    }
}