public class java_00970_CredentialValidator_A08 {

    // List of allowed usernames and passwords
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user1", "user2");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public static class CredentialValidationResult {
        private boolean isValid;
        private String errorMessage;

        // Constructor and getters
    }

    public CredentialValidationResult validate(String username, String password) {
        CredentialValidationResult result = new CredentialValidationResult();
        result.isValid = false;

        // Validate username and password
        if (!ALLOWED_USERNAMES.contains(username) || !ALLOWED_PASSWORDS.contains(password)) {
            result.errorMessage = "Invalid username or password.";
            return result;
        }

        result.isValid = true;
        return result;
    }
}