public class java_29402_CredentialValidator_A08 {

    // Static list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3")
    );

    // Credential validation method
    public boolean validate(String username, String password) {
        return VALID_CREDENTIALS.stream()
                .anyMatch(c -> c.getUsername().equals(username) && c.getPassword().equals(password));
    }

    // Credential data class
    public static class Credential {
        private String username;
        private String password;

        public java_29402_CredentialValidator_A08(String username, String password) {
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