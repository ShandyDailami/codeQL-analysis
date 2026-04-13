public class java_39521_CredentialValidator_A01 {

    // Define the expected username and password.
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    // Custom User class to store username and password.
    private User user;

    public java_39521_CredentialValidator_A01(User user) {
        this.user = user;
    }

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the expected values.
        return username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD);
    }

    // Custom User class.
    public static class User {
        private String username;
        private String password;

        public java_39521_CredentialValidator_A01(String username, String password) {
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

    public static void main(String[] args) {
        // Create a new User with expected username and password.
        User user = new User("admin", "password");

        // Create a new CredentialValidator for the user.
        CredentialValidator validator = new CredentialValidator(user);

        // Validate the credentials.
        boolean isValid = validator.validate("admin", "password");

        // Print the result.
        System.out.println("Is valid: " + isValid);
    }
}