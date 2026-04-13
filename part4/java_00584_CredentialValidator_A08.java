import java.security.InvalidParameterException;
import java.util.Arrays;

public class java_00584_CredentialValidator_A08 {

    // Define a hard-coded set of credentials
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    // Validate the username and password
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Compare the username and password with the hard-coded set
        return Arrays.stream(credentials)
            .anyMatch(credential -> Arrays.equals(credential, new String[] {username, password}));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        boolean valid = validator.validate("user1", "password1");
        System.out.println("Valid: " + valid);

        valid = validator.validate("unknown", "unknown");
        System.out.println("Valid: " + valid);
   
        valid = validator.validate("user3", "wrongpassword");
        System.out.println("Valid: " + valid);
    }
}