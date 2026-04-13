public class java_04691_CredentialValidator_A03 {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]+$";

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_PATTERN);
    }

    public static void main(String[] args) {
        String[] validUsernames = {"alice", "bob", "charlie_123", "_admin", "alice_123"};
        String[] invalidUsernames = {"alice 123", "alice$123", "alice 123 $xyz"};

        for (String username : validUsernames) {
            if (!isValidUsername(username)) {
                System.out.println("Invalid username: " + username);
            }
        }

        for (String username : invalidUsernames) {
            if (isValidUsername(username)) {
                System.out.println("Expected invalid username: " + username);
            }
        }
    }
}