public class java_09060_CredentialValidator_A07 {

    // Define a set of valid credentials
    private static final String[][] VALID_CREDENTIALS = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public boolean validate(String username, String password) {
        // Iterate through the valid credentials
        for (String[] credential : VALID_CREDENTIALS) {
            // If the username and password match a valid credential...
            if (credential[0].equals(username) && credential[1].equals(password)) {
                // Return true
                return true;
            }
        }
        // If no match found, return false
        return false;
    }

}