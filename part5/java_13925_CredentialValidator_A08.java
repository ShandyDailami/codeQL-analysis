public class java_13925_CredentialValidator_A08 {

    // Predefined credentials
    private final Map<String, String> credentials = new HashMap<>();

    public java_13925_CredentialValidator_A08() {
        // Initialize with some predefined credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the username and password match the predefined set
        return credentials.get(username).equals(password);
    }
}