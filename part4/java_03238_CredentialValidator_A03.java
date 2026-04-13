public class java_03238_CredentialValidator_A03 {

    // Define a hard-coded set of credentials
    private static final String[][] credentialSet = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" }
    };

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Loop through each credential in the set
        for (String[] credential : credentialSet) {
            // If the username and password match the current credential in the set
            if (credential[0].equals(username) && credential[1].equals(password)) {
                // Return true to signify a successful match
                return true;
            }
        }
        // If no match is found, return false
        return false;
    }
}