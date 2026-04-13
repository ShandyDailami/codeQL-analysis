// CredentialValidator is a security interface that checks if a given password is valid
interface CredentialValidator {
    // Method to validate the password
    boolean isValid(String password);
}

public class java_38344_CredentialValidator_A08 implements CredentialValidator {
    // A secret key that should not be shared
    private final String secretKey;

    public java_38344_CredentialValidator_A08(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public boolean isValid(String password) {
        // Check if the password matches the secret key
        return password.equals(secretKey);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a custom credential validator
        CredentialValidator validator = new CustomCredentialValidator("secret");

        // Validate a password
        boolean isValid = validator.isValid("secret");

        // Print the result
        System.out.println("Is valid: " + isValid);
    }
}