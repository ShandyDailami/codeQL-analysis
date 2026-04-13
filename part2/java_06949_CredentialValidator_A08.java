public class java_06949_CredentialValidator_A08 {
    // Predefined credentials
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Iterate over the credentials
        for (String[] credential : credentials) {
            // If the username and password match the predefined credentials
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true; // Credentials are valid
            }
        }
        return false; // Credentials are not valid
    }
}