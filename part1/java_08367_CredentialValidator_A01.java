public class java_08367_CredentialValidator_A01 {

    // hardcoded credentials
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"}
    };

    // method to validate credentials
    public boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}