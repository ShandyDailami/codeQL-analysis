// Create a CredentialValidator interface with validate method
public interface CredentialValidator {
    boolean validate(String username, String password);
}

// Create a simple CredentialValidator implementation
public class java_14857_CredentialValidator_A08 implements CredentialValidator {

    // Static password for simplicity
    private final String correctPassword = "password";

    // Override validate method to check if provided username and password match
    @Override
    public boolean validate(String username, String password) {
        return username.equals("admin") && correctPassword.equals(password);
    }
}

// Create a class to manage credential validators
public class CredentialManager {

    // List of credential validators
    private List<CredentialValidator> validators;

    public java_14857_CredentialValidator_A08() {
        this.validators = new ArrayList<>();
    }

    // Add a validator to the list
    public void addValidator(CredentialValidator validator) {
        this.validators.add(validator);
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Iterate over validators and return the first validator that validates
        for (CredentialValidator validator : validators) {
            if (validator.validate(username, password)) {
                return true;
            }
        }
        return false;
    }
}

// Test the CredentialManager
public class Main {
    public static void main(String[] args) {
        CredentialManager manager = new CredentialManager();
        manager.addValidator(new SimpleCredentialValidator());
        System.out.println(manager.validateCredentials("admin", "password")); // Should print true
        System.out.println(manager.validateCredentials("admin", "wrongpassword")); // Should print false
    }
}