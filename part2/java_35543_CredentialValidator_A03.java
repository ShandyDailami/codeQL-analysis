public class java_35543_CredentialValidator_A03 {

    // Pre-defined set of allowed usernames and passwords
    private static final String[] ALLOWED_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    // Credentials to validate
    private String username;
    private String password;

    public java_35543_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate() {
        // If the username or password are null, return false
        if (username == null || password == null) {
            return false;
        }

        // If the username or password is not in the allowed list, return false
        if (!isUsernameAllowed(username) || !isPasswordAllowed(password)) {
            return false;
        }

        // If the credentials are correct, return true
        return true;
    }

    // Helper method to check if a username is allowed
    private boolean isUsernameAllowed(String username) {
        for (String allowedUsername : ALLOWED_USERNAMES) {
            if (allowedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a password is allowed
    private boolean isPasswordAllowed(String password) {
        for (String allowedPassword : ALLOWED_PASSWORDS) {
            if (allowedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user1", "password1");
        System.out.println(validator.validate()); // Prints true

        validator = new CredentialValidator("user4", "password4");
        System.out.println(validator.validate()); // Prints false

        validator = new CredentialValidator(null, "password1");
        System.out.println(validator.validate()); // Prints false

        validator = new CredentialValidator("user1", null);
        System.out.println(validator.validate()); // Prints false
    }
}