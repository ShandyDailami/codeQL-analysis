public class java_07536_CredentialValidator_A01 {
    // Pre-defined credentials.
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public boolean validate(String username, String password) {
        // Check if the given username and password matches any of the predefined credentials.
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }

        return false;
    }
}