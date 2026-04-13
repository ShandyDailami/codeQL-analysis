public class java_08569_CredentialValidator_A03 {
    // Set of allowed users
    private static final Map<String, String> ALLOWED_USERS = new HashMap<>();
    static {
        ALLOWED_USERS.put("user1", "password1");
        ALLOWED_USERS.put("user2", "password2");
        ALLOWED_USERS.put("user3", "password3");
    }

    // Credentials to be used for authentication
    private final String username;
    private final String password;

    public java_08569_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // This is a simplistic approach. In a real-world application, you should use
        // a secure method to compare the passwords.
        return ALLOWED_USERS.get(username) != null && ALLOWED_USERS.get(username).equals(password);
    }
}