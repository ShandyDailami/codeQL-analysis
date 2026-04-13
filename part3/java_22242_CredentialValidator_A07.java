import java.util.Base64;

public class java_22242_CredentialValidator_A07 {

    // A user object to store credentials
    private User user;

    // Constructor
    public java_22242_CredentialValidator_A07(User user) {
        this.user = user;
    }

    // Method to validate the user's password
    public boolean validatePassword(String password) {
        // Encode the given password
        byte[] encodedPassword = Base64.getEncoder().encode(password.getBytes());
        byte[] storedPassword = Base64.getEncoder().encode(user.getPassword().getBytes());

        // Compare the encoded passwords
        if (new String(encodedPassword).equals(new String(storedPassword))) {
            return true;
        } else {
            return false;
        }
    }

    // A sample user object
    public class User {
        private String password;

        public java_22242_CredentialValidator_A07(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        User user = new User("password");
        CredentialValidator validator = new CredentialValidator(user);

        // Testing
        System.out.println(validator.validatePassword("password")); // Should print: true
        System.out.println(validator.validatePassword("wrongPassword")); // Should print: false
    }
}