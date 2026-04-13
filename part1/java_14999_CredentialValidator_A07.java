public class java_14999_CredentialValidator_A07 {
    // Hardcoded list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("user1", "pass1"),
            new Credential("user2", "pass2"),
            new Credential("user3", "pass3"));

    public static boolean isValidCredential(String username, String password) {
        // Iterate over the list of valid credentials
        for (Credential credential : VALID_CREDENTIALS) {
            if (credential.matches(username, password)) {
                return true;
            }
        }
        // If we've made it here, no valid credentials found
        return false;
    }

    // Simple Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_14999_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}