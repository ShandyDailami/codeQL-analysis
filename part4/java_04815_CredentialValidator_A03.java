public class java_04815_CredentialValidator_A03 {

    // A predefined set of credentials
    private static final String[][] predefinedCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public boolean validate(String username, String password) {
        // Check if the username and password match a predefined set of values
        for (String[] credential : predefinedCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }

        // If no predefined credentials match, return false
        return false;
    }
}