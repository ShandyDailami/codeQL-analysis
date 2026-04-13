public class java_06119_CredentialValidator_A08 {

    // Define the class for the Credential
    public class Credential {
        private String username;
        private String password;

        public java_06119_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters and setters for the fields
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

    // Define the class for the IntegrityFailureException
    public class IntegrityFailureException extends Exception {
        public java_06119_CredentialValidator_A08(String message) {
            super(message);
        }
    }

    // Define a method for validating credentials
    public boolean validateCredentials(Credential credential) throws IntegrityFailureException {
        // Simulate a password check in a real-world application
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            return true;
        } else {
            throw new IntegrityFailureException("Invalid username or password");
        }
    }

    // Define a method for main that simulates usage
    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator();
            Credential credential = validator.new Credential("admin", "password");
            if (validator.validateCredentials(credential)) {
                System.out.println("Valid credentials");
            } else {
                System.out.println("Invalid credentials");
            }
        } catch (IntegrityFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}