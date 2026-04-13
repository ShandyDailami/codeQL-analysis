public class java_10492_CredentialValidator_A08 {
    // Hard-coded list of valid credentials
    private static final String[][] VALID_CREDENTIALS = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public boolean validate(String username, String password) {
        for (String[] credential : VALID_CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}