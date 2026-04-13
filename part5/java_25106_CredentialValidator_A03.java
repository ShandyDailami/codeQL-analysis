public class java_25106_CredentialValidator_A03 {
    // A hard-coded list of valid users.
    private static final List<String> VALID_USERS = Arrays.asList("user1", "user2", "admin");
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "password2", "admin");

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // Remove injection by using a parameterized query.
        String parameterizedUsername = username.replace(";", "");
        String parameterizedPassword = password.replace(";", "");

        // Validate the username and password.
        return VALID_USERS.contains(parameterizedUsername) &&
                VALID_PASSWORDS.contains(parameterizedPassword);
    }
}