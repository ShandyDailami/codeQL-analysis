public class java_39430_CredentialValidator_A01 {
    // Predefined set of credentials
    private String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"}
    };

    // Method to validate credentials
    public boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}