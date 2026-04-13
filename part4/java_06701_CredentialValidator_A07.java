public class java_06701_CredentialValidator_A07 {

    // Custom exception for authentication failures
    public class AuthFailureException extends Exception {
        public java_06701_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    // Realistic method for validating a user's credentials
    public void validateCredentials(String username, String password) throws AuthFailureException {
        // Simulate a long process to verify the credentials
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ("user".equals(username) && "password".equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validateCredentials("user", "password");
        } catch (CredentialValidator.AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}