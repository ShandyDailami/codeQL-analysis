public class java_11959_CredentialValidator_A08 {

    // Hard-coded list of valid credentials
    private static final String[][] VALID_CREDENTIALS = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
        // Add more credentials as needed
    };

    // Method to authenticate the user
    public boolean authenticate(String username, String password) {
        for (String[] credential : VALID_CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}