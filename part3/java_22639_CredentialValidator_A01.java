public class java_22639_CredentialValidator_A01 {
    // This is a very simple way to enforce access control,
    // but real-world applications would use a more robust method
    // of checking password hashes and other security measures.

    // This is the list of valid credentials
    private static final String[] VALID_CREDENTIALS = {
        "admin:admin",
        "user1:password1",
        "user2:password2",
    };

    // This method checks if the provided credentials are valid
    public boolean isValidCredentials(String username, String password) {
        // Convert the username and password to a unique identifier
        String identifier = username + ":" + password;

        // Iterate over the list of valid credentials
        for (String validCredential : VALID_CREDENTIALS) {
            // If the current credential matches the identifier, return true
            if (validCredential.equals(identifier)) {
                return true;
            }
        }

        // If no valid credentials were found, return false
        return false;
    }
}