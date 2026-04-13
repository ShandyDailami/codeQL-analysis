import java.util.Base64;

public class java_05612_CredentialValidator_A03 {
    private String validUsername;
    private String validPassword;

    // Constructor
    public java_05612_CredentialValidator_A03(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    // Method to validate credentials
    public boolean validate(String enteredUsername, String enteredPassword) {
        // Convert entered credentials to Base64
        String enteredCredentials = Base64.getEncoder().encodeToString((enteredUsername + ":" + enteredPassword).getBytes());

        // Compare entered credentials with valid credentials
        return enteredCredentials.equals(Base64.getEncoder().encodeToString(validUsername.getBytes())) &&
                enteredCredentials.equals(Base64.getEncoder().encodeToString(validPassword.getBytes()));
    }

    public static void main(String[] args) {
        // Create a CredentialValidator instance with valid credentials
        CredentialValidator validator = new CredentialValidator("user", "password");

        // Validate the instance
        System.out.println(validator.validate("user", "password")); // Expected output: true
        System.out.println(validator.validate("invalid", "password")); // Expected output: false
        System.out.println(validator.validate("user", "invalid")); // Expected output: false
    }
}