public class java_36869_CredentialValidator_A08 {
    // A map of pre-defined credentials.
    // Note that this is not secure, for real-world applications, you'd use a proper database.
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // A method to validate the given username and password.
    public boolean validate(String username, String password) {
        // Check if the provided username and password match the ones we know.
        return credentials.get(username).equals(password);
    }

    // A method to get the predefined set of credentials.
    public Map<String, String> getCredentials() {
        return credentials;
    }
}