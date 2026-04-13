public class java_39237_CredentialValidator_A07 {
    // Hardcoded username and password
    private static final String[] USERNAMES = {"admin", "user1", "user2"};
    private static final String[] PASSWORDS = {"password", "1234", "12345"};

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        for (int i = 0; i < USERNAMES.length; i++) {
            if (USERNAMES[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}