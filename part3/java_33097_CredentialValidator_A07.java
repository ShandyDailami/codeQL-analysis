public class java_33097_CredentialValidator_A07 {

    public static class Credential {
        private String username;
        private String password;

        public java_33097_CredentialValidator_A07(String username, String password) {
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

    public Credential validate(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return new Credential(username, password);
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}