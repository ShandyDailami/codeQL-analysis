public class java_38481_CredentialValidator_A03 {

    // Hardcoded list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
        new Credential("user1", "password1"),
        new Credential("user2", "password2"),
        new Credential("user3", "password3"));

    public boolean isValidCredential(String username, String password) {
        // Iterate over the valid credentials
        for (Credential credential : VALID_CREDENTIALS) {
            if (credential.matches(username, password)) {
                return true;
            }
        }

        return false;
    }

    // Credential class
    public static class Credential {
        private final String username;
        private final String password;

        public java_38481_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}