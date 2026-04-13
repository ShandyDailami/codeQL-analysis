public class java_00833_CredentialValidator_A01 {
    // Predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Static block to initialize the credentials map
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the given username and password match the predefined set of credentials
        return credentials.get(username).equals(password);
    }
}