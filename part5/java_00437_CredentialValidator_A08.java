public class java_00437_CredentialValidator_A08 {

    // Using a HashMap to store credentials
    private Map<String, String> credentials = new HashMap<>();

    // Constructor to initialize the credentials map
    public java_00437_CredentialValidator_A08() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        return password.equals(credentials.get(username));
    }
}