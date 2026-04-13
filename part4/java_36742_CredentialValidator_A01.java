public class java_36742_CredentialValidator_A01 implements CredentialValidator {

    // Array of predefined valid usernames
    private String[] validUsernames = {"user1", "user2", "user3"};

    // Default constructor
    public java_36742_CredentialValidator_A01() {
    }

    // Method to validate a username
    @Override
    public boolean validate(String username, String password) {
        // If the username is in the predefined list of valid usernames
        if (Arrays.asList(validUsernames).contains(username)) {
            // Validate the password (this would usually involve a real password validation,
            // but for simplicity, we're just checking if the password is not null)
            if (password == null) {
                return false;
            }
            return true;
        }
        return false;
    }
}