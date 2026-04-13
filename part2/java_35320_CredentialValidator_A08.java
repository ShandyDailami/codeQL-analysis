public class java_35320_CredentialValidator_A08 {

    // Step 1: Create a method to validate credentials.
    public void validate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    // Step 2: Create a main method to test our CredentialValidator.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("username", "password");
    }
}