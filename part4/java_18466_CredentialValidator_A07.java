public class java_18466_CredentialValidator_A07 {
    // Define a set of predefined credentials
    private static final String[][] credentials = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"},
        {"dave", "password4"}
    };

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        // Iterate over the credentials
        for (String[] credential : credentials) {
            // If the username matches and the password is correct, return true
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }

        // If no match is found, return false
        return false;
    }
}