public class java_02485_CredentialValidator_A03 {

    // Our predefined credentials
    private static final String[][] creds = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // Iterate over our predefined credentials
        for (int i = 0; i < creds.length; i++) {
            // If the current username and password match our predefined credentials
            if (creds[i][0].equals(username) && creds[i][1].equals(password)) {
                // Return true
                return true;
            }
        }
        // If we get here, we didn't find a match, return false
        return false;
    }
}