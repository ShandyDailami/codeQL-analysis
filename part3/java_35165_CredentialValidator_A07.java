public class java_35165_CredentialValidator_A07 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static class Credential {
        private String username;
        private String password;

        public java_35165_CredentialValidator_A07(String username, String password) {
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

    private Credential credential;

    public java_35165_CredentialValidator_A07() {
        credential = new Credential(VALID_USERNAME, VALID_PASSWORD);
    }

    public boolean validate(String username, String password) {
        return credential.getUsername().equals(username) && credential.getPassword().equals(password);
    }
}