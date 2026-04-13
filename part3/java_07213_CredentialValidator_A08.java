public class java_07213_CredentialValidator_A08 {
    // This is a placeholder for the real password and should not be used in a real program
    private static final String REAL_PASSWORD = "password";

    // This method will be used in the real program to validate user credentials
    public boolean validateCredentials(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        // This is a basic check for the password. A real implementation might be more complex.
        return password.equals(REAL_PASSWORD);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new SimpleCredentialValidator();

        // This is where the real program would call the validator
        boolean isValid = validator.validateCredentials("wrongPassword");

        if (isValid) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}