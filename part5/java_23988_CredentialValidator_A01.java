public class java_23988_CredentialValidator_A01 {

    // Hard-coded set of usernames and passwords
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // Loop through the credentials
        for (int i = 0; i < credentials.length; i++) {
            // Check if the provided username and password match the current one
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }
}