public class java_39764_CredentialValidator_A03 {

    // The list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("admin", "password123"),
            new Credential("user1", "password123"),
            new Credential("user2", "password123")
    );

    // Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_39764_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // CredentialValidator class
    public static class CredentialValidatorImpl implements CredentialValidator {

        @Override
        public boolean validate(String username, String password) {
            for (Credential credential : VALID_CREDENTIALS) {
                if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }
}