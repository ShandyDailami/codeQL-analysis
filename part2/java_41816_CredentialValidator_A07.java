public class java_41816_CredentialValidator_A07 {

    // Predefined set of usernames and passwords
    private String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
    };

    // Method to validate the username and password
    public boolean validateCredentials(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}