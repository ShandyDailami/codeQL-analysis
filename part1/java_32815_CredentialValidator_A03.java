public class java_32815_CredentialValidator_A03 {
    // Define a hard-coded list of usernames and passwords
    private static final String[] USERNAMES = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    public boolean validateCredentials(String username, String password) {
        // Iterate through the hard-coded list of usernames and passwords
        for (int i = 0; i < USERNAMES.length; i++) {
            if (USERNAMES[i].equals(username) && PASSWORDS[i].equals(password)) {
                // If the username and password match, return true
                return true;
            }
        }

        // If we've reached here, the username and password didn't match
        return false;
    }
}