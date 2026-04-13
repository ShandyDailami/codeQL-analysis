public class java_40850_CredentialValidator_A03 {

    // A hard-coded list of valid usernames and passwords
    private static final String[][] VALID_CREDENTIALS = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
    };

    public boolean validate(String username, String password) {
        // Iterate through the hard-coded list of valid credentials
        for (String[] credential : VALID_CREDENTIALS) {
            // If the current username and password match, return true
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        // If no matching credential is found, return false
        return false;
    }
}