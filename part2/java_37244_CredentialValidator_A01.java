import java.util.Arrays;

public class java_37244_CredentialValidator_A01 {

    // Predefined list of valid credentials
    private static final String[] VALID_CREDENTIALS = {"user1", "user2", "user3"};

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        return Arrays.asList(VALID_CREDENTIALS).contains(username) && password.equals("password");
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password")); // Returns true
        System.out.println(validator.validate("user4", "password")); // Returns false
   
    }
}