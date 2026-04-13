public class java_13759_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_13759_CredentialValidator_A03(String username, String password) {
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

public interface CredentialValidator {
    boolean validate(Credential credential);
}

public class BasicCredentialValidator implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) {
        // Simplistic validation: always return true
        // This is a placeholder for real-world use
        return true;
    }
}

public class SecuredCredentialValidator {
    private CredentialValidator validator;

    public java_13759_CredentialValidator_A03(CredentialValidator validator) {
        this.validator = validator;
    }

    public boolean validateCredential(String username, String password) {
        // Remove the following line once you've implemented the real-world validation
        // In reality, never trust the client's input
        // System.out.println("Validating credential: " + username + ", " + password);

        // Use the real-world validation mechanism
        Credential credential = new Credential(username, password);
        return validator.validate(credential);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new BasicCredentialValidator();
        SecuredCredentialValidator secValidator = new SecuredCredentialValidator(validator);

        // Test the secure validator
        boolean isValid = secValidator.validateCredential("admin", "password");
        System.out.println("Is Valid: " + isValid);
    }
}