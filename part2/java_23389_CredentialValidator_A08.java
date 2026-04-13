public class java_23389_CredentialValidator_A08 {

    // Static list of credentials for validation
    private static final List<Credential> CREDENTIALS = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3"));

    public boolean validate(String username, String password) {
        // Validate the username and password
        // Return true if valid, false otherwise
        return CREDENTIALS.stream()
                .anyMatch(credential -> credential.getUsername().equals(username) && credential.getPassword().equals(password));
    }

    // Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_23389_CredentialValidator_A08(String username, String password) {
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
}