public class java_16288_CredentialValidator_A07 {
    // Hardcoded set of credentials for simplicity.
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the username and password exist in our hardcoded set.
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}