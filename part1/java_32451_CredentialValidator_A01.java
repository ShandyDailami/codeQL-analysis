public class java_32451_CredentialValidator_A01 {
    // Set of predefined credentials.
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the set of credentials.
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        // Check if the provided password matches the expected password for the given username.
        String expectedPassword = credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}