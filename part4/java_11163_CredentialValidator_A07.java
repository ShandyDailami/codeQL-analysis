// Define the CredentialValidator interface with a validate method
public interface CredentialValidator {
    boolean validate(String username, String password);
}

// Implement the CredentialValidator interface
public class java_11163_CredentialValidator_A07 implements CredentialValidator {

    // Simulate a hardcoded user database
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"pass1", "pass2", "pass3"};

    // Assume that the username and password is correct
    @Override
    public boolean validate(String username, String password) {
        for (int i = 0; i < USERS.length; i++) {
            if (USERS[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

// Test the CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new StdCredentialValidator();

        // Simulate login attempts
        System.out.println(validator.validate("user1", "pass1")); // Should print true
        System.out.println(validator.validate("user4", "pass4")); // Should print false
    }
}