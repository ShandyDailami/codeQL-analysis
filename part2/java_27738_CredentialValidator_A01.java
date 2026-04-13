public class java_27738_CredentialValidator_A01 {

    // Hard-coded set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the entered credentials match the hard-coded ones
        return credentials.get(username).equals(password);
    }
}