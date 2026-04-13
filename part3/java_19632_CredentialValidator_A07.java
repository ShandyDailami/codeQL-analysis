public class java_19632_CredentialValidator_A07 {

    // A simple credential validator that accepts any password.
    // This is a minimalist approach, focusing on security-sensitive operations.

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate(new Credential("username", "password123"));
    }

    public void validate(Credential credential) {
        if (credential.getPassword().equals("password123")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
            // A07_AuthFailure: Stop the authentication process
            System.exit(0);
        }
    }

    class Credential {
        private String username;
        private String password;

        public java_19632_CredentialValidator_A07(String username, String password) {
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