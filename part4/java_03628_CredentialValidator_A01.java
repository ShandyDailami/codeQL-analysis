// CredentialValidator interface and its methods
public interface CredentialValidator {
    boolean validate(String username, String password);
    boolean checkAccess(String username, String password);
}

// SimpleCredentialValidator class java_03628_CredentialValidator_A01 implements the CredentialValidator interface
public class SimpleCredentialValidator implements CredentialValidator {
    private String[][] users = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    @Override
    public boolean validate(String username, String password) {
        // Check if the password matches for the given username
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkAccess(String username, String password) {
        // Validate the password and then check if the username and password are valid
        return validate(username, password);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a new SimpleCredentialValidator
        CredentialValidator validator = new SimpleCredentialValidator();

        // Use the validator
        boolean accessGranted = validator.checkAccess("user1", "password1");
        System.out.println("Access granted: " + accessGranted);
    }
}