public class java_23239_CredentialValidator_A03 {

    // This is a predefined set of valid credentials
    private static final String[][] VALID_CREDENTIALS = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
        {"user4", "pass4"},
        {"user5", "pass5"}
    };

    // This method takes in a username and password,
    // and returns true if the pair is valid, false otherwise
    public boolean validate(String username, String password) {
        for (String[] credential : VALID_CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}