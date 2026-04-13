public class java_41700_CredentialValidator_A03 {
    // List of allowed usernames and passwords
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("user1", "user2", "admin");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "admin");

    // The CredentialValidator
    public boolean isValid(String username, String password) {
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        }
        return false;
    }
}