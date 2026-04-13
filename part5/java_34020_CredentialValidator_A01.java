public class java_34020_CredentialValidator_A01 {

    // Interface for Credential
    interface Credential {
        String getUsername();
        String getPassword();
    }

    // Implementation of CredentialValidator
    static class Impl implements CredentialValidator.Credential {
        private final String username;
        private final String password;

        public java_34020_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Credential credential = validator.validate("username", "password");

        if (credential != null) {
            System.out.println("Credentials valid: " + credential.getUsername() + ", " + credential.getPassword());
        } else {
            System.out.println("Credentials are invalid.");
        }
    }

    // CredentialValidator implementation
    public Credential validate(String username, String password) {
        // You can add complex validation here if needed
        if (username != null && password != null && username.equals("admin") && password.equals("admin")) {
            return new Impl(username, password);
        } else {
            return null;
        }
    }
}