public class java_03611_CredentialValidator_A08 {

    // Define a class-level variable for a secret password
    private String secretPassword = "topSecret";

    // Define a method for a method-level variable
    private void authenticateUser(String userName, String password) {
        if (!password.equals(secretPassword)) {
            throw new IntegrityFailure("Integrity failure: Password does not match expected password");
        }
    }

    // Define a method that can only be called by the main method
    public static void main(String[] args) {
        // Instantiate a new CredentialValidator object
        CredentialValidator validator = new CredentialValidator();

        // Attempt to authenticate the user with the provided credentials
        try {
            validator.authenticateUser("user", "wrongPassword");
        } catch (IntegrityFailure e) {
            System.out.println(e.getMessage());
        }
    }

    // Define a custom Exception class for the integrity failure
    static class IntegrityFailure extends RuntimeException {
        public java_03611_CredentialValidator_A08(String message) {
            super(message);
        }
    }
}