public class java_18084_CredentialValidator_A08 {

    // Define a hard-coded set of credentials
    private static final Credentials CREDENTIALS = new Credentials("admin", "password");

    // Define the Credentials class
    public static class Credentials {
        private String username;
        private String password;

        public java_18084_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Define the CredentialValidator class
    public static class CredentialValidator {
        public boolean validate(String username, String password) {
            return CREDENTIALS.getUsername().equals(username) && CREDENTIALS.getPassword().equals(password);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Example of using the validator
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}