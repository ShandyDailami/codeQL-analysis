public class java_33921_CredentialValidator_A03 {
    private String expectedPassword;

    public java_33921_CredentialValidator_A03() {
        this.expectedPassword = "1234"; // this should be stored securely, not hard-coded here
    }

    public Credentials authenticate(String password) {
        if (password.equals(this.expectedPassword)) {
            return new Credentials(password, true);
        } else {
            return null;
        }
    }

    public static class Credentials {
        private String password;
        private boolean authenticated;

        public java_33921_CredentialValidator_A03(String password, boolean authenticated) {
            this.password = password;
            this.authenticated = authenticated;
        }

        public String getPassword() {
            return password;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }
    }
}