public class java_18243_CredentialValidator_A07 {

    // Define a hard-coded set of credentials
    private static final String[][] knownCredentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
    };

    // Credential validator
    public boolean validate(String username, String password) {
        // Check if the provided username and password match a known credential
        for (String[] credential : knownCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}