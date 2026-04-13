public class java_09988_CredentialValidator_A07 {

    // Define your own Credential class
    private class Credential {
        private String username;
        private String password;

        public java_09988_CredentialValidator_A07(String username, String password) {
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

    // Define your own CredentialValidator class
    private class CredentialValidator {
        private Credential credential;

        public java_09988_CredentialValidator_A07() {
            this.credential = new Credential("admin", "password");
        }

        public boolean validate(String username, String password) {
            return this.credential.getUsername().equals(username) && this.credential.getPassword().equals(password);
        }
    }

    // Use the CredentialValidator class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("admin", "password");

        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}