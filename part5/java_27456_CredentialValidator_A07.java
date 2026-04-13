public class java_27456_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final Credentials CREDENTIALS = new Credentials("username", "password");

    public static class Credentials {
        private final String username;
        private final String password;

        public java_27456_CredentialValidator_A07(String username, String password) {
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

    public static class UserCredentials {
        private final String username;
        private final String password;

        public java_27456_CredentialValidator_A07(String username, String password) {
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

    public java_27456_CredentialValidator_A07(Credentials credentials) {
        CREDENTIALS = credentials;
    }

    public boolean validate(UserCredentials userCredentials) {
        return CREDENTIALS.getUsername().equals(userCredentials.getUsername())
                && CREDENTIALS.getPassword().equals(userCredentials.getPassword());
    }
}