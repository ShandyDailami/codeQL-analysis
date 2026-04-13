public class java_26977_CredentialValidator_A03 {

    // Array of predefined valid credentials
    private static String[][] validCredentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
    };

    // Method to check if a provided username and password match a valid credential
    public boolean validate(String username, String password) {
        for (String[] credential : validCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}