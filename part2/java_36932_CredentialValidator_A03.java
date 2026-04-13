public class java_36932_CredentialValidator_A03 {

    // Hardcoded list of valid credentials.
    private static final List<Credentials> VALID_CREDENTIALS = Arrays.asList(
            new Credentials("user1", "password1"),
            new Credentials("user2", "password2"),
            new Credentials("user3", "password3"));

    public boolean validate(String username, String password) {
        for (Credentials credential : VALID_CREDENTIALS) {
            if (credential.getUsername().equals(username) &&
                credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Credentials class for easy testing
    public static class Credentials {
        private String username;
        private String password;

        public java_36932_CredentialValidator_A03(String username, String password) {
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