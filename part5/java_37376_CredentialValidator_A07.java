import java.util.Arrays;

public class java_37376_CredentialValidator_A07 {

    // Array of users and their passwords
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    // Method to authenticate users
    public boolean validate(String username, String password) {
        // Get the index of the user in the array
        int userIndex = Arrays.asList(USERS).indexOf(username);

        // If the user is not found, return false
        if (userIndex == -1) {
            return false;
        }

        // Check if the password is correct
        return PASSWORDS[userIndex].equals(password);
    }

    // Main method for testing
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Validate the users
        boolean valid1 = validator.validate("user1", "password1");
        boolean valid2 = validator.validate("user2", "password2");
        boolean valid3 = validator.validate("user3", "password3");

        // Print the result
        System.out.println("User1: " + valid1);
        System.out.println("User2: " + valid2);
        System.out.println("User3: " + valid3);
    }
}