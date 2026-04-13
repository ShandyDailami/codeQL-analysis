public class java_25503_CredentialValidator_A08 {
    // Hardcoded list of allowed usernames and passwords
    private static final String[] ALLOWED_USERS = {"user1", "user2"};
    private static final String[] ALLOWED_PASSWORDS = {"pass1", "pass2"};

    // Method to validate a username and password
    public boolean validate(String user, String password) {
        // Check if the user and password match
        for (String allowedUser : ALLOWED_USERS) {
            if (allowedUser.equals(user)) {
                for (String allowedPassword : ALLOWED_PASSWORDS) {
                    if (allowedPassword.equals(password)) {
                        // If the user and password match, return true
                        return true;
                    }
                }
            }
        }
        // If the user and password do not match, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        System.out.println(validator.validate("user1", "pass1")); // Should print: true
        System.out.println(validator.validate("user3", "pass3")); // Should print: false
    }
}