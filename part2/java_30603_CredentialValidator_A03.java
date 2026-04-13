public class java_30603_CredentialValidator_A03 {
    // This is a placeholder for storing the actual credentials
    private String[][] credentials = {
        {"alice", "password123"},
        {"bob", "secret123"},
        {"charlie", "mypassword123"},
        {"dave", "password12345"},
        {"eve", "password123456"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}