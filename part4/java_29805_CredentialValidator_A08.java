public class java_29805_CredentialValidator_A08 {

    private static final String SECRET_PASSWORD = "password"; // secret password to check

    public static void main(String[] args) {
        Credential credential = new Credential("username", "password");
        CredentialValidator validator = new PasswordValidator();

        boolean valid = validator.isValid(credential);

        if (valid) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are not valid");
        }
    }

    public boolean isValid(Credential credential) {
        String password = credential.getPassword();
        return password.contains(SECRET_PASSWORD);
    }

    public class Credential {
        private String username;
        private String password;

        public java_29805_CredentialValidator_A08(String username, String password) {
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

    public class CredentialValidator {
        public boolean isValid(Credential credential) {
            return false; // Default to invalid
        }
    }

}